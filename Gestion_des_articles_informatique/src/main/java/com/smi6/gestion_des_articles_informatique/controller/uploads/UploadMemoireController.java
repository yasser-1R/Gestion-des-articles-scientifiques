package com.smi6.gestion_des_articles_informatique.controller.uploads;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UploadMemoireController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void uploadMemoire(
            Utilisateur user,
            String titre,
            String resume,
            String etudiant,
            String directeurNom,
            String dateSoutenanceString,
            File selectedPdfFile
    ) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // 1. Créer le mémoire
            Memoire memoire = new Memoire();
            memoire.setTitre(titre);
            memoire.setResume(resume);
            memoire.setEtudiant(etudiant);
            memoire.setUploadPar(user);
            memoire.setDateSoutenance(parseDate(dateSoutenanceString));

            // 2. Chercher le directeur existant
            Professeur directeur = getExistingProfesseur(em, directeurNom);
            memoire.setDirecteur(directeur);

            // 3. Enregistrer le mémoire
            em.persist(memoire);
            em.flush();

            // 4. Gérer le fichier PDF
            if (selectedPdfFile != null) {
                Path cheminPdf = savePdfFile(memoire.getId(), selectedPdfFile);
                memoire.setCheminPdf(cheminPdf.toString());
                em.merge(memoire);
            }

            em.getTransaction().commit();
            System.out.println("✅ Mémoire enregistré avec succès.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erreur lors de l'enregistrement du mémoire : " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    // 🔍 Vérifie que le directeur existe
    private Professeur getExistingProfesseur(EntityManager em, String nomComplet) throws Exception {
        String nomTrim = nomComplet.trim().toLowerCase();
        return em.createQuery(
                "FROM Professeur WHERE LOWER(nomComplet) = :name", Professeur.class)
                .setParameter("name", nomTrim)
                .getResultStream()
                .findFirst()
                .orElseThrow(() -> new Exception("❌ Directeur introuvable : " + nomComplet));
    }

    // 📅 Convertit une date "dd/MM/yyyy" en objet `Date`
    private Date parseDate(String dateString) throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (Exception e) {
            throw new Exception("Format de date invalide. Utilisez : jj/MM/aaaa (ex. : 20/07/2025).");
        }
    }

    // 💾 Sauvegarde le fichier PDF du mémoire
    private Path savePdfFile(int memoireId, File originalFile) throws IOException {
        String folderPath = "pdfs";
        Files.createDirectories(Paths.get(folderPath));

        String fileName = "memoire" + memoireId + ".pdf";
        Path destination = Paths.get(folderPath, fileName);

        Files.copy(originalFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }
}
