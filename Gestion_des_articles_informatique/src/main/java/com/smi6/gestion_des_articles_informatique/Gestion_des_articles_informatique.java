/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.smi6.gestion_des_articles_informatique;
import com.smi6.gestion_des_articles_informatique.view.*;
import com.smi6.gestion_des_articles_informatique.model.*;
import jakarta.persistence.*;
/**
 *
 * @author YN
 */
public class Gestion_des_articles_informatique {

    public static void main(String[] args) {
        
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Just instantiate one of each to force Hibernate to create tables
        Article article = new Article();
        article.setTitre("Test Article");
        em.persist(article);

        Conference conf = new Conference();
        conf.setTitre("Test Conference");
        em.persist(conf);

        These these = new These();
        these.setTitre("Test Thèse");
        em.persist(these);

        Memoire memoire = new Memoire();
        memoire.setTitre("Test Mémoire");
        em.persist(memoire);

        Brevet brevet = new Brevet();
        brevet.setTitre("Test Brevet");
        em.persist(brevet);

        RapportRecherche rapport = new RapportRecherche();
        rapport.setTitre("Test Rapport");
        em.persist(rapport);

        Journal journal = new Journal();
        journal.setNom("Test Journal");
        journal.setQuartile("Q1");
        em.persist(journal);

        Professeur prof = new Professeur();
        prof.setNomComplet("Prof Test");
        em.persist(prof);

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("Tables created and test data persisted successfully.");
    }}
        
        
//        Connexion2 T = new Connexion2();
//        T.setVisible(true);
//
//         // 1. Create EntityManagerFactory
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        
//        try {
//            emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // Name must match your persistence.xml
//            em = emf.createEntityManager();
//            System.out.println("✅ Hibernate and Database connection SUCCESS!");
//
//            // 2. Start a transaction
//            em.getTransaction().begin();
//
//            // 3. Create a new Utilisateur
//            Utilisateur user = new Utilisateur();
//            user.setNomComplet("Test Admin");
//            user.setLogin("admin");
//            user.setMotDePasse("1234");
//            user.setRole(Utilisateur.Role.admin);
//
//            // 4. Save it in the database
//            em.persist(user);
//
//            // 5. Commit the transaction
//            em.getTransaction().commit();
//            System.out.println("✅ User inserted successfully!");
//
//            // 6. Read back from database
//            Utilisateur foundUser = em.find(Utilisateur.class, user.getId());
//            if (foundUser != null) {
//                System.out.println("🔎 Found User: " + foundUser.getNomComplet() + ", Role: " + foundUser.getRole());
//            } else {
//                System.out.println("❌ User not found");
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ ERROR: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (em != null) em.close();
//            if (emf != null) emf.close();
//        }
