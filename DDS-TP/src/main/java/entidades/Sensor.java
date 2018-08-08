package entidades;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
	private Integer medicion;
	private List<Actuador> actuadores;
	
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
