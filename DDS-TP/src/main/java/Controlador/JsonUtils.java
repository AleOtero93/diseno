package Controlador;

import java.util.Scanner;

import org.json.JSONObject;

import java.io.InputStream;


public class JsonUtils {

	public static String jsonStringFromFile (String path) {
		Scanner scanner;
		InputStream in = FileHandler.inputFromFile(path);		
		scanner = new Scanner(in);
		String json= scanner.useDelimiter("\\z").next();
		scanner.close();
		return json;
	}
	
	public static JSONObject jsonObjectFromFile (String path) {
		return new JSONObject(jsonStringFromFile(path));
			
	}
	
	public static boolean objectExists(JSONObject jsonObject, String key) {
		Object o;
		try {
           o = jsonObject.get(key);
           	} catch(Exception e) {
           		return false;
           	}
		return o != null;
	}
	
}
