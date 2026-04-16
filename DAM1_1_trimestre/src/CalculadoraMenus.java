/*
 * Debes de crear una calculadora. 
 * La aplicación mostrará un menú con las operaciones que puede realizar (sumar, restar, multiplicar, dividir y resto).
 * También debe pedir al usuario que introduzca los dos números.
 * Para la operación de restar debemos de comprobar que reste el número mayor menos el menor, 
 * es decir que si el usuario introduce, por ejemplo, 5 y 7 deberá hacer 7-5, no puede dar un número negativo. 
 * Para la operación división el divisor no podrá ser cero, 
 * en dicho caso le mostrará un mensaje diciendo que no se puede hacer la división.
 */

import java.util.Scanner;

public class CalculadoraMenus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Declaración de variables.
		int opcion;
		double num1, num2, calculo;
		
		do {
			
			System.out.println("=== CALCULADORA ===");
			System.out.println("1-. Sumar.");
			System.out.println("2-. Restar.");
			System.out.println("3-. Multiplicar.");
			System.out.println("4-. Dividir.");
			System.out.println("5-. Resto.");
			System.out.println("0-. Salir.");
			
			while(!sc.hasNextInt()) {
				System.out.println("!Hay que introducir un numero entero¡");
				System.out.print("Entrada: ");
				sc.next();
			}
			
			// Cunado el while termina el número se guarda en la variable 'opcion'.
			opcion = sc.nextInt();
			switch (opcion) {
			
			// Sumar.
			case 1:
				System.out.println("== SUMAR ==");
				System.out.print("Introducir el primer número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num1 = sc.nextDouble();
				System.out.print("Introducir el segundo número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num2 = sc.nextDouble();
				calculo = num1 + num2;
				System.out.println("Resultado de la suma es: " + calculo);
				System.out.println();
				break;
			
			// Restar.
			case 2:
				System.out.println("== RESTAR ==");
				System.out.print("Introducir el primer número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num1 = sc.nextDouble();
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				System.out.print("Introducir el segundo número: ");
				num2 = sc.nextDouble();
			
				if (num1 > num2) {
					calculo = num1 - num2;
				}
				else {
					calculo = num2 - num1;
				}
				System.out.println("Resultado de la resta es: " + calculo);
				System.out.println();
				break;
			
			// Multiplicar.
			case 3:
				System.out.println("== MULTIPLICAR ==");
				System.out.print("Introducir el primer número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num1 = sc.nextDouble();
				System.out.print("Introducir el segundo número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num2 = sc.nextDouble();
				calculo = num1 * num2;
				System.out.println("Resultado de la multiplicación es: " + calculo);
				System.out.println();
				break;
			
			// Dividir.
			case 4:
				System.out.println("== DIVIDIR ==");
				System.out.print("Introducir el primer número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num1 = sc.nextDouble();
				System.out.print("Introducir el segundo número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num2 = sc.nextDouble();
				
				while (num2 == 0) {
					System.out.println("No se puede dividir entre '0'.");
					System.out.println("== DIVIDIR ==");
					System.out.print("Introducir el primer número: ");
					while (!sc.hasNextDouble()) {
						System.out.println("!Tiene que ser un número¡");
						System.out.println("Entrada: ");
						sc.next();
					}
					num1 = sc.nextDouble();
					System.out.print("Introducir el segundo número: ");
					while (!sc.hasNextDouble()) {
						System.out.println("!Tiene que ser un número¡");
						System.out.println("Entrada: ");
						sc.next();
					}
					num2 = sc.nextDouble();		
				}
				
				calculo = num1 / num2;
				
				System.out.println("Resultado de la división es: " + calculo);
				System.out.println();
				break;
			
			// Resto.
			case 5:
				System.out.println("== RESTO ==");
				System.out.print("Introducir el primer número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num1 = sc.nextDouble();
				System.out.print("Introducir el segundo número: ");
				while (!sc.hasNextDouble()) {
					System.out.println("!Tiene que ser un número¡");
					System.out.println("Entrada: ");
					sc.next();
				}
				num2 = sc.nextDouble();
				while (num2 == 0) {
					System.out.println("El divisor no puede ser '0'");
					System.out.println();
					System.out.println("== RESTO ==");
					System.out.print("Introducir el primer número: ");
					while (!sc.hasNextDouble()) {
						System.out.println("!Tiene que ser un número¡");
						System.out.println("Entrada: ");
						sc.next();
					}
					num1 = sc.nextDouble();
					System.out.print("Introducir el segundo número: ");
					while (!sc.hasNextDouble()) {
						System.out.println("!Tiene que ser un número¡");
						System.out.println("Entrada: ");
						sc.next();
					}
					num2 = sc.nextDouble();	
				}
				
				calculo = num1 % num2;
				
				System.out.println("El resto es: " + calculo);
				System.out.println();
				break;
					
			// Salir.
			case 0:
				break;
			
			// Mensaje de error al introducir un número diferente a 0-5.	
			default:
				System.out.println("El número introducido no es válido tiene que se de 0 - 5)");
				break;
			}
		}
		while (opcion != 0);
		System.out.println("!Hasta Pronto¡");
		sc.close();
	}

}
