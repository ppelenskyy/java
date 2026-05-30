package Ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Introduce código postal(5 digitos): ");
			int codigoPostal = sc.nextInt();
			if (Integer.toString(codigoPostal).length() != 5) {
				throw new CodigoPostalException("Error: longitud incorrecta");
			} else {
				System.out.println("Código postal correcto.");
			}
		} catch (CodigoPostalException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

}
