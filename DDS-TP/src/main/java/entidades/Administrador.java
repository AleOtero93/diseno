package entidades;

import org.joda.time.DateTime;
import org.joda.time.Months;

public class Administrador extends Usuario {
	
	private String domicilio;
	private DateTime fechaAltaSistema;
	private Integer Id;

	public Administrador(String nombre, 
			String apellido, 
			String usuario, 
			String password,
			String domicilio,
			DateTime fechaAltaSistema,
			Integer Id) {
		super(nombre, apellido, usuario, password);
		
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

	public DateTime getFechaAltaSistema() {
		return fechaAltaSistema;
	}

	public void setFechaAltaSistema(DateTime fechaAltaSistema) {
		this.fechaAltaSistema = fechaAltaSistema;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	public long mesesEnSistema(){
    	return Months.monthsBetween(this.fechaAltaSistema, DateTime.now() ).getMonths();
    }

}
