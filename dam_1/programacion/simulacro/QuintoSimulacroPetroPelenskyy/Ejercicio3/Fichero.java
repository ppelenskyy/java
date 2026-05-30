package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
	private String path = "fichero.txt";
	
	/*
	 * Metodo para comprobar si existe una palabra si no existe devuelve false.
	 */
	private boolean existeFichero(String p) {
		File f = new File(p);
		if (f.exists())
			return true;
		return false;
	}
	
	
	/*
	 * Metodo para crear el fichero.
	 */
	private void crearFichero(String p) {
		File f = new File(p);
		try {
			f.createNewFile();
		} catch (IOException e) {
			System.out.println("\nError: al crear el fichero.");
		}
	}
	
	
	/*
	 * Metodo para añadir una palabra, aqui es donde se revisa si existe el fichero si no existe
	 * se crea el fichero mediante el metodo crearFichero().
	 */
	public void aniadirPalabra(String palabra) {
		if (!existeFichero(path)) {
			crearFichero(path);
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)) ) {
			bw.write(palabra + "\n");
			System.out.println("\nPalabra añadida correctamente.");
		} catch (IOException e) {
			System.out.println("\nError: al añadir la palabra.");
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Metodo para mostrar por consola la palabra mas corta y mas larga.
	 * para tener una palabra mas corta se utiliza una variable de primera palabra para almacenar 
	 * la primera palabra en la variable de palabra mas corta para tener punto de inicio si
	 * no siempre seria el vacio la palabra mas corta.
	 */
	public void mostrarPalabras() {
		int primeraPalabra = 0;
		String palabra;
		String palabraLarga = "";
		int larga = 0;
		String palabraCorta = "";
		int corta = 0;
		if (!existeFichero(path)) {
			System.out.println("\nNo existe ninguna palabra guardada.");
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while((palabra = br.readLine()) != null) {
				if (primeraPalabra == 0) {
					palabraCorta = palabra;
					corta = palabra.length();
					primeraPalabra++;
				}
				if (palabra.length() > larga) {
					palabraLarga = palabra;
					larga = palabra.length();
				}
				if (palabra.length() < corta) {
					palabraCorta = palabra;
					corta = palabra.length();
				}
			}
			System.out.println("\nPalabra más corta: "+ palabraCorta);
			System.out.println("\nPalabra más larga: "+ palabraLarga);
		} catch (FileNotFoundException e) {
			System.out.println("\nError: fichero no encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("\nError: al leer el fichero.");
			e.printStackTrace();
		}
	}
}
