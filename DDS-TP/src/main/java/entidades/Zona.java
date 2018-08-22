package entidades;

import java.util.List;

public class Zona {
	
	private String nombre;
	private Integer id;
	private Float longitud;
	private Float latitud;
	private Integer radio;
	
	private List<Transformador> transformadores;
	
	public Zona(String nombre, Integer id, List<Transformador> transformadores) {
		this.nombre = nombre;
		this.id=id;
		this.setTransformadores(transformadores);
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
	
	public Integer getRadio() {
		return radio;
	}
	
	public void setRadio(Integer radio) {
		this.radio = radio;
	}
	
	public Double consumoZona() {
		return null;
	}
	

	public List<Transformador> getTransformadores() {
		return transformadores;
	}

	public void setTransformadores(List<Transformador> transformadores) {
		this.transformadores = transformadores;
	}

	public void agregarTransformador (Transformador transformador) {
		transformadores.add(transformador);
	}
	
	public double consumoTotal() {
		Double consumoTotal = this.transformadores.stream()
				.mapToDouble(transformador -> transformador.energiaConsumida()).sum();
		return consumoTotal;
	}
}
