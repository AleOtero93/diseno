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
	
	Cliente cli;
	Dispositivo disp;
	
	@Before
	public void BeforeMethod() {
		cli = new Cliente("TestNom", 
						"TestApe", 
						"TestUsu", 
						"TestPas", 
						TipoDocumento.DNI,
						new Categoria("TestCat",1,2,1f,2f));
		disp = new Dispositivo("TestDisp",1234,1);
		cli.agregarDisp(disp);
	}	
		
	@Test
	public void dispEncendido_Test(){		
		Assert.assertEquals(true, cli.dispEncendido(disp));
	}
	
	@Test
	public void eliminarDisp_Test(){
		cli.eliminarDisp(disp.getNombre());
		Assert.assertEquals(0,cli.cantDisp());
	}
	
	@Test
	public void cantDisp_Test(){
		Assert.assertEquals(1,cli.cantDisp());
	}
	
	@Test
	public void cantDispEnEstado_Test() {
		Assert.assertEquals(0,cli.cantDispEnEstado(1));
	}	
	
}
