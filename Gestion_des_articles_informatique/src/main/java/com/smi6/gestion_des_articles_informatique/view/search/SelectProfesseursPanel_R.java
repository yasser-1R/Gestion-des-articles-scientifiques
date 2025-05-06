package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.view.uploads.*;
import com.smi6.gestion_des_articles_informatique.model.Professeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectProfesseursPanel_R extends javax.swing.JPanel {

    private List<JCheckBox> checkBoxes = new ArrayList<>();
    private List<String> preSelectedProfesseurs;
    private JPanel panelProfesseurs;
    private JTextField TF_newProf;

    public SelectProfesseursPanel_R(List<String> preSelectedProfesseurs) {
        this.preSelectedProfesseurs = preSelectedProfesseurs;
        initComponents();
        loadProfesseurs();
    }

    private void loadProfesseurs() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            List<Professeur> professeurs = em.createQuery("FROM Professeur ORDER BY LOWER(nomComplet)", Professeur.class).getResultList();
            em.close();
            emf.close();

            panelProfesseurs.removeAll();

            for (Professeur prof : professeurs) {
                JCheckBox checkBox = new JCheckBox(prof.getNomComplet());
                checkBox.setFont(new Font("Calibri", Font.PLAIN, 16));
                if (preSelectedProfesseurs != null && preSelectedProfesseurs.contains(prof.getNomComplet())) {
                    checkBox.setSelected(true);
                }
                checkBoxes.add(checkBox);
                panelProfesseurs.add(checkBox);
            }

            panelProfesseurs.revalidate();
            panelProfesseurs.repaint();

        } catch (Exception ex) {
            System.err.println("Erreur lors du chargement des professeurs: " + ex.getMessage());
        }
    }

    public String getSelectedProfesseursText() {
        StringBuilder sb = new StringBuilder();
        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(cb.getText());
            }
        }
        return sb.toString();
    }

    private void initComponents() {
        JLabel L_selectionner = new JLabel("Sélectionner les Professeurs");
        L_selectionner.setFont(new Font("Calibri", Font.PLAIN, 24));

        panelProfesseurs = new JPanel();
        panelProfesseurs.setLayout(new BoxLayout(panelProfesseurs, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelProfesseurs);

//        TF_newProf = new JTextField(20);
//        TF_newProf.setFont(new Font("Calibri", Font.PLAIN, 16));

//        JButton B_add = new JButton("Ajouter");
//        B_add.setFont(new Font("Calibri", Font.PLAIN, 16));
//        B_add.setBackground(new Color(18, 53, 36));
//        B_add.setForeground(new Color(239, 227, 194));
//        B_add.setFocusable(false);
//        B_add.addActionListener(e -> addProfesseur());

//        JPanel addPanel = new JPanel(new FlowLayout());
//        addPanel.add(TF_newProf);
//        addPanel.add(B_add);

        JButton B_valider = new JButton("Valider");
        B_valider.setFont(new Font("Calibri", Font.PLAIN, 18));
        B_valider.setBackground(new Color(18, 53, 36));
        B_valider.setForeground(new Color(239, 227, 194));
        B_valider.setFocusable(false);
        B_valider.addActionListener(e -> SwingUtilities.getWindowAncestor(this).dispose());

        setPreferredSize(new Dimension(420, 450));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(20));
        add(L_selectionner);
        add(Box.createVerticalStrut(18));
        add(scrollPane);
        add(Box.createVerticalStrut(18));
//        add(addPanel);
        add(Box.createVerticalStrut(18));
        add(B_valider);
        add(Box.createVerticalStrut(20));
    }

//    private void addProfesseur() {
//        String nom = TF_newProf.getText().trim();
//        if (nom.isEmpty()) return;
//
//        try {
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
//            EntityManager em = emf.createEntityManager();
//
//            em.getTransaction().begin();
//            Professeur newProf = new Professeur();
//            newProf.setNomComplet(nom);
//            em.persist(newProf);
//            em.getTransaction().commit();
//            em.close();
//            emf.close();
//
//            JCheckBox cb = new JCheckBox(nom);
//            cb.setFont(new Font("Calibri", Font.PLAIN, 16));
//            cb.setSelected(true);
//            checkBoxes.add(cb);
//            panelProfesseurs.add(cb);
//            panelProfesseurs.revalidate();
//            panelProfesseurs.repaint();
//
//            TF_newProf.setText("");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Erreur ajout professeur : " + ex.getMessage());
//        }
//    }
}
