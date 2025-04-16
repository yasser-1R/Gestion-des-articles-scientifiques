package com.gestion_des_articles;

import com.gestion_des_articles.controller.AuthController;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Connexion à la base de données (modifie le mot de passe si besoin)
                Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/GESTION_DES_ARTICLES",
                    "root",
                    ""
                );

                // Lancer le contrôleur d’authentification
                new AuthController(connection);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données !");
            }
        });
    }
}
