package tests;

import entidades.Cliente;
import entidades.Categoria;
import entidades.DispositivoEstandar;
import entidades.TipoDocumento;
import estadosDispositivos.Encendido;
import entidades.DispositivoInteligente;
import utilidades.Simplex;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente;
		DispositivoInteligente televisor;
		DispositivoInteligente lavaropas;
		DispositivoInteligente ventilador;
		
		List<DispositivoInteligente> dispositivosCliente = new ArrayList<>();
		
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123", TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		televisor = new DispositivoInteligente ("televisor",1234,new Encendido(),0.18,0.08,90,360);
		lavaropas = new DispositivoInteligente("lavaropas", 1111, new Encendido(), 0.875, 0.875,6,30);
		ventilador = new DispositivoInteligente("ventilador", 1111, new Encendido(), 0.06, 0.06,120,360);
		cliente.setDispositivos(dispositivosCliente);
		cliente.agregarDisp(televisor);
		cliente.agregarDisp(lavaropas);
		cliente.agregarDisp(ventilador);
		
		Simplex simplex = new Simplex(cliente.getDispositivos());
		
		System.out.println(simplex.getSolucion().getValue());
		System.out.println(simplex.getSolucion().getPoint()[0]);
		System.out.println(simplex.getSolucion().getPoint()[1]);
		System.out.println(simplex.getSolucion().getPoint()[2]);

	}

}
