package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PublicationListView extends JFrame {

    public PublicationListView(
            List<Article> articles,
            List<Conference> conferences,
            List<Brevet> brevets,
            List<These> theses,
            List<Memoire> memoires,
            List<RapportRecherche> rapports) {

        setTitle("Liste des Publications");
        setSize(1050, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔽 Container for publication panels
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (articles != null) {
            for (Article a : articles) {
                container.add(new PublicationPanel(a));
                container.add(Box.createVerticalStrut(10));
            }
        }

        if (conferences != null) {
            for (Conference c : conferences) {
                container.add(new PublicationPanel(c));
                container.add(Box.createVerticalStrut(10));
            }
        }

        if (brevets != null) {
            for (Brevet b : brevets) {
                container.add(new PublicationPanel(b));
                container.add(Box.createVerticalStrut(10));
            }
        }

        if (theses != null) {
            for (These t : theses) {
                container.add(new PublicationPanel(t));
                container.add(Box.createVerticalStrut(10));
            }
        }

        if (memoires != null) {
            for (Memoire m : memoires) {
                container.add(new PublicationPanel(m));
                container.add(Box.createVerticalStrut(10));
            }
        }

        if (rapports != null) {
            for (RapportRecherche r : rapports) {
                container.add(new PublicationPanel(r));
                container.add(Box.createVerticalStrut(10));
            }
        }

        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // 🔚 Bottom panel with Close button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton closeButton = new JButton("Close");

        closeButton.setBackground(new Color(18, 53, 36));
        closeButton.setFont(new Font("Calibri", Font.PLAIN, 16));
        closeButton.setForeground(new Color(239, 227, 194));
        closeButton.setBorder(BorderFactory.createSoftBevelBorder(0));
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.setFocusable(false);

        closeButton.addActionListener((ActionEvent e) -> {
            dispose(); // 🔚 Just close the window
        });

        bottomPanel.add(closeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
