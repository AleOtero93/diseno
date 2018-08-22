package accionesDispositivo;

import org.joda.time.LocalDateTime;

import entidades.DispositivoInteligente;
import estadosDispositivos.Encendido;

public class EncenderDispositivo implements AccionesSobreDispositivos {

	@Override
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.addEstado(new Encendido());
		dispositivo.ultimoEstado().setFechaFin(LocalDateTime.now());
	}

}
