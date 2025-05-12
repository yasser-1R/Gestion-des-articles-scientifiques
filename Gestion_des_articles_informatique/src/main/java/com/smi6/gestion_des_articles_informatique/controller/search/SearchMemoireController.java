package com.smi6.gestion_des_articles_informatique.controller.search;

import com.smi6.gestion_des_articles_informatique.model.Memoire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchMemoireController {

    public List<Memoire> searchMemoires(String encadrants, String etudiant, String date1, String date2, String keyword) throws Exception {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Memoire> results = new ArrayList<>();

        try {
            emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            em = emf.createEntityManager();

            StringBuilder query = new StringBuilder("SELECT m FROM Memoire m WHERE 1=1");

            // Search by multiple encadrants (supervisors)
            if (encadrants != null && !encadrants.trim().isEmpty()) {
                List<String> encadrantNames = parseNames(encadrants); // Parse input into a list of names
                query.append(" AND LOWER(m.directeur.nomComplet) IN :encadrants");
            }

            if (etudiant != null && !etudiant.trim().isEmpty()) {
                query.append(" AND LOWER(m.etudiant) LIKE :etudiant");
            }
            if (date1 != null && !date1.trim().isEmpty() && date2 != null && !date2.trim().isEmpty()) {
                query.append(" AND m.dateSoutenance BETWEEN :date1 AND :date2");
            }
            if (keyword != null && !keyword.trim().isEmpty()) {
                query.append(" AND (LOWER(m.titre) LIKE :keyword OR LOWER(m.resume) LIKE :keyword)");
            }

            var q = em.createQuery(query.toString(), Memoire.class);

            // Set parameters for encadrants (multiple supervisors)
            if (encadrants != null && !encadrants.trim().isEmpty()) {
                List<String> encadrantNames = parseNames(encadrants);
                q.setParameter("encadrants", encadrantNames);
            }
            if (etudiant != null && !etudiant.trim().isEmpty()) {
                q.setParameter("etudiant", "%" + etudiant.trim().toLowerCase() + "%");
            }
            if (date1 != null && !date1.trim().isEmpty() && date2 != null && !date2.trim().isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date d1 = sdf.parse(date1.trim());
                Date d2 = sdf.parse(date2.trim());
                q.setParameter("date1", d1);
                q.setParameter("date2", d2);
            }
            if (keyword != null && !keyword.trim().isEmpty()) {
                q.setParameter("keyword", "%" + keyword.trim().toLowerCase() + "%");
            }

            results = q.getResultList();

        } catch (Exception e) {
            throw new Exception("Erreur lors de la recherche des mémoires : " + e.getMessage(), e);
        } finally {
//            if (em != null) em.close();
//            if (emf != null) emf.close();
        }

        return results;
    }

    // Method to parse the input into a list of names
    private List<String> parseNames(String input) {
        List<String> names = new ArrayList<>();
        for (String name : input.split(",")) {
            String trimmed = name.trim().toLowerCase();
            if (!trimmed.isEmpty()) {
                names.add(trimmed);
            }
        }
        return names;
    }
}
