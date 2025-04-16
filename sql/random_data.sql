USE GESTION_DES_ARTICLES;

-- Départements
INSERT INTO departement (nom) VALUES 
('Informatique'),
('Mathématiques'),
('Physique');

-- Étudiants
INSERT INTO etudiant (cin, cne, nom, prenom, email, mot_de_passe, filiere, id_departement) VALUES
('EE123456', 'CNE001', 'Bouzid', 'Yassine', 'yassine.bouzid@univ.ma', 'pass123', 'Génie Logiciel', 1),
('EE654321', 'CNE002', 'El Idrissi', 'Sara', 'sara.idrissi@univ.ma', 'sara2024', 'Systèmes Embarqués', 1),
('MM987654', 'CNE003', 'Mouhsine', 'Walid', 'walid.mouhsine@univ.ma', 'walidpwd', 'Analyse Mathématique', 2);

-- Professeurs
INSERT INTO professeur (cin, nom, prenom, email, mot_de_passe, id_departement) VALUES
('P12345', 'Bensalem', 'Karim', 'karim.bensalem@univ.ma', 'prof123', 1),
('P67890', 'Ouahbi', 'Nadia', 'nadia.ouahbi@univ.ma', 'mathpass', 2);

-- Admins
INSERT INTO admin (cin, nom, prenom, email, mot_de_passe) VALUES
('A99999', 'El Ghazali', 'Imane', 'imane.ghazali@univ.ma', 'adminroot');

-- Articles (PDF fictifs)
INSERT INTO article (titre, mots_cles, chemin_pdf, id_departement, date_publication) VALUES
('Systèmes multi-agents pour la robotique', 'robotique, multi-agents, IA', 'pdfs/article1.pdf', 1, '2025-04-01'),
('Analyse des séries temporelles climatiques', 'climat, analyse, séries temporelles', 'pdfs/article2.pdf', 2, '2025-04-02'),
('Optimisation dans les réseaux neuronaux', 'deep learning, optimisation', 'pdfs/article3.pdf', 1, '2025-04-03');

-- Publications (liens entre étudiants, articles, profs)
INSERT INTO publication (id_article, cin_etudiant, cin_professeur, filiere_etudiant, date_publication) VALUES
(1, 'EE123456', 'P12345', 'Génie Logiciel', '2025-04-01'),
(2, 'MM987654', 'P67890', 'Analyse Mathématique', '2025-04-02'),
(3, 'EE654321', 'P12345', 'Systèmes Embarqués', '2025-04-03');
