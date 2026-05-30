package prueba_clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		switchPrincipal();
	}
	
	// Método switch principal.
	public static void switchPrincipal() {
		// Decalaración de variables.
		int opcion, opcion2;
		String text;
		
		// Creación de objetos.
		Scanner sc = new Scanner(System.in);
		Persona p = new Persona("Petro", "Pelenskyy");
		Coche c = new Coche();
		
		// Creación de listas.
		ArrayList<Coche> listaCoches = new ArrayList<>();
		ArrayList<Persona> listaPersonas = new ArrayList<>();
		//ss
		// Instrucciones.
		do {
			mostrarMenuPrincipal();
			opcion = getEntero(sc);
			switch (opcion) {
			// 1.|- Alta persona / coche.  
			case 1:
				do {
					text = " |1.|- Alta persona.                                |\n |2.|- Alta coche.                                  |";
					mostrarMenuSecundario(text);
					opcion2 = getEntero(sc);
					if (opcion2 == 1) {
						
					}
					else if (opcion2 == 1) {
						
					}
					else System.out.println("Elegir entre [0 y 2]");
				} while (opcion2 != 0);
				break;
				
			// 2.|- Baja persona / coche.  
			case 2:
				text = " |1.|- Baja persona.                                |\n |2.|- Baja coche.                                  |";
				mostrarMenuSecundario(text);
				break;
			
			// 3.|- Mostrar personas / coches. 
			case 3:
				text = " |1.|- Mostrar personas.                            |\n |2.|- Mostrar coches.                              |";
				mostrarMenuSecundario(text);
				break;
			
			// 4.|- Modificar persona / coche.  
			case 4:
				text = " |1.|- Mostrar personas.                            |\n |2.|- Modificar coche.                             |";
				mostrarMenuSecundario(text);
				break;
			
			// 5.|- Asignar / desasignar coche.
			case 5:
				text = " |1.|- Asignar coche.                               |\n |2.|- Desasignar coche.                            |";
				mostrarMenuSecundario(text);
				break;
				
			// 0.- Salir.
			case 0:
				break;
			default:
				System.out.println("Elegir entre [0 y 5]");
			}
		} while(opcion != 0);
		System.out.println("¡Hasta pronto!");
		
	}
	
	// Método para mostrar menú principal.
	public static void mostrarMenuPrincipal() {
		separar();
		System.out.println(" [             === MENÚ PRINCIPAL===                ]");
		System.out.println(" ┌──────────────────────────────────────────────────┐");
		System.out.println(" |1.|- Alta persona / coche.                        |");
		System.out.println(" |2.|- Baja persona / coche.                        |");
		System.out.println(" |3.|- Mostrar personas / coches.                   |");
		System.out.println(" |4.|- Modificar persona / coche.                   |");
		System.out.println(" |5.|- Asignar / desasignar coche.                  |");
		System.out.println(" |0.|- Salir.                                       |");
		System.out.println(" └──────────────────────────────────────────────────┘");
		System.out.print(" Entrada: ");
	}
	
	// Método para mostrar menú secundario.
	public static void mostrarMenuSecundario(String text) {
		separar();
		System.out.println(" [            === MENÚ SECUNDARIO ===               ]");
		System.out.println(" ┌──────────────────────────────────────────────────┐");
		System.out.println(text);
		System.out.println(" |0.|- Salir.                                       |");
		System.out.println(" └──────────────────────────────────────────────────┘");
		System.out.print(" Entrada: ");
	}
	
	// Método para revisar que se introduzca número entero. OK.
	public static int getEntero(Scanner sc) {
		// Decalaración de variables.
		int entero;
		
		// Instrucciones.
		while (!sc.hasNextInt()) {
			separar();
			System.out.print("¡Tiene que ser un numero entero!: ");
			sc.next();
		}
		entero = sc.nextInt();
		sc.nextLine();
		return entero;
	}
	
	// Método para separar visualmente en consola.
	public static void separar() {
		System.out.println();
	}
	
}
