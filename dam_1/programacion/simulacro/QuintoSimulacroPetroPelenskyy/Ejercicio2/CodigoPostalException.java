package Ejercicio2;

public class CodigoPostalException extends Exception {
	
	/*
	 * Constructo recibe por parametros el mensaje y 
	 * lo manda al constructor de la clase Exception
	 */
	public CodigoPostalException(String mensaje) {
		super(mensaje);
	}
}
