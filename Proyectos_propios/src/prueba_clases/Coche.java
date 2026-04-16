package prueba_clases;

public class Coche {
	// Atributos o propiedades.
	protected String marca, modelo;
	protected int año, velMax;

	// Métodos constructores.
	protected Coche() {
	}
	
	protected Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	protected Coche(String marca, String modelo, int año, int velMax) {
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.velMax = velMax;
	}
	
	// Métodos getters y setters.
	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	protected String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}

	protected int getAño() {
		return año;
	}

	protected void setAño(int año) {
		this.año = año;
	}

	protected int getVelMax() {
		return velMax;
	}

	protected void setVelMax(int velMax) {
		this.velMax = velMax;
	}

}
