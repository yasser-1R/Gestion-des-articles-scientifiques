
package com.smi6.gestion_des_articles_informatique.controller.autentification;
import com.smi6.gestion_des_articles_informatique.model.Article;
import com.smi6.gestion_des_articles_informatique.model.Professeur;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
public class Profile {
     public Profile(){}
    private  EntityManager em;
    
    
   
    public Profile(EntityManager em){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        this.em = emf.createEntityManager();
     }
    //Recupereration les informations du professeur 
   
     public Utilisateur getProfile (int idUtilisateur){
           return em.find(Utilisateur.class,idUtilisateur);
       }
     
     
     //Modifier le mots de passe 
     public void changerMotDePasse(int idUtilisateur, String ancienMdp, String nouveauMdp, String confirmationMdp) throws Exception {
        Utilisateur util = em.find(Utilisateur.class, idUtilisateur);

        if (!util.getMotDePasse().equals(ancienMdp)) {
            throw new Exception("Ancien mot de passe incorrect.");
        }

        if (!nouveauMdp.equals(confirmationMdp)) {
            throw new Exception("Le nouveau mot de passe et la confirmation ne correspondent pas.");
        }

        util.setMotDePasse(nouveauMdp);

        em.getTransaction().begin();
        em.merge(util);
        em.getTransaction().commit();
    }
}
