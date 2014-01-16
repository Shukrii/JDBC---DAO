-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 06. Nov 2013 um 18:51
-- Server Version: 5.5.32
-- PHP-Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `jdbcuebung`
--
CREATE DATABASE IF NOT EXISTS `jdbcuebung` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jdbcuebung`;

-- --------------------------------------------------------

--
-- 

Tabellenstruktur für Tabelle `klasse`
--


CREATE TABLE IF NOT EXISTS `klasse` (
  `id` varchar(5) NOT NULL,
 
					 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Daten für Tabelle `klasse`

--

INSERT INTO `klasse` (`id`, `bez`) VALUES
('1AHIF', 'AHIF'),
('1BHIF', 'BHIF'),
('1CHIF', 'CHIF'),
('2AHIF', 'AHIF'),
('3BHIF', 'BHIF'),
('3AHIF', 'AHIF');

--
 --------------------------------------------------------

--
-- 
Tabellenstruktur für Tabelle `schueler`
--


CREATE TABLE IF NOT EXISTS `schueler` (

`id` int(11) NOT NULL,
  
`vorname` varchar(20) DEFAULT NULL,
  
`nachname` varchar(20) DEFAULT NULL,
  
`klasse` varchar(5) DEFAULT NULL,
  
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Daten für Tabelle `schueler`
--


INSERT INTO `schueler` (`id`, `vorname`, `nachname`, `klasse`) VALUES

(1, 'John', 'Jones', '1AHIF'),

(2, 'Max', 'Muster', '2AHIF');

(3, 'Karl', 'Max', '3BHIF');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
