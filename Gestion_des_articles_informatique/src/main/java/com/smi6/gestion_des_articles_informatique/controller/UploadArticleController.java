package com.smi6.gestion_des_articles_informatique.controller;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UploadArticleController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void uploadArticle(
            Utilisateur user,
            String titre,
            String resume,
            String auteursString,
            String journauxString,
            String dateString,
            File selectedPdfFile
    ) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. Créer l'article
            Article article = new Article();
            article.setTitre(titre);
            article.setResume(resume);
            article.setUploadPar(user);
            article.setDatePublication(parseDate(dateString));

            // 2. Lier les auteurs existants
            List<Professeur> professeurs = getExistingProfesseurs(em, auteursString);
            article.setProfesseurs(professeurs);

            // 3. Lier les journaux existants
            List<Journal> journaux = getExistingJournaux(em, journauxString);
            article.setJournaux(journaux);

            // 4. Enregistrer l'article
            em.persist(article);
            em.flush(); // obtenir l'ID

            // 5. Gérer le fichier PDF
            if (selectedPdfFile != null) {
                Path cheminPdf = savePdfFile(article.getId(), selectedPdfFile);
                article.setCheminPdf(cheminPdf.toString());
                em.merge(article);
            }

            em.getTransaction().commit();
            System.out.println("✅ Article enregistré avec succès.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erreur lors de l'enregistrement de l'article : " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // 🔍 Recherche de professeurs existants uniquement
    private List<Professeur> getExistingProfesseurs(EntityManager em, String noms) throws Exception {
        List<Professeur> professeurs = new ArrayList<>();
        for (String nom : noms.split(",")) {
            String nomTrim = nom.trim().toLowerCase();
            if (!nomTrim.isEmpty()) {
                Professeur prof = em.createQuery(
                        "FROM Professeur WHERE LOWER(nomComplet) = :name", Professeur.class)
                        .setParameter("name", nomTrim)
                        .getResultStream()
                        .findFirst()
                        .orElseThrow(() -> new Exception("❌ Professeur introuvable : " + nomTrim));
                professeurs.add(prof);
            }
        }
        return professeurs;
    }

    // 🔍 Recherche de journaux existants uniquement
    private List<Journal> getExistingJournaux(EntityManager em, String noms) throws Exception {
        List<Journal> journaux = new ArrayList<>();
        for (String nom : noms.split(",")) {
            String nomTrim = nom.trim().toLowerCase();
            if (!nomTrim.isEmpty()) {
                Journal journal = em.createQuery(
                        "FROM Journal WHERE LOWER(nom) = :name", Journal.class)
                        .setParameter("name", nomTrim)
                        .getResultStream()
                        .findFirst()
                        .orElseThrow(() -> new Exception("❌ Journal introuvable : " + nomTrim));
                journaux.add(journal);
            }
        }
        return journaux;
    }

    // 📅 Conversion de chaîne "dd/MM/yyyy" en Date
    private Date parseDate(String dateString) throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (Exception e) {
            throw new Exception("Format de date invalide. Utilisez : jj/MM/aaaa (ex. : 02/05/2025).");
        }
    }

    // 💾 Sauvegarde du fichier PDF dans un dossier local
    private Path savePdfFile(int articleId, File originalFile) throws IOException {
        String folderPath = "pdfs";
        Files.createDirectories(Paths.get(folderPath));

        String fileName = "article" + articleId + ".pdf";
        Path destination = Paths.get(folderPath, fileName);

        Files.copy(originalFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }
}
