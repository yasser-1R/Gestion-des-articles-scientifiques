/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author HP
 */
public class UtilisateurDAO {
      private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public List<Utilisateur> getAllUtilisateurs() {
        EntityManager em = emf.createEntityManager();
        List<Utilisateur> utilisateurs = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
        em.close();
        return utilisateurs;
    }
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
        em.close();
    }

    public void supprimerUtilisateur(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Utilisateur utilisateur = em.find(Utilisateur.class, id);
        if (utilisateur != null) {
            em.remove(utilisateur);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(utilisateur);
        em.getTransaction().commit();
        em.close();
    }
}
