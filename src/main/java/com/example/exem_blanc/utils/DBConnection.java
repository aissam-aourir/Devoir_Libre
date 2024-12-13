package com.example.exem_blanc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/aissam1";//le nom de base de donnees
    private static final String USER = "root"; // Changez selon vos identifiants
    private static final String PASSWORD = "root";

    private static Connection connection;

    // Méthode pour récupérer la connexion unique
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("Driver JDBC introuvable !");
            }
        }
        return connection;
    }
}
