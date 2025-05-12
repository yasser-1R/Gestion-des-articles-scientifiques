package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.model.Professeur;
import jakarta.persistence.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class SelectEncadrantPanel_R2 extends javax.swing.JPanel {

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton selectedRadio = null;
    private JPanel panelProfesseurs;


    public SelectEncadrantPanel_R2(String preSelectedName) {
        initComponents();
        loadProfesseurs(preSelectedName);
    }

    private void loadProfesseurs(String preSelectedName) {
        panelProfesseurs = new JPanel();
        panelProfesseurs.setLayout(new BoxLayout(panelProfesseurs, BoxLayout.Y_AXIS));

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

List<Professeur> professeurs = em.createQuery("FROM Professeur ORDER BY LOWER(nomComplet)", Professeur.class).getResultList();
            em.close();
            emf.close();

            for (Professeur prof : professeurs) {
                JRadioButton radio = new JRadioButton(prof.getNomComplet());
                radio.setFont(new Font("Calibri", Font.PLAIN, 16));
                if (preSelectedName != null && prof.getNomComplet().equalsIgnoreCase(preSelectedName)) {
                    radio.setSelected(true);
                    selectedRadio = radio;
                }
                buttonGroup.add(radio);
                panelProfesseurs.add(radio);
            }

        } catch (Exception ex) {
            System.err.println("Erreur lors du chargement des professeurs : " + ex.getMessage());
        }

        ScrollPaneEncadrant.setViewportView(panelProfesseurs);
    }

    public String getSelectedEncadrantText() {
        for (Component comp : panelProfesseurs.getComponents()) {
            if (comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
                return ((JRadioButton) comp).getText();
            }
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        L_selectionner = new javax.swing.JLabel();
        ScrollPaneEncadrant = new javax.swing.JScrollPane();
        B_valider = new javax.swing.JButton();


        L_selectionner.setFont(new java.awt.Font("Calibri", 0, 24));
        L_selectionner.setText("Sélectionner l'encadrant");

        B_valider.setBackground(new java.awt.Color(18, 53, 36));
        B_valider.setFont(new java.awt.Font("Calibri", 0, 18));
        B_valider.setForeground(new java.awt.Color(239, 227, 194));
        B_valider.setText("Valider");
        B_valider.setFocusable(false);
        B_valider.addActionListener(evt -> javax.swing.SwingUtilities.getWindowAncestor(this).dispose());



        setPreferredSize(new java.awt.Dimension(420, 450));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(L_selectionner)
                        .addComponent(ScrollPaneEncadrant, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(B_valider)
                        )
                    .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
                    .addComponent(L_selectionner)
                    .addGap(18, 18, 18)
                    .addComponent(ScrollPaneEncadrant, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    
                    .addComponent(B_valider)
                    .addGap(20, 20, 20))
        );
    }

    private javax.swing.JLabel L_selectionner;
    private javax.swing.JScrollPane ScrollPaneEncadrant;
    private javax.swing.JButton B_valider;
}
