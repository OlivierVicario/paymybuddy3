CREATE DATABASE  IF NOT EXISTS `paymybuddy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `paymybuddy`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: paymybuddy
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `balance` decimal(10,2) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `user_account_fk` (`user_id`),
  CONSTRAINT `user_account_fk` FOREIGN KEY (`user_id`) REFERENCES `user_1` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (204,0.00,240),(205,0.00,241),(206,0.00,242),(207,0.00,243),(208,0.00,244),(209,0.00,245),(210,0.00,246),(211,0.00,247),(212,0.00,248),(213,0.00,249);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account` (
  `bank_account_id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `bankname` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `iban` varchar(27) NOT NULL,
  `bic` varchar(11) NOT NULL,
  PRIMARY KEY (`bank_account_id`,`account_id`),
  KEY `account_bank_account_fk` (`account_id`),
  CONSTRAINT `account_bank_account_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
INSERT INTO `bank_account` VALUES (2,204,'unknow','unknow','unknow','unknow'),(3,205,'unknow','unknow','unknow','unknow'),(4,206,'unknow','unknow','unknow','unknow'),(5,207,'unknow','unknow','unknow','unknow'),(6,208,'unknow','unknow','unknow','unknow'),(7,209,'unknow','unknow','unknow','unknow'),(8,210,'unknow','unknow','unknow','unknow'),(9,211,'unknow','unknow','unknow','unknow'),(10,212,'unknow','unknow','unknow','unknow'),(11,213,'unknow','unknow','unknow','unknow');
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connection_1`
--

DROP TABLE IF EXISTS `connection_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `connection_1` (
  `connection_id` int NOT NULL AUTO_INCREMENT,
  `user_from_id` int NOT NULL,
  `user_to_id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`connection_id`,`user_from_id`,`user_to_id`),
  KEY `user_connection_fk` (`user_from_id`),
  KEY `user_connection_fk1` (`user_to_id`),
  CONSTRAINT `user_connection_fk` FOREIGN KEY (`user_from_id`) REFERENCES `user_1` (`user_id`),
  CONSTRAINT `user_connection_fk1` FOREIGN KEY (`user_to_id`) REFERENCES `user_1` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=508 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connection_1`
--

LOCK TABLES `connection_1` WRITE;
/*!40000 ALTER TABLE `connection_1` DISABLE KEYS */;
INSERT INTO `connection_1` VALUES (504,242,240,'penelope guiness'),(506,242,241,'nick wahlberg');
/*!40000 ALTER TABLE `connection_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation`
--

DROP TABLE IF EXISTS `operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operation` (
  `opration_id` int NOT NULL AUTO_INCREMENT,
  `credit` tinyint(1) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `account_id` int NOT NULL,
  PRIMARY KEY (`opration_id`),
  KEY `account_operation_fk` (`account_id`),
  CONSTRAINT `account_operation_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation`
--

LOCK TABLES `operation` WRITE;
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL,
  `connection_name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `account_id` int NOT NULL,
  `connection_id` int NOT NULL,
  `user_from_id` int NOT NULL,
  `user_to_id` int NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `connection_1_transaction_fk` (`connection_id`,`user_from_id`,`user_to_id`),
  KEY `account_transaction_fk` (`account_id`),
  CONSTRAINT `account_transaction_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `connection_1_transaction_fk` FOREIGN KEY (`connection_id`, `user_from_id`, `user_to_id`) REFERENCES `connection_1` (`connection_id`, `user_from_id`, `user_to_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_1`
--

DROP TABLE IF EXISTS `user_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_1` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_1`
--

LOCK TABLES `user_1` WRITE;
/*!40000 ALTER TABLE `user_1` DISABLE KEYS */;
INSERT INTO `user_1` VALUES (240,NULL,'$2a$10$j/eRZeD7OP/1LyhpmV6jReG/CyaJc5SqSnX9yZE4V21gZsCRZbr8S','penelope.guiness@oc.com','penelope','guiness',1),(241,NULL,'$2a$10$0CqgGQof9JLVivkqby0NV.AEXbDnxmoNQzCKI.g72PIlP37qTBdMC','nick.wahlberg@oc.com','nick','wahlberg',1),(242,NULL,'$2a$10$eeiXCUbgdgvIpSgAKxqnVu8YFOq57XRjxUHnO3NhlA2NhdoNe/ALC','ed.chase@oc.com','ed','chase',1),(243,NULL,'$2a$10$NGxFNHHP6UO4gtBtbxrcYuFCjbneb3wHBweviG0KssCBBUoO2OO32','jennifer.davis@oc.com','jennifer','davis',1),(244,NULL,'$2a$10$lHXAxGHmeUoLpdp/9fnAJ.ORvJA5fvQBCKZ/WcHhEDc/rP6dGiujG','johnny.lollobridgida@oc.com','johnny','lollobrigida',1),(245,NULL,'$2a$10$bAg9J1sjcQTSgsdElGXpYOKfpmScnjpbo37KI58CN3aAhm4KQUgGe','bette.nicholson@oc.com','bette','nicholson',1),(246,NULL,'$2a$10$.zQUBaL1XqmDjsP1EfR5M.1qc.StQyM47geoK1NsfIezMepeWTlGq','grace.mostel@oc.com','grace','mostel',1),(247,NULL,'$2a$10$lT7KvNFMxqcraYg7jn86D.K.RR8oLxAxn3/Pwqr320zu7Wl7XmD/.','matthew.johansson@oc.com','matthew','johansson',1),(248,NULL,'$2a$10$gOYsaNc6ZzNRPBdZYPJX5OfQ7JHws2QXLdEXQoQ2UcXUUEMYmY8tm','joe.swank@oc.com','joe','swank',1),(249,NULL,'$2a$10$HnirV.f0IOjdmeaUzWEv/Ot3j4cTaKPHC.zte5N6TEDTcNB3UL4BS','christian.gable@oc.com','christian','gable',1);
/*!40000 ALTER TABLE `user_1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-12 16:18:21
