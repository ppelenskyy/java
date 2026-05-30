package figuras_geometricas;

/**
 * Desarrolla una aplicación orientada a objetos que gestione diferentes tipos de figuras geométricas. 
 * El sistema debe cumplir las siguientes condiciones:
 * 	- Existirá una clase abstracta llamada Figura.
 * 	- La clase Figura contendrá al menos dos métodos abstractos:
 * 		· calcularArea()
 * 		· calcularPerimetro()
 *	- Se crearán al menos dos clases que hereden de Figura (por ejemplo, Circulo y Rectangulo).
 * 	- Cada clase hija deberá implementar los métodos abstractos de la clase Figura.
 * 	- La aplicación deberá utilizar polimorfismo, de forma que las figuras se manejen mediante referencias del tipo Figura.
 */

public class Main {

	public static void main(String[] args) {
		Gestion g = new Gestion();
		g.switchMain();
	}

}