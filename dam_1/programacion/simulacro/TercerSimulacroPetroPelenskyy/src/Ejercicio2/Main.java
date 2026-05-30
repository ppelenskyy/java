package Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean error = false;
		int codigoPostal;
		do {
			error = false;
			try {
				System.out.print("Escribir código postal (5 digitos): ");
				codigoPostal = sc.nextInt();
				if (Integer.toString(codigoPostal).length() != 5) {
					System.out.println("\n");
					throw new ExcepcionCodigoPostal("longitud incorrecta.");
				}
			} catch (ExcepcionCodigoPostal e) {
				System.out.println("\nError: " + e.getMessage());
				sc.nextLine();
				error = true;
			} catch (InputMismatchException e) {
				System.out.println("\nError: tiene que ser un número entero.\n" + e.getStackTrace());
				sc.nextLine();
				error = true;
			} catch (Exception e) {
				System.out.println("\nError: en general." + e.getStackTrace());
				sc.nextLine();
				error = true;
			}
		} while (error);

	}

}
