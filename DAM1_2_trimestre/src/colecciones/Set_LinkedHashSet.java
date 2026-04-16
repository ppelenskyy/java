package colecciones;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Set_LinkedHashSet {

	public static void main(String[] args) {
		/**
		 * Almacena los objetos del conjunto en función del orden de inserción.
		 */
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("Ocho");
		set.add("Dos");
		set.add("Tres");
		set.add("Uno");
		set.add("Cuatro");
		set.add("Uno");
		
		//Comprobar si se inserta correctamente
		if(!set.add("Tres")) {
		System.out.println("Error al insertar!");
		}
		
		//Imprime: Uno Dos Tres Cuatro
		Iterator<String> j = set.iterator();
		
		while(j.hasNext()) {
		System.out.println(j.next() + " ");
		}

	}

}
