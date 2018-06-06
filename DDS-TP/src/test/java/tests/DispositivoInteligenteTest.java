package tests;
import org.junit.Before;
import org.junit.Test;

import entidades.Dispositivo;
import entidades.DispositivoInteligente;
import org.junit.Assert;

public class DispositivoInteligenteTest {
	
	private DispositivoInteligente heladera;
	private DispositivoInteligente telefono;
			
	@Before
    public void initialize() {
		 
		 heladera = new DispositivoInteligente(new Dispositivo("heladera",20,1));
		 telefono = new DispositivoInteligente(new Dispositivo("telefono",21,1));
	 	 
	}
		
	@Test
    public void testEstadoEncendido(){
				Assert.assertEquals(true, heladera.encendido());
				Assert.assertEquals(true, telefono.encendido());
	}	
	
	@Test
    public void testEstadoAhorroDeEnergia(){
		  heladera.ahorroEnergia();
		  		Assert.assertEquals(true, heladera.getEstado()==2);
		  		Assert.assertEquals(false, telefono.getEstado()==2);
	}	
		
	@Test
    public void testCambiarEstado(){
		        heladera.apagar();
				Assert.assertEquals(true, heladera.apagado());
				Assert.assertEquals(false, telefono.apagado());
				
	}	
}
