package juegos;
import java.util.Scanner;

public class PiedraPapelTijera {
	public static final String RESET = "\u001B[0m", ROJO = "\u001B[31m", VERDE = "\u001B[32m", AMARILLO = "\u001B[33m", NEGRO = "\u001b[30m";
	public static final String pd = "PIEDRA", pp = "PAPEL ", tj = "TIJERA";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		menu(sc);
	}
	
	// Método para mostrar menú principal y elegir una de las opciones diponibles.
	public static void menu(Scanner sc) {
		// Declaración de variables.
		int opcion;
	
		// Instrucciones.
		do {
			mostrarMenu();
			opcion = revisarEntero(sc);
			if (opcion == 1) {
				jugar(sc);
			}
			else if (opcion == 0) {
				System.out.println("¡Hasta pronto!");
			}
			else System.out.println(ROJO+"Opción invalida elegir entre [0-3]"+RESET);	
		} while (opcion != 0);
	}
	
	// Método para jugar.
	public static void jugar(Scanner sc) {
		// Declaración de variables.
		String opcionJugador, opcionSistema;
		
		// Instrucciones.
		opcionSistema = opcion(sc, 0);
		System.out.println(opcionSistema);
		mostrarMenuPpt();
		opcionJugador = opcion(sc, 1);
		if (opcionJugador.equals(opcionSistema)) {
			System.out.println(" _____________________");
			System.out.println("| Jugador | ORDENADOR |");
			System.out.println("|---------------------|");	
			System.out.println("| "+opcionJugador+"  =  "+opcionSistema+"   |");
			System.out.println("|_____________________|");
			System.out.println(AMARILLO+"        EMPATE"+RESET);
		}
		else if (opcionJugador.equals(pd) && opcionSistema.equals(tj)) {
			System.out.println(" _____________________");
			System.out.println("| Jugador | ORDENADOR |");
			System.out.println("|---------------------|");	
			System.out.println("| "+opcionJugador+"  >  "+opcionSistema+"   |");
			System.out.println("|_____________________|");
			System.out.println(VERDE+"       VICTORIA"+RESET);
		}
		else if (opcionJugador.equals(tj) && opcionSistema.equals(pp)) {
			System.out.println(" _____________________");
			System.out.println("| Jugador | ORDENADOR |");
			System.out.println("|---------------------|");	
			System.out.println("| "+opcionJugador+"  >  "+opcionSistema+"   |");
			System.out.println("|_____________________|");
			System.out.println(VERDE+"       VICTORIA"+RESET);
		}
		else if (opcionJugador.equals(pp) && opcionSistema.equals(pd)) {
			System.out.println(" _____________________");
			System.out.println("| Jugador | ORDENADOR |");
			System.out.println("|---------------------|");	
			System.out.println("| "+opcionJugador+"  >  "+opcionSistema+"   |");
			System.out.println("|_____________________|");
			System.out.println(VERDE+"       VICTORIA"+RESET);
		}
		else {
			System.out.println(" _____________________");
			System.out.println("| Jugador | ORDENADOR |");
			System.out.println("|---------------------|");	
			System.out.println("| "+opcionJugador+"  <  "+opcionSistema+"   |");
			System.out.println("|_____________________|");
			System.out.println(ROJO+"       DERROTA"+RESET);
		}


	}
	
	// Método para obtener la opción.
	public static String opcion(Scanner sc, int i) {
		// Declaración de variables.
		boolean salir = false;
		int opcion;
		String ppt = null;
		
		// Instrucciones.
		if (i == 1) {
			do {
				opcion = revisarEntero(sc);
				if (opcion == 1) {					
					ppt = pd;
					salir = true;
				}
				else if (opcion == 2) {
					ppt = pp;
					salir = true;
				}
				else if (opcion == 3) {
					ppt = tj;
					salir = true;
				}
				else System.out.println(ROJO+"Opción invalida elegir entre [1-3]"+RESET);	
			} while(!salir);	
		}
		else {
			do {
				opcion = (int)(Math.random()*3)+1;
				if (opcion == 1) {
					ppt = pd;
					salir = true;
				}
				else if (opcion == 2) {
					ppt = pp;
					salir = true;
				}
				else if (opcion == 3) {
					ppt = tj;
					salir = true;
				}
				else System.out.println(ROJO+"Opción invalida elegir entre [1-3]"+RESET);	
			} while(!salir);		
		}
		return ppt;
	}
	
	// Método para visualizar menú.
	public static void mostrarMenuPpt() {
		System.out.println(" _____________________________");
		System.out.println("|       ---ELEGIR---          |");
		System.out.println("|   1. Piedra.                |");
		System.out.println("|   2. Papel.                 |");
		System.out.println("|   3. Tijera.                |");
		System.out.println("|_____________________________|");
		System.out.print(" Opcion: ");	
	}
	
	// Método para visualizar menú.
	public static void mostrarMenu() {
		System.out.println(" _____________________________");
		System.out.println("|  ---"+NEGRO+"PIEDRA PAPEL TIJERA"+RESET+"---  |");
		System.out.println("|   1. Jugar.                 |");
		System.out.println("|   0. Salir.                 |");
		System.out.println("|_____________________________|");
		System.out.print(" Opcion: ");	
	}
	
	// Método para revisar que se introduzca un número entero.
	public static int revisarEntero(Scanner sc) {
		// Declaración de variables.
		int entero;
		
		// Instrucciones.
		while (!sc.hasNextInt()) {
			System.out.print("Tiene que ser un número entero: ");
			sc.next();
		}
		entero = sc.nextInt();
		sc.nextLine();
		separar();
		return entero;
	}
	
	// Métod para separar visualmente en la consola.
	public static void separar() {
		System.out.println();
	}
}
