package com.smi6.gestion_des_articles_informatique.view;

import com.smi6.gestion_des_articles_informatique.model.Journal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectJournauxPanel extends javax.swing.JPanel {

    private List<JCheckBox> checkBoxes = new ArrayList<>();
    private List<String> preSelectedJournaux;
    private JPanel panelJournaux;
    private JTextField TF_nouveau;
    private JTextField TF_quartile;
    private JButton B_ajouter;

    public SelectJournauxPanel(List<String> preSelectedJournaux) {
        this.preSelectedJournaux = preSelectedJournaux;
        initComponents();
        loadJournaux();
    }

    private void loadJournaux() {
        panelJournaux = new JPanel();
        panelJournaux.setLayout(new BoxLayout(panelJournaux, BoxLayout.Y_AXIS));

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            List<Journal> journaux = em.createQuery("FROM Journal ORDER BY LOWER(nom)", Journal.class).getResultList();
            em.close();
            emf.close();

            for (Journal journal : journaux) {
                JCheckBox checkBox = new JCheckBox(journal.getNom());
                checkBox.setFont(new Font("Calibri", Font.PLAIN, 16));
                if (preSelectedJournaux != null && preSelectedJournaux.contains(journal.getNom())) {
                    checkBox.setSelected(true);
                }
                checkBoxes.add(checkBox);
                panelJournaux.add(checkBox);
            }

        } catch (Exception ex) {
            System.err.println("Erreur chargement journaux: " + ex.getMessage());
        }

        ScrollPaneJournaux.setViewportView(panelJournaux);
    }

    public String getSelectedJournauxText() {
        StringBuilder sb = new StringBuilder();
        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(cb.getText());
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        L_selectionner = new javax.swing.JLabel();
        ScrollPaneJournaux = new javax.swing.JScrollPane();
        B_valider = new javax.swing.JButton();
        TF_nouveau = new javax.swing.JTextField();
        TF_quartile = new javax.swing.JTextField();
        B_ajouter = new javax.swing.JButton();

        L_selectionner.setFont(new java.awt.Font("Calibri", 0, 24));
        L_selectionner.setText("Sélectionner les Journaux");

        B_valider.setBackground(new java.awt.Color(18, 53, 36));
        B_valider.setFont(new java.awt.Font("Calibri", 0, 18));
        B_valider.setForeground(new java.awt.Color(239, 227, 194));
        B_valider.setText("Valider");
        B_valider.setFocusable(false);
        B_valider.addActionListener(evt -> javax.swing.SwingUtilities.getWindowAncestor(this).dispose());

        TF_nouveau.setFont(new java.awt.Font("Calibri", 0, 16));
        TF_nouveau.setToolTipText("Ajouter un nouveau journal");

        TF_quartile = new JTextField();
        TF_quartile.setFont(new Font("Calibri", Font.PLAIN, 16));
        TF_quartile.setToolTipText("Quartile (Q1, Q2, etc.)");
        TF_quartile.setPreferredSize(new Dimension(50, 30));

        B_ajouter.setBackground(new java.awt.Color(18, 53, 36));
        B_ajouter.setFont(new java.awt.Font("Calibri", 0, 16));
        B_ajouter.setForeground(new java.awt.Color(239, 227, 194));
        B_ajouter.setText("Ajouter");
        B_ajouter.setFocusable(false);
        B_ajouter.addActionListener(e -> {
            String nom = TF_nouveau.getText().trim();
            String quartile = TF_quartile.getText().trim();
            if (nom.isEmpty()) return;

            for (JCheckBox cb : checkBoxes) {
                if (cb.getText().equalsIgnoreCase(nom)) {
                    JOptionPane.showMessageDialog(this, "Ce journal existe déjà.");
                    return;
                }
            }

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                Journal newJournal = new Journal();
                newJournal.setNom(nom);
                newJournal.setQuartile(quartile);
                em.persist(newJournal);

                em.getTransaction().commit();
                em.close();
                emf.close();

                JCheckBox cb = new JCheckBox(nom);
                cb.setFont(new Font("Calibri", Font.PLAIN, 16));
                cb.setSelected(true);
                checkBoxes.add(cb);
                panelJournaux.add(cb);
                panelJournaux.revalidate();
                panelJournaux.repaint();

                TF_nouveau.setText("");
                TF_quartile.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout : " + ex.getMessage());
            }
        });

        setPreferredSize(new java.awt.Dimension(420, 450));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(L_selectionner)
                        .addComponent(ScrollPaneJournaux, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(B_valider)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TF_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TF_quartile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(B_ajouter)))
                    .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
                    .addComponent(L_selectionner)
                    .addGap(18, 18, 18)
                    .addComponent(ScrollPaneJournaux, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TF_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TF_quartile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(B_ajouter))
                    .addGap(18, 18, 18)
                    .addComponent(B_valider)
                    .addGap(20, 20, 20))
        );
    }

    private javax.swing.JLabel L_selectionner;
    private javax.swing.JScrollPane ScrollPaneJournaux;
    private javax.swing.JButton B_valider;
}
