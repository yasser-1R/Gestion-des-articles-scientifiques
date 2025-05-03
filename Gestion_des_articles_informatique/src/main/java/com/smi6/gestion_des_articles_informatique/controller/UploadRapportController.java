package com.smi6.gestion_des_articles_informatique.controller;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UploadRapportController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void uploadRapport(
            Utilisateur user,
            String titre,
            String resume,
            String auteursString,
            String dateString,
            File selectedPdfFile
    ) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. Créer le rapport
            RapportRecherche rapport = new RapportRecherche();
            rapport.setTitre(titre);
            rapport.setResume(resume);
            rapport.setUploadPar(user);
            rapport.setDatePublication(parseDate(dateString));

            // 2. Lier les auteurs existants
            List<Professeur> professeurs = getExistingProfesseurs(em, auteursString);
            rapport.setAuteurs(professeurs);

            // 3. Enregistrer le rapport
            em.persist(rapport);
            em.flush(); // obtenir l'ID

            // 4. Gérer le fichier PDF
            if (selectedPdfFile != null) {
                Path cheminPdf = savePdfFile(rapport.getId(), selectedPdfFile);
                rapport.setCheminPdf(cheminPdf.toString());
                em.merge(rapport);
            }

            em.getTransaction().commit();
            System.out.println("✅ Rapport de recherche enregistré avec succès.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erreur lors de l'enregistrement du rapport : " + e.getMessage(), e);
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

    // 📅 Conversion de chaîne "dd/MM/yyyy" en Date
    private Date parseDate(String dateString) throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (Exception e) {
            throw new Exception("Format de date invalide. Utilisez : jj/MM/aaaa (ex. : 02/05/2025).");
        }
    }

    // 💾 Sauvegarde du fichier PDF dans un dossier local
    private Path savePdfFile(int rapportId, File originalFile) throws IOException {
        String folderPath = "pdfs";
        Files.createDirectories(Paths.get(folderPath));

        String fileName = "rapport" + rapportId + ".pdf";
        Path destination = Paths.get(folderPath, fileName);

        Files.copy(originalFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }
}
