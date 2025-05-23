/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smi6.gestion_des_articles_informatique.view.connexion_home;

import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import com.smi6.gestion_des_articles_informatique.view.search.Search_All;
import com.smi6.gestion_des_articles_informatique.view.search.Select_type_R;
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
public class Accueille_sans_compte2 extends javax.swing.JFrame {
private Utilisateur U = null;

    /**
     * Creates new form Accueille_avec_compte2
     */
    public Accueille_sans_compte2() {
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

        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton9.setBackground(new java.awt.Color(18, 53, 36));
        jButton9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(239, 227, 194));
        jButton9.setText("Retourner");
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(384, 384, 384))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

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
        ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/icones/Retour.png"));
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(scaledImage1);

        // Appliquer l’icône
        jButton9.setIcon(resizedIcon1);
        jButton9.setIconTextGap(10); // Espace entre icône et texte

        // Centrage vertical du texte + icône
        jButton9.setHorizontalAlignment(SwingConstants.CENTER); // Centre tout (icône + texte)
        jButton9.setVerticalAlignment(SwingConstants.CENTER);

        // Pour éviter que le texte soit décalé par la taille du bouton
        jButton9.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l’icône
        jButton9.setVerticalTextPosition(SwingConstants.CENTER);  // Aligné verticalement

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Select_type_R STR = new Select_type_R(this.U);
        STR.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Connexion2 c =new Connexion2();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

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
//            java.util.logging.Logger.getLogger(Accueille_sans_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Accueille_sans_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Accueille_sans_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Accueille_sans_compte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new Accueille_avec_compte2().setVisible(true);
////            }
////        });
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new Accueille_avec_compte2().setVisible(true);
////            }
////        });
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new Accueille_avec_compte2().setVisible(true);
////            }
////        });
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
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}
