package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;

@Entity
@Table(name = "article_professeur")
public class ArticleProfesseur {

    @EmbeddedId
    private ArticleProfesseurId id;

    @ManyToOne
    @MapsId("idArticle")
    @JoinColumn(name = "id_article")
    private Article article;

    @ManyToOne
    @MapsId("idProfesseur")
    @JoinColumn(name = "id_professeur")
    private Professeur professeur;

    public ArticleProfesseur() {}

    public ArticleProfesseur(Article article, Professeur professeur) {
        this.article = article;
        this.professeur = professeur;
        this.id = new ArticleProfesseurId(article.getId(), professeur.getId());
    }

    // Getters and Setters

    public ArticleProfesseurId getId() {
        return id;
    }

    public void setId(ArticleProfesseurId id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
