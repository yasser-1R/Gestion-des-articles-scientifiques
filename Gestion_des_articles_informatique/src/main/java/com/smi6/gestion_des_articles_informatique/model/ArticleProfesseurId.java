package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArticleProfesseurId implements Serializable {

    private Long idArticle;
    private Long idProfesseur;

    public ArticleProfesseurId() {}

    public ArticleProfesseurId(Long idArticle, Long idProfesseur) {
        this.idArticle = idArticle;
        this.idProfesseur = idProfesseur;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Long getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Long idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleProfesseurId)) return false;
        ArticleProfesseurId that = (ArticleProfesseurId) o;
        return Objects.equals(idArticle, that.idArticle) && Objects.equals(idProfesseur, that.idProfesseur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle, idProfesseur);
    }
}
