package Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean error;
		int codigoPostal;
		do {
			error = false;
			try {
				System.out.print("\nCódigo postal(5 dígitos): ");
				codigoPostal = sc.nextInt();
				if (Integer.toString(codigoPostal).length() != 5) {
					throw new CodigoPostalException("longitud incorrecta.");
				}
				System.out.println("\nCódigo postal correcto.");
			} catch (CodigoPostalException e) {
				System.out.println("\nError: " + e.getMessage());
				error = true;
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("\nError: tiene que ser un número entero.");
				error = true;
				sc.nextLine();
			}
		} while(error);
		sc.close();
	}

}
