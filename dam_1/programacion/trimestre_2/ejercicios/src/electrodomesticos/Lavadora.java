package electrodomesticos;

public class Lavadora extends Electrodomestico {
	private final double CARGA_BASE = 5.0;
	protected double carga;
	
	public Lavadora() {
		super();
		this.carga = CARGA_BASE;
	}
	
	public Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
		this.carga = CARGA_BASE;
	}
	
	public Lavadora(double carga, String color, char consumoEnergetico, double precioBase, double peso) {
		super(color, consumoEnergetico, precioBase, peso);
		this.carga = carga;
	}
	
	protected double getCarga() {
		return carga;
	}
	
	@Override
	protected double precioFinal() {
		double precioFinal;
		
		precioFinal = super.precioFinal();
		
		if (carga > 30) precioFinal += 50;
			
		return precioFinal;
	}
}
