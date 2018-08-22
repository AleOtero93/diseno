package entidades;

import java.util.List;

import accionesDispositivo.AccionesSobreDispositivos;

import java.util.ArrayList;
import entidades.DispositivoInteligente;
import estadosDispositivos.EstadoDispositivo;

public class Cliente extends Usuario {
	
	
	private Float domicilioLongitud;
	private Float domicilioLatitus;

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
					TipoDocumento tipoDocumento,
					Integer nroDocumento,
					Categoria categoria) {
		super(nombre, apellido, usuario, password);
		
		this.categoria = categoria;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
		this.dispositivosEstandares = new ArrayList<DispositivoEstandar>();
		
	}

	public Float getDomicilioLongitud() {
		return domicilioLongitud;
	}
	public void setDomicilioLongitud(Float domicilioLongitud) {
		this.domicilioLongitud = domicilioLongitud;
	}
	public Float getDomicilioLatitus() {
		return domicilioLatitus;
	}
	public void setDomicilioLatitus(Float domicilioLatitus) {
		this.domicilioLatitus = domicilioLatitus;
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

	//Calcula distancia entre dos puntos
	public Float distancia (Float longitudA, Float longitudB, Float latitudA, Float latitudB) {
		return (float) Math.sqrt(Math.pow(longitudB-longitudA,2)+Math.pow(latitudB-latitudA,2));
	
	}
	
	//Busca transformador mas cercano
	public void buscarTransformadorCercano(List<Transformador> transformadores) {
		
	}

}
