package colecciones_ejercicio;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cola extends EstructuraMenu{
	Queue<Participante> cola = new PriorityQueue<>(Comparator.comparing(Participante::getNombre).thenComparing(Participante::getApellidos).thenComparing(Participante::getDni));
	
	public Cola () {
		
	}
	
	@Override
	protected int mostrarMenu() {
		System.out.printf(""" 
		
		┌───────────────────────────────────────────────────────────┐
		│                   MENÚ Queue (LinkedList)                 │
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
		System.out.print("\nIntroducir nombre: ");
		nombre = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir apellidos: ");
		apellidos = sc.nextLine().toUpperCase().trim();
		System.out.print("Introducir DNI: ");
		dni = sc.nextLine().toUpperCase().trim();
		return cola.add(new Participante(nombre, apellidos, dni));
	}
	
	@Override
	protected void mostrarTodosParticipantes() {
		if (cola.isEmpty()) {
			System.out.println("\n¡No hay participantes almacenados!");
			return;
		}
		System.out.println();
		for (Participante p: cola) {
			System.out.println(p.toString());
		}
	}
	
	@Override
	protected boolean buscarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		for (Participante p: cola) {
			if (p.getDni().equals(dni)) {
				System.out.println();
				System.out.println(p.toString());
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected boolean eliminarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		for (Participante p: cola) {
			if (p.getDni().equals(dni)) {
				return cola.remove(p);
			}
		}
		return false;
	}
	
	@Override
	protected int numeroDeParticipantes() {
		return cola.size();
	}
	
}
