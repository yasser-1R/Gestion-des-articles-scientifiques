package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.view.results.PublicationListView;
import com.smi6.gestion_des_articles_informatique.controller.search.SearchTheseController;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import java.awt.Image;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author YN
 */
public class Search_These extends javax.swing.JFrame {
private Utilisateur U;
    /**
     * Creates new form Search_Article
     */
    public Search_These(Utilisateur U) {
        initComponents();
        this.U = U;
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L_auteurs = new javax.swing.JLabel();
        L_publierle = new javax.swing.JLabel();
        TF_date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TF_date1 = new javax.swing.JTextField();
        L_publierle1 = new javax.swing.JLabel();
        L_publierle2 = new javax.swing.JLabel();
        TF_date2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        B_retourner1 = new javax.swing.JButton();
        L_Lieu = new javax.swing.JLabel();
        TF_Lieu = new javax.swing.JTextField();
        B_SelectE = new javax.swing.JButton();
        TF_Encadran = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        L_auteurs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        L_auteurs.setForeground(new java.awt.Color(18, 53, 36));
        L_auteurs.setText("Encadrant");

        L_publierle.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        L_publierle.setForeground(new java.awt.Color(18, 53, 36));
        L_publierle.setText("Date entre");

        TF_date.setBackground(new java.awt.Color(239, 227, 194));
        TF_date.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TF_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_dateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("dd/mm/yyyy");

        TF_date1.setBackground(new java.awt.Color(239, 227, 194));
        TF_date1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TF_date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_date1ActionPerformed(evt);
            }
        });

        L_publierle1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        L_publierle1.setForeground(new java.awt.Color(18, 53, 36));
        L_publierle1.setText("et");

        L_publierle2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        L_publierle2.setForeground(new java.awt.Color(18, 53, 36));
        L_publierle2.setText("Mots cles");

        TF_date2.setBackground(new java.awt.Color(239, 227, 194));
        TF_date2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TF_date2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_date2ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(18, 53, 36));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(239, 227, 194));
        jButton2.setText("Rechercher");
        jButton2.setToolTipText("");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 45));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        B_retourner1.setBackground(new java.awt.Color(18, 53, 36));
        B_retourner1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        B_retourner1.setForeground(new java.awt.Color(239, 227, 194));
        B_retourner1.setText("Retourner");
        B_retourner1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_retourner1.setFocusable(false);
        B_retourner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_retourner1ActionPerformed(evt);
            }
        });

        L_Lieu.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        L_Lieu.setForeground(new java.awt.Color(18, 53, 36));
        L_Lieu.setText("Etudiant");

        TF_Lieu.setBackground(new java.awt.Color(239, 227, 194));
        TF_Lieu.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        B_SelectE.setBackground(new java.awt.Color(18, 53, 36));
        B_SelectE.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        B_SelectE.setForeground(new java.awt.Color(239, 227, 194));
        B_SelectE.setText("Select Encadran");
        B_SelectE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_SelectE.setFocusable(false);
        B_SelectE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SelectEActionPerformed(evt);
            }
        });

        TF_Encadran.setBackground(new java.awt.Color(239, 227, 194));
        TF_Encadran.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TF_Encadran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_EncadranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(B_retourner1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(L_publierle2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_publierle, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Lieu, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_auteurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_Lieu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TF_date2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TF_date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(L_publierle1)
                                .addGap(18, 18, 18)
                                .addComponent(TF_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(0, 461, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B_SelectE, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TF_Encadran)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(B_SelectE)
                        .addComponent(TF_Encadran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(L_auteurs))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Lieu)
                    .addComponent(TF_Lieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_publierle)
                    .addComponent(TF_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(L_publierle1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_publierle2)
                    .addComponent(TF_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_retourner1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/icones/Profile.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        // Appliquer l’icône
        L_auteurs.setIcon(resizedIcon);
        L_auteurs.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        L_auteurs.setHorizontalAlignment(SwingConstants.CENTER);
        L_auteurs.setVerticalAlignment(SwingConstants.CENTER);

        // Position du texte par rapport à l’icône
        L_auteurs.setHorizontalTextPosition(SwingConstants.RIGHT);
        L_auteurs.setVerticalTextPosition(SwingConstants.CENTER);
        ImageIcon originalIcon33 = new ImageIcon(getClass().getResource("/icones/publie.png"));
        Image scaledImage33 = originalIcon33.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon33 = new ImageIcon(scaledImage33);

        // Appliquer l’icône
        L_publierle.setIcon(resizedIcon33);
        L_publierle.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        L_publierle.setHorizontalAlignment(SwingConstants.CENTER);
        L_publierle.setVerticalAlignment(SwingConstants.CENTER);

        // Position du texte par rapport à l’icône
        L_publierle.setHorizontalTextPosition(SwingConstants.RIGHT);
        L_publierle.setVerticalTextPosition(SwingConstants.CENTER);
        ImageIcon originalIcon44 = new ImageIcon(getClass().getResource("/icones/cle.png"));
        Image scaledImage44 = originalIcon44.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon44 = new ImageIcon(scaledImage44);

        // Appliquer l’icône
        L_publierle2.setIcon(resizedIcon44);
        L_publierle2.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        L_publierle2.setHorizontalAlignment(SwingConstants.CENTER);
        L_publierle2.setVerticalAlignment(SwingConstants.CENTER);

        // Position du texte par rapport à l’icône
        L_publierle2.setHorizontalTextPosition(SwingConstants.RIGHT);
        L_publierle2.setVerticalTextPosition(SwingConstants.CENTER);
        ImageIcon originalIcon22 = new ImageIcon(getClass().getResource("/icones/SansCompte.png"));
        Image scaledImage22 = originalIcon22.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon22 = new ImageIcon(scaledImage22);

        // Appliquer l’icône
        jButton2.setIcon(resizedIcon22);
        jButton2.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton2.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton2.setVerticalAlignment(SwingConstants.CENTER);
        ImageIcon originalIcon11 = new ImageIcon(getClass().getResource("/icones/Retour1.png"));
        Image scaledImage11 = originalIcon11.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon11 = new ImageIcon(scaledImage11);

        // Appliquer l’icône
        B_retourner1.setIcon(resizedIcon11);
        B_retourner1.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        B_retourner1.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        B_retourner1.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        B_retourner1.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        B_retourner1.setVerticalTextPosition(SwingConstants.CENTER);  // Aligné verticalement
        ImageIcon originalIcon77 = new ImageIcon(getClass().getResource("/icones/etudiant.png"));
        Image scaledImage77 = originalIcon77.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon77 = new ImageIcon(scaledImage77);

        // Appliquer l’icône
        L_Lieu.setIcon(resizedIcon77);
        L_Lieu.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        L_Lieu.setHorizontalAlignment(SwingConstants.CENTER);
        L_Lieu.setVerticalAlignment(SwingConstants.CENTER);

        // Position du texte par rapport à l’icône
        L_Lieu.setHorizontalTextPosition(SwingConstants.RIGHT);
        L_Lieu.setVerticalTextPosition(SwingConstants.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_dateActionPerformed

    private void TF_date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_date1ActionPerformed

    private void TF_date2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_date2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_date2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String encadrant = TF_Encadran.getText().trim();
    String etudiant = TF_Lieu.getText().trim();  // Field for student
    String date1 = TF_date.getText().trim();
    String date2 = TF_date1.getText().trim();
    String keyword = TF_date2.getText().trim();

    SearchTheseController controller = new SearchTheseController();
    List<com.smi6.gestion_des_articles_informatique.model.These> theses;

    try {
        theses = controller.searchTheses(encadrant, etudiant, date1, date2, keyword);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage(), "Recherche", JOptionPane.ERROR_MESSAGE);
        return;
    }

    List<Integer> ids = new ArrayList<>();
    for (var t : theses) {
        ids.add(t.getId());
    }

PublicationListView dialog = new PublicationListView(
    null,          // articles
    null,          // conferences
    null,          // brevets
    theses,        // theses
    null,          // memoires
    null           // rapports
);
dialog.setVisible(true); // Modal, blocks until closed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void B_retourner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_retourner1ActionPerformed
        Select_type_R  ST = new Select_type_R(this.U);
        ST.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_B_retourner1ActionPerformed

    private void B_SelectEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SelectEActionPerformed
         // Prepare list of pre-selected names
        String currentText = TF_Encadran.getText().trim();
        List<String> selectedProfesseurs = new ArrayList<>();
        if (!currentText.isEmpty()) {
            for (String name : currentText.split(",")) {
                selectedProfesseurs.add(name.trim());
            }
        }

        // Create panel with pre-selected names
        SelectProfesseursPanel_R selectProfPanel = new SelectProfesseursPanel_R(selectedProfesseurs);

        // Create dialog
        JDialog dialog = new JDialog(this, "Choisir Professeurs", true);
        dialog.getContentPane().add(selectProfPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // AFTER dialog is closed:
        // Get new list of selected professors
        String selected = selectProfPanel.getSelectedProfesseursText();

        // OVERWRITE the old text field content
        TF_Encadran.setText(selected);

    }//GEN-LAST:event_B_SelectEActionPerformed

    private void TF_EncadranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_EncadranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_EncadranActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Search_Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Search_Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Search_Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Search_Article.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Search_Article().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_SelectE;
    private javax.swing.JButton B_retourner1;
    private javax.swing.JLabel L_Lieu;
    private javax.swing.JLabel L_auteurs;
    private javax.swing.JLabel L_publierle;
    private javax.swing.JLabel L_publierle1;
    private javax.swing.JLabel L_publierle2;
    private javax.swing.JTextField TF_Encadran;
    private javax.swing.JTextField TF_Lieu;
    private javax.swing.JTextField TF_date;
    private javax.swing.JTextField TF_date1;
    private javax.swing.JTextField TF_date2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
