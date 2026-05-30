package electrodomesticos;

public class Television extends Electrodomestico {
	private final double RESOLUCION_BASE = 20;
	private final boolean SINTONIZADOR_TDT_BASE = false;
	
	protected double resolucion;
	protected boolean sintonizadorTDT;
	
	protected Television() {
		super();
		this.resolucion = RESOLUCION_BASE;
		this.sintonizadorTDT = SINTONIZADOR_TDT_BASE;
	}
	
	protected Television(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = RESOLUCION_BASE;
		this.sintonizadorTDT = SINTONIZADOR_TDT_BASE;
		
	}
	
	protected Television(double resolucion, boolean sintonizadorTDT, String color, char consumoEnergetico, double precioBase, double peso) {
		super(color, consumoEnergetico, precioBase, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
	}

	protected double getResolucion() {
		return resolucion;
	}

	protected boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}
	
	@Override
	protected double precioFinal() {
		double precioFinal;
		
		precioFinal = super.precioFinal();
		
		if (resolucion > 40) precioFinal *= 1.3;
		if (sintonizadorTDT) precioFinal += 50;
		
		return precioFinal;
	}
	
}
