package test;

import java.io.File;
import java.io.IOException;

public class ImprimirNumeros {

	public static void main(String[] args) throws IOException {
		final String FICHERO = "alumnos.txt";
		File fichero = new File(FICHERO);
		if (!fichero.exists()) {
			fichero.createNewFile();
			System.out.println("El fichero no existe");
		} else {
			System.out.println("Fichero existe");
		}

	}

}
