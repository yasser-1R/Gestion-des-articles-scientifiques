-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2025 at 06:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_articles`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_publication` date DEFAULT NULL,
  `resume` text DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `upload_par` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `chemin_pdf`, `date_publication`, `resume`, `titre`, `upload_par`) VALUES
(7, 'pdfs\\article7.pdf', '2000-12-12', 'rrrrrrrrrrrrrrr', 'ttttttttttt', 9),
(8, 'pdfs\\article8.pdf', '2023-05-15', 'Cette étude présente une nouvelle approche pour l\'intelligence artificielle appliquée aux systèmes embarqués.', 'Intelligence Artificielle dans les Systèmes Embarqués', 9),
(9, 'pdfs\\article9.pdf', '2023-06-22', 'Analyse comparative des algorithmes de machine learning pour la détection d\'anomalies dans les réseaux.', 'Détection d\'Anomalies dans les Réseaux par Machine Learning', 11),
(10, 'pdfs\\article10.pdf', '2023-07-30', 'Présentation d\'un framework innovant pour le développement d\'applications web sécurisées.', 'Framework pour Applications Web Sécurisées', 13),
(11, 'pdfs\\article11.pdf', '2023-08-14', 'Évaluation des performances des systèmes de reconnaissance faciale dans des environnements à faible luminosité.', 'Reconnaissance Faciale en Conditions de Faible Luminosité', 9),
(12, 'pdfs\\article12.pdf', '2023-09-05', 'Étude des techniques de réduction de dimensionnalité pour l\'analyse de données massives.', 'Réduction de Dimensionnalité pour Big Data', 11),
(13, 'pdfs\\article13.pdf', '2023-10-18', 'Analyse de l\'impact des architectures de réseaux de neurones profonds sur la consommation énergétique.', 'Efficacité Énergétique des Réseaux de Neurones Profonds', 13),
(14, 'pdfs\\article14.pdf', '2023-11-27', 'Méthodes avancées pour la protection des données personnelles dans les systèmes d\'information.', 'Protection des Données Personnelles dans les SI', 9),
(15, 'pdfs\\article1.pdf', '2023-05-15', 'This paper explores recent advancements in artificial intelligence and their applications in healthcare systems.', 'AI Applications in Modern Healthcare Systems', 8),
(16, 'pdfs\\article2.pdf', '2023-07-22', 'A comprehensive review of deep learning methods for image classification and their performance comparisons.', 'Deep Learning Image Classification: A Comparative Study', 9),
(17, 'pdfs\\article3.pdf', '2023-09-10', 'This research presents a novel approach to network security using blockchain technology and smart contracts.', 'Enhancing Network Security with Blockchain Integration', 10),
(18, 'pdfs\\article4.pdf', '2023-11-05', 'Analysis of big data processing techniques for real-time applications in IoT environments.', 'Real-time Big Data Processing in IoT Ecosystems', 8),
(19, 'pdfs\\article5.pdf', '2024-01-18', 'This study investigates the effects of quantum computing on modern cryptographic systems.', 'Quantum Computing Impact on Cryptographic Systems', 9),
(20, 'pdfs\\article6.pdf', '2024-02-25', 'A new methodology for natural language processing that improves sentiment analysis accuracy.', 'Advanced NLP Techniques for Sentiment Analysis', 10),
(21, 'pdfs\\article8.pdf', '2024-03-14', 'This paper presents a survey of machine learning algorithms for autonomous vehicle navigation systems.', 'Machine Learning in Autonomous Vehicle Navigation', 8),
(22, 'pdfs\\article9.pdf', '2024-04-02', 'Research on cloud computing architectures that optimize resource allocation in distributed systems.', 'Optimized Resource Allocation in Cloud Computing', 9),
(23, 'pdfs\\article10.pdf', '2024-04-20', 'A study on cybersecurity challenges in smart city infrastructures and proposed solutions.', 'Cybersecurity Challenges in Smart City Implementations', 10),
(24, 'pdfs\\article11.pdf', '2023-06-08', 'This research explores embedded systems design for energy-efficient IoT devices.', 'Energy-Efficient Embedded Systems for IoT Applications', 8),
(25, 'pdfs\\article12.pdf', '2023-08-17', 'Analysis of software development methodologies and their impact on project success rates.', 'Impact of Development Methodologies on Project Success', 9),
(26, 'pdfs\\article13.pdf', '2023-10-23', 'This paper presents new algorithms for facial recognition with improved accuracy and reduced bias.', 'Advanced Facial Recognition Algorithms with Reduced Bias', 10),
(27, 'pdfs\\article14.pdf', '2023-12-05', 'A comprehensive study on database optimization techniques for high-transaction environments.', 'Database Optimization for High-Transaction Systems', 8),
(28, 'pdfs\\article15.pdf', '2024-01-27', 'This research investigates neural networks for medical image analysis and disease detection.', 'Neural Networks in Medical Image Analysis', 9),
(29, 'pdfs\\article16.pdf', '2024-02-12', 'An analysis of virtual reality applications in education and their learning outcomes.', 'Virtual Reality in Education: Outcomes and Efficacy', 10),
(30, 'pdfs\\article17.pdf', '2024-03-19', 'This paper explores the integration of AI in supply chain management to optimize logistics.', 'AI-Driven Supply Chain Optimization', 8),
(31, 'pdfs\\article18.pdf', '2024-03-28', 'Research on wireless sensor networks for environmental monitoring applications.', 'Wireless Sensor Networks in Environmental Monitoring', 9),
(32, 'pdfs\\article19.pdf', '2024-04-10', 'This study presents a novel approach to augmented reality for industrial maintenance.', 'Augmented Reality Systems for Industrial Maintenance', 10),
(33, 'pdfs\\article20.pdf', '2024-04-25', 'An investigation into data privacy concerns in social media platforms and proposed frameworks.', 'Data Privacy Frameworks for Social Media Platforms', 8),
(34, 'pdfs\\article21.pdf', '2024-05-01', 'This paper discusses edge computing architectures for latency-sensitive applications.', 'Edge Computing for Latency-Critical Applications', 9);

-- --------------------------------------------------------

--
-- Table structure for table `article_journal`
--

CREATE TABLE `article_journal` (
  `id_article` int(11) NOT NULL,
  `id_journal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `article_journal`
--

INSERT INTO `article_journal` (`id_article`, `id_journal`) VALUES
(7, 22),
(8, 16),
(9, 17),
(10, 18),
(11, 19),
(12, 20),
(13, 21),
(14, 24),
(1, 16),
(2, 17),
(3, 18),
(4, 16),
(5, 17),
(6, 18),
(8, 16),
(9, 17),
(10, 18),
(11, 16),
(12, 17),
(13, 18),
(14, 16),
(15, 17),
(16, 18),
(17, 16),
(18, 17),
(19, 18),
(20, 16),
(21, 17);

-- --------------------------------------------------------

--
-- Table structure for table `article_professeur`
--

CREATE TABLE `article_professeur` (
  `id_article` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `article_professeur`
--

INSERT INTO `article_professeur` (`id_article`, `id_professeur`) VALUES
(7, 22),
(7, 25),
(8, 21),
(8, 22),
(9, 22),
(9, 23),
(10, 23),
(10, 24),
(11, 24),
(11, 25),
(12, 25),
(12, 26),
(13, 26),
(13, 27),
(14, 27),
(14, 21),
(1, 21),
(1, 22),
(2, 23),
(2, 24),
(3, 25),
(3, 21),
(4, 22),
(4, 23),
(5, 24),
(5, 25),
(6, 21),
(6, 22),
(8, 23),
(8, 24),
(9, 25),
(9, 21),
(10, 22),
(10, 23),
(11, 24),
(11, 25),
(12, 21),
(12, 22),
(13, 23),
(13, 24),
(14, 25),
(14, 21),
(15, 22),
(15, 23),
(16, 24),
(16, 25),
(17, 21),
(17, 22),
(18, 23),
(18, 24),
(19, 25),
(19, 21),
(20, 22),
(20, 23),
(21, 24),
(21, 25);

-- --------------------------------------------------------

--
-- Table structure for table `brevets`
--

CREATE TABLE `brevets` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_depot` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `upload_par` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brevets`
--

INSERT INTO `brevets` (`id`, `chemin_pdf`, `date_depot`, `description`, `statut`, `titre`, `upload_par`) VALUES
(9, 'pdfs\\brevet1.pdf', '2023-03-12', 'Système innovant permettant d\'optimiser la consommation d\'énergie dans les centres de données.', 'En cours d\'examen', 'Système d\'Optimisation Énergétique pour Centres de Données', 9),
(10, 'pdfs\\brevet2.pdf', '2023-04-25', 'Méthode sécurisée pour l\'authentification biométrique multi-facteurs.', 'Accordé', 'Méthode d\'Authentification Biométrique Multi-facteurs', 11),
(11, 'pdfs\\brevet3.pdf', '2023-05-30', 'Algorithme de compression de données avec préservation de l\'intégrité pour applications médicales.', 'En cours d\'examen', 'Algorithme de Compression pour Données Médicales', 13),
(12, 'pdfs\\brevet4.pdf', '2023-06-18', 'Dispositif pour la détection automatique des cyberattaques sur les infrastructures critiques.', 'Accordé', 'Système de Détection de Cyberattaques', 9),
(13, 'pdfs\\brevet1.pdf', '2023-05-20', 'A novel encryption algorithm for secure data transmission in IoT devices.', 'Approved', 'Enhanced IoT Encryption Method', 8),
(14, 'pdfs\\brevet2.pdf', '2023-06-15', 'A machine learning system for real-time traffic pattern analysis and prediction.', 'Pending', 'ML-Based Traffic Analysis System', 9),
(15, 'pdfs\\brevet3.pdf', '2023-07-28', 'A blockchain-based system for secure electronic voting.', 'Approved', 'Secure Electronic Voting System', 10),
(16, 'pdfs\\brevet4.pdf', '2023-09-05', 'An AI-driven diagnostic tool for early detection of cardiovascular diseases.', 'Pending', 'AI Cardiovascular Diagnostic Tool', 8),
(17, 'pdfs\\brevet5.pdf', '2023-10-18', 'A quantum computing approach to optimize supply chain logistics.', 'Under Review', 'Quantum Supply Chain Optimizer', 9),
(18, 'pdfs\\brevet6.pdf', '2023-11-30', 'A smart energy management system for residential buildings using IoT sensors.', 'Approved', 'Smart Home Energy Management System', 10),
(19, 'pdfs\\brevet7.pdf', '2024-01-12', 'A neural network-based image enhancement algorithm for low-light conditions.', 'Pending', 'Low-Light Image Enhancement Algorithm', 8),
(20, 'pdfs\\brevet8.pdf', '2024-02-08', 'A secure cloud storage system with client-side encryption and distributed backup.', 'Approved', 'Secure Distributed Cloud Storage', 9),
(21, 'pdfs\\brevet9.pdf', '2024-03-22', 'An augmented reality system for remote technical assistance and maintenance.', 'Under Review', 'AR Remote Technical Assistance', 10),
(22, 'pdfs\\brevet10.pdf', '2024-04-15', 'A natural language processing algorithm for automated content summarization.', 'Pending', 'Automated Content Summarization Algorithm', 8),
(23, 'pdfs\\brevet11.pdf', '2023-06-05', 'A biometric authentication system combining facial recognition and behavioral analysis.', 'Approved', 'Multi-factor Biometric Authentication', 9),
(24, 'pdfs\\brevet12.pdf', '2023-07-19', 'A smart water management system for agricultural irrigation using IoT sensors.', 'Pending', 'Smart Agricultural Irrigation System', 10),
(25, 'pdfs\\brevet13.pdf', '2023-08-30', 'A machine learning algorithm for early detection of cybersecurity threats.', 'Under Review', 'ML-Based Threat Detection System', 8),
(26, 'pdfs\\brevet14.pdf', '2023-10-10', 'A drone-based system for environmental monitoring and pollution detection.', 'Approved', 'Drone Environmental Monitoring System', 9),
(27, 'pdfs\\brevet15.pdf', '2023-12-20', 'A virtual reality system for immersive medical training simulations.', 'Pending', 'VR Medical Training Simulator', 10),
(28, 'pdfs\\brevet16.pdf', '2024-02-02', 'A blockchain-based system for intellectual property rights management.', 'Under Review', 'Blockchain IP Rights Management', 8),
(29, 'pdfs\\brevet17.pdf', '2024-03-05', 'An AI algorithm for automated code optimization and performance enhancement.', 'Pending', 'AI Code Optimization Algorithm', 9),
(30, 'pdfs\\brevet18.pdf', '2024-03-28', 'A robotics system for automated quality control in manufacturing.', 'Approved', 'Automated QC Robotics System', 10),
(31, 'pdfs\\brevet19.pdf', '2024-04-18', 'A machine learning approach for personalized learning content delivery.', 'Under Review', 'Personalized Learning Content System', 8),
(32, 'pdfs\\brevet20.pdf', '2024-04-30', 'A system for real-time language translation using neural networks.', 'Pending', 'Neural Network Translation System', 9);

-- --------------------------------------------------------

--
-- Table structure for table `brevet_professeur`
--

CREATE TABLE `brevet_professeur` (
  `id_brevet` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brevet_professeur`
--

INSERT INTO `brevet_professeur` (`id_brevet`, `id_professeur`) VALUES
(1, 21),
(1, 22),
(2, 23),
(2, 24),
(3, 25),
(3, 21),
(4, 22),
(4, 23),
(5, 24),
(5, 25),
(6, 21),
(6, 22),
(7, 23),
(7, 24),
(8, 25),
(8, 21),
(9, 22),
(9, 23),
(10, 24),
(10, 25),
(11, 21),
(11, 22),
(12, 23),
(12, 24),
(13, 25),
(13, 21),
(14, 22),
(14, 23),
(15, 24),
(15, 25),
(16, 21),
(16, 22),
(17, 23),
(17, 24),
(18, 25),
(18, 21),
(19, 22),
(19, 23),
(20, 24),
(20, 25);

-- --------------------------------------------------------

--
-- Table structure for table `conferences`
--

CREATE TABLE `conferences` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_conference` date DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `resume` text DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `upload_par` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conferences`
--

INSERT INTO `conferences` (`id`, `chemin_pdf`, `date_conference`, `lieu`, `resume`, `titre`, `upload_par`) VALUES
(7, 'pdfs\\conference7.pdf', '2021-10-12', 'bbbbbbb', 'sefsdfsdgsdfgsdgsdg', 'conf1', 9),
(8, 'pdfs\\conference8.pdf', '2023-04-10', 'Paris, France', 'Présentation des dernières avancées en matière de cybersécurité et défense contre les menaces persistantes avancées.', 'Cybersécurité: Défis et Solutions', 9),
(9, 'pdfs\\conference9.pdf', '2023-05-22', 'Berlin, Allemagne', 'Exploration des techniques d\'apprentissage profond pour la vision par ordinateur.', 'Deep Learning pour la Vision par Ordinateur', 11),
(10, 'pdfs\\conference10.pdf', '2023-06-15', 'Barcelone, Espagne', 'Analyse des tendances futures dans le développement des interfaces homme-machine.', 'Interfaces Homme-Machine: Tendances Futures', 13),
(11, 'pdfs\\conference11.pdf', '2023-07-18', 'Tokyo, Japon', 'Présentation des applications potentielles de l\'informatique quantique dans la recherche scientifique.', 'Applications de l\'Informatique Quantique', 9),
(12, 'pdfs\\conference12.pdf', '2023-08-30', 'San Francisco, USA', 'Discussion sur l\'éthique et la gouvernance des systèmes d\'intelligence artificielle.', 'Éthique et Gouvernance en IA', 11),
(13, 'pdfs\\conference1.pdf', '2023-06-10', 'Paris, France', 'This conference focuses on recent advances in artificial intelligence and machine learning applications.', 'International Conference on AI and ML', 8),
(14, 'pdfs\\conference2.pdf', '2023-08-15', 'Berlin, Germany', 'A symposium on cybersecurity threats and defensive strategies in modern information systems.', 'Global Cybersecurity Symposium', 9),
(15, 'pdfs\\conference3.pdf', '2023-09-22', 'Tokyo, Japan', 'This conference explores innovations in quantum computing and its potential applications.', 'Quantum Computing Innovations Conference', 10),
(16, 'pdfs\\conference4.pdf', '2023-10-30', 'San Francisco, USA', 'A forum for discussing cloud computing architectures and implementation challenges.', 'Cloud Computing Architecture Forum', 8),
(17, 'pdfs\\conference5.pdf', '2023-12-05', 'Singapore', 'This conference addresses IoT developments and their integration with smart city initiatives.', 'IoT and Smart Cities Conference', 9),
(18, 'pdfs\\conference6.pdf', '2024-01-20', 'London, UK', 'A symposium on big data analytics and their business applications.', 'Big Data Analytics Symposium', 10),
(19, 'pdfs\\conference8.pdf', '2024-02-28', 'Sydney, Australia', 'This conference focuses on sustainable computing and green IT solutions.', 'Sustainable Computing Conference', 8),
(20, 'pdfs\\conference9.pdf', '2024-03-15', 'Barcelona, Spain', 'A forum for discussing mobile computing technologies and applications.', 'Mobile Computing Technologies Forum', 9),
(21, 'pdfs\\conference10.pdf', '2024-04-05', 'Toronto, Canada', 'This conference explores advancements in human-computer interaction and user experience design.', 'Human-Computer Interaction Conference', 10),
(22, 'pdfs\\conference11.pdf', '2023-07-12', 'Amsterdam, Netherlands', 'A symposium on blockchain technology and its applications in various sectors.', 'Blockchain Applications Symposium', 8),
(23, 'pdfs\\conference12.pdf', '2023-08-25', 'Seoul, South Korea', 'This conference addresses virtual and augmented reality technologies and their practical uses.', 'VR/AR Technologies Conference', 9),
(24, 'pdfs\\conference13.pdf', '2023-10-08', 'Dubai, UAE', 'A forum for discussing intelligent transportation systems and autonomous vehicles.', 'Intelligent Transportation Systems Forum', 10),
(25, 'pdfs\\conference14.pdf', '2023-11-18', 'Vienna, Austria', 'This conference focuses on data mining techniques and knowledge discovery.', 'Data Mining and Knowledge Discovery Conference', 8),
(26, 'pdfs\\conference15.pdf', '2024-01-07', 'Stockholm, Sweden', 'A symposium on natural language processing and computational linguistics.', 'NLP and Computational Linguistics Symposium', 9),
(27, 'pdfs\\conference16.pdf', '2024-02-14', 'Mumbai, India', 'This conference explores software engineering methodologies and best practices.', 'Software Engineering Methodologies Conference', 10),
(28, 'pdfs\\conference17.pdf', '2024-03-03', 'Cape Town, South Africa', 'A forum for discussing robotics and automation technologies.', 'Robotics and Automation Forum', 8),
(29, 'pdfs\\conference18.pdf', '2024-03-28', 'Moscow, Russia', 'This conference addresses network security and information assurance.', 'Network Security Conference', 9),
(30, 'pdfs\\conference19.pdf', '2024-04-12', 'Rio de Janeiro, Brazil', 'A symposium on e-learning technologies and digital education.', 'E-Learning Technologies Symposium', 10),
(31, 'pdfs\\conference20.pdf', '2024-04-28', 'Helsinki, Finland', 'This conference focuses on bioinformatics and computational biology.', 'Bioinformatics and Computational Biology Conference', 8),
(32, 'pdfs\\conference21.pdf', '2024-05-02', 'Athens, Greece', 'A forum for discussing web technologies and internet applications.', 'Web Technologies Forum', 9);

-- --------------------------------------------------------

--
-- Table structure for table `conference_professeur`
--

CREATE TABLE `conference_professeur` (
  `id_conference` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conference_professeur`
--

INSERT INTO `conference_professeur` (`id_conference`, `id_professeur`) VALUES
(7, 22),
(7, 25),
(7, 23),
(8, 21),
(8, 22),
(8, 23),
(9, 23),
(9, 24),
(9, 25),
(10, 25),
(10, 26),
(10, 27),
(11, 21),
(11, 23),
(11, 25),
(12, 22),
(12, 24),
(12, 26),
(1, 21),
(1, 22),
(2, 23),
(2, 24),
(3, 25),
(3, 21),
(4, 22),
(4, 23),
(5, 24),
(5, 25),
(6, 21),
(6, 22),
(8, 23),
(8, 24),
(9, 25),
(9, 21),
(10, 22),
(10, 23),
(11, 24),
(11, 25),
(12, 21),
(12, 22),
(13, 23),
(13, 24),
(14, 25),
(14, 21),
(15, 22),
(15, 23),
(16, 24),
(16, 25),
(17, 21),
(17, 22),
(18, 23),
(18, 24),
(19, 25),
(19, 21),
(20, 22),
(20, 23),
(21, 24),
(21, 25);

-- --------------------------------------------------------

--
-- Table structure for table `journaux`
--

CREATE TABLE `journaux` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `quartile` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `journaux`
--

INSERT INTO `journaux` (`id`, `nom`, `quartile`) VALUES
(16, 'Nature', 'Q1'),
(17, 'Science', 'Q1'),
(18, 'IEEE Transactions on Neural Networks', 'Q1'),
(19, 'Journal of Machine Learning Research', 'Q1'),
(20, 'IEEE Access', 'Q2'),
(21, 'Applied Soft Computing', 'Q2'),
(22, 'Journal of Intelligent & Fuzzy Systems', 'Q3'),
(23, 'International Journal of Computer Applications', 'Q4'),
(24, 'ACM Transactions on Information Systems', 'Q1');

-- --------------------------------------------------------

--
-- Table structure for table `memoires`
--

CREATE TABLE `memoires` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_soutenance` date DEFAULT NULL,
  `etudiant` varchar(255) DEFAULT NULL,
  `resume` text DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `id_directeur` int(11) DEFAULT NULL,
  `upload_par` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `memoires`
--

INSERT INTO `memoires` (`id`, `chemin_pdf`, `date_soutenance`, `etudiant`, `resume`, `titre`, `id_directeur`, `upload_par`) VALUES
(8, 'pdfs\\memoire8.pdf', '2024-01-12', 'etddd', 'asfasfasfsdfasd', 'memotttttt', 22, 9),
(9, 'pdfs\\memoire1.pdf', '2023-05-20', 'Layla Benali', 'This dissertation explores web security vulnerabilities and mitigation techniques for modern applications.', 'Web Security Vulnerabilities Analysis', 21, 8),
(10, 'pdfs\\memoire2.pdf', '2023-06-18', 'Mark Johnson', 'A study on the implementation of machine learning algorithms for stock market prediction.', 'ML-Based Stock Market Prediction Models', 22, 9),
(11, 'pdfs\\memoire3.pdf', '2023-07-25', 'Amina Khalid', 'This dissertation investigates mobile application security best practices and common vulnerabilities.', 'Security Best Practices for Mobile Applications', 23, 10),
(12, 'pdfs\\memoire4.pdf', '2023-08-15', 'Roberto Garcia', 'An analysis of data visualization techniques for complex data sets in business intelligence.', 'Data Visualization for Business Intelligence', 24, 8),
(13, 'pdfs\\memoire5.pdf', '2023-09-22', 'Yuki Tanaka', 'This study explores image processing algorithms for medical diagnostic applications.', 'Image Processing in Medical Diagnostics', 25, 9),
(14, 'pdfs\\memoire6.pdf', '2023-10-18', 'Aisha Mohammed', 'A comprehensive analysis of database optimization techniques for high-traffic web applications.', 'Database Optimization for Web Applications', 21, 10),
(15, 'pdfs\\memoire7.pdf', '2023-11-25', 'Daniel Müller', 'This dissertation investigates user experience design principles for mobile banking applications.', 'UX Design Principles for Mobile Banking', 22, 8),
(16, 'pdfs\\memoire9.pdf', '2023-12-15', 'Hana Kim', 'A study on natural language processing techniques for automated customer service systems.', 'NLP for Automated Customer Service', 23, 9),
(17, 'pdfs\\memoire10.pdf', '2024-01-20', 'Samuel Osei', 'This dissertation explores secure coding practices for preventing common web vulnerabilities.', 'Secure Coding for Web Application Security', 24, 10),
(18, 'pdfs\\memoire11.pdf', '2024-02-12', 'Sophia Chang', 'An analysis of cloud migration strategies for legacy enterprise systems.', 'Cloud Migration Strategies for Legacy Systems', 25, 8),
(19, 'pdfs\\memoire12.pdf', '2023-06-08', 'Karim Sidiki', 'This study investigates agile development methodologies for remote software teams.', 'Agile Methodologies for Remote Development Teams', 21, 9),
(20, 'pdfs\\memoire13.pdf', '2023-07-19', 'Nina Petrova', 'A comprehensive analysis of recommendation systems algorithms and their applications.', 'Recommendation Systems: Algorithms and Applications', 22, 10),
(21, 'pdfs\\memoire14.pdf', '2023-08-26', 'Lucas Silva', 'This dissertation explores IoT security protocols and their implementation challenges.', 'Security Protocols for IoT Implementations', 23, 8),
(22, 'pdfs\\memoire15.pdf', '2023-09-30', 'Emma Watson', 'A study on machine learning approaches for fraud detection in financial transactions.', 'ML for Financial Fraud Detection', 24, 9),
(23, 'pdfs\\memoire16.pdf', '2023-11-05', 'Hassan Al-Qahtani', 'This dissertation investigates virtual reality interface design for educational applications.', 'VR Interface Design for Education', 25, 10),
(24, 'pdfs\\memoire17.pdf', '2023-12-18', 'Julia Kovács', 'An analysis of data privacy compliance strategies for international businesses.', 'Data Privacy Compliance for Global Businesses', 21, 8),
(25, 'pdfs\\memoire18.pdf', '2024-01-28', 'Taro Yamamoto', 'This study explores blockchain application development for digital identity verification.', 'Blockchain for Digital Identity Verification', 22, 9),
(26, 'pdfs\\memoire19.pdf', '2024-02-25', 'Isabella Romano', 'A comprehensive analysis of UI/UX design patterns for e-commerce platforms.', 'UI/UX Design Patterns for E-commerce', 23, 10),
(27, 'pdfs\\memoire20.pdf', '2024-03-15', 'Andre Santos', 'This dissertation investigates network security monitoring systems and intrusion detection.', 'Network Security Monitoring and Intrusion Detection', 24, 8),
(28, 'pdfs\\memoire21.pdf', '2024-04-05', 'Mia Zhang', 'A study on microservices architecture implementation for scalable web applications.', 'Microservices for Scalable Web Applications', 25, 9);

-- --------------------------------------------------------

--
-- Table structure for table `professeurs`
--

CREATE TABLE `professeurs` (
  `id` int(11) NOT NULL,
  `nom_complet` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professeurs`
--

INSERT INTO `professeurs` (`id`, `nom_complet`) VALUES
(21, 'Yasser Rochdi'),
(22, 'Aya Elhamraoui'),
(23, 'Mohamed Daif'),
(24, 'Omar Boutkhoum'),
(25, 'Driss Abada'),
(26, 'Abdessadek Aaroud'),
(27, 'Hanan Elfaik');

-- --------------------------------------------------------

--
-- Table structure for table `rapports_recherche`
--

CREATE TABLE `rapports_recherche` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_publication` date DEFAULT NULL,
  `resume` text DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `upload_par` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rapports_recherche`
--

INSERT INTO `rapports_recherche` (`id`, `chemin_pdf`, `date_publication`, `resume`, `titre`, `upload_par`) VALUES
(8, 'pdfs\\rapport1.pdf', '2023-05-05', 'This research report investigates the current state of quantum computing and its potential impact in the next decade.', 'Future Prospects of Quantum Computing', 8),
(9, 'pdfs\\rapport2.pdf', '2023-06-12', 'An analysis of machine learning applications in financial fraud detection systems.', 'Machine Learning for Financial Fraud Detection', 9),
(10, 'pdfs\\rapport3.pdf', '2023-07-18', 'This report explores the ethical considerations in artificial intelligence development and deployment.', 'Ethical Frameworks for AI Development', 10),
(11, 'pdfs\\rapport4.pdf', '2023-08-25', 'A comprehensive study on cybersecurity threats targeting critical infrastructure systems.', 'Cybersecurity for Critical Infrastructure', 8),
(12, 'pdfs\\rapport5.pdf', '2023-09-30', 'This research investigates big data analytics techniques for healthcare applications.', 'Big Data Analytics in Healthcare', 9),
(13, 'pdfs\\rapport6.pdf', '2023-11-08', 'An analysis of blockchain technology implementation in supply chain management.', 'Blockchain in Supply Chain Management', 10),
(14, 'pdfs\\rapport7.pdf', '2023-12-15', 'This report studies the integration of IoT devices in smart city initiatives and their challenges.', 'IoT Integration in Smart Cities', 8),
(15, 'pdfs\\rapport8.pdf', '2024-01-22', 'A comprehensive analysis of natural language processing techniques for sentiment analysis.', 'NLP Techniques for Sentiment Analysis', 9),
(16, 'pdfs\\rapport9.pdf', '2024-02-18', 'This research explores cloud computing security measures and best practices.', 'Security Best Practices in Cloud Computing', 10),
(17, 'pdfs\\rapport10.pdf', '2024-03-25', 'An investigation into the use of virtual reality for remote education and training.', 'VR Applications in Remote Education', 8),
(18, 'pdfs\\rapport11.pdf', '2023-06-05', 'This report analyzes the impact of 5G technology on mobile application development.', '5G Impact on Mobile Applications', 9),
(19, 'pdfs\\rapport12.pdf', '2023-07-28', 'A study on neuromorphic computing architectures and their potential applications.', 'Neuromorphic Computing Applications', 10),
(20, 'pdfs\\rapport13.pdf', '2023-09-10', 'This research investigates data privacy regulations and their implementation challenges.', 'Data Privacy Regulatory Compliance', 8),
(21, 'pdfs\\rapport14.pdf', '2023-10-22', 'An analysis of edge computing architectures for real-time processing applications.', 'Edge Computing for Real-time Processing', 9),
(22, 'pdfs\\rapport15.pdf', '2023-12-05', 'This report studies the use of machine learning in predictive maintenance for industrial equipment.', 'ML in Industrial Predictive Maintenance', 10),
(23, 'pdfs\\rapport16.pdf', '2024-01-15', 'A comprehensive analysis of autonomous vehicle navigation systems and challenges.', 'Autonomous Vehicle Navigation Systems', 8),
(24, 'pdfs\\rapport17.pdf', '2024-02-28', 'This research explores human-computer interaction design principles for accessibility.', 'HCI Design for Accessibility', 9),
(25, 'pdfs\\rapport18.pdf', '2024-03-18', 'An investigation into sustainable computing practices and green IT initiatives.', 'Sustainable Computing Initiatives', 10),
(26, 'pdfs\\rapport19.pdf', '2024-04-12', 'This report analyzes the role of artificial intelligence in cybersecurity threat detection.', 'AI Role in Cybersecurity Defense', 8),
(27, 'pdfs\\rapport20.pdf', '2024-04-25', 'A study on the integration of augmented reality in industrial training programs.', 'AR Applications in Industrial Training', 9);

-- --------------------------------------------------------

--
-- Table structure for table `rapport_professeur`
--

CREATE TABLE `rapport_professeur` (
  `id_rapport` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rapport_professeur`
--

INSERT INTO `rapport_professeur` (`id_rapport`, `id_professeur`) VALUES
(1, 21),
(1, 22),
(2, 23),
(2, 24),
(3, 25),
(3, 21),
(4, 22),
(4, 23),
(5, 24),
(5, 25),
(6, 21),
(6, 22),
(7, 23),
(7, 24),
(8, 25),
(8, 21),
(9, 22),
(9, 23),
(10, 24),
(10, 25),
(11, 21),
(11, 22),
(12, 23),
(12, 24),
(13, 25),
(13, 21),
(14, 22),
(14, 23),
(15, 24),
(15, 25),
(16, 21),
(16, 22),
(17, 23),
(17, 24),
(18, 25),
(18, 21),
(19, 22),
(19, 23),
(20, 24),
(20, 25);

-- --------------------------------------------------------

--
-- Table structure for table `theses`
--

CREATE TABLE `theses` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_soutenance` date DEFAULT NULL,
  `etudiant` varchar(255) DEFAULT NULL,
  `resume` text DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `id_directeur` int(11) DEFAULT NULL,
  `upload_par` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `theses`
--

INSERT INTO `theses` (`id`, `chemin_pdf`, `date_soutenance`, `etudiant`, `resume`, `titre`, `id_directeur`, `upload_par`) VALUES
(7, 'pdfs\\these1.pdf', '2023-06-15', 'Mohammed Ahmed', 'This thesis explores novel deep learning architectures for medical image analysis and disease diagnosis.', 'Deep Learning Approaches for Medical Image Analysis', 21, 8),
(8, 'pdfs\\these2.pdf', '2023-07-22', 'Sofia Rodriguez', 'A comprehensive study on blockchain security protocols and their vulnerabilities.', 'Security Analysis of Blockchain Protocols', 22, 9),
(9, 'pdfs\\these3.pdf', '2023-08-30', 'Amir Khan', 'This research investigates quantum cryptography methods for secure communication systems.', 'Quantum Cryptographic Methods for Communication Security', 23, 10),
(10, 'pdfs\\these4.pdf', '2023-09-28', 'Leila Chen', 'An analysis of machine learning algorithms for natural language understanding.', 'Advanced ML Techniques for Natural Language Understanding', 24, 8),
(11, 'pdfs\\these5.pdf', '2023-10-15', 'Ahmed Hassan', 'This thesis presents new methodologies for IoT network security and threat mitigation.', 'Enhancing Security in IoT Networks', 25, 9),
(12, 'pdfs\\these6.pdf', '2023-11-20', 'Maria Gonzalez', 'A study on cloud computing resource allocation optimization using AI techniques.', 'AI-Driven Cloud Resource Allocation', 21, 10),
(13, 'pdfs\\these7.pdf', '2023-12-12', 'John Nguyen', 'This research explores human-computer interaction designs for users with disabilities.', 'Accessible HCI Design for Diverse Users', 22, 8),
(14, 'pdfs\\these8.pdf', '2024-01-25', 'Sara Ali', 'An investigation into autonomous vehicle decision-making algorithms and ethical considerations.', 'Ethical Decision-Making in Autonomous Vehicles', 23, 9),
(15, 'pdfs\\these9.pdf', '2024-02-18', 'David Park', 'This thesis examines big data analytics techniques for social media sentiment analysis.', 'Big Data Analytics for Social Media Sentiment', 24, 10),
(16, 'pdfs\\these10.pdf', '2024-03-22', 'Fatima El Mansouri', 'A comprehensive study on cybersecurity risk assessment methodologies for critical infrastructure.', 'Cybersecurity Risk Assessment for Critical Systems', 25, 8),
(17, 'pdfs\\these11.pdf', '2023-07-05', 'Carlos Mendez', 'This research investigates neural network optimization techniques for edge computing devices.', 'Neural Network Optimization for Edge Devices', 21, 9),
(18, 'pdfs\\these12.pdf', '2023-08-15', 'Priya Sharma', 'An analysis of virtual reality technologies for immersive educational experiences.', 'Immersive Learning through Virtual Reality', 22, 10),
(19, 'pdfs\\these13.pdf', '2023-09-18', 'Omar Al-Farsi', 'This thesis explores blockchain applications for supply chain transparency and traceability.', 'Blockchain for Supply Chain Transparency', 23, 8),
(20, 'pdfs\\these14.pdf', '2023-10-28', 'Liu Wei', 'A study on reinforcement learning algorithms for robotic navigation systems.', 'Reinforcement Learning in Robotic Navigation', 24, 9),
(21, 'pdfs\\these15.pdf', '2023-12-05', 'Zainab Mohammed', 'This research investigates secure software development practices and vulnerability detection.', 'Secure Development Practices and Vulnerability Prevention', 25, 10),
(22, 'pdfs\\these16.pdf', '2024-01-15', 'Raj Patel', 'An analysis of smart grid technologies and their cybersecurity implications.', 'Cybersecurity Implications of Smart Grid Technologies', 21, 8),
(23, 'pdfs\\these17.pdf', '2024-02-22', 'Elena Ivanova', 'This thesis presents new methods for privacy-preserving machine learning in healthcare.', 'Privacy-Preserving ML in Healthcare Analytics', 22, 9),
(24, 'pdfs\\these18.pdf', '2024-03-08', 'Thomas Schmidt', 'A comprehensive study on edge computing architectures for IoT environments.', 'Edge Computing Architectures for IoT', 23, 10),
(25, 'pdfs\\these19.pdf', '2024-04-12', 'Mei Lin', 'This research explores natural language generation techniques for automated content creation.', 'NLG Methods for Automated Content Creation', 24, 8),
(26, 'pdfs\\these20.pdf', '2024-04-28', 'Ali Al-Zaidi', 'An investigation into augmented reality interfaces for industrial maintenance applications.', 'AR Interfaces for Industrial Maintenance', 25, 9);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id` int(11) NOT NULL,
  `nom_complet` varchar(255) NOT NULL,
  `login` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `role` enum('admin','utilisateur') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom_complet`, `login`, `mot_de_passe`, `role`) VALUES
(8, 'Yasser Rochdi', 'yasserU', '1234', 'utilisateur'),
(9, 'Yasser Admin', 'yasserA', '1234', 'admin'),
(10, 'Aya Elhamraoui', 'ayaU', '1234', 'utilisateur'),
(11, 'Aya Admin', 'ayaA', '1234', 'admin'),
(12, 'Mohamed Daif', 'mohamedU', '1234', 'utilisateur'),
(13, 'Mohamed Admin', 'mohamedA', '1234', 'admin'),
(14, 'U', 'U', '1', 'utilisateur'),
(15, 'A', 'A', '1', 'admin');

-- --------------------------------------------------------

--
-- Stand-in structure for view `vue_professeur_resume`
-- (See below for the actual view)
--
CREATE TABLE `vue_professeur_resume` (
`id_professeur` int(11)
,`professeur` varchar(255)
,`nb_articles` bigint(21)
,`nb_brevets` bigint(21)
,`nb_theses` bigint(21)
,`nb_memoires` bigint(21)
,`nb_rapports` bigint(21)
,`nb_conferences` bigint(21)
);

-- --------------------------------------------------------

--
-- Structure for view `vue_professeur_resume`
--
DROP TABLE IF EXISTS `vue_professeur_resume`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vue_professeur_resume`  AS SELECT `p`.`id` AS `id_professeur`, `p`.`nom_complet` AS `professeur`, (select count(0) from `article_professeur` `ap` where `ap`.`id_professeur` = `p`.`id`) AS `nb_articles`, (select count(0) from `brevet_professeur` `bp` where `bp`.`id_professeur` = `p`.`id`) AS `nb_brevets`, (select count(0) from `theses` `t` where `t`.`id_directeur` = `p`.`id`) AS `nb_theses`, (select count(0) from `memoires` `m` where `m`.`id_directeur` = `p`.`id`) AS `nb_memoires`, (select count(0) from `rapport_professeur` `rp` where `rp`.`id_professeur` = `p`.`id`) AS `nb_rapports`, (select count(0) from `conference_professeur` `cp` where `cp`.`id_professeur` = `p`.`id`) AS `nb_conferences` FROM `professeurs` AS `p` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlxymmd46qd2gpx08cb9sw53tk` (`upload_par`);

--
-- Indexes for table `article_journal`
--
ALTER TABLE `article_journal`
  ADD KEY `FKppubh40gdyj33s2vo6c0v4i8j` (`id_journal`),
  ADD KEY `FKa0t5fjd9gss2htfkl94j6sf3k` (`id_article`);

--
-- Indexes for table `article_professeur`
--
ALTER TABLE `article_professeur`
  ADD KEY `FKqjg0iefkv1x13now7kn4836kt` (`id_professeur`),
  ADD KEY `FK771aw3wwbmrev1gr8xh0g53r2` (`id_article`);

--
-- Indexes for table `brevets`
--
ALTER TABLE `brevets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqy4cwsfievffwpxyvjitbxcy3` (`upload_par`);

--
-- Indexes for table `brevet_professeur`
--
ALTER TABLE `brevet_professeur`
  ADD KEY `FKfj0xhlo8y7h71p8ynqmi6vl2k` (`id_professeur`),
  ADD KEY `FKa6kc0alhrdb9vmm4miheudnck` (`id_brevet`);

--
-- Indexes for table `conferences`
--
ALTER TABLE `conferences`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4or11ibnbmy17wkigr8ljqh71` (`upload_par`);

--
-- Indexes for table `conference_professeur`
--
ALTER TABLE `conference_professeur`
  ADD KEY `FKieqxviwuu7h4ywvae3l7yjv0a` (`id_professeur`),
  ADD KEY `FK3vsr23e3i3ap2rl1lk5os618n` (`id_conference`);

--
-- Indexes for table `journaux`
--
ALTER TABLE `journaux`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `memoires`
--
ALTER TABLE `memoires`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqjojynqqayq6ouvbsuq9sit09` (`id_directeur`),
  ADD KEY `FKeew913icsmifgy7v3hn82sp8l` (`upload_par`);

--
-- Indexes for table `professeurs`
--
ALTER TABLE `professeurs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rapports_recherche`
--
ALTER TABLE `rapports_recherche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkagqfox29gfyv2ulqyhg2k9uo` (`upload_par`);

--
-- Indexes for table `rapport_professeur`
--
ALTER TABLE `rapport_professeur`
  ADD KEY `FKfxh13v1d6lrmx7046vpdqbcba` (`id_professeur`),
  ADD KEY `FKa8yix5tufim4wli2ym1q8a5wm` (`id_rapport`);

--
-- Indexes for table `theses`
--
ALTER TABLE `theses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKry3bb3vjqk12h2cphlvpp2e28` (`id_directeur`),
  ADD KEY `FKrhovd6y1tb5kybn1krm4u6jnc` (`upload_par`);

--
-- Indexes for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `brevets`
--
ALTER TABLE `brevets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `conferences`
--
ALTER TABLE `conferences`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `journaux`
--
ALTER TABLE `journaux`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `memoires`
--
ALTER TABLE `memoires`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `professeurs`
--
ALTER TABLE `professeurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `rapports_recherche`
--
ALTER TABLE `rapports_recherche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `theses`
--
ALTER TABLE `theses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `FKlxymmd46qd2gpx08cb9sw53tk` FOREIGN KEY (`upload_par`) REFERENCES `utilisateurs` (`id`);

--
-- Constraints for table `article_journal`
--
ALTER TABLE `article_journal`
  ADD CONSTRAINT `FKa0t5fjd9gss2htfkl94j6sf3k` FOREIGN KEY (`id_article`) REFERENCES `articles` (`id`),
  ADD CONSTRAINT `FKppubh40gdyj33s2vo6c0v4i8j` FOREIGN KEY (`id_journal`) REFERENCES `journaux` (`id`);

--
-- Constraints for table `article_professeur`
--
ALTER TABLE `article_professeur`
  ADD CONSTRAINT `FK771aw3wwbmrev1gr8xh0g53r2` FOREIGN KEY (`id_article`) REFERENCES `articles` (`id`),
  ADD CONSTRAINT `FKqjg0iefkv1x13now7kn4836kt` FOREIGN KEY (`id_professeur`) REFERENCES `professeurs` (`id`);

--
-- Constraints for table `brevets`
--
ALTER TABLE `brevets`
  ADD CONSTRAINT `FKqy4cwsfievffwpxyvjitbxcy3` FOREIGN KEY (`upload_par`) REFERENCES `utilisateurs` (`id`);

--
-- Constraints for table `brevet_professeur`
--
ALTER TABLE `brevet_professeur`
  ADD CONSTRAINT `FKa6kc0alhrdb9vmm4miheudnck` FOREIGN KEY (`id_brevet`) REFERENCES `brevets` (`id`),
  ADD CONSTRAINT `FKfj0xhlo8y7h71p8ynqmi6vl2k` FOREIGN KEY (`id_professeur`) REFERENCES `professeurs` (`id`);

--
-- Constraints for table `conferences`
--
ALTER TABLE `conferences`
  ADD CONSTRAINT `FK4or11ibnbmy17wkigr8ljqh71` FOREIGN KEY (`upload_par`) REFERENCES `utilisateurs` (`id`);

--
-- Constraints for table `conference_professeur`
--
ALTER TABLE `conference_professeur`
  ADD CONSTRAINT `FK3vsr23e3i3ap2rl1lk5os618n` FOREIGN KEY (`id_conference`) REFERENCES `conferences` (`id`),
  ADD CONSTRAINT `FKieqxviwuu7h4ywvae3l7yjv0a` FOREIGN KEY (`id_professeur`) REFERENCES `professeurs` (`id`);

--
-- Constraints for table `memoires`
--
ALTER TABLE `memoires`
  ADD CONSTRAINT `FKeew913icsmifgy7v3hn82sp8l` FOREIGN KEY (`upload_par`) REFERENCES `utilisateurs` (`id`),
  ADD CONSTRAINT `FKqjojynqqayq6ouvbsuq9sit09` FOREIGN KEY (`id_directeur`) REFERENCES `professeurs` (`id`);

--
-- Constraints for table `rapports_recherche`
--
ALTER TABLE `rapports_recherche`
  ADD CONSTRAINT `FKkagqfox29gfyv2ulqyhg2k9uo` FOREIGN KEY (`upload_par`) REFERENCES `utilisateurs` (`id`);

--
-- Constraints for table `rapport_professeur`
--
ALTER TABLE `rapport_professeur`
  ADD CONSTRAINT `FKa8yix5tufim4wli2ym1q8a5wm` FOREIGN KEY (`id_rapport`) REFERENCES `rapports_recherche` (`id`),
  ADD CONSTRAINT `FKfxh13v1d6lrmx7046vpdqbcba` FOREIGN KEY (`id_professeur`) REFERENCES `professeurs` (`id`);

--
-- Constraints for table `theses`
--
ALTER TABLE `theses`
  ADD CONSTRAINT `FKrhovd6y1tb5kybn1krm4u6jnc` FOREIGN KEY (`upload_par`) REFERENCES `utilisateurs` (`id`),
  ADD CONSTRAINT `FKry3bb3vjqk12h2cphlvpp2e28` FOREIGN KEY (`id_directeur`) REFERENCES `professeurs` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
