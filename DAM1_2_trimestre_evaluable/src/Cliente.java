/**
 * Clase molde para crear objetos de tipo Cliente.
 */
public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	
	/**
	 * Método contructor.
	 * 
	 * Al crear un objeto nuevo se pasan por parametros
	 * todos lo atributos para dejar el cliente con todos los
	 * datos necesarios.
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 */
	protected Cliente(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	// Métodos Getters.
	protected String getDni() {
		return dni;
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	// Método toString.
	@Override
	public String toString() {
		return "Cliente Dni: " + dni + ", Nombre: " + nombre + ", Apellidos: " + apellidos;
	}
	
}
