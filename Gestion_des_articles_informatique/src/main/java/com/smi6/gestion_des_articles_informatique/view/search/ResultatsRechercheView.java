package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ResultatsRechercheView extends JFrame {
    private JTable tableResultats;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnRetour;
    private Utilisateur utilisateur;
    private List<Integer> idsArticles;
    private List<Integer> idsConferences;
    private List<Integer> idsBrevets;
    private List<Integer> idsTheses;
    private List<Integer> idsMemoires;
    private List<Integer> idsRapports;
    private List<DocumentInfo> documentsInfo = new ArrayList<>();
    // Define colors and font as constants
    private final Color BACKGROUND_COLOR = new Color(239, 227, 194);
    private final Color BUTTON_BACKGROUND = new Color(18, 53, 36);
    private final Color BUTTON_TEXT = new Color(239, 227, 194);
    private final Font CALIBRI_FONT = new Font("Calibri", Font.PLAIN, 14);

    public ResultatsRechercheView(
            Utilisateur utilisateur,
            List<Integer> idsArticles,
            List<Integer> idsConferences,
            List<Integer> idsBrevets,
            List<Integer> idsTheses,
            List<Integer> idsMemoires,
            List<Integer> idsRapports) {

        this.utilisateur = utilisateur;
        this.idsArticles = idsArticles != null ? idsArticles : new ArrayList<>();
        this.idsConferences = idsConferences != null ? idsConferences : new ArrayList<>();
        this.idsBrevets = idsBrevets != null ? idsBrevets : new ArrayList<>();
        this.idsTheses = idsTheses != null ? idsTheses : new ArrayList<>();
        this.idsMemoires = idsMemoires != null ? idsMemoires : new ArrayList<>();
        this.idsRapports = idsRapports != null ? idsRapports : new ArrayList<>();

        setTitle("Résultats de recherche");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1050, 600);
        setLocationRelativeTo(null);

        // Set default font for the entire UI
        setUIFont(CALIBRI_FONT);

        initComponents();
        chargerDonnees();
    }

    // Method to set default font for all UI components
    private void setUIFont(Font font) {
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
    }

    private void initComponents() {
        String[] entetes = {"Type", "Titre", "Date", "Détails", "Voir PDF"};
        tableModel = new DefaultTableModel(entetes, 0) {
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3 || columnIndex == 4) return JButton.class;
                return String.class;
            }
        };

        tableResultats = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            // Override to set background color for cells except buttons (columns 3 and 4)
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                // Apply background color only to non-button cells
                if (column != 3 && column != 4) {
                    comp.setBackground(BACKGROUND_COLOR);
                }
                comp.setFont(CALIBRI_FONT);
                return comp;
            }
        };
        tableResultats.setRowHeight(40); // Smaller row height
        tableResultats.setFont(CALIBRI_FONT);
        tableResultats.getTableHeader().setFont(CALIBRI_FONT);
        tableResultats.setGridColor(new Color(200, 200, 200));
        
        // Keep the header with default look
        tableResultats.getTableHeader().setFont(CALIBRI_FONT);

        // Custom button renderer that preserves the default Java Swing button behavior
        tableResultats.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton(value.toString());
                button.setBackground(BUTTON_BACKGROUND);
                button.setForeground(BUTTON_TEXT);
                button.setFont(CALIBRI_FONT);
                return button;
            }
        });

        tableResultats.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = tableResultats.rowAtPoint(evt.getPoint());
                int col = tableResultats.columnAtPoint(evt.getPoint());
                if (row >= 0 && col == 3) {
                    // Simulate button click effect
                    JButton button = (JButton) tableResultats.getDefaultRenderer(JButton.class)
                            .getTableCellRendererComponent(tableResultats, "Détails", false, false, row, col);
                    button.doClick();
                    tableResultats.repaint();
                    afficherDetails(row);
                }
                else if (row >= 0 && col == 4) {
                    // Simulate button click effect
                    JButton button = (JButton) tableResultats.getDefaultRenderer(JButton.class)
                            .getTableCellRendererComponent(tableResultats, "Voir PDF", false, false, row, col);
                    button.doClick();
                    tableResultats.repaint();
                    ouvrirPDF(row);
                }
            }
        });

        scrollPane = new JScrollPane(tableResultats);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        
        btnRetour = new JButton("Retour");
        btnRetour.setBackground(BUTTON_BACKGROUND);
        btnRetour.setForeground(BUTTON_TEXT);
        btnRetour.setFont(CALIBRI_FONT);
        btnRetour.setFocusable(false);
        btnRetour.addActionListener(e -> {
            new Select_type_R(utilisateur).setVisible(true);
            dispose();
        });

        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.setBackground(BACKGROUND_COLOR);
        panelBoutons.add(btnRetour);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);
        
        // Adjust column widths after the component is visible
        SwingUtilities.invokeLater(this::ajusterLargeurColonnes);
    }
    
    private void ajusterLargeurColonnes() {
        TableColumnModel columnModel = tableResultats.getColumnModel();
        
        // Set specific widths for each column
        columnModel.getColumn(0).setPreferredWidth(100);  // Type
        columnModel.getColumn(1).setPreferredWidth(500);  // Titre (give more space)
        columnModel.getColumn(2).setPreferredWidth(100);  // Date
        columnModel.getColumn(3).setPreferredWidth(80);   // Détails
        columnModel.getColumn(4).setPreferredWidth(80);   // Voir PDF
    }

    private void chargerDonnees() {
        documentsInfo.clear();
        for (Integer id : idsArticles) {
            Article a = chargerArticle(id);
            if (a != null) documentsInfo.add(new DocumentInfo("Article", a.getId(), a.getTitre(), a.getDatePublication(), a.getCheminPdf(), a));
        }
        for (Integer id : idsConferences) {
            Conference c = chargerConference(id);
            if (c != null) documentsInfo.add(new DocumentInfo("Conférence", c.getId(), c.getTitre(), c.getDateConference(), c.getCheminPdf(), c));
        }
        for (Integer id : idsBrevets) {
            Brevet b = chargerBrevet(id);
            if (b != null) documentsInfo.add(new DocumentInfo("Brevet", b.getId(), b.getTitre(), b.getDateDepot(), b.getCheminPdf(), b));
        }
        for (Integer id : idsTheses) {
            These t = chargerThese(id);
            if (t != null) documentsInfo.add(new DocumentInfo("Thèse", t.getId(), t.getTitre(), t.getDateSoutenance(), t.getCheminPdf(), t));
        }
        for (Integer id : idsMemoires) {
            Memoire m = chargerMemoire(id);
            if (m != null) documentsInfo.add(new DocumentInfo("Mémoire", m.getId(), m.getTitre(), m.getDateSoutenance(), m.getCheminPdf(), m));
        }
        for (Integer id : idsRapports) {
            RapportRecherche r = chargerRapport(id);
            if (r != null) documentsInfo.add(new DocumentInfo("Rapport", r.getId(), r.getTitre(), r.getDatePublication(), r.getCheminPdf(), r));
        }
        remplirTableau();
    }

    private void remplirTableau() {
        tableModel.setRowCount(0);
        for (DocumentInfo doc : documentsInfo) {
            tableModel.addRow(new Object[]{doc.getType(), doc.getTitre(), doc.getFormattedDate(), "Détails", "Voir PDF"});
        }
    }

    private void afficherDetails(int row) {
        if (row >= 0 && row < documentsInfo.size()) {
            DocumentInfo doc = documentsInfo.get(row);
            PublicationDetailsDialog dialog = new PublicationDetailsDialog(this, doc.getEntity());
            dialog.setVisible(true);
        }
    }

    private void ouvrirPDF(int row) {
        if (row >= 0 && row < documentsInfo.size()) {
            DocumentInfo doc = documentsInfo.get(row);
            String cheminPdf = doc.getCheminPdf();
            if (cheminPdf != null && !cheminPdf.isEmpty()) {
                try {
                    File pdfFile = new File(cheminPdf);
                    if (pdfFile.exists()) {
                        // Fix the URI creation to properly handle special characters
                        URI uri = pdfFile.toURI();
                        Desktop.getDesktop().browse(uri);
                    } else {
                        JOptionPane.showMessageDialog(this, "Le fichier PDF n'a pas été trouvé: " + cheminPdf, "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'ouverture du PDF: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace(); // Print stack trace for debugging
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aucun PDF n'est associé à ce document.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private Article chargerArticle(Integer id) {
        return chargerEntite(Article.class, id);
    }
    private Conference chargerConference(Integer id) {
        return chargerEntite(Conference.class, id);
    }
    private Brevet chargerBrevet(Integer id) {
        return chargerEntite(Brevet.class, id);
    }
    private These chargerThese(Integer id) {
        return chargerEntite(These.class, id);
    }
    private Memoire chargerMemoire(Integer id) {
        return chargerEntite(Memoire.class, id);
    }
    private RapportRecherche chargerRapport(Integer id) {
        return chargerEntite(RapportRecherche.class, id);
    }

    private <T> T chargerEntite(Class<T> clazz, Integer id) {
   EntityManagerFactory emf = null;
    EntityManager em = null;
    try {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
        T entity = em.find(clazz, id);

        // Force lazy collections to load before closing EM
        if (entity instanceof Article a) {
            a.getProfesseurs().size();
            a.getJournaux().size();
        } else if (entity instanceof Conference c) {
            c.getProfesseurs().size();
        } else if (entity instanceof Brevet b) {
            b.getInventeurs().size();
        } else if (entity instanceof RapportRecherche r) {
            r.getAuteurs().size();
        }

        return entity;
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement de " + clazz.getSimpleName() + " (ID: " + id + "): " + e.getMessage());
        return null;
    } finally {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
    }

    private static class DocumentInfo {
        private String type;
        private Integer id;
        private String titre;
        private java.util.Date date;
        private String cheminPdf;
        private Object entity;

        public DocumentInfo(String type, Integer id, String titre, java.util.Date date, String cheminPdf, Object entity) {
            this.type = type;
            this.id = id;
            this.titre = titre;
            this.date = date;
            this.cheminPdf = cheminPdf;
            this.entity = entity;
        }

        public String getType() { return type; }
        public Integer getId() { return id; }
        public String getTitre() { return titre; }
        public java.util.Date getDate() { return date; }
        public String getFormattedDate() {
            return (date != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(date) : "";
        }
        public String getCheminPdf() { return cheminPdf; }
        public Object getEntity() { return entity; }
    }
}