package colecciones_ejercicio;

import java.util.Objects;

public class Participante {
	private String nombre;
	private String apellidos;
	private final String dni;
	
	public Participante (String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Participante - Nombre: " + nombre + ", Apellidos: " + apellidos + ", DNI: " + dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(dni, other.dni);
	}
}
