package com.gestion_des_articles.controller;

import com.gestion_des_articles.dao.AdminDAO;
import com.gestion_des_articles.dao.EtudiantDAO;
import com.gestion_des_articles.model.Admin;
import com.gestion_des_articles.model.Etudiant;
import com.gestion_des_articles.view.*;

import javax.swing.*;
import java.sql.Connection;

public class AuthController {
    private AuthChoiceView choiceView;
    private Connection connection;

    public AuthController(Connection connection) {
        this.connection = connection;
        choiceView = new AuthChoiceView();
        choiceView.setVisible(true);

        choiceView.getUserButton().addActionListener(e -> showLogin("utilisateur"));
        choiceView.getAdminButton().addActionListener(e -> showLogin("administrateur"));
    }

    private void showLogin(String role) {
        LoginView loginView = new LoginView(role);
        loginView.setVisible(true);
        loginView.getBackButton().addActionListener(ae -> loginView.dispose());
        loginView.getLoginButton().addActionListener(e -> {
            String email = loginView.getEmail();
            String password = loginView.getPassword();

            if (role.equals("utilisateur")) {
                EtudiantDAO etudiantDAO = new EtudiantDAO(connection);
                Etudiant etu = etudiantDAO.login(email, password);
                if (etu != null) {
                    loginView.dispose();
                    choiceView.dispose();
                    AccueilUserView accueil = new AccueilUserView(etu.getPrenom());
                    accueil.setVisible(true);

                    accueil.getLogoutButton().addActionListener(ae -> accueil.dispose());

                    // 👇 Ajouter l'ouverture de la recherche d'article
                    accueil.getSearchButton().addActionListener(ae -> {
                        ArticleSearchView searchView = new ArticleSearchView();
                        new ArticleController(searchView, connection); // 👈 on relie la vue et la logique
                        searchView.setVisible(true);
                    });
                    

                } else {
                    JOptionPane.showMessageDialog(loginView, "Email ou mot de passe invalide !");
                }

            } else {
                AdminDAO adminDAO = new AdminDAO(connection);
                Admin admin = adminDAO.login(email, password);
                if (admin != null) {
                    loginView.dispose();
                    choiceView.dispose();
                    AccueilAdminView accueil = new AccueilAdminView(admin.getPrenom());
                    accueil.setVisible(true);

                    accueil.getLogoutButton().addActionListener(ae -> accueil.dispose());
                    accueil.getSearchButton().addActionListener(ae -> {
                        ArticleSearchView searchView = new ArticleSearchView();
                        new ArticleController(searchView, connection); // 👈 on relie la vue et la logique
                        searchView.setVisible(true);
                    });

                } else {
                    JOptionPane.showMessageDialog(loginView, "Email ou mot de passe invalide !");
                }
            }
        });
    }
}