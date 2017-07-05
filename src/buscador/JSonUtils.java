package buscador;

import java.io.IOException;
import java.nio.charset.Charset;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSonUtils {
	
	//a peso mas alto, z el menor
	public enum Alphabet {
		a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;

		static int MAX_WEIGHT = 26;
		
	    public static int getNum(String targ) {
	        return MAX_WEIGHT - valueOf(targ).ordinal();
	    }

	    public static int getNum(char targ) {
	        return MAX_WEIGHT - valueOf(String.valueOf(targ)).ordinal();
	    }    
	}
	
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
	
	public static void main(String[] args) {
		//testing json
		try {
			String stringToParse = Reader.readFile("./resources/redd-test-data.json", Charset.defaultCharset()); //StandardCharsets.UTF_8
			
			
			JSONObject json = stringToJson(stringToParse);
//			System.out.println("sku-20000 :  " + json.get("sku-20000"));

			for (Object key : json.keySet()) {
//				System.out.println(key + " : " + (String)json.get(key).toString().replaceAll("att-*", ""));
				JSONObject atts = stringToJson((String)json.get(key).toString().replaceAll("att-*", ""));
//				for (Object att : atts.keySet()) {
//					System.out.println(Alphabet.getNum((String)att));
//				}
			}
			
//			System.out.println(Alphabet.getNum("z"));
			
//			JSONObject atts = stringToJson((String)json.get("sku-1").toString().replaceAll("att-*", ""));
//			for (Object att : atts.keySet()) {
////				System.out.println((String)att + " -> " + Alphabet.getNum((String)att));
//				System.out.println((String)att + " peso:  " + Alphabet.getNum((String)att) +" : "+ atts.get(att));
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
