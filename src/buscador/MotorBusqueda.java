package buscador;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.json.simple.JSONObject;

public class MotorBusqueda {
	
	//Enumera el alfabeto para asignar pesos planos (de 1 en 1) a las letras
	//donde "a" peso mas alto y "z" el menor
	public static enum Alfabeto {
		a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;

		static int MAX_WEIGHT = 26;
		
	    public static int getNum(String targ) {
	        return MAX_WEIGHT - valueOf(targ).ordinal();
	    }

	    public static int getNum(char targ) {
	        return MAX_WEIGHT - valueOf(String.valueOf(targ)).ordinal();
	    }    
	}
	
	public TreeMap<Integer, String> buscador(String rutaArchivo, String input) {
		String stringToParse = "";
		
		try {
			//Leo archivo de ejemplo de entrada
			stringToParse = Reader.readFile(rutaArchivo);
		} catch(IOException io) {
			System.out.println("No se pudo leer archivo de entrada");
			io.printStackTrace();
		}
		//Transforma a JSONObject para manipularlo
		JSONObject json = JSONUtils.stringToJson(stringToParse);
		//Mapa donde almacena par "sku-x", atributos
		Map<String, JSONObject> mapaJson = JSONUtils.jsonToMap(json);
		//Obtiene desde el mapa los atributos del sku de busqueda
		JSONObject atributosBusqueda = mapaJson.get(input);
		//Peso final que se le dara al match entre elementos
		int pesoBusqueda = 0;
		String atributo = "";
		String key = "";
		JSONObject value = null;
		
		if(atributosBusqueda == null) {
			System.out.println("Elemento no pertenece a los datos obtenidos.");
			return null;
		}
		
		//TreeMap ordenado descendente para guardar los resultados de la comparacion de pesos
		TreeMap<Integer, String> mapaResultado = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 > o1? 1 : o2==o1? 0 :-1;
			}
		});		    
		
		//Recorre mapa de entrada
		for(Entry<String, JSONObject> entry : mapaJson.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			pesoBusqueda = 0;
			
			//Evita comparar consigo mismo
			if(!key.equals(input)) {
				//Por cada letra del alfabeto, compara el match de atributos
				for (Alfabeto letra : Alfabeto.values()) {
					atributo = "att-"+letra;
					//Agrega peso si los atributos son iguales
					if(atributosBusqueda.get(atributo) != null && value.get(atributo) != null && atributosBusqueda.get(atributo).equals(value.get(atributo)) ) {
						pesoBusqueda += Alfabeto.getNum(""+letra);
					}
				}
				
				//Se omiten resultados sin match
				if(pesoBusqueda > 0) {
					mapaResultado.put(pesoBusqueda, key);
				}
			}
		}
		
		return mapaResultado;
	}
}
