package com.smi6.gestion_des_articles_informatique.view.users;

import javax.swing.*;
import com.smi6.gestion_des_articles_informatique.controller.users.UserController;
import com.smi6.gestion_des_articles_informatique.model.Utilisateur;

public class ModifyUserDialog extends JDialog {

    private JTextField usernameField, roleField;
    private JButton modifyButton;
    private int userId;

    public ModifyUserDialog(JFrame parent, int userId) {
        super(parent, "Modify User", true);
        this.userId = userId;
        setSize(300, 200);
        setLocationRelativeTo(parent);

        // Retrieve user data and populate fields
        UserController controller = new UserController();
        Utilisateur user = controller.getUserById(userId);
        usernameField = new JTextField(user.getNomComplet(), 20);
        roleField = new JTextField(user.getRole().name(), 20);
        modifyButton = new JButton("Modify User");

        modifyButton.addActionListener(e -> onModifyUser());

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nom Complet:"));
        add(usernameField);
        add(new JLabel("Role:"));
        add(roleField);
        add(modifyButton);
    }

    private void onModifyUser() {
        String nomComplet = usernameField.getText().trim();
        String role = roleField.getText().trim();

        if (nomComplet.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Modify the user in the database
        UserController controller = new UserController();
        controller.modifyUser(userId, nomComplet, Utilisateur.Role.valueOf(role));
        dispose();  // Close dialog
    }
}
