package entidades;

import java.util.List;

import accionesDispositivo.AccionesSobreDispositivos;

import java.util.ArrayList;
import entidades.DispositivoInteligente;
import estadosDispositivos.EstadoDispositivo;

public class Cliente extends Usuario {

	private String domicilio;
	//Cambiar por Latitud y longitud en todos los tests.
	private Float domicilioLongitud;
	private Float domicilioLatitud;
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
					TipoDocumento tipoDocumento,
					Integer nroDocumento,
					Categoria categoria) {
		super(nombre, apellido, usuario, password);
		
		this.categoria = categoria;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.domicilio = domicilio;
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

	public Float getDomicilioLongitud() {
		return domicilioLongitud;
	}

	public void setDomicilioLongitud(Float domicilioLongitud) {
		this.domicilioLongitud = domicilioLongitud;
	}

	public Float getDomicilioLatitud() {
		return domicilioLatitud;
	}

	public void setDomicilioLatitud(Float domicilioLatitud) {
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

//	public Object consumoEnergia() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	


}
