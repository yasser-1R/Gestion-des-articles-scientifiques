package com.smi6.gestion_des_articles_informatique.controller.uploads;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UploadTheseController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void uploadThese(
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

            // 1. Créer la thèse
            These these = new These();
            these.setTitre(titre);
            these.setResume(resume);
            these.setEtudiant(etudiant);
            these.setUploadPar(user);
            these.setDateSoutenance(parseDate(dateSoutenanceString));

            // 2. Chercher le directeur existant
            Professeur directeur = getExistingProfesseur(em, directeurNom);
            these.setDirecteur(directeur);

            // 3. Enregistrer la thèse
            em.persist(these);
            em.flush(); // pour avoir l'ID

            // 4. Gérer le fichier PDF
            if (selectedPdfFile != null) {
                Path cheminPdf = savePdfFile(these.getId(), selectedPdfFile);
                these.setCheminPdf(cheminPdf.toString());
                em.merge(these);
            }

            em.getTransaction().commit();
            System.out.println("✅ Thèse enregistrée avec succès.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erreur lors de l'enregistrement de la thèse : " + e.getMessage(), e);
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

    // 📅 Conversion de "dd/MM/yyyy" en Date
    private Date parseDate(String dateString) throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (Exception e) {
            throw new Exception("Format de date invalide. Utilisez : jj/MM/aaaa (ex. : 10/06/2025).");
        }
    }

    // 💾 Sauvegarde du fichier PDF
    private Path savePdfFile(int theseId, File originalFile) throws IOException {
        String folderPath = "pdfs";
        Files.createDirectories(Paths.get(folderPath));

        String fileName = "these" + theseId + ".pdf";
        Path destination = Paths.get(folderPath, fileName);

        Files.copy(originalFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination;
    }
}
