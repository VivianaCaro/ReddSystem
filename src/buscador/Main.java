package buscador;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Evaluacion ReddSytem");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese elemento de busqueda (Ejemplo: \"sku-12\"): ");
		String elemento = scanner.nextLine();
		
		MotorBusqueda motor = new MotorBusqueda();
		
		if(args.length >= 1 ) {
			TreeMap<Integer, String> resultado = motor.buscador(args[0], elemento.trim());
			
			if(resultado != null) {
				System.out.println("Resultado TOP 10 match de elementos: ");
				System.out.println("| RANKING\t| ELEMENTO \t\t| PUNTUACION\t|");
				
				int i = 0;
				for (Integer key : resultado.keySet()) {
					if (i++ == 10) {
						break;
					}
					System.out.println("|\t"+i+"\t|\t" + resultado.get(key) + " \t|\t " + key + "\t|");
				}
			}
		} else {
			System.out.println("No se especifico archivo de entrada");
		}
	}
}
