
package com.gestion_des_articles.view;

import javax.swing.*;
import java.awt.*;

public class ArticleSearchView extends JFrame {
    private JTextField idField;
    private JButton searchButton;
    private JLabel titreLabel;
    private JLabel motsClesLabel;

    public ArticleSearchView() {
        setTitle("Recherche d'Article");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("ID de l'article :"));
        idField = new JTextField();
        panel.add(idField);

        searchButton = new JButton("Rechercher");
        panel.add(searchButton);
        panel.add(new JLabel());  // placeholder

        panel.add(new JLabel("Titre :"));
        titreLabel = new JLabel("...");
        panel.add(titreLabel);

        panel.add(new JLabel("Mots clés :"));
        motsClesLabel = new JLabel("...");
        panel.add(motsClesLabel);

        add(panel);
    }

    public JTextField getIdField() {
        return idField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setTitre(String titre) {
        titreLabel.setText(titre);
    }

    public void setMotsCles(String motsCles) {
        motsClesLabel.setText(motsCles);
    }
}
