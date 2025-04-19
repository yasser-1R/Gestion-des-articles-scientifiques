CREATE DATABASE GESTION_DES_ARTICLES;
USE GESTION_DES_ARTICLES;

-- TABLE DÉPARTEMENTS
CREATE TABLE departement (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) UNIQUE
);

-- TABLE ÉTUDIANTS
CREATE TABLE etudiant (
    cin VARCHAR(20) PRIMARY KEY,
    cne VARCHAR(20) UNIQUE,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    mot_de_passe VARCHAR(255),
    filiere VARCHAR(100),
    id_departement INT,
    FOREIGN KEY (id_departement) REFERENCES departement(id)
);

-- TABLE PROFESSEURS
CREATE TABLE professeur (
    cin VARCHAR(20) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    mot_de_passe VARCHAR(255),
    id_departement INT,
    FOREIGN KEY (id_departement) REFERENCES departement(id)
);

-- TABLE ADMINS
CREATE TABLE admin (
    cin VARCHAR(20) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    mot_de_passe VARCHAR(255)
);

-- TABLE ARTICLES (le contenu est un PDF)
CREATE TABLE article (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(255),
    mots_cles VARCHAR(255),
    chemin_pdf VARCHAR(255),
    id_departement INT,
    date_publication VARCHAR(12),
    FOREIGN KEY (id_departement) REFERENCES departement(id)
);

-- TABLE DE LIAISON : publication ( étudiant <-> article <-> professeur)
CREATE TABLE publication (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_article INT,
    cin_etudiant VARCHAR(20),
    cin_professeur VARCHAR(20),
    filiere_etudiant VARCHAR(100),
    date_publication VARCHAR(12),

    FOREIGN KEY (id_article) REFERENCES article(id),
    FOREIGN KEY (cin_etudiant) REFERENCES etudiant(cin),
    FOREIGN KEY (cin_professeur) REFERENCES professeur(cin)

);
