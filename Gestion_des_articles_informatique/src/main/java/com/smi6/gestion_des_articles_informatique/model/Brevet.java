package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brevets")
public class Brevet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "chemin_pdf", length = 500)
    private String cheminPdf;

    @Column(name = "date_depot")
    @Temporal(TemporalType.DATE)
    private Date dateDepot;

    @Column(name = "statut")
    private String statut;

    @ManyToMany
    @JoinTable(
        name = "brevet_professeur",
        joinColumns = @JoinColumn(name = "id_brevet"),
        inverseJoinColumns = @JoinColumn(name = "id_professeur")
    )
    private List<Professeur> inventeurs = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCheminPdf() {
        return cheminPdf;
    }

    public void setCheminPdf(String cheminPdf) {
        this.cheminPdf = cheminPdf;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<Professeur> getInventeurs() {
        return inventeurs;
    }

    public void setInventeurs(List<Professeur> inventeurs) {
        this.inventeurs = inventeurs;
    }
}