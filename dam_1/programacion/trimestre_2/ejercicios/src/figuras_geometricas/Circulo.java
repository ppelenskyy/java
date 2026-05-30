package figuras_geometricas;

public class Circulo extends Figura {
	private double radio;
	private final double PI = Math.PI;
	
	protected Circulo() {
		
	}
	
	protected Circulo(double radio) {
		this.radio = radio;
	}
	
	protected double getRadio() {
		return radio;
	}

	protected void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	protected double calcularArea() {
		double area = PI*Math.pow(radio, 2);
		return area;	
	}

	@Override
	protected double calcularPerimetro() {
		double perimetro = PI*(2*radio);
		return perimetro;
	}

}
