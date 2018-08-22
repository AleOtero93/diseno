package entidades;

import org.joda.time.DateTime;
import org.joda.time.Months;

public class Administrador extends Usuario {
	private DateTime fechaAltaSistema;
	private Integer Id;

	public Administrador(String nombre, 
			String apellido, 
			String usuario, 
			String password,
			DateTime fechaAltaSistema,
			Integer Id) {
		super(nombre, apellido, usuario, password);
		
		this.fechaAltaSistema = fechaAltaSistema;
		this.Id = Id;
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
