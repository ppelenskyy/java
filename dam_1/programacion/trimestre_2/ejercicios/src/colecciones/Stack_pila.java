package colecciones;

import java.util.Stack;

public class Stack_pila {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		System.out.println(st.empty());
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		st.add(5);		
		System.out.println("Ultimo elemento: "+st.peek());
		System.out.println("Eliminado: "+st.pop());
		System.out.println("Ultimo elemento: "+st.peek());
		System.out.println("Insertar elemento en la cima: "+st.push(7));
		System.out.println("Ultimo elemento: "+st.peek());
		System.out.println("Posición elemento: "+st.search(2));
		System.out.println("Posición elemento: "+st.search(1));
		
		for (Integer i: st) {
			System.out.println(i);
		}
	}

}
