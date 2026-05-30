package Ejercicio2;

public class Circulo extends Figura2D {
	private double radio;
	
	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro = 2 * Math.PI * radio;
		return perimetro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/*
	 * Metod equals comprueba si el objeto es el mismo objeto en memoria
	 * comprueba si el objeto es una instancia de circulo
	 * luego se crea un objeto de circulo pasado por parametros,
	 * y se combrueaba si los atributos son iguales si los son devuelve true si no devuelve false
	 * indicando que es diferente.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Circulo))
			return false;
		Circulo other = (Circulo) obj;
		if (super.getNombre() != other.getNombre())
			return false;
		if (Double.doubleToLongBits(radio) != Double.doubleToLongBits(other.radio))
			return false;
		return true;
	}
	
	
}
