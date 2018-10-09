package entidades;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

public class Transformador {
	private String nombre;
	private Integer id;
	private Float longitud;
	private Float latitud;
	private List<Cliente> residentes = new ArrayList<Cliente>();
	
	public Transformador(String nombre, Integer id, List<Cliente> residentes) {
		this.nombre=nombre;
		this.id=id;
		this.residentes=residentes;
		}
	private Zona zona;
	private List<Cliente> clientes;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getLongitud() {
		return longitud;
	}
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	public Float getLatitud() {
		return latitud;
	}
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	
	public List<Cliente> getResidentes() {
		return residentes;
	}
	public void setResidentes(List<Cliente> residentes) {
		this.residentes = residentes;
	}
	
	public void agregarResidente(Cliente residente){
		residentes.add(residente);
	}
		
	public Double consumoTransformador() {
		return null;
	}

	public double energiaConsumida(LocalDateTime desde, LocalDateTime hasta) {
		Double consumoTotal = 0.00;
		for (int i=0;i<residentes.size();i++) {
			consumoTotal += residentes.get(i).consumoEnergia(desde, hasta);
		}
		return consumoTotal;
	}
	
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void agregarUsuario(Cliente unCliente){
		clientes.add(unCliente);
	}
	
	public void actualizarClientes() {
		
	}
}
