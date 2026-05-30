package Ejercicio1;

public final class BarcoPasajeros extends Barco {
	private int numCamarotes;
	private int pasajerosPorCamarote;

	public BarcoPasajeros(int id, String nombre, double velocidadMaxima, int numCamarotes, int pasajerosPorCamarote) {
		super(id, nombre, velocidadMaxima);
		this.numCamarotes = numCamarotes;
		this.pasajerosPorCamarote = pasajerosPorCamarote;
	}

	@Override
	public int calcularCapacidad() {
		int numeroTotalPasajeros = numCamarotes * pasajerosPorCamarote;
		return numeroTotalPasajeros;
	}
	
	@Override
	public void mostrarInformacion() {
		System.out.println("BarcoPasajeros [numCamarotes=" + numCamarotes + ", pasajerosPorCamarote=" + pasajerosPorCamarote
				+ ", calcularCapacidad()=" + calcularCapacidad() + "]");

	}

}
