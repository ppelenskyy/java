package colecciones;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Set_TreeSet {

	public static void main(String[] args) {
		/**
		 * Almacena los elementos ordenados dentro del conjunto. 
		 * Los elementos almacenados deben implementar la interfaz Comparable (en Clase).
		 */
		Set<String> set = new TreeSet<>();
		
		set.add("Javi");
		set.add("Carlos");
		set.add("Zick");
		set.add("Jorge");
		set.add("Niko");
		set.add("Lucy");
		set.add("Carlos");
		set.add("Lucy");
		set.add("Lucy");
		set.add("Andres");
		
		Iterator<String> j = set.iterator();
		
		while (j.hasNext()) {
			System.out.println(j.next());
		}
	}

}
