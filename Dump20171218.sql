CREATE DATABASE  IF NOT EXISTS `contattiDB` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `contattiDB`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: contattiDB
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `contatti`
--

DROP TABLE IF EXISTS `contatti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contatti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `numeroTelefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contatti`
--

LOCK TABLES `contatti` WRITE;
/*!40000 ALTER TABLE `contatti` DISABLE KEYS */;
INSERT INTO `contatti` VALUES (2,'arcibaldo','nuzzolo','arci@mail','131213124'),(3,'luca','gialli','gialli.l@mail.com','8882933521'),(4,'francesco','blu','francesco@mail.com','7543785748'),(5,'franco','rosa','francorosa@mail.com','8475834744'),(6,'giovanni','rossi','giovarssi@libero.it','0342342344'),(8,'lucia','due','luica@mail','0432959434'),(9,'beatrice','tre','beatrice@mail','4458345458'),(10,'christian','quattro','chri@mail','4584357834'),(12,'amhed','abdhulla','amhedmail','4548579454'),(13,'abdul','jamali','abdul@mail','4647848376'),(14,'gabriele','bonzi','mail@lele','72632763256'),(16,'mattia','acab','acab@mail','37376376376'),(17,'matta','null','null','4343434343'),(18,'mattia','acab','acab@mail','6374377');
/*!40000 ALTER TABLE `contatti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'contattiDB'
--

--
-- Dumping routines for database 'contattiDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-18 14:30:27
