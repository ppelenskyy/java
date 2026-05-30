package retos;

import java.util.Scanner;

/**
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

public class Anagrama {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		comprobarAnagrama(sc);
		sc.close();
	}
	
	public static void comprobarAnagrama(Scanner sc) {
		String palabraUno, palabraDos;
		
		System.out.printf("""
		┌──────────────────────┐
		│       ANAGRAMA       │
		└──────────────────────┘
		""");
		System.out.print("Introducir primera palabra: ");
		palabraUno = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir segunda palabra: ");
		palabraDos = sc.nextLine().toUpperCase().trim();
		
		if (palabraUno.equalsIgnoreCase(palabraDos))
			System.out.println("¡Dos palabras exactamente iguales no son anagrama!");
		
		else if (palabraUno.length() != palabraDos.length()) 
			System.out.println("¡La longitud de las dos palabras no es igual!");

		else {
			if (compararChar(palabraUno, palabraDos))
				System.out.printf("%n%s - es anagrama de la palabra: %s",palabraDos, palabraUno);
			else
				System.out.printf("%n%s - NO es anagrama de la palabra: %s",palabraDos,palabraUno);
		}
	}
	
	public static boolean compararChar(String palabraUno, String palabraDos) {
		/**
		 * Se creean dos arrays de char y se almacenan las do palabras
		 * letra por letra en los arrays.
		 */
		char[] p1 = palabraUno.toCharArray();
		char[] p2 = palabraDos.toCharArray();
		int numeroChar = 0;
		
		/** 
		 * Se comprueba caracter por caracter de la palabraUno con la palabraDos
		 * si coincide se reescribe el array p2 con '-' y se suma +1 al numeroChar
		 */
		for (int i = 0; i < p1.length; i++) {
			for (int k = 0; k < p2.length; k++) {
				if(p1[i] == p2[k]) {
					numeroChar++;
					p2[k] = '-';
					break;
				}
			}
		}
		
		if (numeroChar == p1.length) 
			return true;
		else 
			return false;
	}

}
