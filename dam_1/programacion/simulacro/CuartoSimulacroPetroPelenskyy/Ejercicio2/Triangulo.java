package Ejercicio2;

public class Triangulo extends Figura2D {
	private double longitud1;
	private double longitud2;
	private double longitud3;
	
	public Triangulo(String nombre, double longitud1, double longitud2, double longitud3) {
		super(nombre);
		this.longitud1 = longitud1;
		this.longitud2 = longitud2;
		this.longitud3 = longitud3;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro;
		perimetro = longitud1 + longitud2 + longitud3;
		return perimetro;
	}

	/*
	 * Metod equals comprueba si el objeto es el mismo objeto en memoria
	 * comprueba si el objeto es una instancia de Triangulo
	 * luego se crea un objeto de triangulo pasado por parametros,
	 * y se combrueaba si los atributos son iguales si los son devuelve true si no devuelve false
	 * indicando que es diferente.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Triangulo))
			return false;
		Triangulo other = (Triangulo) obj;
		if (super.getNombre() != other.getNombre())
			return false;
		if (Double.doubleToLongBits(longitud1) != Double.doubleToLongBits(other.longitud1))
			return false;
		if (Double.doubleToLongBits(longitud2) != Double.doubleToLongBits(other.longitud2))
			return false;
		if (Double.doubleToLongBits(longitud3) != Double.doubleToLongBits(other.longitud3))
			return false;
		return true;
	}
	

}
