package com.smi6.gestion_des_articles_informatique.view.statistiques;

import com.smi6.gestion_des_articles_informatique.view.connexion_home.Accueille_avec_compte2;
import com.smi6.gestion_des_articles_informatique.view.connexion_home.Accueille_admin2;
import com.smi6.gestion_des_articles_informatique.view.connexion_home.Accueille_sans_compte2;
import com.smi6.gestion_des_articles_informatique.model.*;
import com.smi6.gestion_des_articles_informatique.controller.search.GeneralSearchController;
import jakarta.persistence.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author YN
 */
public class Professeur_Resume extends javax.swing.JFrame {

    private Utilisateur U;
    private GeneralSearchController searchController;

    /** Creates new form Professeur_Resume */
    public Professeur_Resume(Utilisateur U) {
        this.U = U;
        this.searchController = new GeneralSearchController();
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }

    private void initComponents() {
        setSize(1050, 600);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7; // only the button column is editable
            }
        };
        L_title = new javax.swing.JLabel();
        B_retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Calibri", 0, 18));
        jTable1.setRowHeight(35);
        jTable1.setBackground(new java.awt.Color(239, 227, 194));
        jTable1.setFocusable(false);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Professeur", "Articles", "Brevets", "Thèses", "Mémoires", "Rapports", "Conférences", "Actions"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        L_title.setFont(new java.awt.Font("Calibri", 1, 24));
        L_title.setForeground(new java.awt.Color(18, 53, 36));
        L_title.setText("Résumé des Professeurs");

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
                    .addComponent(L_title))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B_retour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        String sql = """
            SELECT 
                p.id,
                p.nom_complet,
                (SELECT COUNT(*) FROM article_professeur ap WHERE ap.id_professeur = p.id),
                (SELECT COUNT(*) FROM brevet_professeur bp WHERE bp.id_professeur = p.id),
                (SELECT COUNT(*) FROM theses t WHERE t.id_directeur = p.id),
                (SELECT COUNT(*) FROM memoires m WHERE m.id_directeur = p.id),
                (SELECT COUNT(*) FROM rapport_professeur rp WHERE rp.id_professeur = p.id),
                (SELECT COUNT(*) FROM conference_professeur cp WHERE cp.id_professeur = p.id)
            FROM professeurs p
            ORDER BY p.nom_complet ASC
        """;

        List<Object[]> results = em.createNativeQuery(sql).getResultList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Object[] row : results) {
            JButton btn = new JButton("Voir détails");
            btn.setBackground(new java.awt.Color(18, 53, 36));
            btn.setForeground(new java.awt.Color(239, 227, 194));
            btn.setFont(new java.awt.Font("Calibri", 0, 16));
            btn.setFocusPainted(false);

            int idProf = (Integer) row[0];
            String nomProf = (String) row[1];
            
            btn.addActionListener(e -> {
                try {
                    // Récupérer le professeur correspondant
                    TypedQuery<Professeur> query = em.createQuery(
                        "SELECT p FROM Professeur p WHERE p.id = :id", Professeur.class);
                    query.setParameter("id", idProf);
                    Professeur professeur = query.getSingleResult();
                    
                    // Utiliser GeneralSearchController pour récupérer toutes les publications
                    List<Professeur> profList = new ArrayList<>();
                    profList.add(professeur);
                    
                    Map<String, List<?>> searchResults = searchController.search(null, profList, null, null);
                    
                    // Ouvrir DetailsProfesseur avec les publications trouvées
                    DetailsProfesseur detailsView = new DetailsProfesseur(U, idProf, nomProf, searchResults);
                    detailsView.setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, 
                        "Erreur lors de la récupération des publications: " + ex.getMessage(),
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            });

            model.addRow(new Object[] {
                row[1],
                ((Number) row[2]).intValue(),
                ((Number) row[3]).intValue(),
                ((Number) row[4]).intValue(),
                ((Number) row[5]).intValue(),
                ((Number) row[6]).intValue(),
                ((Number) row[7]).intValue(),
                btn
            });
        }

        jTable1.getColumn("Professeur").setPreferredWidth(200);

        jTable1.getColumn("Actions").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });

        jTable1.getColumn("Actions").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            private JButton button;

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                button = (JButton) value;
                return button;
            }
        });

//        em.close();
//        emf.close();
    }

    private void B_retourActionPerformed(java.awt.event.ActionEvent evt) {
        Utilisateur user = this.U;
        if (user != null) {
            if (user.getRole() == Utilisateur.Role.admin) {
                Accueille_admin2 adminView = new Accueille_admin2(user);
                adminView.setVisible(true);
            } else if (user.getRole() == Utilisateur.Role.utilisateur) {
                Accueille_avec_compte2 userView = new Accueille_avec_compte2(user);
                userView.setVisible(true);
            } else {
                Accueille_sans_compte2 A = new Accueille_sans_compte2();
                A.setVisible(true);
            }
        } else {
            Accueille_sans_compte2 A = new Accueille_sans_compte2();
            A.setVisible(true);
        }
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Professeur_Resume(null).setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton B_retour;
    private javax.swing.JLabel L_title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}