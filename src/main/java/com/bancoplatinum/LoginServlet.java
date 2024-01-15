package com.bancoplatinum;

import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null) {
            try (Connection connection = DBConnection.getConnection()) {
                String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            // Usuario encontrado, obtener detalles de la persona asociada
                            sql = "SELECT * FROM persona WHERE usuario_id = ?";
                            try (PreparedStatement personaStatement = connection.prepareStatement(sql)) {
                                personaStatement.setInt(1, resultSet.getInt("id"));
                                
                                try (ResultSet personaResult = personaStatement.executeQuery()) {
                                    if (personaResult.next()) {
                                        // Iniciar sesión y redirigir a la página de dashboard
                                        request.getSession().setAttribute("user", username);
                                        request.getSession().setAttribute("nombre", personaResult.getString("nombre"));
                                        request.getSession().setAttribute("apellido", personaResult.getString("apellido"));
                                        response.sendRedirect("dashboard.jsp");
                                    } else {
                                        // No se encontró el detalle de la persona asociada al usuario
                                        request.setAttribute("loginError", "No se encontraron detalles de la persona.");
                                        request.getRequestDispatcher("login.jsp").forward(request, response);
                                    }
                                }
                            }
                        } else {
                            // Usuario no encontrado o contraseña incorrecta
                            request.setAttribute("loginError", "Usuario o contraseña incorrecta.");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
            } catch (SQLException e) {
                throw new ServletException("Error al conectar con la base de datos", e);
            }
        } else {
            // Campos de usuario o contraseña vacíos
            request.setAttribute("loginError", "Los campos de usuario y contraseña no pueden estar vacíos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
	
}
