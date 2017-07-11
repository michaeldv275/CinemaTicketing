-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: udc
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movieID` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `genre` varchar(45) NOT NULL,
  PRIMARY KEY (`movieID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Star Wars: The Force Awakens','A continuation of the saga.','Sci-Fi');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieshowing`
--

DROP TABLE IF EXISTS `movieshowing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movieshowing` (
  `schedID` int(11) NOT NULL AUTO_INCREMENT,
  `movieID` int(11) NOT NULL,
  `theaterID` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `day` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`schedID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieshowing`
--

LOCK TABLES `movieshowing` WRITE;
/*!40000 ALTER TABLE `movieshowing` DISABLE KEYS */;
INSERT INTO `movieshowing` VALUES (1,1,1,12,3,2015),(2,1,1,12,4,2015);
/*!40000 ALTER TABLE `movieshowing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `seatID` int(11) NOT NULL AUTO_INCREMENT,
  `status` enum('Available','Reserved') NOT NULL DEFAULT 'Available',
  `row` int(1) unsigned zerofill NOT NULL,
  `col` int(2) unsigned zerofill NOT NULL,
  `theaterID` int(11) NOT NULL,
  `floorNum` int(2) unsigned zerofill NOT NULL,
  `seat_enabled` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`seatID`),
  KEY `theaterID_idx` (`theaterID`),
  CONSTRAINT `theaterID` FOREIGN KEY (`theaterID`) REFERENCES `theater` (`theaterID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (15,'Available',0,00,4,01,1),(16,'Available',0,01,4,01,1),(17,'Available',0,02,4,01,1),(18,'Available',0,03,4,01,1),(19,'Available',0,04,4,01,1),(20,'Available',0,05,4,01,1),(21,'Available',0,06,4,01,1),(22,'Available',0,07,4,01,1),(23,'Available',0,08,4,01,1),(24,'Available',0,09,4,01,1),(25,'Available',1,00,4,01,0),(26,'Available',1,01,4,01,0),(27,'Available',1,02,4,01,0),(28,'Available',1,03,4,01,0),(29,'Available',1,04,4,01,0),(30,'Available',1,05,4,01,0),(31,'Available',1,06,4,01,0),(32,'Available',1,07,4,01,0),(33,'Available',1,08,4,01,0),(34,'Available',1,09,4,01,0),(35,'Available',2,00,4,01,1),(36,'Available',2,01,4,01,1),(37,'Available',2,02,4,01,1),(38,'Available',2,03,4,01,1),(39,'Available',2,04,4,01,1),(40,'Available',2,05,4,01,1),(41,'Available',2,06,4,01,1),(42,'Available',2,07,4,01,1),(43,'Available',2,08,4,01,1),(44,'Available',2,09,4,01,1),(45,'Available',3,00,4,01,0),(46,'Available',3,01,4,01,0),(47,'Available',3,02,4,01,0),(48,'Available',3,03,4,01,0),(49,'Available',3,04,4,01,0),(50,'Available',3,05,4,01,0),(51,'Available',3,06,4,01,0),(52,'Available',3,07,4,01,0),(53,'Available',3,08,4,01,0),(54,'Available',3,09,4,01,0),(55,'Available',4,00,4,01,0),(56,'Available',4,01,4,01,0),(57,'Available',4,02,4,01,0),(58,'Available',4,03,4,01,0),(59,'Available',4,04,4,01,0),(60,'Available',4,05,4,01,0),(61,'Available',4,06,4,01,0),(62,'Available',4,07,4,01,0),(63,'Available',4,08,4,01,0),(64,'Available',4,09,4,01,0);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theater` (
  `theaterID` int(11) NOT NULL AUTO_INCREMENT,
  `theaterName` varchar(45) NOT NULL,
  `numOfFloors` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`theaterID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES (1,'Greenbelt',2,200),(2,'Glorietta',2,200),(3,'theatre',3,50),(4,'new',5,50);
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` enum('Admin','User') NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin','udc','Admin'),(2,'user','user','user','udc','User');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-03 21:15:26
