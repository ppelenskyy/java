package model;

import interfaces.OperacionesCuenta;

/**
 * Clase abstracta que representa un usuario genérico del sistema.
 * Contiene los atributos comunes y define el comportamiento básico.
 */
public abstract class CuentaUsuario implements OperacionesCuenta {
	private String nombreUsuario;
	private String email;
	private long telefono;
	private int edad;
	
	/**
	 * Constructor que inicializa los datos del usuario.
	 */
	public CuentaUsuario (String nombreUsuario, String email, long telefono, int edad) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.telefono = telefono;
		this.edad = edad;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Método abstracto que obliga a las clases hijas a definir
	 * cómo se muestra la información del usuario.
	 */
	public abstract void mostrarInformacion();
	
}