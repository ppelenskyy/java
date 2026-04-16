package electrodomesticos;

public class Electrodomestico {
	private final double[] CONSUMO_PRECIO = {100,80,60,50,30,10};
	private final char[] ARRAY_CONSUMO = {'A','B','C','D','E','F'};
	private final String[] ARRAY_COLOR = {"blanco","negro","rojo","azul","gris"};

	private final String COLOR_BASE = "blanco";
	private final char CONSUMO_BASE= 'F';
	private final double PRECIO_BASE = 100;
	private final double PESO_BASE = 5;

	protected String color;
	protected char consumoEnergetico;
	protected double precioBase;
	protected double peso;
	
	protected Electrodomestico() {
		this.color = COLOR_BASE;
		this.consumoEnergetico = CONSUMO_BASE;
		this.precioBase = PRECIO_BASE;
		this.peso = PESO_BASE;
			
	}

	protected Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = COLOR_BASE;
		this.consumoEnergetico = CONSUMO_BASE;
	}

	protected Electrodomestico(String color, char consumoEnergetico, double precioBase, double peso) {
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.precioBase = precioBase;
		this.peso = peso;	
	}

	protected char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	protected double getPeso() {
		return peso;
	}

	protected double getPrecioBase() {
		return precioBase;
	}

	protected String getColor() {
		return color;
	}
	
	private char comprobarConsumoEnergetico(char letra) {
		letra = Character.toUpperCase(letra);
		
		for (char l: ARRAY_CONSUMO) {
			if (l == letra) {
				return letra;
			}
		}
		return 'F';
	}
	
	private String comprobarColor(String color) {
		color = color.toLowerCase();
		
		for (String c: ARRAY_COLOR) {		
			if (c.equals(color)) {
				return color;
			}
		}
		return "blanco";
	}
	
	protected double precioFinal() {
		double precioFinal; 
		
		precioFinal = this.precioBase;
		
		for (int i = 0; i < ARRAY_CONSUMO.length; i++) {
			if (ARRAY_CONSUMO[i] == this.consumoEnergetico) {
				precioFinal += CONSUMO_PRECIO[i]; 
			}
		}
		
		if (this.peso < 20) 
			precioFinal += 10;
		else if (this.peso > 19 && this.peso < 50) 
			precioFinal += 50;
		else if (this.peso > 49 && this.peso < 80) 
			precioFinal += 80;
		else 
			precioFinal += 100;
		
		return precioFinal;	
	}
	
}
