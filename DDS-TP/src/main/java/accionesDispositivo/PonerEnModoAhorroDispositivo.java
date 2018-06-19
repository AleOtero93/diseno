package accionesDispositivo;

import entidades.DispositivoInteligente;

public class PonerEnModoAhorroDispositivo implements AccionesSobreDispositivos {

	@Override
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.ponerEnModoAhorro();
	}

}
