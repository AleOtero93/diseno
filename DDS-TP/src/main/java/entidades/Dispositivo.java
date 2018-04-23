package entidades;

public class Dispositivo {

	private String nombre;
	private Float kwhora;
	private Boolean encendido;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getKwhora() {
		return kwhora;
	}
	public void setKwhora(Float kwhora) {
		this.kwhora = kwhora;
	}
	public Boolean getEncendido() {
		return encendido;
	}
	public void setEncendido(Boolean encendido) {
		this.encendido = encendido;
	}
	
}
