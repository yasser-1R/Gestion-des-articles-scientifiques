package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rapports_recherche")
public class RapportRecherche {

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

    @ManyToMany
    @JoinTable(
        name = "rapport_professeur",
        joinColumns = @JoinColumn(name = "id_rapport"),
        inverseJoinColumns = @JoinColumn(name = "id_professeur")
    )
    private List<Professeur> auteurs = new ArrayList<>();

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

    public List<Professeur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<Professeur> auteurs) {
        this.auteurs = auteurs;
    }
}