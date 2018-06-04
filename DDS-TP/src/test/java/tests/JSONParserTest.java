package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParserTest {

	private static final String filePath = "C:\\Users\\Dario Angel\\Desktop\\entities.json";
	
	public static void main(String[] args) {

		try {
			// read the json file
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				System.out.println("El nombre es : " + jsonObject.get("name"));
				
			}
			
			// get a String from the JSON object
			//String name = (String) jsonObject.get("name");
			//System.out.println("The first name is: " + name);

//			// get a number from the JSON object
//			long id =  (long) jsonObject.get("id");
//			System.out.println("The id is: " + id);
//
//			// get an array from the JSON object
//			JSONArray lang= (JSONArray) jsonObject.get("languages");
//			
//			// take the elements of the json array
//			for(int i=0; i<lang.size(); i++){
//				System.out.println("The " + i + " element of the array: "+lang.get(i));
//			}
//			Iterator i = lang.iterator();
//
//			// take each value from the json array separately
//			while (i.hasNext()) {
//				JSONObject innerObj = (JSONObject) i.next();
//				System.out.println("language "+ innerObj.get("lang") + 
//						" with level " + innerObj.get("knowledge"));
//			}
//			// handle a structure into the json object
//			JSONObject structure = (JSONObject) jsonObject.get("job");
//			System.out.println("Into job structure, name: " + structure.get("name"));

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

	}

}