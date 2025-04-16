
package com.gestion_des_articles.view;

import javax.swing.*;

public class AccueilAdminView extends JFrame {
    private JButton logoutButton;

    public AccueilAdminView(String nom) {
        setTitle("Bienvenue Admin");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Bienvenue Admin " + nom + " !");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        logoutButton = new JButton("Déconnexion");

        add(label, "North");
        add(logoutButton, "South");
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }
}
