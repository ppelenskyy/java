package figuras_geometricas;

public class Cuadrado extends Figura {
	private double lado;
	
	protected Cuadrado() {
		
	}
	
	protected Cuadrado(double lado) {
		this.lado = lado;
	}
	
	protected double getLado() {
		return this.lado;
	}
	
	protected void setLado(double lado) {
		this.lado = lado;
	}
	
	@Override
	protected double calcularArea() {
		double area = Math.pow(lado, 2);
		return area;
	}

	@Override
	protected double calcularPerimetro() {
		double perimetro = 4*lado;
		return perimetro;
	}

}