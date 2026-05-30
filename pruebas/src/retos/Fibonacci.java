package retos;

/**
  * Escribe un programa que imprima los 50 primeros números de la sucesión
  * de Fibonacci empezando en 0.
  * - La serie Fibonacci se compone por una sucesión de números en
  *   la que el siguiente siempre es la suma de los dos anteriores.
  *   0, 1, 1, 2, 3, 5, 8, 13...
  */

public class Fibonacci {

	public static void main(String[] args) {
		fib_2();
	}
	
	public static void fib_1() {
		long[] fib = new long[50];
		
		for(int i = 0; i < fib.length; i++) {
			if (i == 0) {
				System.out.println((i+1)+".- "+fib[i]);
				fib[i+1] = 1;
			}
			else {
				if (i == 1) {
					System.out.println((i+1)+".- "+fib[i]);
					fib[i+1] = 1;
				}
				else {
					fib[i] = fib[i-1]+fib[i-2];
					System.out.println((i+1)+".- "+fib[i]);
				}
			}
		}
	}
	
	public static void fib_2() {
		long n0 = 0;
		long n1 = 1;

		for (int i = 0; i <= 50; i++) {
			System.out.println(n0); //       0 1 1 2 3 5
			
			long fib = n0 + n1;		// fib = 1 2 3 5 8 13
			n0 = n1;				// n0  = 1 1 2 3 5 8
			n1 = fib;				// n1  = 1 2 3 5 8 13
		}
	}

}
