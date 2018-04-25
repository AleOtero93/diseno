package tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Administrador;

public class AdministradorTest {
	
	Administrador admin;
	
	@Before
	public void BeforeMethod() {
		 admin = new Administrador("TestNom", 
				"TestApe", 
				"TestUsu", 
				"TestPas",
				"TestDom",
				new Date(),
				111111);
	}
	
	@Test
	public void mesesEnSistema_Test() {
		Assert.assertEquals(0,admin.mesesEnSistema());
	}
}
