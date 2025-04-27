-- Création de la base
CREATE DATABASE IF NOT EXISTS gestion_articles;
USE gestion_articles;

-- Table utilisateurs
CREATE TABLE utilisateurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom_complet VARCHAR(255) NOT NULL,
    login VARCHAR(100) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role ENUM('admin', 'utilisateur') NOT NULL
);

-- Table professeurs
CREATE TABLE professeurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom_complet VARCHAR(255) NOT NULL
);

-- Table journaux
CREATE TABLE journaux (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

-- Table articles
CREATE TABLE articles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    resume TEXT,
    upload_par INT,
    date_publication DATE,
    chemin_pdf VARCHAR(500),
    FOREIGN KEY (upload_par) REFERENCES utilisateurs(id)
);

-- Table de liaison article_professeur (relation Many-to-Many)
CREATE TABLE article_professeur (
    id_article INT,
    id_professeur INT,
    PRIMARY KEY (id_article, id_professeur),
    FOREIGN KEY (id_article) REFERENCES articles(id) ON DELETE CASCADE,
    FOREIGN KEY (id_professeur) REFERENCES professeurs(id) ON DELETE CASCADE
);

-- Table de liaison article_journal (relation Many-to-Many)
CREATE TABLE article_journal (
    id_article INT,
    id_journal INT,
    PRIMARY KEY (id_article, id_journal),
    FOREIGN KEY (id_article) REFERENCES articles(id) ON DELETE CASCADE,
    FOREIGN KEY (id_journal) REFERENCES journaux(id) ON DELETE CASCADE
);
