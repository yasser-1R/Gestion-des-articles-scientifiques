package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String resume;

    @ManyToOne
    @JoinColumn(name = "upload_par")
    private Utilisateur uploadPar;

    @Column(name = "date_publication")
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @Column(name = "chemin_pdf")
    private String cheminPdf;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleProfesseur> auteurs;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleJournal> journaux;

    public Article() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Utilisateur getUploadPar() {
        return uploadPar;
    }

    public void setUploadPar(Utilisateur uploadPar) {
        this.uploadPar = uploadPar;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getCheminPdf() {
        return cheminPdf;
    }

    public void setCheminPdf(String cheminPdf) {
        this.cheminPdf = cheminPdf;
    }

    public List<ArticleProfesseur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<ArticleProfesseur> auteurs) {
        this.auteurs = auteurs;
    }

    public List<ArticleJournal> getJournaux() {
        return journaux;
    }

    public void setJournaux(List<ArticleJournal> journaux) {
        this.journaux = journaux;
    }
}
