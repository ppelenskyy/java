/* 4.-
 * Dado tres números por teclado, que me muestre cuál es el mayor y el menor.
 * Mostrarlos en orden descendiente.
*/

import java.util.Scanner;

public class ComparacionTresNumeros {
      	
	public static void main(String[] args) {
	    
		// Asignar objeto
		Scanner sc = new Scanner(System.in);
		
		// Creación de variables
		int num1, num2, num3;
		
		// Petición de datos
		System.out.println("Comparación de tres numeros mayor o menor");
		System.out.print("Primer numero: ");
		num1=sc.nextInt();
		System.out.print("Segundo numero: ");
		num2=sc.nextInt();
		System.out.print("Tercer numero: ");
		num3=sc.nextInt();

		// Operaciones y Resultados
		
		// Comparar si todos los numeros son iguales
		if ((num1 == num2) && (num2 == num3)) {
			System.out.println("El resultado en orden descendiente es: "+num1+" , "+num2+" , "+num3);
		}
		
		// Comparar si numero 1 es el mas grande de todos
		else if ((num1 > num2) && (num1 > num3)) {
			if (num2 > num3) {
				System.out.println("El resultado en orden descendiente es: "+num1+" , "+num2+" , "+num3);
			}
			else {
				System.out.println("El resultado en orden descendiente es: "+num1+" , "+num3+" , "+num2);
			}
			
		}
			
		// Comparar si numero 2 es el mas grande de todos
		else if ((num2 > num1) && (num2 > num3)) {	
			if (num1 > num3) {
				System.out.println("El resultado en orden descendiente es: "+num2+" , "+num1+" , "+num3);
				}			
			else {
				System.out.println("El resultado en orden descendiente es: "+num2+" , "+num3+" , "+num1);
				}	
			}
		
		// Comparar si numero 3 es el mas grande de todos
		else if ((num3 > num1) && (num3 > num2)) {
			if (num1 > num2) {
				System.out.println("El resultado en orden descendiente es: "+num3+" , "+num1+" , "+num2);
			}
			else {
				System.out.println("El resultado en orden descendiente es: "+num3+" , "+num2+" , "+num1);
			}
		}
		else {
			System.out.println("Error");
		}
		sc.close();
	}
}

