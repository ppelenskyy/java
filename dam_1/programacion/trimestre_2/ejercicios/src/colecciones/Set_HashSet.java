package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_HashSet {
	public static void main(String[] args) {
		/**
		 * No permite elementos repetidos.
		 *
		 * Ideal cuando:
		 * No quieres duplicados.
		 * No te importa el orden.
		 */
		Set<String> set = new HashSet<>();
		
		set.add("Javi");
		set.add("Carlos");
		set.add("Carlos");
		set.add("Jorge");
		set.add("Niko");
		set.add("Lucy");
		set.add("Carlos");
		set.add("Lucy");
		set.add("Lucy");
		set.add("Lucy");
		
		if(!set.add("Carlos")) {
			System.out.println("Error al insertar");
		}
		
		Iterator<String> j = set.iterator();
		
		while(j.hasNext()) {
			System.out.println(j.next());
		}
		System.out.println("123");
	}
}
