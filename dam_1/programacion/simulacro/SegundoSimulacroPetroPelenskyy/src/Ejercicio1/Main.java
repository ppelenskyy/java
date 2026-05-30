package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Barco> listaBarcos = new ArrayList<>();
		listaBarcos.add(new BarcoPasajeros(1, "Catalina", 132, 100, 43));
		listaBarcos.add(new BarcoPasajeros(2, "Reno", 100, 23, 12));
		listaBarcos.add(new BarcoCarga(1, "Cargon", 2, 23, 32));
		listaBarcos.add(new BarcoCarga(2, "Nona", 12, 223, 332));
		
		for (Barco b : listaBarcos) {
			if (b instanceof BarcoPasajeros) {
				System.out.println("\nBarco de Pasajeros");
				b.mostrarInformacion();
			} else {
				System.out.println("\nBarco de Carga");
				b.mostrarInformacion();
			}
		}
	}
	
	private static boolean noEsNegativo(int n) {
		try {
			if (n < 0) throw new BarcoInvalidoException("Error número negativo introducido.");
			return true;
		} catch (BarcoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
