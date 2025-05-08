package com.breack.services.controller;

import java.sql.Connection;

import org.mindrot.jbcrypt.BCrypt;

import com.breack.services.Conexion;
import com.breack.services.model.Usuario;

public class LoginController {

    public boolean login(String username, String password) {
        boolean isValid = false;

        // Consulta SQL para verificar las credenciales
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Establecer los parámetros de la consulta
            stmt.setString(1, username);
            stmt.setString(2, password); // Si estás guardando la contraseña de manera en texto plano (lo cual no se recomienda), lo usas directamente aquí.
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Si el usuario existe en la base de datos
                isValid = true;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        
        return isValid;
    }
}