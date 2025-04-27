package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.*;

@Entity
@Table(name = "article_journal")
public class ArticleJournal {

    @EmbeddedId
    private ArticleJournalId id;

    @ManyToOne
    @MapsId("idArticle")
    @JoinColumn(name = "id_article")
    private Article article;

    @ManyToOne
    @MapsId("idJournal")
    @JoinColumn(name = "id_journal")
    private Journal journal;

    public ArticleJournal() {}

    public ArticleJournal(Article article, Journal journal) {
        this.article = article;
        this.journal = journal;
        this.id = new ArticleJournalId(article.getId(), journal.getId());
    }

    // Getters and Setters

    public ArticleJournalId getId() {
        return id;
    }

    public void setId(ArticleJournalId id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }
}
