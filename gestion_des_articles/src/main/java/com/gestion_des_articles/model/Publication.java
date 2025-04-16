
package com.gestion_des_articles.model;

public class Publication {
    private int id;
    private int idArticle;
    private String cinEtudiant;
    private String cinProfesseur;
    private String filiereEtudiant;
    private String datePublication;

    public Publication() {}

    public Publication(int id, int idArticle, String cinEtudiant, String cinProfesseur, String filiereEtudiant, String datePublication) {
        this.id = id;
        this.idArticle = idArticle;
        this.cinEtudiant = cinEtudiant;
        this.cinProfesseur = cinProfesseur;
        this.filiereEtudiant = filiereEtudiant;
        this.datePublication = datePublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getCinEtudiant() {
        return cinEtudiant;
    }

    public void setCinEtudiant(String cinEtudiant) {
        this.cinEtudiant = cinEtudiant;
    }

    public String getCinProfesseur() {
        return cinProfesseur;
    }

    public void setCinProfesseur(String cinProfesseur) {
        this.cinProfesseur = cinProfesseur;
    }

    public String getFiliereEtudiant() {
        return filiereEtudiant;
    }

    public void setFiliereEtudiant(String filiereEtudiant) {
        this.filiereEtudiant = filiereEtudiant;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
}
