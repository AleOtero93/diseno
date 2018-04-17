package entidades;

public class Categoria {

	private String nombre;
	private Integer consumoMensualMinimo;
	private Integer consumoMensualMaximo;
	private Float cargoFijo;
	private Float cargoVariable;
	
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
