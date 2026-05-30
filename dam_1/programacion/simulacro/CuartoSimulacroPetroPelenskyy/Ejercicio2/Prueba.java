package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList<Figura2D> listaFiguras = new ArrayList<>();
		Figura2D f;
		f = new Circulo("Circulo", 23);
		listaFiguras.add(f);
		f = new Rectangulo("Rectangulo", 20, 20);
		listaFiguras.add(f);
		f = new Triangulo("Triangulo", 2, 2, 4);
		listaFiguras.add(f);
		
		// Recorremos la lista de figuras con un for each mostramos por pantalla (el nombre y calculamos el perimetro).
		for (Figura2D lf : listaFiguras) {
			System.out.println("\nNombre: " + lf.getNombre() + ", perímetro: " + lf.calcularPerimetro() + "cm"); 
		}
	}

}
