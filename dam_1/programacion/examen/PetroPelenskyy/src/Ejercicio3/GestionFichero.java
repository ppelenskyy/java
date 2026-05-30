package Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionFichero {
	private String path = "notas.txt";
	
	/**
	 * Métod para añadir una nota al ficher, 
	 * primero se comprueba si exsite el fichero, si no existe se crea al instante
	 * luego se añade la nota y se guarda en el fichero, si se añade correctamete 
	 * se muestra mensaje por pantalla.
	 * @param nota recibe nota que se va a insertar 
	 */
	public void aniadirNota(int nota) {
		if (!existeFichero()) {
			if(!crearFichero()) {
				return;
			}
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			bw.write(nota + "\n");
			System.out.println("\nNota añadida correctamente.");
		} catch(IOException e) {
			System.out.println("\nError: al añadir la nota.");
		}
	}
	
	/**
	 * Método para mostrar las notas
	 * primero combrueba si existe el fichero si no existe se muestra el mensaje y se sale
	 * del método,  luego se lee el ficher y se parsea la nota de formato cadena de texto a int
	 * primero se asignan primeros valores para tener valores para poder comparar correctamente y 
	 * luego se realizan las comparaciónes y al final se muestra el mensaje por pantalla
	 * con nota alta y nota baja.
	 */
	public void mostrarNotas() {
		if (!existeFichero()) {
			System.out.println("\nNo existe el ficher por lo tanto no hay ninguna nota guardada.");
			return;
		}
		int contador = 0;
		int notaMayor = 0;
		int notaMenor = 0;
		int nota = 0;
		String texto;
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			while((texto = br.readLine()) != null) {
				try {
					nota = Integer.parseInt(texto);
				} catch (NumberFormatException e) {
					System.out.println("\nError: al parsear la nota.");
					return;
				}
				if (contador == 0) {
					notaMayor = nota;
					notaMenor = nota;
				}
				if (nota > notaMayor) {
					notaMayor = nota;
				}
				if (nota < notaMenor) {
					notaMenor = nota;
				}
				contador++;
			}
		} catch(IOException e) {
			System.out.println("\nError: al leer las notas.");
		}
		if (contador > 0) {
			System.out.println("\nNota mayor: " + notaMayor);
			System.out.println("\nNota menor: " + notaMenor);
		} else {
			System.out.println("\nEl archivo está vacio.");
		}
		
	}
	
	/**
	 * Método para revisar si existe el fichero
	 * @return
	 * 		true si existe
	 * 		false si no existe
	 */
	private boolean existeFichero() {
		File f = new File(path);
		if (!f.exists()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Método para crear el fichero
	 * @return
	 * 		true si se crear correctamente
	 * 		false si hay un error al crear el fichero
	 */
	private boolean crearFichero() {
		File f = new File(path);
		try {
			f.createNewFile();
			System.out.println("\nFichero creado correctamente.");
		} catch(IOException e) {
			System.out.println("\nError: al crear el fichero.");
			return false;
		}
		return true;
	}
}
