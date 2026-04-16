package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FicheroCuentas {
	private String path = "C:\\Users\\ppele\\Documents\\DOC\\Projects\\java\\DAM1_3_trimestre_evaluable\\src\\users.txt";
	private String pathMessages = "C:\\Users\\ppele\\Documents\\DOC\\Projects\\java\\DAM1_3_trimestre_evaluable\\src\\usersMessages.txt";
	
	public boolean esUsuario(String email) {
		if (!existeFichero(path)) {
			crearFichero(path);
		}
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[1].equals(email)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}
	
	public void guardarUsuario(String usuario) {
		if (!existeFichero(path)) {
			crearFichero(path);
		} 
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			if (esUsuario((usuario.split(";"))[1])) {
				System.out.println("\nUsuario con este email ya existe.");
				return;
			}
			bw.write(usuario);
			System.out.println("\nUsuario guardado correctamente.");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public boolean publicarMensaje(String Mensaje) {
		if (!existeFichero(pathMessages)) {
			crearFichero(pathMessages);
		} 
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathMessages, true))) {
			bw.write(Mensaje);
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}
	
	public String leerUsuario(String email) {
		try (var br = new BufferedReader(new FileReader(path))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] part = linea.split(";");
				if (part[1].equals(email)) {
					return linea;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}
	
	private boolean existeFichero(String p) {
		if ((new File(p)).exists()) {
			return true;
		}
		return false;
	}
	
	private void crearFichero(String p) {
		File f = new File(p);
		if (!(f.exists())) {
			try {
				f.createNewFile();
			} catch (FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}	
	}
}
