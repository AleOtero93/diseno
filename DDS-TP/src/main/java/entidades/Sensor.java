package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sensores")
public class Sensor {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "medicion")
	private Integer medicion;
	
	@OneToMany(
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
	@JoinColumn(name = "sensor_id")
	private List<Actuador> actuadores;
	
	//Constructor vacío para que funcione
	public Sensor(){
	}
	
	public Sensor(Integer medicion){
		this.medicion = medicion;
		this.actuadores = new ArrayList<Actuador>();
	}
	
	public void agregarAct(Actuador act){
		actuadores.add(act);
	}
	
	public void eliminarAct(Actuador act){
		if(actuadores.contains(act)){
			actuadores.remove(act);
		}
	}
	
	public List<Actuador> getActuadores() {
		return actuadores;
	}

	public void setActuadores(List<Actuador> actuadores) {
		this.actuadores = actuadores;
	}

	public Integer getMedicion() {
		return medicion;
	}

	public void setMedicion(Integer medicion) {
		this.medicion = medicion;
	}
	
	public void actualizar(){
		for(Actuador act : actuadores){
			act.actualizar(medicion);
		}
	}
	
}
