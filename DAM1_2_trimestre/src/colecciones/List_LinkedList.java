package colecciones;

import java.util.LinkedList;

public class List_LinkedList {

	public static void main(String[] args) {
		/**
		 * Se utiliza para implementar la interfaz que permite manejar 
		 * la colección como si fuera una cola. 
		 */
		LinkedList<String> linked = new LinkedList<>();
		
		linked.add("Jose");
		linked.add("Ana");
		linked.add("Lourdes");
		linked.add("Raül");
		linked.add("Fidel");
		linked.add("Arantxa");
		
		linked.removeFirst();
		linked.removeLast();
		
		for (String x: linked) {
			System.out.println(x);
		}
	}

}
