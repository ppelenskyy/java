package figuras_geometricas;

import java.util.Scanner;

public class Gestion {
	private Scanner sc = new Scanner(System.in);
	private final String CYAN = "\u001B[36m", GREEN = "\u001B[32m", RESET = "\u001B[0m";
	
	protected Gestion() {
		
	}
	
	/*
	 * Método para mostrar menú de Figuras.
	 */
	private int getMenu() {
		int option;
		System.out.printf("""
					
		┌────────────────────────┐
		│  %sFIGURAS GEOMÉTRICAS%s   │
		└────────────────────────┘
		  1. - Cuadrado
		  2. - Rectángulo
		  3. - Triángulo
		  4. - Círculo
		 ────────────────────────
		  0. - Salir
		└────────────────────────┘
		""",CYAN,RESET);
		System.out.print(" Opción: ");
		option = isInt();
		return option;
	}
	
	/*
	 * Método para mostrar menú Área / Perímetro.
	 */
	private int getMenuAP() {
		int option;
		System.out.printf("""
		
								
		┌────────────────────────┐
		│    %sÁREA / PERÍMETRO%s    │
		└────────────────────────┘
		  1. - Área
		  2. - Perímetro
		 ────────────────────────
		  0. - Salir
		└────────────────────────┘
		""",CYAN,RESET);
		System.out.print(" Opción: ");
		option = isInt();
		return option;
	}
	
	/*
	 * Método para elegir la figura.
	 */
	protected void switchMain() {
		int option;
		Figura f;
		
		do {
			option = getMenu();
			
			switch(option) {
				// 1.- Cuadrado.
				case 1: {
					System.out.println("\n----- CUADRADO -----");
					System.out.print("Introducir la longitud de un lado (cm): ");
					double lado = isDouble();
					f = new Cuadrado(lado);
					switchAP(f);
					break;
				}
				
				// 2.- Rectángulo.
				case 2: {
					System.out.println("\n----- RECTÁNGULO -----");
					System.out.print("Introducir la longitud de la base (cm): ");
					double base = isDouble();
					System.out.print("Introducir la longitud de la altura (cm): ");
					double altura = isDouble();
					f = new Rectangulo(base, altura);
					switchAP(f);
					break;
				}
				
				// 3.- Triángulo.
				case 3: {
					System.out.println("\n----- TRIÁNGULO -----");
					System.out.print("Introducir la longitud del lado 1 (cm): ");
					double lado1 = isDouble();
					System.out.print("Introducir la longitud del lado 2 (cm): ");
					double lado2 = isDouble();
					System.out.print("Introducir la longitud del lado 3 (cm): ");
					double lado3 = isDouble();
					f = new Triangulo(lado1, lado2, lado3);
					switchAP(f);
					break;
				}
				
				// 4.- Círculo.
				case 4: {
					System.out.println("\n----- CÍRCULO -----");
					System.out.print("Introducir el radio del círculo (cm): ");
					double radio = isDouble();
					f = new Circulo(radio);
					switchAP(f);
					break;
				}
				
				// 0.- Salir.
				case 0: {
					break;
				}
				
				default: {
					System.out.println("\nElegir entre [0-4]");
					break;
				}
			}
		} while (option != 0);	
	}
	
	/*
	 * Método para elegir entre Área y Perímetro.
	 */
	private void switchAP(Figura f) {
		int option;
	
		do {
			option = getMenuAP();
			
			switch(option) {
				// 1.- Área.
				case 1: {
					double area = f.calcularArea();
					System.out.printf("%nÁrea = %s%.2f%s cm²",GREEN,area,RESET);
					break;
				}
				
				// 2.- Perímetro.
				case 2: {
					double perimetro = f.calcularPerimetro();
					System.out.printf("%nPerímetro = %s%.2f%s cm",GREEN,perimetro,RESET);	
					break;
				}
				
				// 0.- Atras.
				case 0: {
					break;
				}
				
				default: {
					System.out.println("Elegir entre [0-2]");
					break;
				}
			}
		} while (option != 0);	
	}
	
	/*
	 * Método para revisar si se introduce un número entero.
	 */
	protected int isInt() {
		int i;
		while(!sc.hasNextInt()) {
			System.out.print("Error introducir un número entero: ");
			sc.nextLine();
		}
		i = sc.nextInt();
		sc.nextLine();		
		return i;
	}
	
	/*
	 * Método para revisar si se introduce un número double.
	 */
	protected double isDouble() {
		double d;
		while(!sc.hasNextDouble()) {
			System.out.print("Error introducir un número: ");
			sc.nextLine();
		}
		d = sc.nextDouble();
		sc.nextLine();	
		return d;
	}
}
