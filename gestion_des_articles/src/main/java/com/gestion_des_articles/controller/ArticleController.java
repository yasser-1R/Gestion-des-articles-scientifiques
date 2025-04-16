
package com.gestion_des_articles.controller;

import com.gestion_des_articles.dao.ArticleDAO;
import com.gestion_des_articles.model.Article;
import com.gestion_des_articles.view.ArticleSearchView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ArticleController {
    private ArticleSearchView view;
    private ArticleDAO dao;

    public ArticleController(ArticleSearchView view, Connection connection) {
        this.view = view;
        this.dao = new ArticleDAO(connection);

        this.view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(view.getIdField().getText());
                    Article article = dao.findById(id);
                    if (article != null) {
                        view.setTitre(article.getTitre());
                        view.setMotsCles(article.getMotsCles());
                    } else {
                        JOptionPane.showMessageDialog(view, "Aucun article trouvé !");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "ID invalide !");
                }
            }
        });
    }
}
