/*
 * 1.-
 * Pedir el nombre y tres notas por teclado al usuario para poder mostrar la
 * media. Tenéis que hacer el ejercicio con números enteros y con decimales. Me
 * entregáis la versión que queráis.
 * El mensaje que debe mostrar tiene que ser: Bienvenido .......: tu nota es......
*/

import java.util.Scanner;

public class NotaMedia {
    	
	public static void main(String[] args) {
	    
		// Asignar objeto
		Scanner sc = new Scanner(System.in);
		
		// Creación de variables
		String nombre;
		int nota1, nota2, nota3, media;
		
		// Petición de datos
		System.out.print("Tu nombre es: ");
		nombre=sc.nextLine();
		System.out.print("Tu primera nota es: ");
		nota1=sc.nextInt();
		System.out.print("Tu segunda nota es: ");
		nota2=sc.nextInt();
		System.out.print("Tu tercera nota es: ");
		nota3=sc.nextInt();

		// Operaciones
		media = (nota1+nota2+nota3)/3;

		// Resultados
		System.out.println("Bienvenid: "+nombre+" tu nota es: "+media);
		sc.close();
	}

}
