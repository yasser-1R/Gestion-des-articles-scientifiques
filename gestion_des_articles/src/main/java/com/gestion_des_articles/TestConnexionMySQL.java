package com.gestion_des_articles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionMySQL {
    public static void main(String[] args) {
        // Paramètres de connexion
        String url = "jdbc:mysql://localhost:3306/GESTION_DES_ARTICLES";
        String user = "root";
        String password = ""; 

        try {
            // Chargement du driver (optionnel pour JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie à la base de données !");

            // Fermer proprement
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Le driver JDBC MySQL est introuvable !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
