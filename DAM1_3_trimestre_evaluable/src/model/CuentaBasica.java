package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import interfaces.OperacionesCuenta;
import util.FicheroCuentas;

public final class CuentaBasica extends CuentaUsuario implements OperacionesCuenta {
	private int limiteMensajes = 5;
	private int mensajesPublicados = 0;

	public CuentaBasica(String nombreUsuario, String email, int telefono, int edad) {
		super(nombreUsuario, email, telefono, edad);
	}
	
	public int getLimiteMensajes() {
		return limiteMensajes;
	}

	public void setLimiteMensajes(int limiteMensajes) {
		this.limiteMensajes = limiteMensajes;
	}

	@Override
	public void actualizarPerfil(String email, int telefono) {
		super.email = email;
		super.telefono = telefono;
		System.out.println("\nPerfil actualizado correctamente.");
	}

	@Override
	public void publicarMensaje(String mensaje) {
		if (limiteMensajes > 0) {
			LocalDateTime f = LocalDateTime.now();
			var fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			FicheroCuentas fc = new FicheroCuentas();
			String fMensaje = email + ";" + "Usuario Básico" + f.format(fechaFormateada) + ";" + mensaje;
			if (fc.publicarMensaje(fMensaje)) {
				mensajesPublicados++;
				limiteMensajes--;
				System.out.println("\nMensaje publicado correctamente.");
			} else {
				System.out.println("\nError: mensaje no publicado.");
			}
		} else {
			System.out.println("\nNo puedes publicar mas mensajes límite mensual alcanzado.");
		}
	}

	@Override
	protected void mostrarInformacion() {
		// TODO Auto-generated method stub
		
	}

}
