package colecciones;

import java.util.PriorityQueue;
import java.util.Queue;

public class Queue_PriorityQueue {

	public static void main(String[] args) {
		/**
		 * Una cola de prioridad en Java es un tipo especial de cola en el que todos los elementos se ordenansegún su orden natural 
		 * o se basan en un comparador personalizado suministrado en el momento dela creación.
		 * La parte frontal de la cola de prioridad contiene el menor elemento de acuerdo con el orden
		 * especificado, y la parte posterior de la cola de prioridad contiene el mayor elemento.
		 */
		Queue<Integer> cola = new PriorityQueue<>();
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