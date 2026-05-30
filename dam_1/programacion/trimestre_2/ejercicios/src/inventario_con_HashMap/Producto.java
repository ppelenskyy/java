package inventario_con_HashMap;

import java.util.Objects;

public class Producto {
	private final String codigoProducto;
	private String nombre;
	private double precio;
	private int stock;
	private static int codigo = 0;
	
	public Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.codigoProducto = codigoProducto(nombre);
	}
	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Producto - Codigo: " + codigoProducto + " Nombre: " + nombre + " Precio: " + precio + " Stock: " + stock;
	}
	
	private String codigoProducto(String nombre) {
		codigo++;
		return codigo + "_" + nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigoProducto, other.codigoProducto);
	}
}
