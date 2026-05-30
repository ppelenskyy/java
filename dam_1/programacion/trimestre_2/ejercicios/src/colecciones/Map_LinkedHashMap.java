package colecciones;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Map_LinkedHashMap {

	public static void main(String[] args) {
		/**
		 * Almacena los objetos del conjunto en
		 * función del orden de inserción.
		 */
		Map<Integer, String> id = new LinkedHashMap<>();
		id.put(6, "Petro");
		id.put(1, "Petro");
		id.put(3, "Petro");
		id.put(5, "Pedro");
		System.out.println(id);
		
		System.out.println(id.get(1));
		System.out.println(id.get(5));
		
		// Imprimir recorriendo con Iterator
		Set set = id.entrySet();
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()) {
		Map.Entry mentry = (Map.Entry)iterator.next();
		System.out.println("Clave: " + mentry.getKey() + " - Valor: "+
		mentry.getValue());
		}
	}

}