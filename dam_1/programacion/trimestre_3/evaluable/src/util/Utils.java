package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.EdadInvalida;
import exceptions.TelefonoInvalido;
import model.CuentaBasica;
import model.CuentaPremium;
import model.CuentaUsuario;

public class Utils {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Convierte los datos de un usuario en cadena de texto separados con un delimitador ';'.
	 * @param nombreUsuario
	 * @param email
	 * @param telefono
	 * @param edad
	 * @param tipo es el tipo de cuenta de usuario ('p' para premium y 'b' par básico) 
	 * @return String usuario con datos del usuario con delimitadores
	 */
	public static String formatearUsuario(String nombreUsuario, String email, long telefono, int edad, String tipo) {
		String usuario;
		usuario = nombreUsuario + ";" + email + ";" + telefono + ";" + edad + ";" + tipo + "\n";
		return usuario;
	}
	
	/**
	 * Crea un objeto de tipo CuentaUsuario a partir de cadena de texto usuario,
	 * según el tipo de cuenta indicado, instancia una CuentaPremium o una CuentaBasica.
	 * @param cadena de texto con los datos del usuario delimitados por ';'
	 * @return objeto CuentaUsuario correspondiente al tipo de cuenta o null en caso de error
	 */
	public static CuentaUsuario crearObjetoUsuario(String usuario) {
		String nombreUsuario, email, tipo;
		long telefono;
		int edad;
		try {
			String[] part = usuario.split(";");
			nombreUsuario = part[0];
			email = part[1];
			telefono = Long.parseLong(part[2]);
			edad = Integer.parseInt(part[3]);
			tipo = part[4];
			CuentaUsuario cu;
			if (tipo.equals("p")) {
				cu = new CuentaPremium(nombreUsuario, email, telefono, edad);
			} else {
				cu = new CuentaBasica(nombreUsuario, email, telefono, edad);
			}
			return cu;
		} catch (NullPointerException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}
	
	/**
	 * Valida que el teléfono tenga 10 dígitos.
	 * Si la longitud es incorrecta lanza excepción TelefonoInvalido.
	 */
	public static long validarTelefono() {
		boolean error;
		long telefono = 0;
		do {
			error = true;
			try {
				telefono = leerLong("Teléfono");
				if (Long.toString(telefono).length() != 10) {
					throw new TelefonoInvalido("\nError: longitud incorrecta, es necesario introducir 10 dígitos.");
				}
				error = false;
			} catch (TelefonoInvalido e) {
				System.out.println(e.getMessage());
			}
		} while (error);
		return telefono;
	}
	
	/**
	 * Valida que la edad sea mayor o igual a 16 años.
	 * Si la edad es inferior a 16 años lanza excepción EdadInvalida
	 */
	public static int validarEdad() {
		boolean error;
		int edad = 0;
		do {
			error = true;
			try {
				edad = leerEntero("Edad");
				if (!(edad >= 16)) {
					throw new EdadInvalida("\nError: edad invalida, edad mínima 16 años.");
				}
				error = false;
			} catch (EdadInvalida e) {
				System.out.println(e.getMessage());
			}
		} while (error);
		return edad;
	}
	
	/**
	 * Solicita y devuelve el email del usuario.
	 */
	public static String leerEmail() {
		String email;
		boolean error = false;
		do {
			System.out.print("Email: ");
			email = sc.nextLine().toLowerCase().trim();
			if (email.isBlank()) {
				System.out.println("\nError: el campo email no puede estar vacio.");
				error = true;
			} else {
				error = false;
			}
		} while(error);
		return email;
	}
	
	/**
	 * Solicita y devuelve el nombre del usuario.
	 */
	public static String leerNombre() {
		String nombre;
		boolean error = false;
		do {
			System.out.print("Nombre: ");
			nombre = sc.nextLine().toUpperCase().trim();
			if (nombre.isBlank()) {
				System.out.println("\nError: el campo nombre no puede estar vacio.");
				error = true;
			} else {
				error = false;
			}
		} while(error);
		return nombre;
	}
	
	/**
	 * Lee un número long por consola validando errores de entrada.
	 * @param nombre texto que se muestra al usuario indicando qué dato introducir
	 * @return número de tipo long introducido por el usuario
	 */
	public static long leerLong(String nombre) {
	    boolean error;
	    long numero = 0;
	    do {
	        error = true;
	        try {
	            System.out.print(nombre + ": ");
	            numero = sc.nextLong();
	            error = false;
	        } catch (InputMismatchException e) {
	            System.out.println("\nError: tiene que ser un número.");
	            sc.nextLine();
	        } catch (Exception e) {
	            System.out.println(e.getLocalizedMessage());
	            sc.nextLine();
	        }
	    } while (error);
	    sc.nextLine();
	    return numero;
	}
	
	/**
	 * Lee un número entero por consola validando errores de entrada.
	 * @param nombre texto que se muestra al usuario indicando qué dato introducir
	 * @return número de tipo int introducido por el usuario
	 */
	public static int leerEntero(String nombre) {
	    boolean error;
	    int numero = 0;
	    do {
	        error = true;
	        try {
	            System.out.print(nombre + ": ");
	            numero = sc.nextInt();
	            error = false;
	        } catch (InputMismatchException e) {
	            System.out.println("\nError: tiene que ser un número entero.");
	            sc.nextLine();
	        } catch (Exception e) {
	            System.out.println(e.getLocalizedMessage());
	            sc.nextLine();
	        }
	    } while (error);
	    sc.nextLine();
	    return numero;
	}
	
}