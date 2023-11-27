
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection con;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/gestiondulceria";
	private static final String usr = "root";
	private static final String pass = "";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

//metodo conexión 
//connection:interfaz para implementar una sesión cliente-servidor con una base de datos	
	public Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, usr, pass);
			System.out.println("Conexion correcta");
		} catch (SQLException e) {
			System.out.println("Error en conexion");
			e.printStackTrace();
		}
		return con;

	}
}
