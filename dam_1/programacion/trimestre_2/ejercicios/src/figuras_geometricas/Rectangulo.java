package figuras_geometricas;

public class Rectangulo extends Figura {
	private double base;
	private double altura;
	
	protected Rectangulo() {
		
	}
	
	protected Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	protected double getBase() {
		return this.base;
	}
	
	protected double getAltura() {
		return this.altura;
	}
	
	protected void setBase(double base) {
		this.base = base;
	}
	
	protected void setAltura(double altura) {
		this.altura = altura;
	}
	
	@Override
	protected double calcularArea() {
		double area = base*altura;
		return area;
	}

	@Override
	protected double calcularPerimetro() {
		double perimetro = 2*(base+altura);
		return perimetro;
	}

}
