/* 3.-
 * Dado dos números por teclado, que me muestre cuál es el mayor, menor y si
 * son iguales.
*/

import java.util.Scanner;

public class ComparacionDosNumeros {
    	
	public static void main(String[] args) {
	    
		// Asignar objeto
		Scanner sc = new Scanner(System.in);
		
		// Creación de variables
		int num1, num2;
		
		// Petición de datos
		System.out.println("Comparación de numeros mayor, menor o igual");
		System.out.print("Primer numero: ");
		num1=sc.nextInt();
		System.out.print("Segundo numero: ");
		num2=sc.nextInt();

		// Operaciones y Resultados
		if (num1 == num2) {
			System.out.println(num1+" Es igual a "+num2);
		}
		else if (num1 > num2) {
			System.out.println(num1+" Es mayor que "+num2);
		}
		else if (num1 < num2) {
			System.out.println(num1+" Es menor que "+num2);
		}
		else {
			System.out.println("Datos incorrectos");
		
		}
		sc.close();
        
	}

}
