package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.google.gson.reflect.TypeToken;

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
	
	public void LecturaDeJsonTransformadores(){
        LectorJson parserJson = new LectorJson();
        List <Zona> zona = parserJson.leerArchivoDeTipo("zonas.json", new TypeToken<ArrayList<Zona>>(){}.getType());
        assertTrue(zona.get(0).getTransformadores().size()==3);
    }

	
	@Test(expected = ArchivoNoEncontrado.class)
	 public void testArchivoNoEncontradoExcepcion() throws Exception {
		archivoInexistente = "noExiste.json";	
		LectorJson.leerArchivoDeTipo(archivoInexistente, new TypeToken<ArrayList<Zona>>(){}.getType());
	}

	
	
}
