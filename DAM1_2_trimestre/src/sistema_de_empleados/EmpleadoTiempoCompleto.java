package sistema_de_empleados;

public class EmpleadoTiempoCompleto extends Empleado {
	private double sueldoAnual = 30000;
	private String nombre, apellidos;
	private String dni;

	protected EmpleadoTiempoCompleto(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	protected double getSueldoAnual() {
		return sueldoAnual;
	}

	protected void setSueldoAnual(double sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
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
		return sueldoAnual/12;
	}

}
