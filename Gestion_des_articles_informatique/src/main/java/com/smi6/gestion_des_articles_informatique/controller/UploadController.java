package com.smi6.gestion_des_articles_informatique.controller;

import com.smi6.gestion_des_articles_informatique.dao.ArticleDAO;
import com.smi6.gestion_des_articles_informatique.model.Article;
import com.smi6.gestion_des_articles_informatique.view.Upload3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UploadController {

    private Upload3 view;
    private File selectedPdfFile; // Temporary storage for the selected PDF

    public UploadController(Upload3 view) {
        this.view = view;
    }

    public void setSelectedPdfFile(File file) {
        this.selectedPdfFile = file;
    }

public void publierArticle() {
    String title = view.getTitleField().getText().trim();
    if (title.isEmpty()) {
        view.showError("Le titre est obligatoire.");
        return;
    }

    StringBuilder authorsBuilder = new StringBuilder();
    boolean hasAuthor = false;
    for (var field : view.getAuthorFields()) {
        if (field.isVisible() && !field.getText().trim().isEmpty()) {
            if (hasAuthor) authorsBuilder.append(", ");
            authorsBuilder.append(field.getText().trim());
            hasAuthor = true;
        }
    }
    if (!hasAuthor) {
        view.showError("Au moins un auteur doit être renseigné.");
        return;
    }

    StringBuilder journalsBuilder = new StringBuilder();
    boolean hasJournal = false;
    for (var field : view.getJournalFields()) {
        if (field.isVisible() && !field.getText().trim().isEmpty()) {
            if (hasJournal) journalsBuilder.append(", ");
            journalsBuilder.append(field.getText().trim());
            hasJournal = true;
        }
    }
    if (!hasJournal) {
        view.showError("Au moins un journal doit être renseigné.");
        return;
    }

    String selectedQuartile = view.getQuartileComboBox().getSelectedItem().toString();

    String dateText = view.getPublicationDateField().getText().trim();
    if (dateText.isEmpty()) {
        view.showError("La date de publication est obligatoire.");
        return;
    }

    java.sql.Date sqlDate;
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = sdf.parse(dateText);
        sqlDate = new java.sql.Date(utilDate.getTime());
    } catch (ParseException e) {
        view.showError("Format de date incorrect. Exemple : 26/04/2025");
        return;
    }

    if (selectedPdfFile == null) {
        view.showError("Veuillez sélectionner un fichier PDF.");
        return;
    }

    // 2. Save to database
    Article article = new Article();
    article.setTitle(title);
    article.setAuthors(authorsBuilder.toString());
    article.setJournals(journalsBuilder.toString());
    article.setQuartile(selectedQuartile);
    article.setPublicationDate(sqlDate);
    article.setPdfPath(""); // Temporary at first

    ArticleDAO dao = new ArticleDAO();
    int newId = dao.insertArticle(article);

    if (newId == -1) {
        view.showError("Erreur lors de l'insertion de l'article en base de données.");
        return;
    }

    // 3. Move and rename the PDF
    try {
        String projectFolder = System.getProperty("user.dir") + "/pdfs/";
        File destinationFolder = new File(projectFolder);
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        String newFileName = "Article" + newId + "PDF.pdf";
        File newPdfFile = new File(destinationFolder, newFileName);

        Files.copy(selectedPdfFile.toPath(), newPdfFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // After copying: update pdf_path
        article.setPdfPath(newFileName);
        dao.updatePdfPath(newId, article.getPdfPath());

    } catch (IOException e) {
        e.printStackTrace();
        view.showError("Erreur lors de la sauvegarde du fichier PDF.");
        return;
    }

    // 4. Clear the form
    clearFields();
    view.showMessage("Article publié avec succès !");
}

    
    
    
    
    
    
    
    
    
    
    
    
    private void updatePdfPath(int articleId, String pdfPath) {
    try (Connection conn = com.smi6.gestion_des_articles_informatique.util.DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement("UPDATE articles SET pdf_path = ? WHERE id = ?")) {
        
        pstmt.setString(1, pdfPath);
        pstmt.setInt(2, articleId);
        pstmt.executeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
        view.showError("Erreur lors de la mise à jour du chemin du fichier PDF.");
    }
}

    
    
    private void clearFields() {
    view.getTitleField().setText("");

    for (var field : view.getAuthorFields()) {
        field.setText("");
        field.setVisible(false);
    }
    if (!view.getAuthorFields().isEmpty()) {
        view.getAuthorFields().get(0).setVisible(true); // Toujours laisser A1 visible
    }

    for (var field : view.getJournalFields()) {
        field.setText("");
        field.setVisible(false);
    }
    if (!view.getJournalFields().isEmpty()) {
        view.getJournalFields().get(0).setVisible(true); // Toujours laisser J1 visible
    }

    view.getPublicationDateField().setText("");
    view.getQuartileComboBox().setSelectedIndex(0); // Revenir sur "Aucun"
    view.setPdfFileLabel("Sélectionner un fichier");
    selectedPdfFile = null;
}

    
    
    
  
}
