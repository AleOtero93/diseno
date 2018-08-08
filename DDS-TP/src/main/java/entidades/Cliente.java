package entidades;

import java.util.List;

import accionesDispositivo.AccionesSobreDispositivos;

import java.util.ArrayList;
import entidades.DispositivoInteligente;
import estadosDispositivos.EstadoDispositivo;

public class Cliente extends Usuario {

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
	
	public List<DispositivoInteligente> getDispositivos() {
		return dispositivosInteligentes;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivosInteligentes) {
		this.dispositivosInteligentes = dispositivosInteligentes;
		this.puntos += 15 * dispositivosInteligentes.size();
	}
	
	public List<DispositivoEstandar> getDispositivosEstandares() {
		return dispositivosEstandares;
	}

	public void setDispositivosEstandares(List<DispositivoEstandar> dispositivosEstandares) {
		this.dispositivosEstandares = dispositivosEstandares;
	}
	public void agregarDisp(DispositivoInteligente disp){
		dispositivosInteligentes.add(disp);
	}
	
	public void eliminarDisp(DispositivoInteligente disp){
		dispositivosInteligentes.remove(disp);
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

	


}
