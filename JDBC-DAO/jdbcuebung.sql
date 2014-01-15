-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 22. Nov 2013 um 23:16
-- Server Version: 5.5.32
-- PHP-Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `jdbcuebung2`
--
CREATE DATABASE IF NOT EXISTS `jdbcuebung` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jdbcuebung`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `klassen`
--

CREATE TABLE IF NOT EXISTS `klassen` (
  `id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `klassen`
--

INSERT INTO `klassen` (`id`) VALUES
('1BFIT'),
('3ASHT');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lehrer`
--

CREATE TABLE IF NOT EXISTS `lehrer` (
  `id` int(11) NOT NULL,
  `vorname` varchar(20) NOT NULL,
  `nachname` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `lehrer`
--

INSERT INTO `lehrer` (`id`, `vorname`, `nachname`) VALUES
(1, 'John', 'Johnas'),
(2, 'Max', 'Min'),
(3, 'Jason', 'Statham');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `unterricht`
--

CREATE TABLE IF NOT EXISTS `unterricht` (
  `l_id` int(11) NOT NULL,
  `k_id` varchar(10) NOT NULL,
  `tagstunde` varchar(4) NOT NULL,
  KEY `l_id` (`l_id`),
  KEY `k_id` (`k_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `unterricht`
--
ALTER TABLE `unterricht`
  ADD CONSTRAINT `unterricht_ibfk_1` FOREIGN KEY (`l_id`) REFERENCES `lehrer` (`id`),
  ADD CONSTRAINT `unterricht_ibfk_2` FOREIGN KEY (`k_id`) REFERENCES `klassen` (`id`),
  ADD CONSTRAINT `unterricht_ibfk_3` FOREIGN KEY (`l_id`) REFERENCES `lehrer` (`id`),
  ADD CONSTRAINT `unterricht_ibfk_4` FOREIGN KEY (`k_id`) REFERENCES `klassen` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
