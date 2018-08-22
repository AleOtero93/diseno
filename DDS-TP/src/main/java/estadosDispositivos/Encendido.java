package estadosDispositivos;

import org.joda.time.LocalDateTime.*;
import org.joda.time.*;
import static org.joda.time.LocalDateTime.*;
import entidades.DispositivoInteligente;

public class Encendido implements EstadoDispositivo {

	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	public Encendido(){
		fechaInicio = now();
	}
	
	public Encendido(LocalDateTime fechaInicio, LocalDateTime fechaFin){
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	@Override
	public double obtenerConsumo(DispositivoInteligente dispositivo) {
		return dispositivo.getConsumoPorHora();
	}
	
	@Override
	public void apagarDispositivo(DispositivoInteligente dispositivo) {
		fechaFin = now();
        dispositivo.addEstado(new Apagado());
	}

	@Override
	public void encenderDispositivo(DispositivoInteligente dispositivo) {
		
	}

	@Override
	public void ponerEnModoAhorro(DispositivoInteligente dispositivo) {
		fechaFin = now();
        dispositivo.addEstado(new ModoAhorro());
	}

	@Override
	public boolean estaEncendido() {
		return true;
	}

	@Override
	public Double consumoPeriodo(LocalDateTime desde, LocalDateTime hasta, DispositivoInteligente dispositivo) {
		
		Interval intervaloDeConsumo = new Interval(desde.toDateTime(), hasta.toDateTime());
        Interval intervaloDeEstado = new Interval(fechaInicio.toDateTime(), fechaFin.toDateTime());

        if (intervaloDeConsumo.overlaps(intervaloDeEstado)) {
            Interval intervaloConsumido = intervaloDeEstado.overlap(intervaloDeConsumo);

            return dispositivo.getConsumoPorHora() * Hours.hoursBetween(intervaloConsumido.getStart(), intervaloConsumido.getEnd()).getHours();

        } else {
            return 0.0;
        }
    }

}
