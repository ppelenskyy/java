package Ejercicio2;

import java.util.Scanner;

public class Main {

	/**
	 * Método principal de arranque del programa,
	 * aqui recoge el número de teléfono y lo pasa al método para comprobarlo 
	 * si es correcto se guarda true en la variable correcto y se muestra el mensaje
	 * si no captura la excepción personalizada y asigna el valor true a la variable error
	 * para seguir en el bucle hasta que se introduzca un número correcto.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean error;
		boolean correcto = false;
		String numeroTelefono;
		do {
			error = false;
			try {
				System.out.print("\nIntoducir el número de telélfono(9 digitos): ");
				numeroTelefono = sc.nextLine();
				correcto = comprobarNumeroTelefono(numeroTelefono);
			} catch(TelefonoInvalidoException e) {
				System.out.println("\nError: " + e.getMessage());
				error = true;
			} 
			if (correcto) {
				System.out.println("\nNúmero de teléfono es correcto.");
			}
		} while (error);
		sc.close();
	}
	
	/**
	 * Método para comprobar si el número introducido es correcto
	 * el número se guarda en una cadena de texto y primero se comprueba si 
	 * está vacio si lo esta lanza excepcion que se recoge en el metodo main
	 * si no esta vacio comprueba si tiene 9 caracteres luego comprueba si son
	 * números si alguna condicion falla lanza excepcion personalizada.
	 * 
	 * @param 
	 * 		numeroTelefono número de teléfono en formato cadena de texto
	 * @return
	 * 		true si todas las condiciones son correctas
	 * @throws 
	 * 		TelefonoInvalidoException propaga la excepcion en caso de que no se cumpla alguna condición
	 */
	private static boolean comprobarNumeroTelefono(String numeroTelefono) throws TelefonoInvalidoException{
		if (numeroTelefono.isBlank()) {
			throw new TelefonoInvalidoException("el campo esta vacio.");
		}
		if (numeroTelefono.length()!= 9) {
			throw new TelefonoInvalidoException("longitud incorrecta.");
		}
		char[] caracteres = numeroTelefono.toCharArray();
		for(char c : caracteres) {
			if (!Character.isDigit(c)) {
				throw new TelefonoInvalidoException("contiene caracteres distintos a digitos.");
			}
		}
		return true;
	}

}
