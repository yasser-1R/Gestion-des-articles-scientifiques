package com.gestion_des_articles.view;

import javax.swing.*;
import java.awt.*;

public class AccueilAdminView extends JFrame {
    private JButton logoutButton;
    private JButton manageButton;
    private JButton searchButton;


    public AccueilAdminView(String nom) {
        setTitle("Bienvenue Admin");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Bienvenue Admin " + nom + " !");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        logoutButton = new JButton("Déconnexion");
        searchButton = new JButton("Rechercher un articl");
        manageButton = new JButton("Gérer les articles"); // optionnel pour le futur

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(manageButton);
        buttonPanel.add(logoutButton);
        buttonPanel.add(searchButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getManageButton() {
        return manageButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
