-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2025 at 08:53 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `article_journal`
--

CREATE TABLE `article_journal` (
  `id_article` int(11) NOT NULL,
  `id_journal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `article_professeur`
--

CREATE TABLE `article_professeur` (
  `id_article` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `titre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `brevet_professeur`
--

CREATE TABLE `brevet_professeur` (
  `id_brevet` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `titre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `conference_professeur`
--

CREATE TABLE `conference_professeur` (
  `id_conference` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `journaux`
--

CREATE TABLE `journaux` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `quartile` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `id_directeur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `professeurs`
--

CREATE TABLE `professeurs` (
  `id` int(11) NOT NULL,
  `nom_complet` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rapports_recherche`
--

CREATE TABLE `rapports_recherche` (
  `id` int(11) NOT NULL,
  `chemin_pdf` varchar(500) DEFAULT NULL,
  `date_publication` date DEFAULT NULL,
  `resume` text DEFAULT NULL,
  `titre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rapport_professeur`
--

CREATE TABLE `rapport_professeur` (
  `id_rapport` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `id_directeur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `FKqjojynqqayq6ouvbsuq9sit09` (`id_directeur`);

--
-- Indexes for table `professeurs`
--
ALTER TABLE `professeurs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rapports_recherche`
--
ALTER TABLE `rapports_recherche`
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `FKry3bb3vjqk12h2cphlvpp2e28` (`id_directeur`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `brevets`
--
ALTER TABLE `brevets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conferences`
--
ALTER TABLE `conferences`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `journaux`
--
ALTER TABLE `journaux`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `memoires`
--
ALTER TABLE `memoires`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `professeurs`
--
ALTER TABLE `professeurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rapports_recherche`
--
ALTER TABLE `rapports_recherche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `theses`
--
ALTER TABLE `theses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

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
-- Constraints for table `brevet_professeur`
--
ALTER TABLE `brevet_professeur`
  ADD CONSTRAINT `FKa6kc0alhrdb9vmm4miheudnck` FOREIGN KEY (`id_brevet`) REFERENCES `brevets` (`id`),
  ADD CONSTRAINT `FKfj0xhlo8y7h71p8ynqmi6vl2k` FOREIGN KEY (`id_professeur`) REFERENCES `professeurs` (`id`);

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
  ADD CONSTRAINT `FKqjojynqqayq6ouvbsuq9sit09` FOREIGN KEY (`id_directeur`) REFERENCES `professeurs` (`id`);

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
  ADD CONSTRAINT `FKry3bb3vjqk12h2cphlvpp2e28` FOREIGN KEY (`id_directeur`) REFERENCES `professeurs` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
