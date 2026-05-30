/* Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).
 * 
 * El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla lo anterior.
 * 
 * Crea sus métodos get, set y toString.
 * 
 * Tendrá dos métodos especiales:
 * ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
 * retirar(double cantidad): se retira una cantidad a la cuenta,si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.
 * 
 * Tarea extra:
 * Como tenemos dos cuentas, comprobar primero el titular para poder ingresar, retirar o ver saldo.
 * Añadir la opción de transferencia bancaria.
 * Añadir la opción de ingresar o eliminar cuentas bancarias.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// Declaración del Scanner y creación de ArrayList.
		Scanner sc = new Scanner(System.in);
		ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
		
		// Creación de dos objetos Cuenta.
		Cuenta userA = new Cuenta("Silicon", 1993.32);
		listaCuentas.add(userA);
		Cuenta userB = new Cuenta("David", -150);
		listaCuentas.add(userB);
		
		// Instrucciones.
		switchBanco(sc, listaCuentas);
	}
	
	// Método para el switch.
	protected static void switchBanco(Scanner sc, ArrayList<Cuenta> listaCuentas) {
		short opcion;
		int indx;
		double dinero;
		
		do {
			mostrarMenuBanco();
			opcion = sc.nextShort();
			sc.nextLine();

			switch(opcion) {
				// 1.- Añadir cuenta bancaria.
				case 1: {
					anadirCuenta(sc, listaCuentas);
					break;
				}
				
				// 2.- Eliminar cuenta bancaria.
				case 2: {
					eliminarCuenta(sc, listaCuentas);
					break;
				}
				
				// 3.- Ingresar dinero.
				case 3: {
					System.out.println("\n[   INGRESAR DINERO   ]");
					indx = comprobarExisteCuenta(sc, listaCuentas);
					if (indx == -1 || indx == -2) break; 
					dinero = listaCuentas.get(indx).getCantidad();
					System.out.printf("Dinero disponible: %.2f%n",dinero);
					System.out.print("Cantidad: ");
					dinero = sc.nextDouble();
					sc.nextLine();
					listaCuentas.get(indx).ingresar(dinero);
					break;
				}
				
				// 4.- Retirar dinero.
				case 4: {
					System.out.println("\n[   RETIRAR DINERO   ]");
					indx = comprobarExisteCuenta(sc, listaCuentas);
					if (indx == -1 || indx == -2) break; 
					dinero = listaCuentas.get(indx).getCantidad();
					System.out.printf("Dinero disponible: %.2f%n",dinero);
					System.out.print("Cantidad: ");
					dinero = sc.nextDouble();
					sc.nextLine();
					listaCuentas.get(indx).retirar(dinero);
					break;
				}
				
				// 5.- Realizar una transferencia.
				case 5: {
					Cuenta userA, userB;
					
					System.out.println("\n[   REALIZAR UNA TRANSFERENCIA   ]");
					System.out.println("ORIGEN");
					indx = comprobarExisteCuenta(sc, listaCuentas);
					if (indx == -1 || indx == -2) break;
					userA = listaCuentas.get(indx);
					
					System.out.println("DESTINO");
					indx = comprobarExisteCuenta(sc, listaCuentas);
					if (indx == -1 || indx == -2) break;
					userB = listaCuentas.get(indx);
					
					transferenciaBancaria(sc, userA, userB);
					break;
				}
				
				// 0.- Salir;
				case 0: {
					System.out.println("<<<<<<<<<<<<< ¡Hasta Pronto! >>>>>>>>>>>>>");
					break;
				}
				
				default: {
					System.out.println("Elegir entre [0-5]");
					break;
				}
			}	
		} while (opcion != 0);	
	}
	
	// Método para añadir cuenta.
	protected static void anadirCuenta(Scanner sc, ArrayList<Cuenta> listaCuentas) {
		String titular;
		
		System.out.println("\n[   AÑADIR CUENTA BANCARIA   ]");		
		System.out.print("Nombre del titular: ");
		titular = sc.nextLine();
		listaCuentas.add(new Cuenta(titular));
		System.out.printf("¡Cuenta con nombre del titular: %s creada correctamente!",titular);
	}
	
	// Método para eliminar cuenta.
	protected static void eliminarCuenta(Scanner sc, ArrayList<Cuenta> listaCuentas) {
		int indx;
		String titular;
		
		System.out.println("\n[   ELIMINAR CUENTA BANCARIA   ]");
		indx = comprobarExisteCuenta(sc, listaCuentas);
		if (indx == -1 || indx == -2) return;
		titular = listaCuentas.get(indx).getTitular();
		listaCuentas.remove(indx);
		System.out.printf("¡Cuenta %s eliminada correctamente!",titular);
	}
	
	// Método para comprobar si existe la cuenta.
	protected static int comprobarExisteCuenta(Scanner sc, ArrayList<Cuenta> listaCuentas) {
		boolean existe = false;
		String nombre;
		
		if (listaCuentas.size() == 0) {
			System.out.println("¡Lista de cuentas está vacia!");
			return -1;
		}

		System.out.print("Introducir nombre del titular: ");
		nombre = sc.nextLine();
		
		for (Cuenta i: listaCuentas) {
			if(i.getTitular().equalsIgnoreCase(nombre)) {
				existe = true;
				return listaCuentas.indexOf(i);
			}
		}	
	
		if(!existe) 
			System.out.println("¡Nombre del titular no existe!");
		return -2;
	}
	
	// Método para mostrar menú banco.
	protected static void mostrarMenuBanco() {
		System.out.println("\n  ┌─────────────────────┐");
		System.out.println("  │        BANCO        │");
		System.out.println("  └─────────────────────┘");
		System.out.println("1.- Añadir cuenta bancaria.");
		System.out.println("2.- Eliminar cuenta bancaria.");
		System.out.println("3.- Ingresar dinero.");
		System.out.println("4.- Retirar dinero.");
		System.out.println("5.- Realizar una transferencia.");
		System.out.println("0.- Salir.");
		System.out.println("───────────────────────────");
		System.out.print("Opción: ");
	}
	
	// Método para realizar una transferencia.
	protected static void transferenciaBancaria(Scanner sc, Cuenta userA, Cuenta userB) {
		double dineroA, dineroB, cantidadT;
		dineroA = userA.getCantidad();
		dineroB = userB.getCantidad();
		
		System.out.printf("Dinero disponible: %.2f%n",dineroA);
		System.out.print("Introducir la cantidad a transferir: ");
		cantidadT = sc.nextDouble();
		sc.nextLine();
		if ((dineroA - cantidadT) < 0) {
			System.out.println("No hay saldo suficiente");
			return;
		}
		else {
			userA.setCantidad(dineroA-cantidadT);
			System.out.printf("%.2f € transferidos/s correctamente.%n",cantidadT);
			dineroA = userA.getCantidad();
			System.out.printf("Nuevo saldo disponible: %.2f €%n",dineroA);
			userB.setCantidad(dineroB+cantidadT);
		}
	}

}
