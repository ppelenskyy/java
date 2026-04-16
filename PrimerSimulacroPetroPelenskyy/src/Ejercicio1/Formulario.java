package Ejercicio1;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean incompleto;
		int opcion;
		String nombre = "", apellidos = "", DNI = "", email = "";
		
		do {
			incompleto = true;
			System.out.println("""				
					     === MENU FORMULARIO === 
					  1.- Rellenar nombre.
					  2.- Rellenar apellidos.
					  3.- Rellenar DNI.
					  4.- Rellenar e-mail.
					  5.- Salir.
					""");
			System.out.print("Opción: ");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1: {
				System.out.print("Nombre: ");
				nombre = sc.nextLine();
				break;
			}
			case 2: {
				System.out.print("Apellidos: ");
				apellidos = sc.nextLine();
				break;
			}
			case 3: {
				System.out.print("DNI: ");
				DNI = sc.nextLine();
				break;
			}
			case 4: {
				System.out.print("e-mail: ");
				email = sc.nextLine();
				break;
			}
			case 5: {
				String[] form = {nombre, apellidos, DNI, email};
				if (!estaCompleto(form)) {
					break;
				}
				incompleto = false;
				System.out.println("\nEl formulario está completo.");
				System.out.println("--- HASTA PRONTO ---");
				sc.close();
				break;
			}
			default: {
				System.out.println("\nElegir entre 1-5.");
				break;
			}

			}
		} while (incompleto);
	}
	
	private static boolean estaCompleto(String[] form) {
		for (String s : form) {
			if(s.isBlank()) {
				System.out.println("\nFaltan datos por rellenar.");
				return false;
			}
		}
		return true;
	}

}
