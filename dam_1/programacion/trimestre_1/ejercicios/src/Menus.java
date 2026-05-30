/*
 * 1.- Realiza un programa que permite realizar las siguientes tareas:
 * 
 * a.- Dado un número por teclado debe indicar si es par o impar.
 * 
 * b.- Elaborar un programa para calcular el sueldo de un trabajador, a partir de las horas trabajadas en la semana y la clase a la que pertenece:
 * 
 * Trabajadores de clase “A”, se les paga 25 euros por hora.
 * Trabajadores de clase “B”, se paga 20 euros por hora.
 * Trabajadores de clase “C”, se les paga 15 euros por hora y
 * Trabajadores de clase “D”, 10 euros por hora.
 * Ingresar el número de horas trabajadas y la clase a la que pertenece, y a continuación, devuelve el sueldo del trabajador. Debes de usar constantes para cada clase.
 * 
 * c.- Escribe un programa que calcule el precio final de un producto según su base imponible (precio antes de impuestos), el tipo de IVA aplicado (general, reducido o superreducido) y el código promocional.
 * Los tipos de IVA general, reducido y superreducido son del 21%, 10% y 4% respectivamente. 
 * Los códigos promocionales pueden ser nopro, mitad, meno5 o 5porc que significan, 
 * respectivamente, que no se aplica promoción, el precio se reduce a la mitad, se descuentan 5 euros o se descuenta el 5%. 
 * 
 *  Ejemplo:
 *  Introduzca la base imponible: 25
 *  Introduzca el tipo de IVA (general, reducido o superreducido): reducido
 *  Introduzca el código promocional (nopro, mitad, meno5 o 5porc): mitad
 *  Base imponible        25.00
 *  IVA (10%)              2.50
 *  Precio con IVA        27.50
 *  Cód. promo. (mitad): -13.75
 *  TOTAL                 13.75
*/

import java.util.Scanner;

public class Menus {

	public static void main(String[] args) {
		
		// Declaración de scanner.
		Scanner sc = new Scanner(System.in);
		
		// Declaración de variables y constantes.
		String iva, prom;
		int opcion, opcion2, num1;
		double horas, calculo, base, ivaResult = 0, ivaBase, ivaCon, total;
		final int A = 25, B = 20, C = 15, D = 10;
		
		// Bucle principal para elegir una de 4 opciones disponible.
		do {
			System.out.println("=== MENÚ DEL PROGRAMA ===");
			System.out.println("1-. Revisar un número si es Par/Impar.");
			System.out.println("2-. Cálcular el sueldo por horas trabajadas.");
			System.out.println("3-. Precio final de un producto.");
			System.out.println("0-. Salir.");
			
			// Comprobar que el número introducido sea un número entero.
			while(!sc.hasNextInt()) {
				System.out.print("¡Tiene que ser un número entero!: ");
				sc.next();
			}
			
			// Cuando la comprobacion es correcta se guarda el resultado en la variable 'opcion'.
			opcion = sc.nextInt(); 
			
			switch(opcion) {
				
			// Opción 1 Revisar número Par/Imar.
			case 1:	
				System.out.println("== Revisar número Par/Impar ==");
				System.out.print("Número: ");
					
				// Comprobar que el número introducido sea un número entero.
			    	
				while(!sc.hasNextInt()) {						
					System.out.print("¡Tiene que ser un número entero!: ");	
					sc.next();
				}
					
			    // Cuando la comprobacion es correcta se guarda el resultado en la variable 'num1'.
			    num1 = sc.nextInt();
			        
			    // Se realiza la comprobación del 'num1' si el resto de división del num1 / 2 = 0, entonces es par; si no, es impar.
			    if (num1 % 2 == 0) {
			    	System.out.println("Número " + num1+" es par.");
			    }
			    else {
			        System.out.println("Número " + num1 + " es impar.");
			    }
			    System.out.println();
			    break;
					
			// Opción 2 Cálcular el sueldo por horas trabajadas.
			case 2:
	
				// Bucle para elegir la clase.
				do {
					System.out.println("== Calcular el sueldo ==");
					System.out.println("1-. clase A (25€/h).");
					System.out.println("2-. clase B (20€/h).");
					System.out.println("3-. clase C (15€/h).");
					System.out.println("4-. clase D (10€/h).");
					System.out.println("0-. Atras.");
					System.out.print("Elegir clase: ");
					
					// Comprobar que el número introducido sea un número entero.
					while (!sc.hasNextInt()) {
						System.out.println("¡Tiene que ser un número entero!");
						System.out.print("Elegir clase: ");
						sc.next();
					}
					
					// Cuando la comprobacion es correcta se guarda el resultado en la variable 'opcion2'.
					opcion2 = sc.nextInt();
				
					switch (opcion2) {
						
					// Si se elige opción '1' esta equivale a la Clase A.
					case 1:
						System.out.println("Ingrese el número de horas trabajadas: ");
							
						// Comprobar que el número introducido sea un número.
						while (!sc.hasNextDouble()) {
							System.out.print("¡Tiene que ser un número!: ");
							sc.next();
						}
							
						// Cuando la comprobacion es correcta se guarda el resultado en la variable 'horas'.
						horas = sc.nextDouble();
							
						// Se realiza el cálculo.
						calculo = horas * A;
						System.out.println("El sueldo por " + horas + " horas trabajadas, es de " + calculo + " euros.");
						System.out.println();
						break;
							
						// Si se elige opción '2' esta equivale a la Clase B.
					case 2:
						System.out.println("Ingrese el número de horas trabajadas: ");
							
						// Comprobar que el número introducido sea un número.
						while (!sc.hasNextDouble()) {
							System.out.print("¡Tiene que ser un número!: ");
							sc.next();
						}
							
						// Cuando la comprobacion es correcta se guarda el resultado en la variable 'horas'.
						horas = sc.nextDouble();
							
						// Se realiza el cálculo.
						calculo = horas * B;
						System.out.println("El sueldo por " + horas + " horas trabajadas, es de " + calculo + " euros.");
						System.out.println();
						break;
							
						// Si se elige opción '3' esta equivale a la Clase C.	
					case 3:
						System.out.println("Ingrese el número de horas trabajadas: ");
							
						// Comprobar que el número introducido sea un número.
						while (!sc.hasNextDouble()) {
							System.out.print("¡Tiene que ser un número!: ");
							sc.next();
						}
							
						// Cuando la comprobacion es correcta se guarda el resultado en la variable 'horas'.
						horas = sc.nextDouble();
						
						// Se realiza el cálculo.
						calculo = horas * C;
						System.out.println("El sueldo por " + horas + " horas trabajadas, es de " + calculo + " euros.");
						System.out.println();
						break;
						
						// Si se elige opción '4' esta equivale a la Clase D.
					case 4:
						System.out.println("Ingrese el número de horas trabajadas: ");
							
						// Comprobar que el número introducido sea un número.
						while (!sc.hasNextDouble()) {
							System.out.print("¡Tiene que ser un número!: ");
							sc.next();
						}
							
						// Cuando la comprobacion es correcta se guarda el resultado en la variable 'horas'.
						horas = sc.nextDouble();
							
						// Se realiza el cálculo.
						calculo = horas * D;
						System.out.println("El sueldo por " + horas + " horas trabajadas, es de " + calculo + " euros.");
						System.out.println();
						break;
				
						// Si se elige opción '0' se sale del switch.		
					case 0:
						break;
					
					default:
						System.out.println("Tiene que ser un numero de 0-4");
						System.out.println();
						break;
					}
				
				// Cuando 'opcion2 = 0' se termina el bucle para elegir clase, porque la condición es false.
				} while (opcion2 != 0);
				System.out.println();
				
				// Se sale de la opción 2 volviendo al bucle principal.
				break;
					
			// Opción 3 Cálcular el precio final de un producto.
			case 3:
				System.out.println("Introduzca la base imponible: ");
					
				// Comprobar que el número introducido sea un número.
				while (!sc.hasNextDouble()) {
					System.out.print("¡Tiene que ser un número!: ");
					sc.next();
				}
					
				// Cuando la comprobación es correcta se guarda el resultado en la variable 'base'.
				base = sc.nextDouble();
					
				// Se ejecuta el bucle para elegir el tipo del IVA.
				do {
					System.out.println("Introduzca el tipo de IVA (general, reducido o superreducido): ");
						
					// Se pide el texto, se guarda en 'iva' y se convierte a minúsculas.
					iva = sc.next().toLowerCase();
						
					switch (iva) {
					
					// Si se escribe "general", entonces se guarda el número '21' en variable 'ivaResult'.	
					case ("general"):
						ivaResult = 21;
						break;
					
					// Si se escribe "reducido", entonces se guarda el número '10' en variable 'ivaResult'.		
					case ("reducido"):
						ivaResult = 10;
						break;
					
					// Si se escribe "superreducido", entonces se guarda el número '4' en variable 'ivaResult'.	
					case ("superreducido"):
						ivaResult = 4;
						break;
					
					// Si se escribe otro texto diferente se ejecuta el 'default'.	
					default:		
						System.out.println("¡Error! - elegir entre (general, reducido ó superreducido): ");
						System.out.println();	
					}
					
				// Se sigue ejecutando el bucle del IVA hasta que el 'iva' no sea igual a uno de los siguientes valores (general, reducido ó superreducido).
				} while (!(iva.equals("general") || iva.equals("reducido") || iva.equals("superreducido")));
				
				// Se ejecuta el bucle para elegir el tipo de promoción.	
				do {	
					System.out.println("Introduzca el código promocional (nopro, mitad, meno5 o 5porc): ");
					prom = sc.next();
					
					switch (prom) {
	
					case ("nopro"):
						System.out.printf(" Base imponible          %.2f €%n", base);
						System.out.printf(" IVA %.2f%%              %.2f €%n", ivaResult, ivaBase = (base * (ivaResult/100)));
						System.out.printf(" Precio con IVA          %.2f €%n", ivaCon = (base + ivaBase));
						System.out.printf(" Cód. promo. %s:     -0,0 €%n", prom);
						System.out.printf(" TOTAL                   %.2f €%n", ivaCon);
						break;
					
					case ("mitad"):
						System.out.printf(" Base imponible          %.2f €%n", base);
						System.out.printf(" IVA %.2f%%              %.2f €%n", ivaResult, ivaBase = (base * (ivaResult/100)));
						System.out.printf(" Precio con IVA          %.2f €%n", ivaCon = (base + ivaBase));
						System.out.printf(" Cód. promo. %s:     -%.2f €%n", prom, total = (ivaCon / 2));
						System.out.printf(" TOTAL                   %.2f €%n", total);
						break;
					
					case ("meno5"):
						System.out.printf(" Base imponible          %.2f €%n", base);
						System.out.printf(" IVA %.2f%%              %.2f €%n", ivaResult, (ivaBase = (base * (ivaResult/100))));
						System.out.printf(" Precio con IVA          %.2f €%n", ivaCon = (base + ivaBase));
						System.out.printf(" Cód. promo. %s:    	-5 €%n", prom);
						System.out.printf(" TOTAL                  3 %.2f €%n", total = ivaCon - 5);
						break;
							
					case ("5porc"):
						System.out.printf(" Base imponible           %.2f €%n", base);
						System.out.printf(" IVA %.2f%%               %.2f €%n", ivaResult , (ivaBase = (base * (ivaResult/100))));
						System.out.printf(" Precio con IVA           %.2f €%n", (ivaCon = (base + ivaBase)));
						System.out.printf(" Cód. promo. %s:      -%.2f €%n", prom, total = (ivaCon * 0.05));
						System.out.printf(" TOTAL                    %.2f €%n", ivaCon - total);
						break;
						
					default:		
						System.out.println("¡Error! - elegir entre (nopro, mitad, meno5 ó 5proc): ");
						System.out.println();	
					}
					
				// Se sigue ejecutando el bucle de promoción hasta que el 'prom' no sea igual a uno de los siguientes valores (nopro, mitad, meno5 ó 5proc).
				} while (!(prom.equals("nopro") || prom.equals("mitad") || prom.equals("meno5") || prom.equals("5porc")));
 
				System.out.println();
				
				// Se termina Opción 3 Cálcular el precio final de un producto.
				break;					
			
			// Opcíon 0 Salir del switch.
			case 0:
				System.out.println();
				break;
			}
		// Cuando 'opcion = 0' se termina el bucle principal porque la condición es false.
		} while(opcion != 0);
		System.out.println("¡Hasta Pronto!");
		sc.close();
	}
}
