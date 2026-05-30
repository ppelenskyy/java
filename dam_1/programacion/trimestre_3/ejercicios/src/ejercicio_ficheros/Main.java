package ejercicio_ficheros;

/**
 * 1. Escribe un programa que guarde en un fichero con nombre primos.txt 
 * los números primos que hay entre 1 y 500. (PrimosEscribir.java)
 * 
 * 2. Realiza un programa que lea el fichero creado en el ejercicio anterior y que muestre
 * los números por pantalla. (PrimosLeer.java).
 * 
 * @author Petro Pelenskyy Pelenskyy
 */

public class Main {

	public static void main(String[] args) {
		String path = "./src/com/fp/petro/ejercicio_ficheros/primos.txt";
		
		PrimosEscribir.escribirFichero(path);
		PrimosLeer.leerFichero(path);
	}

}
