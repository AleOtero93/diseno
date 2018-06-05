package entidades;

public class Dispositivo {
	
	private String nombre;
	private Float kwhora;
	private Integer idFabrica;
	private Integer tipo;//0-Estandar,1-Inteligente
	   
    public Dispositivo(String nom, Integer idFab, Integer tipo){
        this.nombre = nom;
        this.idFabrica = idFab;
        this.tipo = tipo;
    }
	
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
	public Integer getIdFabrica() {
		return idFabrica;
	}
	public void setIdFabrica(Integer idFabrica) {
		this.idFabrica = idFabrica;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}
