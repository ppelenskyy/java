package Ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fichero f = new Fichero();
		String opcion = "";
		do {
			System.out.println("""
					
					=== MENÚ FICHERO ===
					1.- Añadir palabra.
					2.- Mostrar palabras.
					0.- Salir.
					""");
			System.out.print("Opción: ");
			opcion = sc.nextLine();
			switch(opcion) {
				case "1":{
					f.aniadirPalabra();
					break;
				}
				case "2":{
					f.mostrarPalabras();
					break;
				}
				case "0":{
					System.out.println("\n=== HASTA PRONTO ===");
					break;
				}
				default:{
					System.out.println("\nOpción incorrecta elegir entre 0-2.");
					break;
				}
			}
		} while (!opcion.equals("0"));
		sc.close();
	}

}
