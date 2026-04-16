/*
 * Realiza una aplicación para la gestión de la biblioteca de la Universidad Europea.
 * En la biblioteca se tienen libros que se pueden alquilar durante un determinado tiempo por parte de los clientes.
 * La aplicación debe ofrecer un menú al empleado para poder realizar las siguientes tareas:
 * 1.- Insertar.
 * 2.- Eliminar.
 * 3.- Modificar.
 * 4.- Alquilar.
 * 5.- Devolver.
 * 6.- Salir.
 * Todos aquellos datos que no facilita el enunciado, debéis decidirlos vosotras/os.
 * Mucha suerte 
 */

import java.util.Scanner;

public class BibliotecaUem {
	
	// Método main.
	public static void main(String[] args) {
		// Declaración del Scanner.
		Scanner sc = new Scanner(System.in);
		// Punto de partida.
		switchMenu(sc);
	}

	// Método para imprimir el menú y llamar al método [switchMenu()]. 
	public static void menu() {
		separar();
		System.out.println("=== BIBLIOTECA UEM ===");
		System.out.println("1.- Insertar.");
		System.out.println("2.- Eliminar.");
		System.out.println("3.- Modificar.");
		System.out.println("4.- Alquilar.");
		System.out.println("5.- Devolver.");
		System.out.println("6.- Salir.");
		System.out.print("Entrada: ");
	}

	// Método switch principal. 
	public static void switchMenu(Scanner sc) {		
		// Declaración de variables locales y matriz.
		int opcion;
		final int COLUMNAS = 5; // 0-Título, 1-Autor, 2-Año de publicación, 3-ISBN y 4-DNI.
		final int FILAS = 5;
		String[][] matrizBiblioteca = new String[FILAS][COLUMNAS];
		
		// Instrucciones.
		do {
			menu();
			opcion = revisarEntero(sc);
			switch (opcion) {
			case 1:
				System.out.println("--- INSERTAR ---");
				insertar(sc, matrizBiblioteca);				
				break;
			case 2:
				System.out.println("--- ELIMINAR ---");
				eliminar(sc, matrizBiblioteca);				
				break;
			case 3:
				System.out.println("--- MODIFICAR ---");
				modificar(sc, matrizBiblioteca);				
				break;
			case 4:
				System.out.println("--- ALQUILAR ---");
				alquilar(sc, matrizBiblioteca);				
				break;
			case 5:
				System.out.println("--- DEVOLVER ---");
				devolver(sc, matrizBiblioteca);				
				break;
			case 6:
				break;
			default:
				System.out.println("Elegir un número entre 0-6: ");
				break;
			}
		} while (opcion != 6);
		System.out.println("¡Hasta pronto!");
	}
	
	// Método para insertar. 
	public static void insertar(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales.
		boolean libre = false, copia = false;
		int pos;
		String isbn, opcion;
		
		// Instrucciones.
		for (int i = 0; i < matrizBiblioteca.length && !copia; i++) {
			if (matrizBiblioteca[i][3] == null) {
				libre = true;
				System.out.print("ISBN: ");
				isbn = sc.nextLine().toUpperCase().trim();			
				for (int k = 0; k < matrizBiblioteca.length; k++) {
					if (matrizBiblioteca[k][3] != null && matrizBiblioteca[k][3].equals(isbn)) {	
						separar();
						copia = true;
						System.out.println("¡ISBN introducido ya existe!");		
						separar();
						do {
							System.out.print("¿Añadir mas copias del libro? [S/n]: ");
							opcion = sc.nextLine().toLowerCase().trim();
							separar();
							if (opcion.equals("s")) {	
								pos = k;
								insertarVarios(sc, matrizBiblioteca, pos);							
							}
							else if (opcion.equals("n")) break;
							else System.out.println("¡Elegir [S] o [n]!");
						} while (!(opcion.equals("s") || opcion.equals("n")));
						break;
					}
				}
				if (!copia) {	
				matrizBiblioteca[i][3] = isbn;
				System.out.print("Título: ");
				matrizBiblioteca[i][0] = sc.nextLine().toUpperCase().trim();
				System.out.print("Autor: ");
				matrizBiblioteca[i][1] = sc.nextLine().toUpperCase().trim();
				System.out.print("Año de publicación: ");
				matrizBiblioteca[i][2] = sc.nextLine().toUpperCase().trim();
				separar();
				System.out.println("Libro con título: "+matrizBiblioteca[i][0]+" añadido correctamente.");
				break;
				}
			}	
		}
		if (!libre) System.out.println("¡No hay espacios libres disponibles!");
	}
	
	// Método complementario para insertar copias multiples. 
	public static void insertarVarios(Scanner sc, String[][] matrizBiblioteca, int pos) {
		// Declaración de variables locales.
		int cantidad = 0, librosAñadidos = 0, opcion;
		
		// Instrucciones.
		for (int i = 0; i < matrizBiblioteca.length; i++) {			
			if (matrizBiblioteca[i][3] == null) {
				cantidad++;
			}
		}
		System.out.println("Espacios libres disponibles: "+cantidad);
		do {
			System.out.println("0.- Cancelar.");
			System.out.print("Entrada:  ");
			opcion = revisarEntero(sc);
			if (opcion == 0) break;
			else if (opcion > 0 && opcion <= cantidad) {
				for (int i = 0; i < matrizBiblioteca.length && opcion > 0; i++) {
					if (matrizBiblioteca[i][3] == null) {
						matrizBiblioteca[i][0] = matrizBiblioteca[pos][0];
						matrizBiblioteca[i][1] = matrizBiblioteca[pos][1];
						matrizBiblioteca[i][2] = matrizBiblioteca[pos][2];
						matrizBiblioteca[i][3] = matrizBiblioteca[pos][3];
						opcion--;
						librosAñadidos++;
					}
				} 
				System.out.println(librosAñadidos + " libro/s añadido/s correctamente.");
				break;
			}
			else {
				System.out.println("¡Espacios disponibles: " + cantidad + " introducir una cantidad igual o inferior!");
				separar();
			}		
		} while (opcion != 0);
	}

	// Método para eliminar. 
	public static void eliminar(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales.
		boolean salir = false, existe = false;
		int opcion;
		int d = 0, indice;
		int[] librosIsbn = new int[matrizBiblioteca.length];
		String isbn;
		
		// Instrucciones.
		do {
			System.out.println("1.- Eliminar uno. \n2.- Eliminar todos con el mismo ISBN. \n3.- Eliminar todos. \n0.- Salir.");
			System.out.print("Entrada: ");
			opcion = revisarEntero(sc);
			switch(opcion) {
			// 1.- Eliminar uno.
			case 1: 
				isbn = isbn(sc, matrizBiblioteca);
				if (isbn == null) break;
				System.out.println("--- Libros disponibles para poder eliminar ---");
				for (int i = 0; i < matrizBiblioteca.length; i++) {
					if (matrizBiblioteca[i][3] != null && matrizBiblioteca[i][3].equals(isbn)) {			
						librosIsbn[d] = i;
						System.out.println("Índice: "+d+".- Título: "+matrizBiblioteca[librosIsbn[d]][0]+" Autor: "+matrizBiblioteca[librosIsbn[d]][1]+" Año de publicación: "+matrizBiblioteca[librosIsbn[d]][2]+" ISBN: "+matrizBiblioteca[librosIsbn[d]][3]);
						d++;
					}
				}
				separar();
				do {
					System.out.println(d+".-Cancelar.");
					System.out.print("Entrada: ");
					indice = revisarEntero(sc);
					if (indice >= 0 && indice < d) {
						for (int i = 0; i < matrizBiblioteca[librosIsbn[indice]].length; i++) {
							matrizBiblioteca[librosIsbn[indice]][i] = null;
						}
						System.out.println("Libro con ISBN: "+isbn+" eliminado correctamente de la posición: "+librosIsbn[indice]);
						salir = true;
						break;
					}
					else if (indice == d) salir = true;
					else System.out.println("Índice incorrecto elegir entre [0-"+(d-1)+"]");
						
				} while(!salir);
				break;
	
			// 2.- Eliminar todos con el mismo ISBN.
			case 2: 
				isbn = isbn(sc, matrizBiblioteca);
				if (isbn != null) {
					System.out.println("--- Libros eliminados ---");
					for (int i = 0; i < matrizBiblioteca.length; i++) {
						if (matrizBiblioteca[i][3] != null && matrizBiblioteca[i][3].equals(isbn)) {			
							System.out.print("Indice: "+i+".- Título: "+matrizBiblioteca[i][0]+" Autor: "+matrizBiblioteca[i][1]+" Año de publicación: "+matrizBiblioteca[i][2]+" ISBN: "+matrizBiblioteca[i][3]);
							for (int k = 0; k < matrizBiblioteca[i].length; k++) {
								matrizBiblioteca[i][k] = null;
							}
							System.out.println(" eliminado correctamente!");
						}
					}
					salir = true;
					break;
				} 
				else {
					salir = true;
					break;
				}	
				
			// 3.- Eliminar todos.
			case 3: 
				for (int i = 0; i < matrizBiblioteca.length; i++) {
					for (int j = 0; j < matrizBiblioteca[i].length; j++) {
						if (matrizBiblioteca[i][0] != null) existe = true;
						matrizBiblioteca[i][j] = null;
					}
				}
				if (existe) System.out.println("¡Todos los libros eliminados correctamente!");
				else System.out.println("¡No hay libros en la lista!");
				salir = true;
				break;
			
			// 0.- Salir.
			case 0:
				break;
					
			default:
				System.out.println("¡Elegir entre [0-3]!");
				separar();	
				break;
			}
		} while (opcion != 0 && !salir);
	}
		
	// Método para modificar. 
	public static void modificar(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales y arrays.
		boolean cancelar = false;
		int indice, d = 0, nd = 0;
		String isbn;
		int[] arrayDisponibles = new int[matrizBiblioteca.length];
		int[] arrayNoDisponibles = new int[matrizBiblioteca.length];
		
		// Instrucciones.
		isbn = isbn(sc, matrizBiblioteca);
		if (isbn == null) return;
		for (int i = 0; i < matrizBiblioteca.length; i++) {
			if (matrizBiblioteca[i][3] != null && matrizBiblioteca[i][3].equals(isbn) && matrizBiblioteca[i][4] == null) {
				arrayDisponibles[d] = i;
				d++;
			} 
			else if (matrizBiblioteca[i][3] != null && matrizBiblioteca[i][3].equals(isbn) && matrizBiblioteca[i][4] != null) {
				arrayNoDisponibles[nd] = i;
				nd++;
			}
		}
		if (nd > 0) {
			System.out.println("--- Libros no disponibles porque están alquilados ---");
			for (int i = 0; i < nd; i++) {
				System.out.println(i+".- Título: "+matrizBiblioteca[arrayNoDisponibles[i]][0]+" Autor: "+matrizBiblioteca[arrayNoDisponibles[i]][1]+" Año de publicación: "+matrizBiblioteca[arrayNoDisponibles[i]][2]+" ISBN: "+matrizBiblioteca[arrayNoDisponibles[i]][3]+" DNI: "+matrizBiblioteca[arrayNoDisponibles[i]][4]);
			}
			separar();
		}
		if (d > 0) {
			System.out.println("--- Libros disponibles para poder modificar ---");
			for (int i = 0; i < d; i++) {
				System.out.println(i+".- Título: "+matrizBiblioteca[arrayDisponibles[i]][0]+" Autor: "+matrizBiblioteca[arrayDisponibles[i]][1]+" Año de publicación: "+matrizBiblioteca[arrayDisponibles[i]][2]+" ISBN: "+matrizBiblioteca[arrayDisponibles[i]][3]);
			}
			separar();
			do {
				System.out.println(d+".-Cancelar.");
				System.out.print("Entrada: ");
				indice = revisarEntero(sc);
				if (indice >= 0 && indice < d) {
					System.out.println("Título anterior: "+matrizBiblioteca[indice][0]);
					System.out.print("Título nuevo: ");
					matrizBiblioteca[indice][0] = sc.nextLine().toUpperCase().trim();
					System.out.println("Autor anterior: "+matrizBiblioteca[indice][1]);
					System.out.print("Autor nuevo: ");
					matrizBiblioteca[indice][1] = sc.nextLine().toUpperCase().trim();
					System.out.println("Año de publicación anterior: "+matrizBiblioteca[indice][2]);
					System.out.print("Año de publicación nuevo: ");
					matrizBiblioteca[indice][2] = sc.nextLine().toUpperCase().trim();
					System.out.println("ISBN anterior: "+matrizBiblioteca[indice][3]);
					System.out.print("ISBN nuevo: ");
					matrizBiblioteca[indice][3] = sc.nextLine().toUpperCase().trim();
					break;
				}
				else if (indice == d) {
					cancelar = true;
					break; 	
				}
				else System.out.println("Índice incorrecto elegir entre [0-"+d+"]");
			} while (!cancelar);
		}
	}

	// Método para alquilar. 
	public static void alquilar(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales.
		boolean disponible = false;
		String isbn;
		
		// Instrucciones.
		isbn = isbn(sc, matrizBiblioteca);
		if (isbn == null) return;
		for (int i = 0; i < matrizBiblioteca.length; i++) {
			if (matrizBiblioteca[i][3] != null && matrizBiblioteca[i][3].equals(isbn)) {
				if (matrizBiblioteca[i][4] == null) {
					System.out.print("Libro disponible introducir DNI para alquilarlo: ");
					matrizBiblioteca[i][4] = sc.nextLine().toUpperCase().trim();
					disponible = true;
					break;
				} 
			} 
		}
		if (!disponible) System.out.println("¡No hay libros disponibles!");	
	}
	
	// Método para devolver.
	public static void devolver(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales.
		int al = 0;
		int [] arrayLibros = new int [matrizBiblioteca.length];
		String dni;
		
		// Instrucciones.
		dni = dni(sc, matrizBiblioteca);
		if (dni == null) return;
		for (int i = 0; i < matrizBiblioteca.length; i++) {
			if (matrizBiblioteca[i][4] != null && matrizBiblioteca[i][4].equals(dni)) {
				arrayLibros[al] = i;
				al++;
			} 
		}
		devolverDisponibles(sc, arrayLibros, al, matrizBiblioteca, dni);	
	}
	
	// Método complementario para devolver libros (disponibles).
	public static void devolverDisponibles(Scanner sc, int[] arrayLibros, int al, String[][] matrizBiblioteca, String dni) {	
		// Declaración de variables locales.
		boolean salir = false;
		String opcion;
		int indice;
		
		// Instrucciones.
		System.out.println("--- Libros alquilados por el DNI introducido ---" );
		for (int i = 0; i < al; i++) {	
			System.out.println("Índice: "+i+".- Título: "+matrizBiblioteca[arrayLibros[i]][0]+" Autor: "+matrizBiblioteca[arrayLibros[i]][1]+" Año de publicación: "+matrizBiblioteca[arrayLibros[i]][2]+" ISBN: "+matrizBiblioteca[arrayLibros[i]][3]);	
		}
		separar();
		System.out.println(al + ".- Devolver todos.");
		System.out.println((al + 1) + ".- Cancelar.");
		do {
			System.out.print("Entrada: ");	
			indice = revisarEntero(sc);
			if (indice >= 0 && indice < al) {
				matrizBiblioteca[arrayLibros[indice]][4] = null;
				System.out.println("Libro con ISBN: " + matrizBiblioteca[arrayLibros[indice]][3] + " está devuelto correctamente.");
				al--;
				if (al > 0) {
					do {
						System.out.print("¿Deseas devolver otro libro? [S/n]: ");
						opcion = sc.nextLine().toLowerCase().trim();
						if (opcion.equals("s")) {
							devolver(sc, matrizBiblioteca);
							break;
						}
						else if (opcion.equals("n")) {
							salir = true;
							break;
						}
						else {
							System.out.println("¡Elegir entre [S] o [n]!");
							separar();
						}
					} while (!(opcion.equals("s") || opcion.equals("n")));	
					break;		
				}
				else {
					break;
				}
			}	
			else if (indice == al) {
				for (int i = 0; i < al; i++) {
					matrizBiblioteca[arrayLibros[i]][4] = null;
					System.out.println("Libro con ISBN: " + matrizBiblioteca[arrayLibros[i]][3] + " está devuelto correctamente.");
				}
				break;
			}
			else if (indice == al + 1) {
				break;	
			}
			else System.out.println("Índice incorrecto elegir entre [0-"+(al + 1)+"]");	 
		} while(!salir);
	}
	
	// ------------------------------------------------------------------
	
	// Método para introducir ISBN (existente).
	public static String isbn(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales.
		boolean existe = false;
		String isbn;
		
		// Instrucciones.
		System.out.print("Introducir el ISBN: ");
		isbn = sc.nextLine().toUpperCase().trim();
		separar();
		for (int i = 0; i < matrizBiblioteca.length; i++) {		
			if (matrizBiblioteca[i][3] != null && matrizBiblioteca[i][3].equals(isbn)) {
				existe = true;
				break;
			}
		}
		if (!existe) {
			isbn = null;
			System.out.println("¡No existe ISBN introducido!");
		}
		return isbn;
	}
	
	// Método para introducir DNI (existente).
	public static String dni(Scanner sc, String[][] matrizBiblioteca) {
		// Declaración de variables locales y array.
		boolean existe = false;
		String dni;
	
		// Instrucciones.
		System.out.print("Introducir el DNI: ");
		dni = sc.nextLine().toUpperCase().trim();
		separar();
		for (int i = 0; i < matrizBiblioteca.length; i++) {
			if (matrizBiblioteca[i][4] != null && matrizBiblioteca[i][4].equals(dni)) {
				existe = true;
				break;
			} 
		}
		if (!existe) {
			System.out.println("¡El DNI introducido no tiene ningún libro alquilado!");
			dni = null;
		}
		return dni;
	}
	
	// Método para revisar que el número introducido sea un número entero.
	public static int revisarEntero(Scanner sc) {
		// Declaración de variables locales.
		int opcion;
		
		// Instrucciones.
		while (!sc.hasNextInt()) {
			System.out.print("Tiene que ser un número entero: ");
			sc.next();
		}
		opcion = sc.nextInt();
		sc.nextLine();
		separar();
		return opcion;
	}

	// Método para separar visualmente en la consola.
	public static void separar() {
		System.out.println();
	}
}
