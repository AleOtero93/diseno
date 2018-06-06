package tests;


import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Administrador;

public class AdministradorTest {
	
	private Administrador admin;
	//private Administrador admin2;
	
		
	@Before
	public void initialize() {
		 admin = new Administrador("Julian","Crespo","admin1","12345","Corrientes 1000",
				     new Date(),111111);
		 
		
		 
	/* admin2 = new Administrador("Eduardo", "Lopez","admin2","12345","Boedo",
		 va la fecha2018/01/01,001222);*/
		 
	}
	
	@Test
	public void mesesEnSistema_Test() {
		Assert.assertEquals(0,admin.mesesEnSistema());
	}
	
/*	@Test
	public void mesesEnSistema2_Test() {
		Assert.assertEquals(5,admin2.mesesEnSistema());
	} */
}
