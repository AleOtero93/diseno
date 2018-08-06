package estadosDispositivos;

import org.joda.time.LocalDateTime.*;
import entidades.DispositivoInteligente;
import static org.joda.time.LocalDateTime.*;

import java.util.Optional;

import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import entidades.DispositivoInteligente;


public class ModoAhorro implements EstadoDispositivo {
	
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	public ModoAhorro(){
		fechaInicio = now();
	}

	public ModoAhorro(LocalDateTime fechaInicio, LocalDateTime fechaFin){
		
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	@Override
	public void apagarDispositivo(DispositivoInteligente dispositivo) {
		fechaFin = LocalDateTime.now();
		dispositivo.addEstado(new Apagado());
		
	}

	@Override
	public void encenderDispositivo(DispositivoInteligente dispositivo) {
		fechaFin = LocalDateTime.now();
		dispositivo.addEstado(new Encendido());
		
	}

	@Override
	public void ponerEnModoAhorro(DispositivoInteligente dispositivo) {
		
	}

	@Override
	public boolean estaEncendido() {
		return true;
	}

	@Override
	public Double consumoPeriodo(LocalDateTime desde, LocalDateTime hasta, DispositivoInteligente dispositivo) {
	
		Interval intervaloDeConsumo = new Interval(desde.toDateTime(), hasta.toDateTime());
        Interval intervaloDeEstado = new Interval(fechaInicio.toDateTime(),fechaFin.toDateTime());

        if (intervaloDeConsumo.overlaps(intervaloDeEstado)) {
            Interval intervaloConsumido = intervaloDeConsumo.overlap(intervaloDeEstado);

            return dispositivo.getConsumoPorHoraEnAhorro() * Hours.hoursBetween(intervaloConsumido.getStart(), intervaloConsumido.getEnd()).getHours();

        } else {
            return 0.0;
        }

    }
		
}
