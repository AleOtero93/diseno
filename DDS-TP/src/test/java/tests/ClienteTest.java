package tests;

import org.junit.Test;

import entidades.Cliente;
import entidades.Categoria;
import entidades.Dispositivo;
import entidades.TipoDocumento;
import entidades.DispositivoInteligente;

import org.junit.Before;

import org.junit.Assert;

public class ClienteTest {
	
	Cliente cliente;
	Dispositivo dispositivo;
	
	@Before
	public void BeforeMethod() {
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123", TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		dispositivo = new DispositivoInteligente (new Dispositivo("TestDisp",1234,1));
		cliente.agregarDisp(dispositivo);
	}	
		
	@Test
	public void testDispositivoEstaEncendido(){		
		Assert.assertEquals(true, cliente.dispEncendido(dispositivo));
	}
	
	@Test
	public void testEliminarDispositivo(){
		cliente.eliminarDisp(dispositivo.getNombre());
		Assert.assertEquals(0,cliente.cantDisp());
	}
	
	@Test
	public void testCantidadDeDispositivos(){
		Assert.assertEquals(1,cliente.cantDisp());
	}
	
	@Test
	public void testCantidadDeDispositovosEnEstadoEncendido() {
		Assert.assertEquals(1,cliente.cantDispEnEstado(1));
	}	
	
}
