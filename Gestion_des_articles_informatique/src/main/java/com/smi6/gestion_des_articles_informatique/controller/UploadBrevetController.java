package com.smi6.gestion_des_articles_informatique.controller;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UploadBrevetController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void uploadBrevet(
            Utilisateur user,
            String titre,
            String description,
            String statut,
            String inventeursString,
            String dateDepotString,
            File selectedPdfFile
    ) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. Créer le brevet
            Brevet brevet = new Brevet();
            brevet.setTitre(titre);
            brevet.setDescription(description);
            brevet.setStatut(statut);
            brevet.setUploadPar(user);
            brevet.setDateDepot(parseDate(dateDepotString));

            // 2. Lier les inventeurs (professeurs) existants
            List<Professeur> inventeurs = getExistingProfesseurs(em, inventeursString);
            brevet.setInventeurs(inventeurs);

            // 3. Enregistrer le brevet
            em.persist(brevet);
            em.flush(); // pour obtenir l’ID

            // 4. Gérer le fichier PDF
            if (selectedPdfFile != null) {
                Path cheminPdf = savePdfFile(brevet.getId(), selectedPdfFile);
                brevet.setCheminPdf(cheminPdf.toString());
                em.merge(brevet);
            }

            em.getTransaction().commit();
            System.out.println("✅ Brevet enregistré avec succès.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erreur lors de l'enregistrement du brevet : " + e.getMessage(), e);
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
            throw new Exception("Format de date invalide. Utilisez : jj/MM/aaaa (ex. : 15/06/2025).");
        }
    }

    // 💾 Sauvegarde du fichier PDF dans un dossier local
    private Path savePdfFile(int brevetId, File originalFile) throws IOException {
        String folderPath = "pdfs";
        Files.createDirectories(Paths.get(folderPath));

        String fileName = "brevet" + brevetId + ".pdf";
        Path destination = Paths.get(folderPath, fileName);

        Files.copy(originalFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }
}
