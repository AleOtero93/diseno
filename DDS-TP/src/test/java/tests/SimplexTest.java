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
import utilidades.Simplex;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class SimplexTest {
	
	Cliente cliente;
	DispositivoInteligente televisor;
	DispositivoInteligente lavaropas;
	DispositivoInteligente ventilador;
	DispositivoEstandar lampara;
	
	List<DispositivoInteligente> dispositivosCliente = new ArrayList<>();
	
	
	@Before
	public void BeforeMethod() {
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123", TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		televisor = new DispositivoInteligente ("televisor",1234,new Encendido(),0.18,0.08,90,360);
		lavaropas = new DispositivoInteligente("lavaropas", 1111, new Encendido(), 0.875, 0.875,6,30);
		ventilador = new DispositivoInteligente("ventilador", 1111, new Encendido(), 0.06, 0.06,120,360);
		cliente.setDispositivos(dispositivosCliente);
		cliente.agregarDisp(televisor);
		cliente.agregarDisp(lavaropas);
		cliente.agregarDisp(ventilador);
					
	}	
		
	@Test
	public void testSimplex(){
		Simplex simplex = new Simplex(cliente.getDispositivos());
		Assert.assertEquals(760, simplex.getSolucion().getValue(), 0.01);
		Assert.assertEquals(360, simplex.getSolucion().getPoint()[0], 0.01); // <--- X2
		Assert.assertEquals(30, simplex.getSolucion().getPoint()[1], 0.01); // <--- X1
		Assert.assertEquals(370, simplex.getSolucion().getPoint()[2], 0.01); // <--- X0
	}
	
}
