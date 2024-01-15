package com.bancoplatinum;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        // Invalida la sesión actual y la elimina.
        request.getSession().invalidate();
        
        // Redirige al usuario a login.jsp.
        response.sendRedirect("login.jsp");
    }
}