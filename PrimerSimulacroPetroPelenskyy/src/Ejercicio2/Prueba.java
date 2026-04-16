package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList<Figura2D> listaFiguras = new ArrayList<Figura2D>();
		Circulo c = new Circulo(4);
		listaFiguras.add(c);
		Rectangulo r = new Rectangulo(30, 10);
		listaFiguras.add(r);
		Triangulo t = new Triangulo(43, 12, 15);
		listaFiguras.add(t);
		
		for (Figura2D f : listaFiguras) {
			System.out.println(f.getNombre() + " " + f.calcularPerimetro() + "cm");	
		}
	}

}
