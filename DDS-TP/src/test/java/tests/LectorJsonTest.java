package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.google.gson.reflect.TypeToken;

import entidades.Cliente;

import utilidades.LectorJson;

public class LectorJsonTest {
	
	@Test
    public void LecturaDeJson(){
        LectorJson parserJson = new LectorJson();
        List <Cliente> clientes = parserJson.leerArchivoDeTipo("entities.json", new TypeToken<ArrayList<Cliente>>(){}.getType());
        assertTrue(clientes.size()==1);
    }


}
