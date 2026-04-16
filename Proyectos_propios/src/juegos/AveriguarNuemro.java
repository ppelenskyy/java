package juegos;
import java.util.Scanner;

public class AveriguarNuemro {
	public static final String RESET = "\u001B[0m";
	public static final String ROJO  = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m"; 
	
	// Método main.
	public static void main(String[] args) {
		// Declaración del Scanner.
		Scanner sc = new Scanner(System.in);
		
		// Llamada al menú principal.
		menu(sc);
	}
	
	// Método para mostrar menú principal y elegir una de las opciones diponibles.
	public static void menu(Scanner sc) {
		// Declaración de variables.
		int opcion;
		int max = 10;
		int intentos = 5;
		String dificultad = "Facil  ";
	
		// Instrucciones.
		do {
			mostrarMenu();
			opcion = revisarEntero(sc);
			if (opcion == 1) {
				if (max == 10) {
					dificultad = "Facil  ";
					intentos = 5;
				}
				else if (max == 20) {
					dificultad = "Media  ";
					intentos  = 7;
				}
				else {
					dificultad = "Dificil";
					intentos  = 10;
				}
				jugar(sc, max, intentos, dificultad);
			}
			else if (opcion == 2) {
				max = dificultad(sc);
			}
			else if (opcion == 3) {
				reglas();
			}
			else if (opcion == 0) {
				System.out.println("--- ¡Hasta pronto! ---");
			}
			else System.out.println(ROJO+"Opción invalida elegir entre [0-3]"+RESET);	
		} while (opcion != 0);
	}
	
	// Opción 1. Método para jugar.
	public static void jugar(Scanner sc, int max, int intentos, String dificultad) {
		// Declaración de variables.
		boolean victoria = false;
		final int NUMERO = (int)(Math.random()*max)+1;
		int numeroIntroducido;
		int contador = intentos;
		
		// Instrucciones.
		System.out.println(" ___________________________");
		System.out.println("|       ---JUGAR---         |");
		System.out.println("|   Dificultad: "+dificultad+"     |");
		System.out.println("|   Números de: 1-"+max+"        |");
		if (intentos > 9) {
			System.out.println("|   Intentos: "+intentos+"            |");
		}
		else {
			System.out.println("|   Intentos: "+intentos+"             |");
		}
		System.out.println("|___________________________|");
		
		do {
			System.out.print("Introducir un número: ");	
			numeroIntroducido = revisarEntero(sc);
			if (numeroIntroducido == NUMERO) {
				System.out.println(VERDE+"¡Victoria! el número secreto era: "+RESET+NUMERO);
				victoria = true;
			}
			else if (numeroIntroducido > NUMERO) {
				System.out.println(ROJO+"¡Demasiado grande!"+RESET);
				contador -= 1;
				if (contador == 1) System.out.println(AMARILLO+"¡ULTIMO INTENTO!"+RESET);
				else System.out.println(AMARILLO+"Intentos restantes: "+contador+RESET);
				separar();
			}
			else {
				System.out.println(AZUL+"¡Demasiado pequeño!"+RESET);
				contador -= 1;
				if (contador == 1) System.out.println(AMARILLO+"¡ULTIMO INTENTO!"+RESET);
				else System.out.println(AMARILLO+"Intentos restantes: "+contador+RESET);
				separar();
			}
		} while (contador != 0 && !victoria);
		if (contador == 0) System.out.println(ROJO+"PARTIDA PERDIDA"+RESET);
		separar();
		System.out.println("Intentos utilizados: "+(intentos-contador));
	}
	
	// Opción 2. Método elegir dificultad.
	public static int dificultad(Scanner sc) {
		int dificultad = 7;
		int opcion; 
		System.out.println(" _________________________________");
		System.out.println("|   ---Dificultad del Juego---    |");
		System.out.println("|   1. Facil   - número de 1-10   |");
		System.out.println("|   2. Media   - número de 1-20   |");
		System.out.println("|   3. Dificil - número de 1-50   |");
		System.out.println("|_________________________________|");
		System.out.print(" Opcion: ");
		do {
			opcion = revisarEntero(sc);
			if (opcion == 1) {
				dificultad = 10;
				break;
			}
			else if (opcion == 2) {
				dificultad = 20;
				break;
			}
			else if (opcion == 3) {
				dificultad = 50;
				break;
			}
			else System.out.print(ROJO+"Elegir entre [1-3]: "+RESET);	
		} while (true);

		return dificultad;
	}
	
	// Opción 3. Método para mostrar reglas del juego.
	public static void reglas() {
		System.out.println(" ________________________________________________");
		System.out.println("|                 ---REGLAS---                   |");
		System.out.println("|- El programa elige un número fijo.             |");
		System.out.println("|- El programa dice:                             |");
		System.out.println("|    “Demasiado grande”                          |");
		System.out.println("|    “Demasiado pequeño”                         |");
		System.out.println("|- El juego termina cuando el jugador acierta.   |");
		System.out.println("|- Al final se muestra cuántos intentos ha usado.|");
		System.out.println("|________________________________________________|");
	}
	
	// Método para mostrar visualmente el menú.
	public static void mostrarMenu() {
		System.out.println(" _____________________________");
		System.out.println("| ---JUEGO ADIVINAR NÚMERO--- |");
		System.out.println("|   1. Jugar.                 |");
		System.out.println("|   2. Dificultad.            |");
		System.out.println("|   3. Reglas.                |");
		System.out.println("|   0. Salir.                 |");
		System.out.println("|_____________________________|");
		System.out.print(" Opcion: ");
	}
	
	// Método para revisar que se introduzca un número entero.
	public static int revisarEntero(Scanner sc) {
		int entero;
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
