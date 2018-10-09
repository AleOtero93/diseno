package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.junit.Test;
import com.google.gson.reflect.TypeToken;

import entidades.Cliente;
import entidades.Zona;
import entidades.Transformador;
import excepciones.ArchivoNoEncontrado;
import utilidades.LectorJson;

public class LectorJsonTransformadores {
	private  String archivoInexistente;
	
	@Test
    public void LecturaDeJsonZonas(){
        LectorJson parserJson = new LectorJson();
        List <Zona> zona = parserJson.leerArchivoDeTipo("zonas.json", new TypeToken<ArrayList<Zona>>(){}.getType());
        assertTrue(zona.size()==2);
    }
	
	@Test
	public void LecturaDeJsonTransformadores(){
        LectorJson parserJson = new LectorJson();
        List <Zona> zona = parserJson.leerArchivoDeTipo("zonas.json", new TypeToken<ArrayList<Zona>>(){}.getType());
        assertTrue(zona.get(0).getTransformadores().size()==3);
    }
	
	@Test
	public void TestClientesTransformadores() {
		LectorJson parserJsonZonas = new LectorJson();
        List <Zona> zona = parserJsonZonas.leerArchivoDeTipo("zonas.json", new TypeToken<ArrayList<Zona>>(){}.getType());
        
        LectorJson parserJsonClientes = new LectorJson();
        List <Cliente> clientes = parserJsonClientes.leerArchivoDeTipo("entities.json", new TypeToken<ArrayList<Cliente>>(){}.getType());
        Cliente cliente; 
        
        List <Transformador> transformadoresTotales = new ArrayList<Transformador>();
        List <Transformador> transformadores;
        Transformador t;
        for (int i=0;i<zona.size();i++) {
			transformadores = zona.get(i).getTransformadores();
			for (int j=0;j<transformadores.size();j++) {
				t = transformadores.get(j);
				transformadoresTotales.add(t);
			}
		}
        
        for(int i=0;i<clientes.size();i++) {
        	cliente = clientes.get(i);
        	cliente.buscarTransformadorCercano(transformadoresTotales);
        }
        
        assertTrue(transformadoresTotales.get(0).getResidentes().size()==1);
	}

	
	@Test(expected = ArchivoNoEncontrado.class)
	 public void testArchivoNoEncontradoExcepcion() throws Exception {
		archivoInexistente = "noExiste.json";	
		LectorJson.leerArchivoDeTipo(archivoInexistente, new TypeToken<ArrayList<Zona>>(){}.getType());
	}

	
	
}
