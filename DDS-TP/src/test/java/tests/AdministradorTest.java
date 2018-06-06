package tests;

<<<<<<< HEAD
import org.joda.time.DateTime;
=======

import java.util.Date;

>>>>>>> 14b42f96840a06f9f98fd04fc3a4fad241bd2767
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entidades.Administrador;

public class AdministradorTest {
	
<<<<<<< HEAD
	Administrador admin;
	DateTime fecha;
=======
	private Administrador admin;
	//private Administrador admin2;
>>>>>>> 14b42f96840a06f9f98fd04fc3a4fad241bd2767
	
		
	@Before
<<<<<<< HEAD
	public void BeforeMethod() {
		fecha = new DateTime("2018-01-01");
		admin = new Administrador("julian","crespo","admincrespo","1234","Caballito",fecha,123);
=======
	public void initialize() {
		 admin = new Administrador("Julian","Crespo","admin1","12345","Corrientes 1000",
				     new Date(),111111);
		 
		
		 
	/* admin2 = new Administrador("Eduardo", "Lopez","admin2","12345","Boedo",
		 va la fecha2018/01/01,001222);*/
		 
>>>>>>> 14b42f96840a06f9f98fd04fc3a4fad241bd2767
	}
	
	@Test
	public void testMesesEnSistema() {
		Assert.assertEquals(5,admin.mesesEnSistema());
	}
	
/*	@Test
	public void mesesEnSistema2_Test() {
		Assert.assertEquals(5,admin2.mesesEnSistema());
	} */
}
