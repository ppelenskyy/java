package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Cuenta {
	// Atributos.
	protected final double CANTIDAD = 0.0;
	private String CONTRASEÑA = "root";
	protected double cantidad;
	protected String titular;
	private String contraseña;
	
	// Métdodos contructores.
	public Cuenta() {
		
	}
	public Cuenta(String titular) {
		this.titular = titular;
		cantidad = CANTIDAD;
	}
	
	public Cuenta(String titular , double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	
	// Getters and Setters.
	protected double getCantidad() {
		return cantidad;
	}

	protected void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	protected String getTitular() {
		return titular;
	}

	protected void setTitular(String titular) {
		this.titular = titular;
	}
	
	// Método toString.
	@Override
	public String toString() {
		return "Cuenta cantidad = " + cantidad + " €, titular = " + titular + "]";
	}
	
	//-------------------------------------------------------------------------------------------------
	// Métodos especiales.
	//-------------------------------------------------------------------------------------------------
	
	// ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
	protected void ingresar(double cantidad) {
		if (cantidad < 0) System.out.println("La cantidad a ingresar no puede ser negativa");
		else {
			this.cantidad += cantidad;
			System.out.println(cantidad+" € ingeresado/s correctamente.");
			System.out.println("Nuevo saldo disponible: "+this.cantidad+" €");	
		}
	}
	
	// retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.
	protected void retirar(double cantidad) {
		if ((this.cantidad - cantidad) < 0) System.out.println("No hay saldo suficiente");
		else {
			this.cantidad -= cantidad;
			System.out.println(cantidad+" € retirado/s correctamente.");
			System.out.println("Nuevo saldo disponible: "+this.cantidad+" €");	
		}
	}
	
	// transferir(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.
	protected void transferir(double cantidad) {
		if ((this.cantidad - cantidad) < 0) System.out.println("No hay saldo suficiente");
		else {
			this.cantidad -= cantidad;
			System.out.println(cantidad+" € transferidos/s correctamente.");
			System.out.println("Nuevo saldo disponible: "+this.cantidad+" €");	
		}
	}
	
	//-------------------------------------------------------------------------------------------------
	// Métodos adicionales.
	//-------------------------------------------------------------------------------------------------
	
	protected void switchUser(Scanner sc, ArrayList<Cuenta> listaUsuarios, Cuenta user) {
		short opcion;
		double dinero;
		
		do {
			mostrarMenuUser();
			opcion = (short)revisarEntero(sc);

			switch(opcion) {
				// 1.- Ingresar dinero.
				case 1: {
					System.out.println("\n[   INGRESAR DINERO   ]");
					System.out.print("Cantidad: ");
					dinero = revisarDouble(sc);
					user.ingresar(dinero);
					break;
				}
				
				// 2.- Retirar dinero.
				case 2: {
					System.out.println("\n[   RETIRAR DINERO   ]");
					System.out.print("Cantidad: ");
					dinero = revisarDouble(sc);
					user.retirar(dinero);
					break;
				}
				
				// 3.- Realizar una transferencia.
				case 3: {
					System.out.println("\n[   REALIZAR UNA TRANSFERENCIA   ]");
					int indx = comprobarExisteUser(sc, listaUsuarios);
					if (indx == -1 || indx == -2) return; 
					break;
				}
				
				case 0: {
					break;
				}
				
				default: {
					System.out.println("Elegir entre [0-3]");
					break;
				}
			}	
		} while (opcion != 0);	
	}
	
	protected void switchAdmin(Scanner sc, ArrayList<Cuenta> listaUsuarios, Cuenta user) {
		short opcion;
		
		do {
			mostrarMenuAdmin();
			opcion = (short)revisarEntero(sc);

			switch(opcion) {
				// 1.- Añadir cuenta bancaria.
				case 1: {
					anadirUser(sc, listaUsuarios, user);
					break;
				}
				
				// 2.- Eliminar cuenta bancaria.
				case 2: {
					eliminarUser(sc, listaUsuarios);
					break;
				}
				
				// 3.- Modificar cuenta bancaria.
				case 3: {	
					modificarUser(sc, listaUsuarios);
					break;
				}
				
				// 0.- Salir.
				case 0: {
					break;
				}
				
				default: {
					System.out.println("Elegir entre [0-3]");
					break;
				}
			}	
		} while (opcion != 0);	
	}
	
	// Método para añadir cuenta.
	private void anadirUser(Scanner sc, ArrayList<Cuenta> listaUsuarios, Cuenta user) {
		System.out.println("[   AÑADIR CUENTA BANCARIA   ]");	
		listaUsuarios.add(user);
		System.out.print("Nombre del titular: ");
		user.setTitular(sc.nextLine());
		System.out.println("¡Usuarios añadido correctamente!");
	}
	
	// Método para eliminar cuenta.
	private void eliminarUser(Scanner sc, ArrayList<Cuenta> listaUsuarios) {
		System.out.println("[   ELIMINAR CUENTA BANCARIA   ]");
		int indx = comprobarExisteUser(sc, listaUsuarios);
		if (indx == -1 || indx == -2) return;
		listaUsuarios.remove(indx);
		System.out.println("¡Usuarios eliminado correctamente!");
	}
	
	// Método para modificar cuenta.
	private void modificarUser(Scanner sc, ArrayList<Cuenta> listaUsuarios) {
		String nombre;

		System.out.println("[   MODIFICAR CUENTA BANCARIA   ]");
		int indx = comprobarExisteUser(sc, listaUsuarios);
		if (indx == -1 || indx == -2) return;
		Cuenta user = listaUsuarios.get(indx);
		System.out.println("Nombre actual del titular: "+user.getTitular());
		System.out.print("Nuevo nombre del titular: ");
		nombre = sc.nextLine();
		user.setTitular(nombre);
		System.out.println("Cantidad actual: "+user.getCantidad());
		System.out.print("Nueva cantidad: ");
		user.setCantidad(revisarDouble(sc));
		System.out.println("¡Usuarios modificado correctamente!");
	}
	
	// Método para comprobar si existe el usuario.
	protected int comprobarExisteUser(Scanner sc, ArrayList<Cuenta> listaUsuarios) {
		boolean existe = false;
		String nombre;
		
		if (listaUsuarios.size() == 0) {
			System.out.println("¡Lista de usuarios está vacia!");
			return -1;
		}
		
		System.out.println(listaUsuarios.size());
		
		for (Cuenta i: listaUsuarios) {
			System.out.println("PRUEBA");
			System.out.println(i.getTitular());
		}
		
		System.out.print("Introducir nombre del titular: ");
		nombre = sc.nextLine();
		
		for (Cuenta i: listaUsuarios) {
			if(i.getTitular().equalsIgnoreCase(nombre)) {
				System.out.println("Titular encontrado");
				existe = true;
				return listaUsuarios.indexOf(i);
			}
		}	
	
		if(!existe) 
			System.out.println("¡Titular no encontrado!");
		return -2;
	}
	
	// Método comprobar contraseña del administrador.
	protected boolean comprobarAdmin(String contraseña) {
		this.contraseña = CONTRASEÑA;
		if (contraseña.equals(this.contraseña)) {
			System.out.println("Contraseña correcta.");
			return true;
		}
		else {
			System.out.println("Contraseña incorrecta.");
			return false;
		}
	}
	
	// Método para revisar entero.
	protected int revisarEntero(Scanner sc) {
		int e;
		
		while(!sc.hasNextInt()) {
			System.out.print("Tieneque ser un número entero: ");
			sc.next();
		}
		e = sc.nextInt();
		sc.nextLine();

		return e;
	}
	
	// Método para revisar double.
	protected double revisarDouble(Scanner sc) {
		double d;
		
		while(!sc.hasNextDouble()) {
			System.out.print("Tieneque ser un número entero: ");
			sc.next();
		}
		d = sc.nextDouble();
		sc.nextLine();

		return d;
	}
	
	// Método para mostrar menú banco.
	protected void mostrarMenuBanco() {
		System.out.println("  ┌─────────────────────┐");
		System.out.println("  │        BANCO        │");
		System.out.println("  └─────────────────────┘");
		System.out.println("1.- Acceso administradores.");
		System.out.println("2.- Acceso usuarios.");
		System.out.println("0.- Salir.");
		System.out.println("───────────────────────────");
		System.out.print("Opción: ");
	}
	
	// Método para mostrar menú administrador.
	private void mostrarMenuAdmin() {
		System.out.println("  ┌─────────────────────┐");
		System.out.println("  │  CUENTAS BANCARIAS  │");
		System.out.println("  ├─────────────────────┤");
		System.out.println("  │    ADMINISTRADOR    │");
		System.out.println("  └─────────────────────┘");
		System.out.println("1.- Añadir cuenta bancaria.");
		System.out.println("2.- Eliminar cuenta bancaria.");
		System.out.println("3.- Modificar cuenta bancaria.");
		System.out.println("0.- Salir.");
		System.out.println("───────────────────────────");
		System.out.print("Opción: ");
	}
	
	// Método para mostrar menú usuarios.
	private void mostrarMenuUser() {
		System.out.println("  ┌─────────────────────┐");
		System.out.println("  │   CUENTA BANCARIA   │");
		System.out.println("  ├─────────────────────┤");
		System.out.println("       "+titular);
		System.out.println("  └─────────────────────┘");
		System.out.println("1.- Ingresar dinero.");
		System.out.println("2.- Retirar dinero.");
		System.out.println("3.- Realizar una transferencia.");
		System.out.println("0.- Salir.");
		System.out.println("───────────────────────────");
		System.out.print("Opción: ");
	}
	
}
