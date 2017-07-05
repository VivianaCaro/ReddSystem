package buscador;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtils {
	public static JSONObject stringToJson(String stringToParse) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		
		try {
			json = (JSONObject) parser.parse(stringToParse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	public static Map<String, JSONObject> jsonToMap(JSONObject json) {
		Map<String, JSONObject> map = new HashMap<>();
		 
		for (Object key : json.keySet()) {
			map.put( (String) key, (JSONObject) json.get(key));
		}
		
		return map;
	}
}
