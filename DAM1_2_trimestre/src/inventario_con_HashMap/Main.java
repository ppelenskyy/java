package inventario_con_HashMap;

/**
 * Desarrolla un sistema de gestión de inventario para una tienda. Debes implementar un programa en Java que utilice un HashMap para almacenar productos, donde:
 * 
 * 1. Clave: El código único del producto (String).
 * 2. Valor: Un objeto de la clase Producto, que contiene:
 * 	- nombre (String)
 * 	- precio (double)
 * 	- stock (int) (cantidad disponible)
 * 
 * El programa debe permitir las siguientes operaciones:
 * 
 * - Agregar un producto al inventario.
 * - Buscar un producto por su código y mostrar sus detalles.
 * - Actualizar el stock de un producto.
 * - Eliminar un producto del inventario.
 * - Mostrar todos los productos almacenados
 */
public class Main {

	public static void main(String[] args) {
		Gestion g = new Gestion();
		g.switchMenu();
	}

}
