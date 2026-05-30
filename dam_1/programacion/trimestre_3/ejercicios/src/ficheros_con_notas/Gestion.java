package ficheros_con_notas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gestion {
	private Scanner sc = new Scanner(System.in);
	private String path;
	private String pathTemporal;
	
	public Gestion(String path) {
		this.path = path+"alumnos.txt";
		pathTemporal = path+"alumnosTemporal.txt";
	}
	
	protected void switchMenu() {
		try {
			File f = new File(path);
			if (f.exists()) {
				f.delete();
				f.createNewFile();
				System.out.println("Fichero borrado y creado correctamente");
			} else {
				f.createNewFile();
				System.out.println("Fichero creado correctamente");
			}
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
		int opcion;
		do {
			opcion = getMenuOpcion();
			switch(opcion) {
				case 1: {
					addAlumno();
					break;
				}
				case 2: {
					setNota();
					break;
				}
				case 3: {
					deleteAlumno();
					break;
				}
				case 4: {
					getTodosAlumnos();
					break;
				}
				case 5: {
					getAlumno();
					break;
				}
				case 0: {
					System.out.println("\n--- HASTA PRONTO ---");
					sc.close();
					break;
				}
				default: {
					System.out.println("\nError: elegir entre 0-5");
				}
			}
		} while(opcion != 0);
	}
	
	private void addAlumno() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			System.out.print("\nNombre del alumno: ");
			String nombre = sc.nextLine().toUpperCase().trim();
			if (isAlumno(nombre)) {
				System.out.println("\nEl alumno ya existe");
				return;
			}
			System.out.print("Nota del alumno: ");
			String nota = Double.toString(getNotaCorrecta());
			bw.write(nombre + ":" + nota + "\n");	
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
	}
	
	private void setNota() {
		File temporal = new File(pathTemporal);
		File fichero = new File(path);
		try (BufferedReader br = new BufferedReader(new FileReader(path));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(pathTemporal))) {
			System.out.print("\nNombre del alumno: ");
			String nombre = sc.nextLine().toUpperCase().trim();
			if (isAlumno(nombre)) {
				String linea;
				while((linea = br.readLine()) != null) {
					String[] part = linea.split(":");
					if (part[0].equals(nombre)) {
						System.out.println("Nota actual: " + part[1]);
						System.out.print("Nueva nota: ");
						String nota = Double.toString(getNotaCorrecta());
						bw.write(nombre + ":" + nota + "\n");
					} else {
						bw.write(linea + "\n");
					}
				}	
			} else {
				System.out.println("\nNo existe alumno con el nombre: " + nombre);
				return;
			}
			
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
		if (fichero.delete() && temporal.renameTo(fichero)) {
			System.out.println("\nFichero modificado correctamente");
		} else {
			System.out.println("\nError al modificar el fichero");
		}
	}
	
	private void deleteAlumno() {
		File temporal = new File(pathTemporal);
		File fichero = new File(path);
		try (BufferedReader br = new BufferedReader(new FileReader(path));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(pathTemporal))) {
			System.out.print("\nNombre del alumno: ");
			String nombre = sc.nextLine().toUpperCase().trim();
			if (isAlumno(nombre)) {
				String linea;
				while((linea = br.readLine()) != null) {
					String[] part = linea.split(":");
					if (part[0].equals(nombre)) {
						System.out.println("Alumno con nombre: " + nombre + " eliminado correctamente");
						continue;
					} else {
						bw.write(linea + "\n");
					}
				}	
			} else {
				System.out.println("\nNo existe alumno con el nombre: " + nombre);
				return;
			}
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
		if (fichero.delete() && temporal.renameTo(fichero)) {
			System.out.println("\nFichero modificado correctamente");
		} else {
			System.out.println("\nError al modificar el fichero");
		}
	}
	
	private void getTodosAlumnos() {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] part = linea.split(":");
				System.out.println("Nombre: " + part[0] + " Nota: " + part[1]);
			}	
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
	}
	
	private void getAlumno() {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			System.out.print("\nNombre del alumno: ");
			String nombre = sc.nextLine().toUpperCase().trim();
			if (isAlumno(nombre)) {
				String linea;
				while((linea = br.readLine()) != null) {
					String[] part = linea.split(":");
					if (part[0].equals(nombre)) {
						System.out.println("Nombre: " + part[0] + " Nota: " + part[1]);
						break;
					}
				}	
			} else {
				System.out.println("\nNo existe alumno con el nombre: " + nombre);
			}
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
	}
	
	private boolean isAlumno(String nombre) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] part = linea.split(":");
				if (part[0].equals(nombre)) {
					return true;
				}
			}
		} catch (IOException e) {
			System.out.println("\nError: " + e.getLocalizedMessage());
		}
		return false;
	}
	
	private double getNotaCorrecta() {
		boolean error;
		double nota;
		do {
			error = false;
			nota = getDouble();
			if (nota < 0 || nota > 10) {
				System.out.println("\nError: la nota tiene que estar comprendida entre 0.0-10.0");
				error = true;
			}
		} while (error);
		return nota;
	}
	
	private int getMenuOpcion() {
		System.out.println("""
				
				┌─────────────────────┐
				│  FICHERO CON NOTAS  │
				└─────────────────────┘
				1.- Añadir alumno
				2.- Modificar nota
				3.- Eliminar alumno y nota
				4.- Mostrar todos
				5.- Mostrar un alumno
				0.- Salir.
				""");
		System.out.print("Opción: ");
		int opcion = getInt();
		return opcion;
	}
	
	private int getInt() {
		boolean error;
		int entero = -1;
		do {
			error = true;
			try {
				String s = sc.nextLine();
				entero = Integer.parseInt(s);
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("\nError - tiene que ser un número");
			} catch (Exception e) {
				System.out.println("\nError: " + e.getLocalizedMessage());
			}
		} while(error);
		return entero;
	}
	
	private double getDouble() {
		boolean error;
		double decimal = -1;
		do {
			error = true;
			try {
				String s = sc.nextLine();
				decimal = Double.parseDouble(s);
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("\nError - tiene que ser un número");
			} catch (Exception e) {
				System.out.println("\nError: " + e.getLocalizedMessage());
			}
		} while(error);
		return decimal;
	}
	
}
