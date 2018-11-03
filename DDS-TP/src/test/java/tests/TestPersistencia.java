//package tests;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//
//import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
//
//import entidades.Cliente;
//import entidades.Transformador;
//import entidades.Zona;
//
//public class TestPersistencia {
//	
//	public static void main(String[] args) {
//	
//	EntityManager manager = PerThreadEntityManagers.getEntityManager();
//	EntityTransaction transaccion = manager.getTransaction();
//	
//	List<Transformador> transformadores = null;
//	List<Cliente> residentes = null;
//	
//	transaccion.begin();
//	
//	Transformador tranfo = new Transformador("T1", 1, residentes);
//	Zona zona = new Zona("caballito", 1, transformadores);
//		
//	manager.persist(zona);
//	manager.persist(tranfo);
//	
//	transaccion.commit();
//	
//	}
//}
