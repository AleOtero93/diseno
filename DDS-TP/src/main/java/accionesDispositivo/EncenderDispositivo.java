package accionesDispositivo;

import entidades.DispositivoInteligente;

public class EncenderDispositivo implements AccionesSobreDispositivos {

	@Override
	public void ejecutar(DispositivoInteligente dispositivo) {
		dispositivo.encenderDispositivo();
	}

}
