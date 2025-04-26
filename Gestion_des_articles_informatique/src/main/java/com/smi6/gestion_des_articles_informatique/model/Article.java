package com.smi6.gestion_des_articles_informatique.model;

import java.sql.Date;

public class Article {
    private int id;
    private String title;
    private String authors;
    private String journals;
    private String quartile;
    private Date publicationDate;   // ✅ correct type
    private String pdfPath;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getJournals() {
        return journals;
    }
    public void setJournals(String journals) {
        this.journals = journals;
    }

    public String getQuartile() {
        return quartile;
    }
    public void setQuartile(String quartile) {
        this.quartile = quartile;
    }

    public Date getPublicationDate() {  // ✅ returns java.sql.Date
        return publicationDate;
    }
    public void setPublicationDate(Date publicationDate) {  // ✅ setter accepts java.sql.Date
        this.publicationDate = publicationDate;
    }

    public String getPdfPath() {
        return pdfPath;
    }
    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }
}
