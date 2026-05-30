package service;

import java.util.Scanner;

import model.CuentaPremium;
import model.CuentaUsuario;
import repository.FicheroCuentas;
import util.Utils;

public class GestionUsuarios {
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Muestra el menú principal del programa.
	 * Permite al usuario elegir entre crear cuenta, iniciar sesión o salir.
	 */
	public void menuInicio() {
		int opcion;
		do {
			opcion = mostrarMenuInicio();
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
	 * Muestra el menú de opciones para usuarios con cuenta premium.
	 */
	public void menuUsuarioPremium(CuentaUsuario cu) {
		int opcion;
		FicheroCuentas fc = new FicheroCuentas();
		do {
			opcion = mostrarMenuPremium();
			switch (opcion) {
				case 1: {
					System.out.print("\nMensaje: ");
					String mensaje = sc.nextLine();
					cu.publicarMensaje(mensaje);
					break;
				}
				case 2: {
					System.out.println();
					String email = Utils.leerEmail();
					if (fc.existeUsuario(email) && !cu.getEmail().equals(email)) {
						System.out.println("\nYa existe usuario con este email.");
						break;
					}
					long telefono = Utils.validarTelefono();
					cu.actualizarPerfil(email, telefono);
					return;
				}
				case 3: {
					if (fc.eliminarUsuario(cu.getEmail())) {
						System.out.println("\nUsuario eliminado correctamente.");
					}
					return;
				}
				case 4: {
					cu.mostrarInformacion();
					break;
				}
				case 5: {
					fc.mostrarMensaje(cu.getEmail());
					break;
				}
				case 6: {
					String usuarioModificado = Utils.formatearUsuario(cu.getNombreUsuario(), cu.getEmail(), cu.getTelefono(), cu.getEdad(), "b");
					if (fc.modificarUsuario(cu.getEmail(), usuarioModificado)) {
						System.out.println("\nCuenta Premium desactivada correctamente.");
					}
					return;
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
	 * Muestra el menú de opciones para usuarios con cuenta básica.
	 */
	public void menuUsuarioBasico(CuentaUsuario cu) {
		int opcion;
		FicheroCuentas fc = new FicheroCuentas();
		do {
			opcion = mostrarMenuBasico();
			switch (opcion) {
				case 1: {
					System.out.print("\nMensaje: ");
					String mensaje = sc.nextLine();
					cu.publicarMensaje(mensaje);
					break;
				}
				case 2: {
					System.out.println();
					String email = Utils.leerEmail();
					if (fc.existeUsuario(email) && !cu.getEmail().equals(email)) {
						System.out.println("\nYa existe usuario con este email.");
						break;
					}
					long telefono = Utils.validarTelefono();
					cu.actualizarPerfil(email, telefono);
					return;
				}
				case 3: {
					if (fc.eliminarUsuario(cu.getEmail())) {
						System.out.println("\nUsuario eliminado correctamente.");
					}
					return;
				}
				case 4: {
					cu.mostrarInformacion();
					break;
				}
				case 5: {
					fc.mostrarMensaje(cu.getEmail());;
					break;
				}
				case 6: {
					String usuarioModificado = Utils.formatearUsuario(cu.getNombreUsuario(), cu.getEmail(), cu.getTelefono(), cu.getEdad(), "p");
					if (fc.modificarUsuario(cu.getEmail(), usuarioModificado)) {
						System.out.println("\nCuenta Premium activada correctamente.");
					}
					return;
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
	
	private int mostrarMenuInicio() {
		System.out.print("""
				
				╔═══════════════════════════════════════╗
				║              MENÚ INICIO              ║
				║▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀║
				║ 1.- Iniciar sesión.                   ║
				║ 2.- Crear cuenta.                     ║
				║ 0.- Salir.                            ║
				╚═══════════════════════════════════════╝
				""");
		return Utils.leerEntero("Opción");
	}
	
	private int mostrarMenuBasico() {
		System.out.print("""
				
				╔═══════════════════════════════════════╗
				║           MENÚ CUENTA BASICA          ║
				║▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀║
				║ 1.- Publicar mensaje.                 ║
				║ 2.- Actualizar perfil.                ║ 
				║ 3.- Eliminar cuenta.                  ║
				║ 4.- Mostrar información de la cuenta. ║
				║ 5.- Mostrar mensajes publicados.      ║
				║ 6.- Activar cuenta Premium.           ║
				║ 0.- Cerrar sesión.                    ║
				╚═══════════════════════════════════════╝
				""");
		return Utils.leerEntero("Opción");
	}
	
	private int mostrarMenuPremium() {
		System.out.print("""
				
				╔═══════════════════════════════════════╗
				║           MENÚ CUENTA PREMIUM         ║
				║▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀║
				║ 1.- Publicar mensaje.                 ║
				║ 2.- Actualizar perfil.                ║ 
				║ 3.- Eliminar cuenta.                  ║
				║ 4.- Mostrar información de la cuenta. ║
				║ 5.- Mostrar mensajes publicados.      ║
				║ 6.- Desactivar cuenta Premium.        ║
				║ 0.- Cerrar sesión.                    ║
				╚═══════════════════════════════════════╝
				""");
		return Utils.leerEntero("Opción");
	}
	
	
	/**
	 * Gestiona el inicio de sesión del usuario.
	 * Solicita el email, comprueba si existe en el sistema y,
	 * en caso afirmativo, crea el objeto CuentaUsuario.
	 * A continuación, muestra el menú correspondiente según el tipo de cuenta.
	 */
	public void iniciarSesion() {
		FicheroCuentas fc = new FicheroCuentas();
		String email, usuario;	
		System.out.println();
		email = Utils.leerEmail();
		if (!fc.existeUsuario(email)) {
			System.out.println("\nNo existe usuario con el email introducido."); 
			return;
		}
		usuario = fc.leerUsuario(email);
		CuentaUsuario cu = Utils.crearObjetoUsuario(usuario);
		System.out.println("\nSesión iniciada correctamente.");
		if (cu instanceof CuentaPremium) {
			menuUsuarioPremium(cu);
		} else {
			menuUsuarioBasico(cu);
		}
	}
	
	/**
	 * Solicita los datos al usuario y crea una nueva cuenta.
	 * Valida los datos introducidos y guarda el usuario en el fichero.
	 */
	public void crearUsuario() {
		FicheroCuentas fc = new FicheroCuentas();
		String nombreUsuario, email;
		long telefono;
		int edad;	
		System.out.println();
		nombreUsuario = Utils.leerNombre();
		email = Utils.leerEmail();
		if (fc.existeUsuario(email)) {
			System.out.println("\nYa existe usuario con el email introducido."); 
			return;
		}
		telefono = Utils.validarTelefono();
		edad = Utils.validarEdad();
		fc.guardarUsuario(Utils.formatearUsuario(nombreUsuario, email, telefono, edad, "b"));
	}
	
}
