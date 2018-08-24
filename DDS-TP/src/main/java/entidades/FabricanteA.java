package entidades;

import org.joda.time.DateTime;

public class FabricanteA{
	
	public Integer nroSerie;
	public String Fabricante;
	public String nombreDispositivo;
	public Integer status; // 0-Apagado,1-Encendido,2-Ahorro

	public FabricanteA(){}
	
	public FabricanteA(Integer nSerie, String idFabr,String nomDisp) {
		this.nroSerie = nSerie;
		this.Fabricante = idFabr;
		this.nombreDispositivo = nomDisp;
		this.status = 1;
	}
	
	public void prender() {
		this.status = 1;
	}
	
	public void apagar() {
		this.status = 0;
	}
	
	
	public void ahorrar() {
		this.status = 2;
	}
	
	public Double consumoPeriodo(DateTime fechaDesde, DateTime fechaHasta) {
		return 15.0; //Dummy
	}
}
