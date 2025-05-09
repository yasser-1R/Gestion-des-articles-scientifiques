package com.smi6.gestion_des_articles_informatique.view.users;

import javax.swing.*;
import com.smi6.gestion_des_articles_informatique.controller.users.UserController;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;

public class AddUserDialog extends JDialog {

    private JTextField usernameField, roleField;
    private JButton addButton;

    public AddUserDialog(JFrame parent) {
        super(parent, "Add New User", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        usernameField = new JTextField(20);
        roleField = new JTextField(20);
        addButton = new JButton("Add User");

        addButton.addActionListener(e -> onAddUser());

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nom Complet:"));
        add(usernameField);
        add(new JLabel("Role:"));
        add(roleField);
        add(addButton);
    }

    private void onAddUser() {
        String nomComplet = usernameField.getText().trim();
        String role = roleField.getText().trim();

        if (nomComplet.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add the user to the database
        UserController controller = new UserController();
        controller.addUser(nomComplet, Utilisateur.Role.valueOf(role));
        ((UsersView) getOwner()).loadUsersTable();  // Refresh users table
        dispose();  // Close dialog
    }
}
