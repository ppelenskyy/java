public class ForAnidado {
	
	public static void main (String[] args) {
		
		int numeroFilas = 10, numeroColumnas = 10;
	
		/* Recorrer todas las filas y las columnas de un tablero de ajedrez variable
		* que recibimos como parámetro tanto el número de filas como de columnas. */
			
		for (int indiceFila = 1; indiceFila <= numeroFilas; indiceFila++) {
			/* Para cada fila que recorremos con el índice indiceFila para la primera
			 * dimensión, para recorrer las columnas con otro indiceColumna
			 * para la segunda dimensión. */
			 for (int indiceColumna = 1; indiceColumna <= numeroColumnas; indiceColumna++){
			 //...e imprimir el valor de la posición de la Fila y la Columna
			 System.out.println("Fila: " + indiceFila + " Columna: " + indiceColumna);
			 }
		}
	}
	
}