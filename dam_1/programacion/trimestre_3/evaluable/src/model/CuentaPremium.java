package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import repository.FicheroCuentas;
import util.Utils;

public final class CuentaPremium extends CuentaUsuario  {
	
	public CuentaPremium(String nombreUsuario, String email, long telefono, int edad) {
		super(nombreUsuario, email, telefono, edad);
	}
	
	@Override
	public void actualizarPerfil(String email, long telefono) {
		String emailAntiguo = getEmail();
		setEmail(email);
		setTelefono(telefono);
		String usuarioActualizado = Utils.formatearUsuario(getNombreUsuario(), getEmail(), getTelefono(), getEdad(), "p");
		FicheroCuentas fc = new FicheroCuentas();
		if (fc.modificarUsuario(emailAntiguo, usuarioActualizado)) {
			System.out.println("\nPerfil actualizado correctamente.");
		}
	}

	@Override
	public void publicarMensaje(String mensaje) {
		if (mensaje.isBlank()) {
			System.out.println("\nMensaje no publicado, está en blanco ó contiene solo espacios.");
			return;
		}
		LocalDateTime f = LocalDateTime.now();
		var fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		FicheroCuentas fc = new FicheroCuentas();
		String fMensaje = getEmail() + ";Cuenta Premium;" + f.format(fechaFormateada) + ";" + mensaje + "\n";
		if (fc.guardarMensaje(fMensaje)) {
			System.out.println("\nMensaje publicado correctamente.");
		}
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("\n--- CUENTA PREMIUM ---");
		System.out.println("Nombre: " + getNombreUsuario() + ", Email: " + getEmail() + ", Teléfono: " + getTelefono() + ", Edad: " + getEdad());
	}
	
}