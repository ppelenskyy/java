package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroCuentas {
	private String path = "./src/users.txt";
	private String pathTemporal = "./src/usersTemporal.txt";
	private String pathMessages = "./src/usersMessages.txt";
	private String pathMessagesTemporal = "./src/usersMessagesTemporal.txt";
	
	/**
	 * Guarda un usuario en el fichero de texto users.txt.
	 * Si el fichero no existe, lo crea automáticamente.
	 * @param usuario formateado con delimitadores ';' para ser almacenado directamente en el archivo users.txt
	 *  con datos como el nombre, el email, el número de teléfono, 
	 *  la edad y el tipo de usuario('p' para premium y 'b' para básico)
	 */
	public void guardarUsuario(String usuario) {
		if (!existeFichero(path)) {
			crearFichero(path);
		} 
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			bw.write(usuario);
			System.out.println("\nUsuario guardado correctamente.");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Guarda un mensaje en el fichero de mensajes usersMessages.txt.
	 * Si el fichero no existe, lo crea automáticamente.
	 * @param mensaje formateado con email, tipo de cuenta, fecha y el mensaje en cuestión
	 * @return true si se ha guardado correctamentey false en caso contrario.
	 */
	public boolean guardarMensaje(String mensaje) {
		if (!existeFichero(pathMessages)) {
			crearFichero(pathMessages);
		} 
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathMessages, true))) {
			bw.write(mensaje);
			return true;
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}
	
	/**
	 * Modifica los datos de un usuario en el fichero users.txt y en caso 
	 * de tener mensajes publicados también actualiza sus mensajes con el nuevo email 
	 * en el archivo usersMessages.txt.
	 * @param email email antiguo
	 * @param usuarioActualizado 
	 * 		cadena de texto del usuario formateado para ser guardado
	 * 		en el fichero users.txt con el nuevo email y número de teléfono
	 * @return true si se ha modificado correctamente y false en caso contrario
	 */
	public boolean modificarUsuario(String email, String usuarioActualizado) {
		boolean modificado = false;
		try (BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(pathTemporal))) {
			String linea;
			if (!existeFichero(pathTemporal)) {
				crearFichero(pathTemporal);
			}
			File f = new File(path);
			File ft = new File(pathTemporal);
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[1].equals(email)) {
					bw.write(usuarioActualizado);
					if (existeMensaje(email)) {
						String[] partUsuario = usuarioActualizado.split(";");
						String emailNuevo = partUsuario[1];
						modificarEmailMensaje(email, emailNuevo);
					}
					modificado = true;
				} else {
					bw.write(linea + "\n");
				}
			}
			eliminarRenombrarFichero(f, ft);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return modificado;
	}
	
	/**
	 * Actualiza el email en los mensajes asociados a un usuario.
	 * @param email antiguo
	 * @param emailNuevo email nuevo
	 */
	private void modificarEmailMensaje(String email, String emailNuevo) {
		try (BufferedReader br = new BufferedReader(new FileReader(pathMessages));
			BufferedWriter bw = new BufferedWriter(new FileWriter(pathMessagesTemporal))) {
			String linea;
			if (!existeFichero(pathMessagesTemporal)) {
				crearFichero(pathMessagesTemporal);
			}
			File f = new File(pathMessages);
			File ft = new File(pathMessagesTemporal);
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[0].equals(email)) {
					String mensajeModificado = emailNuevo + ";" + part[1] + ";" + part[2] + ";" + part[3] + "\n";
					bw.write(mensajeModificado);
				} else {
					bw.write(linea + "\n");
				}
			}
			eliminarRenombrarFichero(f, ft);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Muestra todos los mensajes de un usuario concreto.
	 * @param email del usuario
	 */
	public void mostrarMensaje(String email) {
		boolean existe = false;
		if (!existeFichero(pathMessages)) {
			System.out.println("\nNo hay mensajes guardados en la aplicación.");
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(pathMessages))){
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[0].equals(email)) {
					System.out.println("\nEmail: " + part[0] + " Tipo cuenta: " + part[1] + " Fecha: " + part[2]);
					System.out.println("Mensaje: " + part[3]);
					existe = true;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		if (!existe) {
			System.out.println("\nEl usuario no ha publicado ningún mensaje.");
		}
	}
	
	/**
	 * Elimina un usuario del fichero.
	 * @param email del usuario a eliminar
	 * @return true si se ha eliminado correctamente y false en caso contrario
	 */
	public boolean eliminarUsuario(String email) {
		boolean eliminado = false;
		try (BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(pathTemporal))) {
			String linea;
			if (!existeFichero(pathTemporal)) {
				crearFichero(pathTemporal);
			}
			File f = new File(path);
			File ft = new File(pathTemporal);
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[1].equals(email)) {
					eliminado = true;
					continue;
				} else {
					bw.write(linea + "\n");
				}
			}
			eliminarRenombrarFichero(f, ft);
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return eliminado;
	}
	
	/**
	 * Busca y devuelve un usuario del fichero a partir de su email.
	 * @param email del usuario a buscar
	 * @return 
	 * 		String linea con todos los datos del usuario encontrado 
	 * 		si no lo encuentra devuelve null
	 */
	public String leerUsuario(String email) {
		try (var br = new BufferedReader(new FileReader(path))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[1].equals(email)) {
					return linea;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}
	
	/**
	 * Comprueba si un usuario existe en el fichero.
	 * @param email del usuario a comprobar
	 * @return 
	 * 		devuelve true en caso afirmativo y 
	 * 		false si no tiene mensajes o no existe el fichero
	 */
	public boolean existeUsuario(String email) {
		if (!existeFichero(path)) {
			return false;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[1].equals(email)) {
					return true;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}
	
	/**
	 * Comprueba si un usuario tiene mensajes publicados.
	 * @param email del usuario a comprobar
	 * @return 
	 * 		devuelve true en caso afirmativo y 
	 * 		false si no tiene mensajes o no existe el fichero
	 */
	public boolean existeMensaje(String email) {
		if (!existeFichero(pathMessages)) {
			return false;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(pathMessages))){
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[0].equals(email)) {
					return true;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}
	
	/**
	 * Elimina y renombra el fichero temporal.
	 * @param f fichero original
	 * @param ft fichero temporal
	 */
	private void eliminarRenombrarFichero(File f, File ft) {
		if (f.delete()) {
		    if (ft.renameTo(f)) {
		        System.out.println("\nArchivo actualizado correctamente.");
		    } else {
		        System.out.println("\nError al renombrar el archivo temporal.");
		    }
		} else {
		    System.out.println("\nError al eliminar el archivo original.");
		}
	}
	
	/**
	 * Comprueba si un fichero existe.
	 * @param ruta del fichero
	 * @return true si existe y false en caso contrario
	 */
	private boolean existeFichero(String p) {
		if ((new File(p)).exists()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Crea un fichero.
	 * @param ruta del fichero
	 */
	private void crearFichero(String p) {
		File f = new File(p);
		if (!(f.exists())) {
			try {
				f.createNewFile();
				System.out.println("\nFichero creado correctamente.");
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}	
	}
	
}
