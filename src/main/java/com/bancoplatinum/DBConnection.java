package com.bancoplatinum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// Coloca tus credenciales de MySQL aquí
    private static final String URL = "jdbc:mysql://localhost:3306/BancoPlatinum";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234Esau";
    
 // Método para obtener la conexión
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Asegúrate que el driver esté en tu librería
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error conectando a la base de datos", e);
        }
    }
}
