package buscador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

	static String readFile(String path) throws IOException {
//	  byte[] encoded = Files.readAllBytes(Paths.get(path));
//	  return new String(encoded, encoding);
		InputStream is = new FileInputStream(path); 
		BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
		String line = buf.readLine(); StringBuilder sb = new StringBuilder(); 
		while(line != null) {
			sb.append(line).append("\n"); 
			line = buf.readLine(); 
		}
		String fileAsString = sb.toString();

		return fileAsString;
	}
}
