package colecciones_ejercicio;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pila extends EstructuraMenu {
	Deque<Participante> pila = new ArrayDeque<>();
	
	public Pila () {
		
	}
	
	@Override
	protected int mostrarMenu() {
		System.out.printf(""" 
		
		┌───────────────────────────────────────────────────────────┐
		│                     MENÚ Deque                            │
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
		return pila.add(new Participante(nombre, apellidos, dni));
	}
	
	@Override
	protected void mostrarTodosParticipantes() {
		if (pila.isEmpty()) {
			System.out.println("\n¡No hay participantes almacenados!");
			return;
		}
		System.out.println();
		for (Participante p: pila) {
			System.out.println(p.toString());
		}
	}
	
	@Override
	protected boolean buscarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		for (Participante p: pila) {
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
		for (Participante p: pila) {
			if (p.getDni().equals(dni)) {
				return pila.remove(p);
			}
		}
		return false;
	}
	
	@Override
	protected int numeroDeParticipantes() {
		return pila.size();
	}
	
}
