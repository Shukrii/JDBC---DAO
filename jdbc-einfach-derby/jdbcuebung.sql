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

INSERT INTO `klasse` (`id`) VALUES
('1a'),
('2b'),
('3c'),
('4a'),
('5b'),
('5c');

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

(1, 'vorname1', 'nachname1', '1a'),

(2, 'vorname2', 'nachname2', '2b');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
