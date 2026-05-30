package colecciones_ejercicio;

import java.util.Scanner;

public interface ComprobarNumero {
	Scanner sc = new Scanner(System.in);
	
	default int comprobarInt() {
		int entero;
		while(!sc.hasNextInt()) {
			System.out.println("\nError introducir un número entero: ");
			sc.nextLine();
		}
		entero = sc.nextInt();
		sc.nextLine();		
		return entero;
	}
	
	default double comprobarDouble() {
		double decimal;
		while(!sc.hasNextDouble()) {
			System.out.println("\nError introducir un número decimal: ");
			sc.nextLine();
		}
		decimal = sc.nextDouble();
		sc.nextLine();		
		return decimal;
	}
}
