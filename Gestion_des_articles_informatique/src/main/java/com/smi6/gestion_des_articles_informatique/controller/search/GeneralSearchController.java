package com.smi6.gestion_des_articles_informatique.controller.search;

import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GeneralSearchController {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    
    /**
     * 🔍 Recherche globale dans toutes les tables de publications
     * 
     * @param searchText Texte à rechercher dans titre et résumé/description (peut être null)
     * @param professors Liste des professeurs pour filtrer (peut être vide)
     * @param startDateStr Date de début format dd/MM/yyyy (peut être null)
     * @param endDateStr Date de fin format dd/MM/yyyy (peut être null)
     * @return Map contenant les listes de chaque type de publication
     */
    public Map<String, List<?>> search(String searchText, List<Professeur> professors, 
                                      String startDateStr, String endDateStr) throws Exception {
        
        EntityManager em = emf.createEntityManager();
        
        try {
            // 📅 Conversion des dates
            Date startDate = parseDate(startDateStr);
            Date endDate = parseDate(endDateStr);
            
            Map<String, List<?>> results = new HashMap<>();
            
            // 📚 Recherche dans chaque type de publication
            results.put("articles", searchArticles(em, searchText, professors, startDate, endDate));
            results.put("theses", searchTheses(em, searchText, professors, startDate, endDate));
            results.put("memoires", searchMemoires(em, searchText, professors, startDate, endDate));
            results.put("brevets", searchBrevets(em, searchText, professors, startDate, endDate));
            results.put("conferences", searchConferences(em, searchText, professors, startDate, endDate));
            results.put("rapports", searchRapports(em, searchText, professors, startDate, endDate));
            
            System.out.println("✅ Recherche effectuée avec succès.");
            return results;
            
        } catch (Exception e) {
            throw new Exception("❌ Erreur lors de la recherche : " + e.getMessage(), e);
        } finally {
//            em.close();
        }
    }
    
    // 📅 Conversion de chaîne "dd/MM/yyyy" en Date
    private Date parseDate(String dateString) throws Exception {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (Exception e) {
            throw new Exception("Format de date invalide. Utilisez : jj/MM/aaaa (ex. : 02/05/2025).");
        }
    }
    
    // 📝 RECHERCHE ARTICLES
    private List<Article> searchArticles(EntityManager em, String searchText, List<Professeur> professors, 
                                       Date startDate, Date endDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Article> query = cb.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 🔍 Condition de recherche textuelle
        if (searchText != null && !searchText.trim().isEmpty()) {
            String likePattern = "%" + searchText.toLowerCase() + "%";
            Predicate titlePredicate = cb.like(cb.lower(root.get("titre")), likePattern);
            Predicate resumePredicate = cb.like(cb.lower(root.get("resume")), likePattern);
            predicates.add(cb.or(titlePredicate, resumePredicate));
        }
        
        // 👨‍🏫 Filtre par professeurs
        if (professors != null && !professors.isEmpty()) {
            Join<Article, Professeur> profJoin = root.join("professeurs");
            predicates.add(profJoin.in(professors));
        }
        
        // 📅 Filtre par plage de dates
        if (startDate != null && endDate != null) {
            predicates.add(cb.between(root.get("datePublication"), startDate, endDate));
        } else if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("datePublication"), startDate));
        } else if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("datePublication"), endDate));
        }
        
        // 🔄 Combinaison des conditions
        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }
        
        TypedQuery<Article> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
    
    // 📝 RECHERCHE THÈSES
    private List<These> searchTheses(EntityManager em, String searchText, List<Professeur> professors, 
                                   Date startDate, Date endDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<These> query = cb.createQuery(These.class);
        Root<These> root = query.from(These.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 🔍 Condition de recherche textuelle
        if (searchText != null && !searchText.trim().isEmpty()) {
            String likePattern = "%" + searchText.toLowerCase() + "%";
            Predicate titlePredicate = cb.like(cb.lower(root.get("titre")), likePattern);
            Predicate resumePredicate = cb.like(cb.lower(root.get("resume")), likePattern);
            predicates.add(cb.or(titlePredicate, resumePredicate));
        }
        
        // 👨‍🏫 Filtre par professeurs
        if (professors != null && !professors.isEmpty()) {
            Join<These, Professeur> directorJoin = root.join("directeur");
            predicates.add(directorJoin.in(professors));
        }
        
        // 📅 Filtre par plage de dates
        if (startDate != null && endDate != null) {
            predicates.add(cb.between(root.get("dateSoutenance"), startDate, endDate));
        } else if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dateSoutenance"), startDate));
        } else if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dateSoutenance"), endDate));
        }
        
        // 🔄 Combinaison des conditions
        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }
        
        TypedQuery<These> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
    
    // 📝 RECHERCHE MÉMOIRES
    private List<Memoire> searchMemoires(EntityManager em, String searchText, List<Professeur> professors, 
                                      Date startDate, Date endDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Memoire> query = cb.createQuery(Memoire.class);
        Root<Memoire> root = query.from(Memoire.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 🔍 Condition de recherche textuelle
        if (searchText != null && !searchText.trim().isEmpty()) {
            String likePattern = "%" + searchText.toLowerCase() + "%";
            Predicate titlePredicate = cb.like(cb.lower(root.get("titre")), likePattern);
            Predicate resumePredicate = cb.like(cb.lower(root.get("resume")), likePattern);
            predicates.add(cb.or(titlePredicate, resumePredicate));
        }
        
        // 👨‍🏫 Filtre par professeurs
        if (professors != null && !professors.isEmpty()) {
            Join<Memoire, Professeur> directorJoin = root.join("directeur");
            predicates.add(directorJoin.in(professors));
        }
        
        // 📅 Filtre par plage de dates
        if (startDate != null && endDate != null) {
            predicates.add(cb.between(root.get("dateSoutenance"), startDate, endDate));
        } else if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dateSoutenance"), startDate));
        } else if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dateSoutenance"), endDate));
        }
        
        // 🔄 Combinaison des conditions
        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }
        
        TypedQuery<Memoire> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
    
    // 📝 RECHERCHE BREVETS
    private List<Brevet> searchBrevets(EntityManager em, String searchText, List<Professeur> professors, 
                                     Date startDate, Date endDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Brevet> query = cb.createQuery(Brevet.class);
        Root<Brevet> root = query.from(Brevet.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 🔍 Condition de recherche textuelle
        if (searchText != null && !searchText.trim().isEmpty()) {
            String likePattern = "%" + searchText.toLowerCase() + "%";
            Predicate titlePredicate = cb.like(cb.lower(root.get("titre")), likePattern);
            Predicate descriptionPredicate = cb.like(cb.lower(root.get("description")), likePattern);
            predicates.add(cb.or(titlePredicate, descriptionPredicate));
        }
        
        // 👨‍🏫 Filtre par professeurs
        if (professors != null && !professors.isEmpty()) {
            Join<Brevet, Professeur> profJoin = root.join("inventeurs");
            predicates.add(profJoin.in(professors));
        }
        
        // 📅 Filtre par plage de dates
        if (startDate != null && endDate != null) {
            predicates.add(cb.between(root.get("dateDepot"), startDate, endDate));
        } else if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dateDepot"), startDate));
        } else if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dateDepot"), endDate));
        }
        
        // 🔄 Combinaison des conditions
        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }
        
        TypedQuery<Brevet> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
    
    // 📝 RECHERCHE CONFÉRENCES
    private List<Conference> searchConferences(EntityManager em, String searchText, List<Professeur> professors, 
                                            Date startDate, Date endDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Conference> query = cb.createQuery(Conference.class);
        Root<Conference> root = query.from(Conference.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 🔍 Condition de recherche textuelle
        if (searchText != null && !searchText.trim().isEmpty()) {
            String likePattern = "%" + searchText.toLowerCase() + "%";
            Predicate titlePredicate = cb.like(cb.lower(root.get("titre")), likePattern);
            Predicate resumePredicate = cb.like(cb.lower(root.get("resume")), likePattern);
            predicates.add(cb.or(titlePredicate, resumePredicate));
        }
        
        // 👨‍🏫 Filtre par professeurs
        if (professors != null && !professors.isEmpty()) {
            Join<Conference, Professeur> profJoin = root.join("professeurs");
            predicates.add(profJoin.in(professors));
        }
        
        // 📅 Filtre par plage de dates
        if (startDate != null && endDate != null) {
            predicates.add(cb.between(root.get("dateConference"), startDate, endDate));
        } else if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dateConference"), startDate));
        } else if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dateConference"), endDate));
        }
        
        // 🔄 Combinaison des conditions
        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }
        
        TypedQuery<Conference> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
    
    // 📝 RECHERCHE RAPPORTS
    private List<RapportRecherche> searchRapports(EntityManager em, String searchText, List<Professeur> professors, 
                                               Date startDate, Date endDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RapportRecherche> query = cb.createQuery(RapportRecherche.class);
        Root<RapportRecherche> root = query.from(RapportRecherche.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        // 🔍 Condition de recherche textuelle
        if (searchText != null && !searchText.trim().isEmpty()) {
            String likePattern = "%" + searchText.toLowerCase() + "%";
            Predicate titlePredicate = cb.like(cb.lower(root.get("titre")), likePattern);
            Predicate resumePredicate = cb.like(cb.lower(root.get("resume")), likePattern);
            predicates.add(cb.or(titlePredicate, resumePredicate));
        }
        
        // 👨‍🏫 Filtre par professeurs
        if (professors != null && !professors.isEmpty()) {
            Join<RapportRecherche, Professeur> profJoin = root.join("auteurs");
            predicates.add(profJoin.in(professors));
        }
        
        // 📅 Filtre par plage de dates
        if (startDate != null && endDate != null) {
            predicates.add(cb.between(root.get("datePublication"), startDate, endDate));
        } else if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("datePublication"), startDate));
        } else if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("datePublication"), endDate));
        }
        
        // 🔄 Combinaison des conditions
        if (!predicates.isEmpty()) {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }
        
        TypedQuery<RapportRecherche> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
}