package entidades;

import org.joda.time.LocalDateTime;

public class DispositivoEstandar extends Dispositivo{
	
	private Double consumoPorHora;
	private Integer horasEncendidoPorDia;
	
	public DispositivoEstandar(String nombre, Integer idFab, Double consumoPorHora, Integer horasEncendidoPorDia) {
		super(nombre,idFab);
		this.consumoPorHora = consumoPorHora;
		this.horasEncendidoPorDia = horasEncendidoPorDia;
	}

	public Double getConsumoPorHora() {
		return consumoPorHora;
	}
	public void setConsumoPorHora(Double consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	public Integer getHorasEncendidoPorDia() {
		return horasEncendidoPorDia;
	}

	public void setHorasEncendidoPorDia(Integer horasEncendidoPorDia) {
		this.horasEncendidoPorDia = horasEncendidoPorDia;
	}

	//Calcular el consumo del periodo del dispositivo Estandar
	
	@Override
	public Double consumoPeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public DispositivoInteligente ConvertirInteligente() {
//		DispositivoInteligente nuevoDispInteligente = new DispositivoInteligente(this);
//		return nuevoDispInteligente;
//	}
}
