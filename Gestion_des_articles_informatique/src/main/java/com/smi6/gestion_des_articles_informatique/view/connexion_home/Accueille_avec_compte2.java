/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smi6.gestion_des_articles_informatique.view.connexion_home;

import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import com.smi6.gestion_des_articles_informatique.view.search.Search_All;
import com.smi6.gestion_des_articles_informatique.view.search.Select_type_R;
import com.smi6.gestion_des_articles_informatique.view.statistiques.Professeur_Resume;
import com.smi6.gestion_des_articles_informatique.view.uploads.Select_type;
import java.awt.Component;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
/**
 *
 * @author YN
 */
public class Accueille_avec_compte2 extends javax.swing.JFrame {
private Utilisateur U;

    /**
     * Creates new form Accueille_avec_compte2
     */
    public Accueille_avec_compte2(Utilisateur U) {
        this.U = U;
        initComponents();
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

        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setBackground(new java.awt.Color(18, 53, 36));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(239, 227, 194));
        jButton3.setText("Profil");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(18, 53, 36));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(239, 227, 194));
        jButton2.setText("Rehercher");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(18, 53, 36));
        jButton6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(239, 227, 194));
        jButton6.setText("Uploader");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(18, 53, 36));
        jButton7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(239, 227, 194));
        jButton7.setText("Statistiques");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(18, 53, 36));
        jButton8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(239, 227, 194));
        jButton8.setText("Déconnecter");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 409, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 409, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/icones/SeConnecter.png"));
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon3 = new ImageIcon(scaledImage3);

        // Appliquer l’icône
        jButton3.setIcon(resizedIcon3);
        jButton3.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton3.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton3.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        jButton3.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        jButton3.setVerticalTextPosition(SwingConstants.CENTER);
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/icones/SansCompte.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        // Appliquer l’icône
        jButton2.setIcon(resizedIcon);
        jButton2.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton2.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton2.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        jButton2.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        jButton2.setVerticalTextPosition(SwingConstants.CENTER);  // Aligné verticalement
        ImageIcon originalIcon6 = new ImageIcon(getClass().getResource("/icones/Uploader.png"));
        Image scaledImage6 = originalIcon6.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon6 = new ImageIcon(scaledImage6);

        // Appliquer l’icône
        jButton6.setIcon(resizedIcon6);
        jButton6.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton6.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton6.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        jButton6.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        jButton6.setVerticalTextPosition(SwingConstants.CENTER);
        ImageIcon originalIcon7 = new ImageIcon(getClass().getResource("/icones/Statistiques.png"));
        Image scaledImage7 = originalIcon7.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon7 = new ImageIcon(scaledImage7);

        // Appliquer l’icône
        jButton7.setIcon(resizedIcon7);
        jButton7.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton7.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton7.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        jButton7.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        jButton7.setVerticalTextPosition(SwingConstants.CENTER);
        ImageIcon originalIcon8 = new ImageIcon(getClass().getResource("/icones/Retour1.png"));
        Image scaledImage8 = originalIcon8.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon8 = new ImageIcon(scaledImage8);

        // Appliquer l’icône
        jButton8.setIcon(resizedIcon8);
        jButton8.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton8.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton8.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        jButton8.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        jButton8.setVerticalTextPosition(SwingConstants.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Select_type_R R = new Select_type_R(this.U);
        R.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Select_type ST = new Select_type(this.U);
        ST.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Professeur_Resume PR = new Professeur_Resume(this.U);
        PR.setVisible(true);
        this.dispose();
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Connexion2 c =new Connexion2();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ProfileView PV = new ProfileView(this.U);
        PV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
//            java.util.logging.Logger.getLogger(Accueille_avec_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Accueille_avec_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Accueille_avec_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Accueille_avec_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new Accueille_avec_compte2().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    // End of variables declaration//GEN-END:variables
}
