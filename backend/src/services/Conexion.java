package backend.services; // o el paquete que estés usando

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    private static final String URL = "jdbc:sqlserver://192.168.1.138:1433;databaseName=BreakPhone2_0;encrypt=true;trustServerCertificate=true";
    private static final String USUARIO = "sa";
    private static final String CONTRASENA = "@123PDR";

    @SuppressWarnings("CallToPrintStackTrace")
    public static Connection obtenerConexion() {
        try {
            // Registrar el driver si es necesario (opcional desde JDBC 4.0)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
        return null;
    }
// Cerrar la conexión
    @SuppressWarnings("CallToPrintStackTrace")
    public static void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
    }