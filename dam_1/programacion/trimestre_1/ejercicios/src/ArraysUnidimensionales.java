/*
* 1.- Programa Java que guarda en un array 10 números enteros que se leen por teclado. A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
* 
* 2.- Programa Java para leer la altura de N personas y calcular la altura media. Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media. 
* El valor de N se pide por teclado y debe ser entero positivo.
* 
* 3.- En España cada persona está identificada con un Documento Nacional de Identidad (DNI) en el que figura un número y una letra, por ejemplo 56999545W
* La letra que sigue al número se calcula siguiendo la metodología que vamos a indicar. Crea un programa que calcule la letra de un DNI a partir del número de DNI que introduzca el usuario. 
* Es decir, se debe pedir el DNI sin la letra por teclado y el programa nos devolverá el DNI completo (con la letra).
* Para calcular la letra, se debe tomar el resto de dividir nuestro número de DNI entre 23. 
* El resultado debe estar por tanto entre 0 y 22.
* Crea una aplicación donde, dado un DNI SÓLO NUMÉRICO, busque en un array de caracteres la posición que corresponda y devuelva su letra. Esta es la tabla de caracteres:
* Posición     0   1   2   3  4   5   6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  21  22
* Letra        T   R   W   A  G   M   Y  F  P  D  X   B   N    J   Z   S   Q   V   H   L   C   K   E
* Por ejemplo, si introducimos el  DNI 20267079, el resto de dividirlo por 23 sería 8, luego la letra sería la P, que es la que ocupa esa posición en la matriz de caracteres.
*/

import java.util.Scanner;

public class ArraysUnidimensionales {
	
	public static void main(String[] args) {
		// Declaración del Scanner.
		Scanner sc = new Scanner(System.in);
		
		// Declaración variable y constantes.
		int opcion, resultado, n = 1000, alturaTotal = 0, alturaMedia, alturaSuperior = 0, alturaInferior = 0, alturaIgual = 0, restoDni;
		long dni;
		final int ARRAYX = 10; 
		
		// Arrays
		int array10 [] = new int [ARRAYX]; 		
		final char ARRAYDNI [] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		
		// Bucle principal.
		do {
			// Se pide al usuariuo que eliga una de las opcines disponibles.
			System.out.println("=== Menú ===");
			System.out.println("1-. Array 10 números");
			System.out.println("2-. Array Altura");
			System.out.println("3-. Array DNI");
			System.out.println("0-. Salir");
			
			// Usuario introduce un valor, y se comprueba si es un número entero si no lo es no se sale del bucle while.
			while(!sc.hasNextInt()) {
				System.out.print("¡Tiene que ser un número entero!: ");
				sc.next();
			}
			
			// Se guarda el resultado en variable 'opcion'.
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			// Opción 1 Array 10 números
			case 1:
				for (int i = 0; i < ARRAYX; i++) {
					System.out.print("Introducir el número para la posición " + i + ": ");
					while(!sc.hasNextInt()) {
						System.out.print("¡Tiene que ser un número entero!: ");
						sc.next();
					}
					resultado = sc.nextInt();
					array10 [i] = resultado;
				}
				for (int i = 0; i < 10; i++) {
					
					if (array10 [i] == 0) {
						System.out.println("El número en la posición: " + i + " es igual a 0.");
					}
					else if (array10 [i] < 0) {
						System.out.println("El número en la posición: " + i + " número: " + array10 [i] + " es negativo.");	
					}
					else {
						System.out.println("El número en la posición: " + i + " número: " + array10 [i] + " es positivo.");		
					}	
				}
				System.out.println();
				break;
			
			// Opción 2 Array Altura.
			case 2: 
				// Resetear las variables para que no se sume el valor introducido anteriormente. (si se repite el case 2).
				alturaTotal = 0;
				alturaInferior = 0;
				alturaSuperior = 0;
				alturaIgual = 0;
				
				System.out.print("Introducir el número de personas a comparar: ");
				while(!sc.hasNextInt()) {
					System.out.print("¡Tiene que ser un número entero!: ");
					sc.next();
				}
				n = sc.nextInt();
				
				while (n == 0) {
					System.out.println("¡El número de personas no puede ser igual o menor a 0!");
					while(!sc.hasNextInt()) {
						System.out.print("¡Tiene que ser un número entero!: ");
						sc.next();
					}
					n = sc.nextInt();
				}
				
				int arrayAltura [] = new int [n];
				
				for (int i = 0; i < n; i++) {
					System.out.print("Introducir la altura en 'cm' de persona nº: " + (i + 1) + ": ");
					while(!sc.hasNextInt()) {
						System.out.print("¡Tiene que ser un número entero en 'cm' !: ");
						sc.next();
					}
				    arrayAltura [i] = sc.nextInt();	
				    alturaTotal += arrayAltura [i];
			
				}
				alturaMedia = alturaTotal / n;
				System.out.println("Altura media es de: " + alturaMedia);
				
				for (int i = 0; i < n; i++) {
					if (arrayAltura [i] < alturaMedia) {
						alturaInferior ++;
					}
					else if (arrayAltura [i] > alturaMedia) {
						alturaSuperior ++;
					}
					else if (arrayAltura [i] == alturaMedia) {
						alturaIgual ++;
					}
				}
				if (alturaIgual == 0) {
					System.out.println("Número de personas con altura inferiro a la media es de: " + alturaInferior + " personas.");
					System.out.println("Número de personas con altura superior a la media es de: " + alturaSuperior + " personas.");
				}
				else {
					System.out.println("Número de personas con altura igual a la media es de: " + alturaIgual + " personas.");
					System.out.println("Número de personas con altura inferiro a la media es de: " + alturaInferior + " personas.");
					System.out.println("Número de personas con altura superior a la media es de: " + alturaSuperior + " personas.");
				}
				System.out.println();
				break;
			
			// Opción 3 Array DNI.
			case 3:
				System.out.println("=== Revisar cual es la letra de DNI según el número ===");
				System.out.println("Introducir el número del DNI: ");
				while(!sc.hasNextLong()) {
					System.out.println("¡Tiene que ser un número!: ");
					sc.next();
				}
				dni = sc.nextLong();
				while (dni < 0) {
					System.out.println("DNI no puede ser negativo:");
					while(!sc.hasNextLong()) {
						System.out.println("¡Tiene que ser un número!: ");
						sc.next();
					}
					dni = sc.nextLong();	
				}
				
				restoDni = (int)dni % 23;
				System.out.println("La letra del DNI es: " + ARRAYDNI[restoDni]);
				System.out.println("El DNI completo es: " + dni + ARRAYDNI[restoDni]);
				System.out.println();
				break;
			
			// Opción 0 Salir del switch.
			case 0:
				break;
			
			// Opción por defecto.
			default:
				System.out.println("Elegir una opción de 0 - 3.");
				break;
			}
		// Se termina de ejecutar el bucle si se elige la opción 0.
		}while (opcion != 0);
		sc.close();
	}
}
