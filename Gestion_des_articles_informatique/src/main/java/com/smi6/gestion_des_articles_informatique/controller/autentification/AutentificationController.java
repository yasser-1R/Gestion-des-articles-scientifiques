package com.smi6.gestion_des_articles_informatique.controller.autentification;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;

public class AutentificationController {

    // Variable for managing database connection
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    // Method to authenticate and return the user object
    public Utilisateur authenticate(String login, String password) {
        EntityManager em = emf.createEntityManager();

        Utilisateur user = null; // default value if authentication fails

        try {
            // Prepare the query to find a user with matching login and password
            TypedQuery<Utilisateur> query = em.createQuery(
                "SELECT u FROM Utilisateur u WHERE u.login = :login AND u.motDePasse = :password", Utilisateur.class);
            query.setParameter("login", login);
            query.setParameter("password", password);

            // Execute the query and get the user
            user = query.getSingleResult();
        } catch (Exception e) {
            // If no user found or error occurs, user remains null
            user = null;
        } finally {
            em.close();
        }

        return user; // Return the user object if found, or null if failed
    }
}