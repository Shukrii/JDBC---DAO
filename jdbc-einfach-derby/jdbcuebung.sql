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

-- Tabellenstruktur fÃ¼r Tabelle `flugzeugtyp`
--


CREATE TABLE IF NOT EXISTS `flugzeugtyp` (
  `bezeichnung` varchar(40) NOT NULL,
 
					 PRIMARY KEY (`bezeichnung`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Daten fÃ¼r Tabelle `flugzeugtyp`

--

INSERT INTO `flugzeugtyp` (`bezeichnung`) VALUES
('Passagierflugzeug'),
('Transportflugzeug');

--
-- --------------------------------------------------------

--
-- 
-- Tabellenstruktur fÃ¼r Tabelle `flugzeug`
--


CREATE TABLE IF NOT EXISTS `flugzeug` (

`id` int(11) NOT NULL,
  
`name` varchar(20) DEFAULT NULL,
    
`typ` varchar(40) DEFAULT NULL,
  
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Daten fÃ¼r Tabelle `flugzeug`
--


INSERT INTO `mitarbeiter` (`id`, `name`, `typ`) VALUES

(1, 'Airbus A380', 'Passagierflugzeug'),

(2, 'Boeing 737', 'Passagierflugzeug'),

(3, 'Antonov AC100', 'Transportflugzeug');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
