package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.model.Article;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Vue pour afficher les résultats de recherche des articles scientifiques
 */
public class ArticleResultsView extends JFrame {

    private JTable tableResultats;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnRetour;
    private Utilisateur utilisateur;
    private List<Integer> idsArticles;
    private List<DocumentInfo> documentsInfo = new ArrayList<>();

    /**
     * Constructeur
     */
    public ArticleResultsView(Utilisateur utilisateur, List<Integer> idsArticles) {
        this.utilisateur = utilisateur;
        this.idsArticles = idsArticles != null ? idsArticles : new ArrayList<>();

        setTitle("Résultats de recherche - Articles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        
        initComponents();
        chargerDonnees();
    }

    /**
     * Initialise les composants de l'interface utilisateur
     */
    private void initComponents() {
        String[] entetes = {"Type", "Titre", "Résumé", "Détails", "Voir PDF"};
        
        tableModel = new DefaultTableModel(entetes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3 || columnIndex == 4) {
                    return JButton.class;
                }
                return String.class;
            }
        };
        
        tableResultats = new JTable(tableModel);
        tableResultats.setRowHeight(50);
        
        tableResultats.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableResultats.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableResultats.getColumnModel().getColumn(2).setPreferredWidth(400);
        tableResultats.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableResultats.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        tableResultats.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                    boolean hasFocus, int row, int column) {
                JButton button = new JButton();
                if (column == 3) {
                    button.setText("Détails");
                } else if (column == 4) {
                    button.setText("Voir PDF");
                }
                button.setBackground(new Color(18, 53, 36));
                button.setForeground(new Color(239, 227, 194));
                return button;
            }
        });
        
        tableResultats.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableResultats.rowAtPoint(evt.getPoint());
                int col = tableResultats.columnAtPoint(evt.getPoint());
                
                if (row >= 0 && col >= 0) {
                    if (col == 3) {
                        afficherDetails(row);
                    } else if (col == 4) {
                        ouvrirPDF(row);
                    }
                }
            }
        });
        
        scrollPane = new JScrollPane(tableResultats);
        
        btnRetour = new JButton("Retour");
        btnRetour.setBackground(new Color(18, 53, 36));
        btnRetour.setForeground(new Color(239, 227, 194));
        btnRetour.setFocusable(false);
        btnRetour.addActionListener((ActionEvent e) -> {
            Select_type_R ST = new Select_type_R(utilisateur);
            ST.setVisible(true);
            dispose();
        });
        
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(btnRetour);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);
    }

    /**
     * Charge les données des articles depuis la base de données
     */
    private void chargerDonnees() {
        documentsInfo.clear();
        
        // Charger les articles
        for (Integer id : idsArticles) {
            Article article = chargerArticle(id);
            if (article != null) {
                DocumentInfo info = new DocumentInfo(
                    "Article", 
                    article.getId(), 
                    article.getTitre(), 
                    article.getResume(),
                    article.getCheminPdf()
                );
                documentsInfo.add(info);
            }
        }
        
        remplirTableau();
    }
    
    /**
     * Remplit le tableau avec les données des articles
     */
    private void remplirTableau() {
        tableModel.setRowCount(0);
        
        for (DocumentInfo doc : documentsInfo) {
            tableModel.addRow(new Object[]{
                doc.getType(),
                doc.getTitre(),
                doc.getResume(),
                "Détails",
                "Voir PDF"
            });
        }
    }
    
    /**
     * Affiche les détails d'un article
     */
    private void afficherDetails(int row) {
        if (row >= 0 && row < documentsInfo.size()) {
            DocumentInfo doc = documentsInfo.get(row);
            
            JOptionPane.showMessageDialog(
                this,
                "Type: " + doc.getType() + "\n" +
                "Titre: " + doc.getTitre() + "\n" +
                "Résumé: " + doc.getResume(),
                "Détails du document",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    /**
     * Ouvre le PDF associé à un article
     */
    private void ouvrirPDF(int row) {
        if (row >= 0 && row < documentsInfo.size()) {
            DocumentInfo doc = documentsInfo.get(row);
            String cheminPdf = doc.getCheminPdf();
            
            if (cheminPdf != null && !cheminPdf.isEmpty()) {
                try {
                    File pdfFile = new File(cheminPdf);
                    if (pdfFile.exists()) {
                        Desktop.getDesktop().browse(new URI("file:///" + pdfFile.getAbsolutePath().replace("\\", "/")));
                    } else {
                        JOptionPane.showMessageDialog(
                            this,
                            "Le fichier PDF n'a pas été trouvé: " + cheminPdf,
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Erreur lors de l'ouverture du PDF: " + e.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Aucun PDF n'est associé à ce document.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
    
    /**
     * Charge un article depuis la base de données
     */
    private Article chargerArticle(Integer id) {
        Article article = null;
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            em = emf.createEntityManager();
            article = em.find(Article.class, id);
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'article (ID: " + id + "): " + e.getMessage());
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

        return article;
    }
    
    /**
     * Classe interne pour stocker les informations des articles
     */
    private class DocumentInfo {
        private String type;
        private Integer id;
        private String titre;
        private String resume;
        private String cheminPdf;
        
        public DocumentInfo(String type, Integer id, String titre, String resume, String cheminPdf) {
            this.type = type;
            this.id = id;
            this.titre = titre;
            this.resume = resume;
            this.cheminPdf = cheminPdf;
        }
        
        public String getType() {
            return type;
        }
        
        public Integer getId() {
            return id;
        }
        
        public String getTitre() {
            return titre;
        }
        
        public String getResume() {
            return resume;
        }
        
        public String getCheminPdf() {
            return cheminPdf;
        }
    }
}