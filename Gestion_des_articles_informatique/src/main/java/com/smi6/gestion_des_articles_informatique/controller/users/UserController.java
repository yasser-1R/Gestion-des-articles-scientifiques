package com.smi6.gestion_des_articles_informatique.controller.users;

import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import com.smi6.gestion_des_articles_informatique.view.users.UserTableModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserController {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public UserController() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
    }

    public UserTableModel getUserTableModel() {
        List<Utilisateur> users = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
        return new UserTableModel(users);
    }

    public void deleteUser(int userId) {
        try {
            em.getTransaction().begin();
            Utilisateur user = em.find(Utilisateur.class, userId);
            if (user != null) {
                em.remove(user);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public Utilisateur getUserById(int userId) {
        return em.find(Utilisateur.class, userId);
    }

    public void modifyUser(int userId, String nomComplet, Utilisateur.Role role) {
        try {
            em.getTransaction().begin();
            Utilisateur user = em.find(Utilisateur.class, userId);
            if (user != null) {
                user.setNomComplet(nomComplet);
                user.setRole(role);
                em.merge(user);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void addUser(String nomComplet, Utilisateur.Role role) {
        try {
            em.getTransaction().begin();
            Utilisateur user = new Utilisateur();
            user.setNomComplet(nomComplet);
            user.setRole(role);
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
