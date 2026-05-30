package Ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fichero f = new Fichero();
		String opcion;
		do {
			System.out.println("""
					
					    === MENÚ ===
					1.- Añadir palabra.
					2.- Mostrar palabras.
					0.- Salir.
					""");
			opcion = sc.nextLine();
			switch(opcion) {
			/*
			 * En el caso 1 para añadir una palabra se entra en el bucle do while 
			 * para revisar si la palabra introducida es valida 
			 * si palabra es null, esta vacia ó tiene logitud menor a 2 se considera como incorrecta
			 * en este caso error = true
			 * asi conseguimos que se introduzca una palabra correcta.
			 */
				case "1": {
					boolean error;
					String palabra;
					do {
						error = false;
						System.out.print("\nAñadir palabra: ");
						palabra = sc.nextLine();
						if (palabra.isBlank() || palabra.length() < 2) {
							System.out.println("\nError: la palabra no puede ser null, estar vacia ó ser menor de 2 caracteres.");
							error = true;
						} else {
							f.aniadirPalabra(palabra);
						}
					} while(error);
					break;
				}
				case "2": {
					f.mostrarPalabras();
					break;
				}
				case "0": {
					System.out.println("\n=== HASTA PRONTO ===");
					break;
				}			
				default: {
					System.out.println("\nOpción incorrecta elegir entre 0-2");
					break;
				}
			}
		} while(!opcion.equals("0"));
		sc.close();
	}

}
