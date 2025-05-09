package com.smi6.gestion_des_articles_informatique.controller.search;

import com.smi6.gestion_des_articles_informatique.model.Brevet;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class SearchBrevetController {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public List<Brevet> searchBrevets(
            String inventeursString,
            String statut,
            String date1String,
            String date2String,
            String keyword
    ) throws Exception {

        EntityManager em = emf.createEntityManager();

        try {
            StringBuilder jpql = new StringBuilder("SELECT DISTINCT b FROM Brevet b LEFT JOIN b.inventeurs p WHERE 1=1");
            Map<String, Object> params = new HashMap<>();

            // 🔍 Mots-clés (titre ou description)
            if (keyword != null && !keyword.trim().isEmpty()) {
                jpql.append(" AND (LOWER(b.titre) LIKE :kw OR LOWER(b.description) LIKE :kw)");
                params.put("kw", "%" + keyword.toLowerCase() + "%");
            }

            // 🔍 Inventeurs
            if (inventeursString != null && !inventeursString.trim().isEmpty()) {
                List<String> noms = parseNames(inventeursString);
                jpql.append(" AND LOWER(p.nomComplet) IN :inventeurs");
                params.put("inventeurs", noms);
            }

            // 🔍 Statut
            if (statut != null && !statut.trim().isEmpty()) {
                jpql.append(" AND LOWER(b.statut) LIKE :statut");
                params.put("statut", "%" + statut.toLowerCase() + "%");
            }

            // 🔍 Dates de dépôt
            Date date1 = parseDate(date1String);
            Date date2 = parseDate(date2String);

            if (date1 != null && date2 != null) {
                jpql.append(" AND b.dateDepot BETWEEN :d1 AND :d2");
                params.put("d1", date1);
                params.put("d2", date2);
            } else if (date1 != null) {
                jpql.append(" AND b.dateDepot >= :d1");
                params.put("d1", date1);
            } else if (date2 != null) {
                jpql.append(" AND b.dateDepot <= :d2");
                params.put("d2", date2);
            }

            TypedQuery<Brevet> query = em.createQuery(jpql.toString(), Brevet.class);
            params.forEach(query::setParameter);

            return query.getResultList();

        } finally {
//            em.close();
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
