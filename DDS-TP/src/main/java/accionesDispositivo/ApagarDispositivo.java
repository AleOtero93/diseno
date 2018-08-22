package accionesDispositivo;

import org.joda.time.LocalDateTime;

import entidades.DispositivoInteligente;
import estadosDispositivos.Apagado;

public class ApagarDispositivo implements AccionesSobreDispositivos {

	@Override
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.addEstado(new Apagado());
		dispositivo.ultimoEstado().setFechaFin(LocalDateTime.now());
	}
}
