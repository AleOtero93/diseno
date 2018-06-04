package entidades;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	private static final String filePath = "C:\\dds\\tp\\diseno\\DDS-TP\\Archivos Json\\entities.json";
	
	public static void main(String[] args) {
		System.out.println("iniciando... ");
		
		try {
			//Cargamos la ruta en un filereader
			FileReader reader = new FileReader(filePath);

			//Llamamos al parser y le mandamos el reader
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

			//Variables a usar en las repetitivas
			Cliente usuario;
			Dispositivo dispositivo;
			JSONObject jObject, jObject_disp;
			JSONArray jsonArray_disp;
			String nombre, apellido, username, password;
			List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
			final List<Cliente> clientes= new ArrayList<Cliente>();

			//Por cada elemento del array de clientes
			for (int index = 0; index < jsonArray.size(); index++) {
				
				//Obtengo el objeto de esa posicion del array
				jObject = (JSONObject) jsonArray.get(index);
				
				//Seteo las variables para crear el objeto cliente
				nombre = (String) jObject.get("nombre");
				apellido = (String) jObject.get("apellido");
				username = (String) jObject.get("usuario");
				password = (String) jObject.get("password");
				
				//Llamo al constructor de cliente
				usuario = new Cliente(nombre, apellido, username, password);
				
				//Creo un nuevo array json con los dispositivos
				jsonArray_disp = (JSONArray) jObject.get("dispositivos");
				
				//Por cada elemento del array de dispositivos, IDEM CLIENTE
				for(int index_disp = 0; index_disp < jsonArray_disp.size(); index_disp++){
					jObject_disp = (JSONObject) jsonArray_disp.get(index_disp);
					dispositivo = new Dispositivo();
					dispositivo.setNombre((String) jObject_disp.get("nombre"));
					Double kwhora = (Double) jObject_disp.get("kwhora");
					dispositivo.setKwhora(kwhora.floatValue());
					dispositivo.setEncendido((Boolean) jObject_disp.get("encendido"));
					
					//Lo agrego a la lista
					dispositivos.add(dispositivo);
				}
				
				//Agrego la lista de dispositivos al Cliente
				usuario.setDispositivos(dispositivos);
				
				//Agrego a la lista de clientes para verificar si funciono
				clientes.add(usuario);
			}

			for(final Cliente c : clientes) {
				System.out.println("nombre: " + c.getNombre());
				System.out.println("apellido: " + c.getApellido());
				System.out.println("dispositivos:");
				dispositivos = c.getDispositivos();
				for(final Dispositivo d : dispositivos) {
					System.out.println("nombre: " + d.getNombre());
					System.out.println("kwhora: " + d.getKwhora());
					System.out.println("encendido: " + d.getEncendido());
				}
				System.out.println("-----");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
