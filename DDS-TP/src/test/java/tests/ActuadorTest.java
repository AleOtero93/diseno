package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Actuador;
import entidades.DispositivoInteligente;
import entidades.Sensor;

public class ActuadorTest {

	DispositivoInteligente dispositivo;
	Actuador actuador;
	Sensor sensor;
	
	@Before
	public void BeforeMethod() {
		dispositivo = new DispositivoInteligente("Aire Acondicionado",114);
		actuador = new Actuador(18,"<","encender");
		sensor = new Sensor(20);
		
	}	
	
	@Test
	public void testActualizarEstadoDeDispositvo() {
		dispositivo.apagar();
		actuador.agregarDisp(dispositivo);
		sensor.agregarAct(actuador);
		sensor.setEstado(17);
		sensor.actualizar();
		Assert.assertEquals(true,dispositivo.getEstado()==1);
	}
	
}
