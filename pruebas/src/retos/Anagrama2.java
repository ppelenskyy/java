package retos;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

public class Anagrama2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		if (comprobarAnagrama(sc))
			System.out.printf("Si es anagrama");
		else 
			System.out.printf("NO es anagrama");
		
		sc.close();
	}
	
	public static boolean comprobarAnagrama(Scanner sc) {
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
		
		if (palabraUno.equalsIgnoreCase(palabraDos)) {
			System.out.println("\n¡Dos palabras exactamente iguales no son anagrama!");
			return false;
		}
			
		else if (palabraUno.length() != palabraDos.length()) {
			System.out.println("\n¡La longitud de las dos palabras no es igual!");
			return false;
		}		

		else {
			char[] p1 = palabraUno.toCharArray();
			char[] p2 = palabraDos.toCharArray();
				
			Arrays.sort(p1);
			Arrays.sort(p2);
			if (Arrays.equals(p1, p2)) return true;
			else return false;
		}
	}
}
	
	