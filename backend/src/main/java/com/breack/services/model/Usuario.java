package com.breack.services.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private final String username;
    private final String password;
    
    // Constructor
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // Método para validar el login
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean validarLogin(Connection conn) {
        String query = "SELECT ContrasenaHash FROM Usuarios WHERE NombreUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, this.username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("ContrasenaHash");
                // Compara el hash de la contraseña proporcionada con el almacenado
                if (storedHash.equals(this.hashPassword(this.password))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para hacer el hash de la contraseña con SHA-256
    @SuppressWarnings("CallToPrintStackTrace")
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método principal para probar el hash
    public static void main(String[] args) {
        Usuario u = new Usuario("breackadm", "admin123");
        System.out.println("Hash generado: " + u.hashPassword("admin123"));
    }
}
