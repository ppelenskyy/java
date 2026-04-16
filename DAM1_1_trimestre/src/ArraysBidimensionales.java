/*
 * 1. Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla en forma de matriz.
 * 2. Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo con números aleatorios entre 0 y 10.
 * 3. Crear dos matrices de n filas x n columnas y sumar sus valores, los resultados se deben almacenar en otra matriz. 
 * Los valores y el tamaño no serán insertados por el usuario. Mostrar las matrices originales y el resultado.
 */

import java.util.Scanner;

public class ArraysBidimensionales {

	public static void main(String[] args) {
		// Declarar Scanner.
		Scanner sc = new Scanner(System.in);
		
		// Declarar variables, constantes y matrizes.
		int opcion;
		int n;
		final int MATRIZ3X3 [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int matriz5xn [][];
		int matrizA [][] = {
				{10,20,30},
				{15,25,35}
		};
		int matrizB [][] = {
				{5,10,15},
				{100,150,250}
		};
		int matrizSuma[][] = new int [2][3];
		
		// Bucle principal.
		do {
			System.out.println("=== MENÚ ===");
			System.out.println("1-. Matriz 3x3.");
			System.out.println("2-. Matriz 5x(n).");
			System.out.println("3-. Suma de dos matrizes (n)x(n).");
			System.out.println("0-. Salir.");
			System.out.print("Entrada: ");
			
			// Comprobar si el número introducido es número entero.
			while(!sc.hasNextInt()) {
				System.out.print("¡Tiene que ser un número entero!: ");
				sc.next();	
			}
			
			// Guardar el número entero.
			opcion = sc.nextInt();
			System.out.println();
			
			// Switch principal.
			switch(opcion) {
				// 1-. Matriz 3x3.
				case 1:
					System.out.println("--- Matriz 3x3 ---");
					System.out.print("Columna");
					System.out.println(" 0 1 2");
					System.out.println("        -----");
					
					// Recorrer las filas.
					for (int i = 0;i < MATRIZ3X3.length;i++) {	
						System.out.print("Fila "+i+"| ");
						
						// Recorrer las columnas.
						for (int j = 0;j < MATRIZ3X3[i].length;j++) {
							System.out.print(MATRIZ3X3[i][j] + " ");
						}
						System.out.println();	
					}
					System.out.println();
					break;			
				
				// 2-. Matriz 5x(n).
				case 2:
					System.out.println("--- Matriz 5x(n) ---");
					System.out.print("Introducir el número de columnas: ");
					
					// Comprobar que el número introducido sea un número entero.
					while(!sc.hasNextInt()) {
						System.out.print("!Tiene que ser un número entero!: ");
						sc.next();	
						}
					
					// Guardar número en la variable.
					n = sc.nextInt();
					
					// Comprobar que el número introducido sea un número mayor a 0.
					while(n <= 0) {
						System.out.println("¡Tiene que ser mayor a '0'!: ");
						
						// Comprobar que el número introducido sea un número entero.
						while(!sc.hasNextInt()) {
							System.out.print("!Tiene que ser un número entero!: ");
							sc.next();	
						}
						
						// Guardar número en la variable.
						n= sc.nextInt();
					}
					
					
					matriz5xn = new int [5][n];
					
					// Recorrer matriz para pedir número(entero) por teclado para cada celda.
					for (int i = 0;i < matriz5xn.length;i++) {
						for(int j = 0; j<matriz5xn[i].length;j++) {
							System.out.println("Escribir el valor para la Fila: "+ i + " Columna: "+ j);
							while(!sc.hasNextInt()) {
								System.out.print("¡Tiene que ser un número entero!: ");
								sc.next();
							}
							matriz5xn [i][j] = sc.nextInt(); 
						}
					}
					
					// Recorrer matriz mostrando el contenido de cada celda.
					for (int i = 0; i < matriz5xn.length;i++) {
						System.out.println("Fila: " + i);
						for (int j = 0; j < matriz5xn[i].length;j++) {
							System.out.println(" Columna: " + j + " Valor: " + matriz5xn[i][j]);
						}
					}
					System.out.println();
					break;
					
				// 3-. Suma de dos matrizes (n)x(n).
				case 3:
					System.out.println("--- Suma de dos matrizes (n)x(n) ---");
					
					// Recorrer matrizSuma para sumar matrizA[i][j] + matrizB[i][j] y guardar el resultado en matrizSuma.
					for (int i = 0; i < matrizSuma.length; i++) {
						for (int j = 0; j < matrizSuma[i].length; j++) {
							matrizSuma[i][j] = matrizA[i][j] + matrizB[i][j];
							System.out.println("La suma de: "+ matrizA[i][j] + " + " + matrizB[i][j] + " = " + matrizSuma[i][j]);
						}
					}
					System.out.println();
					
					// Recorrer matrizSuma ya con resultados de la suma de matrizA[i][j] + matrizB[i][j].
					System.out.println("Se reccorre matrizSuma para revisar el resultado guardado.");
					for (int i = 0; i < matrizSuma.length; i++) {
						System.out.println("Fila: " + i);
						for (int j = 0; j < matrizSuma[i].length; j++) {
							System.out.println("Columna: " + j + " Suma: " + matrizSuma[i][j]);	
						}
					}
					System.out.println();
					break;
					
				// 0-. Salir.
				case 0:
					System.out.println();
					break;
					
				// Opción por defecto.
				default:
					System.out.println("¡Valor incorrecto elegir entre 0 y 3!");
					System.out.println();
					break;
			}		
		}while (opcion != 0); // Condición para salir del bucle principal.
		
		// Mensaje de despedida.
		System.out.println("¡Hasta pronto!");
		
		// Cerrar el Scanner.
		sc.close();
	}

}
