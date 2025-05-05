package com.smi6.gestion_des_articles_informatique.view.statistiques;

import com.smi6.gestion_des_articles_informatique.model.*;
import com.smi6.gestion_des_articles_informatique.view.connexion_home.Accueille_admin2;
import jakarta.persistence.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author YN
 */
public class DetailsProfesseur extends javax.swing.JFrame {
    private Utilisateur U;
    private int professeurId;
    private String professeurNom;
    private Map<String, List<?>> publicationsData;
    private String[] publicationTypes = {"Article", "Thèse", "Mémoire", "Brevet", "Conférence", "Rapport"};
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructor with search results
     */
    public DetailsProfesseur(Utilisateur U, int professeurId, String professeurNom, Map<String, List<?>> publicationsData) {
        this.U = U;
        this.professeurId = professeurId;
        this.professeurNom = professeurNom;
        this.publicationsData = publicationsData;
        initComponents();
        setLocationRelativeTo(null);
        loadDataFromResults();
    }

    private void initComponents() {
        setSize(1050, 600);
        setTitle("Détails des publications");
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        L_title = new javax.swing.JLabel();
        B_retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Configure table
        jTable1.setFont(new java.awt.Font("Calibri", 0, 16));
        jTable1.setRowHeight(30);
        jTable1.setBackground(new java.awt.Color(239, 227, 194));
        jTable1.setFocusable(false);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "Type", "Titre", "Date", "Info", "Voir PDF" }
        ));
        jScrollPane1.setViewportView(jTable1);

        // Configure title with professor name
        L_title = new javax.swing.JLabel();
        L_title.setFont(new java.awt.Font("Calibri", 1, 24));
        L_title.setForeground(new java.awt.Color(18, 53, 36));
        L_title.setText("Publications du prof. " + professeurNom);

        // Configure return button
        B_retour = new javax.swing.JButton();
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

        // Layout setup
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

    /**
     * Load data from search results
     */
    private void loadDataFromResults() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        // Process articles
        if (publicationsData.containsKey("articles")) {
            List<Article> articles = (List<Article>) publicationsData.get("articles");
            for (Article article : articles) {
                addPublicationToTable(model, "Article", article.getTitre(), article.getDatePublication(), 
                        article.getCheminPdf(), article, null);
            }
        }
        
        // Process theses
        if (publicationsData.containsKey("theses")) {
            List<These> theses = (List<These>) publicationsData.get("theses");
            for (These these : theses) {
                addPublicationToTable(model, "Thèse", these.getTitre(), these.getDateSoutenance(), 
                        these.getCheminPdf(), null, these);
            }
        }
        
        // Process memoires
        if (publicationsData.containsKey("memoires")) {
            List<Memoire> memoires = (List<Memoire>) publicationsData.get("memoires");
            for (Memoire memoire : memoires) {
                addPublicationToTable(model, "Mémoire", memoire.getTitre(), memoire.getDateSoutenance(), 
                        memoire.getCheminPdf(), null, memoire);
            }
        }
        
        // Process brevets
        if (publicationsData.containsKey("brevets")) {
            List<Brevet> brevets = (List<Brevet>) publicationsData.get("brevets");
            for (Brevet brevet : brevets) {
                addPublicationToTable(model, "Brevet", brevet.getTitre(), brevet.getDateDepot(), 
                        brevet.getCheminPdf(), null, brevet);
            }
        }
        
        // Process conferences
        if (publicationsData.containsKey("conferences")) {
            List<Conference> conferences = (List<Conference>) publicationsData.get("conferences");
            for (Conference conference : conferences) {
                addPublicationToTable(model, "Conférence", conference.getTitre(), conference.getDateConference(), 
                        conference.getCheminPdf(), null, conference);
            }
        }
        
        // Process rapports
        if (publicationsData.containsKey("rapports")) {
            List<RapportRecherche> rapports = (List<RapportRecherche>) publicationsData.get("rapports");
            for (RapportRecherche rapport : rapports) {
                addPublicationToTable(model, "Rapport", rapport.getTitre(), rapport.getDatePublication(), 
                        rapport.getCheminPdf(), null, rapport);
            }
        }
        
        // Configure column widths
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);  // Type
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(350); // Titre
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100); // Date
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);  // Info
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);  // PDF
        
        // Configure button renderers
        configureButtonRenderers();
    }
    
    /**
     * Add a publication to the table
     */
    private void addPublicationToTable(DefaultTableModel model, String type, String titre, Date date, 
                                     String pdfPath, Object articleObj, Object otherObj) {
        // Format date
        String dateStr = date != null ? dateFormat.format(date) : "-";
        
        // Create info button
        JButton infoBtn = new JButton("Info");
        infoBtn.setBackground(new java.awt.Color(70, 130, 180));
        infoBtn.setForeground(Color.WHITE);
        infoBtn.setFont(new java.awt.Font("Calibri", 0, 14));
        infoBtn.setFocusPainted(false);
        
        // Set action for info button
        infoBtn.addActionListener(e -> {
            showPublicationDetails(type, articleObj, otherObj);
        });
        
        // Create PDF button
        JButton pdfBtn = new JButton("PDF");
        pdfBtn.setBackground(new java.awt.Color(18, 53, 36));
        pdfBtn.setForeground(new java.awt.Color(239, 227, 194));
        pdfBtn.setFont(new java.awt.Font("Calibri", 0, 14));
        pdfBtn.setFocusPainted(false);
        
        // Set action for PDF button
        if (pdfPath != null && !pdfPath.isEmpty()) {
            pdfBtn.addActionListener(e -> {
                openPdfFile(pdfPath);
            });
        } else {
            pdfBtn.setEnabled(false);
        }
        
        // Add row to table
        model.addRow(new Object[] { type, titre, dateStr, infoBtn, pdfBtn });
    }
    
    /**
     * Configure button renderers for the table
     */
    private void configureButtonRenderers() {
        // Configure Info button column
        jTable1.getColumn("Info").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });
        
        jTable1.getColumn("Info").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            private JButton button;
            
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, 
                    boolean isSelected, int row, int column) {
                button = (JButton) value;
                return button;
            }
        });
        
        // Configure PDF button column
        jTable1.getColumn("Voir PDF").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });
        
        jTable1.getColumn("Voir PDF").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            private JButton button;
            
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, 
                    boolean isSelected, int row, int column) {
                button = (JButton) value;
                return button;
            }
        });
    }
    
    /**
     * Show publication details in a popup
     */
    private void showPublicationDetails(String type, Object articleObj, Object otherObj) {
        JDialog dialog = new JDialog(this, "Détails de la publication", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        // Display different details based on publication type
        if (type.equals("Article") && articleObj != null) {
            Article article = (Article) articleObj;
            addInfoLine(infoPanel, "Type:", "Article scientifique");
            addInfoLine(infoPanel, "Titre:", article.getTitre());
            addInfoLine(infoPanel, "Résumé:", article.getResume());
            addInfoLine(infoPanel, "Date de publication:", article.getDatePublication() != null ? 
                    dateFormat.format(article.getDatePublication()) : "-");
            
            // Get journal info if available
            if (article.getJournaux() != null && !article.getJournaux().isEmpty()) {
                Journal journal = article.getJournaux().get(0);
                addInfoLine(infoPanel, "Journal:", journal.getNom());
                addInfoLine(infoPanel, "Quartile:", journal.getQuartile());
            }
            
            // List co-authors
            StringBuilder authorsStr = new StringBuilder();
            for (Professeur prof : article.getProfesseurs()) {
                if (authorsStr.length() > 0) authorsStr.append(", ");
                authorsStr.append(prof.getNomComplet());
            }
            addInfoLine(infoPanel, "Auteurs:", authorsStr.toString());
            
        } else if (type.equals("Thèse") && otherObj != null) {
            These these = (These) otherObj;
            addInfoLine(infoPanel, "Type:", "Thèse de doctorat");
            addInfoLine(infoPanel, "Titre:", these.getTitre());
            addInfoLine(infoPanel, "Résumé:", these.getResume());
            addInfoLine(infoPanel, "Date de soutenance:", these.getDateSoutenance() != null ? 
                    dateFormat.format(these.getDateSoutenance()) : "-");
            addInfoLine(infoPanel, "Doctorant:", these.getEtudiant());
            addInfoLine(infoPanel, "Directeur:", these.getDirecteur() != null ? 
                    these.getDirecteur().getNomComplet() : "-");
            
        } else if (type.equals("Mémoire") && otherObj != null) {
            Memoire memoire = (Memoire) otherObj;
            addInfoLine(infoPanel, "Type:", "Mémoire de master");
            addInfoLine(infoPanel, "Titre:", memoire.getTitre());
            addInfoLine(infoPanel, "Résumé:", memoire.getResume());
            addInfoLine(infoPanel, "Date de soutenance:", memoire.getDateSoutenance() != null ? 
                    dateFormat.format(memoire.getDateSoutenance()) : "-");
            addInfoLine(infoPanel, "Étudiant:", memoire.getEtudiant());
            addInfoLine(infoPanel, "Encadrant:", memoire.getDirecteur() != null ? 
                    memoire.getDirecteur().getNomComplet() : "-");
            
        } else if (type.equals("Brevet") && otherObj != null) {
            Brevet brevet = (Brevet) otherObj;
            addInfoLine(infoPanel, "Type:", "Brevet d'invention");
            addInfoLine(infoPanel, "Titre:", brevet.getTitre());
            addInfoLine(infoPanel, "Description:", brevet.getDescription());
            addInfoLine(infoPanel, "Date de dépôt:", brevet.getDateDepot() != null ? 
                    dateFormat.format(brevet.getDateDepot()) : "-");
            addInfoLine(infoPanel, "Statut:", brevet.getStatut());
            
            // List inventors
            StringBuilder inventorsStr = new StringBuilder();
            for (Professeur prof : brevet.getInventeurs()) {
                if (inventorsStr.length() > 0) inventorsStr.append(", ");
                inventorsStr.append(prof.getNomComplet());
            }
            addInfoLine(infoPanel, "Inventeurs:", inventorsStr.toString());
            
        } else if (type.equals("Conférence") && otherObj != null) {
            Conference conference = (Conference) otherObj;
            addInfoLine(infoPanel, "Type:", "Présentation de conférence");
            addInfoLine(infoPanel, "Titre:", conference.getTitre());
            addInfoLine(infoPanel, "Résumé:", conference.getResume());
            addInfoLine(infoPanel, "Date:", conference.getDateConference() != null ? 
                    dateFormat.format(conference.getDateConference()) : "-");
            addInfoLine(infoPanel, "Lieu:", conference.getLieu());
            
            // List presenters
            StringBuilder presentersStr = new StringBuilder();
            for (Professeur prof : conference.getProfesseurs()) {
                if (presentersStr.length() > 0) presentersStr.append(", ");
                presentersStr.append(prof.getNomComplet());
            }
            addInfoLine(infoPanel, "Présentateurs:", presentersStr.toString());
            
        } else if (type.equals("Rapport") && otherObj != null) {
            RapportRecherche rapport = (RapportRecherche) otherObj;
            addInfoLine(infoPanel, "Type:", "Rapport de recherche");
            addInfoLine(infoPanel, "Titre:", rapport.getTitre());
            addInfoLine(infoPanel, "Résumé:", rapport.getResume());
            addInfoLine(infoPanel, "Date de publication:", rapport.getDatePublication() != null ? 
                    dateFormat.format(rapport.getDatePublication()) : "-");
            
            // List authors
            StringBuilder authorsStr = new StringBuilder();
            for (Professeur prof : rapport.getAuteurs()) {
                if (authorsStr.length() > 0) authorsStr.append(", ");
                authorsStr.append(prof.getNomComplet());
            }
            addInfoLine(infoPanel, "Auteurs:", authorsStr.toString());
        }
        
        // Add scroll pane for info panel
        JScrollPane scrollPane = new JScrollPane(infoPanel);
        scrollPane.setBorder(null);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Add close button
        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new java.awt.Color(18, 53, 36));
        closeButton.setForeground(new java.awt.Color(239, 227, 194));
        closeButton.setFont(new java.awt.Font("Calibri", 0, 16));
        closeButton.addActionListener(e -> {
            dialog.dispose();
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(closeButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        dialog.setContentPane(contentPanel);
        dialog.setVisible(true);
    }
    
    /**
     * Add a line of information to the info panel
     */
    private void addInfoLine(JPanel panel, String label, String value) {
        JPanel linePanel = new JPanel(new BorderLayout());
        linePanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        JLabel labelComp = new JLabel(label);
        labelComp.setFont(new Font("Calibri", Font.BOLD, 14));
        labelComp.setPreferredSize(new Dimension(120, 20));
        linePanel.add(labelComp, BorderLayout.WEST);
        
        JTextArea valueArea = new JTextArea(value != null ? value : "-");
        valueArea.setLineWrap(true);
        valueArea.setWrapStyleWord(true);
        valueArea.setEditable(false);
        valueArea.setBackground(panel.getBackground());
        valueArea.setFont(new Font("Calibri", Font.PLAIN, 14));
        
        // If the text is a long description or resumé, set a larger size
        if (label.contains("Résumé") || label.contains("Description")) {
            valueArea.setRows(4);
            JScrollPane scrollPane = new JScrollPane(valueArea);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            linePanel.add(scrollPane, BorderLayout.CENTER);
        } else {
            linePanel.add(valueArea, BorderLayout.CENTER);
        }
        
        panel.add(linePanel);
    }
    
    /**
     * Open PDF file
     */
    private void openPdfFile(String pdfPath) {
        try {
            if (pdfPath != null && !pdfPath.isEmpty()) {
                File file = new File(pdfPath);
                if (file.exists()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Le fichier PDF n'existe pas à l'emplacement spécifié : " + pdfPath,
                        "Fichier introuvable", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Erreur lors de l'ouverture du PDF : " + ex.getMessage(),
                "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void B_retourActionPerformed(java.awt.event.ActionEvent evt) {
        Professeur_Resume resumeView = new Professeur_Resume(U);
        resumeView.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            // This is just a placeholder for testing
            Map<String, List<?>> emptyData = new HashMap<>();
            new DetailsProfesseur(null, 1, "Professeur Test", emptyData).setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton B_retour;
    private javax.swing.JLabel L_title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}