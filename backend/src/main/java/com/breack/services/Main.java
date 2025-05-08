package com.breack.services;

import com.breack.services.controller.LoginController;

public class Main {
    public static void main(String[] args) {
        // Lógica de tu aplicación aquí
        System.out.println("Sistema iniciado");

        // Ejemplo de cómo llamar a un controlador
        LoginController loginController = new LoginController();
        boolean loginSuccess = loginController.login("usuario", "contraseña");
        if (loginSuccess) {
            System.out.println("Login exitoso.");
        } else {
            System.out.println("Login fallido.");
        }
    }
}