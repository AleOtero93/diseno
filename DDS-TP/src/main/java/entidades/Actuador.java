package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Actuador {
	private Integer regla;
	private String operacion;
	private AccionesSobreDispositivos operacionEnDispositivo;
	private List<DispositivoInteligente> dispositivos;
	
	public Actuador(Integer regla, String operacion, String operacionEnDispositivo){
		this.regla = regla;
		this.operacion = operacion;
		this.operacionEnDispositivo = operacionEnDispositivo;
		this.dispositivos = new ArrayList<DispositivoInteligente>();
		
	}
	
	public void agregarDisp(DispositivoInteligente disp){
		dispositivos.add(disp);
	}
	
	public void eliminarDisp(String nomDisp){
		for(int i=0;i<dispositivos.size();i++) {
			if(dispositivos.get(i).getNombre().equalsIgnoreCase(nomDisp)) {
				dispositivos.remove(i);
				break;
			}
		}
	}
	
	public List<DispositivoInteligente> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<DispositivoInteligente> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Integer getRegla() {
		return regla;
	}

	public void setRegla(Integer regla) {
		this.regla = regla;
	}
	
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	public String getOperacionEnDisp() {
		return operacionEnDispositivo;
	}

	public void setOperacionEnDisp(String operacion) {
		this.operacionEnDispositivo = operacion;
	}
	
	public void actualizar(Integer estado){
		String op = "(" + estado + " " + operacion + " " + regla + ")";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		boolean result;
		try {
			result = (boolean) engine.eval(op);
			if(result){
				for(DispositivoInteligente disp : dispositivos){
					operacionEnDispositivo.ejecutar();
				}
			}
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
