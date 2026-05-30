/**
 * VENTA DE TABLETS
 * 
 * - Desarrollar una aplicación que me permita gestionar la compra y venta de tablets
 *   en la tienda.
 *   
 * - Debes de guardar diferentes tipos de tablets y clientes. TÚ decides qué
 *   propiedades tienen las tablets y cuáles los clientes.
 * 
 * - Debes de tener una o varias arrays para guardar las tablets que están disponibles
 * 	 para vender y realizar las ventas a los clientes.
 * 
 * - Haz un menú para que el usuario vea las diferentes opciones que puede realizar:
 * 		1.- Dar de alta una tablet. Comprobar que esa tablet no exista.
 * 		2.- Dar de alta un cliente. Comprobar que ese cliente no existe.
 * 		3.- Vender una tablet a un cliente.
 * 		4.- Mostrar tablets disponibles para la venta.
 * 		5.- Mostrar tablets compradas por un cliente en concreto.
 * 		6.- Salir.
 * 
 * @author Petro Pelenskyy Pelenskyy
*/

/**
 * Clase principal por donde empieza a ejecutarse el programa.
 */
public class Main {
	
	public static void main(String[] args) {
		// Crear objeto gt de la clase GestionTienda.
		GestionTienda gt = new GestionTienda();
		// Llamar al método switchMenu de la clase GestionTienda utilizando el objeto creado.
		gt.switchMenu();
	}

}
