package colecciones_ejercicio;

import java.util.HashSet;
import java.util.Set;

public class Conjunto extends EstructuraMenu{
	Set<Participante> conjunto = new HashSet<>();
	
	public Conjunto () {
		
	}
	
	@Override
	protected int mostrarMenu() {
		System.out.printf(""" 
		
		┌───────────────────────────────────────────────────────────┐
		│                     MENÚ Set (HashSet)                    │
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
		return conjunto.add(new Participante(nombre, apellidos, dni));
	}
	
	@Override
	protected void mostrarTodosParticipantes() {
		if (conjunto.isEmpty()) {
			System.out.println("\n¡No hay participantes almacenados!");
			return;
		}
		System.out.println();
		for (Participante p: conjunto) {
			System.out.println(p.toString());
		}
	}
	
	@Override
	protected boolean buscarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		return conjunto.contains(new Participante("","",dni));
	}
	
	@Override
	protected boolean eliminarParticipante() {
		System.out.print("\nIntroducir DNI: ");
		String dni = sc.nextLine().toUpperCase().trim();
		return conjunto.remove(new Participante("","",dni));
	}
	
	@Override
	protected int numeroDeParticipantes() {
		return conjunto.size();
	}

}
