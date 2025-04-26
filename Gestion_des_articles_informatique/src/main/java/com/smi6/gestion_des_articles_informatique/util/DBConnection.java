package com.smi6.gestion_des_articles_informatique.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_articles"; // Replace with your database name
    private static final String USER = "root"; // Replace if you have a username
    private static final String PASSWORD = ""; // Replace if you have a password

    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DBConnection() {
    }

    // Public method to get the connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
