-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idAutor` int(12) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Autor1'),(2,'Paulin'),(3,'Autor3'),(4,'autor4'),(5,'autor5'),(6,'Pedro');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editora` (
  `nome` varchar(100) NOT NULL,
  `idEditora` int(12) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idEditora`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES ('Editora1',1),('Editora2',2),('Editora3',3);
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `idLivro` int(12) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `anoPub` int(4) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `idEditora` int(12) NOT NULL,
  PRIMARY KEY (`idLivro`),
  KEY `fkEditoraLivro` (`idEditora`),
  CONSTRAINT `fkEditoraLivro` FOREIGN KEY (`idEditora`) REFERENCES `editora` (`idEditora`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'Como programar em java',2023,'1222347683212',1),(2,'Guia motivacional',0,'7654439872134',2),(3,'Aprendendo desenvolvimento web',0,'8792550190235',1),(4,'Padrões de Projeto',0,'0917458769218',3),(5,'Unity',0,'8017545578213',3),(6,'Programando com C#',0,'7699850024138',1),(7,'Quebrando a cabeça',0,'1624660092512',2),(8,'A vida é dura ft Leandro',0,'2434809521754',3),(9,'teste',2004,'1376902653216',2);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livrohasautor`
--

DROP TABLE IF EXISTS `livrohasautor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livrohasautor` (
  `idLivroHasAutor` int(12) NOT NULL AUTO_INCREMENT,
  `idLivro` int(12) NOT NULL,
  `idAutor` int(12) NOT NULL,
  PRIMARY KEY (`idLivroHasAutor`),
  KEY `livroHasLivro` (`idLivro`),
  KEY `LivroHasAutor` (`idAutor`),
  CONSTRAINT `LivroHasAutor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  CONSTRAINT `livroHasLivro` FOREIGN KEY (`idLivro`) REFERENCES `livro` (`idLivro`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livrohasautor`
--

LOCK TABLES `livrohasautor` WRITE;
/*!40000 ALTER TABLE `livrohasautor` DISABLE KEYS */;
INSERT INTO `livrohasautor` VALUES (1,3,2),(2,1,1),(3,1,4),(4,1,5),(5,3,2),(6,2,2),(7,3,2),(8,4,2),(9,2,3);
/*!40000 ALTER TABLE `livrohasautor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'biblioteca'
--

--
-- Dumping routines for database 'biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-04  9:48:05
