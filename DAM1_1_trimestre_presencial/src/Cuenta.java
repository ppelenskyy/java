public class Cuenta {
	// Atributos.
	protected final double CANTIDAD = 0.0;
	protected double cantidad;
	protected String titular;
	
	// Métdodos contructores.
	public Cuenta() {
		
	}
	public Cuenta(String titular) {
		this.titular = titular;
		cantidad = CANTIDAD;
	}
	
	public Cuenta(String titular , double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	
	// Getters and Setters.
	protected double getCantidad() {
		return cantidad;
	}

	protected void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	protected String getTitular() {
		return titular;
	}

	protected void setTitular(String titular) {
		this.titular = titular;
	}
	
	// Método toString.
	@Override
	public String toString() {
		return "Cuenta cantidad = " + cantidad + " €, titular = " + titular + "]";
	}
	
	//-------------------------------------------------------------------------------------------------
	// Métodos especiales.
	//-------------------------------------------------------------------------------------------------
	
	// ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
	protected void ingresar(double cantidad) {
		if (cantidad < 0) System.out.println("La cantidad a ingresar no puede ser negativa");
		else {
			this.cantidad += cantidad;
			System.out.println(cantidad+" € ingeresado/s correctamente.");
			System.out.println("Nuevo saldo disponible: "+this.cantidad+" €");	
		}
	}
	
	// retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.
	protected void retirar(double cantidad) {
		if ((this.cantidad - cantidad) < 0) this.cantidad = 0;
		else {
			this.cantidad -= cantidad;
			System.out.println(cantidad+" € retirado/s correctamente.");
			System.out.println("Nuevo saldo disponible: "+this.cantidad+" €");	
		}
	}
	
}
