package Ejercicio2;

import java.util.Objects;

public class Rectangulo extends Figura2D {
	private double longitudBase;
	private double longitudAltura;
	
	protected Rectangulo(double longitudBase, double longitudAltura) {
		super("Rectángulo");
		this.longitudBase = longitudBase;
		this.longitudAltura = longitudAltura;
	}
	
	@Override
	public double calcularPerimetro() {
		return longitudBase+longitudAltura;
	}

	@Override
	public String toString() {
		return "Rectangulo [longitudBase=" + longitudBase + ", longitudAltura=" + longitudAltura + ", getNombre()="
				+ getNombre() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(longitudAltura), Double.valueOf(longitudBase));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return Double.doubleToLongBits(longitudAltura) == Double.doubleToLongBits(other.longitudAltura)
				&& Double.doubleToLongBits(longitudBase) == Double.doubleToLongBits(other.longitudBase);
	}
	
	
}
