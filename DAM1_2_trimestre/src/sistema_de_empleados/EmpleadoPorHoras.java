package sistema_de_empleados;

public class EmpleadoPorHoras extends Empleado {
	private double sueldoHora = 30;
	private double horasTrabajadas;
	private String nombre, apellidos;
	private String dni;

	protected EmpleadoPorHoras(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	protected double getSueldoHora() {
		return sueldoHora;
	}
	
	protected void setSueldoHora(double sueldoHora) {
		this.sueldoHora = sueldoHora;
	}

	protected double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	protected void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas += horasTrabajadas;
	}

	@Override
	protected String getNombre() {
		return nombre;
	}

	@Override
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	protected String getApellidos() {
		return apellidos;
	}

	@Override
	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	protected String getDni() {
		return dni;
	}

	@Override
	protected void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	protected double calcularSueldo() {
		return sueldoHora * horasTrabajadas;
	}

}
