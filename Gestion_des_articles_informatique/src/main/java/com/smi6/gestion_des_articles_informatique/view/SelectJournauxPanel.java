package com.smi6.gestion_des_articles_informatique.view;

import com.smi6.gestion_des_articles_informatique.model.Journal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class SelectJournauxPanel extends javax.swing.JPanel {

    private List<JCheckBox> checkBoxes = new ArrayList<>();
    private List<String> preSelectedJournaux;

    public SelectJournauxPanel(List<String> preSelectedJournaux) {
        initComponents();
        this.preSelectedJournaux = preSelectedJournaux;
        loadJournaux();
    }

    private void loadJournaux() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            List<Journal> journaux = em.createQuery("FROM Journal", Journal.class).getResultList();
            em.close();
            emf.close();

            JPanel panelJournaux = new JPanel();
            panelJournaux.setLayout(new BoxLayout(panelJournaux, BoxLayout.Y_AXIS));

            for (Journal journal : journaux) {
                JCheckBox checkBox = new JCheckBox(journal.getNom());

                // 🔥 If the journal is pre-selected, check the box
                if (preSelectedJournaux != null && preSelectedJournaux.contains(journal.getNom())) {
                    checkBox.setSelected(true);
                }

                checkBoxes.add(checkBox);
                panelJournaux.add(checkBox);
            }

            ScrollPaneJournaux.setViewportView(panelJournaux);
        } catch (Exception ex) {
            System.err.println("Erreur lors du chargement des journaux: " + ex.getMessage());
        }
    }

    public String getSelectedJournauxText() {
        StringBuilder sb = new StringBuilder();
        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
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

        L_selectionner.setFont(new java.awt.Font("Calibri", 0, 24)); 
        L_selectionner.setText("Sélectionner les Journaux");

        B_valider.setBackground(new java.awt.Color(18, 53, 36));
        B_valider.setFont(new java.awt.Font("Calibri", 0, 18)); 
        B_valider.setForeground(new java.awt.Color(239, 227, 194));
        B_valider.setText("Valider");
        B_valider.setFocusable(false);
        B_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_validerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPaneJournaux, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_selectionner)
                    .addComponent(B_valider))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(L_selectionner)
                .addGap(18, 18, 18)
                .addComponent(ScrollPaneJournaux, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(B_valider)
                .addGap(20, 20, 20))
        );
    }

    private void B_validerActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // When user clicks "Valider", simply close the dialog (handled outside)
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }                                          

    private javax.swing.JButton B_valider;
    private javax.swing.JLabel L_selectionner;
    private javax.swing.JScrollPane ScrollPaneJournaux;
}
