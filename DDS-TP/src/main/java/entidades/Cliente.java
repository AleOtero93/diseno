package entidades;

import java.util.List;
import java.util.ArrayList;


public class Cliente extends Usuario {

	private Categoria categoria;
	private TipoDocumento tipoDocumento;
	private List<Dispositivo> dispositivos;
	
	public Cliente(String nombre, 
			String apellido, 
			String usuario, 
			String password){
		super(nombre, apellido, usuario, password);
	}

	public Cliente(String nombre, 
			String apellido, 
			String usuario, 
			String password, 
			TipoDocumento tipoDocumento,
			Categoria categoria) {
		super(nombre, apellido, usuario, password);
		// TODO Auto-generated constructor stub

		this.categoria = categoria;
		this.tipoDocumento = tipoDocumento;
		this.dispositivos = new ArrayList<Dispositivo>();
		
	}

	public boolean dispEncendido(Dispositivo dispositivo) {
		String nombre = dispositivo.getNombre();

		for(Dispositivo disp : dispositivos) {
			if(disp.getNombre().equals(nombre)) {
				return dispositivo.getEncendido();
				
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
	
	public int cantDispEnEstado(Boolean estado) {
		int cont = 0;
		for(Dispositivo disp : dispositivos) {
			if(disp.getEncendido() == estado) {
				cont++;				
			}
		}
		return cont;
	}
	
	
}
