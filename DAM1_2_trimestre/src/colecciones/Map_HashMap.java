package colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map_HashMap {

	public static void main(String[] args) {
		/**
		 * Almacena las claves en una tabla hash. Es la más usada debido a su alto rendimiento y 
		 * a que, en muchas ocasiones, el orden de los elementos no es lo más relevante.
		 */
		Map<String, Integer> edad = new HashMap<>();
		edad.put("Petro", 45);
		edad.put("Jorge", 18);
		edad.put("Anastasio", 20);
		edad.put("Belt", 30);
		System.out.println(edad);
		
		System.out.println(edad.get("Petro"));
		System.out.println(edad.get("Belt"));
			
		Set set = edad.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			System.out.println("Clave: "+me.getKey()+" - VALOR - "+me.getValue());
		}
	}

}
