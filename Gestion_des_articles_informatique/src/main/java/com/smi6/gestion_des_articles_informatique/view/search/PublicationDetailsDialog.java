package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.model.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.List; // ✅ CORRECT


public class PublicationDetailsDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public PublicationDetailsDialog(JFrame parent, Object publication) {
        super(parent, "Détails de la publication", true);
        setSize(600, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        populateContent(publication);

        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void populateContent(Object pub) {
        if (pub instanceof Article a) {
            addLabel("Type: Article");
            addLabel("Titre: " + a.getTitre());
            addLabel("Résumé: " + a.getResume());
            addLabel("Date: " + formatDate(a.getDatePublication()));
            addLabel("Professeurs: " + joinNames(a.getProfesseurs()));
            addLabel("Journaux: " + a.getJournaux().stream().map(Journal::getNom).collect(Collectors.joining(", ")));
        } else if (pub instanceof Conference c) {
            addLabel("Type: Conférence");
            addLabel("Titre: " + c.getTitre());
            addLabel("Résumé: " + c.getResume());
            addLabel("Lieu: " + c.getLieu());
            addLabel("Date: " + formatDate(c.getDateConference()));
            addLabel("Professeurs: " + joinNames(c.getProfesseurs()));
        } else if (pub instanceof Brevet b) {
            addLabel("Type: Brevet");
            addLabel("Titre: " + b.getTitre());
            addLabel("Description: " + b.getDescription());
            addLabel("Date de dépôt: " + formatDate(b.getDateDepot()));
            addLabel("Statut: " + b.getStatut());
            addLabel("Inventeurs: " + joinNames(b.getInventeurs()));
        } else if (pub instanceof These t) {
            addLabel("Type: Thèse");
            addLabel("Titre: " + t.getTitre());
            addLabel("Résumé: " + t.getResume());
            addLabel("Etudiant: " + t.getEtudiant());
            addLabel("Directeur: " + (t.getDirecteur() != null ? t.getDirecteur().getNomComplet() : ""));
            addLabel("Date de soutenance: " + formatDate(t.getDateSoutenance()));
        } else if (pub instanceof Memoire m) {
            addLabel("Type: Mémoire");
            addLabel("Titre: " + m.getTitre());
            addLabel("Résumé: " + m.getResume());
            addLabel("Etudiant: " + m.getEtudiant());
            addLabel("Directeur: " + (m.getDirecteur() != null ? m.getDirecteur().getNomComplet() : ""));
            addLabel("Date de soutenance: " + formatDate(m.getDateSoutenance()));
        } else if (pub instanceof RapportRecherche r) {
            addLabel("Type: Rapport de recherche");
            addLabel("Titre: " + r.getTitre());
            addLabel("Résumé: " + r.getResume());
            addLabel("Date de publication: " + formatDate(r.getDatePublication()));
            addLabel("Auteurs: " + joinNames(r.getAuteurs()));
        } else {
            addLabel("Type non pris en charge.");
        }
    }

    private void addLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        contentPanel.add(label);
    }

    private String formatDate(java.util.Date date) {
        return (date != null) ? dateFormat.format(date) : "N/A";
    }

    private String joinNames(List<Professeur> profs) {
        return profs.stream().map(Professeur::getNomComplet).collect(Collectors.joining(", "));
    }
}
