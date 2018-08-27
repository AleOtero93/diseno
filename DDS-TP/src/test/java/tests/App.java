package tests;

import entidades.Cliente;
import entidades.Categoria;
import entidades.DispositivoEstandar;
import entidades.TipoDocumento;
import estadosDispositivos.Encendido;
import simplex.SimplexAdapter;
import entidades.DispositivoInteligente;
import utilidades.Simplex;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente;
		DispositivoInteligente televisor;
		DispositivoInteligente lavaropas;
		DispositivoInteligente ventilador;
		
		List<DispositivoInteligente> dispositivosCliente = new ArrayList<>();
		
		cliente = new Cliente("Alejandro", "Otero", "aotero", "admin123","villa crespo",TipoDocumento.DNI,12345,new Categoria("TestCat",1,2,1f,2f));
		televisor = new DispositivoInteligente ("televisor",1234,new Encendido(),0.18,0.08,90,360);
		lavaropas = new DispositivoInteligente("lavaropas", 1111, new Encendido(), 0.875, 0.875,6,30);
		ventilador = new DispositivoInteligente("ventilador", 1111, new Encendido(), 0.06, 0.06,120,360);
		cliente.setDispositivos(dispositivosCliente);
		cliente.agregarDisp(televisor);
		cliente.agregarDisp(lavaropas);
		cliente.agregarDisp(ventilador);
		
		PointValuePair solucion = cliente.hogarEficiente();
		
		System.out.println(solucion.getValue());
		System.out.println(solucion.getPoint()[0]);
		System.out.println(solucion.getPoint()[1]);
		System.out.println(solucion.getPoint()[2]);

	}

}
