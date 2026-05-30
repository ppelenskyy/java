package figuras_geometricas;

public class Triangulo extends Figura {
	private double lado1, lado2, lado3;
	
	protected Triangulo() {
		
	}
	
	protected Triangulo(double lado1, double lado2, double lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	protected double getLado1() {
		return this.lado1;
	}
	
	protected double getLado2() {
		return this.lado2;
	}
	
	protected double getLado3() {
		return this.lado3;
	}
	
	protected void setLado1(double lado1) {
		this.lado1 = lado1;
	}
	
	protected void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	
	protected void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	@Override
	protected double calcularArea() {
		double perimetro = lado1+lado2+lado3;
		double semiPerimetro = perimetro/2;
		double area = Math.sqrt(semiPerimetro*((semiPerimetro-lado1)*(semiPerimetro-lado2)*(semiPerimetro-lado3)));
		return area;
	}

	@Override
	protected double calcularPerimetro() {
		double perimetro = lado1+lado2+lado3;
		return perimetro;
	}

}