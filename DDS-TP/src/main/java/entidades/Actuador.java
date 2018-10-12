package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import accionesDispositivo.AccionesSobreDispositivos;

@Entity
@Table(name = "actuadores")

public class Actuador {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_regla",unique = true) 
	private Integer regla;
	 
	 @Column(name = "operacion",nullable = false) 
	private String operacion;
	private AccionesSobreDispositivos operacionEnDispositivo;
	private List<DispositivoInteligente> dispositivos;
	
	public Actuador(Integer regla, String operacion, AccionesSobreDispositivos operacionEnDispositivo){
		this.regla = regla;
		this.operacion = operacion;
		this.operacionEnDispositivo = operacionEnDispositivo;
		this.dispositivos = new ArrayList<DispositivoInteligente>();
		
	}
			
	public Actuador() {}

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
		
	public void setOperacionEnDisp(AccionesSobreDispositivos operacion) {
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
					operacionEnDispositivo.ejecutar(disp);
				}
			}
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
