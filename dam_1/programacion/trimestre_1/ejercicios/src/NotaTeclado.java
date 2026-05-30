/*
* 6.- Dada una nota por teclado, me debe mostrar su nota en letras. Posibilidades:
* • De 0 a 4 INSUFICIENTE
* • 5 SUFICIENTE
* • 6 BIEN
* • De 7 a 8 NOTABLE
* • 9 SOBRESALIENTE
* • 10 MATRICULA DE HONOR
* Es decir, si me da un 7 mostrará el mensaje de NOTABLE. Hay que controlar que el
* usuario introduce un número de 0 a 10.
*/

import java.util.Scanner;

public class NotaTeclado {

	public static void main(String[] args) {
		// Asignar objeto
		Scanner sc = new Scanner(System.in);
		
		// Creación de variables
		double nota;

		// Peticion de datos
		System.out.print("La nota es : ");
		nota = sc.nextDouble();
		
		// Operaciones y Resultado	
		if ((nota < 0) || (nota > 10)) {
			System.out.println("Valor incorrecto el numero tiene que ser de 0 a 10");
		}
		else if ((nota >= 0) && (nota < 5)) {
			System.out.println("INSUFICIENTE");
		}
		else if ((nota >= 5) && (nota < 6)) {
			System.out.println("SUFICIENTE");
		}
		else if ((nota >= 6) && (nota < 7)) {
			System.out.println("BIEN");
		}
		else if ((nota > 6) && (nota < 9)) {
			System.out.println("NOTABLE");
		}
		else if ((nota >= 9) && (nota < 10)) {
			System.out.println("SOBRESALIENTE");
		}
		else if (nota == 10) {
			System.out.println("MATRICULA DE HONOR");
		}
		else {
			System.out.println("Dato invalido");
		}
		sc.close();
		

	}

}
