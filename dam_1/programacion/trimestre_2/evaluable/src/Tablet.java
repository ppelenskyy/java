/**
 * Clase molde para crear objetos de tipo Tablet.
 */
public class Tablet {
	/**
	 *  Atributo estatico se utiliza para generar IMEI único,
	 *  se autoincrementa con cada nueva instancia de la clase Tablet.
	 */
	private static int numTablet = 0;
	
	// Atributos.
	private final String DNI_SIN_COMPRADOR = "00000000Z";
	private String imei;
	private String marca;
	private String modelo;
	private String color;
	private double precio;
	private String dniComprador;
	
	/**
	 * Método Constructor.
	 * 
	 * Al crear un objeto nuevo se tienen que pasar practicamente todos los atributos como parámetros,
	 * menos imei (se genera automaticamente con método generarImei()) y 
	 * el dniComprador que se asigna al realizar la venta de la tablet.
	 * 
	 * @param marca
	 * @param modelo
	 * @param color
	 * @param precio
	 */

	protected Tablet(String marca, String modelo, String color, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.imei = generarImei();
		this.dniComprador = DNI_SIN_COMPRADOR;
	}
	 
	// Métodos Getters y Setters.
	protected String getMarca() {
		return marca;
	}

	protected String getModelo() {
		return modelo;
	}

	protected String getColor() {
		return color;
	}

	protected double getPrecio() {
		return precio;
	}

	protected String getImei() {
		return imei;
	}

	protected String getDniComprador() {
		return dniComprador;
	}
	
	protected void setDniComprador(String dniComprador) {
		this.dniComprador = dniComprador;
	}

	// Método toString.
	@Override
	public String toString() {
		return "Tablet IMEI: " + imei + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Precio: "
				+ precio + " €";
	}

	/**
	 * Método utilizado para generar un IMEI único.
	 *
	 * El IMEI se genera a partir de la conversión de la primera y última letra
	 * de los atributos marca, modelo y color a valores numéricos. Estos valores
	 * se concatenan junto con un contador estático que se autoincrementa con cada
	 * nueva instancia de la clase Tablet, garantizando que el IMEI sea único.
	 *
	 * Finalmente, se comprueba la longitud del IMEI y se ajusta a 15 dígitos
	 * añadiendo ceros si es necesario.
	 *
	 * @return IMEI generado de 15 dígitos.
	 */
	private String generarImei() {
		String imei = "";
		int longitud, numPrimera, numUltima;
		char letraPrimera, letraUltima;	
		longitud = this.marca.length();
		if (longitud == 0) {
			numPrimera = 999;
			numUltima = 999;
		} else {
			letraPrimera  = this.marca.charAt(0);
			letraUltima = this.marca.charAt(longitud-1);
			numPrimera = (int) letraPrimera;
			numUltima = (int) letraUltima;
		}
		imei += Integer.toString(numPrimera, numUltima);
		longitud = this.modelo.length();
		if (longitud == 0) {
			numPrimera = 999;
			numUltima = 999;
		} else {
			letraPrimera  = this.modelo.charAt(0);
			letraUltima = this.modelo.charAt(longitud-1);
			numPrimera = (int) letraPrimera;
			numUltima = (int) letraUltima;	
		}
		imei += Integer.toString(numPrimera, numUltima);
		longitud = this.color.length();
		if (longitud == 0) {
			numPrimera = 999;
			numUltima = 999;
		} else {
			letraPrimera  = this.color.charAt(0);
			letraUltima = this.color.charAt(longitud-1);
			numPrimera = (int) letraPrimera;
			numUltima = (int) letraUltima;
		}
		imei += Integer.toString(numPrimera, numUltima);
		numTablet++;
		imei += Integer.toString(numTablet);
		if (imei.length() < 15 || imei.length() > 15) {
			if (imei.length() < 15) {
				while (imei.length() < 15) {
					imei += "0";
				}
			} else if (imei.length() > 15) {
				imei = imei.substring(0, 15);
			}
		}
		return imei;
	}
	
}
