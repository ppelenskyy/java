package Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Crear objeto de clase de gestion de fichero
		GestionFichero gf = new GestionFichero();
		Scanner sc = new Scanner(System.in);
		String opcion;
		do {
			System.out.println("""
					
					=== MENÚ DE NOTAS ===
					a.- Insertar nota
					b.- Mostrar notas
					c.- Salir de la aplicación
					""");
			System.out.print("Opción: ");
			opcion = sc.nextLine().toLowerCase().trim();
			/*
			 * Recoger el número y revisar si es un número, 
			 * si es positivo y si no es mayor que 10 al final 
			 * añadirlo utilizando el método de la clase GestionFichero
			 */
			switch(opcion) {
				case "a":{
					int nota = 0;
					boolean error;
					do {
						error = false;
						try {
							System.out.print("Ingresar nota: ");
							nota = sc.nextInt();
							sc.nextLine();
						} catch (InputMismatchException e) {
							System.out.println("\nError: tiene que ser un número.");
							sc.nextLine();
							error = true;
						} catch (Exception e) {
							System.out.println("\nError: en general.");
							error = true;
							sc.nextLine();
						}
						if (nota < 0 || nota > 10) {
							System.out.println("\nError: tiene que ser un número positivo y no superior a 10.");
							error = true;
						}		
					} while(error);
					gf.aniadirNota(nota);
					break;
				}
				case "b":{
					gf.mostrarNotas();
					break;
				}
				case "c":{
					System.out.println("\n--- Hasta Pronto ---");
					break;
				}
				default:{
					System.out.println("\nOpción incorrecta elegir entre a-c");
					break;
				}
			}
		} while(!opcion.equals("c"));
		sc.close();
	}

}
