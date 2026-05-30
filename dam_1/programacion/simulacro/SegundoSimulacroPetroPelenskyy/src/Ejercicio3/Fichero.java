package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fichero {
	private Scanner sc = new Scanner(System.in);
	private String path = "palabras.txt";
	
	public void anadirPalabra() {
		System.out.print("Introduce la palabra: ");
		String palabra = sc.nextLine();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			File f = new File(path);
			
			if (!f.exists()) {
				f.createNewFile();
				System.out.println("Fichero creado correctamente.");
			}
			bw.write(palabra + "\n");
			System.out.println("Palabra guardada correctamente.");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void mostrarPalabras() {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linea;
			int palabraCorta = 99999999;
			int palabraLarga = 0;
			String masCorta = "";
			String masLarga = "";
			while ((linea = br.readLine()) != null) {
				if (linea.length() < palabraCorta) {
					palabraCorta = linea.length();
					masCorta = linea;
				}
				if (linea.length() > palabraLarga) {
					palabraLarga = linea.length();
					masLarga = linea;
				}
			}
			System.out.println("Palabra mas larga: " + masLarga + " con longitud de: " + palabraLarga);
			System.out.println("Palabra mas corta: " + masCorta + " con longitud de: " + palabraCorta);
			
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}
