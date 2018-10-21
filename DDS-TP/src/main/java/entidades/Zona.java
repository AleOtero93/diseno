package entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;

@Entity
@Table(name = "Zonas")
public class Zona {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nombre" )
	private String nombre;
	
	@Column(name = "centroLongitud")
	private Float longitud;
	
	@Column(name = "centroLatitud")
	private Float latitud;

	@Column(name = "radio")
	private Integer radio;
	
	@OneToMany(mappedBy = "zona", cascade= CascadeType.ALL)
	private List<Transformador> transformadores;
	
	public Zona() {}
	
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
	
	public double consumoTotal(LocalDateTime desde, LocalDateTime hasta) {
		Double consumoTotal = this.transformadores.stream()
				.mapToDouble(transformador -> transformador.energiaConsumida(desde, hasta)).sum();
		return consumoTotal;
	}
}
