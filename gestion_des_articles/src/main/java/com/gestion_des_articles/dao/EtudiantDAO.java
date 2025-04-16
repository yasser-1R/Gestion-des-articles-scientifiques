
package com.gestion_des_articles.dao;

import com.gestion_des_articles.model.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtudiantDAO {
    private Connection connection;

    public EtudiantDAO(Connection connection) {
        this.connection = connection;
    }

    public Etudiant login(String email, String password) {
        String sql = "SELECT * FROM etudiant WHERE email = ? AND mot_de_passe = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Etudiant(
                    rs.getString("cin"),
                    rs.getString("cne"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    rs.getString("filiere"),
                    rs.getInt("id_departement")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
