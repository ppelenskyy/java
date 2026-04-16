package Ejercicio2;

public abstract class Figura2D implements FiguraGeometrica {
	private String nombre;
	
	protected Figura2D(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract double calcularPerimetro();
}
