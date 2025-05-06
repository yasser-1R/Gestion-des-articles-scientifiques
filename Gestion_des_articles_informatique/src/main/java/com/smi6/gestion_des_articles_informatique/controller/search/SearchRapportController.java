package com.smi6.gestion_des_articles_informatique.controller.search;

import com.smi6.gestion_des_articles_informatique.model.RapportRecherche;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class SearchRapportController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public List<RapportRecherche> searchRapports(
            String auteursString,
            String date1String,
            String date2String,
            String keyword
    ) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {
            StringBuilder jpql = new StringBuilder("SELECT DISTINCT r FROM RapportRecherche r LEFT JOIN r.auteurs p WHERE 1=1");
            Map<String, Object> params = new HashMap<>();

            // 🔍 Mots-clés dans titre ou résumé
            if (keyword != null && !keyword.trim().isEmpty()) {
                jpql.append(" AND (LOWER(r.titre) LIKE :kw OR LOWER(r.resume) LIKE :kw)");
                params.put("kw", "%" + keyword.toLowerCase() + "%");
            }

            // 🔍 Auteurs
            if (auteursString != null && !auteursString.trim().isEmpty()) {
                List<String> noms = parseNames(auteursString);
                jpql.append(" AND LOWER(p.nomComplet) IN :auteurs");
                params.put("auteurs", noms);
            }

            // 🔍 Dates
            Date date1 = parseDate(date1String);
            Date date2 = parseDate(date2String);

            if (date1 != null && date2 != null) {
                jpql.append(" AND r.datePublication BETWEEN :d1 AND :d2");
                params.put("d1", date1);
                params.put("d2", date2);
            } else if (date1 != null) {
                jpql.append(" AND r.datePublication >= :d1");
                params.put("d1", date1);
            } else if (date2 != null) {
                jpql.append(" AND r.datePublication <= :d2");
                params.put("d2", date2);
            }

            TypedQuery<RapportRecherche> query = em.createQuery(jpql.toString(), RapportRecherche.class);
            params.forEach(query::setParameter);

            return query.getResultList();

        } finally {
            em.close();
        }
    }

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
            throw new Exception("Date invalide : " + dateStr + ". Format attendu : jj/MM/aaaa");
        }
    }
}
