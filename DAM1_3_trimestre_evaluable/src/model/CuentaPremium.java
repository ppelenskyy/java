package model;

import interfaces.OperacionesCuenta;

public final class CuentaPremium extends CuentaUsuario implements OperacionesCuenta  {
	private int mensajesPublicados = 0;
	
	public CuentaPremium(String nombreUsuario, String email, int telefono, int edad) {
		super(nombreUsuario, email, telefono, edad);
	}

	@Override
	public void actualizarPerfil(String email, int telefono) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void publicarMensaje(String mensaje) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void mostrarInformacion() {
		// TODO Auto-generated method stub
		
	}

}
