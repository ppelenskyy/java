package colecciones_ejercicio;

import java.util.HashMap;
import java.util.Map;

public class Diccionario extends EstructuraMenu {
	Map<String, Participante> diccionario = new HashMap<>();
	
	public Diccionario () {
		
	}
	
	@Override
	protected int mostrarMenu() {
		System.out.printf(""" 
		
		┌───────────────────────────────────────────────────────────┐
		│                     MENÚ Map (HashMap)                    │
		├───────────────────────────────────────────────────────────┤
		│ [1] - Añadir nombres de participantes.                    │
		│ [2] - Mostrar todos los participantes almacenados.        │
		│ [3] - Buscar si un participante está en la lista.         │
		│ [4] - Eliminar un participante.                           │
		│ [5] - Mostrar el número total de participantes.           │
		│───────────────────────────────────────────────────────────│
		│ [0] - Atrás                                               │ 
		└───────────────────────────────────────────────────────────┘
		""");
		System.out.print("Entrada: ");
		return comprobarInt();
	}
	
	@Override
	protected boolean addParticipante() {
		String nombre, apellidos, dni;
		System.out.print("Introducir nombre: ");
		nombre = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir apellidos: ");
		apellidos = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir DNI: ");
		dni = sc.nextLine().toUpperCase().trim();
		diccionario.put(dni, (new Participante(nombre, apellidos, dni)));
		return true;
	}
	
	@Override
	protected void mostrarTodosParticipantes() {
		if (diccionario.isEmpty()) {
			System.out.println("\n¡No hay participantes almacenados!");
			return;
		}
		System.out.println();
		for (String dni: diccionario.keySet()) {
			System.out.println(diccionario.get(dni).toString());
		}
	}
	
	@Override
	protected boolean buscarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		if (diccionario.containsKey(dni)) {	
			Participante p = diccionario.get(dni);
			System.out.println();
			System.out.println(p.toString());
			return true;
		}	
		return false;
	}
	
	@Override
	protected boolean eliminarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		if (diccionario.containsKey(dni)) {	
			diccionario.remove(dni);
			return true;
		}	
		return false;
	}
	
	@Override
	protected int numeroDeParticipantes() {
		return diccionario.size();
	}

}
