package data_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static final String connector = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/uem";
	private static final String user = "user";
	private static final String password = "";
	
	public static Connection conectar() {
		try {
			Class.forName(connector);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("\nError: controlador no encontrado.");
			e.getStackTrace();
		} catch (SQLException e) {
			System.out.println("\nError: de conexión.");
			e.getStackTrace();
		}
		return null;
	}
	
	public static void desconectar(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("\nDesconectado correctamente.");
			}
		} catch (SQLException e) {
			System.out.println("\nError: al cerrar la conexión.");
		}
	}
	
}
