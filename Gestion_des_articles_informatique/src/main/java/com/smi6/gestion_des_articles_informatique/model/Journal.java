package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "journaux")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "quartile")
    private String quartile; // Q1, Q2, Q3, Q4

    @ManyToMany(mappedBy = "journaux")
    private List<Article> articles = new ArrayList<>();

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuartile() {
        return quartile;
    }

    public void setQuartile(String quartile) {
        this.quartile = quartile;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
