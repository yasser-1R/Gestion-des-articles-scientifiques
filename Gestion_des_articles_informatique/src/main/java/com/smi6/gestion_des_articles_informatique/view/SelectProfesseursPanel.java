package com.smi6.gestion_des_articles_informatique.view;

import com.smi6.gestion_des_articles_informatique.model.Professeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class SelectProfesseursPanel extends javax.swing.JPanel {

    private List<JCheckBox> checkBoxes = new ArrayList<>();
    private List<String> preSelectedProfesseurs;
    private JPanel panelProfesseurs;
    private JScrollPane scrollPane;
    private JTextField TF_newProf;

    public SelectProfesseursPanel(List<String> preSelectedProfesseurs) {
        this.preSelectedProfesseurs = preSelectedProfesseurs;
        initComponents();
        loadProfesseurs();
    }

    private void loadProfesseurs() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            List<Professeur> professeurs = em.createQuery("FROM Professeur", Professeur.class).getResultList();
            em.close();
            emf.close();

            panelProfesseurs.removeAll();

            for (Professeur prof : professeurs) {
                JCheckBox checkBox = new JCheckBox(prof.getNomComplet());
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
        setLayout(new BorderLayout());

        JLabel L_selectionner = new JLabel("Sélectionner les Professeurs");
        L_selectionner.setFont(new Font("Calibri", Font.PLAIN, 24));

        panelProfesseurs = new JPanel();
        panelProfesseurs.setLayout(new BoxLayout(panelProfesseurs, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(panelProfesseurs);

        // Ajout manuel
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new FlowLayout());
        TF_newProf = new JTextField(15);
        JButton B_add = new JButton("Ajouter");
        B_add.addActionListener(e -> addProfesseur());

        addPanel.add(new JLabel("Nouveau Professeur :"));
        addPanel.add(TF_newProf);
        addPanel.add(B_add);

        JButton B_valider = new JButton("Valider");
        B_valider.setBackground(new Color(18, 53, 36));
        B_valider.setForeground(new Color(239, 227, 194));
        B_valider.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        bottom.add(addPanel, BorderLayout.CENTER);
        bottom.add(B_valider, BorderLayout.SOUTH);

        add(L_selectionner, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    private void addProfesseur() {
        String nom = TF_newProf.getText().trim();
        if (nom.isEmpty()) return;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            Professeur newProf = new Professeur();
            newProf.setNomComplet(nom.toLowerCase());
            em.persist(newProf);
            em.getTransaction().commit();
            em.close();
            emf.close();

            JCheckBox cb = new JCheckBox(nom);
            cb.setSelected(true);
            checkBoxes.add(cb);
            panelProfesseurs.add(cb);
            panelProfesseurs.revalidate();
            panelProfesseurs.repaint();

            TF_newProf.setText("");
        } catch (Exception ex) {
            System.err.println("Erreur ajout professeur : " + ex.getMessage());
        }
    }
}
