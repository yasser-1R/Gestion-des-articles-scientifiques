package com.gestion_des_articles.model;

public class Etudiant {
    private String cin;             // Primary key (VARCHAR)
    private String cne;             // Unique identifier
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String filiere;
    private int idDepartement;      // Foreign key

    // Constructor
    public Etudiant() {
    }

    public Etudiant(String cin, String cne, String nom, String prenom, String email,
                    String motDePasse, String filiere, int idDepartement) {
        this.cin = cin;
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.filiere = filiere;
        this.idDepartement = idDepartement;
    }

    // Getters and Setters
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " (" + cne + ")";
    }
}
