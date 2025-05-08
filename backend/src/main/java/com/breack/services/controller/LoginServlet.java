package com.breack.services.controller;

import java.io.IOException;
import java.io.InputStream;  // Corregido aquí

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.breack.services.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Leer el cuerpo JSON de la solicitud
        InputStream inputStream = request.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario loginRequest = objectMapper.readValue(inputStream, Usuario.class); // Mapea el JSON a un objeto Usuario

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        LoginController loginController = new LoginController();
        boolean isValid = loginController.login(username, password);

        // Configurar la respuesta HTTP
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (isValid) {
            response.setStatus(HttpServletResponse.SC_OK); // 200 OK
            response.getWriter().write("{\"message\": \"Login exitoso\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
            response.getWriter().write("{\"message\": \"Credenciales incorrectas\"}");
        }
    }
}
