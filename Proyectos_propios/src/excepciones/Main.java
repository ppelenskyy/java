package excepciones;

import javax.swing.JOptionPane;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean estado  = false;
		boolean error = false;
		int a, b;

		do {
			try {
				System.out.println(" === Resta === ");
				System.out.print("Introducir primer número: ");
				a = Integer.parseInt(sc.nextLine());
				System.out.print("Introducir segundo número: ");
				b = Integer.parseInt(sc.nextLine());
				System.out.println("Resultado de resta: "+restar(a, b));
				estado = true;
					
			} catch (NumberFormatException e) {
				System.out.println(e);
			}		
		} while(!estado);	
	}
	
	public static int restar(int a, int b) {
		if (a > b) {
			return a - b;
		}
		return b - a;
	}

}
