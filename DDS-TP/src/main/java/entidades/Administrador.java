package entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.joda.time.DateTime;
import org.joda.time.Months;

@Entity
@DiscriminatorValue(value="Administrador" )
public class Administrador extends Usuario {

	private static final long serialVersionUID = 1L;
	
	@Column (name="fechaAltaAdmin")
	private DateTime fechaAltaSistema;
	
	private Integer id;

	public Administrador(String nombre, 
			String apellido, 
			String usuario, 
			String password,
			DateTime fechaAltaSistema,
			Integer id) {
		super(nombre, apellido, usuario, password);
		
		this.fechaAltaSistema = fechaAltaSistema;
		this.id = id;
	}

	public DateTime getFechaAltaSistema() {
		return fechaAltaSistema;
	}

	public void setFechaAltaSistema(DateTime fechaAltaSistema) {
		this.fechaAltaSistema = fechaAltaSistema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public long mesesEnSistema(){
    	return Months.monthsBetween(this.fechaAltaSistema, DateTime.now() ).getMonths();
    }

}
