package Ejercicio2;

import java.util.Objects;

public class Triangulo extends Figura2D {
	private double longitud1;
	private double longitud2;
	private double longitud3;
	
	protected Triangulo(double longitud1, double longitud2, double longitud3) {
		super("Triángulo");
		this.longitud1 = longitud1;
		this.longitud2 = longitud2;
		this.longitud3 = longitud3;
	}

	@Override
	public double calcularPerimetro() {
		return longitud1+longitud2+longitud3;
	}

	@Override
	public String toString() {
		return "Triangulo [longitud1=" + longitud1 + ", longitud2=" + longitud2 + ", longitud3=" + longitud3
				+ ", getNombre()=" + getNombre() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(longitud1), Double.valueOf(longitud2), Double.valueOf(longitud3));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangulo other = (Triangulo) obj;
		return Double.doubleToLongBits(longitud1) == Double.doubleToLongBits(other.longitud1)
				&& Double.doubleToLongBits(longitud2) == Double.doubleToLongBits(other.longitud2)
				&& Double.doubleToLongBits(longitud3) == Double.doubleToLongBits(other.longitud3);
	}
	
	

	
	
}
