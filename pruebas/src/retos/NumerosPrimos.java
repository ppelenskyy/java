package retos;

/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

public class NumerosPrimos {

    public static void main(String[] args) {

        for (int i = 1; i <= 1000; i++) {
            if (esPrimo(i)) {
                System.out.println(i + " es primo.");
            }
        }
    }

    public static boolean esPrimo(int n) {

        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}