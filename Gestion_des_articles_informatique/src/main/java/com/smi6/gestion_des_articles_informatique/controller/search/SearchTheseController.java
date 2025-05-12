package com.smi6.gestion_des_articles_informatique.controller.search;

import com.smi6.gestion_des_articles_informatique.model.These;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class SearchTheseController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public List<These> searchTheses(String encadrants, String etudiant, String date1Str, String date2Str, String keyword) throws Exception {
        EntityManager em = emf.createEntityManager();

        try {
            StringBuilder jpql = new StringBuilder("SELECT t FROM These t WHERE 1=1");
            Map<String, Object> params = new HashMap<>();

            // 🔍 Encadrants (multiple professors)
            if (encadrants != null && !encadrants.trim().isEmpty()) {
                List<String> encadrantNames = parseNames(encadrants); // Parse the input into a list of names
                jpql.append(" AND LOWER(t.directeur.nomComplet) IN :encadrants");
                params.put("encadrants", encadrantNames);
            }

            // 🔍 Étudiant
            if (etudiant != null && !etudiant.trim().isEmpty()) {
                jpql.append(" AND LOWER(t.etudiant) LIKE :etudiant");
                params.put("etudiant", "%" + etudiant.trim().toLowerCase() + "%");
            }

            // 🔍 Mots-clés (titre ou résumé)
            if (keyword != null && !keyword.trim().isEmpty()) {
                jpql.append(" AND (LOWER(t.titre) LIKE :kw OR LOWER(t.resume) LIKE :kw)");
                params.put("kw", "%" + keyword.trim().toLowerCase() + "%");
            }

            // 🔍 Dates
            Date date1 = parseDate(date1Str);
            Date date2 = parseDate(date2Str);

            if (date1 != null && date2 != null) {
                jpql.append(" AND t.dateSoutenance BETWEEN :d1 AND :d2");
                params.put("d1", date1);
                params.put("d2", date2);
            } else if (date1 != null) {
                jpql.append(" AND t.dateSoutenance >= :d1");
                params.put("d1", date1);
            } else if (date2 != null) {
                jpql.append(" AND t.dateSoutenance <= :d2");
                params.put("d2", date2);
            }

            TypedQuery<These> query = em.createQuery(jpql.toString(), These.class);
            params.forEach(query::setParameter);

            return query.getResultList();
        } finally {
//            em.close();
        }
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

    private Date parseDate(String dateStr) throws Exception {
        if (dateStr == null || dateStr.trim().isEmpty()) return null;
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr.trim());
        } catch (Exception e) {
            throw new Exception("Date invalide : " + dateStr + " (format attendu : jj/MM/aaaa)");
        }
    }
}
