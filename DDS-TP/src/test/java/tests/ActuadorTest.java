package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import accionesDispositivo.AccionesSobreDispositivos;
import accionesDispositivo.ApagarDispositivo;
import accionesDispositivo.EncenderDispositivo;
import entidades.Actuador;
import entidades.DispositivoInteligente;
import entidades.Sensor;
import estadosDispositivos.Apagado;
import estadosDispositivos.Encendido;

public class ActuadorTest {

	DispositivoInteligente aireAcondicionado;
	Actuador actuador;
	Sensor sensor;
	AccionesSobreDispositivos encender;
	AccionesSobreDispositivos apagar;
	List<Actuador> actuadores = new ArrayList<>();
	List<DispositivoInteligente> dispositivosCliente = new ArrayList<>();
		
	@Before
	public void initialize(){
		aireAcondicionado = new DispositivoInteligente("aire acondicionado", 111111, new Apagado(), 10.0 , 5.0);
		apagar = new ApagarDispositivo();
		encender = new EncenderDispositivo();
		sensor = new Sensor(20);
		actuador = new Actuador(18, "<", encender);
	}
		
	@Test
	public void testActualizarEstadoDispositivo(){
		actuador.agregarDisp(aireAcondicionado);
		sensor.agregarAct(actuador);
		sensor.setMedicion(17);
		sensor.actualizar();
		Assert.assertEquals(true,aireAcondicionado.estaEncendido());
	
	}
	
	
//	@Before
//	public void BeforeMethod() {
//		dispositivo = new DispositivoInteligente("Aire Acondicionado",114);
//		actuador = new Actuador(18,"<","encender");
//		sensor = new Sensor(20);
//		
//	}	
//	
//	@Test
//	public void testActualizarEstadoDeDispositvo() {
//		dispositivo.apagar();
//		actuador.agregarDisp(dispositivo);
//		sensor.agregarAct(actuador);
//		sensor.setEstado(17);
//		sensor.actualizar();
//		Assert.assertEquals(true,dispositivo.getEstado()==1);
//	}
//	
}
