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
	private Integer puntos;
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
		this.puntos = 0;
	}
	
	public List<DispositivoInteligente> getDispositivos() {
		return dispositivosInteligentes;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivosInteligentes = dispositivos;
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
	
//	public boolean dispEncendido(Dispositivo dispositivo) {
//		if(dispositivo.getTipo() == 1){//Si es Inteligente
//			String nombre = dispositivo.getNombre();
//	
//			for(Dispositivo disp : dispositivos) {
//				if(disp.getNombre().equals(nombre)) {
//					return ((DispositivoInteligente)dispositivo).encendido();
//					
//				}
//			}
//		}
//		return false;
//	}
	
	
//	public void eliminarDisp(String nomDisp){
//		for(int i=0;i<dispositivos.size();i++) {
//			if(dispositivos.get(i).getNombre().equalsIgnoreCase(nomDisp)) {
//				dispositivos.remove(i);
//				break;
//			}
//		}
//	}
//	
//	public int cantDisp(){
//		return dispositivos.size();
//	}
//	
//	public int cantDispEnEstado(Integer estado) {
//		int cont = 0;
//		for(Dispositivo disp : dispositivos) {
//			if(disp.getTipo() == 1 && ((DispositivoInteligente)disp).getEstado() == estado) {
//				cont++;				
//			}
//		}
//		return cont;
//	}
	
//	public void convertirDisp(Dispositivo disp) {
//		this.puntos += 10;
//		((DispositivoEstandar)disp).ConvertirInteligente();
//		disp = null;
//	}
//	
//	public void registrarDisp(Dispositivo disp) {
//		this.agregarDisp(disp);
//		this.puntos += 15;
//	}

	
	
	
}
