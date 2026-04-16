package colecciones;

import java.util.Vector;

public class List_Vector {

	public static void main(String[] args) {
		/**
		 * el vector está sincronizado, lo que significa que solo un subproceso a la vez puede acceder
		 * al código, mientras que arrayList no está sincronizado, lo que significa que varios subprocesos
		 * pueden trabajar con un ArrayList al mismo tiempo —con los problemas que esto puede derivar—.
		 */
		Vector<String> v = new Vector<>();
		
		v.add("Laura");
		v.add("Jorge");
		
		for (String s: v) {
			System.out.println(s);
		}
	}

}
