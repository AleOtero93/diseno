package utilidades;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.io.FileReader;

import com.google.gson.Gson;

import excepciones.ArchivoNoEncontrado;

public class LectorJson {
	
	public static <T> List<T> leerArchivoDeTipo(String filename, Type tipoLista)
	{
	
		try
	{
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
	    BufferedReader lector = new BufferedReader(new FileReader(path));
	
	    Gson gson = new Gson();
	
//	    Type tipoLista = new TypeToken<ArrayList<T>>() {
//	    }.getType();

//		Type tipoLista = new TypeToken<ArrayList<T>>(){}.getType();

		List<T> listaMapeada = gson.fromJson(lector, tipoLista);

//		return (List<T>) listaMapeada.get(0);

	    return listaMapeada;
    }
	catch(FileNotFoundException ex)
	{
		throw new ArchivoNoEncontrado(filename);

	}
}


}
