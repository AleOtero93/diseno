package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.google.gson.reflect.TypeToken;

import entidades.Cliente;
import excepciones.ArchivoNoEncontrado;
import utilidades.LectorJson;

public class LectorJsonTest {
	private  String archivoInexistente;
	
	@Test
    public void LecturaDeJson(){
        LectorJson parserJson = new LectorJson();
        List <Cliente> clientes = parserJson.leerArchivoDeTipo("entities.json", new TypeToken<ArrayList<Cliente>>(){}.getType());
        assertTrue(clientes.size()==1);
    }

	
	@Test(expected = ArchivoNoEncontrado.class)
	 public void testArchivoNoEncontradoExcepcion() throws Exception {
		archivoInexistente = "noExiste.json";	
		LectorJson.leerArchivoDeTipo(archivoInexistente, new TypeToken<ArrayList<Cliente>>(){}.getType());
	}

	
	
}
