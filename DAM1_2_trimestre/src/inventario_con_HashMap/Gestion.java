package inventario_con_HashMap;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Producto> inventario = new HashMap<>();
	
	public Gestion() {
		
	}
	
	public void switchMenu() {
		int opcion = 0;
		do {
			opcion = mostrarMenu();
			switch(opcion) {
				case 1:
					System.out.println("\n   AGREGAR UN PRODUCTO");
					System.out.println("═════════════════════════");
					agregarProducto();
					break;
				case 2:
					System.out.println("\n   BUSCAR UN PRODUCTO");
					System.out.println("════════════════════════");
					buscarProducto();
					break;
				case 3:
					System.out.println("\n   ACTUALIZAR STOCK DE UN PRODUCTO");
					System.out.println("═════════════════════════════════════");
					actualizarStockProducto();
					break;
				case 4:
					System.out.println("\n   ELIMINAR UN PRODUCTO");
					System.out.println("══════════════════════════");
					eliminarProducto();
					break;
				case 5:
					System.out.println("\n   MOSTRAR TODOS LOS PRODUCTOS");
					System.out.println("═════════════════════════════════");
					mostrarProductos();
					break;
				case 0:
					System.out.println("\n═════════Hasta Pronto═════════");
					break;
				default:
					System.out.println("\nOpción incorrecta: elegir entre 0-5.");
					break;
			}
		} while (opcion != 0);
	}
	
	private int mostrarMenu() {
		boolean error;
		int opcion = 0;
		do {
			error = false;
			try {
				System.out.println("""
						
						┌─────────────────────────────────┐
						│         MENÚ INVENTARIO         │
						│═════════════════════════════════│
						│1.- Agregar un producto          │
						│2.- Buscar un producto           │
						│3.- Actualizar el stock          │
						│4.- Eliminar un producto         │
						│5.- Mostrar todos los productos  │
						│0.- Salir                        │
						├─────────────────────────────────┘""");
				System.out.print("└ Entrada: ");
				opcion = sc.nextInt();
				sc.nextLine();	
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("\nError: tiene que ser un número entero.");
				error = true;
			} catch(Exception e) {
				sc.nextLine();
				System.out.println("\nError: general.");
				error = true;
			}
		} while(error);
		return opcion;
	}
	
	private void agregarProducto() {
		String nombre, codigoProducto;
		double precio = 0;
		int stock = 0;
		boolean error;
		System.out.print("Nombre: ");
		nombre = sc.nextLine();
		do {
			error = false;
			try {
				System.out.print("Precio: ");
				precio = sc.nextDouble();
			} catch(InputMismatchException e) {
				System.out.println("\nError: tiene que ser un número.");
				error = true;
			}
			if (!error) {
				try {
					System.out.print("Stock: ");
					stock = sc.nextInt();
				} catch(InputMismatchException e) {
					System.out.println("\nError: tiene que ser un número entero.");
					error = true;
				}
			}
			sc.nextLine();
		} while (error);
		Producto p = new Producto(nombre, precio, stock);
		codigoProducto = p.getCodigoProducto();
		inventario.put(codigoProducto, p);
		System.out.println("\n" + inventario.get(codigoProducto).toString() + " agregado correctamente.");
	}
	
	private Producto buscarProducto() {
		if (inventario.isEmpty()) {
			System.out.println("\nEl inventario esta vacio.");
			return null;
		}
		System.out.print("\nIntroducir Código de Producto: ");
		String codigoProducto = sc.nextLine();
		if (inventario.containsKey(codigoProducto)) {
			System.out.println("\nPRODUCTO ENCONTRADO");
			System.out.println(inventario.get(codigoProducto).toString());
			return inventario.get(codigoProducto);
		} 
		System.out.println("\nProducto no encontrado.");
		return null;
	}
	
	private void actualizarStockProducto() {
		boolean error;
		Producto p = buscarProducto();
		try {
			p.getStock();
			do {
				error = false;
				try {
					System.out.print("\nNuevo Stock: ");
					p.setStock(sc.nextInt());
					sc.nextLine();
					System.out.println("\nStock actualizado correctamente\nNuevo Stock: " + p.getStock());
				} catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("\nError: hay que introducir un número entero.");
					error = true;
				}
			} while (error);
		} catch (NullPointerException e) {
		}
	}
	
	private void eliminarProducto() {
		Producto p = buscarProducto();
		try {
			inventario.remove(p.getCodigoProducto());
			System.out.println("\nProducto eliminado correctamente.");
		} catch(NullPointerException e) {
			
		}
	}
	
	private void mostrarProductos() {
		if (inventario.isEmpty()) {
			System.out.println("\nEl inventario esta vacio.");
			return;
		}
		for (String codigoProducto: inventario.keySet()) {
			System.out.println(inventario.get(codigoProducto).toString());
		}
	}
}
