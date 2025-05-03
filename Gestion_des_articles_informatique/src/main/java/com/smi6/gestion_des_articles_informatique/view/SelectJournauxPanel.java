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
    private JTextField TF_newJournal;

    public SelectJournauxPanel(List<String> preSelectedJournaux) {
        this.preSelectedJournaux = preSelectedJournaux;
        initComponents();
        loadJournaux();
    }

    private void loadJournaux() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            List<Journal> journaux = em.createQuery("FROM Journal", Journal.class).getResultList();
            em.close();
            emf.close();

            panelJournaux.removeAll();

            for (Journal journal : journaux) {
                JCheckBox checkBox = new JCheckBox(journal.getNom());
                if (preSelectedJournaux != null && preSelectedJournaux.contains(journal.getNom())) {
                    checkBox.setSelected(true);
                }
                checkBoxes.add(checkBox);
                panelJournaux.add(checkBox);
            }

            panelJournaux.revalidate();
            panelJournaux.repaint();

        } catch (Exception ex) {
            System.err.println("Erreur chargement journaux: " + ex.getMessage());
        }
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

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel L_selectionner = new JLabel("Sélectionner les Journaux");
        L_selectionner.setFont(new Font("Calibri", Font.PLAIN, 24));

        panelJournaux = new JPanel();
        panelJournaux.setLayout(new BoxLayout(panelJournaux, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelJournaux);

        // Ajout manuel
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new FlowLayout());
        TF_newJournal = new JTextField(15);
        JButton B_add = new JButton("Ajouter");
        B_add.addActionListener(e -> addJournal());

        addPanel.add(new JLabel("Nouveau Journal :"));
        addPanel.add(TF_newJournal);
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

    private void addJournal() {
        String nom = TF_newJournal.getText().trim();
        if (nom.isEmpty()) return;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            Journal newJournal = new Journal();
            newJournal.setNom(nom);
            em.persist(newJournal);
            em.getTransaction().commit();
            em.close();
            emf.close();

            JCheckBox cb = new JCheckBox(nom);
            cb.setSelected(true);
            checkBoxes.add(cb);
            panelJournaux.add(cb);
            panelJournaux.revalidate();
            panelJournaux.repaint();

            TF_newJournal.setText("");
        } catch (Exception ex) {
            System.err.println("Erreur ajout journal : " + ex.getMessage());
        }
    }
}
