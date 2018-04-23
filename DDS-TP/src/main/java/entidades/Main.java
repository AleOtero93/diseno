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
	
	private static final String filePath = "C:\\DDS-TP\\diseno\\DDS-TP\\Archivos Json\\entities.json";
	
	public static void main(String[] args) {
		System.out.println("iniciando... ");
		
		try {
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

			final List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();

			for (int index = 0; index < jsonArray.size(); index++) {
				final Dispositivo dispositivo = new Dispositivo();
				final JSONObject jObject = (JSONObject) jsonArray.get(index);

				dispositivo.setNombre((String) jObject.get("nombre"));
				Double kwhora = (Double) jObject.get("kwhora");
				dispositivo.setKwhora(kwhora.floatValue());
				dispositivo.setEncendido((Boolean) jObject.get("encendido"));

				dispositivos.add(dispositivo);
			}

			for(final Dispositivo d : dispositivos) {
				System.out.println("nombre: " + d.getNombre());
				System.out.println("kwhora: " + d.getKwhora());
				System.out.println("encendido: " + d.getEncendido());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
