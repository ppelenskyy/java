package interfaces;

/**
 * Interfaz que define las operaciones básicas que puede realizar un usuario.
 * Obliga a las clases que la implementan a definir estos métodos.
 */
public interface OperacionesCuenta {
	
	/**
	 * Permite actualizar los datos del usuario como email y teléfono.
	 */
	public void actualizarPerfil(String email, long telefono);

	/**
	 * Permite al usuario publicar un mensaje en el sistema.
	 */
	public void publicarMensaje(String mensaje);
	
}