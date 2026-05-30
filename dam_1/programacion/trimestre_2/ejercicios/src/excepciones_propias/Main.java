package excepciones_propias;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws DniExcepcion, TelefonoExcepcion, DecimalesExcepcion {
		Scanner sc = new Scanner(System.in);
		String dni = "", telefono;
		int entero;
		double decimal;
		boolean error;
		do {
			error = true;
			try {
				System.out.print("\nIntroducir el DNI: ");
				dni = sc.nextLine().toUpperCase().trim();	
				dni = dniComprobar(dni);
				error = false;
			} catch (Exception e) {
				System.out.println("\nError: en general");
			}
			telefono = numeroTelefonoComprobar(sc);
			decimal = numeroComprobar(sc);
		} while(error);
		
		entero = (int) decimal;
		System.out.println("\nDNI: " + dni + ", Teléfono: " + telefono + ", Número favorito: " + entero + ".");
	}
	
	public static String dniComprobar(String dni) throws DniExcepcion {
		boolean error = true;
		String dniNumeros;
		try {
			if (dni.length() != 9)
				throw new DniExcepcion("\nError: longitud del DNI incorrecta tiene que ser de 8 dígitos y 1 letra");
			dniNumeros = dni.substring(0, 8);
			for (int i = 0; i < dniNumeros.length(); i++) {
				if (!(Character.isDigit(dniNumeros.charAt(i)))) 
					throw new DniExcepcion("\nError: el DNI no contiene números en las posiciones de 1 a 8");
			}
			if (Character.isDigit(dni.charAt(8))) 
				throw new DniExcepcion("\nError: el DNI no contiene letra en la ultima posición");
			error = false;
		} catch(DniExcepcion e) {
			System.out.println(e.getMessage());
		} finally {
			if (error) 
				dni = "true";
		}
		return dni;
	}
	
	public static String numeroTelefonoComprobar(Scanner sc) throws TelefonoExcepcion {
		boolean error;
		String telefono = "";
		do {
			error = true;
			try {
				System.out.print("\nIntroducir el número del teléfono (ej: 633142587) +34 ");
				telefono = sc.nextLine();
				if (Integer.parseInt(telefono) == 0)
					throw new TelefonoExcepcion("\nError: no puede contener unicamente 0s");
				if (telefono.length() != 9) 
					throw new TelefonoExcepcion("\nError: longitud del teléfono incorrecta tiene que ser de 9 digitos");
				error = false;
			} catch(NumberFormatException e) {
				System.out.println("\nError: tienen que ser números");
			} catch(TelefonoExcepcion e) {
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("\nError: en general");
			}
		} while(error);
		return "+34 " + telefono.substring(0, 3) + " " + telefono.substring(3, 6) + " " + telefono.substring(6, 9);
	}
	
	public static double numeroComprobar(Scanner sc) throws DecimalesExcepcion {
		boolean error;
		double decimal = 0.0;
		do {
			error = true;
			try {
				System.out.print("\nIntroducir el número favorito: ");
				decimal = sc.nextDouble();
				if (decimal != (int) decimal) 
					throw new DecimalesExcepcion("\nError: el número no puede contener decimales");	
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("\nError: tiene que ser un número");
			} catch (DecimalesExcepcion e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("\nError: en general");
			} finally {
				sc.nextLine();
			}
		} while(error);
		return decimal;
	}
}
