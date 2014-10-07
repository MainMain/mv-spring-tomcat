-- phpMyAdmin SQL Dump
-- version 2.10.1
-- http://www.phpmyadmin.net
-- 
-- Serveur: localhost
-- Généré le : Ven 03 Septembre 2010 à 10:13
-- Version du serveur: 5.0.45
-- Version de PHP: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de données: `dbpam_hibernate`
-- 
-- DROP DATABASE `dbpam_hibernate`;
CREATE DATABASE `dbpam_hibernate` DEFAULT CHARACTER SET utf8 COLLATE utf8_swedish_ci;
USE `dbpam_hibernate`;

-- --------------------------------------------------------

-- 
-- Structure de la table `cotisations`
-- 

DROP TABLE IF EXISTS `cotisations`;
CREATE TABLE IF NOT EXISTS `cotisations` (
  `ID` bigint(20) NOT NULL auto_increment,
  `SECU` double NOT NULL,
  `RETRAITE` double NOT NULL,
  `CSGD` double NOT NULL,
  `CSGRDS` double NOT NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- 
-- Contenu de la table `cotisations`
-- 

INSERT INTO `cotisations` (`ID`, `SECU`, `RETRAITE`, `CSGD`, `CSGRDS`, `VERSION`) VALUES 
(3, 9.39, 7.88, 6.15, 3.49, 1);

-- --------------------------------------------------------

-- 
-- Structure de la table `employes`
-- 

DROP TABLE IF EXISTS `employes`;
CREATE TABLE IF NOT EXISTS `employes` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PRENOM` varchar(20) NOT NULL,
  `SS` varchar(15) NOT NULL,
  `ADRESSE` varchar(50) NOT NULL,
  `CP` varchar(5) NOT NULL,
  `VILLE` varchar(30) NOT NULL,
  `NOM` varchar(30) NOT NULL,
  `VERSION` int(11) NOT NULL,
  `INDEMNITE_ID` bigint(20) NOT NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `SS` (`SS`),
  KEY `FK_EMPLOYES_INDEMNITE_ID` (`INDEMNITE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- 
-- Contenu de la table `employes`
-- 

INSERT INTO `employes` (`ID`, `PRENOM`, `SS`, `ADRESSE`, `CP`, `VILLE`, `NOM`, `VERSION`, `INDEMNITE_ID`) VALUES 
(5, 'Marie', '254104940426058', '5 rue des oiseaux', '49203', 'St Corentin', 'Jouveinal', 1, 8),
(6, 'Justine', '260124402111742', 'La Brûlerie', '49014', 'St Marcel', 'Laverti', 1, 7);

-- --------------------------------------------------------

-- 
-- Structure de la table `indemnites`
-- 

DROP TABLE IF EXISTS `indemnites`;
CREATE TABLE IF NOT EXISTS `indemnites` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ENTRETIEN_JOUR` double NOT NULL,
  `REPAS_JOUR` double NOT NULL,
  `INDICE` int(11) NOT NULL,
  `INDEMNITES_CP` double NOT NULL,
  `BASE_HEURE` double NOT NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `INDICE` (`INDICE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- 
-- Contenu de la table `indemnites`
-- 

INSERT INTO `indemnites` (`ID`, `ENTRETIEN_JOUR`, `REPAS_JOUR`, `INDICE`, `INDEMNITES_CP`, `BASE_HEURE`, `VERSION`) VALUES 
(7, 2, 3, 1, 12, 1.93, 1),
(8, 2.1, 3.1, 2, 15, 2.1, 1);

-- 
-- Contraintes pour les tables exportées
-- 

-- 
-- Contraintes pour la table `employes`
-- 
ALTER TABLE `employes`
  ADD CONSTRAINT `FK_EMPLOYES_INDEMNITE_ID` FOREIGN KEY (`INDEMNITE_ID`) REFERENCES `indemnites` (`ID`);

--
-- Propriétaire
--
GRANT ALL PRIVILEGES ON DBPAM_HIBERNATE.* TO 'dbpam'@'localhost' identified by 'dbpam';

