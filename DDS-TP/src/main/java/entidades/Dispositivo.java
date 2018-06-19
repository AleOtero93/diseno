package entidades;

import org.joda.time.DateTime;

public abstract class Dispositivo {
	
	private String nombre;
	private Integer idFabrica;
	   
    public Dispositivo(String nombre, Integer idFab){
        this.nombre = nombre;
        this.idFabrica = idFab;
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdFabrica() {
		return idFabrica;
	}
	public void setIdFabrica(Integer idFabrica) {
		this.idFabrica = idFabrica;
	}
	
	public abstract Double consumoPeriodo(DateTime fechaDesde, DateTime fechaHasta);
				
}
