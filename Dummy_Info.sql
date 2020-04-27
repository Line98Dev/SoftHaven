-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: denmarktraffic
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `berth`
--

DROP TABLE IF EXISTS `berth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `berth` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(16) NOT NULL,
  `QuayId` int NOT NULL,
  `Available` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Id`),
  KEY `QuayId` (`QuayId`),
  CONSTRAINT `berth_ibfk_1` FOREIGN KEY (`QuayId`) REFERENCES `quay` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `berth`
--

LOCK TABLES `berth` WRITE;
/*!40000 ALTER TABLE `berth` DISABLE KEYS */;
INSERT INTO `berth` VALUES (1,'B-1',1,1),(2,'B-2',1,1),(3,'B-3',2,1),(4,'B-4',2,1);
/*!40000 ALTER TABLE `berth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quay`
--

DROP TABLE IF EXISTS `quay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quay` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(64) NOT NULL,
  `PortName` varchar(64) NOT NULL,
  `Type` varchar(32) NOT NULL,
  `Length` smallint unsigned NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quay`
--

LOCK TABLES `quay` WRITE;
/*!40000 ALTER TABLE `quay` DISABLE KEYS */;
INSERT INTO `quay` VALUES (1,'Quay A-1','Oslo','Dry Bulk',300),(2,'Quay A-2','Oslo','Container',550);
/*!40000 ALTER TABLE `quay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ship`
--

DROP TABLE IF EXISTS `ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ship` (
  `IMO` mediumint unsigned NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Berth` int DEFAULT NULL,
  `State` varchar(24) NOT NULL,
  PRIMARY KEY (`IMO`),
  KEY `Berth` (`Berth`),
  CONSTRAINT `ship_ibfk_1` FOREIGN KEY (`Berth`) REFERENCES `berth` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship`
--

LOCK TABLES `ship` WRITE;
/*!40000 ALTER TABLE `ship` DISABLE KEYS */;
INSERT INTO `ship` VALUES (101,'Enterprise',1,'expected'),(102,'Galactica',2,'expected'),(103,'Pegasus',3,'expected'),(104,'Borg Cube 75C8',4,'expected');
/*!40000 ALTER TABLE `ship` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-26 22:00:24
