package tests;

import org.junit.Test;

import entidades.Cliente;
import entidades.Administrador;
import entidades.Categoria;
import entidades.Dispositivo;
import entidades.TipoDocumento;

import org.junit.Before;

import java.util.Date;

import org.junit.Assert;

public class ClienteTest {
	
	Cliente cliente;
	Dispositivo disp;
	
	@Before
	public void BeforeMethod() {
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123", TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		disp = new Dispositivo("TestDisp",1234,1);
		cliente.agregarDisp(disp);
	}	
		
	@Test
	public void dispEncendido_Test(){		
		Assert.assertEquals(true, cliente.dispEncendido(disp));
	}
	
	@Test
	public void eliminarDisp_Test(){
		cliente.eliminarDisp(disp.getNombre());
		Assert.assertEquals(0,cliente.cantDisp());
	}
	
	@Test
	public void cantDisp_Test(){
		Assert.assertEquals(1,cliente.cantDisp());
	}
	
	@Test
	public void cantDispEnEstado_Test() {
		Assert.assertEquals(0,cliente.cantDispEnEstado(1));
	}	
	
}
