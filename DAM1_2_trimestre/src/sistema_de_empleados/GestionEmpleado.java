package sistema_de_empleados;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionEmpleado {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
	private final String  RED = "\033[31m",  YELLOW = "\033[33m", GREEN = "\033[32m", BLUE = "\033[36m", BG_BLACK= "\033[40m", RESET = "\033[0m";
	
	protected GestionEmpleado() {
		
	}
	
	/*
	 * Método switch principal.
	 */
	protected void switchMenu() {
		int opcion;

		do {
			opcion = mostrarMenuPrincipal();
			
			switch(opcion) {
				// 1.- Añadir
				case 1: {
					addEmpleado();
					break;
				}
				
				// 2.- Eliminar
				case 2: {
					eliminarEmpleado();
					break;
				}
				
				// 3.- Modificar
				case 3: {
					modificarEmpleado();
					break;
				}
				
				// 4.- Mostrar sueldo
				case 4: {
					mostrarSueldoEmpleado();
					break;
				}
				
				// 0.- Salir
				case 0: {
					System.out.printf("\n───────────%s ¡Hasta Pronto! %s───────────",BG_BLACK, RESET);
					break;
				}
				
				default:{
					System.out.printf("\n%sOpción incorrecta elegir entre [0-4]%s",RED,RESET);
					break;
				}				
			} 
		} while(opcion != 0);
	}
	
	/*
	 * Método switch para modificar empleado a tiempo completo.
	 */
	private void switchModificar(EmpleadoTiempoCompleto etc) {
		int opcion;

		do {
			opcion = mostrarMenuModificar(0); // Parámetro 0 = mostrar menu para empleado a tiempo completo.
			switch(opcion) {
				// 1.- Modificar nombre
				case 1: {				
					System.out.printf("%nNombre actual: %s%n",etc.getNombre());
					System.out.print("Nuevo nombre: ");
					etc.setNombre(sc.nextLine().toUpperCase().trim());
					System.out.printf("%n%sNombre modificado correctamente.%s",GREEN,RESET);
					break;
				}
				
				// 2.- Modificar apellidos
				case 2: {
					System.out.printf("%nApellidos actuales: %s%n",etc.getApellidos());
					System.out.print("Nuevos apellidos: ");
					etc.setApellidos(sc.nextLine().toUpperCase().trim());
					System.out.printf("%n%sApellidos modificados correctamente.%s",GREEN,RESET);
					break;
				}
				
				// 3.- Modificar dni
				case 3: {
					System.out.printf("%nDNI actual: %s%n",etc.getDni());
					System.out.print("Nuevo DNI: ");
					etc.setDni(sc.nextLine().toUpperCase().trim());
					System.out.printf("%n%sDNI modificado correctamente.%s",GREEN,RESET);
					break;
				}
				
				// 4.- Modificar salario
				case 4: {
					System.out.printf("%nSalario actual (ANUAL): %s €%n",etc.getSueldoAnual());
					System.out.print("Nuevo salario: ");
					etc.setSueldoAnual(esDouble());
					System.out.printf("%n%sSalario modificado correctamente. %nNuevo salario:%s %.2f €",GREEN,RESET,etc.getSueldoAnual());
					break;
				}
				
				// 0.- Atras
				case 0:{
					break;
				}
				
				default: {
					System.out.printf("\n%sOpción incorrecta elegir entre [0-4]%s",RED,RESET);
					break;
				}
			}
		} while (opcion != 0);
	}
	
	/*
	 * Método switch para modificar empleado por horas.
	 */
	private void switchModificar(EmpleadoPorHoras eph) {
		int opcion;

		do {
			opcion = mostrarMenuModificar(1); // Parámetro 1 = mostrar menu para empleado por horas.
			switch(opcion) {
				// 1.- Modificar nombre
				case 1: {
					System.out.printf("%nNombre actual: %s%n",eph.getNombre());
					System.out.print("Nuevo nombre: ");
					eph.setNombre(sc.nextLine().toUpperCase().trim());
					System.out.printf("%n%sNombre modificado correctamente.%s",GREEN,RESET);
					break;
				}
				
				// 2.- Modificar apellidos
				case 2: {
					System.out.printf("%nApellidos actuales: %s%n",eph.getApellidos());
					System.out.print("Nuevos apellidos: ");
					eph.setApellidos(sc.nextLine().toUpperCase().trim());
					System.out.printf("%n%sApellidos modificados correctamente.%s",GREEN,RESET);
					break;
				}
				
				// 3.- Modificar dni
				case 3: {
					System.out.printf("%nDNI actual: %s%n",eph.getDni());
					System.out.print("Nuevo DNI: ");
					eph.setDni(sc.nextLine().toUpperCase().trim());
					System.out.printf("%n%sDNI modificado correctamente.%s",GREEN,RESET);
					break;
				}
				
				// 4.- Modificar salario
				case 4: {
					System.out.printf("%nSalario actual (POR HORA): %.2f €%n",eph.getSueldoHora());
					System.out.print("Nuevo salario: ");
					eph.setSueldoHora(esDouble());
					System.out.printf("%n%sSalario modificado correctamente. %nNuevo salario:%s %.2f €",GREEN,RESET,eph.getSueldoHora());
					break;
				}
				
				// 5.- Modificar horas
				case 5: {
					System.out.printf("%nHoras actuales: %.2f h%n",eph.getHorasTrabajadas());
					System.out.print("Nuevas horas: ");
					eph.setHorasTrabajadas(esDouble());
					System.out.printf("%n%sHoras trabajadas modificadas correctamente. %nNuevas horas:%s %.2f h",GREEN,RESET,eph.getHorasTrabajadas());
					break;
				}
				
				// 0.- Atras
				case 0:{
					break;
				}
				
				default: {
					System.out.printf("\n%sOpción incorrecta elegir entre [0-5]%s",RED,RESET);
					break;
				}
			}
		} while (opcion != 0);
	}
	
	/*
	 * Método para añadir un empleado.
	 */
	private void addEmpleado() {
		int opcion;
		String nombre, apellidos, dni;

		do {
			opcion = mostrarMenuAdd();
			switch(opcion) {
				// 1.- Empleado tiempo completo
				case 1:{
					System.out.print("\nNombre: ");
					nombre = sc.nextLine().toUpperCase().trim();
					System.out.print("Apellidos: ");
					apellidos = sc.nextLine().toUpperCase().trim();
					System.out.print("DNI: ");
					dni = sc.nextLine().toUpperCase().trim();
					if (buscarDni(dni) >= 0) {
						System.out.println("\n¡DNI introducido ya existe!");
						return;
					}
					Empleado e = new EmpleadoTiempoCompleto(nombre, apellidos, dni);
					listaEmpleados.add(e);
					System.out.printf("%n%sEmpleado %s %s añadido correctamente a la lista de empleados.%s",GREEN,nombre, apellidos,RESET);
					break;
				}
				
				// 2.- Empleado por horas
				case 2:{
					System.out.print("\nNombre: ");
					nombre = sc.nextLine().toUpperCase().trim();
					System.out.print("Apellidos: ");
					apellidos = sc.nextLine().toUpperCase().trim();
					System.out.print("DNI: ");
					dni = sc.nextLine().toUpperCase().trim();
					if (buscarDni(dni) >= 0) {
						System.out.println("\n¡DNI introducido ya existe!");
						return;
					}
					Empleado e = new EmpleadoPorHoras(nombre, apellidos, dni);
					listaEmpleados.add(e);
					System.out.printf("%n%sEmpleado %s %s añadido correctamente a la lista de empleados.%s",GREEN,nombre, apellidos,RESET);
					break;
				}
				
				// 0.- Atras
				case 0:{
					break;
				}
				
				default: {
					System.out.printf("\n%sOpción incorrecta elegir entre [0-2]%s",RED,RESET);
					break;
				}
			}
		} while(opcion != 0);
	}
	
	/*
	 * Método para eliminar un empleado.
	 */
	private void eliminarEmpleado() {
		int indx;
		String nombre, apellidos;
		
		indx = buscarEmpleado();
		
		if (indx < 0) return;
		
		Empleado e = listaEmpleados.get(indx);	
		
		nombre = e.getNombre();
		apellidos = e.getApellidos();
		
		listaEmpleados.remove(indx);
		System.out.printf("%n%sEmpleado %s %s eliminado correctamente de la lista de empleados.%s",GREEN,nombre,apellidos,RESET);
	}
	
	/*
	 * Método para modificar un empleado.
	 */
	private void modificarEmpleado() {
		int indx;
		
		indx = buscarEmpleado();
		
		if (indx < 0) return;

		Empleado e = listaEmpleados.get(indx);
					
		if (e instanceof EmpleadoTiempoCompleto etc) { 
			switchModificar(etc); 
		} 
		
		else if (e instanceof EmpleadoPorHoras eph) {
			switchModificar(eph); 
		}	
	}
	
	/*
	 * Método para mostrar el sueldo de un empleado.
	 */
	private void mostrarSueldoEmpleado() {
		int indx;
		
		indx = buscarEmpleado();
		
		if (indx < 0) return;	
		
		Empleado e = listaEmpleados.get(indx);
		
		if (e instanceof EmpleadoTiempoCompleto etc) {
			System.out.printf("%nEl sueldo mensual del empleado %s %s con el régimen a tiempo completo es de: %.2f €/mes.",etc.getNombre(),etc.getApellidos(),etc.calcularSueldo());
		}
		
		else if (e instanceof EmpleadoPorHoras eph) {			
			System.out.printf("%nEl sueldo acumulado del empleado %s %s con el régimen por horas es de: %.2f € con %.2f horas trabajadas.",eph.getNombre(),eph.getApellidos(),eph.calcularSueldo(),eph.getHorasTrabajadas());
		}	
	}

	/*
	 * Método para buscar un empleado.
	 */
	private int buscarEmpleado() {
		String dni; 
		int indx;
			
		if(listaEmpleados.isEmpty()) {
			System.out.printf("%n%sLista de empleados está vacia.%s",YELLOW,RESET);
			return -1;
		}
		
		System.out.print("\nIntroducir el DNI: ");
		dni = sc.nextLine().toUpperCase().trim();
		
		indx = buscarDni(dni);
		
		if (indx >= 0) return indx;
		else System.out.printf("%sNo existe empleado con DNI%s: %s",RED,RESET,dni);
		return -2;
	}
	
	/*
	 * Método para buscar un dni.
	 */
	protected int buscarDni(String dni) {
		for (Empleado e: listaEmpleados) {
			if (e.getDni().equals(dni)) {
				return listaEmpleados.indexOf(e);
			}
		}
		return -2;
	}
	
	/*
	 * Método para mostrar menú de gestion de empleados.
	 */
	private int mostrarMenuPrincipal() {
		int option;
		
		System.out.printf("""
		\n			
		┌───────────────────────────────┐
		│%s%s        MENÚ EMPLEADOS         %s│
		├───────────────────────────────┤
		│%s 1.%s - Añadir                   │
		│%s 2.%s - Eliminar                 │
		│%s 3.%s - Modificar                │
		│%s 4.%s - Mostrar sueldo           │
		│-------------------------------│
		│%s 0. - Salir                    %s│
		├───────────────────────────────┘
		""",BLUE,BG_BLACK,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BG_BLACK,RESET);
		System.out.printf("└ %sOpción%s: ",BLUE,RESET);
		option = esInt();
		return option;
	}
	
	/*
	 * Método para mostrar menú de añadir empleados.--
	 */
	private int mostrarMenuAdd() {
		int option;
		
		System.out.printf("""
		\n			
		┌───────────────────────────────┐
		│%s%s		AÑADIR EMPLEADO		%s│
		├───────────────────────────────┤
		│%s 1.%s - Empleado tiempo completo	│
		│%s 2.%s - Empleado por horas       │
		│-------------------------------│
		│%s 0. - Atras			%s│
		├───────────────────────────────┘
		""",BLUE,BG_BLACK,RESET,BLUE,RESET,BLUE,RESET,BG_BLACK,RESET);
		System.out.printf("└ %sOpción%s: ",BLUE,RESET);
		option = esInt();
		return option;
	}
	
	/*
	 * Método para mostrar menú de modificar empleados.
	 */
	private int mostrarMenuModificar(int function) {
		int option;
		
		if (function == 0) {
			System.out.printf("""
					\n			
					┌───────────────────────────────┐
					│%s%s    MODIFICAR DATOS EMPLEADO   %s│
					├───────────────────────────────┤
					│%s 1.%s - Nombre                   │
					│%s 2.%s - Apellidos                │
					│%s 3.%s - DNI                      │
					│%s 4.%s - Salario                  │
					│-------------------------------│
					│%s 0. - Atras                    %s│
					├───────────────────────────────┘
					""",BLUE,BG_BLACK,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BG_BLACK,RESET);
					System.out.printf("└ %sOpción%s: ",BLUE,RESET);
		}
		else {
			System.out.printf("""
					\n			
					┌───────────────────────────────┐
					│%s%s    MODIFICAR DATOS EMPLEADO   %s│
					├───────────────────────────────┤
					│%s 1.%s - Nombre                   │
					│%s 2.%s - Apellidos                │
					│%s 3.%s - DNI                      │
					│%s 4.%s - Salario                  │
					│%s 5.%s - Horas                    │
					│-------------------------------│
					│%s 0. - Atras                    %s│
					├───────────────────────────────┘
					""",BLUE,BG_BLACK,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BLUE,RESET,BG_BLACK,RESET);
					System.out.printf("└ %sOpción%s: ",BLUE,RESET);
		}
		option = esInt();
		return option;
	}
	
	/*
	 * Método para revisar si se introduce un número entero.
	 */
	protected int esInt() {
		int i;
		
		while(!sc.hasNextInt()) {
			System.out.printf("%sError introducir un número entero%s: ",RED,RESET);
			sc.nextLine();
		}
		i = sc.nextInt();
		sc.nextLine();		
		return i;
	}
	
	/*
	 * Método para revisar si se introduce un número double.
	 */
	protected double esDouble() {
		double d;
		
		while(!sc.hasNextDouble()) {
			System.out.printf("%sError introducir un número%s: ",RED,RESET);
			sc.nextLine();
		}
		d = sc.nextDouble();
		sc.nextLine();	
		return d;
	}
	
}
