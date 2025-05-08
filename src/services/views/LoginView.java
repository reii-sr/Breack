package src.services.views;

import java.util.Scanner;
import src.services.controller.LoginController;

public class LoginView {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre de usuario
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine().trim();  // Limpiar espacios al inicio y final

        // Solicitar la contraseña
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine().trim();  // Limpiar espacios al inicio y final

        // Controlador para manejar el login
        LoginController loginController = new LoginController();
        try {
            // Verificar las credenciales
            if (loginController.login(username, password)) {
                System.out.println("Login exitoso.");
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        } catch (Exception e) {
            // Manejo de excepciones si ocurre un error durante el login
            System.out.println("Hubo un problema al intentar realizar el login. Por favor intente más tarde.");
            e.printStackTrace();
        } finally {
            // Cerrar el scanner al final del proceso
            scanner.close();
        }
    }
}
