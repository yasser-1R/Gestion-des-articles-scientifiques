package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String resume;

    @Column(name = "chemin_pdf", length = 500)
    private String cheminPdf;

    @Column(name = "date_publication")
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @Column(name = "upload_par")
    private Integer uploadPar; // You can map it to Utilisateur if you want later

    @ManyToMany
    @JoinTable(
        name = "article_professeur",
        joinColumns = @JoinColumn(name = "id_article"),
        inverseJoinColumns = @JoinColumn(name = "id_professeur")
    )
    private List<Professeur> professeurs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "article_journal",
        joinColumns = @JoinColumn(name = "id_article"),
        inverseJoinColumns = @JoinColumn(name = "id_journal")
    )
    private List<Journal> journaux = new ArrayList<>();

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCheminPdf() {
        return cheminPdf;
    }

    public void setCheminPdf(String cheminPdf) {
        this.cheminPdf = cheminPdf;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Integer getUploadPar() {
        return uploadPar;
    }

    public void setUploadPar(Integer uploadPar) {
        this.uploadPar = uploadPar;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public List<Journal> getJournaux() {
        return journaux;
    }

    public void setJournaux(List<Journal> journaux) {
        this.journaux = journaux;
    }
}
