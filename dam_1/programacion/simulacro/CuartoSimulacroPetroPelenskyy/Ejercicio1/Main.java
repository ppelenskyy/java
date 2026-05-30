package Ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] formulario = new String[4];
		boolean completo;
		String opcion;
		do {
			completo = false;
			System.out.println("""
					
					    === Menú ===
					1.- Rellenar nombre.
					2.- Rellenar apellidos.
					3.- Rellenar DNI.
					4.- Rellenar e-mail.
					5.- Salir
					""");
			System.out.print("Opción: ");
			opcion = sc.nextLine();
			switch(opcion) {
				case "1":{
					nombre(sc, formulario);
					break;
				}
				case "2":{
					apellidos(sc, formulario);
					break;
				}
				case "3":{
					DNI(sc, formulario);
					break;
				}
				case "4":{
					email(sc, formulario);
					break;
				}
				case "5":{
					completo = estaCompleto(formulario);
					if (!completo) {
						System.out.println("\nFormulario incompleto, faltan datos por rellenar.");
					} else {
						System.out.println("\nFormulario completo.");
					}
					break;
				}
				default:{
					System.out.println("Opción incorrecta elegir entre 1-5");
					break;
				}
			}
		} while(!(completo && opcion.equals("5")));

	}
	
	/* Metodo para comprobar el array del formulario si hay 
	*  algún valor null o está vacio devuelve false
	*  si está todo completado devuelve true
	*/
	private static boolean estaCompleto(String[] formulario) {
		boolean completo;
		completo = true;
		for (String s : formulario) {
			if (s == null || s.isBlank()) {
				completo = false;
			}
		}
		return completo;
	}
	
	private static void nombre(Scanner sc, String[] formulario) {
		String nombre;
		boolean error;
		do {
			error = false;
			System.out.print("\nNombre: ");
			nombre = sc.nextLine();
			if (nombre == null || nombre.isBlank()) {
				System.out.println("\nError el valor no puede ser null o estar vacio.");
				error = true;
			}
		} while(error);
		formulario[0] = nombre;
	}
	
	private static void apellidos(Scanner sc, String[] formulario) {
		String apellidos;
		boolean error;
		do {
			error = false;
			System.out.print("\nApellidos: ");
			apellidos = sc.nextLine();
			if (apellidos == null || apellidos.isBlank()) {
				System.out.println("\nError el valor no puede ser null o estar vacio.");
				error = true;
			}
		} while(error);
		formulario[1] = apellidos;
	}
	
	private static void DNI(Scanner sc, String[] formulario) {
		String DNI;
		boolean error;
		do {
			error = false;
			System.out.print("\nDNI: ");
			DNI = sc.nextLine();
			if (DNI == null || DNI.isBlank()) {
				System.out.println("\nError el valor no puede ser null o estar vacio.");
				error = true;
			}
		} while(error);
		formulario[2] = DNI;
	}
	
	private static void email(Scanner sc, String[] formulario) {
		String email;
		boolean error;
		do {
			error = false;
			System.out.print("\nEmail: ");
			email = sc.nextLine();
			if (email == null || email.isBlank()) {
				System.out.println("\nError el valor no puede ser null o estar vacio.");
				error = true;
			}
		} while(error);
		formulario[3] = email;
	}
	
}
