package com.gestion_des_articles;

import com.gestion_des_articles.view.ArticleSearchView;
import com.gestion_des_articles.controller.ArticleController;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/GESTION_DES_ARTICLES",
                    "root",
                    ""
                );
                ArticleSearchView view = new ArticleSearchView();
                new ArticleController(view, conn);
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données !");
            }
        });
    }
}
