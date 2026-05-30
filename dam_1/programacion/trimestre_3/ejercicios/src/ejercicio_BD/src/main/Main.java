package main;

import data_base.GestionBD;

public class Main {

	public static void main(String[] args) {
		GestionBD gbd = new GestionBD();
		gbd.agregarAlumno();
		gbd.mostrarAlumnos();
	}

}
