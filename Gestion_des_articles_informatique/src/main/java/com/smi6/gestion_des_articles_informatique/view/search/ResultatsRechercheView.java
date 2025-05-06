package com.smi6.gestion_des_articles_informatique.view.search;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Vue pour afficher les résultats de recherche des documents scientifiques
 */
public class ResultatsRechercheView extends JFrame {

    // Composants UI
    private JTable tableResultats;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnRetour;

    // Utilisateur connecté
    private Utilisateur utilisateur;

    // Données à afficher
    private List<Integer> idsArticles;
    private List<Integer> idsConferences;
    private List<Integer> idsBrevets;
    private List<Integer> idsTheses;
    private List<Integer> idsMemoires;
    private List<Integer> idsRapports;

    // Structure pour stocker les informations des documents
    private List<DocumentInfo> documentsInfo = new ArrayList<>();

    /**
     * Constructeur
     */
    public ResultatsRechercheView(
            Utilisateur utilisateur,
            List<Integer> idsArticles,
            List<Integer> idsConferences,
            List<Integer> idsBrevets,
            List<Integer> idsTheses,
            List<Integer> idsMemoires,
            List<Integer> idsRapports) {
        
        // Initialisation des attributs
        this.utilisateur = utilisateur;
        this.idsArticles = idsArticles != null ? idsArticles : new ArrayList<>();
        this.idsConferences = idsConferences != null ? idsConferences : new ArrayList<>();
        this.idsBrevets = idsBrevets != null ? idsBrevets : new ArrayList<>();
        this.idsTheses = idsTheses != null ? idsTheses : new ArrayList<>();
        this.idsMemoires = idsMemoires != null ? idsMemoires : new ArrayList<>();
        this.idsRapports = idsRapports != null ? idsRapports : new ArrayList<>();

        // Configuration de la fenêtre
        setTitle("Résultats de recherche");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1050, 600);
        setLocationRelativeTo(null);
        
        // Initialisation des composants UI
        initComponents();
        
        // Charger les données
        chargerDonnees();
    }

    /**
     * Initialise les composants de l'interface utilisateur
     */
    private void initComponents() {
        // Définition des entêtes du tableau
        String[] entetes = {"Type", "Titre", "Résumé", "Détails", "Voir PDF"};
        
        // Création du modèle de table non éditable
        tableModel = new DefaultTableModel(entetes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4; // Seuls les boutons sont cliquables
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3 || columnIndex == 4) {
                    return JButton.class;
                }
                return String.class;
            }
        };
        
        // Création du tableau
        tableResultats = new JTable(tableModel);
        tableResultats.setRowHeight(50); // Hauteur de ligne augmentée pour plus de lisibilité
        
        // Définir les largeurs des colonnes
        tableResultats.getColumnModel().getColumn(0).setPreferredWidth(100); // Type
        tableResultats.getColumnModel().getColumn(1).setPreferredWidth(200); // Titre
        tableResultats.getColumnModel().getColumn(2).setPreferredWidth(400); // Résumé
        tableResultats.getColumnModel().getColumn(3).setPreferredWidth(100); // Détails
        tableResultats.getColumnModel().getColumn(4).setPreferredWidth(100); // Voir PDF
        
        // Personnalisation du rendu des cellules pour les boutons
        tableResultats.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                    boolean hasFocus, int row, int column) {
                JButton button = new JButton();
                if (column == 3) {
                    button.setText("Détails");
                    button.setBackground(new Color(18, 53, 36));
                    button.setForeground(new Color(239, 227, 194));
                } else if (column == 4) {
                    button.setText("Voir PDF");
                    button.setBackground(new Color(18, 53, 36));
                    button.setForeground(new Color(239, 227, 194));
                }
                return button;
            }
        });
        
        // Ajout d'un gestionnaire d'événements pour les clics sur les cellules du tableau
        tableResultats.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableResultats.rowAtPoint(evt.getPoint());
                int col = tableResultats.columnAtPoint(evt.getPoint());
                
                if (row >= 0 && col >= 0) {
                    if (col == 3) { // Bouton "Détails"
                        afficherDetails(row);
                    } else if (col == 4) { // Bouton "Voir PDF"
                        ouvrirPDF(row);
                    }
                }
            }
        });
        
        // Création du conteneur de défilement pour le tableau
        scrollPane = new JScrollPane(tableResultats);
        
        // Bouton de retour
        btnRetour = new JButton("Retour");
        btnRetour.setBackground(new Color(18, 53, 36));
        btnRetour.setForeground(new Color(239, 227, 194));
        btnRetour.setFocusable(false);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer cette fenêtre
            }
        });
        
        // Panel pour le bouton retour
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(btnRetour);
        
        // Organisation du layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);
    }

    /**
     * Charge les données des documents depuis la base de données
     */
    private void chargerDonnees() {
        // Vider la liste actuelle
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
        
        // Charger les conférences
        for (Integer id : idsConferences) {
            Conference conference = chargerConference(id);
            if (conference != null) {
                DocumentInfo info = new DocumentInfo(
                    "Conférence", 
                    conference.getId(), 
                    conference.getTitre(), 
                    conference.getResume(),
                    conference.getCheminPdf()
                );
                documentsInfo.add(info);
            }
        }
        
        // Charger les brevets
        for (Integer id : idsBrevets) {
            Brevet brevet = chargerBrevet(id);
            if (brevet != null) {
                DocumentInfo info = new DocumentInfo(
                    "Brevet", 
                    brevet.getId(), 
                    brevet.getTitre(), 
                    brevet.getDescription(),
                    brevet.getCheminPdf()
                );
                documentsInfo.add(info);
            }
        }
        
        // Charger les thèses
        for (Integer id : idsTheses) {
            These these = chargerThese(id);
            if (these != null) {
                DocumentInfo info = new DocumentInfo(
                    "Thèse", 
                    these.getId(), 
                    these.getTitre(), 
                    these.getResume(),
                    these.getCheminPdf()
                );
                documentsInfo.add(info);
            }
        }
        
        // Charger les mémoires
        for (Integer id : idsMemoires) {
            Memoire memoire = chargerMemoire(id);
            if (memoire != null) {
                DocumentInfo info = new DocumentInfo(
                    "Mémoire", 
                    memoire.getId(), 
                    memoire.getTitre(), 
                    memoire.getResume(),
                    memoire.getCheminPdf()
                );
                documentsInfo.add(info);
            }
        }
        
        // Charger les rapports
        for (Integer id : idsRapports) {
            RapportRecherche rapport = chargerRapport(id);
            if (rapport != null) {
                DocumentInfo info = new DocumentInfo(
                    "Rapport", 
                    rapport.getId(), 
                    rapport.getTitre(), 
                    rapport.getResume(),
                    rapport.getCheminPdf()
                );
                documentsInfo.add(info);
            }
        }
        
        // Remplir le tableau avec les données chargées
        remplirTableau();
    }
    
    /**
     * Remplit le tableau avec les données des documents
     */
    private void remplirTableau() {
        // Effacer les données actuelles du tableau
        tableModel.setRowCount(0);
        
        // Ajouter chaque document au tableau
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
     * Affiche les détails d'un document
     */
    private void afficherDetails(int row) {
        if (row >= 0 && row < documentsInfo.size()) {
            DocumentInfo doc = documentsInfo.get(row);
            
            // À implémenter selon les besoins
            // Pour l'instant, affichons juste une boîte de dialogue
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
     * Ouvre le PDF associé à un document
     */
    private void ouvrirPDF(int row) {
        if (row >= 0 && row < documentsInfo.size()) {
            DocumentInfo doc = documentsInfo.get(row);
            String cheminPdf = doc.getCheminPdf();
            
            if (cheminPdf != null && !cheminPdf.isEmpty()) {
                try {
                    File pdfFile = new File(cheminPdf);
                    if (pdfFile.exists()) {
                        // Ouvrir le PDF dans le navigateur par défaut
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
     * Méthodes pour charger les entités depuis la base de données
     * Ces méthodes devraient être implémentées avec JPA/Hibernate
     */
    
    
    
    
    
    
    private Article chargerArticle(Integer id) {
    Article article = null;
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {
        // Create EntityManagerFactory directly (specify your persistence unit name)
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();

        // Retrieve the article from the database
        article = em.find(Article.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement de l'article (ID: " + id + "): " + e.getMessage());
    } finally {
        // Close resources
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    return article;
    }
    
    
    
    
    
    
    private Conference chargerConference(Integer id) {
    Conference conference = null;
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
        conference = em.find(Conference.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement de la conférence (ID: " + id + "): " + e.getMessage());
    } finally {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    return conference;
}

    
    
    private Brevet chargerBrevet(Integer id) {
    Brevet brevet = null;
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
        brevet = em.find(Brevet.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement du brevet (ID: " + id + "): " + e.getMessage());
    } finally {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    return brevet;
}

    
    
    
    

    
    
    
    private These chargerThese(Integer id) {
    These these = null;
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
        these = em.find(These.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement de la thèse (ID: " + id + "): " + e.getMessage());
    } finally {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    return these;
}

    
    
    
    
    private Memoire chargerMemoire(Integer id) {
    Memoire memoire = null;
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
        memoire = em.find(Memoire.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement du mémoire (ID: " + id + "): " + e.getMessage());
    } finally {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    return memoire;
}

    
    
    
    
    
    private RapportRecherche chargerRapport(Integer id) {
    RapportRecherche rapport = null;
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
        rapport = em.find(RapportRecherche.class, id);
    } catch (Exception e) {
        System.err.println("Erreur lors du chargement du rapport (ID: " + id + "): " + e.getMessage());
    } finally {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    return rapport;
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Classe interne pour stocker les informations des documents
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
    
    /**
     * Méthode main pour tester la vue (à supprimer en production)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Données de test
            Utilisateur user = new Utilisateur();
            List<Integer> articles = new ArrayList<>();
            articles.add(7);
            List<Integer> conferences = new ArrayList<>();
            conferences.add(7);
            List<Integer> brevets = new ArrayList<>();
            List<Integer> theses = new ArrayList<>();
            List<Integer> memoires = new ArrayList<>();
            List<Integer> rapports = new ArrayList<>();
            
            ResultatsRechercheView view = new ResultatsRechercheView(
                user, articles, conferences, brevets, theses, memoires, rapports);
            view.setVisible(true);
        });
    }
}