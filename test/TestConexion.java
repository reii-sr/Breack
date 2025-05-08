package test;

import java.sql.Connection;
import src.services.Conexion;

public class TestConexion {
    public static void main(String[] args) {
        Connection conn = Conexion.obtenerConexion();
        if (conn != null) {
            System.out.println("Conexión exitosa!");
        } else {
            System.out.println("Error en la conexión.");
        }
    }
}