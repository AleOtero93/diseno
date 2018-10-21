package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "id", unique = true , nullable = false )
	private Long id; 
	
	@Column(name = "descripcion")
	private String nombre;
	
	private Integer consumoMensualMinimo;
	private Integer consumoMensualMaximo;
	
	@Column(name = "cargoFijo")
	private Float cargoFijo;
	
	@Column(name = "cargoVariable")
	private Float cargoVariable;
	
	
	public Categoria(String nom, int min, int max, Float cFij, Float cVar) {
		this.nombre = nom;
		this.consumoMensualMinimo = min;
		this.consumoMensualMaximo = max;
		this.cargoFijo = cFij;
		this.cargoVariable = cVar;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getConsumoMensualMinimo() {
		return consumoMensualMinimo;
	}
	public void setConsumoMensualMinimo(Integer consumoMensualMinimo) {
		this.consumoMensualMinimo = consumoMensualMinimo;
	}
	public Integer getConsumoMensualMaximo() {
		return consumoMensualMaximo;
	}
	public void setConsumoMensualMaximo(Integer consumoMensualMaximo) {
		this.consumoMensualMaximo = consumoMensualMaximo;
	}
	public Float getCargoFijo() {
		return cargoFijo;
	}
	public void setCargoFijo(Float cargoFijo) {
		this.cargoFijo = cargoFijo;
	}
	public Float getCargoVariable() {
		return cargoVariable;
	}
	public void setCargoVariable(Float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}
	
	
	
}
