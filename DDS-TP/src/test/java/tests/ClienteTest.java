package tests;

import org.junit.Test;

import entidades.Cliente;
import entidades.Categoria;
import entidades.Dispositivo;
import entidades.DispositivoEstandar;
import entidades.TipoDocumento;
import estadosDispositivos.Apagado;
import estadosDispositivos.Encendido;
import entidades.DispositivoInteligente;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class ClienteTest {
	
	Cliente cliente;
	DispositivoInteligente heladera;
	DispositivoInteligente celular;
	DispositivoEstandar lampara;
	
	List<DispositivoInteligente> dispositivosCliente = new ArrayList<>();
	
	
	@Before
	public void BeforeMethod() {
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123","villa crespo",TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		heladera = new DispositivoInteligente ("heladera",1234,new Encendido(),85.0,10.0,0,0);
		celular = new DispositivoInteligente("celular", 1111, new Apagado(), 25.0, 5.0,0,0);
		lampara = new DispositivoEstandar("lampara", 4567, 15.0, 8);
		cliente.setDispositivos(dispositivosCliente);
		cliente.agregarDisp(heladera);
		cliente.agregarDisp(celular);
					
	}	
		
	@Test
	public void testDispositivoEstaEncendido(){		
		Assert.assertEquals(true, heladera.estaEncendido());
	}
	
	@Test
	public void testEliminarDispositivo(){
		cliente.eliminarDisp(celular);
		Assert.assertThat(1, is(cliente.cantidadTotalDeDispositivos()));
	}
	
	@Test
	public void testCantidadDeDispositivosInteligentesEncendidos(){
		Assert.assertThat(1, is (cliente.cantidadDeDispositivosEncendidos()));
		}
		
	@Test
    public void testPuntosClienteConDispositivosInteligentes() {
    	Assert.assertThat(30, is (cliente.getPuntos()));
    }
	
	
}
