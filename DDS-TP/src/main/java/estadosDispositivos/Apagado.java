package estadosDispositivos;

import org.joda.time.LocalDateTime;
import entidades.DispositivoInteligente;

public class Apagado implements EstadoDispositivo {
	
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	public Apagado(){
		LocalDateTime.now();
	}
	
	@Override
	public void setFechaFin(LocalDateTime fecha) {
		this.fechaFin = fecha;
	}

	@Override
	public double obtenerConsumo(DispositivoInteligente dispositivo) {
		return 0;
	}
	
	@Override
	public LocalDateTime getFechaInicio() {
		return this.fechaInicio;
	}
	
	@Override
    public LocalDateTime getFechaFin() {
    	return this.fechaFin;
    }
		
	@Override
	public void apagarDispositivo(DispositivoInteligente dispositivo) {
		
	}

	@Override
	public void encenderDispositivo(DispositivoInteligente dispositivo) {
		LocalDateTime.now();
		dispositivo.addEstado(new Encendido());
	}

	@Override
	public void ponerEnModoAhorro(DispositivoInteligente dispositivo) {
		LocalDateTime.now();
		dispositivo.addEstado(new ModoAhorro());
	}

	@Override
	public boolean estaEncendido() {
		return false;
	}

//	@Override
//	public Double consumoPeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta,
//			DispositivoInteligente dispositivo) {
//		
//		return 0.0;
//	}

}
