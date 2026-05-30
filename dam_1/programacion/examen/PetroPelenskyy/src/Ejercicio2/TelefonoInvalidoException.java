package Ejercicio2;

/** 
 * Clase con la propia excepción cuando se genera una excepción se
 * crea un objeto de dicha clase y se pasa el mensaje a clase padre Exception 
 * para luego poder mostrarlo mediante el método getMessage() 
 */
public class TelefonoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TelefonoInvalidoException(String mensaje) {
		super(mensaje);
	}

}
