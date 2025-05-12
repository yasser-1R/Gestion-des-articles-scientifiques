package com.smi6.gestion_des_articles_informatique.view.results;

import com.smi6.gestion_des_articles_informatique.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.List;

public class PublicationDetailsDialog extends JDialog {

    // Match the colors and fonts from the main application
    private final Color BACKGROUND_COLOR = new Color(239, 227, 194);
    private final Color BUTTON_BACKGROUND = new Color(18, 53, 36);
    private final Color BUTTON_TEXT = new Color(239, 227, 194);
    private final Color SECTION_TITLE_COLOR = new Color(18, 53, 36);
    private final Color TEXT_COLOR = new Color(60, 60, 60);
    private final Font CALIBRI_TITLE = new Font("Calibri", Font.BOLD, 20);
    private final Font CALIBRI_SECTION = new Font("Calibri", Font.BOLD, 18);
    private final Font CALIBRI_CONTENT = new Font("Calibri", Font.PLAIN, 16);
    
    private final JPanel contentPanel = new JPanel();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public PublicationDetailsDialog(JFrame parent, Object publication) {
        super(parent, "Détails de la publication", true);
        setSize(700, 500); // Increased size for better readability
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        
        // Set background color for the entire dialog
        getContentPane().setBackground(BACKGROUND_COLOR);
        
        // Create a header panel
        JPanel headerPanel = createHeaderPanel(publication);
        add(headerPanel, BorderLayout.NORTH);
        
        // Setup the content panel with a more attractive layout
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        // Create a scroll pane with custom styling
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBackground(BACKGROUND_COLOR);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        add(scrollPane, BorderLayout.CENTER);

        populateContent(publication);

        // Create a styled bottom panel with buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        JButton closeButton = new JButton("Fermer");
        styleButton(closeButton);
        closeButton.addActionListener(e -> dispose());
        buttonPanel.add(closeButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createHeaderPanel(Object publication) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(BUTTON_BACKGROUND);
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        // Create title based on publication type
        String title = getPublicationType(publication);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(CALIBRI_TITLE);
        titleLabel.setForeground(BUTTON_TEXT);
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        
        return headerPanel;
    }
    
    private String getPublicationType(Object pub) {
        if (pub instanceof Article) return "Détails de l'Article";
        else if (pub instanceof Conference) return "Détails de la Conférence";
        else if (pub instanceof Brevet) return "Détails du Brevet";
        else if (pub instanceof These) return "Détails de la Thèse";
        else if (pub instanceof Memoire) return "Détails du Mémoire";
        else if (pub instanceof RapportRecherche) return "Détails du Rapport de Recherche";
        else return "Détails de la Publication";
    }
    
    private void styleButton(JButton button) {
        button.setBackground(BUTTON_BACKGROUND);
        button.setForeground(BUTTON_TEXT);
        button.setFont(CALIBRI_CONTENT);
        button.setFocusPainted(false);
        button.setBorder(new CompoundBorder(
            new LineBorder(new Color(10, 30, 20), 1),
            new EmptyBorder(8, 15, 8, 15)
        ));
    }

    private void populateContent(Object pub) {
        if (pub instanceof Article a) {
                    addSectionTitle("Informations Générales");
        addFieldWithValue("Titre", a.getTitre());
        addFieldWithValue("Date de publication", formatDate(a.getDatePublication()));
        
        addSectionTitle("Contenu");
        addFieldWithValue("Résumé", a.getResume());
        
        addSectionTitle("Auteurs et Publication");
        addFieldWithValue("Professeurs", joinNames(a.getProfesseurs()));
        
        // 🔽 Journals with Quartile
        String journalsWithQuartile = a.getJournaux().stream()
            .map(journal -> journal.getNom() + " (" + journal.getQuartile() + ")")
            .collect(Collectors.joining(", "));
        addFieldWithValue("Journaux", journalsWithQuartile);
    
           } else if (pub instanceof Conference c) {
            addSectionTitle("Informations Générales");
            addFieldWithValue("Titre", c.getTitre());
            addFieldWithValue("Date", formatDate(c.getDateConference()));
            addFieldWithValue("Lieu", c.getLieu());
            
            addSectionTitle("Contenu");
            addFieldWithValue("Résumé", c.getResume());
            
            addSectionTitle("Participants");
            addFieldWithValue("Professeurs", joinNames(c.getProfesseurs()));
        } else if (pub instanceof Brevet b) {
            addSectionTitle("Informations Générales");
            addFieldWithValue("Titre", b.getTitre());
            addFieldWithValue("Date de dépôt", formatDate(b.getDateDepot()));
            addFieldWithValue("Statut", b.getStatut());
            
            addSectionTitle("Contenu");
            addFieldWithValue("Description", b.getDescription());
            
            addSectionTitle("Inventeurs");
            addFieldWithValue("Inventeurs", joinNames(b.getInventeurs()));
        } else if (pub instanceof These t) {
            addSectionTitle("Informations Générales");
            addFieldWithValue("Titre", t.getTitre());
            addFieldWithValue("Date de soutenance", formatDate(t.getDateSoutenance()));
            
            addSectionTitle("Contenu");
            addFieldWithValue("Résumé", t.getResume());
            
            addSectionTitle("Personnes");
            addFieldWithValue("Etudiant", t.getEtudiant());
            addFieldWithValue("Directeur", (t.getDirecteur() != null ? t.getDirecteur().getNomComplet() : "Non spécifié"));
        } else if (pub instanceof Memoire m) {
            addSectionTitle("Informations Générales");
            addFieldWithValue("Titre", m.getTitre());
            addFieldWithValue("Date de soutenance", formatDate(m.getDateSoutenance()));
            
            addSectionTitle("Contenu");
            addFieldWithValue("Résumé", m.getResume());
            
            addSectionTitle("Personnes");
            addFieldWithValue("Etudiant", m.getEtudiant());
            addFieldWithValue("Directeur", (m.getDirecteur() != null ? m.getDirecteur().getNomComplet() : "Non spécifié"));
        } else if (pub instanceof RapportRecherche r) {
            addSectionTitle("Informations Générales");
            addFieldWithValue("Titre", r.getTitre());
            addFieldWithValue("Date de publication", formatDate(r.getDatePublication()));
            
            addSectionTitle("Contenu");
            addFieldWithValue("Résumé", r.getResume());
            
            addSectionTitle("Auteurs");
            addFieldWithValue("Auteurs", joinNames(r.getAuteurs()));
        } else {
            addFieldWithValue("Erreur", "Type de publication non pris en charge.");
        }
    }

    private void addSectionTitle(String title) {
        // Add some space before each section except the first one
        if (contentPanel.getComponentCount() > 0) {
            contentPanel.add(Box.createVerticalStrut(15));
        }
        
        JLabel sectionLabel = new JLabel(title);
        sectionLabel.setFont(CALIBRI_SECTION);
        sectionLabel.setForeground(SECTION_TITLE_COLOR);
        sectionLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, SECTION_TITLE_COLOR),
            BorderFactory.createEmptyBorder(5, 0, 5, 0)
        ));
        sectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(sectionLabel);
        contentPanel.add(Box.createVerticalStrut(10));
    }

    private void addFieldWithValue(String fieldName, String value) {
        // Create a panel for this field with a 2-column layout
        JPanel fieldPanel = new JPanel(new BorderLayout(15, 0));
        fieldPanel.setBackground(BACKGROUND_COLOR);
        fieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        // Field name (left column, bold)
        JLabel nameLabel = new JLabel(fieldName + ":");
        nameLabel.setFont(new Font(CALIBRI_CONTENT.getName(), Font.BOLD, CALIBRI_CONTENT.getSize()));
        nameLabel.setForeground(TEXT_COLOR);
        nameLabel.setPreferredSize(new Dimension(150, nameLabel.getPreferredSize().height));
        fieldPanel.add(nameLabel, BorderLayout.WEST);
        
        // Field value (right column, might be multiline for longer text)
        if (fieldName.equals("Résumé") || fieldName.equals("Description")) {
            // For longer text, use a text area with word wrap
            JTextArea valueArea = new JTextArea(value);
            valueArea.setFont(CALIBRI_CONTENT);
            valueArea.setForeground(TEXT_COLOR);
            valueArea.setBackground(BACKGROUND_COLOR);
            valueArea.setLineWrap(true);
            valueArea.setWrapStyleWord(true);
            valueArea.setEditable(false);
            valueArea.setBorder(null);
            
            // Set preferred size for multi-line text
            int preferredHeight = Math.min(100, value.length() / 50 * 16 + 20);
            valueArea.setPreferredSize(new Dimension(400, preferredHeight));
            
            fieldPanel.add(valueArea, BorderLayout.CENTER);
        } else {
            // For shorter text, use a simple label
            JLabel valueLabel = new JLabel(value);
            valueLabel.setFont(CALIBRI_CONTENT);
            valueLabel.setForeground(TEXT_COLOR);
            fieldPanel.add(valueLabel, BorderLayout.CENTER);
        }
        
        contentPanel.add(fieldPanel);
    }

    private String formatDate(java.util.Date date) {
        return (date != null) ? dateFormat.format(date) : "Non spécifié";
    }

    private String joinNames(List<Professeur> profs) {
        if (profs == null || profs.isEmpty()) {
            return "Aucun";
        }
        return profs.stream().map(Professeur::getNomComplet).collect(Collectors.joining(", "));
    }
}