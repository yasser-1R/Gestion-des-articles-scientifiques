package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "memoires")
public class Memoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String resume;

    @Column(name = "chemin_pdf", length = 500)
    private String cheminPdf;

    @Column(name = "date_soutenance")
    @Temporal(TemporalType.DATE)
    private Date dateSoutenance;

    private String etudiant;

    @ManyToOne
    @JoinColumn(name = "id_directeur") // FK vers professeur.id
    private Professeur directeur;

    
    
    @ManyToOne
@JoinColumn(name = "upload_par")
private Utilisateur uploadPar;

    
    
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

    public Date getDateSoutenance() {
        return dateSoutenance;
    }

    public void setDateSoutenance(Date dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }

    public String getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(String etudiant) {
        this.etudiant = etudiant;
    }

    public Professeur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Professeur directeur) {
        this.directeur = directeur;
    }

    public Utilisateur getUploadPar() {
        return uploadPar;
    }

    public void setUploadPar(Utilisateur uploadPar) {
        this.uploadPar = uploadPar;
    }
    
    
    
    
}
