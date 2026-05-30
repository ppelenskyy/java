package ejercicio_ficheros;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PrimosEscribir {

	public static void escribirFichero(String path) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, false))) {
			//OBSERVACIÓN >>> EL FICHERO SE CREA CON FileWriter <<< con parametro = false se sobreescribe el fichero con true se añaden nuevas lineas.
			/**
			 * NO ES NECESARIO AÑADRI ESTE CÓDIGO
			File fichero = new File(path);
			if (!fichero.exists()) {
				System.out.println("El fichero no existe");
				if (fichero.createNewFile()) {
					System.out.println("Fichero creado correctamente");
				} else {
					System.out.println("No se ha podido crear el fichero");
				}
			} else {
				System.out.println("El fichero ya existe");
			}
			*/
			for (int i = 2; i <= 500; i++) {
				if (esPrimo(i)) {
					writer.write(i + "\n");
				}
			}
			System.out.println("Números primos guardados correctamente en primos.txt\n"); 
		} catch (FileNotFoundException e) {
			System.out.println("Excepción: " + e.toString());
		} catch (IOException e) {
			System.out.println("Excepción: " + e.toString());
		}
	}
	
	private static boolean esPrimo(int i) {
		int primo = (int) Math.sqrt(i);
		while (primo > 1) {
			if (i % primo == 0) {
				return false;
			}
			primo--;
		}
		return true;
	}

}
