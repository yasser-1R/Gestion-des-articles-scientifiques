package com.smi6.gestion_des_articles_informatique.view.users;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;

public class UserTableModel extends AbstractTableModel {

    private List<Utilisateur> users;
    private final String[] columnNames = {"ID", "Nom Complet", "Login", "Role"};

    public UserTableModel(List<Utilisateur> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utilisateur user = users.get(rowIndex);
        switch (columnIndex) {
            case 0: return user.getId();  // ID
            case 1: return user.getNomComplet();  // Nom Complet
            case 2: return user.getLogin();  // Login
            case 3: return user.getRole();  // Role
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
        fireTableDataChanged();
    }
}
