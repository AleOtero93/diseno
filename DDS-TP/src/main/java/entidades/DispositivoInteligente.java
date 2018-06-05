package entidades;

import java.util.Date;

public class DispositivoInteligente extends Dispositivo{
	private Integer estado;
	private Float consumo;
	private Float kwHoraAhorro;
	
	public DispositivoInteligente(String nom, Integer idFab) {
		super(nom,idFab,1);
		this.encender();
	}
	public DispositivoInteligente(Dispositivo disp) {
		super(disp.getNombre(),disp.getIdFabrica(),1);
		this.encender();
	}
	public DispositivoInteligente(DispositivoEstandar disp) {
		super(disp.getNombre(),disp.getIdFabrica(),1);
		this.encender();
	}
	
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public float getconsumo() {
		return consumo;
	}
	public void setconsumo(Float consumo) {
		this.consumo = consumo;
	}
	public float getkwHoraAhorro() {
		return kwHoraAhorro;
	}
	public void setkwHoraAhorro(Float kwHoraAhorro) {
		this.kwHoraAhorro = kwHoraAhorro;
	}	
	public void apagar() {
		this.estado = 0;
	}
	public void encender() {
		this.estado = 1;
	}
	public void ahorroEnergia() {
		this.estado = 2;
	}
	public boolean encendido(){
		return (this.estado == 1);
	}
	public boolean apagado(){
		return (this.estado == 0);
	}
	public float energiaConsumida(Integer horas){
		//Necesitamos Persistencia, por ahora devolvemos dummy
		float calcEnergia = 0;
		return calcEnergia;
	}
	public float consumoPeriodo(Date fechaInicio, Date fechaFin){
		//Necesitamos Persistencia, por ahora devolvemos dummy
		float calcConsumo = 0;
		return calcConsumo;
	}
}
