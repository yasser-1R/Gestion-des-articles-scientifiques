
package com.gestion_des_articles.dao;

import com.gestion_des_articles.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAO {
    private Connection connection;

    public ArticleDAO(Connection connection) {
        this.connection = connection;
    }

    public Article findById(int id) {
        String sql = "SELECT * FROM article WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Article(
                    rs.getInt("id"),
                    rs.getString("titre"),
                    rs.getString("mots_cles"),
                    rs.getString("chemin_pdf"),
                    rs.getInt("id_departement"),
                    rs.getString("date_publication")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
