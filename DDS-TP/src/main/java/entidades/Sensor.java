package entidades;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
	private Integer estado;
	private List<Actuador> actuadores;
	
	public Sensor(Integer estado){
		this.estado = estado;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
//	public void actualizar(){
//		for(Actuador act : actuadores){
//			act.actualizar(estado);
//		}
//	}
	
}
