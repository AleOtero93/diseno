package accionesDispositivo;

import org.joda.time.LocalDateTime;

import entidades.DispositivoInteligente;
import estadosDispositivos.ModoAhorro;

public class PonerEnModoAhorroDispositivo implements AccionesSobreDispositivos {

	@Override
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.addEstado(new ModoAhorro());
		dispositivo.ultimoEstado().setFechaFin(LocalDateTime.now());
	}

}
