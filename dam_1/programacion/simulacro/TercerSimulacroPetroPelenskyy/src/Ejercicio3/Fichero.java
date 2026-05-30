package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fichero {
	private final String path = "fichero.txt";
	
	// Metodo para crear fichero
	private void crearFichero() {
		try {
			File f = new File(path);
			if (f.createNewFile()) {
				System.out.println("\nFichero creado correctamente.");
			} else {
				System.out.println("\nFichero no creado.");
			}
		} catch (IOException e) {
			System.out.println("\nError: al crear el fichero.\n" + e.getLocalizedMessage());
		}
	}
	
	// Metodo para comprobar si existe el fichero
	private boolean existeFichero() {
		File f = new File(path);
		if (f.exists()) {
			return true;
		}
		return false;
	}
	
	
	// Metodo para añadir palabra al fichero, 
	// si no existe el fichero se crear el fichero automaticamente
	// tambien si se intenta añadir palabra vacia salta error y 
	// se vuelve a pedir la palabra hasta que no este vacia
	public void aniadirPalabra() {
		Scanner sc = new Scanner(System.in);
		boolean error = false;
		String palabra = "";
		if (!existeFichero())
			crearFichero();
		do {
			error = false;
			try (var bw = new BufferedWriter(new FileWriter(path, true))) {
				System.out.print("Introducir palabra: ");
				palabra = sc.nextLine();
				if (palabra == null || palabra.isBlank()) {
					System.out.println("\nError: la palabra no puede estar vacia.");
					error = true;
				} else {
					bw.write(palabra + "\n");
					System.out.println("\nPalabra añadida correctamente.");
				}
			} catch(IOException e) {
				System.out.println("\nError: al escribir en el fichero.\n" + e.getLocalizedMessage());
			}
		} while(error);
	}
	
	// Metodo para mostrar palabras, para almacenar la primera palabra mas corta 
	// utilizo un if para tener un punto de partida si no la palabra mas corta\
	// siempre seria el vacio ""
	public void mostrarPalabras() {
		String linea;
		String palabraCorta = "";
		String palabraLarga = "";
		int primeraPalabra = 0;
		if (!existeFichero()) {
			System.out.println("\nNo existe el fichero.");
			return;
		}
		try (var br = new BufferedReader(new FileReader(path))) {
			while ((linea = br.readLine()) != null) {
				 if (primeraPalabra == 0) {
					 palabraCorta = linea;
					 primeraPalabra++;
				 }
				 if (palabraLarga.length() < linea.length()) {
					 palabraLarga = linea;
				 }
				 if (palabraCorta.length() > linea.length()) {
					 palabraCorta = linea;
				 }
			}
			System.out.println("\nPalabra mas larga: " + palabraLarga);
			System.out.println("\nPalabra mas corta: " + palabraCorta);
		} catch (IOException e) {
			System.out.println("\nError: al leer el fichero.\n" + e.getLocalizedMessage());
		}
	}
}
