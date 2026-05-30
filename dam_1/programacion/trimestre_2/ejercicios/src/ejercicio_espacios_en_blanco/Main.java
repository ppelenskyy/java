package ejercicio_espacios_en_blanco;

import java.util.Scanner;

/**
 * Validación de Entrada de Texto
 * 
 * Crear un programa que le pida al usuario que ingrese un texto, pero que valide que el texto no sea vacío ni contenga sólo espacios en blanco. Paso a tener en cuenta:
 * 		1. El programa debe pedir al usuario que ingrese un texto. 
 * 		La entrada debe ser procesada para asegurarse de que no sea únicamente espacios en blanco.
 * 
 *	 	2. Si el usuario ingresa solo espacios en blanco o una cadena vacía, 
 *		el programa debe mostrar un mensaje de error indicando que no se permiten solo espacios en blanco y debe volver a pedir la entrada.
 * 
 * 		3. El programa debe seguir solicitando la entrada del usuario hasta que se ingrese un texto válido (es decir, un texto que no sea vacío ni contenga solo espacios).
 * 
 *	 	4. Una vez que el usuario ingrese un texto válido, el programa debe mostrar el texto ingresado.
 */

public class Main {

	public static void main(String[] args) throws EspaciosEnBlancoExcepcion {
		Scanner sc = new Scanner(System.in);
		boolean error;
		String texto;
		do {
			error = false;
			System.out.print("\nIntroduzca una cadena de texto: ");
			texto = sc.nextLine();
			try {
				if (texto.isBlank()) {
					error = true;
					throw (new EspaciosEnBlancoExcepcion("\nError: la cadena de caractéres contiene solamente espacio/s en blanco."));
				}
			} catch(EspaciosEnBlancoExcepcion e) {
				System.out.println(e.getMessage());
			}
		} while(error);
		System.out.println("\nTexto: " + texto);
		sc.close();
	}

}
