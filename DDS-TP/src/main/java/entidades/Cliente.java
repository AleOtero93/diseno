package entidades;

import java.util.List;
import java.util.ArrayList;


public class Cliente extends Usuario {

	private Categoria categoria;
	private TipoDocumento tipoDocumento;
	private List<Dispositivo> dispositivos;
	private Integer puntos;
	private Integer nroDocumento;
	
	public Cliente(String nombre, 
			String apellido, 
			String usuario, 
			String password, 
			TipoDocumento tipoDocumento,
			Integer nroDocumento,
			Categoria categoria) {
		super(nombre, apellido, usuario, password);
		// TODO Auto-generated constructor stub

		this.categoria = categoria;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.dispositivos = new ArrayList<Dispositivo>();
		this.puntos = 0;
	}

	public boolean dispEncendido(Dispositivo dispositivo) {
		if(dispositivo.getTipo() == 1){//Si es Inteligente
			String nombre = dispositivo.getNombre();
	
			for(Dispositivo disp : dispositivos) {
				if(disp.getNombre().equals(nombre)) {
					return ((DispositivoInteligente)dispositivo).encendido();
					
				}
			}
		}
		return false;
	}
	
	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
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
	
	public void agregarDisp(Dispositivo disp){
		dispositivos.add(disp);
	}
	
	public void eliminarDisp(String nomDisp){
		for(int i=0;i<dispositivos.size();i++) {
			if(dispositivos.get(i).getNombre().equalsIgnoreCase(nomDisp)) {
				dispositivos.remove(i);
				break;
			}
		}
	}
	
	public int cantDisp(){
		return dispositivos.size();
	}
	
	public int cantDispEnEstado(Integer estado) {
		int cont = 0;
		for(Dispositivo disp : dispositivos) {
			if(disp.getTipo() == 1 && ((DispositivoInteligente)disp).getEstado() == estado) {
				cont++;				
			}
		}
		return cont;
	}
	
	public void convertirDisp(Dispositivo disp) {
		this.puntos += 10;
		((DispositivoEstandar)disp).ConvertirInteligente();
		disp = null;
	}
	
	public void registrarDisp(Dispositivo disp) {
		this.agregarDisp(disp);
		this.puntos += 15;
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	
	
}
