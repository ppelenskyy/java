package sistema_de_empleados;

/**
 * Desarrolla una aplicación orientada a objetos para gestionar empleados de una empresa. 
 * El sistema debe cumplir las siguientes condiciones:
 * - Existirá una clase abstracta llamada Empleado.
 * - La clase Empleado contendrá al menos un método abstracto llamado calcularSueldo().
 * - Se crearán al menos dos clases que hereden de Empleado (por ejemplo, EmpleadoTiempoCompleto y EmpleadoPorHoras).
 * - Cada subclase deberá implementar el método calcularSueldo().
 * - El sistema deberá aplicar polimorfismo, gestionando todos los empleados mediante referencias del tipo Empleado.
 */

public class Main {

	public static void main(String[] args) {
		GestionEmpleado gE = new GestionEmpleado();
		gE.switchMenu();
	}

}
