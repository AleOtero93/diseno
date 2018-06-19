package estadosDispositivos;

import org.joda.time.LocalDateTime;

import entidades.DispositivoInteligente;

public class Apagado implements EstadoDispositivo {

	@Override
	public void apagarDispositivo(DispositivoInteligente dispositivo) {
		
	}

	@Override
	public void encenderDispositivo(DispositivoInteligente dispositivo) {

	}

	@Override
	public void ponerEnModoAhorro(DispositivoInteligente dispositivo) {
		
	}

	@Override
	public boolean estaEncendido() {
		return false;
	}

	@Override
	public Double consumoPeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta,
			DispositivoInteligente dispositivo) {
		
		return null;
	}

}
