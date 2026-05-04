package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/evento_management";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static Connection conexion;

    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos");
            return conexion;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de MySQL no encontrado");
            throw new ClassNotFoundException("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            throw new SQLException("Error de conexión SQL: " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("✓ Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static boolean estaConectado() {
        try {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
