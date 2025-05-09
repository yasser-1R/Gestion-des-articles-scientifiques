package com.smi6.gestion_des_articles_informatique.view.users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import com.smi6.gestion_des_articles_informatique.controller.users.UserController;

public class UsersView extends JFrame {
    private JTable usersTable;
    private UserController userController;

    public UsersView() {
        userController = new UserController();
        setTitle("Users Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the UI components
        usersTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(usersTable);

        // Create Buttons
        JButton addButton = new JButton("Add User");
        JButton modifyButton = new JButton("Modify User");
        JButton deleteButton = new JButton("Delete User");

        // Add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load users from the database into the table
        loadUsersTable();

        // Button actions
        addButton.addActionListener(this::onAddUser);
        modifyButton.addActionListener(this::onModifyUser);
        deleteButton.addActionListener(this::onDeleteUser);
    }

    void loadUsersTable() {
        // Load data into the table
        usersTable.setModel(userController.getUserTableModel());
    }

    private void onAddUser(ActionEvent e) {
        // Open a dialog or new frame for adding a user
        new AddUserDialog(this).setVisible(true);
    }

    private void onModifyUser(ActionEvent e) {
        // Get selected user
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow != -1) {
            int userId = (int) usersTable.getValueAt(selectedRow, 0);
            new ModifyUserDialog(this, userId).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to modify.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onDeleteUser(ActionEvent e) {
        // Get selected user
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow != -1) {
            int userId = (int) usersTable.getValueAt(selectedRow, 0);
            userController.deleteUser(userId);
            loadUsersTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UsersView().setVisible(true);
        });
    }
}
