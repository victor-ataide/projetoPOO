-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coffee
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Bianca Andrade',12,'estudante','12345'),(2,'Bia an',15,'studante','1269'),(3,'Bianca Andrade',12,'estudante','12345'),(4,'Bia an',15,'studante','1269'),(5,'Gab Matias',28,'gerente','qwerty'),(6,'Jotin',56,'cliente','cleto'),(7,'Brito',9,'vendedor','pokemon'),(8,'ana',89,'caixa','d1nd1n'),(9,'Victor',59,'cliente','wow'),(10,'Farias',30,'Vendedor','fga'),(11,'Bianca Andrade',12,'estudante','12345'),(12,'co',15,'cab','superAdmin'),(13,'bu',66,'tu','admin'),(14,'victor',55,'cab','superAdmin'),(15,'victor',88,'vab','superAdmin'),(16,'bpa',58,'fav','superAdmin'),(17,'agora',43,'vab','Admin'),(18,'ga',90,'vf','Admin'),(19,'Thiago',56,'gop','Admin'),(20,'lucas',55,'gh','Admin'),(21,'fernando',33,'thi','Admin'),(22,'t',5,'far','Vendendor'),(23,'victor',990,'rt','Vendendor'),(24,'faf',445,'fa','Admin'),(25,'aaaaa',566656,'tyu','Admin'),(26,'victor',9,'afa','Vendendor'),(27,'ghj',56,'afg','Admin'),(28,'pfvdeus',99,'afa','Admin'),(29,'Diego',23,'tudo','Admin'),(30,'thiago',55,'gh','Admin'),(31,'jose',56,'Vendedor','gti');
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

-- Dump completed on 2023-06-19  6:57:08
