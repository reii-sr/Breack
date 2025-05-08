package src.services.controller;

import java.sql.Connection;
import src.services.model.Usuario;
import src.services.Conexion;

public class LoginController {

    public boolean login(String username, String password) {
        // Obtén la conexión
        Connection conn = Conexion.obtenerConexion();
        if (conn != null) {
            // Crea el objeto Usuario y verifica el login
            Usuario usuario = new Usuario(username, password);
            boolean esValido = usuario.validarLogin(conn);

            // Cierra la conexión
            Conexion.cerrarConexion(conn);
            return esValido;
        }
        return false;
    }
}