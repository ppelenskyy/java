/*
 * Debes de crear una calculadora. La aplicación mostrará un menú con las operaciones que puede realizar (sumar, restar, multiplicar, dividir y resto).
 * También debe pedir al usuario que introduzca los dos números. Para la operación de restar debemos de comprobar que reste el número mayor menos el menor, 
 * es decir que si el usuario introduce, por ejemplo, 5 y 7 deberá hacer 7-5, no puede dar un número negativo. 
 * Para la operación división el divisor no podrá ser cero, en dicho caso le mostrará un mensaje diciendo que no se puede hacer la división.
 * 
 * Cualquier duda estoy a vuestra disposición.
 * Un saludo.
 */

import java.util.Scanner;

public class CalculadoraParte2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		menu(sc);

	}
	
	// Método para imprimire el menú y ejecutar el 'switch'.
	public static void menu(Scanner sc) {
		separar();
		System.out.println("=== CALCULADORA ===");
		System.out.println("1.- Sumar.");
		System.out.println("2.- Restar.");
		System.out.println("3.- Multiplicar.");
		System.out.println("4.- Dividir.");
		System.out.println("5.- Resto.");
		System.out.println("0.- Salir.");
		switchMenu(sc);
	}
	
	// Método para menú switch.
	public static void switchMenu(Scanner sc) {
		int opcion;
		do {
			opcion = (int)revisarNumero(sc);	
			switch(opcion) {
			case 1:
				System.out.println("--- SUMAR ---");
				System.out.println("El resultado es: " + sumar(sc));
				menu(sc);
				break;
			case 2:
				System.out.println("--- RESTAR ---");
				System.out.println("El resultado es: " + restar(sc));
				menu(sc);
				break;
			case 3:
				System.out.println("--- MULTIPLICAR ---");
				System.out.println("El resultado es: " + multiplicar(sc));
				menu(sc);
				break;
			case 4:
				System.out.println("--- DIVIDIR ---");
				double resultado = dividir(sc);
				if (resultado == -1) {
					menu(sc);
					break;
				}
				else System.out.println("El resultado es: " + resultado);
				menu(sc);
				break;
			case 5:
				System.out.println("--- RESTO ---");
				double resultadoResto = resto(sc);
				if (resultadoResto == -1) {
					menu(sc);
					break;
				}
				else System.out.println("El resultado es: " + resultadoResto);
				menu(sc);
				break;
			case 0:
				break;
			default: 
				System.out.println("Elegir un número entre 0-4: ");
				break;
			}
			
		} while(opcion != 0);
		System.out.println("¡Hasta pronto!");
	}
	
	// Método para revisar la entrada por teclado que sea un número doble.
	public static double revisarNumero(Scanner sc) {
		while(!sc.hasNextDouble()) {
			System.out.print("Tiene que ser un número: ");
			sc.next();
		}
		return sc.nextDouble();
	}
	
	// Método para separar visualmente en consola.
	public static void separar() {
		System.out.println();
	}
	
	// Método para realizar la suma.
	public static double sumar(Scanner sc) {
		double resultado;
		double arrayNumeros [] = pedirNumeros(sc);
		resultado = arrayNumeros [0] + arrayNumeros [1];
		return resultado;
	}
	
	// Método para realizar la resta.
	public static double restar(Scanner sc) {
		double resultado;
		double arrayNumeros [] = pedirNumeros(sc);
		if (arrayNumeros [0] > arrayNumeros [1]) resultado = arrayNumeros [0] - arrayNumeros [1];
		else resultado = arrayNumeros [1] - arrayNumeros [0];
		return resultado;
	}
	
	// Método para realizar la multiplicación.
	public static double multiplicar(Scanner sc) {
		double resultado;
		double arrayNumeros [] = pedirNumeros(sc);
		resultado = arrayNumeros [0] * arrayNumeros [1];
		return resultado;
	}
	
	// Método para realizar la división.
	public static double dividir(Scanner sc) {
		double resultado;
		double arrayNumeros [] = pedirNumeros(sc);
		if (arrayNumeros [1] == 0) {
			System.out.println("¡No se puede dividir entre '0'!");
			return -1;
		}
		else {
			resultado = arrayNumeros [0] / arrayNumeros [1];
			return resultado;
		}

	}
	
	// Método para realizar el resto.
	public static double resto(Scanner sc) {
		double resultado;
		double [] arrayNumeros = pedirNumeros(sc); 
	
		if (arrayNumeros[1] == 0) {
			System.out.println("¡El divisor no puede ser '0'!");
			return -1;
		}
		else {
			resultado = arrayNumeros[0] % arrayNumeros[1];
			return resultado;
		}
	}
	
	// Método con array para pedir números y retornar 2 números en el mismo método.
	public static double [] pedirNumeros (Scanner sc) {
		double num1, num2;
		System.out.print("Introducir el primer número: ");
		num1 = revisarNumero(sc);
		System.out.print("Introducir el segundo número: ");
		num2 = revisarNumero(sc);
		return new double [] {num1, num2}; 
	}
	
}
