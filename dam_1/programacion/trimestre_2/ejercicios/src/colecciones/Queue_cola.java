package colecciones;

import java.util.LinkedList;
import java.util.Queue;


public class Queue_cola {

	public static void main(String[] args) {
		Queue<Integer> cola = new LinkedList<>();
		cola.add(165);
		cola.add(1);
		cola.add(3);
		cola.add(14);
		cola.add(16);
		System.out.println("Primer elemento: "+cola.peek());
		System.out.println("Eliminado: "+cola.poll());
		System.out.println("Primer elemento: "+cola.element());
	}

}
