-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: emp_msdb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll` (
  `IDpayroll` int NOT NULL AUTO_INCREMENT,
  `ID` int NOT NULL,
  `Date` varchar(45) NOT NULL,
  `Rice Subsidy` varchar(45) NOT NULL,
  `Phone Allowance` varchar(45) NOT NULL,
  `Clothing Allowance` varchar(45) NOT NULL,
  `Total Allowances` varchar(45) NOT NULL,
  `SSS` varchar(45) NOT NULL,
  `Philhealth` varchar(45) NOT NULL,
  `Pag-ibig` varchar(45) NOT NULL,
  `TIN` varchar(45) NOT NULL,
  `Total Deductions` varchar(45) NOT NULL,
  `Total Net Salary` varchar(45) NOT NULL,
  `Term` varchar(100) NOT NULL,
  PRIMARY KEY (`IDpayroll`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES (7,3,'2024-02-25 13:06:25','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 1 (Month Day: 1st day until 15th)'),(8,3,'2023-03-25 22:45:24','1,200','2,000','1,000','4,200.00','1,125.00','900.00','100.0','2,935.50','5,060.50','32,139.50','Term 1 (Month Day: 1st day until 15th)'),(9,3,'2022-04-25 22:45:53','1,000','2,000','1,000','4,000.00','1,125.00','900.00','100.0','2,885.50','5,010.50','31,989.50','Term 1 (Month Day: 1st day until 15th)'),(10,3,'2024-02-25 23:01:11','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 2 (Month Day:16th day until last day)'),(11,2,'2024-02-26 14:23:48','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 1 (Month Day: 1st day until 15th)'),(12,2,'2024-02-26 14:23:59','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 2 (Month Day:16th day until last day)'),(13,3,'2024-02-26 19:46:06','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 1 (Month Day: 1st day until 15th)'),(14,35,'2024-02-26 19:49:29','1,000','2,000','3,000','6,000.00','1,125.00','750.00','100.0','2,138.40','4,113.40','29,386.60','Term 1 (Month Day: 1st day until 15th)'),(15,3,'2024-02-27 15:09:59','1,000','2,001','1,001','4,002.00','1,125.00','900.00','100.0','2,886.00','5,011.00','31,991.00','Term 1 (Month Day: 1st day until 15th)');
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-10  1:07:05
