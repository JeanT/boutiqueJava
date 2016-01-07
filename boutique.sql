-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 12 Décembre 2015 à 00:18
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `boutique`
--
CREATE DATABASE IF NOT EXISTS `boutique` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `boutique`;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_utilisateur_2` (`id_utilisateur`),
  UNIQUE KEY `id` (`id`),
  KEY `id_utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Vider la table avant d'insérer `facture`
--

TRUNCATE TABLE `facture`;
--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`id`, `date`, `id_utilisateur`) VALUES
(3, '2015-12-10', 1),
(4, '2015-12-09', 2);

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id_facture` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id_facture`,`id_produit`),
  KEY `id_facture` (`id_facture`,`id_produit`),
  KEY `id_produit` (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `item`
--

TRUNCATE TABLE `item`;
--
-- Contenu de la table `item`
--

INSERT INTO `item` (`id_facture`, `id_produit`, `quantite`) VALUES
(3, 1, 2),
(3, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ref` varchar(10) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `image` varchar(100) NOT NULL,
  `prix` float NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Vider la table avant d'insérer `produit`
--

TRUNCATE TABLE `produit`;
--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `ref`, `titre`, `image`, `prix`, `stock`) VALUES
(1, 'RFGT45', 'Le gang', 'no image', 25.54, 5),
(2, 'VCJ1547', 'La Scie', 'No image', 14.46, 4);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `rue` varchar(50) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `codePostal` int(5) NOT NULL,
  `mail` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Vider la table avant d'insérer `utilisateur`
--

TRUNCATE TABLE `utilisateur`;
--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `rue`, `ville`, `codePostal`, `mail`) VALUES
(1, 'BOUSCATIE', 'Kevin', 'chemin olhabidea', 'SARE', 64310, 'kevin.bouscatie@cegetel.net'),
(2, 'TONNERRE', 'Jean', '6 rue de la Soie', 'Anglet', 64200, 'jt@gmail.com'),
(3, 'LESEURE', 'Timothée', 'Rue de Marbre', 'Bayonne', 64250, 'tleuseure@hotmail.fr');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `foreign key id_utilisateur` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `foreign key id_facture` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id`),
  ADD CONSTRAINT `foreign key id_produit` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
