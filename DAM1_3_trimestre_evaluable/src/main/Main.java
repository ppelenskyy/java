package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.EdadInvalida;
import exceptions.TelefonoInvalido;
import model.CuentaBasica;
import model.CuentaPremium;
import model.CuentaUsuario;
import util.FicheroCuentas;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {	
		int opcion;
		do {

			opcion = menuInicio();
			switch (opcion) {
				case 1:{
					iniciarSesion();
					break;
				}
				case 2:{
					crearUsuario();
					break;
				}
				case 0: {
					System.out.println("\n---- Hasta Pronto ----");
					break;
				}
				default:{
					System.out.println("\nElegir entre 0-2");
					break;
				}
			}
		} while (opcion != 0);
	}
	
	/**
	 * Método para iniciar sesión o crear un usuario nuevo.
	 * Para comprobar si existe un usuario se realiza una consulta en el fichero de usuarios.
	 * Si encuentra al usuario entonces se llama al método para crear Objeto del usuaraio.
	 */
	private static void iniciarSesion() {
		var fc = new FicheroCuentas();
		String email, usuario;	
		System.out.println();
		email = leerEmail();
		if (!fc.esUsuario(email)) {
			System.out.println("\nNo existe usuario con el email introducido.");
			return;
		}
		usuario = fc.leerUsuario(email);
		CuentaUsuario cu;
		if (usuario.charAt(usuario.length()-1) == 'p') {
			cu = crearObjetoUsuario(usuario, 'p');
			switchUsuarioBasico(cu);
		} else {
			cu = crearObjetoUsuario(usuario, 'b');
		}
		System.out.println("\nSesión iniciada correctamente.");
	}
	
	/**
	 * Método para crear un usuario nuevo y guardarlo en el fichero de texto plano.
	 */
	private static void crearUsuario() {
		String nombreUsuario, email;
		int telefono, edad;	
		System.out.println();
		nombreUsuario = leerNombre();
		email = leerEmail();
		telefono = validarTelefono();
		edad = validarEdad();
		var fc = new FicheroCuentas();
		fc.guardarUsuario(formatoUsuario(nombreUsuario, email, telefono, edad));
	}
	
	private static void switchUsuarioBasico(CuentaUsuario cu) {
		int opcion;
		do {
			opcion = menuUsuarioBasico();
			switch (opcion) {
				case 1: {
					break;
				}
				case 2: {
					break;
				}
				case 3: {
					break;
				}
				case 4: {
					break;
				}
				case 5: {
					break;
				}
				case 0: {
					break;
				}
				default: {
					System.out.println("\nElegir entre 0-5");
					break;
				}
			}
		} while(opcion != 0);
	}
	
	/**
	 * Método para crear un Objeto del usuario.
	 * @param usuario
	 * @param tipoUsuario
	 * @return devuelve un Objeto CuentaUsuario del tipo de usuario concreto.
	 */
	private static CuentaUsuario crearObjetoUsuario(String usuario, char tipoUsuario) {
		String nombreUsuario, email;
		int telefono, edad;
		String[] part = usuario.split(";");
		nombreUsuario = part[0];
		email = part[1];
		telefono = Integer.parseInt(part[2]);
		edad = Integer.parseInt(part[3]);
		if (tipoUsuario == 'p') {
			return (new CuentaPremium(nombreUsuario, email, telefono, edad));
		} else {
			return (new CuentaBasica(nombreUsuario, email, telefono, edad));
		}
	}
	
	/**
	 * Método para devolver una cadena de texto formateada,
	 * para poder almacenarla en el fichero de texto.
	 * @param nombreUsuario
	 * @param email
	 * @param telefono
	 * @param edad
	 * @return devuelve String usuario con separadores.
	 */
	private static String formatoUsuario(String nombreUsuario, String email, int telefono, int edad) {
		String usuario;
		usuario = nombreUsuario + ";" + email + ";" + telefono + ";" + edad + ";" + "b";
		return usuario;
	}
	
	private static int validarTelefono() {
		boolean error;
		int telefono = 0;
		do {
			error = true;
			try {
				telefono = leerEntero("Teléfono");
				if (Integer.toString(telefono).length() != 10) {
					throw new TelefonoInvalido("\nError: longitud incorrecta, la longitud correcta son 10 dígitos.");
				}
				error = false;
			} catch (TelefonoInvalido e) {
				System.out.println(e.getMessage());
			}
		} while (error);
		return telefono;
	}
	
	private static int validarEdad() {
		boolean error;
		int edad = 0;
		do {
			error = true;
			try {
				edad = leerEntero("Edad");
				if (edad < 16) {
					throw new EdadInvalida("\nError: edad invalida, edad mínima 16 años.");
				}
				error = false;
			} catch (EdadInvalida e) {
				System.out.println(e.getMessage());
			}
		} while (error);
		return edad;
	}
	
	private static String leerEmail() {
		String email;
		System.out.print("Email: ");
		email = sc.nextLine().toLowerCase().trim();
		return email;
	}
	
	private static String leerNombre() {
		String nombre;
		System.out.print("Nombre: ");
		nombre = sc.nextLine().toUpperCase().trim();
		return nombre;
	}
	
	private static int menuInicio() {
		System.out.print("""
				
				╔═══════════════════════════════════════╗
				║             MENÚ INICIO               ║
				║▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀║
				║ 1.- Iniciar sesión.                   ║
				║ 2.- Crear cuenta.                     ║
				║ 0.- Salir.                            ║
				╚═══════════════════════════════════════╝
				""");
		return leerEntero("Opción");
	}
	
	private static int menuUsuarioBasico() {
		System.out.print("""
				
				╔═══════════════════════════════════════╗
				║           MENÚ CUENTA BASICA          ║
				║▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀║
				║ 1.- Publicar mensaje.                 ║
				║ 2.- Actualizar perfil.                ║ 
				║ 3.- Eliminar cuenta.                  ║
				║ 4.- Mostrar información de la cuenta. ║
				║ 5.- Comprar suscripción Premium.      ║
				║ 0.- Salir.                            ║
				╚═══════════════════════════════════════╝
				""");
		return leerEntero("Opción");
	}
	
	private static int menuUsuarioPremium() {
		System.out.print("""
				
				╔═══════════════════════════════════════╗
				║           MENÚ CUENTA PREMIUM         ║
				║▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀║
				║ 1.- Publicar mensaje.                 ║
				║ 2.- Actualizar perfil.                ║ 
				║ 3.- Eliminar cuenta.                  ║
				║ 4.- Mostrar información de la cuenta. ║
				║ 5.- Cancelar suscripción Premium.     ║
				║ 0.- Salir.                            ║
				╚═══════════════════════════════════════╝
				""");
		return leerEntero("Opción");
	}
	
	private static int leerEntero(String nombre) {
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
