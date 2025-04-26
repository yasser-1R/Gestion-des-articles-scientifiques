package com.smi6.gestion_des_articles_informatique.dao;

import com.smi6.gestion_des_articles_informatique.model.Article;
import com.smi6.gestion_des_articles_informatique.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ArticleDAO {

    public int insertArticle(Article article) {
        int generatedId = -1; // Default if insert fails
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO articles (title, authors, journals, quartile, publication_date, pdf_path) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, article.getTitle());
            pstmt.setString(2, article.getAuthors());
            pstmt.setString(3, article.getJournals());
            pstmt.setString(4, article.getQuartile());
            pstmt.setDate(5, article.getPublicationDate());
            pstmt.setString(6, article.getPdfPath());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return generatedId;
    }
    
    
    public boolean updatePdfPath(int articleId, String pdfPath) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        conn = DBConnection.getConnection();
        String sql = "UPDATE articles SET pdf_path = ? WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, pdfPath);
        pstmt.setInt(2, articleId);
        int rowsUpdated = pstmt.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}

}
