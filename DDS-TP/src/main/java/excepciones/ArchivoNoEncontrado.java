package excepciones;

public class ArchivoNoEncontrado extends RuntimeException {
	
	public ArchivoNoEncontrado(String filename) 
    {
        super("No se encontro el archivo buscado: "+filename);
    }

}
