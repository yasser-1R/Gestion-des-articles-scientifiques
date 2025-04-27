package com.smi6.gestion_des_articles_informatique.controller;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UploadController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void uploadArticle(Long userId, String titre, String resume, String auteursString, String journauxString, String dateString, File selectedPdfFile, String quartile) throws Exception
 {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. Create new Article
            Article article = new Article();
            article.setTitre(titre);
            article.setResume(resume);

            Utilisateur user = em.find(Utilisateur.class, userId);
            article.setUploadPar(user);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date datePublication = formatter.parse(dateString);
            article.setDatePublication(datePublication);

            // Save Article first (without chemin_pdf)
            em.persist(article);
            em.flush(); // Force save to get ID

            // 2. Copy the PDF file
            if (selectedPdfFile != null) {
                String folderPath = "pdfs";
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                String newPdfName = "article" + article.getId() + ".pdf";
                Path destination = new File(folder, newPdfName).toPath();

                Files.copy(selectedPdfFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

                article.setCheminPdf(destination.toString());
                em.merge(article); // Update article with chemin_pdf
            }

            // 3. Link Auteurs
            String[] auteursArray = auteursString.split(",");
            for (String auteurNom : auteursArray) {
                auteurNom = auteurNom.trim();
                if (!auteurNom.isEmpty()) {
                    Professeur prof = findOrCreateProfesseur(em, auteurNom);
                    ArticleProfesseur link = new ArticleProfesseur(article, prof);
                    em.persist(link);
                }
            }

            // 4. Link Journaux
            String[] journauxArray = journauxString.split(",");
            for (String journalNom : journauxArray) {
                journalNom = journalNom.trim();
                if (!journalNom.isEmpty()) {
                    Journal journal = findOrCreateJournal(em, journalNom);
                    ArticleJournal link = new ArticleJournal(article, journal);
                    em.persist(link);
                }
            }

            em.getTransaction().commit();
            System.out.println("✅ Article enregistré avec succès!");

        } catch (Exception e) {
    em.getTransaction().rollback();
    throw new Exception("Erreur lors de l'enregistrement: " + e.getMessage(), e);
} finally {
            em.close();
        }
    }

    private Professeur findOrCreateProfesseur(EntityManager em, String nomComplet) {
List<Professeur> result = em.createQuery(
    "FROM Professeur WHERE LOWER(nomComplet) = :name", Professeur.class)
    .setParameter("name", nomComplet.toLowerCase())
    .getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            Professeur prof = new Professeur();
            prof.setNomComplet(nomComplet);
            em.persist(prof);
            em.flush();
            return prof;
        }
    }

    private Journal findOrCreateJournal(EntityManager em, String nom) {
List<Journal> result = em.createQuery(
    "FROM Journal WHERE LOWER(nom) = :name", Journal.class)
    .setParameter("name", nom.toLowerCase())
    .getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            Journal journal = new Journal();
            journal.setNom(nom);
            em.persist(journal);
            em.flush();
            return journal;
        }
    }
}