-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: hrm
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idemployee` bigint(20) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(24) DEFAULT NULL,
  `LastName` varchar(24) DEFAULT NULL,
  `Salary` varchar(20) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `IDsection` int(11) NOT NULL,
  PRIMARY KEY (`idemployee`),
  KEY `IDsection_idx` (`IDsection`),
  CONSTRAINT `IDsection` FOREIGN KEY (`IDsection`) REFERENCES `sections` (`IDSection`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Aris','Georgakopoulos','1000',10,1),(2,'Iasonas','Sarlamis','1050',9,1),(3,'Tasos','Konidis','950',9,1),(6,'Nikos','Andreou','980',10,18),(12,'Kostas','Papas','1000',7,18),(16,'Nikos','Georgiou','1025',8,1),(30,'Kostas','Georgopoulos','1050',7,3),(33,'Aris','Georgakopoulos','1900',8,19),(34,'Tasos','Konidis','1450',8,19),(38,'Antonis ','Giannopoulos','1125',8,3),(39,'Marios','Antoniou','1180',8,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-29 23:37:20
