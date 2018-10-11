package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;
@Entity
@Table(name = "dispositivos")
public abstract class Dispositivo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true,nullable = false)
    private int id;
	 @Column(name = "nombre",nullable = false)
	private String nombre;
	 @Column(name = "idFabrica",nullable = false)
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
	
	public abstract Double consumoPeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta);
				
}
