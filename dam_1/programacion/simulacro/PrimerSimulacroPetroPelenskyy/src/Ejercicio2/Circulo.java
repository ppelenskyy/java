package Ejercicio2;

import java.util.Objects;

public class Circulo extends Figura2D {
	private double radio;
	
	protected Circulo(double radio) {
		super("Círculo");
		this.radio = radio;
	}
	
	@Override
	public double calcularPerimetro() {
		return 2*Math.PI*radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", getNombre()=" + getNombre() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(radio));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		return Double.doubleToLongBits(radio) == Double.doubleToLongBits(other.radio);
	}
	
	
}
