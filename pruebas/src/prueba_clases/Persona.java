package prueba_clases;
public class Persona {
	// Atributos o propiedades.
	protected String nombre, apellidos, dni;
	
	// Métodos constructores.
	protected Persona() {	
	}
	
	protected Persona (String nombre) {
		this.nombre = nombre;
	}
	
	protected Persona(String nombre, String apellidos) {	
		this.nombre = nombre;
		this.apellidos = apellidos;
		System.out.println("El nombre es: "+nombre+" y el apellido es: "+apellidos);
	}
	
	protected Persona(String nombre, String apellidos, String dni) {	
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	// Métodos getters y setters.
	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}
	
}
