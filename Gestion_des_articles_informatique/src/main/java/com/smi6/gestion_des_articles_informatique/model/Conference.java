package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "conferences")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String resume;

    @Column(name = "chemin_pdf", length = 500)
    private String cheminPdf;

    @Column(name = "date_conference")
    @Temporal(TemporalType.DATE)
    private Date dateConference;

    @Column(name = "lieu")
    private String lieu;

    
    @ManyToOne
@JoinColumn(name = "upload_par")
private Utilisateur uploadPar;

    
    
    
    @ManyToMany
    @JoinTable(
        name = "conference_professeur",
        joinColumns = @JoinColumn(name = "id_conference"),
        inverseJoinColumns = @JoinColumn(name = "id_professeur")
    )
    private List<Professeur> professeurs = new ArrayList<>();

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

    public Date getDateConference() {
        return dateConference;
    }

    public void setDateConference(Date dateConference) {
        this.dateConference = dateConference;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public Utilisateur getUploadPar() {
        return uploadPar;
    }

    public void setUploadPar(Utilisateur uploadPar) {
        this.uploadPar = uploadPar;
    }
    
    
    
}