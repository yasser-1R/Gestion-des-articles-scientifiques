-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2025 at 12:59 PM
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
(1, 'pdfs\\article1.pdf', '2020-12-12', 'resumer arabic NLP', 'arabic NLP', 2),
(2, 'pdfs\\article2.pdf', '2021-10-11', 'resumer arabic NLP', 'arabic NLP', 2),
(3, 'pdfs\\article3.pdf', '2022-10-10', 'resumer english NLP', 'english  NLP', 2),
(4, 'pdfs\\article4.pdf', '2019-12-23', 'resume dddtest', 'deep learning ', 2),
(5, 'pdfs\\article5.pdf', '2010-12-21', 'resume test', 'analyse de sentiment eng', 2);

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
(1, 1),
(1, 3),
(2, 2),
(2, 4),
(3, 2),
(3, 4),
(3, 6),
(4, 2),
(4, 5),
(5, 1),
(5, 2),
(5, 3);

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
(1, 3),
(1, 1),
(1, 2),
(2, 4),
(2, 3),
(3, 4),
(3, 3),
(3, 5),
(4, 4),
(5, 3),
(5, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `journaux`
--

CREATE TABLE `journaux` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `journaux`
--

INSERT INTO `journaux` (`id`, `nom`) VALUES
(1, 'Nature'),
(2, 'Science'),
(3, 'IEEE Transactions on Computers'),
(4, 'ACM Computing Surveys'),
(5, 'Journal of Artificial Intelligence Research'),
(6, 'Neural Networks Journal'),
(7, 'Communications of the ACM');

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
(1, 'Yasser Rochdi'),
(2, 'Aya Elhamraoui'),
(3, 'Mohamed Daif'),
(4, 'Omar Boutkhoum'),
(5, 'Driss Abada'),
(6, 'Abdessadek Aaroud'),
(7, 'Hanan Elfaik');

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
(1, 'yasser rochdi A', 'yasserA', '1234', 'admin'),
(2, 'yasser rochdi U', 'yasserU', '1234', 'utilisateur');

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_article_full_info`
-- (See below for the actual view)
--
CREATE TABLE `v_article_full_info` (
`article_id` int(11)
,`article_title` varchar(255)
,`uploaded_by` varchar(255)
,`professeur_name` varchar(255)
,`journal_name` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_article_journal`
-- (See below for the actual view)
--
CREATE TABLE `v_article_journal` (
`article_id` int(11)
,`article_title` varchar(255)
,`journal_id` int(11)
,`journal_name` varchar(255)
,`uploaded_by` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_article_professeur`
-- (See below for the actual view)
--
CREATE TABLE `v_article_professeur` (
`article_id` int(11)
,`article_title` varchar(255)
,`professeur_id` int(11)
,`professeur_name` varchar(255)
,`uploaded_by` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_article_summary`
-- (See below for the actual view)
--
CREATE TABLE `v_article_summary` (
`article_id` int(11)
,`article_title` varchar(255)
,`uploaded_by` varchar(255)
,`uploader_role` enum('admin','utilisateur')
);

-- --------------------------------------------------------

--
-- Structure for view `v_article_full_info`
--
DROP TABLE IF EXISTS `v_article_full_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_article_full_info`  AS SELECT `a`.`id` AS `article_id`, `a`.`titre` AS `article_title`, `u`.`nom_complet` AS `uploaded_by`, `p`.`nom_complet` AS `professeur_name`, `j`.`nom` AS `journal_name` FROM (((((`articles` `a` left join `article_professeur` `ap` on(`a`.`id` = `ap`.`id_article`)) left join `professeurs` `p` on(`ap`.`id_professeur` = `p`.`id`)) left join `article_journal` `aj` on(`a`.`id` = `aj`.`id_article`)) left join `journaux` `j` on(`aj`.`id_journal` = `j`.`id`)) left join `utilisateurs` `u` on(`a`.`upload_par` = `u`.`id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `v_article_journal`
--
DROP TABLE IF EXISTS `v_article_journal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_article_journal`  AS SELECT `a`.`id` AS `article_id`, `a`.`titre` AS `article_title`, `j`.`id` AS `journal_id`, `j`.`nom` AS `journal_name`, `u`.`nom_complet` AS `uploaded_by` FROM (((`articles` `a` join `article_journal` `aj` on(`a`.`id` = `aj`.`id_article`)) join `journaux` `j` on(`j`.`id` = `aj`.`id_journal`)) left join `utilisateurs` `u` on(`a`.`upload_par` = `u`.`id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `v_article_professeur`
--
DROP TABLE IF EXISTS `v_article_professeur`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_article_professeur`  AS SELECT `a`.`id` AS `article_id`, `a`.`titre` AS `article_title`, `p`.`id` AS `professeur_id`, `p`.`nom_complet` AS `professeur_name`, `u`.`nom_complet` AS `uploaded_by` FROM (((`articles` `a` join `article_professeur` `ap` on(`a`.`id` = `ap`.`id_article`)) join `professeurs` `p` on(`p`.`id` = `ap`.`id_professeur`)) left join `utilisateurs` `u` on(`a`.`upload_par` = `u`.`id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `v_article_summary`
--
DROP TABLE IF EXISTS `v_article_summary`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_article_summary`  AS SELECT `a`.`id` AS `article_id`, `a`.`titre` AS `article_title`, `u`.`nom_complet` AS `uploaded_by`, `u`.`role` AS `uploader_role` FROM (`articles` `a` left join `utilisateurs` `u` on(`a`.`upload_par` = `u`.`id`)) ;

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
-- Indexes for table `journaux`
--
ALTER TABLE `journaux`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professeurs`
--
ALTER TABLE `professeurs`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `journaux`
--
ALTER TABLE `journaux`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `professeurs`
--
ALTER TABLE `professeurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
