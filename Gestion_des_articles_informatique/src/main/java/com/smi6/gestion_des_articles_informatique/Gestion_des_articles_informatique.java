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
        Connexion2 T = new Connexion2();
        T.setVisible(true);
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
    }
}
