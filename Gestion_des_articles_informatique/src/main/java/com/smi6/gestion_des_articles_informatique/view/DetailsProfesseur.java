/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smi6.gestion_des_articles_informatique.view;

import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import jakarta.persistence.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author YN
 */
public class DetailsProfesseur extends javax.swing.JFrame {
    private Utilisateur U;
    private int professeurId;

    public DetailsProfesseur(Utilisateur U, int professeurId) {
        this.U = U;
        this.professeurId = professeurId;
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }

    private void initComponents() {
        setSize(1050, 600);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        L_title = new javax.swing.JLabel();
        B_retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Calibri", 0, 16));
        jTable1.setRowHeight(30);
        jTable1.setBackground(new java.awt.Color(239, 227, 194));
        jTable1.setFocusable(false);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "Type", "Titre", "Voir PDF" }
        ));
        jScrollPane1.setViewportView(jTable1);

        L_title.setFont(new java.awt.Font("Calibri", 1, 24));
        L_title.setForeground(new java.awt.Color(18, 53, 36));
        L_title.setText("Détails des publications du professeur");

        B_retour.setBackground(new java.awt.Color(18, 53, 36));
        B_retour.setFont(new java.awt.Font("Calibri", 0, 18));
        B_retour.setForeground(new java.awt.Color(239, 227, 194));
        B_retour.setText("Retourner");
        B_retour.setFocusable(false);
        B_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_retourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                        .addComponent(L_title)
                        .addComponent(B_retour))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(L_title)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(B_retour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        pack();
    }

    private void loadData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        String[] types = {"Article", "Brevet", "Thèse", "Mémoire", "Rapport", "Conférence"};
        String[] queries = {
            "SELECT titre, chemin_pdf FROM articles a JOIN article_professeur ap ON a.id = ap.id_article WHERE ap.id_professeur = :id",
            "SELECT titre, chemin_pdf FROM brevets b JOIN brevet_professeur bp ON b.id = bp.id_brevet WHERE bp.id_professeur = :id",
            "SELECT titre, chemin_pdf FROM theses t WHERE t.id_directeur = :id",
            "SELECT titre, chemin_pdf FROM memoires m WHERE m.id_directeur = :id",
            "SELECT titre, chemin_pdf FROM rapports_recherche r JOIN rapport_professeur rp ON r.id = rp.id_rapport WHERE rp.id_professeur = :id",
            "SELECT titre, chemin_pdf FROM conferences c JOIN conference_professeur cp ON c.id = cp.id_conference WHERE cp.id_professeur = :id"
        };

        for (int i = 0; i < types.length; i++) {
            List<Object[]> results = em.createNativeQuery(queries[i])
                .setParameter("id", professeurId)
                .getResultList();

            for (Object[] row : results) {
                String titre = (String) row[0];
                String chemin = (String) row[1];

                JButton btn = new JButton("Voir PDF");
                btn.setBackground(new java.awt.Color(18, 53, 36));
                btn.setForeground(new java.awt.Color(239, 227, 194));
                btn.setFont(new java.awt.Font("Calibri", 0, 14));
                btn.setFocusPainted(false);

                String finalPath = chemin;
                btn.addActionListener(e -> {
                    try {
                        Desktop.getDesktop().browse(new File(finalPath).toURI());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Erreur lors de l'ouverture du PDF.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                });

                model.addRow(new Object[] { types[i], titre, btn });
            }
        }

        jTable1.getColumn("Voir PDF").setCellRenderer((table, value, isSelected, hasFocus, row, column) -> (Component) value);
        jTable1.getColumn("Voir PDF").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            private JButton button;

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                button = (JButton) value;
                return button;
            }
        });

        em.close();
        emf.close();
    }

    private void B_retourActionPerformed(java.awt.event.ActionEvent evt) {
        Professeur_Resume resumeView = new Professeur_Resume(U);
        resumeView.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new DetailsProfesseur(null, 1).setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton B_retour;
    private javax.swing.JLabel L_title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
