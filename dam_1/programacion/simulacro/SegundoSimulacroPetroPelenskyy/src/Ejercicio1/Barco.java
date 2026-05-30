package Ejercicio1;

public abstract class Barco implements Capacidad {
	private int id;
	private String nombre;
	private double velocidadMaxima;
	
	public Barco(int id, String nombre, double velocidadMaxima) {
		this.id = id;
		this.nombre = nombre;
		this.velocidadMaxima = velocidadMaxima;
	}
	
	public abstract void mostrarInformacion();
	
}
