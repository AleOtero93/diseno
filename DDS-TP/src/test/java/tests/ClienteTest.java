package tests;

import org.junit.Test;

import entidades.Cliente;
import entidades.Categoria;
import entidades.Dispositivo;
import entidades.TipoDocumento;
import estadosDispositivos.Encendido;
import entidades.DispositivoInteligente;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Assert;

public class ClienteTest {
	
	Cliente cliente;
	DispositivoInteligente dispositivo;
	
	@Before
	public void BeforeMethod() {
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123", TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		dispositivo = new DispositivoInteligente ("heladera",1234,new Encendido(),15.0,10.0);
		cliente.agregarDisp(dispositivo);
	}	
		
	@Test
	public void testDispositivoEstaEncendido(){		
		Assert.assertEquals(true, dispositivo.estaEncendido());
	}
	
//	@Test
//	public void testEliminarDispositivo(){
//		cliente.eliminarDisp(dispositivo.getNombre());
//		Assert.assertEquals(0,cliente.cantDisp());
//	}
//	
	@Test
	public void testCantidadDeDispositivosInteligentesEncendidos(){
		Assert.assertSame(1, cliente.cantidadDeDispositivosEncendidos());
		}
	
//	@Test
//	public void testCantidadDeDispositovosEnEstadoEncendido() {
//		Assert.assertEquals(1,cliente.cantDispEnEstado(1));
//	}	
//	
}
