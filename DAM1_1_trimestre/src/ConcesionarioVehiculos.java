/*
 * La aplicación debe ofrecer un menú al usuario para poder realizar las siguientes tareas:
 * 1.- Insertar vehículo.
 * 2.- Eliminar el vehículo y dejar dicho hueco vacío.
 * 3.- Modificar vehículo.
 * 4.- Salir.
 * El ejercicio debe de controlar que no se repiten matrículas dentro del array.
 * Una vez terminado el ejercicio podemos añadir funcionalidades. 
 * Por ejemplo realizar la venta de un vehículo a un cliente con su DNI, mostrar vehículos para la venta disponibles,
 * mostrar los vehículos vendidos, mostrar los vehículos de un cliente en concreto,......Si tenéis dudas me decís, un saludo.
 */

import java.util.Scanner;

public class ConcesionarioVehiculos {

	public static void main(String[] args) {
		// Declarar Scanner.
		Scanner sc = new Scanner(System.in);

		// Declarar variables, constantes y matrizes.
		int opcion, contador = 0;
		final int FILAS = 2;
		final int COLUMNAS = 5; // MATRÍCULA, MARCA, MODELO, PRECIO, DNI
		String matrizV[][] = new String[FILAS][COLUMNAS];
		String eliminar, matricula, marca, modelo, precio, dni, opcion2, opcion3;
		boolean salir = false, existe = false;

		// Bucle principal.
		do {
			System.out.println("=== MENÚ ===");
			System.out.println("1-. Insertar vehículo.");
			System.out.println("2-. Eliminar el vehículo y dejar dicho hueco vacío.");
			System.out.println("3-. Modificar vehículo.");
			System.out.println("4-. Vender vehículo.");
			System.out.println("5-. Mostrar vehículos disponibles.");
			System.out.println("6-. Mostrar vehículos vendidos.");
			System.out.println("7-. Mostrar vehículo/s de un cliente.");
			System.out.println("0-. Salir.");
			System.out.print("Entrada: ");

			// Comprobar si el número introducido es número entero.
			while (!sc.hasNextInt()) {
				System.out.print("¡Tiene que ser un número entero!: ");
				sc.next();
			}

			// Guardar el número entero.
			opcion = sc.nextInt();
			System.out.println();

			// Switch principal.
			switch (opcion) {
			// 1-. Insertar vehículo.
			case 1:
				contador = 0;
				existe = false;
				salir = false;
				System.out.println("--- Insertar vehículo ---");
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][0] == null) {
						System.out.print("Introducir la Matrícula: ");
						matricula = sc.next().trim().toUpperCase();
						for (int k = 0; k < matrizV.length; k++) {
							if (matrizV[k][0] != null && matrizV[k][0].equals(matricula)) {
								salir = true;
								break;
							}
						}
						if (salir) {
							System.out.println();
							System.out.println("¡La matrícula introducida ya existe!");
							break;
						}
						matrizV[i][0] = matricula;
						System.out.print("Introducir la Marca: ");
						matrizV[i][1] = sc.next().trim().toUpperCase();
						System.out.print("Introducir el Modelo: ");
						matrizV[i][2] = sc.next().trim().toUpperCase();
						System.out.print("Introducir el Precio: ");
						matrizV[i][3] = sc.next().trim().toUpperCase();
						System.out.println();
						System.out.println("El vehículo con la matrícula: " + matrizV[i][0] + " marca: " + matrizV[i][1] + " modelo: " + matrizV[i][2] + " precio: " + matrizV[i][3] + " € " + " está correctamente creado en la fila: " + i);
						break;
					} 
					else {
						contador ++;
						if (contador == matrizV.length) {
							existe = true;
						}
					}
				}				
				if (existe) System.out.println("¡La tabla está completa!");
				System.out.println();
				break;

			// 2-. Eliminar el vehículo y dejar dicho hueco vacío.
			case 2:
				contador = 0;
				existe = false;
				System.out.println("--- Eliminar el vehículo y dejar dicho hueco vacío ---");
				System.out.print("Introducir la matrícula del vehículo para elimanrlo: ");
				eliminar = sc.next().trim().toUpperCase();
				System.out.println();
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][0] != null && matrizV[i][0].equals(eliminar)) {
						for (int k = 0; k < matrizV[i].length; k++) {
							matrizV[i][k] = null;
						}
						System.out.println("El vehículo con la matrícula: " + eliminar + " está correctamente eliminado de la fila: " + i);
						break;
					} 
					else {
						contador ++;
						if (contador == matrizV.length) {
							existe = true;
						}
					}						
				}
				if (existe) System.out.println("¡Matrícula no encontrada!");
				System.out.println();
				break;

			// 3-. Modificar vehículo.
			case 3:
				contador = 0;
				existe = false;
				System.out.println("--- Modificar vehículo ---");
				System.out.print("Introducir la matrícula del vehículo para modificarlo: ");
				matricula = sc.next().trim().toUpperCase();
				System.out.println();
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][0] != null && matrizV[i][0].equals(matricula)) {
						do {
							System.out.println("--- MODIFICACIONES DISPONIBLES ");
							System.out.println("a-. Modificar Matrícula.");
							System.out.println("b-. Modificar Marca.");
							System.out.println("c-. Modificar Modelo.");
							System.out.println("d-. Modificar Precio.");
							System.out.println("e-. Modificar DNI.");
							System.out.println("x-. Atras.");
							System.out.print("Entrada: ");
							opcion3 = sc.next().trim().toLowerCase();
							System.out.println();
							switch (opcion3) {
							// a-. Modificar Matrícula.
							case "a":
								existe = false;
								System.out.println("Matrícula actual: " + matrizV[i][0]);
								System.out.print("Introducir nueva matrícula: ");
								matricula = sc.next().trim().toUpperCase();
								System.out.println();
								for (int k = 0; k < matrizV.length; k++) {
									if (k == i)
										continue;
									if (matrizV[k][0] != null && matrizV[k][0].equals(matricula)) {
										existe = true;
										break;
									}
								}
								if (existe)
									System.out.println("¡La matrícula introducida ya existe!");
								else {
									matrizV[i][0] = matricula;
									System.out.println("Matrícula modificada correctamente, nuevo valor: " + matrizV[i][0]);
								}
								System.out.println();
								break;

							// b-. Modificar Marca.
							case "b":
								System.out.println("Marca actual: " + matrizV[i][1]);
								System.out.print("Introducir nueva marca: ");
								marca = sc.next().trim().toUpperCase();
								matrizV[i][1] = marca;
								System.out.println();
								System.out.println("Marca modificada correctamente, nuevo valor: " + matrizV[i][1]);
								System.out.println();
								break;

							// c-. Modificar Modelo.
							case "c":
								System.out.println("Modelo actual: " + matrizV[i][2]);
								System.out.print("Introducir nuevo modelo: ");
								modelo = sc.next().trim().toUpperCase();
								matrizV[i][2] = modelo;
								System.out.println();
								System.out.println("Modelo modificado correctamente, nuevo valor: " + matrizV[i][2]);
								System.out.println();
								break;

							// d-. Modificar Precio.
							case "d":
								System.out.println("Precio actual: " + matrizV[i][3]);
								System.out.print("Introducir nuevo precio: ");
								precio = sc.next().trim().toUpperCase();
								matrizV[i][3] = precio;
								System.out.println();
								System.out.println("Precio modificado correctamente, nuevo valor: " + matrizV[i][3] + " €");
								System.out.println();
								break;

							// e-. Modificar DNI.
							case "e":
								if (matrizV[i][4] == null) System.out.println("DNI actual: VACIO");
								else System.out.println("DNI actual: " + matrizV[i][4]);
								System.out.print("Introducir nuevo DNI: ");
								dni = sc.next().trim().toUpperCase();
								matrizV[i][4] = dni;
								System.out.println();
								System.out.println("DNI modificado correctamente, nuevo valor: " + matrizV[i][4]);
								System.out.println();
								break;

							// x-. Atras.
							case "x":
								break;

							// Opción por defecto.
							default:
								System.out.println();
								System.out.println("¡Opción incorrecta elegir entre 'a','b','c','d' ó 'x'!: ");
								break;
							}
						} while (!opcion3.equals("x"));
						break;
					} 
					else {
						contador ++;
						if (contador == matrizV.length) {
							existe = true;
						}
					}						
				}
				if (existe) System.out.println("¡Matrícula no encontrada!");
				System.out.println();
				break;

			// 4-. Vender vehículo.
			case 4:
				contador = 0;
				existe = false;
				System.out.println("--- Vender el vehículo ---");
				System.out.print("Introducir la matrícula: ");
				matricula = sc.next().trim().toUpperCase();
				System.out.println();
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][0] != null && matrizV[i][0].equals(matricula) && matrizV[i][4] == null) {
						System.out.println("- El vehículo está disponible -");
						System.out.print("matrícula: " + matrizV[i][0] + " marca: " + matrizV[i][1] + " modelo: " + matrizV[i][2]);
						System.out.println(", el precio del vehículo es de: " + matrizV[i][3] + " €");
						do {
							System.out.print("¿Deseas continuar? (s/n): ");
							opcion2 = sc.next().trim().toLowerCase();
							System.out.println();
							switch (opcion2) {
							case "s":
								System.out.print("Introducir el DNI: ");
								matrizV[i][4] = sc.next().trim().toUpperCase();
								System.out.println("¡La venta se ha realizado correctamente!");
								System.out.println("El vehículo con la matrícula: " + matrizV[i][0] + " ahora pertenece al DNI: " + matrizV[i][4]);
								break;

							case "n":
								break;

							default:
								System.out.println("¡Opción incorrecta elegir entre (s/n)!: ");
								break;
							}
						} while (!(opcion2.equals("s") || opcion2.equals("n")));
						break;
					}
					else if (matrizV[i][0] != null && matrizV[i][0].equals(matricula) && matrizV[i][4] != null) {
						System.out.println("El vehículo con matrícula: " + matrizV[i][0] + " está vendido al DNI: " + matrizV[i][4]);
						break;
					}
					else {
						contador ++;
						if (contador == matrizV.length) {
							existe = true;
						}
					}						
				}
				if (existe) System.out.println("¡Matrícula no encontrada!");
				System.out.println();
				break;

			// 5-. Mostrar vehículos disponibles.
			case 5:
				existe = false;
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][4] == null && matrizV[i][0] != null) {
						if (!existe) {
							System.out.println("- Vehículos disponibles -");
							existe = true;
						}
						System.out.println("matrícula: " + matrizV[i][0] + " marca: " + matrizV[i][1] + " modelo: " + matrizV[i][2] + " precio: " + matrizV[i][3] + " €");
					}
				}
				if (!existe) System.out.println("¡No hay vehículos disponibles!");
				System.out.println();
				break;

			// 6-. Mostrar vehículos vendidos.
			case 6:
				existe = false;
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][4] != null && matrizV[i][0] != null) {
						if (!existe) {
							System.out.println("- Vehículos vendidos -");
							existe = true;
						}
						System.out.println("matrícula: " + matrizV[i][0] + " marca: " + matrizV[i][1] + " modelo: " + matrizV[i][2] + " precio: " + matrizV[i][3] + " €" + " DNI: " + matrizV[i][4]);
					}
				}
				if (!existe) System.out.println("¡No hay vehiculos vendidos!");
				System.out.println();
				break;

			// 7-. Mostrar vehículo/s de un cliente.
			case 7:
				existe = false;
				System.out.print("Introducir el DNI: ");
				dni = sc.next().trim().toUpperCase();
				System.out.println();
				for (int i = 0; i < matrizV.length; i++) {
					if (matrizV[i][4] != null && matrizV[i][4].equals(dni)) {
						if (!existe) {
							System.out.println("- Al DNI: " + dni + " le pertenecen los siguientes vehículos -");
							existe = true;
						}
						System.out.println("matrícula: " + matrizV[i][0] + " marca: " + matrizV[i][1] + " modelo: " + matrizV[i][2]);
					}
				}
				if (!existe) System.out.println("¡El DNI: " + dni + " no tiene ningún vehículo asociado!");
				System.out.println();
				break;

			// 0-. Salir.
			case 0:
				break;

			// Opción por defecto.
			default:
				System.out.println("¡Valor incorrecto, elegir entre 0 y 7!");
				System.out.println();
				break;
			}
		} while (opcion != 0); // Condición para salir del bucle principal.

		// Mensaje de despedida.
		System.out.println("¡Hasta pronto!");

		// Cerrar el Scanner.
		sc.close();
	}

}
