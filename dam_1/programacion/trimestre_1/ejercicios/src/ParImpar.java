// 5.- Dado un número por teclado que me diga si es par o impar.


import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		// Asignar objeto
		Scanner sc = new Scanner(System.in);
		
		// Creación de variables

		int numero;
		
		// Petición de datos
        System.out.println("Revisar si el numero es par o imapar");
        System.out.print("Numero : ");
        numero = sc.nextInt();
        
		// Operaciones y Resultados
        if (numero % 2 == 0) {
        System.out.println(numero+" es par.");
        }
        else {
        	System.out.println(numero + " es impar.");
        }
        sc.close();
	}

}
