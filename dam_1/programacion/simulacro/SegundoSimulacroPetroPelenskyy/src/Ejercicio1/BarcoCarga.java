package Ejercicio1;

public final class BarcoCarga extends Barco {
	private int capacidadPorBodega;
	private int numBodegas;
	
	public BarcoCarga(int id, String nombre, double velocidadMaxima, int capacidadPorBodega, int numBodegas) {
		super(id, nombre, velocidadMaxima);
		this.capacidadPorBodega = capacidadPorBodega;
		this.numBodegas = numBodegas;
	}

	@Override
	public int calcularCapacidad() {
		int cargaTotal = capacidadPorBodega * numBodegas;
		return cargaTotal;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("BarcoCarga [capacidadPorBodega=" + capacidadPorBodega + ", numBodegas=" + numBodegas
		+ ", calcularCapacidad()=" + calcularCapacidad() + "]");

	}

}
