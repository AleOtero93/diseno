package entidades;

import java.util.List;

import accionesDispositivo.AccionesSobreDispositivos;

import java.util.ArrayList;
import java.util.Arrays;

import entidades.DispositivoInteligente;
import estadosDispositivos.EstadoDispositivo;
import simplex.SimplexAdapter;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.joda.time.LocalDateTime;

import utilidades.Simplex;

public class Cliente extends Usuario {
	private String domicilio;
	//Cambiar por Latitud y longitud en todos los tests.
	private Double domicilioLongitud;
	private Double domicilioLatitud;
	private Categoria categoria;
	private TipoDocumento tipoDocumento;
	private List<DispositivoInteligente> dispositivosInteligentes;
	private List<DispositivoEstandar> dispositivosEstandares;
	private Integer puntos = 0;
	private Integer nroDocumento;
	
	public Cliente(	String nombre, 
					String apellido, 
					String usuario, 
					String password, 
					String domicilio,
					Double longitud,
					Double latitud,
					TipoDocumento tipoDocumento,
					Integer nroDocumento,
					Categoria categoria) {
		super(nombre, apellido, usuario, password);
		
		this.categoria = categoria;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.domicilio = domicilio;
		this.domicilioLongitud = longitud;
		this.domicilioLatitud = latitud;
		this.dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
		this.dispositivosEstandares = new ArrayList<DispositivoEstandar>();
		
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public List<DispositivoInteligente> getDispositivos() {
		return dispositivosInteligentes;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivosInteligentes) {
		this.dispositivosInteligentes = dispositivosInteligentes;
		
	}
	
	public List<DispositivoEstandar> getDispositivosEstandares() {
		return dispositivosEstandares;
	}

//	public void setDispositivos(List<DispositivoEstandar> dispositivosEstandares) {
//		this.dispositivosEstandares = dispositivosEstandares;
//	}
	public void adaptarDispositivo(DispositivoEstandar dispEst, DispositivoInteligente dispInt) {
		eliminarDisp(dispEst);
		agregarDisp(dispInt);
		this.puntos -= 5;
	}
	public void agregarDisp(DispositivoInteligente disp){
		dispositivosInteligentes.add(disp);
		this.puntos += 15;
	}
	public void agregarDisp(DispositivoEstandar disp){
		dispositivosEstandares.add(disp);
	}
	
	public void eliminarDisp(DispositivoInteligente disp){
		dispositivosInteligentes.remove(disp);
	}
	public void eliminarDisp(DispositivoEstandar disp){
		dispositivosEstandares.remove(disp);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getDomicilioLongitud() {
		return domicilioLongitud;
	}

	public void setDomicilioLongitud(Double domicilioLongitud) {
		this.domicilioLongitud = domicilioLongitud;
	}

	public Double getDomicilioLatitud() {
		return domicilioLatitud;
	}

	public void setDomicilioLatitud(Double domicilioLatitud) {
		this.domicilioLatitud = domicilioLatitud;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	
	public Integer getPuntos() {
		return puntos;
	}
	
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
			
	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	
	public Integer cantidadDeDispositivosEncendidos() {
        Long cantidadDeEncendidos = dispositivosInteligentes.stream().filter(disp -> disp.estaEncendido()).count();
        return cantidadDeEncendidos.intValue();
    }

	public void ejecutarAccionSobreDispositivo(AccionesSobreDispositivos accion, DispositivoInteligente dispositivo) {
        accion.ejecutar(dispositivo);
    }
	
	public Integer cantidadTotalDeDispositivos() {
        return this.dispositivosInteligentes.size() + dispositivosEstandares.size();
    }
	
	public PointValuePair hogarEficiente() {
		//Creo la variable a devolver y la lista de dispositivos a enviar
		PointValuePair solucion = null;
		List<DispositivoInteligente> dispositivosRegulables = new ArrayList<DispositivoInteligente>();
		Simplex simplex;
		
		//Solo agrego a la lista los dispositivos que tienen seteado un usoMinimo y usoMaximo
		 //(heladeras, por ej., no tendran
		for (int i=0;i<dispositivosInteligentes.size();i++) {
			if(dispositivosInteligentes.get(i).getUsoMinimo() > 0 &&
					dispositivosInteligentes.get(i).getUsoMaximo() > 0 &&
					dispositivosInteligentes.get(i).getUsoMaximo() > dispositivosInteligentes.get(i).getUsoMinimo()) {
				dispositivosRegulables.add(dispositivosInteligentes.get(i));
			}
		}
		
		//Si hay algun dispositivo en esa lista, creo el simplex y obtengo la solucion
		if(dispositivosRegulables.size() > 0) {
			//Creo las listas que se iran enviando al simplex: un array con un 1.00 por dispositivo,
				//un array con el consumo de los dispositivos y un array que vaya cambiando todos sus valores a 0.00
				//menos el del dispositivo evaluando (que sera maximizado en esa iteracion).
			double[] cantDispositivos = new double[dispositivosRegulables.size()];
			double[] consumoDispositivos = new double[dispositivosRegulables.size()];
			double[] dispositivoFill = new double[dispositivosRegulables.size()];
			
			//Obtengo el consumo de los dispositivos.
			for (int i=0;i<dispositivosRegulables.size();i++) {
			    cantDispositivos[i] = 1;
			    consumoDispositivos[i] = dispositivosRegulables.get(i).getConsumoPorHora();
			}
			
			//ACA IRIA EL TIPO DE SIMPLEX, POR EJ.
			/*if(tipo == 1){
				simplex = new SimplexAdapter(GoalType.MAXIMIZE, true);
			} else if(tipo == 2){
				simplex = new SimplexAdapterAPI(GoalType.MAXIMIZE, true);
			}*/
			simplex = new SimplexAdapter(GoalType.MAXIMIZE);
			simplex.funcionEconomica(cantDispositivos);
			
			//Restriccion de maximo consumo mensual.
			simplex.restriccion(Relationship.LEQ, 440640, consumoDispositivos);
			
			//Utilizo los maximos y minimos de los dispositivos para las restricciones.
			int usoMaximo = 0;
			int usoMinimo = 0;
			for (int i=0;i<dispositivosRegulables.size();i++) {
				Arrays.fill(dispositivoFill, 0);
				dispositivoFill[i] = 1;
				usoMaximo = dispositivosRegulables.get(i).getUsoMaximo();
				usoMinimo = dispositivosRegulables.get(i).getUsoMinimo();
				simplex.restriccion(Relationship.GEQ, usoMinimo, dispositivoFill);
				simplex.restriccion(Relationship.LEQ, usoMaximo, dispositivoFill);
			}
			
			simplex.resolver();
			solucion = simplex.getSolucion();
		}
		
		//Devuelvo null si no hubo dispositivos o el resultado si los hubo
		return solucion;
	}

	public double consumoEnergia() {
		
		LocalDateTime desde = LocalDateTime.now().minusDays(LocalDateTime.now().getDayOfMonth() - 1).withMillisOfDay(0);

		List<Dispositivo> todosLosDispositivos = new ArrayList<Dispositivo>(this.dispositivosInteligentes);
		todosLosDispositivos.addAll(this.dispositivosEstandares);

		return todosLosDispositivos.stream().mapToDouble(disp -> disp.consumoPeriodo(desde, LocalDateTime.now())).sum();
	}
	
	public double consumoEnergia(LocalDateTime desde, LocalDateTime hasta) {
		List<Dispositivo> todosLosDispositivos = new ArrayList<Dispositivo>(this.dispositivosInteligentes);
		todosLosDispositivos.addAll(this.dispositivosEstandares);

		return todosLosDispositivos.stream().mapToDouble(disp -> disp.consumoPeriodo(desde, hasta)).sum();
	}

	//Calcula distancia entre dos puntos
	public Float distancia (Float longitudA, Float longitudB, Float latitudA, Float latitudB) {
		return (float) Math.sqrt(Math.pow(longitudB-longitudA,2)+Math.pow(latitudB-latitudA,2));
	}
	
	//Busca transformador mas cercano
	public void buscarTransformadorCercano(List<Transformador> transformadores) {
		
	}

}
