
package com.gestion_des_articles.model;

public class Article {
    private int id;
    private String titre;
    private String motsCles;
    private String cheminPdf;
    private int idDepartement;
    private String datePublication;

    public Article() {}

    public Article(int id, String titre, String motsCles, String cheminPdf, int idDepartement, String datePublication) {
        this.id = id;
        this.titre = titre;
        this.motsCles = motsCles;
        this.cheminPdf = cheminPdf;
        this.idDepartement = idDepartement;
        this.datePublication = datePublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getCheminPdf() {
        return cheminPdf;
    }

    public void setCheminPdf(String cheminPdf) {
        this.cheminPdf = cheminPdf;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
}
