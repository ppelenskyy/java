package ejercicio_ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrimosLeer {
	
	public static void leerFichero(String path) {			
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linea;
			int fila = 10;
			System.out.println("_________________ NÚMEROS PRIMOS _________________");
			while((linea = br.readLine()) != null) {
				if (linea.length() < 2) {
					System.out.print(" " + linea + "   ");
				} else if (linea.length() < 3) {
					System.out.print(" " + linea + "  ");
				} else {
					System.out.print(" " + linea + " ");
				}
				
				fila--;
				if (fila == 0) {
					System.out.println();
					fila = 10;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Excepción: " + e.toString());
		} catch (IOException e) {
			System.out.println("Excepción: " + e.toString());
		}

	}
}
