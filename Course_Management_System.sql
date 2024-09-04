CREATE DATABASE  IF NOT EXISTS `course_management_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `course_management_system`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: course_management_system
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `admindata`
--

DROP TABLE IF EXISTS `admindata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admindata` (
  `adminID` int NOT NULL AUTO_INCREMENT,
  `adminEmail` varchar(45) DEFAULT NULL,
  `adminPassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admindata`
--

LOCK TABLES `admindata` WRITE;
/*!40000 ALTER TABLE `admindata` DISABLE KEYS */;
INSERT INTO `admindata` VALUES (1,'admin','password');
/*!40000 ALTER TABLE `admindata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level4`
--

DROP TABLE IF EXISTS `level4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level4` (
  `studentEmail` varchar(50) DEFAULT NULL,
  `Academin_Skills` float DEFAULT NULL,
  `Fundamentals_of_Computing` float DEFAULT NULL,
  `Embedded_System_Programming` float DEFAULT NULL,
  `Internet_Software_Architecture` float DEFAULT NULL,
  `Computational_Mathematics` float DEFAULT NULL,
  `Introductory_Programming_and_Problem_Solving` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level4`
--

LOCK TABLES `level4` WRITE;
/*!40000 ALTER TABLE `level4` DISABLE KEYS */;
INSERT INTO `level4` VALUES ('keshab@gmail.com',76,89,91,86,86,86),('level4@failed.com',76,89,65,34,12,6),('level4@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `level4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level5`
--

DROP TABLE IF EXISTS `level5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level5` (
  `studentEmail` varchar(50) DEFAULT NULL,
  `Concept_of_AI` float DEFAULT NULL,
  `Object_Oriented_Design_and_Programming` float DEFAULT NULL,
  `Numerical_Methods_and_Concurrency` float DEFAULT NULL,
  `Distributed_and_Cloud_System_Programming` float DEFAULT NULL,
  `Collaborative_Development` float DEFAULT NULL,
  `Human_Computer_Interaction` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level5`
--

LOCK TABLES `level5` WRITE;
/*!40000 ALTER TABLE `level5` DISABLE KEYS */;
INSERT INTO `level5` VALUES ('keshab@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `level5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level6`
--

DROP TABLE IF EXISTS `level6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level6` (
  `studentEmail` varchar(50) DEFAULT NULL,
  `Complex_System` float DEFAULT NULL,
  `High_Performance_Computing` float DEFAULT NULL,
  `Project_and_Professionalism` float DEFAULT NULL,
  `Artificial_Intelligence_and_Machine_Learning` float DEFAULT NULL,
  `Big_Data` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level6`
--

LOCK TABLES `level6` WRITE;
/*!40000 ALTER TABLE `level6` DISABLE KEYS */;
/*!40000 ALTER TABLE `level6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level6opt`
--

DROP TABLE IF EXISTS `level6opt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level6opt` (
  `studentEmail` varchar(50) DEFAULT NULL,
  `Complex_System` varchar(5) DEFAULT NULL,
  `High_Performance_Computing` varchar(5) DEFAULT NULL,
  `Project_and_Professionalism` varchar(5) DEFAULT NULL,
  `Artificial_Intelligence_and_Machine_Learning` varchar(5) DEFAULT NULL,
  `Big_Data` varchar(5) DEFAULT NULL,
  UNIQUE KEY `studentEmail_UNIQUE` (`studentEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level6opt`
--

LOCK TABLES `level6opt` WRITE;
/*!40000 ALTER TABLE `level6opt` DISABLE KEYS */;
/*!40000 ALTER TABLE `level6opt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentdata`
--

DROP TABLE IF EXISTS `studentdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentdata` (
  `studentID` int NOT NULL AUTO_INCREMENT,
  `studentName` varchar(50) DEFAULT NULL,
  `studentContact` varchar(20) DEFAULT NULL,
  `studentLevel` int DEFAULT NULL,
  `studentPassword` varchar(45) DEFAULT NULL,
  `studentEmail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`studentID`),
  UNIQUE KEY `studentEmail_UNIQUE` (`studentEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdata`
--

LOCK TABLES `studentdata` WRITE;
/*!40000 ALTER TABLE `studentdata` DISABLE KEYS */;
INSERT INTO `studentdata` VALUES (1,'Keshab Saud','9861120645',5,'ksb123','keshab@gmail.com'),(2,'Level 4 Failed','6666666666',4,'123','level4@failed.com'),(3,'Level 4 studiying','123456789',4,'123123','level4@gmail.com');
/*!40000 ALTER TABLE `studentdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherdata`
--

DROP TABLE IF EXISTS `teacherdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherdata` (
  `teacherID` int NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(50) DEFAULT NULL,
  `teacherSubject` varchar(50) DEFAULT NULL,
  `teacherEmail` varchar(50) DEFAULT NULL,
  `teacherPassword` varchar(50) DEFAULT NULL,
  `teacherContact` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`teacherID`),
  UNIQUE KEY `teacherEmail_UNIQUE` (`teacherEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherdata`
--

LOCK TABLES `teacherdata` WRITE;
/*!40000 ALTER TABLE `teacherdata` DISABLE KEYS */;
INSERT INTO `teacherdata` VALUES (1,'Yugant Basnet','Object Oriented Design and Programming','yugant@gmail.com','yug@123','1234567890'),(2,'Kushal S','Object Oriented Design and Programming','kushal@gmail.com','k@123','12456378'),(3,'Ramesh Tmls','Numerical Methods and Concurrency','ramesh@gmail.com','r@123','986930463'),(4,'Prabesh Gurung','Concepts and Technologies of AI','prabesh@gmail.com','p@123','9861130541'),(5,'Prasidha Sir','Distributed and Cloud System Programming','prasidha@gmail.com','p@123','986021512'),(6,'Big Data teacher','Big Data','bigdata@gmail.com','t123','9875445554');
/*!40000 ALTER TABLE `teacherdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-14 19:47:36
