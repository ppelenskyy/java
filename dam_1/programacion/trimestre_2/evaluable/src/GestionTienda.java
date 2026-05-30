import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para poder realizar todas las funcionalidades disponibles en el programa.
 */
public class GestionTienda {
	// Scanner global para tenerlo disponible en todos los métodos de la clase sin pasarlo como parámetro.
	private Scanner sc = new Scanner(System.in);
	
	// ArrayList crear dos listas para almacenar objetos de tipo Cliente y Tablet.
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ArrayList<Tablet> listaTablets = new ArrayList<Tablet>();
	
	// Constructor por defecto.
	protected GestionTienda() {	
	}
	
	/**
	 * Método switch principal es llamado por la clase Main.
	 */
	protected void switchMenu() {
		int opcion;
		do {
			opcion = mostrarMenuPrincipal();
			switch(opcion) {
				// 1.- Dar de alta una tablet. 
				case 1: {
					altaTablet();
					break;
				}
				// 2.- Dar de alta un cliente. 
				case 2: {
					altaCliente();
					break;
				}
				// 3.- Vender una tablet a un cliente.
				case 3: {
					venderTablet();
					break;
				}
				// 4.- Mostrar tablets disponibles para la venta.
				case 4: {
					tabletDisponible();
					break;
				}
				// 5.- Mostrar tablets compradas por un cliente en concreto.
				case 5: {
					tabletVendida();
					break;
				}
				// 6.- Salir
				case 6: {
					System.out.println("─────────── ¡Hasta Pronto! ───────────");
					break;
				}
				default:{
					System.out.println("\nOpción incorrecta elegir entre [1-6]");
					break;
				}				
			} 
		} while(opcion != 6);
	}
	
	/**
	 * Método para dar de alta a un una tablet nueva.
	 */
	private void altaTablet() {
		boolean existe;
		double precio;
		String marca, modelo, color;
		Tablet t;
		System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄         ALTA TABLET         ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.print("\nIntroducir Marca: ");
		marca = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir Modelo: ");
		modelo = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir Color: ");
		color = sc.nextLine().toUpperCase().trim();
		existe = existeTablet(marca, modelo, color);
		if (existe) {
			System.out.println("\nYa existe una tablet con los mismos datos");
			return;
		}
		System.out.print("Introducir Precio: ");
		precio = comprobarDouble();
		t = new Tablet(marca, modelo, color, precio);
		listaTablets.add(t);
		System.out.println("\n"+t.toString()+" dada de alta correctamente.");
	}

	/**
	 * Método para dar de alta a un cliente nuevo.
	 */
	private void altaCliente() {
		boolean existeCliente;
		String dni, nombre, apellidos;
		Cliente cl;		
		System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄         ALTA CLIENTE        ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		dni = generarDni();
		existeCliente = existeCliente(dni);
		if (existeCliente) {
			System.out.println("\nYa existe un cliente con el mismo DNI");
			return;
		}
		System.out.print("Introducir Nombre: ");
		nombre = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir Apellidos: ");
		apellidos = sc.nextLine().toUpperCase().trim();
		cl = new Cliente(dni, nombre, apellidos);
		listaClientes.add(cl);	
		System.out.println("\n"+cl.toString()+" creado correctamente.");
	}
	
	/**
	 * Método para vender una tablet a un cliente.
	 */
	private void venderTablet() {
		boolean existeTablet, existeCliente;
		String marca, modelo, color, dni;
		System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄        VENDER TABLET        ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		if (listaTablets.isEmpty()) {
			System.out.println("\nNo hay Tablets en la lista de tablets");
			return;
		}
		if (listaClientes.isEmpty()) {
			System.out.println("\nNo hay Clientes en la lista de clientes");
			return;
		}
		System.out.print("\nIntroducir Marca: ");
		marca = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir Modelo: ");
		modelo = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir Color: ");
		color = sc.nextLine().toUpperCase().trim();
		existeTablet = existeTablet(marca, modelo, color);
		if (!existeTablet) {
			System.out.println("\nNo existe tablet con los datos introducidos");
			return;
		}
		for (Tablet t: listaTablets) {
			if (t.getMarca().equals(marca) && t.getModelo().equals(modelo) && t.getColor().equals(color) && t.getDniComprador().equals("00000000Z")) {
				dni = generarDni();
				existeCliente = existeCliente(dni);
				if (!existeCliente) {
					System.out.println("\nNo existe cliente con el DNI introducido");
					return;
				}
				t.setDniComprador(dni);
				System.out.printf("%nTablet vendida correctamente al DNI: %s por %.2f €",dni,t.getPrecio());
			}
		}	
	}

	/**
	 * Método para mostrar tablets disponibles.
	 */
	private void tabletDisponible() {
		boolean disponible = false;
		System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄     TABLETS DISPONIBLES     ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		if (listaTablets.isEmpty()) {
			System.out.println("\nNo hay Tablets en la lista de tablets");
			return;
		}
		for (Tablet t: listaTablets) {
			if (t.getDniComprador().equals("00000000Z")) {
				System.out.println(t.toString());
				disponible = true;
			}
		}
		if (!disponible) System.out.println("\nNo hay Tablets disponibles");
	}
	
	/**
	 * Método para mostrar tablets vendidadas a un cliente en concreto.
	 */
	private void tabletVendida() {
		boolean existeCliente, existeVenta = false;
		String dni;	
		System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄       TABLETS VENDIDAS      ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		if (listaClientes.isEmpty()) {
			System.out.println("\nNo hay Clientes en la lista de clientes");
			return;
		}
		dni = generarDni();
		existeCliente = existeCliente(dni);
		if (!existeCliente) {
			System.out.println("\nNo existe cliente con el DNI introducido");
			return;
		}
		for (Cliente cl: listaClientes) {
			if(cl.getDni().equals(dni)) {
				System.out.println("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
				System.out.println("  "+cl.toString());
				System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
			}
		}
		for (Tablet t: listaTablets) {
			if(t.getDniComprador().equals(dni)) {
				System.out.println(" - "+t.toString());
				existeVenta = true;
			}
		}
		if (!existeVenta) System.out.println("\nNo ha realizado ninguna compra");
	}
	
	/**
	 * Método para comprobar si existe una tablet.
	 * 
	 * @param marca			
	 * @param modelo
	 * @param color
	 * @return true cuando existe y false cuando no existe.	
	 */
	private boolean existeTablet(String marca, String modelo, String color) {	
		if (listaTablets.isEmpty()) {
			return false;
		}
		for (Tablet t: listaTablets) {
			if (t.getMarca().equals(marca) && t.getModelo().equals(modelo) && t.getColor().equals(color)) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * Método para comprobar si existe un cliente.
	 * 
	 * @param dni
	 * @return true cuando existe y false cuando no existe.	
	 */
	private boolean existeCliente(String dni) {
		if (listaClientes.isEmpty()) {
			return false;
		}
		for (Cliente cl: listaClientes) {
			if (cl.getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método para mostrar menú en la consola y devolver la opción elegida por el usuario. 
	 * 
	 * @return opcion 
	 */
	private int mostrarMenuPrincipal() {
		int opcion;
		System.out.printf("""
		%n			
		┌───────────────────────────────────────────────────────────┐
		│░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░│ 
		│██████████████████ MENÚ VENTA DE TABLETS ██████████████████│
		│░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░│ 
		│1. Dar de alta una tablet.                                 │
		│2. Dar de alta un cliente.                                 │
		│3. Vender una tablet a un cliente.                         │
		│4. Mostrar tablets disponibles para la venta.              │
		│5. Mostrar tablets compradas por un cliente en concreto.   │
		│═══════════════════════════════════════════════════════════│
		│6. - Salir                                                 │
		├───────────────────────────────────────────────────────────┘
		""");
		System.out.print("└ Opción: ");
		opcion = comprobarInt();
		return opcion;
	}
	
	/**
	 * Método para devolver DNI completo.
	 * 
	 * Pedir 8 digitos por teclado (tienen que ser números),
	 * revisar la longitud si se introducen menos de 8 digitos se entra en bucle while,
	 * pasar los digitos a array de caracteres,
	 * comprobar si son digitos númericos, si no lo son se vuelve a repetir el bucle do while,
	 * convertir a int y hacer el resto entre 23 y se obtiene el indice de la letra en array letrasDni.
	 *
	 * @return DNI completo.
	 */
	private String generarDni() {
		boolean sonNumeros;		
		String dniNumeros, dniCompleto;
		int indx, numeros;
		char[] letrasDni = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		do {
			sonNumeros = true;
			char[] numerosDni;
			System.out.print("\nIntroducir DNI (solo números cantidad - 8): ");			
			/* *
			 * Guardar los números en varibale de tipo String, porque si el primer número a introducir fuera 0, 
			 * no se guardaría en la variable si la variable fuera de tipo int.
			 */
			dniNumeros = sc.nextLine();
			while (dniNumeros.length() != 8) {
				System.out.print("\nLongitud incorrecta introducir 8 digitos: ");
				dniNumeros = sc.nextLine();
			}
			numerosDni = dniNumeros.toCharArray();
			for (int i = 0; i < numerosDni.length; i++) {
				if (!Character.isDigit(numerosDni[i])) {
					System.out.println("\nError el DNI tiene que contener 8 digitos numéricos");
					sonNumeros = false;
					break;
				}
			}
		} while (!sonNumeros);
		// Convertir de String a int.
		numeros = Integer.parseInt(dniNumeros);	
		// Calcular el indice del array letrasDni.
		indx = numeros % 23;
		// Concatenar números con letra del DNI.
		dniCompleto = dniNumeros + letrasDni[indx];
		return dniCompleto;
	}
	
	/**
	 * Método para devolver un número entero.
	 * 
	 * Pedir por teclado un número entero,
	 * Comprobar si número introducido es un número entero,
     * Si no lo es entrar en bucle hasta que se introduzca un número entero.
	 * 
	 * @return número entero.
	 */
	protected int comprobarInt() {
		int entero;
		while(!sc.hasNextInt()) {
			System.out.println("\nError introducir un número entero: ");
			sc.nextLine();
		}
		entero = sc.nextInt();
		sc.nextLine();		
		return entero;
	}
	
	/**
	 * Método para devolver un número decimal.
	 * 
	 * Pedir por teclado un número decimal,
	 * comprobar si número introducido es un número decimal,
     * si no lo es entrar en bucle hasta que se introduzca un número decimal.
	 * 
	 * @return número decimal.
	 */
	protected double comprobarDouble() {
		double decimal;		
		while(!sc.hasNextDouble()) {
			System.out.println("\nError introducir un número: ");
			sc.nextLine();
		}
		decimal = sc.nextDouble();
		sc.nextLine();	
		return decimal;
	}
	
}
