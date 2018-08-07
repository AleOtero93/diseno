package tests;
import org.junit.Before;
import org.junit.Test;

import accionesDispositivo.AccionesSobreDispositivos;
import accionesDispositivo.ApagarDispositivo;
import accionesDispositivo.EncenderDispositivo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.Dispositivo;
import entidades.DispositivoInteligente;
import entidades.TipoDocumento;
import estadosDispositivos.*;
import org.junit.Assert;

public class DispositivoInteligenteTest {
	
	DispositivoInteligente heladera;
	Cliente cliente;
	AccionesSobreDispositivos apagar;
	AccionesSobreDispositivos encender;
			
	@Before
    public void initialize() {
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123", TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		heladera = new DispositivoInteligente("heladera", 1234, new Apagado(), 15.0, 10.0);
		apagar = new ApagarDispositivo();
		encender = new EncenderDispositivo();
	}
		
	@Test
    public void testEstadoEncendido(){
		Assert.assertEquals(false, heladera.estaEncendido());
	
	}	
	
	@Test
	public void testEjecutarAccion(){
		Assert.assertFalse(heladera.estaEncendido());
		cliente.ejecutarAccionSobreDispositivo(encender, heladera);
		Assert.assertTrue(heladera.estaEncendido());
	}

	
	
}
