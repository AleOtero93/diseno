package accionesDispositivo;

import entidades.DispositivoInteligente;

public class ApagarDispositivo implements AccionesSobreDispositivos {

	@Override
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.apagarDispositivo();
	}
}
