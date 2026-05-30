package sistema_de_empleados;

public abstract class Empleado {
	
	public Empleado() {
		
	}
	
	protected abstract String getNombre();

	protected abstract void setNombre(String nombre);
	
	protected abstract String getApellidos();

	protected abstract void setApellidos(String apellidos);

	protected abstract String getDni();

	protected abstract void setDni(String dni);
	
	protected abstract double calcularSueldo();
	
}
