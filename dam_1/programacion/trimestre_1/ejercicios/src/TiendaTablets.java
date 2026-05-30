/*
 * Desarrollar una aplicación que me permita guardar diferentes tipos de tablets y venderlas a los clientes.
 * Los datos a guardar de las tables son marca, modelo, color y precio de venta.
 * Debes de guardar las tablets que están disponibles para vender y guardar la información de las tablets vendidas y a qué clientes.
 * Tienes que tener un menú con las siguientes tareas:
 * 1.- Dar de alta una tablet (vamos a suponer que sólo tenemos una para la venta. Si quieres usar un atributo de stock)
 * 2.- Modificar datos de una tablet.
 * 3.- Vender tablet a un cliente.
 * 4.- Mostrar todas las tablets.
 * 5.- Mostrar tablets disponibles para la venta.
 * 6.- Mostrar tables vendidas.
 * 0.- Salir.
 * Un saludo.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TiendaTablets {
	
	// Método main(). OK.
	public static void main(String[] args) {
		// Declaración del Scanner.
		Scanner sc = new Scanner(System.in);
		
		// Punto de partida.
		switchMenu(sc);
	}
	
	// Método para mostrar menú. OK
	public static void getMenu() {
		separar();
		System.out.println(" [                  === MENÚ ===                    ]");
		System.out.println(" ┌──────────────────────────────────────────────────┐");
		System.out.println(" |1.|- Dar de alta una tablet.                      |");
		System.out.println(" |2.|- Modificar datos de una tablet.               |");
		System.out.println(" |3.|- Vender tablet a un cliente.                  |");
		System.out.println(" |4.|- Mostrar todas las tablets.                   |");
		System.out.println(" |5.|- Mostrar tablets disponibles para la venta.   |");
		System.out.println(" |6.|- Mostrar tablets vendidas.                    |");
		System.out.println(" |0.|- Salir.                                       |");
		System.out.println(" └──────────────────────────────────────────────────┘");
		System.out.print(" Entrada: ");
	}
	
	// Método para el switch principal. OK.
	public static void switchMenu(Scanner sc) {
		// Declaración de variables y matrices.
		int opcion;
		final int FILAS = 100;
		final int COLUMNAS = 6;
		String[][] matrizTablet = new String[FILAS][COLUMNAS]; // 0. idTalet(primary key), 1. marca, 2. modelo, 3. color, 4. precio de venta , 5. stock.
		String[][] matrizFactura = new String[100][4]; // 0. idFactura(primary key), 1. DNI, 2. Precio, 3. Indice tablet.
		
		// Instrucciones.
		do {
			getMenu();
			opcion = revisarEntero(sc);
			separar();
			switch (opcion) {
			// 1.- Dar de alta una tablet.
			case 1:
				System.out.println("          --- DAR DE ALTA UNA TABLET NUEVA ---");
				System.out.println("________________________________________________________");
				darAltaTablet(sc, matrizTablet);
				break;
				
			// 2.- Modificar datos de una tablet.
			case 2:
				System.out.println("          --- MODIFICAR UNA TABLET ---");
				System.out.println("________________________________________________________");
				modificarTablet(sc, matrizTablet);
				break;
			
			// 3.- Vender tablet a un cliente.
			case 3:
				System.out.println("          --- VENDER UNA TABLET ---");
				System.out.println("________________________________________________________");
				venderTablet(sc, matrizTablet, matrizFactura);
				break;
			
			// 4.- Mostrar todas las tablets.
			case 4:
				System.out.println("          --- MOSTRAR TODAS LAS TABLETS ---");
				System.out.println("________________________________________________________");
				mostrarTodasTablets(sc, matrizTablet);
				break;
			
			// 5.- Mostrar tablets disponibles para la venta.
			case 5:
				System.out.println("          --- TABLETS DISPONIBLES ---");
				System.out.println("________________________________________________________");
				mostrarTabletsDisponibles(sc, matrizTablet);
				break;
				
			// 6.- Mostrar tablets vendidas.
			case 6:
				System.out.println("          --- TABLETS VENDIDAS ---");
				System.out.println("________________________________________________________");
				mostrarTabletsVendidas(sc, matrizTablet, matrizFactura);
				break;
			
			// 0.- Salir.
			case 0:
				break;
			default:
				System.out.println("Elegir entre 0-6");
			}
		} while (opcion != 0);
		System.out.println("¡Hasta pronto!");
	}
	
	// 1.- Método para Dar de alta una tablet. OK.
	public static void darAltaTablet(Scanner sc, String[][] matrizTablet) {
		// Declaración de variables.
		boolean modificar = false; // argumento false sirve para no modificar en método tabletDatos().
		boolean libre = false;
		
		// Instrucciones.
		for (int i = 0; i < matrizTablet.length; i++) {
			if (matrizTablet[i][0] == null) {
				libre = true;
				tabletDatos(sc, matrizTablet, i, modificar);				
				if (matrizTablet[i][0] != null) {
					separar();
					System.out.println("[Tablet ID: "+matrizTablet[i][0]+". Marca: "+matrizTablet[i][1]+". Modelo: "+matrizTablet[i][2]+". Color: "+matrizTablet[i][3]+". Precio: "+matrizTablet[i][4]+" €. Stock: "+matrizTablet[i][5]+" ud. Añadida correctamente]");
				}
				break;
			}
		}
		if (!libre) System.out.println("¡No hay espacios libres para poder insertar mas variantes de tablets!");
	}
	
	// 2.- Método para Modificar datos de una tablet. OK.
	public static void modificarTablet(Scanner sc, String[][] matrizTablet) {
		// Declaración de variables.
		int pos;
		boolean modificar = true; // true sirve para poder modificar en método tabletDatos().
		boolean revisarStock = false; // false sirve para saltar la revision del stock disponible en metodo tabletExiste().
		String idTablet;
		
		// Instrucciones.
		System.out.print("Tablet ID: ");
		idTablet = Integer.toString(revisarEntero(sc));
		pos = tabletExiste(sc, matrizTablet, revisarStock, idTablet);
		if (pos == -1) {
			System.out.println("No existe tablet con ID: "+idTablet); 
			return; 
		}
		else { 
			System.out.println("Introducir nuevos valores");
			tabletDatos(sc, matrizTablet, pos, modificar);
			separar();
			System.out.println("[Tablet con ID: "+idTablet+" modificada correctamente]");
		}
	}
	
	// 3.- Método para Vender tablet a un cliente.
	public static void venderTablet(Scanner sc, String[][] matrizTablet, String[][] matrizFactura) {
		// Declaración de variables.
		boolean revisarStock = true, libre = false, disponibles;
		int pos, stock;
		String idTablet;
		
		// Instrucciones.
		System.out.println("Tablets disponibles:");
		System.out.println("________________________________________________________");
		disponibles = mostrarTabletsDisponibles(sc, matrizTablet);
		if (!disponibles) return;
		System.out.print("Tablet ID: ");
		idTablet = Integer.toString(revisarEntero(sc));
		pos = tabletExiste(sc, matrizTablet, revisarStock, idTablet);
		if (pos == -1) {
			separar();
			System.out.println("No existe tablet con ID: "+idTablet); 
			return; 
		}
		else if (pos == -2) return;
		else {
			for (int i = 0; i < matrizFactura.length; i++) {
				if (matrizFactura[i][0] == null) {
					libre = true;
					
					separar();
					// Guardar el número de factura.
					matrizFactura[i][0] = idFactura(i);
					System.out.println("Factura ID: "+matrizFactura[i][0]);
					
					// Guardar el precio de la tablet.
					matrizFactura[i][2] = matrizTablet[pos][4];
					System.out.println("Precio: "+matrizFactura[i][2]+" €");
					
					// Guardar el DNI del comprador.
					System.out.print("DNI: ");
					matrizFactura[i][1] = sc.nextLine().toUpperCase().trim();
					
					// Guardar el indice de la tablet vendida en matrizFactura.
					matrizFactura[i][3] = Integer.toString(pos);
					
					
					stock = Integer.parseInt(matrizTablet[pos][5]);
					stock--;
					matrizTablet[pos][5] = Integer.toString(stock);
					separar();
					System.out.println("[Tablet con ID: "+idTablet+" vendida correctamente al DNI: "+matrizFactura[i][1]+"]");
					break;
				}
			}
			if (!libre) {
				separar();
				System.out.println("¡No hay espacios libres para poder insertar mas facturas!");	
			}
		}
	}
	
	// 4.- Método para Mostrar todas las tablets.
	public static void mostrarTodasTablets(Scanner sc, String[][] matrizTablet) {
		boolean existen = false;
		
		for (int i = 0; i < matrizTablet.length; i++) {
			if (matrizTablet[i][0] != null) {
				existen = true;
				System.out.println(i+".- | Tablet ID: "+matrizTablet[i][0]+". Marca: "+matrizTablet[i][1]+". Modelo: "+matrizTablet[i][2]+". Color: "+matrizTablet[i][3]+". Precio: "+matrizTablet[i][4]+" €. Stock: "+matrizTablet[i][5]+" ud.");
			}	
		}
		if (!existen) {
			separar();
			System.out.println("¡No hay tablets dadas de alta!");	
		}
	}
	
	// 5.- Método para Mostrar tablets disponibles para la venta. OK.
	public static boolean mostrarTabletsDisponibles(Scanner sc, String[][] matrizTablet) {
		// Declaración de variables.
		boolean disponibles = false;
		
		// Instrucciones.
		for (int i = 0; i < matrizTablet.length; i++) {
			if (matrizTablet[i][0] != null && !matrizTablet[i][5].equals("0")) {
				System.out.println(i+".- | Tablet ID: "+matrizTablet[i][0]+". Marca: "+matrizTablet[i][1]+". Modelo: "+matrizTablet[i][2]+". Color: "+matrizTablet[i][3]+". Precio: "+matrizTablet[i][4]+" €. Stock: "+matrizTablet[i][5]+" ud.");
				disponibles = true;	
			}
		}
		if (!disponibles) System.out.println("¡No hay tablets disponibles!");
		return disponibles;
	}
	
	// 6.- Método para Mostrar tables vendidas.
	public static void mostrarTabletsVendidas(Scanner sc, String[][] matrizTablet, String [][] matrizFactura) {
		boolean existen = false;
		int posTablet;
		
		for (int i = 0; i < matrizFactura.length; i++) {
			if (matrizFactura[i][0] != null) {
				existen = true;
				posTablet = Integer.parseInt(matrizFactura[i][3]);
				System.out.println("    ┌───────────────────────────────────────────────────");
				System.out.println(i+".- | Factura ID: "+matrizFactura[i][0]+". DNI: "+matrizFactura[i][1]+".");
				System.out.println("    ├───────────────────────────────────────────────────");
				System.out.println("    | Tablet ID: "+matrizTablet[posTablet][0]+". Marca: "+matrizTablet[posTablet][1]+". Modelo: "+matrizTablet[posTablet][2]+" Color: "+matrizTablet[posTablet][3]+".");
				System.out.println("    | Precio venta: "+matrizFactura[i][2]+" €.");
				System.out.println("    └───────────────────────────────────────────────────");
				separar();
			}
		}
		if (!existen) {
			separar();
			System.out.println("¡No hay tablets vendidas!");	
		}
	}
	
	//------------------------------------------------------------------------------------
	
	// Método para añadir o modificar una tablet. OK.
	public static void tabletDatos(Scanner sc, String[][] matrizTablet, int i, boolean modificar) {
		boolean revisarStock = false;
		String idTablet;

		// Si modificar es true se ejecuta el if.
		if (modificar) {
			System.out.println("Tablet ID actual: "+matrizTablet[i][0]);
			System.out.print("Tablet ID nuevo: ");
			idTablet = Integer.toString(revisarEntero(sc));
			if (idTablet.equals(matrizTablet[i][0])) {
				System.out.println("Marca actual: "+matrizTablet[i][1]);
				System.out.print("Marca nueva: ");
				matrizTablet[i][1] = sc.nextLine().toUpperCase().trim();;
				System.out.println("Modelo actual: "+matrizTablet[i][2]);
				System.out.print("Modelo nuevo: ");
				matrizTablet[i][2] = sc.nextLine().toUpperCase().trim();;
				System.out.println("Color actual: "+matrizTablet[i][3]);
				System.out.print("Color nuevo: ");
				matrizTablet[i][3] = sc.nextLine().toUpperCase().trim();
				System.out.println("Precio actual: "+matrizTablet[i][4]);
				System.out.print("Precio nuevo: ");
				matrizTablet[i][4] = Double.toString(revisarDouble(sc));
				System.out.println("Stock actual: "+matrizTablet[i][5]);
				System.out.print("Stock nuevo: ");
				matrizTablet[i][5] = Integer.toString(revisarEntero(sc));	
			}
			else if (tabletExiste(sc, matrizTablet, revisarStock, idTablet) != -1) {
				separar();
				System.out.println("¡ID introducido ya existe!");
				return;
			}
			else {
				matrizTablet[i][0] = idTablet;
				System.out.println("Marca actual: "+matrizTablet[i][1]);
				System.out.print("Marca nueva: ");
				matrizTablet[i][1] = sc.nextLine().toUpperCase().trim();;
				System.out.println("Modelo actual: "+matrizTablet[i][2]);
				System.out.print("Modelo nuevo: ");
				matrizTablet[i][2] = sc.nextLine().toUpperCase().trim();;
				System.out.println("Color actual: "+matrizTablet[i][3]);
				System.out.print("Color nuevo: ");
				matrizTablet[i][3] = sc.nextLine().toUpperCase().trim();
				System.out.println("Precio actual: "+matrizTablet[i][4]);
				System.out.print("Precio nuevo: ");
				matrizTablet[i][4] = Double.toString(revisarDouble(sc));
				System.out.println("Stock actual: "+matrizTablet[i][5]);
				System.out.print("Stock nuevo: ");
				matrizTablet[i][5] = Integer.toString(revisarEntero(sc));
				
			}
		}
		
		// Si modificar es false se ejecuta el else (sirve para añadir tablet nueva).
		else {
			System.out.print("ID: ");
			idTablet = Integer.toString(revisarEntero(sc));
			if (tabletExiste(sc, matrizTablet, revisarStock, idTablet) != -1) {
				separar();
				System.out.println("¡ID introducido ya existe!");
				return;
			}
			matrizTablet[i][0] = idTablet;
			System.out.print("Marca: ");
			matrizTablet[i][1] = sc.nextLine().toUpperCase().trim();;
			System.out.print("Modelo: ");
			matrizTablet[i][2] = sc.nextLine().toUpperCase().trim();;
			System.out.print("Color: ");
			matrizTablet[i][3] = sc.nextLine().toUpperCase().trim();;
			System.out.print("Precio: ");
			matrizTablet[i][4] = Double.toString(revisarDouble(sc));
			System.out.print("Stock: ");
			matrizTablet[i][5] = Integer.toString(revisarEntero(sc));
		}

	}
	
	// Método parar revisar si existe una tablet.
	public static int tabletExiste(Scanner sc, String[][] matrizTablet, boolean revisarStock, String tablet_id) {
		// Declaración de variables.
		boolean existe = false;
		int pos = 0;
		String cantidad;
		
		// Instrucciones.
		for (int i = 0; i < matrizTablet.length; i++) {
			if (matrizTablet[i][0] != null && matrizTablet[i][0].equals(tablet_id)) {
				existe = true;
				if (revisarStock && !matrizTablet[i][5].equals("0")) {
					separar();
					cantidad = matrizTablet[i][5];
					System.out.println("Cantidad disponible: "+cantidad+" ud.");
					pos = i;
					break;
				}
				else if (revisarStock && matrizTablet[i][5].equals("0")) {
					separar();
					System.out.println("¡No hay stock disponible!");
					return -2;	
				}
				else {
					pos = i;
					break;
				}
			}
		}		
		if (!existe) {
			pos = -1;
		}
		return pos;
	}
	
	// Método para crear idFactura unico.
	public static String idFactura(int pos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_");
		Date fecha = new Date();
		String fechaFormateada = sdf.format(fecha);
		String idFactura = "F"+fechaFormateada+pos;
		return idFactura;
	}
	// Método para separar visualmente en la consola. OK.
	public static void separar() {
		System.out.println();
	}
	
	// Método para revisar que se introduzca número entero. OK.
	public static int revisarEntero(Scanner sc) {
		// Decalaración de variables.
		int entrada;
		
		// Instrucciones.
		while (!sc.hasNextInt()) {
			separar();
			System.out.print("¡Tiene que ser un numero entero!: ");
			sc.next();
		}
		entrada = sc.nextInt();
		sc.nextLine();
		return entrada;
	}
	
	// Método para revisar que se introduzca número double. OK.
	public static double revisarDouble(Scanner sc) {
		// Decalaración de variables.
		double entrada;
		
		// Instrucciones.
		while (!sc.hasNextDouble()) {
			separar();
			System.out.print("¡Tiene que ser un numero entero!: ");
			sc.next();
		}
		entrada = sc.nextDouble();
		sc.nextLine();
		return entrada;
	}

}
