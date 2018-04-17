package entidades;

import java.util.Date;

public class Administrador extends Usuario {
	
	private String domicilio;
	private Date fechaAltaSistema;
	private Integer Id;

	public Administrador(String nombre, 
			String apellido, 
			String usuario, 
			String password,
			String domicilio,
			Date fechaAltaSistema,
			Integer Id) {
		super(nombre, apellido, usuario, password);
		// TODO Auto-generated constructor stub
		
		this.domicilio = domicilio;
		this.fechaAltaSistema = fechaAltaSistema;
		this.Id = Id;
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaAltaSistema() {
		return fechaAltaSistema;
	}

	public void setFechaAltaSistema(Date fechaAltaSistema) {
		this.fechaAltaSistema = fechaAltaSistema;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
}
