package entidades;

import java.util.List;

public class Transformador {
	private String nombre;
	private Integer id;
	private Float longitud;
	private Float latitud;
	private Zona zona;
	private List<Cliente> clientes;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getLongitud() {
		return longitud;
	}
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	public Float getLatitud() {
		return latitud;
	}
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void agregarUsuario(Cliente unCliente){
		clientes.add(unCliente);
	}
	
	public void actualizarClientes() {
		
	}
	
	public Double consumoTransformador() {
		return null;
	}
}
