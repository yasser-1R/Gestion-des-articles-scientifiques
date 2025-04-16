
package com.gestion_des_articles.view;

import javax.swing.*;
import java.awt.*;

public class AuthChoiceView extends JFrame {
    private JButton userButton;
    private JButton adminButton;

    public AuthChoiceView() {
        setTitle("Choisir un rôle");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userButton = new JButton("Se connecter en tant qu'utilisateur");
        adminButton = new JButton("Se connecter en tant qu'administrateur");

        setLayout(new GridLayout(2, 1));
        add(userButton);
        add(adminButton);
    }

    public JButton getUserButton() {
        return userButton;
    }

    public JButton getAdminButton() {
        return adminButton;
    }
}
