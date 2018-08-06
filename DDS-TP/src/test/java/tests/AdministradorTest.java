package tests;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Administrador;

public class AdministradorTest {
	
	Administrador admin;
	DateTime fecha;
	
	@Before
	public void BeforeMethod() {
		fecha = new DateTime("2018-01-01");
		admin = new Administrador("julian","crespo","admincrespo","1234","Caballito",fecha,123);
	}
	
	@Test
	public void testMesesEnSistema() {
		Assert.assertEquals(7,admin.mesesEnSistema());
	}
}
