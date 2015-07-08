-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 25. Mai 2015 um 15:41
-- Server Version: 5.6.21
-- PHP-Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `service`
--
CREATE DATABASE IF NOT EXISTS `service` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `service`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `history`
--

CREATE TABLE IF NOT EXISTS `history` (
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `userid` varchar(11) DEFAULT NULL,
  `action` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `history`
--

INSERT INTO `history` (`time`, `userid`, `action`) VALUES
('2015-05-01 13:12:12', '6201AA93', 'login'),
('2015-05-01 14:13:12', '6201AA93', 'logout');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `id` varchar(11) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`firstname`, `lastname`, `id`, `role`) VALUES
('Matthias', 'Leiwelt', '1293A893', 'service'),
('Steven', 'Behne', '32E2A993', 'service'),
('Simon', 'Ohlmeier', '6201AA93', 'admin');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `history`
--
ALTER TABLE `history`
 ADD PRIMARY KEY (`time`), ADD KEY `userid` (`userid`);

--
-- Indizes für die Tabelle `person`
--
ALTER TABLE `person`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id` (`id`), ADD UNIQUE KEY `id_2` (`id`), ADD UNIQUE KEY `id_3` (`id`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `history`
--
ALTER TABLE `history`
ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `person` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
