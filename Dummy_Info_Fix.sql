-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: SoftHavenTables
-- ------------------------------------------------------
-- Server version	8.0.19


--
-- Dumping data for table `quay`
--

LOCK TABLES `quay` WRITE;
/*!40000 ALTER TABLE `quay` DISABLE KEYS */;
INSERT INTO `quay` VALUES (1,'Quay A-1','Oslo','Dry Bulk',300),(2,'Quay A-2','Oslo','Container',550);
/*!40000 ALTER TABLE `quay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `berth`
--

LOCK TABLES `berth` WRITE;
/*!40000 ALTER TABLE `berth` DISABLE KEYS */;
INSERT INTO `berth` VALUES (1,'B-1',1,1),(2,'B-2',1,1),(3,'B-3',2,1),(4,'B-4',2,1);
/*!40000 ALTER TABLE `berth` ENABLE KEYS */;
UNLOCK TABLES;


-- Dumping Data for table `ship`

LOCK TABLES `ship` WRITE;
/*!40000 ALTER TABLE `ship` DISABLE KEYS */;
INSERT INTO `ship` VALUES (101,'Enterprise',1,'expected'),(102,'Galactica',2,'expected'),(103,'Pegasus',3,'expected'),(104,'Borg Cube 75C8',4,'expected');
/*!40000 ALTER TABLE `ship` ENABLE KEYS */;
UNLOCK TABLES;



-- Dumping Data for table Vessel Pre-arrival Form

/*!40000 ALTER TABLE `Vessel Pre-arrival Form` DISABLE KEYS */;
INSERT INTO `Vessel Pre-arrival Form` VALUES ('Test Ship Name','Omega',1234,'Test Agent Info','Arriving Form Test',"2019-04-27 05:14:32",1,'Next Port',"2019-04-28 05:14:32",'Offboard Cargo Test',1,'Onboarding Cargo Test',3,2,1,null,null);
/*!40000 ALTER TABLE `Vessel Pre-arrival Form` ENABLE KEYS */;


-- Dump completed on 2020-04-26 22:00:24
