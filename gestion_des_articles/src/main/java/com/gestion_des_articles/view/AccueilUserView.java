package com.gestion_des_articles.view;

import javax.swing.*;
import java.awt.*;

public class AccueilUserView extends JFrame {
    private JButton logoutButton;
    private JButton searchButton;

    public AccueilUserView(String nom) {
        setTitle("Bienvenue Étudiant");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Bienvenue " + nom + " !");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        logoutButton = new JButton("Déconnexion");
        searchButton = new JButton("Rechercher un article");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(searchButton);
        buttonPanel.add(logoutButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
