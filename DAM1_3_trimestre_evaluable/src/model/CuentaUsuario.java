package model;

public abstract class CuentaUsuario {
	String nombreUsuario;
	String email;
	int telefono;
	int edad;
	
	public CuentaUsuario (String nombreUsuario, String email, int telefono, int edad) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.telefono = telefono;
		this.edad = edad;
	}
	
	protected abstract void mostrarInformacion();
}
