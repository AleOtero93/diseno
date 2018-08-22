package entidades;

import java.util.List;

public class Transformador {

	private String nombre;
	private Integer id;
	private Float longitud;
	private Float latitud;
	private List<Cliente> residentes;
	
	public Transformador(String nombre, Integer id, List<Cliente> residentes) {
		this.nombre=nombre;
		this.id=id;
		this.residentes=residentes;
		}
	
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
	
	public List<Cliente> getResidentes() {
		return residentes;
	}
	public void setResidentes(List<Cliente> residentes) {
		this.residentes = residentes;
	}
	
	public void agregarResidente(Cliente residente){
		residentes.add(residente);
	}
	
		
	public Double consumoTransformador() {
		return null;
	}
	
}
