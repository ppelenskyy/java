package data_base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestionBD {
	
	public void agregarAlumno() {
		Scanner sc = new Scanner(System.in);
		String nombre, fecha_nacimiento;
		String anio;
		String mes;
		String dia;
		System.out.println("AGREGAR ALUMNO");
		System.out.print("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("FECHA DE NACIMIENTO");
		System.out.print("Año: ");
		anio = sc.nextLine();
		System.out.print("Mes: ");
		mes = sc.nextLine();
		System.out.print("Día: ");
		dia = sc.nextLine();
		fecha_nacimiento = anio + "-" + mes + "-" + dia;
		String sql = "INSERT INTO alumnos (nombre, fecha_nacimiento) "
				+ "VALUES ('"+ nombre +"', '"+ fecha_nacimiento+"')";
		Connection con = ConexionBD.conectar();
		try {
			Statement st = con.createStatement();
			int filas = st.executeUpdate(sql);
			if (filas > 1) {
				System.out.println("\nAlumno agregado correctamente.");
			}
		} catch (SQLException e) {
			System.out.println("\nError: al agregar alumno.");
			e.getStackTrace();
		}
	}
	
	public void mostrarAlumnos() {
		String sql = "SELECT id, nombre, fecha_nacimiento, TIMESTAMPDIFF(YEAR"
				+ ", fecha_nacimiento, NOW()) AS edad FROM alumnos";
		Connection con = ConexionBD.conectar();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " 
			+ rs.getDate("fecha_nacimiento") + " " + rs.getInt("edad"));
			}
		} catch (SQLException e) {
			System.out.println("Error: al consultar alumnos.");
		} finally {
			ConexionBD.desconectar(con);
		}
	}
}
