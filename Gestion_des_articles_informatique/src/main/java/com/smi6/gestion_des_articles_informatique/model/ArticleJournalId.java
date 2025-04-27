package com.smi6.gestion_des_articles_informatique.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArticleJournalId implements Serializable {

    private Long idArticle;
    private Long idJournal;

    public ArticleJournalId() {}

    public ArticleJournalId(Long idArticle, Long idJournal) {
        this.idArticle = idArticle;
        this.idJournal = idJournal;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Long getIdJournal() {
        return idJournal;
    }

    public void setIdJournal(Long idJournal) {
        this.idJournal = idJournal;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleJournalId)) return false;
        ArticleJournalId that = (ArticleJournalId) o;
        return Objects.equals(idArticle, that.idArticle) && Objects.equals(idJournal, that.idJournal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle, idJournal);
    }
}
