package Ejercicio2;

public class Rectangulo extends Figura2D {
	private double longitudBase;
	private double longitudAltura;
	
	public Rectangulo(String nombre, double longitudBase, double longitudAltura) {
		super(nombre);
		this.longitudBase = longitudBase;
		this.longitudAltura = longitudAltura;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro;
		perimetro = 2*(longitudAltura + longitudBase);
		return perimetro;
	}

	/*
	 * Metod equals comprueba si el objeto es el mismo objeto en memoria
	 * comprueba si el objeto es una instancia de Rectangulo
	 * luego se crea un objeto de rectangulo pasado por parametros,
	 * y se combrueaba si los atributos son iguales si los son devuelve true si no devuelve false
	 * indicando que es diferente.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rectangulo))
			return false;
		Rectangulo other = (Rectangulo) obj;
		if (super.getNombre() != other.getNombre())
			return false;
		if (Double.doubleToLongBits(longitudAltura) != Double.doubleToLongBits(other.longitudAltura))
			return false;
		if (Double.doubleToLongBits(longitudBase) != Double.doubleToLongBits(other.longitudBase))
			return false;
		return true;
	}
	
}
