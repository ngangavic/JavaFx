-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: hsresults
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB

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
-- Table structure for table `tbl_comments`
--

DROP TABLE IF EXISTS `tbl_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `a` varchar(100) DEFAULT NULL,
  `aMinus` varchar(100) DEFAULT NULL,
  `bPlus` varchar(100) DEFAULT NULL,
  `b` varchar(100) DEFAULT NULL,
  `bMinus` varchar(100) DEFAULT NULL,
  `cPlus` varchar(100) DEFAULT NULL,
  `c` varchar(100) DEFAULT NULL,
  `cMinus` varchar(100) DEFAULT NULL,
  `dPlus` varchar(100) DEFAULT NULL,
  `d` varchar(100) DEFAULT NULL,
  `dMinus` varchar(100) DEFAULT NULL,
  `e` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comments`
--

LOCK TABLES `tbl_comments` WRITE;
/*!40000 ALTER TABLE `tbl_comments` DISABLE KEYS */;
INSERT INTO `tbl_comments` VALUES (1,'Excellent','Good work','Hecco','Perfect','Above average','There\'s room for improvement','Below average','Work harder','Too low','Aim higher','Almost bottom','Failed');
/*!40000 ALTER TABLE `tbl_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_agri`
--

DROP TABLE IF EXISTS `tbl_f1_agri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_agri` (
  `id` int(11) DEFAULT NULL,
  `adm` varchar(100) NOT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT '0',
  `g1` varchar(100) DEFAULT NULL,
  `p1` int(100) DEFAULT '0',
  `ex2` int(50) DEFAULT '0',
  `g2` varchar(100) DEFAULT NULL,
  `p2` int(100) DEFAULT '0',
  `ex3` int(50) DEFAULT '0',
  `g3` varchar(100) DEFAULT NULL,
  `p3` int(100) DEFAULT '0',
  `ex4` int(50) DEFAULT '0',
  `g4` varchar(100) DEFAULT NULL,
  `p4` int(100) DEFAULT '0',
  `ex5` int(50) DEFAULT '0',
  `g5` varchar(100) DEFAULT NULL,
  `p5` int(100) DEFAULT '0',
  `ex6` int(50) DEFAULT '0',
  `g6` varchar(100) DEFAULT NULL,
  `p6` int(100) DEFAULT '0',
  `ex7` int(50) DEFAULT '0',
  `g7` varchar(100) DEFAULT NULL,
  `p7` int(100) DEFAULT '0',
  `ex8` int(50) DEFAULT '0',
  `g8` varchar(100) DEFAULT NULL,
  `p8` int(100) DEFAULT '0',
  `ex9` int(50) DEFAULT '0',
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT '0',
  PRIMARY KEY (`adm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_agri`
--

LOCK TABLES `tbl_f1_agri` WRITE;
/*!40000 ALTER TABLE `tbl_f1_agri` DISABLE KEYS */;
INSERT INTO `tbl_f1_agri` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',87,'A',12,78,'A-',11,78,'A-',11,63,'B-',8,30,'D-',2,50,'C',6,41,'D+',4,80,'A',12,50,'C','6'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',88,'A',12,60,'B-',8,56,'C+',7,40,'D+',4,90,'A',12,89,'A',12,70,'B+',10,75,'A-',11,60,'B-','8'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'B',9,65,'B',9,70,'B+',10,78,'A-',11,67,'B',9,90,'A',12,80,'A',12,80,'A',12,80,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',65,'B',9,76,'A-',11,55,'C+',7,70,'B+',10,80,'A',12,67,'B',9,40,'D+',4,60,'B-',8,45,'C-','5'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,'0'),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,'0'),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,'0'),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,0,0,NULL,'0');
/*!40000 ALTER TABLE `tbl_f1_agri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_bio`
--

DROP TABLE IF EXISTS `tbl_f1_bio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_bio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_bio`
--

LOCK TABLES `tbl_f1_bio` WRITE;
/*!40000 ALTER TABLE `tbl_f1_bio` DISABLE KEYS */;
INSERT INTO `tbl_f1_bio` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',67,'B','9',57,'C+','7',23,'E','1',34,'D-','2',20,'E','1',34,'D-','2',34,'D-','2',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',57,'C+','7',60,'B-','8',60,'B-','8',56,'C+','7',43,'D+','4',78,'A-','11',56,'C+','7',67,'B','9',67,'B','9'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',34,'D-','2',23,'E','1',78,'A-','11',65,'B','9',56,'C+','7',65,'B','9',78,'A-','11',89,'A','12',87,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',33,'D-','2',45,'C-','5',52,'C','6',67,'B','9',78,'A-','11',45,'C-','5',90,'A','12',45,'C-','5',88,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_bio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_bus`
--

DROP TABLE IF EXISTS `tbl_f1_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_bus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_bus`
--

LOCK TABLES `tbl_f1_bus` WRITE;
/*!40000 ALTER TABLE `tbl_f1_bus` DISABLE KEYS */;
INSERT INTO `tbl_f1_bus` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',67,'B+','10',90,'A','12',67,'B+','10',63,'B','9',50,'C+','7',45,'C','6',45,'C','6',63,'B','9',67,'B+','10'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',67,'B+','10',65,'B+','10',78,'A','12',51,'C+','7',67,'B+','10',98,'A','12',67,'B+','10',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A','12',56,'B-','8',45,'C','6',67,'B+','10',54,'C+','7',70,'A-','11',78,'A','12',34,'D','3',60,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',89,'A','12',45,'C','6',44,'C-','5',56,'B-','8',33,'D','3',75,'A','12',67,'B+','10',67,'B+','10',50,'C+','7'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_chem`
--

DROP TABLE IF EXISTS `tbl_f1_chem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_chem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_chem`
--

LOCK TABLES `tbl_f1_chem` WRITE;
/*!40000 ALTER TABLE `tbl_f1_chem` DISABLE KEYS */;
INSERT INTO `tbl_f1_chem` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',65,'B','9',45,'C-','5',90,'A','12',78,'A-','11',78,'A-','11',45,'C-','5',89,'A','12',60,'B-','8',70,'B+','10'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B','9',49,'C-','5',78,'A-','11',89,'A','12',90,'A','12',34,'D-','2',67,'B','9',55,'C+','7',54,'C','6'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',56,'C+','7',89,'A','12',67,'B','9',45,'C-','5',76,'A-','11',56,'C+','7',65,'B','9',50,'C','6',40,'D+','4'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',50,'C','6',87,'A','12',88,'A','12',34,'D-','2',56,'C+','7',34,'D-','2',64,'B-','8',45,'C-','5',34,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_chem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_cre`
--

DROP TABLE IF EXISTS `tbl_f1_cre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_cre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_cre`
--

LOCK TABLES `tbl_f1_cre` WRITE;
/*!40000 ALTER TABLE `tbl_f1_cre` DISABLE KEYS */;
INSERT INTO `tbl_f1_cre` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',23,'E','1',34,'D-','2',30,'D-','2',77,'A-','11',38,'D','3',45,'C-','5',45,'C-','5',80,'A','12',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B','9',32,'D-','2',76,'A-','11',65,'B','9',89,'A','12',89,'A','12',89,'A','12',90,'A','12',78,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A-','11',78,'A-','11',89,'A','12',45,'C-','5',67,'B','9',89,'A','12',90,'A','12',76,'A-','11',67,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',89,'A','12',54,'C','6',66,'B','9',55,'C+','7',78,'A-','11',70,'B+','10',30,'D-','2',78,'A-','11',54,'C','6'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_cre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_eng`
--

DROP TABLE IF EXISTS `tbl_f1_eng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_eng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_eng`
--

LOCK TABLES `tbl_f1_eng` WRITE;
/*!40000 ALTER TABLE `tbl_f1_eng` DISABLE KEYS */;
INSERT INTO `tbl_f1_eng` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',38,'D','3',78,'A-','11',45,'C-','5',89,'A','12',98,'A','12',67,'B','9',45,'C-','5',45,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',78,'A-','11',67,'B','9',34,'D-','2',56,'C+','7',78,'A-','11',45,'C-','5',34,'D-','2',34,'D-','2',44,'D+','4'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',45,'C-','5',56,'C+','7',60,'B-','8',34,'D-','2',67,'B','9',34,'D-','2',56,'C+','7',67,'B','9',40,'D+','4'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'D-','2',89,'A','12',23,'E','1',49,'C-','5',56,'C+','7',45,'C-','5',34,'D-','2',23,'E','1',34,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_eng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_geo`
--

DROP TABLE IF EXISTS `tbl_f1_geo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_geo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_geo`
--

LOCK TABLES `tbl_f1_geo` WRITE;
/*!40000 ALTER TABLE `tbl_f1_geo` DISABLE KEYS */;
INSERT INTO `tbl_f1_geo` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',89,'A-','11',40,'D-','2',45,'D','3',40,'D-','2',89,'A-','11',20,'E','1',89,'A-','11',45,'D','3',56,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',45,'D','3',78,'B','9',20,'E','1',78,'B','9',30,'E','1',35,'E','1',45,'D','3',78,'B','9',57,'C-','5'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'C+','7',89,'A-','11',78,'B','9',70,'B-','8',35,'E','1',30,'E','1',89,'A-','11',90,'A','12',78,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',45,'D','3',34,'E','1',76,'B','9',65,'C+','7',78,'B','9',45,'D','3',20,'E','1',30,'E','1',89,'A-','11'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_geo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_his`
--

DROP TABLE IF EXISTS `tbl_f1_his`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_his`
--

LOCK TABLES `tbl_f1_his` WRITE;
/*!40000 ALTER TABLE `tbl_f1_his` DISABLE KEYS */;
INSERT INTO `tbl_f1_his` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',78,'B','9',78,'B','9',34,'E','1',34,'E','1',66,'C+','7',23,'E','1',89,'A-','11',45,'D','3',45,'D','3'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'C+','7',76,'B','9',45,'D','3',55,'C-','5',90,'A','12',45,'D','3',89,'A-','11',78,'B','9',67,'C+','7'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',89,'A-','11',56,'C-','5',67,'C+','7',67,'C+','7',34,'E','1',56,'C-','5',67,'C+','7',89,'A-','11',78,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'E','1',55,'C-','5',89,'A-','11',89,'A-','11',67,'C+','7',67,'C+','7',67,'C+','7',89,'A-','11',45,'D','3'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_his` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_kis`
--

DROP TABLE IF EXISTS `tbl_f1_kis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_kis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_kis`
--

LOCK TABLES `tbl_f1_kis` WRITE;
/*!40000 ALTER TABLE `tbl_f1_kis` DISABLE KEYS */;
INSERT INTO `tbl_f1_kis` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'B-','8',67,'B+','10',67,'B+','10',67,'B+','10',35,'D+','4',45,'C','6',23,'E','1',55,'B-','8',76,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',50,'C+','7',78,'A','12',68,'B+','10',45,'C','6',56,'B-','8',34,'D','3',65,'B+','10',70,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',23,'E','1',34,'D','3',70,'A-','11',89,'A','12',40,'C-','5',78,'A','12',43,'C-','5',67,'B+','10',71,'A-','11'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',56,'B-','8',23,'E','1',65,'B+','10',56,'B-','8',76,'A','12',89,'A','12',54,'C+','7',63,'B','9',76,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_kis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_mat`
--

DROP TABLE IF EXISTS `tbl_f1_mat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_mat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_mat`
--

LOCK TABLES `tbl_f1_mat` WRITE;
/*!40000 ALTER TABLE `tbl_f1_mat` DISABLE KEYS */;
INSERT INTO `tbl_f1_mat` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',45,'B','9',23,'D+','4',89,'A','12',72,'A','12',40,'B-','8',51,'B+','10',89,'A','12',56,'A-','11',44,'B-','8'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'A','12',78,'A','12',34,'C','6',70,'A','12',45,'B','9',54,'B+','10',65,'A','12',23,'D+','4',67,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A','12',90,'A','12',23,'D+','4',67,'A','12',50,'B+','10',56,'A-','11',45,'B','9',43,'B-','8',67,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'C','6',34,'C','6',56,'A-','11',45,'B','9',52,'B+','10',67,'A','12',23,'D+','4',45,'B','9',89,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_mat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_phy`
--

DROP TABLE IF EXISTS `tbl_f1_phy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_phy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_phy`
--

LOCK TABLES `tbl_f1_phy` WRITE;
/*!40000 ALTER TABLE `tbl_f1_phy` DISABLE KEYS */;
INSERT INTO `tbl_f1_phy` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',56,'C+','7',89,'A','12',89,'A','12',43,'D+','4',30,'D-','2',89,'A','12',67,'B','9',30,'D-','2'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',89,'A','12',78,'A-','11',34,'D-','2',67,'B','9',44,'D+','4',76,'A-','11',34,'D-','2',34,'D-','2',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A-','11',45,'C-','5',55,'C+','7',60,'B-','8',56,'C+','7',56,'C+','7',56,'C+','7',89,'A','12',20,'E','1'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',70,'B+','10',67,'B','9',60,'B-','8',56,'C+','7',98,'A','12',55,'C+','7',67,'B','9',89,'A','12',67,'B','9'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_phy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t1_avg`
--

DROP TABLE IF EXISTS `tbl_f1_t1_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t1_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t1_avg`
--

LOCK TABLES `tbl_f1_t1_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t1_avg` DISABLE KEYS */;
INSERT INTO `tbl_f1_t1_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','57','C+',7,'63','B',9,'52','B+',10,'60','B-',8,'66','B',9,'67','B',9,'58','C-',5,'63','C',6,'29','E',1,'74','A-',11,'80','A',12,669,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','59','C+',7,'54','C+',7,'59','A-',11,'59','C+',7,'64','B-',8,'67','B',9,'47','D',3,'62','C',6,'58','C+',7,'55','B-',8,'71','B+',10,655,'B-',8),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','53','C',6,'42','C-',5,'63','A',12,'45','C-',5,'70','B+',10,'59','C+',7,'78','B',9,'70','B-',8,'81','A',12,'59','B-',8,'67','B',9,687,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','48','C-',5,'48','C',6,'41','B-',8,'43','D+',4,'75','A-',11,'65','B',9,'51','D+',4,'59','C-',5,'69','B',9,'59','B-',8,'65','B',9,623,'C+',7),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t1_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t1_ex1`
--

DROP TABLE IF EXISTS `tbl_f1_t1_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t1_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t1_ex1`
--

LOCK TABLES `tbl_f1_t1_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t1_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f1_t1_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','56','C+',7,'56','B-',8,'45','B',9,'56','C+',7,'65','B',9,'56','C+',7,'89','A-',11,'78','B',9,'23','E',1,'67','B+',10,'87','A',12,678,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','78','A-',11,'34','D',3,'67','A',12,'57','C+',7,'67','B',9,'89','A',12,'45','D',3,'67','C+',7,'67','B',9,'34','D',3,'88','A',12,693,'B-',8),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','45','C-',5,'23','E',1,'78','A',12,'34','D-',2,'56','C+',7,'78','A-',11,'67','C+',7,'89','A-',11,'78','A-',11,'78','A',12,'67','B',9,693,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'56','B-',8,'34','C',6,'33','D-',2,'50','C',6,'70','B+',10,'45','D',3,'34','E',1,'89','A',12,'89','A',12,'65','B',9,599,'C+',7),(8,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t1_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t1_ex2`
--

DROP TABLE IF EXISTS `tbl_f1_t1_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t1_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t1_ex2`
--

LOCK TABLES `tbl_f1_t1_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t1_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f1_t1_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','38','D',3,'67','B+',10,'23','D+',4,'67','B',9,'45','C-',5,'56','C+',7,'40','D-',2,'78','B',9,'34','D-',2,'90','A',12,'78','A-',11,616,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','67','B',9,'50','C+',7,'78','A',12,'60','B-',8,'49','C-',5,'78','A-',11,'78','B',9,'76','B',9,'32','D-',2,'67','B+',10,'60','B-',8,705,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','56','C+',7,'34','D',3,'90','A',12,'23','E',1,'89','A',12,'45','C-',5,'89','A-',11,'56','C-',5,'78','A-',11,'56','B-',8,'65','B',9,681,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','89','A',12,'23','E',1,'34','C',6,'45','C-',5,'87','A',12,'67','B',9,'34','E',1,'55','C-',5,'54','C',6,'45','C',6,'76','A-',11,609,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t1_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t1_ex3`
--

DROP TABLE IF EXISTS `tbl_f1_t1_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t1_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t1_ex3`
--

LOCK TABLES `tbl_f1_t1_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t1_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f1_t1_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','78','A-',11,'67','B+',10,'89','A',12,'57','C+',7,'90','A',12,'89','A',12,'45','D',3,'34','E',1,'30','D-',2,'67','B+',10,'78','A-',11,724,'A',13),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'78','A',12,'34','C',6,'60','B-',8,'78','A-',11,'34','D-',2,'20','E',1,'45','D',3,'76','A-',11,'65','B+',10,'56','C+',7,580,'B+',10),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','60','B-',8,'70','A-',11,'23','D+',4,'78','A-',11,'67','B',9,'55','C+',7,'78','B',9,'67','C+',7,'89','A',12,'45','C',6,'70','B+',10,702,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','23','E',1,'65','B+',10,'56','A-',11,'52','C',6,'88','A',12,'60','B-',8,'76','B',9,'89','A-',11,'66','B',9,'44','C-',5,'55','C+',7,664,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t1_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t2_avg`
--

DROP TABLE IF EXISTS `tbl_f1_t2_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t2_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t2_avg`
--

LOCK TABLES `tbl_f1_t2_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t2_avg` DISABLE KEYS */;
INSERT INTO `tbl_f1_t2_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','77','A-',11,'49','C',6,'54','B+',10,'25','E',1,'67','B',9,'54','C',6,'49','D',3,'41','D-',2,'53','C',6,'52','C+',7,'46','C-',5,567,'B',9),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','59','C+',7,'56','B-',8,'56','A-',11,'59','C+',7,'71','B+',10,'62','B-',8,'47','D',3,'63','C',6,'81','A',12,'65','B+',10,'72','B+',10,691,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','45','C-',5,'69','B+',10,'57','A-',11,'62','B-',8,'59','C+',7,'57','C+',7,'45','D',3,'52','D+',4,'67','B',9,'63','B',9,'78','A-',11,654,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','50','C',6,'73','A-',11,'54','B+',10,'63','B-',8,'41','D+',4,'69','B',9,'62','C',6,'74','B-',8,'67','B',9,'54','C+',7,'72','B+',10,677,'A',13),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t2_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t2_ex1`
--

DROP TABLE IF EXISTS `tbl_f1_t2_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t2_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t2_ex1`
--

LOCK TABLES `tbl_f1_t2_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t2_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f1_t2_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'67','B+',10,'72','A',12,'23','E',1,'78','A-',11,'89','A',12,'40','D-',2,'34','E',1,'77','A-',11,'63','B',9,'63','B-',8,648,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','56','C+',7,'68','B+',10,'70','A',12,'56','C+',7,'89','A',12,'67','B',9,'78','B',9,'55','C-',5,'65','B',9,'78','A',12,'40','D+',4,722,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','34','D-',2,'89','A',12,'67','A',12,'65','B',9,'45','C-',5,'60','B-',8,'70','B-',8,'67','C+',7,'45','C-',5,'67','B+',10,'78','A-',11,687,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','49','C-',5,'56','B-',8,'45','B',9,'67','B',9,'34','D-',2,'56','C+',7,'65','C+',7,'89','A-',11,'55','C+',7,'56','B-',8,'70','B+',10,642,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t2_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t2_ex2`
--

DROP TABLE IF EXISTS `tbl_f1_t2_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t2_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t2_ex2`
--

LOCK TABLES `tbl_f1_t2_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t2_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f1_t2_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','89','A',12,'35','D+',4,'40','B-',8,'34','D-',2,'78','A-',11,'43','D+',4,'89','A-',11,'66','C+',7,'38','D',3,'50','C+',7,'30','D-',2,592,'B+',10),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','78','A-',11,'45','C',6,'45','B',9,'43','D+',4,'90','A',12,'44','D+',4,'30','E',1,'90','A',12,'89','A',12,'51','C+',7,'90','A',12,694,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','67','B',9,'40','C-',5,'50','B+',10,'56','C+',7,'76','A-',11,'56','C+',7,'35','E',1,'34','E',1,'67','B',9,'54','C+',7,'67','B',9,602,'A-',11),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','56','C+',7,'76','A',12,'52','B+',10,'78','A-',11,'56','C+',7,'98','A',12,'78','B',9,'67','C+',7,'78','A-',11,'33','D',3,'80','A',12,752,'A',14),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t2_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t2_ex3`
--

DROP TABLE IF EXISTS `tbl_f1_t2_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t2_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t2_ex3`
--

LOCK TABLES `tbl_f1_t2_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t2_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f1_t2_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','98','A',12,'45','C',6,'51','B+',10,'20','E',1,'45','C-',5,'30','D-',2,'20','E',1,'23','E',1,'45','C-',5,'45','C',6,'50','C',6,472,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','45','C-',5,'56','B-',8,'54','B+',10,'78','A-',11,'34','D-',2,'76','A-',11,'35','E',1,'45','D',3,'89','A',12,'67','B+',10,'89','A',12,668,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','34','D-',2,'78','A',12,'56','A-',11,'65','B',9,'56','C+',7,'56','C+',7,'30','E',1,'56','C-',5,'89','A',12,'70','A-',11,'90','A',12,680,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','45','C-',5,'89','A',12,'67','A',12,'45','C-',5,'34','D-',2,'55','C+',7,'45','D',3,'67','C+',7,'70','B+',10,'75','A',12,'67','B',9,652,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t2_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t3_avg`
--

DROP TABLE IF EXISTS `tbl_f1_t3_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t3_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t3_avg`
--

LOCK TABLES `tbl_f1_t3_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t3_avg` DISABLE KEYS */;
INSERT INTO `tbl_f1_t3_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','52','C',6,'51','C+',7,'63','A',12,'41','D+',4,'73','B+',10,'62','B-',8,'63','C',6,'59','C-',5,'60','B-',8,'58','B-',8,'56','C+',7,638,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','37','D',3,'56','B-',8,'51','B+',10,'63','B-',8,'58','C+',7,'52','C',6,'60','C',6,'78','B',9,'85','A',12,'84','A',12,'66','B',9,690,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','54','C',6,'60','B',9,'51','B+',10,'84','A',12,'51','C',6,'55','C+',7,'85','A-',11,'78','B',9,'77','A-',11,'57','B-',8,'80','A',12,732,'A',14),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','30','D-',2,'64','B',9,'52','B+',10,'74','B+',10,'47','C-',5,'74','B+',10,'46','D',3,'67','C+',7,'54','C',6,'61','B',9,'48','C-',5,615,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t3_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t3_ex1`
--

DROP TABLE IF EXISTS `tbl_f1_t3_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t3_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t3_ex1`
--

LOCK TABLES `tbl_f1_t3_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t3_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f1_t3_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','67','B',9,'23','E',1,'89','A',12,'34','D-',2,'89','A',12,'89','A',12,'89','A-',11,'89','A-',11,'45','C-',5,'45','C',6,'41','D+',4,699,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'34','D',3,'65','A',12,'56','C+',7,'67','B',9,'34','D-',2,'45','D',3,'89','A-',11,'89','A',12,'98','A',12,'70','B+',10,681,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','56','C+',7,'43','C-',5,'45','B',9,'78','A-',11,'65','B',9,'56','C+',7,'89','A-',11,'67','C+',7,'90','A',12,'78','A',12,'80','A',12,747,'A',15),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'54','C+',7,'23','D+',4,'90','A',12,'64','B-',8,'67','B',9,'20','E',1,'67','C+',7,'30','D-',2,'67','B+',10,'40','D+',4,556,'B',9),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t3_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t3_ex2`
--

DROP TABLE IF EXISTS `tbl_f1_t3_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t3_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t3_ex2`
--

LOCK TABLES `tbl_f1_t3_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t3_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f1_t3_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'55','B-',8,'56','A-',11,'34','D-',2,'60','B-',8,'67','B',9,'45','D',3,'45','D',3,'80','A',12,'63','B',9,'80','A',12,630,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'65','B+',10,'23','D+',4,'67','B',9,'55','C+',7,'34','D-',2,'78','B',9,'78','B',9,'90','A',12,'67','B+',10,'75','A-',11,661,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','67','B',9,'67','B+',10,'43','B-',8,'89','A',12,'50','C',6,'89','A',12,'90','A',12,'89','A-',11,'76','A-',11,'34','D',3,'80','A',12,774,'A',15),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','23','E',1,'63','B',9,'45','B',9,'45','C-',5,'45','C-',5,'89','A',12,'30','E',1,'89','A-',11,'78','A-',11,'67','B+',10,'60','B-',8,634,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t3_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f1_t3_ex3`
--

DROP TABLE IF EXISTS `tbl_f1_t3_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f1_t3_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f1_t3_ex3`
--

LOCK TABLES `tbl_f1_t3_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f1_t3_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f1_t3_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'76','A',12,'44','B-',8,'56','C+',7,'70','B+',10,'30','D-',2,'56','C-',5,'45','D',3,'56','C+',7,'67','B+',10,'50','C',6,595,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','44','D+',4,'70','A-',11,'67','A',12,'67','B',9,'54','C',6,'89','A',12,'57','C-',5,'67','C+',7,'78','A-',11,'89','A',12,'60','B-',8,742,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','40','D+',4,'71','A-',11,'67','A',12,'87','A',12,'40','D+',4,'20','E',1,'78','B',9,'78','B',9,'67','B',9,'60','B',9,'80','A',12,688,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'76','A',12,'89','A',12,'88','A',12,'34','D-',2,'67','B',9,'89','A-',11,'45','D',3,'54','C',6,'50','C+',7,'45','C-',5,666,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f1_t3_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_agri`
--

DROP TABLE IF EXISTS `tbl_f2_agri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_agri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_agri`
--

LOCK TABLES `tbl_f2_agri` WRITE;
/*!40000 ALTER TABLE `tbl_f2_agri` DISABLE KEYS */;
INSERT INTO `tbl_f2_agri` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',87,'A','12',78,'A-','11',78,'A-','11',63,'B-','8',30,'D-','2',50,'C','6',41,'D+','4',80,'A','12',50,'C','6'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',88,'A','12',60,'B-','8',56,'C+','7',40,'D+','4',90,'A','12',89,'A','12',70,'B+','10',75,'A-','11',60,'B-','8'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'B','9',65,'B','9',70,'B+','10',78,'A-','11',67,'B','9',90,'A','12',80,'A','12',80,'A','12',80,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',65,'B','9',76,'A-','11',55,'C+','7',70,'B+','10',80,'A','12',67,'B','9',40,'D+','4',60,'B-','8',45,'C-','5'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_agri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_bio`
--

DROP TABLE IF EXISTS `tbl_f2_bio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_bio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_bio`
--

LOCK TABLES `tbl_f2_bio` WRITE;
/*!40000 ALTER TABLE `tbl_f2_bio` DISABLE KEYS */;
INSERT INTO `tbl_f2_bio` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',67,'B','9',57,'C+','7',23,'E','1',34,'D-','2',20,'E','1',34,'D-','2',34,'D-','2',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',57,'C+','7',60,'B-','8',60,'B-','8',56,'C+','7',43,'D+','4',78,'A-','11',56,'C+','7',67,'B','9',67,'B','9'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',34,'D-','2',23,'E','1',78,'A-','11',65,'B','9',56,'C+','7',65,'B','9',78,'A-','11',89,'A','12',87,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',33,'D-','2',45,'C-','5',52,'C','6',67,'B','9',78,'A-','11',45,'C-','5',90,'A','12',45,'C-','5',88,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_bio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_bus`
--

DROP TABLE IF EXISTS `tbl_f2_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_bus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_bus`
--

LOCK TABLES `tbl_f2_bus` WRITE;
/*!40000 ALTER TABLE `tbl_f2_bus` DISABLE KEYS */;
INSERT INTO `tbl_f2_bus` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',67,'B+','10',90,'A','12',67,'B+','10',63,'B','9',50,'C+','7',45,'C','6',45,'C','6',63,'B','9',67,'B+','10'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',67,'B+','10',65,'B+','10',78,'A','12',51,'C+','7',67,'B+','10',98,'A','12',67,'B+','10',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A','12',56,'B-','8',45,'C','6',67,'B+','10',54,'C+','7',70,'A-','11',78,'A','12',34,'D','3',60,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',89,'A','12',45,'C','6',44,'C-','5',56,'B-','8',33,'D','3',75,'A','12',67,'B+','10',67,'B+','10',50,'C+','7'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_chem`
--

DROP TABLE IF EXISTS `tbl_f2_chem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_chem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_chem`
--

LOCK TABLES `tbl_f2_chem` WRITE;
/*!40000 ALTER TABLE `tbl_f2_chem` DISABLE KEYS */;
INSERT INTO `tbl_f2_chem` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',65,'B','9',45,'C-','5',90,'A','12',78,'A-','11',78,'A-','11',45,'C-','5',89,'A','12',60,'B-','8',70,'B+','10'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B','9',49,'C-','5',78,'A-','11',89,'A','12',90,'A','12',34,'D-','2',67,'B','9',55,'C+','7',54,'C','6'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',56,'C+','7',89,'A','12',67,'B','9',45,'C-','5',76,'A-','11',56,'C+','7',65,'B','9',50,'C','6',40,'D+','4'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',50,'C','6',87,'A','12',88,'A','12',34,'D-','2',56,'C+','7',34,'D-','2',64,'B-','8',45,'C-','5',34,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_chem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_cre`
--

DROP TABLE IF EXISTS `tbl_f2_cre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_cre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_cre`
--

LOCK TABLES `tbl_f2_cre` WRITE;
/*!40000 ALTER TABLE `tbl_f2_cre` DISABLE KEYS */;
INSERT INTO `tbl_f2_cre` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',23,'E','1',34,'D-','2',30,'D-','2',77,'A-','11',38,'D','3',45,'C-','5',45,'C-','5',80,'A','12',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B','9',32,'D-','2',76,'A-','11',65,'B','9',89,'A','12',89,'A','12',89,'A','12',90,'A','12',78,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A-','11',78,'A-','11',89,'A','12',45,'C-','5',67,'B','9',89,'A','12',90,'A','12',76,'A-','11',67,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',89,'A','12',54,'C','6',66,'B','9',55,'C+','7',78,'A-','11',70,'B+','10',30,'D-','2',78,'A-','11',54,'C','6'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_cre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_eng`
--

DROP TABLE IF EXISTS `tbl_f2_eng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_eng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_eng`
--

LOCK TABLES `tbl_f2_eng` WRITE;
/*!40000 ALTER TABLE `tbl_f2_eng` DISABLE KEYS */;
INSERT INTO `tbl_f2_eng` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',38,'D','3',78,'A-','11',45,'C-','5',89,'A','12',98,'A','12',67,'B','9',45,'C-','5',45,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',78,'A-','11',67,'B','9',34,'D-','2',56,'C+','7',78,'A-','11',45,'C-','5',34,'D-','2',34,'D-','2',44,'D+','4'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',45,'C-','5',56,'C+','7',60,'B-','8',34,'D-','2',67,'B','9',34,'D-','2',56,'C+','7',67,'B','9',40,'D+','4'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'D-','2',89,'A','12',23,'E','1',49,'C-','5',56,'C+','7',45,'C-','5',34,'D-','2',23,'E','1',34,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_eng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_geo`
--

DROP TABLE IF EXISTS `tbl_f2_geo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_geo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_geo`
--

LOCK TABLES `tbl_f2_geo` WRITE;
/*!40000 ALTER TABLE `tbl_f2_geo` DISABLE KEYS */;
INSERT INTO `tbl_f2_geo` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',89,'A-','11',40,'D-','2',45,'D','3',40,'D-','2',89,'A-','11',20,'E','1',89,'A-','11',45,'D','3',56,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',45,'D','3',78,'B','9',20,'E','1',78,'B','9',30,'E','1',35,'E','1',45,'D','3',78,'B','9',57,'C-','5'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'C+','7',89,'A-','11',78,'B','9',70,'B-','8',35,'E','1',30,'E','1',89,'A-','11',90,'A','12',78,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',45,'D','3',34,'E','1',76,'B','9',65,'C+','7',78,'B','9',45,'D','3',20,'E','1',30,'E','1',89,'A-','11'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_geo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_his`
--

DROP TABLE IF EXISTS `tbl_f2_his`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_his`
--

LOCK TABLES `tbl_f2_his` WRITE;
/*!40000 ALTER TABLE `tbl_f2_his` DISABLE KEYS */;
INSERT INTO `tbl_f2_his` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',78,'B','9',78,'B','9',34,'E','1',34,'E','1',66,'C+','7',23,'E','1',89,'A-','11',45,'D','3',45,'D','3'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'C+','7',76,'B','9',45,'D','3',55,'C-','5',90,'A','12',45,'D','3',89,'A-','11',78,'B','9',67,'C+','7'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',89,'A-','11',56,'C-','5',67,'C+','7',67,'C+','7',34,'E','1',56,'C-','5',67,'C+','7',89,'A-','11',78,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'E','1',55,'C-','5',89,'A-','11',89,'A-','11',67,'C+','7',67,'C+','7',67,'C+','7',89,'A-','11',45,'D','3'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_his` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_kis`
--

DROP TABLE IF EXISTS `tbl_f2_kis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_kis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_kis`
--

LOCK TABLES `tbl_f2_kis` WRITE;
/*!40000 ALTER TABLE `tbl_f2_kis` DISABLE KEYS */;
INSERT INTO `tbl_f2_kis` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'B-','8',67,'B+','10',67,'B+','10',67,'B+','10',35,'D+','4',45,'C','6',23,'E','1',55,'B-','8',76,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',50,'C+','7',78,'A','12',68,'B+','10',45,'C','6',56,'B-','8',34,'D','3',65,'B+','10',70,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',23,'E','1',34,'D','3',70,'A-','11',89,'A','12',40,'C-','5',78,'A','12',43,'C-','5',67,'B+','10',71,'A-','11'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',56,'B-','8',23,'E','1',65,'B+','10',56,'B-','8',76,'A','12',89,'A','12',54,'C+','7',63,'B','9',76,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_kis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_mat`
--

DROP TABLE IF EXISTS `tbl_f2_mat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_mat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_mat`
--

LOCK TABLES `tbl_f2_mat` WRITE;
/*!40000 ALTER TABLE `tbl_f2_mat` DISABLE KEYS */;
INSERT INTO `tbl_f2_mat` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',45,'B','9',23,'D+','4',89,'A','12',72,'A','12',40,'B-','8',51,'B+','10',89,'A','12',56,'A-','11',44,'B-','8'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'A','12',78,'A','12',34,'C','6',70,'A','12',45,'B','9',54,'B+','10',65,'A','12',23,'D+','4',67,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A','12',90,'A','12',23,'D+','4',67,'A','12',50,'B+','10',56,'A-','11',45,'B','9',43,'B-','8',67,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'C','6',34,'C','6',56,'A-','11',45,'B','9',52,'B+','10',67,'A','12',23,'D+','4',45,'B','9',89,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_mat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_phy`
--

DROP TABLE IF EXISTS `tbl_f2_phy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_phy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_phy`
--

LOCK TABLES `tbl_f2_phy` WRITE;
/*!40000 ALTER TABLE `tbl_f2_phy` DISABLE KEYS */;
INSERT INTO `tbl_f2_phy` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',56,'C+','7',89,'A','12',89,'A','12',43,'D+','4',30,'D-','2',89,'A','12',67,'B','9',30,'D-','2'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',89,'A','12',78,'A-','11',34,'D-','2',67,'B','9',44,'D+','4',76,'A-','11',34,'D-','2',34,'D-','2',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A-','11',45,'C-','5',55,'C+','7',60,'B-','8',56,'C+','7',56,'C+','7',56,'C+','7',89,'A','12',20,'E','1'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',70,'B+','10',67,'B','9',60,'B-','8',56,'C+','7',98,'A','12',55,'C+','7',67,'B','9',89,'A','12',67,'B','9'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_phy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t1_avg`
--

DROP TABLE IF EXISTS `tbl_f2_t1_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t1_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t1_avg`
--

LOCK TABLES `tbl_f2_t1_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t1_avg` DISABLE KEYS */;
INSERT INTO `tbl_f2_t1_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','57','C+',7,'63','B',9,'52','B+',10,'60','B-',8,'66','B',9,'67','B',9,'58','C-',5,'63','C',6,'29','E',1,'74','A-',11,'80','A',12,669,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','59','C+',7,'54','C+',7,'59','A-',11,'59','C+',7,'64','B-',8,'67','B',9,'47','D',3,'62','C',6,'58','C+',7,'55','B-',8,'71','B+',10,655,'B-',8),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','53','C',6,'42','C-',5,'63','A',12,'45','C-',5,'70','B+',10,'59','C+',7,'78','B',9,'70','B-',8,'81','A',12,'59','B-',8,'67','B',9,687,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','48','C-',5,'48','C',6,'41','B-',8,'43','D+',4,'75','A-',11,'65','B',9,'51','D+',4,'59','C-',5,'69','B',9,'59','B-',8,'65','B',9,623,'C+',7),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t1_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t1_ex1`
--

DROP TABLE IF EXISTS `tbl_f2_t1_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t1_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t1_ex1`
--

LOCK TABLES `tbl_f2_t1_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t1_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f2_t1_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','56','C+',7,'56','B-',8,'45','B',9,'56','C+',7,'65','B',9,'56','C+',7,'89','A-',11,'78','B',9,'23','E',1,'67','B+',10,'87','A',12,678,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','78','A-',11,'34','D',3,'67','A',12,'57','C+',7,'67','B',9,'89','A',12,'45','D',3,'67','C+',7,'67','B',9,'34','D',3,'88','A',12,693,'B-',8),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','45','C-',5,'23','E',1,'78','A',12,'34','D-',2,'56','C+',7,'78','A-',11,'67','C+',7,'89','A-',11,'78','A-',11,'78','A',12,'67','B',9,693,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'56','B-',8,'34','C',6,'33','D-',2,'50','C',6,'70','B+',10,'45','D',3,'34','E',1,'89','A',12,'89','A',12,'65','B',9,599,'C+',7),(8,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t1_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t1_ex2`
--

DROP TABLE IF EXISTS `tbl_f2_t1_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t1_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t1_ex2`
--

LOCK TABLES `tbl_f2_t1_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t1_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f2_t1_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','38','D',3,'67','B+',10,'23','D+',4,'67','B',9,'45','C-',5,'56','C+',7,'40','D-',2,'78','B',9,'34','D-',2,'90','A',12,'78','A-',11,616,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','67','B',9,'50','C+',7,'78','A',12,'60','B-',8,'49','C-',5,'78','A-',11,'78','B',9,'76','B',9,'32','D-',2,'67','B+',10,'60','B-',8,705,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','56','C+',7,'34','D',3,'90','A',12,'23','E',1,'89','A',12,'45','C-',5,'89','A-',11,'56','C-',5,'78','A-',11,'56','B-',8,'65','B',9,681,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','89','A',12,'23','E',1,'34','C',6,'45','C-',5,'87','A',12,'67','B',9,'34','E',1,'55','C-',5,'54','C',6,'45','C',6,'76','A-',11,609,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t1_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t1_ex3`
--

DROP TABLE IF EXISTS `tbl_f2_t1_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t1_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t1_ex3`
--

LOCK TABLES `tbl_f2_t1_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t1_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f2_t1_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','78','A-',11,'67','B+',10,'89','A',12,'57','C+',7,'90','A',12,'89','A',12,'45','D',3,'34','E',1,'30','D-',2,'67','B+',10,'78','A-',11,724,'A',13),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'78','A',12,'34','C',6,'60','B-',8,'78','A-',11,'34','D-',2,'20','E',1,'45','D',3,'76','A-',11,'65','B+',10,'56','C+',7,580,'B+',10),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','60','B-',8,'70','A-',11,'23','D+',4,'78','A-',11,'67','B',9,'55','C+',7,'78','B',9,'67','C+',7,'89','A',12,'45','C',6,'70','B+',10,702,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','23','E',1,'65','B+',10,'56','A-',11,'52','C',6,'88','A',12,'60','B-',8,'76','B',9,'89','A-',11,'66','B',9,'44','C-',5,'55','C+',7,664,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t1_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t2_avg`
--

DROP TABLE IF EXISTS `tbl_f2_t2_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t2_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t2_avg`
--

LOCK TABLES `tbl_f2_t2_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t2_avg` DISABLE KEYS */;
INSERT INTO `tbl_f2_t2_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','77','A-',11,'49','C',6,'54','B+',10,'25','E',1,'67','B',9,'54','C',6,'49','D',3,'41','D-',2,'53','C',6,'52','C+',7,'46','C-',5,567,'B',9),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','59','C+',7,'56','B-',8,'56','A-',11,'59','C+',7,'71','B+',10,'62','B-',8,'47','D',3,'63','C',6,'81','A',12,'65','B+',10,'72','B+',10,691,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','45','C-',5,'69','B+',10,'57','A-',11,'62','B-',8,'59','C+',7,'57','C+',7,'45','D',3,'52','D+',4,'67','B',9,'63','B',9,'78','A-',11,654,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','50','C',6,'73','A-',11,'54','B+',10,'63','B-',8,'41','D+',4,'69','B',9,'62','C',6,'74','B-',8,'67','B',9,'54','C+',7,'72','B+',10,677,'A',13),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t2_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t2_ex1`
--

DROP TABLE IF EXISTS `tbl_f2_t2_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t2_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t2_ex1`
--

LOCK TABLES `tbl_f2_t2_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t2_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f2_t2_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'67','B+',10,'72','A',12,'23','E',1,'78','A-',11,'89','A',12,'40','D-',2,'34','E',1,'77','A-',11,'63','B',9,'63','B-',8,648,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','56','C+',7,'68','B+',10,'70','A',12,'56','C+',7,'89','A',12,'67','B',9,'78','B',9,'55','C-',5,'65','B',9,'78','A',12,'40','D+',4,722,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','34','D-',2,'89','A',12,'67','A',12,'65','B',9,'45','C-',5,'60','B-',8,'70','B-',8,'67','C+',7,'45','C-',5,'67','B+',10,'78','A-',11,687,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','49','C-',5,'56','B-',8,'45','B',9,'67','B',9,'34','D-',2,'56','C+',7,'65','C+',7,'89','A-',11,'55','C+',7,'56','B-',8,'70','B+',10,642,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t2_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t2_ex2`
--

DROP TABLE IF EXISTS `tbl_f2_t2_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t2_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t2_ex2`
--

LOCK TABLES `tbl_f2_t2_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t2_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f2_t2_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','89','A',12,'35','D+',4,'40','B-',8,'34','D-',2,'78','A-',11,'43','D+',4,'89','A-',11,'66','C+',7,'38','D',3,'50','C+',7,'30','D-',2,592,'B+',10),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','78','A-',11,'45','C',6,'45','B',9,'43','D+',4,'90','A',12,'44','D+',4,'30','E',1,'90','A',12,'89','A',12,'51','C+',7,'90','A',12,694,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','67','B',9,'40','C-',5,'50','B+',10,'56','C+',7,'76','A-',11,'56','C+',7,'35','E',1,'34','E',1,'67','B',9,'54','C+',7,'67','B',9,602,'A-',11),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','56','C+',7,'76','A',12,'52','B+',10,'78','A-',11,'56','C+',7,'98','A',12,'78','B',9,'67','C+',7,'78','A-',11,'33','D',3,'80','A',12,752,'A',14),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t2_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t2_ex3`
--

DROP TABLE IF EXISTS `tbl_f2_t2_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t2_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t2_ex3`
--

LOCK TABLES `tbl_f2_t2_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t2_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f2_t2_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','98','A',12,'45','C',6,'51','B+',10,'20','E',1,'45','C-',5,'30','D-',2,'20','E',1,'23','E',1,'45','C-',5,'45','C',6,'50','C',6,472,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','45','C-',5,'56','B-',8,'54','B+',10,'78','A-',11,'34','D-',2,'76','A-',11,'35','E',1,'45','D',3,'89','A',12,'67','B+',10,'89','A',12,668,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','34','D-',2,'78','A',12,'56','A-',11,'65','B',9,'56','C+',7,'56','C+',7,'30','E',1,'56','C-',5,'89','A',12,'70','A-',11,'90','A',12,680,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','45','C-',5,'89','A',12,'67','A',12,'45','C-',5,'34','D-',2,'55','C+',7,'45','D',3,'67','C+',7,'70','B+',10,'75','A',12,'67','B',9,652,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t2_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t3_avg`
--

DROP TABLE IF EXISTS `tbl_f2_t3_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t3_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t3_avg`
--

LOCK TABLES `tbl_f2_t3_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t3_avg` DISABLE KEYS */;
INSERT INTO `tbl_f2_t3_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','52','C',6,'51','C+',7,'63','A',12,'41','D+',4,'73','B+',10,'62','B-',8,'63','C',6,'59','C-',5,'60','B-',8,'58','B-',8,'56','C+',7,638,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','37','D',3,'56','B-',8,'51','B+',10,'63','B-',8,'58','C+',7,'52','C',6,'60','C',6,'78','B',9,'85','A',12,'84','A',12,'66','B',9,690,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','54','C',6,'60','B',9,'51','B+',10,'84','A',12,'51','C',6,'55','C+',7,'85','A-',11,'78','B',9,'77','A-',11,'57','B-',8,'80','A',12,732,'A',14),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','30','D-',2,'64','B',9,'52','B+',10,'74','B+',10,'47','C-',5,'74','B+',10,'46','D',3,'67','C+',7,'54','C',6,'61','B',9,'48','C-',5,615,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t3_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t3_ex1`
--

DROP TABLE IF EXISTS `tbl_f2_t3_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t3_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t3_ex1`
--

LOCK TABLES `tbl_f2_t3_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t3_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f2_t3_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','67','B',9,'23','E',1,'89','A',12,'34','D-',2,'89','A',12,'89','A',12,'89','A-',11,'89','A-',11,'45','C-',5,'45','C',6,'41','D+',4,699,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'34','D',3,'65','A',12,'56','C+',7,'67','B',9,'34','D-',2,'45','D',3,'89','A-',11,'89','A',12,'98','A',12,'70','B+',10,681,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','56','C+',7,'43','C-',5,'45','B',9,'78','A-',11,'65','B',9,'56','C+',7,'89','A-',11,'67','C+',7,'90','A',12,'78','A',12,'80','A',12,747,'A',15),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'54','C+',7,'23','D+',4,'90','A',12,'64','B-',8,'67','B',9,'20','E',1,'67','C+',7,'30','D-',2,'67','B+',10,'40','D+',4,556,'B',9),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t3_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t3_ex2`
--

DROP TABLE IF EXISTS `tbl_f2_t3_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t3_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t3_ex2`
--

LOCK TABLES `tbl_f2_t3_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t3_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f2_t3_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'55','B-',8,'56','A-',11,'34','D-',2,'60','B-',8,'67','B',9,'45','D',3,'45','D',3,'80','A',12,'63','B',9,'80','A',12,630,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'65','B+',10,'23','D+',4,'67','B',9,'55','C+',7,'34','D-',2,'78','B',9,'78','B',9,'90','A',12,'67','B+',10,'75','A-',11,661,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','67','B',9,'67','B+',10,'43','B-',8,'89','A',12,'50','C',6,'89','A',12,'90','A',12,'89','A-',11,'76','A-',11,'34','D',3,'80','A',12,774,'A',15),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','23','E',1,'63','B',9,'45','B',9,'45','C-',5,'45','C-',5,'89','A',12,'30','E',1,'89','A-',11,'78','A-',11,'67','B+',10,'60','B-',8,634,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t3_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f2_t3_ex3`
--

DROP TABLE IF EXISTS `tbl_f2_t3_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f2_t3_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f2_t3_ex3`
--

LOCK TABLES `tbl_f2_t3_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f2_t3_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f2_t3_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'76','A',12,'44','B-',8,'56','C+',7,'70','B+',10,'30','D-',2,'56','C-',5,'45','D',3,'56','C+',7,'67','B+',10,'50','C',6,595,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','44','D+',4,'70','A-',11,'67','A',12,'67','B',9,'54','C',6,'89','A',12,'57','C-',5,'67','C+',7,'78','A-',11,'89','A',12,'60','B-',8,742,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','40','D+',4,'71','A-',11,'67','A',12,'87','A',12,'40','D+',4,'20','E',1,'78','B',9,'78','B',9,'67','B',9,'60','B',9,'80','A',12,688,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'76','A',12,'89','A',12,'88','A',12,'34','D-',2,'67','B',9,'89','A-',11,'45','D',3,'54','C',6,'50','C+',7,'45','C-',5,666,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f2_t3_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_agri`
--

DROP TABLE IF EXISTS `tbl_f3_agri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_agri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_agri`
--

LOCK TABLES `tbl_f3_agri` WRITE;
/*!40000 ALTER TABLE `tbl_f3_agri` DISABLE KEYS */;
INSERT INTO `tbl_f3_agri` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',69,'B','9',78,'A-','11',89,'A','12',78,'A-','11',34,'D-','2',56,'C+','7',23,'E','1',55,'C+','7',90,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',78,'A-','11',56,'C+','7',78,'A-','11',45,'C-','5',67,'B','9',78,'A-','11',56,'C+','7',78,'A-','11',78,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',90,'A','12',90,'A','12',45,'C-','5',49,'C-','5',23,'E','1',45,'C-','5',89,'A','12',34,'D-','2',56,'C+','7'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',78,'A-','11',89,'A','12',12,'E','1',90,'A','12',89,'A','12',34,'D-','2',89,'A','12',56,'C+','7',77,'A-','11'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_agri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_bio`
--

DROP TABLE IF EXISTS `tbl_f3_bio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_bio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_bio`
--

LOCK TABLES `tbl_f3_bio` WRITE;
/*!40000 ALTER TABLE `tbl_f3_bio` DISABLE KEYS */;
INSERT INTO `tbl_f3_bio` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',78,'A-','11',87,'A','12',23,'E','1',56,'C+','7',67,'B','9',78,'A-','11',12,'E','1',56,'C+','7',34,'D-','2'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D-','2',56,'C+','7',23,'E','1',89,'A','12',67,'B','9',34,'D-','2',89,'A','12',90,'A','12',45,'C-','5'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'B','9',45,'C-','5',45,'C-','5',99,'A','12',88,'A','12',67,'B','9',67,'B','9',56,'C+','7',29,'E','1'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',66,'B','9',34,'D-','2',67,'B','9',67,'B','9',56,'C+','7',45,'C-','5',78,'A-','11',87,'A','12',30,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_bio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_bus`
--

DROP TABLE IF EXISTS `tbl_f3_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_bus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_bus`
--

LOCK TABLES `tbl_f3_bus` WRITE;
/*!40000 ALTER TABLE `tbl_f3_bus` DISABLE KEYS */;
INSERT INTO `tbl_f3_bus` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',67,'B+','10',67,'B+','10',56,'B-','8',93,'A','12',87,'A','12',67,'B+','10',56,'B-','8',67,'B+','10',78,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',89,'A','12',40,'C-','5',34,'D','3',88,'A','12',66,'B+','10',89,'A','12',90,'A','12',34,'D','3'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',23,'E','1',78,'A','12',67,'B+','10',56,'B-','8',80,'A','12',89,'A','12',90,'A','12',23,'E','1',89,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',78,'A','12',67,'B+','10',34,'D','3',89,'A','12',78,'A','12',30,'D','3',45,'C','6',89,'A','12',90,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_chem`
--

DROP TABLE IF EXISTS `tbl_f3_chem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_chem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_chem`
--

LOCK TABLES `tbl_f3_chem` WRITE;
/*!40000 ALTER TABLE `tbl_f3_chem` DISABLE KEYS */;
INSERT INTO `tbl_f3_chem` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',89,'A','12',90,'A','12',34,'D-','2',98,'A','12',67,'B','9',34,'D-','2',34,'D-','2',78,'A-','11',78,'A-','11'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',45,'C-','5',67,'B','9',44,'D+','4',77,'A-','11',76,'A-','11',56,'C+','7',67,'B','9',67,'B','9',34,'D-','2'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',34,'D-','2',56,'C+','7',55,'C+','7',56,'C+','7',45,'C-','5',78,'A-','11',89,'A','12',45,'C-','5',67,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',23,'E','1',45,'C-','5',78,'A-','11',45,'C-','5',98,'A','12',89,'A','12',45,'C-','5',34,'D-','2',78,'A-','11'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_chem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_cre`
--

DROP TABLE IF EXISTS `tbl_f3_cre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_cre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_cre`
--

LOCK TABLES `tbl_f3_cre` WRITE;
/*!40000 ALTER TABLE `tbl_f3_cre` DISABLE KEYS */;
INSERT INTO `tbl_f3_cre` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',78,'A-','11',34,'D-','2',91,'A','12',55,'C+','7',90,'A','12',78,'A-','11',34,'D-','2',89,'A','12',30,'D-','2'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',56,'C+','7',45,'C-','5',56,'C+','7',56,'C+','7',92,'A','12',45,'C-','5',78,'A-','11',87,'A','12',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',55,'C+','7',56,'C+','7',50,'C','6',57,'C+','7',89,'A','12',70,'B+','10',89,'A','12',56,'C+','7',39,'D','3'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',23,'E','1',77,'A-','11',54,'C','6',78,'A-','11',56,'C+','7',56,'C+','7',30,'D-','2',78,'A-','11',40,'D+','4'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_cre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_eng`
--

DROP TABLE IF EXISTS `tbl_f3_eng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_eng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_eng`
--

LOCK TABLES `tbl_f3_eng` WRITE;
/*!40000 ALTER TABLE `tbl_f3_eng` DISABLE KEYS */;
INSERT INTO `tbl_f3_eng` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',68,'B','9',56,'C+','7',98,'A','12',56,'C+','7',23,'E','1',98,'A','12',34,'D-','2',75,'A-','11',90,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',12,'E','1',45,'C-','5',15,'E','1',89,'A','12',45,'C-','5',19,'E','1',10,'E','1',67,'B','9',56,'C+','7'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',12,'E','1',23,'E','1',12,'E','1',98,'A','12',76,'A-','11',13,'E','1',14,'E','1',10,'E','1',57,'C+','7'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',99,'A','12',67,'B','9',99,'A','12',34,'D-','2',77,'A-','11',99,'A','12',99,'A','12',32,'D-','2',58,'C+','7'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_eng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_geo`
--

DROP TABLE IF EXISTS `tbl_f3_geo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_geo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_geo`
--

LOCK TABLES `tbl_f3_geo` WRITE;
/*!40000 ALTER TABLE `tbl_f3_geo` DISABLE KEYS */;
INSERT INTO `tbl_f3_geo` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',89,'A-','11',67,'C+','7',67,'C+','7',89,'A-','11',45,'D','3',54,'D+','4',60,'C','6',80,'B+','10',89,'A-','11'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',56,'C-','5',89,'A-','11',89,'A-','11',34,'E','1',44,'D-','2',43,'D-','2',65,'C+','7',65,'C+','7',12,'E','1'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',34,'E','1',32,'E','1',45,'D','3',67,'C+','7',89,'A-','11',40,'D-','2',70,'B-','8',63,'C','6',23,'E','1'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'E','1',98,'A','12',34,'E','1',23,'E','1',56,'C-','5',81,'B+','10',75,'B','9',78,'B','9',20,'E','1'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_geo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_his`
--

DROP TABLE IF EXISTS `tbl_f3_his`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_his`
--

LOCK TABLES `tbl_f3_his` WRITE;
/*!40000 ALTER TABLE `tbl_f3_his` DISABLE KEYS */;
INSERT INTO `tbl_f3_his` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',45,'D','3',60,'C','6',87,'A-','11',89,'A-','11',67,'C+','7',76,'B','9',45,'D','3',45,'D','3',56,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',50,'D+','4',40,'D-','2',33,'E','1',30,'E','1',57,'C-','5',77,'B','9',44,'D-','2',90,'A','12',89,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',56,'C-','5',78,'B','9',34,'E','1',89,'A-','11',50,'D+','4',78,'B','9',89,'A-','11',67,'C+','7',90,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',57,'C-','5',34,'E','1',35,'E','1',80,'B+','10',45,'D','3',89,'A-','11',88,'A-','11',34,'E','1',54,'D+','4'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_his` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_kis`
--

DROP TABLE IF EXISTS `tbl_f3_kis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_kis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_kis`
--

LOCK TABLES `tbl_f3_kis` WRITE;
/*!40000 ALTER TABLE `tbl_f3_kis` DISABLE KEYS */;
INSERT INTO `tbl_f3_kis` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',99,'A','12',88,'A','12',77,'A','12',66,'B+','10',55,'B-','8',44,'C-','5',33,'D','3',22,'E','1',11,'E','1'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',11,'E','1',22,'E','1',33,'D','3',44,'C-','5',55,'B-','8',66,'B+','10',77,'A','12',88,'A','12',99,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',99,'A','12',88,'A','12',77,'A','12',66,'B+','10',55,'B-','8',44,'C-','5',33,'D','3',22,'E','1',11,'E','1'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',11,'E','1',22,'E','1',33,'D','3',44,'C-','5',55,'B-','8',66,'B+','10',77,'A','12',88,'A','12',99,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_kis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_mat`
--

DROP TABLE IF EXISTS `tbl_f3_mat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_mat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_mat`
--

LOCK TABLES `tbl_f3_mat` WRITE;
/*!40000 ALTER TABLE `tbl_f3_mat` DISABLE KEYS */;
INSERT INTO `tbl_f3_mat` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',99,'A','12',66,'A','12',99,'A','12',66,'A','12',99,'A','12',66,'A','12',99,'A','12',66,'A','12',99,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',88,'A','12',77,'A','12',88,'A','12',77,'A','12',88,'A','12',77,'A','12',88,'A','12',77,'A','12',88,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',77,'A','12',88,'A','12',77,'A','12',88,'A','12',77,'A','12',88,'A','12',77,'A','12',88,'A','12',77,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',66,'A','12',99,'A','12',66,'A','12',99,'A','12',99,'A','12',99,'A','12',66,'A','12',99,'A','12',66,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_mat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_phy`
--

DROP TABLE IF EXISTS `tbl_f3_phy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_phy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_phy`
--

LOCK TABLES `tbl_f3_phy` WRITE;
/*!40000 ALTER TABLE `tbl_f3_phy` DISABLE KEYS */;
INSERT INTO `tbl_f3_phy` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',67,'B','9',90,'A','12',90,'A','12',90,'A','12',39,'D','3',23,'E','1',34,'D-','2',40,'D+','4',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D-','2',78,'A-','11',78,'A-','11',34,'D-','2',89,'A','12',44,'D+','4',45,'C-','5',89,'A','12',87,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',23,'E','1',56,'C+','7',45,'C-','5',37,'D','3',90,'A','12',45,'C-','5',67,'B','9',44,'D+','4',34,'D-','2'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',67,'B','9',45,'C-','5',45,'C-','5',89,'A','12',67,'B','9',56,'C+','7',89,'A','12',67,'B','9',56,'C+','7'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_phy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t1_avg`
--

DROP TABLE IF EXISTS `tbl_f3_t1_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t1_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t1_avg`
--

LOCK TABLES `tbl_f3_t1_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t1_avg` DISABLE KEYS */;
INSERT INTO `tbl_f3_t1_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','74','B+',10,'88','A',12,'88','A',12,'62','B-',8,'71','B+',10,'82','A',12,'74','B-',8,'64','C',6,'67','B',9,'63','B',9,'78','A-',12,811,'B+',10),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','24','E',1,'22','E',1,'84','A',12,'37','D',3,'52','C',6,'63','B-',8,'78','B',9,'41','D-',2,'52','C',6,'54','C+',7,'70','B+',11,577,'C',6),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','15','E',1,'88','A',12,'80','A',12,'52','C',6,'48','C-',5,'41','D+',4,'37','E',1,'56','C-',5,'53','C',6,'56','B-',8,'75','A-',5,601,'C',6),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','88','A',12,'22','E',1,'77','A',12,'55','C+',7,'48','C-',5,'52','C',6,'55','C-',5,'42','D-',2,'51','C',6,'59','B-',8,'59','C+',7,608,'C+',7),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t1_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t1_ex1`
--

DROP TABLE IF EXISTS `tbl_f3_t1_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t1_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t1_ex1`
--

LOCK TABLES `tbl_f3_t1_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t1_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f3_t1_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',68,'B',9,99,'A',12,99,'A',12,87,'A',12,89,'A',12,67,'B',9,89,'A-',11,45,'D',3,78,'A-',11,67,'B+',10,69,'B',9,857,'B+',10),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',12,'E',1,11,'E',1,88,'A',12,56,'C+',7,45,'C-',5,34,'D-',2,56,'C-',5,50,'D+',4,56,'C+',7,34,'D',3,78,'A-',11,520,'C-',5),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',12,'E',1,99,'A',12,77,'A',12,45,'C-',5,34,'D-',2,23,'E',1,34,'E',1,56,'C-',5,55,'C+',7,23,'E',1,90,'A',12,548,'C-',5),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',99,'A',12,11,'E',1,66,'A',12,66,'B',9,23,'E',1,67,'B',9,34,'E',1,57,'C-',5,23,'E',1,78,'A',12,78,'A-',11,602,'C+',7),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t1_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t1_ex2`
--

DROP TABLE IF EXISTS `tbl_f3_t1_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t1_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t1_ex2`
--

LOCK TABLES `tbl_f3_t1_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t1_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f3_t1_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+',7,88,'A',12,66,'A',12,87,'A',12,90,'A',12,90,'A',12,67,'C+',7,60,'C',6,34,'D-',2,67,'B+',10,78,'A-',11,783,'A',15),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',45,'C-',5,22,'E',1,77,'A',12,56,'C+',7,67,'B',9,78,'A-',11,89,'A-',11,40,'D-',2,45,'C-',5,89,'A',12,56,'C+',7,664,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',23,'E',1,88,'A',12,88,'A',12,45,'C-',5,56,'C+',7,56,'C+',7,32,'E',1,78,'B',9,56,'C+',7,78,'A',12,90,'A',12,690,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',67,'B',9,22,'E',1,99,'A',12,34,'D-',2,45,'C-',5,45,'C-',5,98,'A',12,34,'E',1,77,'A-',11,67,'B+',10,89,'A',12,677,'A-',11),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t1_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t1_ex3`
--

DROP TABLE IF EXISTS `tbl_f3_t1_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t1_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(5) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t1_ex3`
--

LOCK TABLES `tbl_f3_t1_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t1_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f3_t1_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',98,'A',12,77,'A',12,99,'A',12,23,'E',1,34,'D-',2,90,'A',12,67,'C+',7,87,'A-',11,91,'A',12,56,'B-',8,89,'A',12,811,'B',9),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',15,'E',1,33,'D',3,88,'A',12,23,'E',1,44,'D+',4,78,'A-',11,89,'A-',11,33,'E',1,56,'C+',7,40,'C-',5,78,'A-',11,577,'C',6),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',12,'E',1,77,'A',12,77,'A',12,45,'C-',5,55,'C+',7,45,'C-',5,45,'D',3,34,'E',1,50,'C',6,67,'B+',10,45,'C-',5,552,'C',6),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',99,'A',12,33,'D',3,66,'A',12,67,'B',9,78,'A-',11,45,'C-',5,34,'E',1,35,'E',1,54,'C',6,34,'D',3,12,'E',1,557,'C',6),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t1_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t2_avg`
--

DROP TABLE IF EXISTS `tbl_f3_t2_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t2_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t2_avg`
--

LOCK TABLES `tbl_f3_t2_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t2_avg` DISABLE KEYS */;
INSERT INTO `tbl_f3_t2_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','36','D',3,'55','B-',8,'77','A',12,'67','B',9,'66','B',9,'50','C',6,'62','C',6,'77','B',9,'74','B+',10,'82','A',12,'56','C+',7,702,'A',13),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','11','E',1,'55','B-',8,'80','A',12,'63','B-',8,'69','B',9,'55','C+',7,'40','D-',2,'54','D+',4,'64','B-',8,'62','B',9,'63','B-',8,616,'A-',11),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','8','E',1,'55','B-',8,'84','A',12,'84','A',12,'59','C+',7,'57','C+',7,'65','C+',7,'72','B-',8,'72','B+',10,'75','A',12,'39','D',3,670,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','70','B+',10,'55','B-',8,'99','A',12,'56','C+',7,'77','A-',11,'70','B+',10,'53','D+',4,'71','B-',8,'63','B-',8,'65','B+',10,'71','B+',10,NULL,NULL,NULL),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t2_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t2_ex1`
--

DROP TABLE IF EXISTS `tbl_f3_t2_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t2_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` int(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t2_ex1`
--

LOCK TABLES `tbl_f3_t2_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t2_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f3_t2_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+',7,66,'B+',10,66,'A',12,56,'C+',7,98,'A',12,90,'A',12,89,'A-',11,89,'A-',11,55,'C+',7,93,'A',12,78,'A-',11,836,0,16),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',89,'A',12,44,'C-',5,77,'A',12,89,'A',12,77,'A-',11,34,'D-',2,34,'E',1,30,'E',1,56,'C+',7,34,'D',3,45,'C-',5,609,0,10),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',98,'A',12,66,'B+',10,88,'A',12,99,'A',12,56,'C+',7,37,'D',3,67,'C+',7,89,'A-',11,57,'C+',7,56,'B-',8,49,'C-',5,762,0,13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'D-',2,44,'C-',5,99,'A',12,67,'B',9,45,'C-',5,89,'A',12,23,'E',1,80,'B+',10,78,'A-',11,89,'A',12,90,'A',12,738,0,13),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t2_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t2_ex2`
--

DROP TABLE IF EXISTS `tbl_f3_t2_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t2_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t2_ex2`
--

LOCK TABLES `tbl_f3_t2_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t2_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f3_t2_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',23,'E',1,55,'B-',8,99,'A',12,67,'B',9,67,'B',9,39,'D',3,45,'D',3,67,'C+',7,90,'A',12,87,'A',12,34,'D-',2,673,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',45,'C-',5,55,'B-',8,88,'A',12,67,'B',9,76,'A-',11,89,'A',12,44,'D-',2,57,'C-',5,92,'A',12,88,'A',12,67,'B',9,768,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',76,'A-',11,55,'B-',8,77,'A',12,88,'A',12,45,'C-',5,90,'A',12,89,'A-',11,50,'D+',4,89,'A',12,80,'A',12,23,'E',1,762,'A',14),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',77,'A-',11,55,'B-',8,99,'A',12,56,'C+',7,98,'A',12,67,'B',9,56,'C-',5,45,'D',3,56,'C+',7,78,'A',12,89,'A',12,776,'A',14),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t2_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t2_ex3`
--

DROP TABLE IF EXISTS `tbl_f3_t2_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t2_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t2_ex3`
--

LOCK TABLES `tbl_f3_t2_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t2_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f3_t2_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',98,'A',12,44,'C-',5,66,'A',12,78,'A-',11,34,'D-',2,23,'E',1,54,'D+',4,76,'B',9,78,'A-',11,67,'B+',10,56,'C+',7,674,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',19,'E',1,66,'B+',10,77,'A',12,34,'D-',2,56,'C+',7,44,'D+',4,43,'D-',2,77,'B',9,45,'C-',5,66,'B+',10,78,'A-',11,605,'B+',10),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',13,'E',1,44,'C-',5,88,'A',12,67,'B',9,78,'A-',11,45,'C-',5,40,'D-',2,78,'B',9,70,'B+',10,89,'A',12,45,'C-',5,657,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',99,'A',12,66,'B+',10,99,'A',12,45,'C-',5,89,'A',12,56,'C+',7,81,'B+',10,89,'A-',11,56,'C+',7,30,'D',3,34,'D-',2,NULL,NULL,NULL),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t2_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t3_avg`
--

DROP TABLE IF EXISTS `tbl_f3_t3_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t3_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(5) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t3_avg`
--

LOCK TABLES `tbl_f3_t3_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t3_avg` DISABLE KEYS */;
INSERT INTO `tbl_f3_t3_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','66','B',9,'22','E',1,'88','A',12,'34','D-',2,'63','B-',8,'43','D+',4,'76','B',9,'48','D',3,'51','C',6,'67','B+',10,'186','A',12,744,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','44','D+',4,'88','A',12,'84','A',12,'74','B+',10,'56','C+',7,'73','B+',10,'47','D',3,'74','B-',8,'84','A',12,'71','A-',11,'70','B+',10,765,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','27','E',1,'22','E',1,'80','A',12,'50','C',6,'67','B',9,'48','C-',5,'52','D+',4,'82','B+',10,'61','B-',8,'67','B+',10,'59','C+',7,615,'B+',10),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','63','B-',8,'88','A',12,'77','A',12,'65','B',9,'52','C',6,'70','B+',10,'57','C-',5,'58','C-',5,'49','C-',5,'74','A-',11,'74','B+',10,NULL,NULL,NULL),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t3_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t3_ex1`
--

DROP TABLE IF EXISTS `tbl_f3_t3_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t3_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t3_ex1`
--

LOCK TABLES `tbl_f3_t3_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t3_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f3_t3_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',34,'D-',2,33,'D',3,99,'A',12,12,'E',1,34,'D-',2,34,'D-',2,60,'C',6,45,'D',3,34,'D-',2,56,'B-',8,23,'E',1,464,'C',6),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',10,'E',1,77,'A',12,88,'A',12,89,'A',12,67,'B',9,45,'C-',5,65,'C+',7,44,'D-',2,78,'A-',11,89,'A',12,56,'C+',7,708,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',14,'E',1,33,'D',3,77,'A',12,67,'B',9,89,'A',12,67,'B',9,70,'B-',8,89,'A-',11,89,'A',12,90,'A',12,89,'A',12,774,'A',14),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',99,'A',12,77,'A',12,66,'A',12,78,'A-',11,45,'C-',5,89,'A',12,75,'B',9,88,'A-',11,30,'D-',2,45,'C',6,89,'A',12,781,'A',15),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t3_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t3_ex2`
--

DROP TABLE IF EXISTS `tbl_f3_t3_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t3_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t3_ex2`
--

LOCK TABLES `tbl_f3_t3_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t3_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f3_t3_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',75,'A-',11,22,'E',1,66,'A',12,56,'C+',7,78,'A-',11,40,'D+',4,80,'B+',10,45,'D',3,89,'A',12,67,'B+',10,55,'C+',7,673,'A',13),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B',9,88,'A',12,77,'A',12,90,'A',12,67,'B',9,89,'A',12,65,'C+',7,90,'A',12,87,'A',12,90,'A',12,78,'A-',11,888,'A',17),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',10,'E',1,22,'E',1,88,'A',12,56,'C+',7,45,'C-',5,44,'D+',4,63,'C',6,67,'C+',7,56,'C+',7,23,'E',1,34,'D-',2,508,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',32,'D-',2,88,'A',12,99,'A',12,87,'A',12,34,'D-',2,67,'B',9,78,'B',9,34,'E',1,78,'A-',11,89,'A',12,56,'C+',7,742,'A',13),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t3_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f3_t3_ex3`
--

DROP TABLE IF EXISTS `tbl_f3_t3_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f3_t3_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` int(2) DEFAULT NULL,
  `engg` varchar(2) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` int(2) DEFAULT NULL,
  `kisg` varchar(2) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` int(2) DEFAULT NULL,
  `matg` varchar(2) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` int(2) DEFAULT NULL,
  `biog` varchar(2) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` int(2) DEFAULT NULL,
  `chemg` varchar(2) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` int(2) DEFAULT NULL,
  `phyg` varchar(2) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` int(2) DEFAULT NULL,
  `geog` varchar(2) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` int(2) DEFAULT NULL,
  `hisg` varchar(2) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` int(2) DEFAULT NULL,
  `creg` varchar(2) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` int(2) DEFAULT NULL,
  `busg` varchar(2) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` int(2) DEFAULT NULL,
  `agrig` varchar(2) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f3_t3_ex3`
--

LOCK TABLES `tbl_f3_t3_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f3_t3_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f3_t3_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',90,'A',12,11,'E',1,99,'A',12,34,'D-',2,78,'A-',11,56,'C+',7,89,'A-',11,56,'C-',5,30,'D-',2,78,'A',12,90,'A',12,711,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',56,'C+',7,99,'A',12,88,'A',12,45,'C-',5,34,'D-',2,87,'A',12,12,'E',1,89,'A-',11,89,'A',12,34,'D',3,78,'A-',11,711,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',57,'C+',7,11,'E',1,77,'A',12,29,'E',1,67,'B',9,34,'D-',2,23,'E',1,90,'A',12,39,'D',3,89,'A',12,56,'C+',7,572,'B+',10),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',58,'C+',7,99,'A',12,66,'A',12,30,'D-',2,78,'A-',11,56,'C+',7,20,'E',1,54,'D+',4,40,'D+',4,90,'A',12,77,'A-',11,NULL,NULL,NULL),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f3_t3_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_agri`
--

DROP TABLE IF EXISTS `tbl_f4_agri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_agri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_agri`
--

LOCK TABLES `tbl_f4_agri` WRITE;
/*!40000 ALTER TABLE `tbl_f4_agri` DISABLE KEYS */;
INSERT INTO `tbl_f4_agri` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',87,'A','12',78,'A-','11',78,'A-','11',63,'B-','8',30,'D-','2',50,'C','6',41,'D+','4',80,'A','12',50,'C','6'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',88,'A','12',60,'B-','8',56,'C+','7',40,'D+','4',90,'A','12',89,'A','12',70,'B+','10',75,'A-','11',60,'B-','8'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'B','9',65,'B','9',70,'B+','10',78,'A-','11',67,'B','9',90,'A','12',80,'A','12',80,'A','12',80,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',65,'B','9',76,'A-','11',55,'C+','7',70,'B+','10',80,'A','12',67,'B','9',40,'D+','4',60,'B-','8',45,'C-','5'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_agri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_bio`
--

DROP TABLE IF EXISTS `tbl_f4_bio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_bio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_bio`
--

LOCK TABLES `tbl_f4_bio` WRITE;
/*!40000 ALTER TABLE `tbl_f4_bio` DISABLE KEYS */;
INSERT INTO `tbl_f4_bio` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',67,'B','9',57,'C+','7',23,'E','1',34,'D-','2',20,'E','1',34,'D-','2',34,'D-','2',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',57,'C+','7',60,'B-','8',60,'B-','8',56,'C+','7',43,'D+','4',78,'A-','11',56,'C+','7',67,'B','9',67,'B','9'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',34,'D-','2',23,'E','1',78,'A-','11',65,'B','9',56,'C+','7',65,'B','9',78,'A-','11',89,'A','12',87,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',33,'D-','2',45,'C-','5',52,'C','6',67,'B','9',78,'A-','11',45,'C-','5',90,'A','12',45,'C-','5',88,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_bio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_bus`
--

DROP TABLE IF EXISTS `tbl_f4_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_bus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_bus`
--

LOCK TABLES `tbl_f4_bus` WRITE;
/*!40000 ALTER TABLE `tbl_f4_bus` DISABLE KEYS */;
INSERT INTO `tbl_f4_bus` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',67,'B+','10',90,'A','12',67,'B+','10',63,'B','9',50,'C+','7',45,'C','6',45,'C','6',63,'B','9',67,'B+','10'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',67,'B+','10',65,'B+','10',78,'A','12',51,'C+','7',67,'B+','10',98,'A','12',67,'B+','10',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A','12',56,'B-','8',45,'C','6',67,'B+','10',54,'C+','7',70,'A-','11',78,'A','12',34,'D','3',60,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',89,'A','12',45,'C','6',44,'C-','5',56,'B-','8',33,'D','3',75,'A','12',67,'B+','10',67,'B+','10',50,'C+','7'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_chem`
--

DROP TABLE IF EXISTS `tbl_f4_chem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_chem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_chem`
--

LOCK TABLES `tbl_f4_chem` WRITE;
/*!40000 ALTER TABLE `tbl_f4_chem` DISABLE KEYS */;
INSERT INTO `tbl_f4_chem` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',65,'B','9',45,'C-','5',90,'A','12',78,'A-','11',78,'A-','11',45,'C-','5',89,'A','12',60,'B-','8',70,'B+','10'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B','9',49,'C-','5',78,'A-','11',89,'A','12',90,'A','12',34,'D-','2',67,'B','9',55,'C+','7',54,'C','6'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',56,'C+','7',89,'A','12',67,'B','9',45,'C-','5',76,'A-','11',56,'C+','7',65,'B','9',50,'C','6',40,'D+','4'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',50,'C','6',87,'A','12',88,'A','12',34,'D-','2',56,'C+','7',34,'D-','2',64,'B-','8',45,'C-','5',34,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_chem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_cre`
--

DROP TABLE IF EXISTS `tbl_f4_cre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_cre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_cre`
--

LOCK TABLES `tbl_f4_cre` WRITE;
/*!40000 ALTER TABLE `tbl_f4_cre` DISABLE KEYS */;
INSERT INTO `tbl_f4_cre` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',23,'E','1',34,'D-','2',30,'D-','2',77,'A-','11',38,'D','3',45,'C-','5',45,'C-','5',80,'A','12',56,'C+','7'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'B','9',32,'D-','2',76,'A-','11',65,'B','9',89,'A','12',89,'A','12',89,'A','12',90,'A','12',78,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A-','11',78,'A-','11',89,'A','12',45,'C-','5',67,'B','9',89,'A','12',90,'A','12',76,'A-','11',67,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',89,'A','12',54,'C','6',66,'B','9',55,'C+','7',78,'A-','11',70,'B+','10',30,'D-','2',78,'A-','11',54,'C','6'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_cre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_eng`
--

DROP TABLE IF EXISTS `tbl_f4_eng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_eng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_eng`
--

LOCK TABLES `tbl_f4_eng` WRITE;
/*!40000 ALTER TABLE `tbl_f4_eng` DISABLE KEYS */;
INSERT INTO `tbl_f4_eng` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',38,'D','3',78,'A-','11',45,'C-','5',89,'A','12',98,'A','12',67,'B','9',45,'C-','5',45,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',78,'A-','11',67,'B','9',34,'D-','2',56,'C+','7',78,'A-','11',45,'C-','5',34,'D-','2',34,'D-','2',44,'D+','4'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',45,'C-','5',56,'C+','7',60,'B-','8',34,'D-','2',67,'B','9',34,'D-','2',56,'C+','7',67,'B','9',40,'D+','4'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'D-','2',89,'A','12',23,'E','1',49,'C-','5',56,'C+','7',45,'C-','5',34,'D-','2',23,'E','1',34,'D-','2'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_eng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_geo`
--

DROP TABLE IF EXISTS `tbl_f4_geo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_geo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_geo`
--

LOCK TABLES `tbl_f4_geo` WRITE;
/*!40000 ALTER TABLE `tbl_f4_geo` DISABLE KEYS */;
INSERT INTO `tbl_f4_geo` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',89,'A-','11',40,'D-','2',45,'D','3',40,'D-','2',89,'A-','11',20,'E','1',89,'A-','11',45,'D','3',56,'C-','5'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',45,'D','3',78,'B','9',20,'E','1',78,'B','9',30,'E','1',35,'E','1',45,'D','3',78,'B','9',57,'C-','5'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',67,'C+','7',89,'A-','11',78,'B','9',70,'B-','8',35,'E','1',30,'E','1',89,'A-','11',90,'A','12',78,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',45,'D','3',34,'E','1',76,'B','9',65,'C+','7',78,'B','9',45,'D','3',20,'E','1',30,'E','1',89,'A-','11'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_geo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_his`
--

DROP TABLE IF EXISTS `tbl_f4_his`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_his`
--

LOCK TABLES `tbl_f4_his` WRITE;
/*!40000 ALTER TABLE `tbl_f4_his` DISABLE KEYS */;
INSERT INTO `tbl_f4_his` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',78,'B','9',78,'B','9',34,'E','1',34,'E','1',66,'C+','7',23,'E','1',89,'A-','11',45,'D','3',45,'D','3'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'C+','7',76,'B','9',45,'D','3',55,'C-','5',90,'A','12',45,'D','3',89,'A-','11',78,'B','9',67,'C+','7'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',89,'A-','11',56,'C-','5',67,'C+','7',67,'C+','7',34,'E','1',56,'C-','5',67,'C+','7',89,'A-','11',78,'B','9'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'E','1',55,'C-','5',89,'A-','11',89,'A-','11',67,'C+','7',67,'C+','7',67,'C+','7',89,'A-','11',45,'D','3'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_his` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_kis`
--

DROP TABLE IF EXISTS `tbl_f4_kis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_kis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_kis`
--

LOCK TABLES `tbl_f4_kis` WRITE;
/*!40000 ALTER TABLE `tbl_f4_kis` DISABLE KEYS */;
INSERT INTO `tbl_f4_kis` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'B-','8',67,'B+','10',67,'B+','10',67,'B+','10',35,'D+','4',45,'C','6',23,'E','1',55,'B-','8',76,'A','12'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',34,'D','3',50,'C+','7',78,'A','12',68,'B+','10',45,'C','6',56,'B-','8',34,'D','3',65,'B+','10',70,'A-','11'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',23,'E','1',34,'D','3',70,'A-','11',89,'A','12',40,'C-','5',78,'A','12',43,'C-','5',67,'B+','10',71,'A-','11'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',56,'B-','8',23,'E','1',65,'B+','10',56,'B-','8',76,'A','12',89,'A','12',54,'C+','7',63,'B','9',76,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_kis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_mat`
--

DROP TABLE IF EXISTS `tbl_f4_mat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_mat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_mat`
--

LOCK TABLES `tbl_f4_mat` WRITE;
/*!40000 ALTER TABLE `tbl_f4_mat` DISABLE KEYS */;
INSERT INTO `tbl_f4_mat` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',45,'B','9',23,'D+','4',89,'A','12',72,'A','12',40,'B-','8',51,'B+','10',89,'A','12',56,'A-','11',44,'B-','8'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',67,'A','12',78,'A','12',34,'C','6',70,'A','12',45,'B','9',54,'B+','10',65,'A','12',23,'D+','4',67,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A','12',90,'A','12',23,'D+','4',67,'A','12',50,'B+','10',56,'A-','11',45,'B','9',43,'B-','8',67,'A','12'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',34,'C','6',34,'C','6',56,'A-','11',45,'B','9',52,'B+','10',67,'A','12',23,'D+','4',45,'B','9',89,'A','12'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_mat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_phy`
--

DROP TABLE IF EXISTS `tbl_f4_phy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_phy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `ex1` int(50) DEFAULT NULL,
  `g1` varchar(100) DEFAULT NULL,
  `p1` varchar(100) DEFAULT NULL,
  `ex2` int(50) DEFAULT NULL,
  `g2` varchar(100) DEFAULT NULL,
  `p2` varchar(100) DEFAULT NULL,
  `ex3` int(50) DEFAULT NULL,
  `g3` varchar(100) DEFAULT NULL,
  `p3` varchar(100) DEFAULT NULL,
  `ex4` int(50) DEFAULT NULL,
  `g4` varchar(100) DEFAULT NULL,
  `p4` varchar(100) DEFAULT NULL,
  `ex5` int(50) DEFAULT NULL,
  `g5` varchar(100) DEFAULT NULL,
  `p5` varchar(100) DEFAULT NULL,
  `ex6` int(50) DEFAULT NULL,
  `g6` varchar(100) DEFAULT NULL,
  `p6` varchar(100) DEFAULT NULL,
  `ex7` int(50) DEFAULT NULL,
  `g7` varchar(100) DEFAULT NULL,
  `p7` varchar(100) DEFAULT NULL,
  `ex8` int(50) DEFAULT NULL,
  `g8` varchar(100) DEFAULT NULL,
  `p8` varchar(100) DEFAULT NULL,
  `ex9` int(50) DEFAULT NULL,
  `g9` varchar(100) DEFAULT NULL,
  `p9` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_phy`
--

LOCK TABLES `tbl_f4_phy` WRITE;
/*!40000 ALTER TABLE `tbl_f4_phy` DISABLE KEYS */;
INSERT INTO `tbl_f4_phy` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1',56,'C+','7',56,'C+','7',89,'A','12',89,'A','12',43,'D+','4',30,'D-','2',89,'A','12',67,'B','9',30,'D-','2'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1',89,'A','12',78,'A-','11',34,'D-','2',67,'B','9',44,'D+','4',76,'A-','11',34,'D-','2',34,'D-','2',89,'A','12'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',78,'A-','11',45,'C-','5',55,'C+','7',60,'B-','8',56,'C+','7',56,'C+','7',56,'C+','7',89,'A','12',20,'E','1'),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2',70,'B+','10',67,'B','9',60,'B-','8',56,'C+','7',98,'A','12',55,'C+','7',67,'B','9',89,'A','12',67,'B','9'),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_phy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t1_avg`
--

DROP TABLE IF EXISTS `tbl_f4_t1_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t1_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t1_avg`
--

LOCK TABLES `tbl_f4_t1_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t1_avg` DISABLE KEYS */;
INSERT INTO `tbl_f4_t1_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','57','C+',7,'63','B',9,'52','B+',10,'60','B-',8,'66','B',9,'67','B',9,'58','C-',5,'63','C',6,'29','E',1,'74','A-',11,'80','A',12,669,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','59','C+',7,'54','C+',7,'59','A-',11,'59','C+',7,'64','B-',8,'67','B',9,'47','D',3,'62','C',6,'58','C+',7,'55','B-',8,'71','B+',10,655,'B-',8),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','53','C',6,'42','C-',5,'63','A',12,'45','C-',5,'70','B+',10,'59','C+',7,'78','B',9,'70','B-',8,'81','A',12,'59','B-',8,'67','B',9,687,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','48','C-',5,'48','C',6,'41','B-',8,'43','D+',4,'75','A-',11,'65','B',9,'51','D+',4,'59','C-',5,'69','B',9,'59','B-',8,'65','B',9,623,'C+',7),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t1_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t1_ex1`
--

DROP TABLE IF EXISTS `tbl_f4_t1_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t1_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t1_ex1`
--

LOCK TABLES `tbl_f4_t1_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t1_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f4_t1_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','56','C+',7,'56','B-',8,'45','B',9,'56','C+',7,'65','B',9,'56','C+',7,'89','A-',11,'78','B',9,'23','E',1,'67','B+',10,'87','A',12,678,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','78','A-',11,'34','D',3,'67','A',12,'57','C+',7,'67','B',9,'89','A',12,'45','D',3,'67','C+',7,'67','B',9,'34','D',3,'88','A',12,693,'B-',8),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','45','C-',5,'23','E',1,'78','A',12,'34','D-',2,'56','C+',7,'78','A-',11,'67','C+',7,'89','A-',11,'78','A-',11,'78','A',12,'67','B',9,693,'B-',8),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'56','B-',8,'34','C',6,'33','D-',2,'50','C',6,'70','B+',10,'45','D',3,'34','E',1,'89','A',12,'89','A',12,'65','B',9,599,'C+',7),(8,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t1_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t1_ex2`
--

DROP TABLE IF EXISTS `tbl_f4_t1_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t1_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t1_ex2`
--

LOCK TABLES `tbl_f4_t1_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t1_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f4_t1_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','38','D',3,'67','B+',10,'23','D+',4,'67','B',9,'45','C-',5,'56','C+',7,'40','D-',2,'78','B',9,'34','D-',2,'90','A',12,'78','A-',11,616,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','67','B',9,'50','C+',7,'78','A',12,'60','B-',8,'49','C-',5,'78','A-',11,'78','B',9,'76','B',9,'32','D-',2,'67','B+',10,'60','B-',8,705,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','56','C+',7,'34','D',3,'90','A',12,'23','E',1,'89','A',12,'45','C-',5,'89','A-',11,'56','C-',5,'78','A-',11,'56','B-',8,'65','B',9,681,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','89','A',12,'23','E',1,'34','C',6,'45','C-',5,'87','A',12,'67','B',9,'34','E',1,'55','C-',5,'54','C',6,'45','C',6,'76','A-',11,609,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t1_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t1_ex3`
--

DROP TABLE IF EXISTS `tbl_f4_t1_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t1_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t1_ex3`
--

LOCK TABLES `tbl_f4_t1_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t1_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f4_t1_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','78','A-',11,'67','B+',10,'89','A',12,'57','C+',7,'90','A',12,'89','A',12,'45','D',3,'34','E',1,'30','D-',2,'67','B+',10,'78','A-',11,724,'A',13),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'78','A',12,'34','C',6,'60','B-',8,'78','A-',11,'34','D-',2,'20','E',1,'45','D',3,'76','A-',11,'65','B+',10,'56','C+',7,580,'B+',10),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','60','B-',8,'70','A-',11,'23','D+',4,'78','A-',11,'67','B',9,'55','C+',7,'78','B',9,'67','C+',7,'89','A',12,'45','C',6,'70','B+',10,702,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','23','E',1,'65','B+',10,'56','A-',11,'52','C',6,'88','A',12,'60','B-',8,'76','B',9,'89','A-',11,'66','B',9,'44','C-',5,'55','C+',7,664,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t1_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t2_avg`
--

DROP TABLE IF EXISTS `tbl_f4_t2_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t2_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t2_avg`
--

LOCK TABLES `tbl_f4_t2_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t2_avg` DISABLE KEYS */;
INSERT INTO `tbl_f4_t2_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','77','A-',11,'49','C',6,'54','B+',10,'25','E',1,'67','B',9,'54','C',6,'49','D',3,'41','D-',2,'53','C',6,'52','C+',7,'46','C-',5,567,'B',9),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','59','C+',7,'56','B-',8,'56','A-',11,'59','C+',7,'71','B+',10,'62','B-',8,'47','D',3,'63','C',6,'81','A',12,'65','B+',10,'72','B+',10,691,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','45','C-',5,'69','B+',10,'57','A-',11,'62','B-',8,'59','C+',7,'57','C+',7,'45','D',3,'52','D+',4,'67','B',9,'63','B',9,'78','A-',11,654,'A',12),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','50','C',6,'73','A-',11,'54','B+',10,'63','B-',8,'41','D+',4,'69','B',9,'62','C',6,'74','B-',8,'67','B',9,'54','C+',7,'72','B+',10,677,'A',13),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t2_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t2_ex1`
--

DROP TABLE IF EXISTS `tbl_f4_t2_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t2_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t2_ex1`
--

LOCK TABLES `tbl_f4_t2_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t2_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f4_t2_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'67','B+',10,'72','A',12,'23','E',1,'78','A-',11,'89','A',12,'40','D-',2,'34','E',1,'77','A-',11,'63','B',9,'63','B-',8,648,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','56','C+',7,'68','B+',10,'70','A',12,'56','C+',7,'89','A',12,'67','B',9,'78','B',9,'55','C-',5,'65','B',9,'78','A',12,'40','D+',4,722,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','34','D-',2,'89','A',12,'67','A',12,'65','B',9,'45','C-',5,'60','B-',8,'70','B-',8,'67','C+',7,'45','C-',5,'67','B+',10,'78','A-',11,687,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','49','C-',5,'56','B-',8,'45','B',9,'67','B',9,'34','D-',2,'56','C+',7,'65','C+',7,'89','A-',11,'55','C+',7,'56','B-',8,'70','B+',10,642,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t2_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t2_ex2`
--

DROP TABLE IF EXISTS `tbl_f4_t2_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t2_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t2_ex2`
--

LOCK TABLES `tbl_f4_t2_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t2_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f4_t2_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','89','A',12,'35','D+',4,'40','B-',8,'34','D-',2,'78','A-',11,'43','D+',4,'89','A-',11,'66','C+',7,'38','D',3,'50','C+',7,'30','D-',2,592,'B+',10),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','78','A-',11,'45','C',6,'45','B',9,'43','D+',4,'90','A',12,'44','D+',4,'30','E',1,'90','A',12,'89','A',12,'51','C+',7,'90','A',12,694,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','56','C+',7,'76','A',12,'52','B+',10,'78','A-',11,'56','C+',7,'98','A',12,'78','B',9,'67','C+',7,'78','A-',11,'33','D',3,'80','A',12,752,'A',14),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t2_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t2_ex3`
--

DROP TABLE IF EXISTS `tbl_f4_t2_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t2_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t2_ex3`
--

LOCK TABLES `tbl_f4_t2_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t2_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f4_t2_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','98','A',12,'45','C',6,'51','B+',10,'20','E',1,'45','C-',5,'30','D-',2,'20','E',1,'23','E',1,'45','C-',5,'45','C',6,'50','C',6,472,'B-',8),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','45','C-',5,'56','B-',8,'54','B+',10,'78','A-',11,'34','D-',2,'76','A-',11,'35','E',1,'45','D',3,'89','A',12,'67','B+',10,'89','A',12,668,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','34','D-',2,'78','A',12,'56','A-',11,'65','B',9,'56','C+',7,'56','C+',7,'30','E',1,'56','C-',5,'89','A',12,'70','A-',11,'90','A',12,680,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','45','C-',5,'89','A',12,'67','A',12,'45','C-',5,'34','D-',2,'55','C+',7,'45','D',3,'67','C+',7,'70','B+',10,'75','A',12,'67','B',9,652,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t2_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t3_avg`
--

DROP TABLE IF EXISTS `tbl_f4_t3_avg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t3_avg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t3_avg`
--

LOCK TABLES `tbl_f4_t3_avg` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t3_avg` DISABLE KEYS */;
INSERT INTO `tbl_f4_t3_avg` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','52','C',6,'51','C+',7,'63','A',12,'41','D+',4,'73','B+',10,'62','B-',8,'63','C',6,'59','C-',5,'60','B-',8,'58','B-',8,'56','C+',7,638,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','37','D',3,'56','B-',8,'51','B+',10,'63','B-',8,'58','C+',7,'52','C',6,'60','C',6,'78','B',9,'85','A',12,'84','A',12,'66','B',9,690,'A',13),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','54','C',6,'60','B',9,'51','B+',10,'84','A',12,'51','C',6,'55','C+',7,'85','A-',11,'78','B',9,'77','A-',11,'57','B-',8,'80','A',12,732,'A',14),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','30','D-',2,'64','B',9,'52','B+',10,'74','B+',10,'47','C-',5,'74','B+',10,'46','D',3,'67','C+',7,'54','C',6,'61','B',9,'48','C-',5,615,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t3_avg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t3_ex1`
--

DROP TABLE IF EXISTS `tbl_f4_t3_ex1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t3_ex1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t3_ex1`
--

LOCK TABLES `tbl_f4_t3_ex1` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t3_ex1` DISABLE KEYS */;
INSERT INTO `tbl_f4_t3_ex1` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','67','B',9,'23','E',1,'89','A',12,'34','D-',2,'89','A',12,'89','A',12,'89','A-',11,'89','A-',11,'45','C-',5,'45','C',6,'41','D+',4,699,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'34','D',3,'65','A',12,'56','C+',7,'67','B',9,'34','D-',2,'45','D',3,'89','A-',11,'89','A',12,'98','A',12,'70','B+',10,681,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','56','C+',7,'43','C-',5,'45','B',9,'78','A-',11,'65','B',9,'56','C+',7,'89','A-',11,'67','C+',7,'90','A',12,'78','A',12,'80','A',12,747,'A',15),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'54','C+',7,'23','D+',4,'90','A',12,'64','B-',8,'67','B',9,'20','E',1,'67','C+',7,'30','D-',2,'67','B+',10,'40','D+',4,556,'B',9),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t3_ex1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t3_ex2`
--

DROP TABLE IF EXISTS `tbl_f4_t3_ex2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t3_ex2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t3_ex2`
--

LOCK TABLES `tbl_f4_t3_ex2` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t3_ex2` DISABLE KEYS */;
INSERT INTO `tbl_f4_t3_ex2` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'55','B-',8,'56','A-',11,'34','D-',2,'60','B-',8,'67','B',9,'45','D',3,'45','D',3,'80','A',12,'63','B',9,'80','A',12,630,'A',12),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','34','D-',2,'65','B+',10,'23','D+',4,'67','B',9,'55','C+',7,'34','D-',2,'78','B',9,'78','B',9,'90','A',12,'67','B+',10,'75','A-',11,661,'A',12),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','67','B',9,'67','B+',10,'43','B-',8,'89','A',12,'50','C',6,'89','A',12,'90','A',12,'89','A-',11,'76','A-',11,'34','D',3,'80','A',12,774,'A',15),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','23','E',1,'63','B',9,'45','B',9,'45','C-',5,'45','C-',5,'89','A',12,'30','E',1,'89','A-',11,'78','A-',11,'67','B+',10,'60','B-',8,634,'A',12),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t3_ex2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_f4_t3_ex3`
--

DROP TABLE IF EXISTS `tbl_f4_t3_ex3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_f4_t3_ex3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `eng` varchar(100) DEFAULT NULL,
  `engg` varchar(100) DEFAULT NULL,
  `p1` int(2) DEFAULT NULL,
  `kis` varchar(100) DEFAULT NULL,
  `kisg` varchar(100) DEFAULT NULL,
  `p2` int(2) DEFAULT NULL,
  `mat` varchar(100) DEFAULT NULL,
  `matg` varchar(100) DEFAULT NULL,
  `p3` int(2) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `biog` varchar(100) DEFAULT NULL,
  `p4` int(2) DEFAULT NULL,
  `chem` varchar(100) DEFAULT NULL,
  `chemg` varchar(100) DEFAULT NULL,
  `p5` int(2) DEFAULT NULL,
  `phy` varchar(100) DEFAULT NULL,
  `phyg` varchar(100) DEFAULT NULL,
  `p6` int(2) DEFAULT NULL,
  `geo` varchar(100) DEFAULT NULL,
  `geog` varchar(100) DEFAULT NULL,
  `p7` int(2) DEFAULT NULL,
  `his` varchar(100) DEFAULT NULL,
  `hisg` varchar(100) DEFAULT NULL,
  `p8` int(2) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `creg` varchar(100) DEFAULT NULL,
  `p9` int(2) DEFAULT NULL,
  `bus` varchar(100) DEFAULT NULL,
  `busg` varchar(100) DEFAULT NULL,
  `p10` int(2) DEFAULT NULL,
  `agri` varchar(100) DEFAULT NULL,
  `agrig` varchar(100) DEFAULT NULL,
  `p11` int(2) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `pt` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_f4_t3_ex3`
--

LOCK TABLES `tbl_f4_t3_ex3` WRITE;
/*!40000 ALTER TABLE `tbl_f4_t3_ex3` DISABLE KEYS */;
INSERT INTO `tbl_f4_t3_ex3` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','45','C-',5,'76','A',12,'44','B-',8,'56','C+',7,'70','B+',10,'30','D-',2,'56','C-',5,'45','D',3,'56','C+',7,'67','B+',10,'50','C',6,595,'A-',11),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','44','D+',4,'70','A-',11,'67','A',12,'67','B',9,'54','C',6,'89','A',12,'57','C-',5,'67','C+',7,'78','A-',11,'89','A',12,'60','B-',8,742,'A',14),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','40','D+',4,'71','A-',11,'67','A',12,'87','A',12,'40','D+',4,'20','E',1,'78','B',9,'78','B',9,'67','B',9,'60','B',9,'80','A',12,688,'A',13),(4,'004','AZAM','CARBONATED','DRINK','340','FORM_2','34','D-',2,'76','A',12,'89','A',12,'88','A',12,'34','D-',2,'67','B',9,'89','A-',11,'45','D',3,'54','C',6,'50','C+',7,'45','C-',5,666,'A-',11),(5,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_f4_t3_ex3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_grades`
--

DROP TABLE IF EXISTS `tbl_grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_grades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(100) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `A` varchar(100) DEFAULT NULL,
  `Aminus` varchar(100) DEFAULT NULL,
  `Bplus` varchar(100) DEFAULT NULL,
  `B` varchar(100) DEFAULT NULL,
  `Bminus` varchar(100) DEFAULT NULL,
  `Cplus` varchar(100) DEFAULT NULL,
  `C` varchar(100) DEFAULT NULL,
  `Cminus` varchar(100) DEFAULT NULL,
  `Dplus` varchar(100) DEFAULT NULL,
  `D` varchar(100) DEFAULT NULL,
  `Dminus` varchar(100) DEFAULT NULL,
  `E` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_grades`
--

LOCK TABLES `tbl_grades` WRITE;
/*!40000 ALTER TABLE `tbl_grades` DISABLE KEYS */;
INSERT INTO `tbl_grades` VALUES (1,'FORM_1','ENGLISH','80','75','70','65','60','55','50','45','40','35','30','25'),(2,'FORM_1','KISWAHILI','75','70','65','60','55','50','45','40','35','30','25','20'),(3,'FORM_1','MATHEMATICS','60','55','50','45','40','35','30','25','20','15','10','5'),(4,'FORM_1','BIOLOGY','80','75','70','65','60','55','50','45','40','35','30','25'),(5,'FORM_1','CHEMISTRY','80','75','70','65','60','55','50','45','40','35','30','25'),(6,'FORM_1','PHYSICS','80','75','70','65','60','55','50','45','40','35','30','25'),(7,'FORM_1','GEOGRAPHY','90','85','80','75','70','65','60','55','50','45','40','35'),(8,'FORM_1','HISTORY','90','85','80','75','70','65','60','55','50','45','40','35'),(9,'FORM_1','CRE','80','75','70','65','60','55','50','45','40','35','30','25'),(10,'FORM_1','BUSINESS','75','70','65','60','55','50','45','40','35','30','25','20'),(11,'FORM_1','AGRICULTURE','80','75','70','65','60','55','50','45','40','35','30','25'),(12,'FORM_1','TOTAL','80','75','70','65','60','55','50','45','40','35','30','25');
/*!40000 ALTER TABLE `tbl_grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_students`
--

DROP TABLE IF EXISTS `tbl_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_students` (
  `id` int(11) DEFAULT NULL,
  `adm` varchar(100) NOT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` int(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `dob` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_students`
--

LOCK TABLES `tbl_students` WRITE;
/*!40000 ALTER TABLE `tbl_students` DISABLE KEYS */;
INSERT INTO `tbl_students` VALUES (1,'001','SONY','CASIO','FORME',400,'FORM_1','7/5/2003'),(2,'002','INTEL','COMPAQ','ACER',340,'FORM_1','7/3/2003'),(3,'003','HACKERS','ELECTRON','PHOENIX',350,'FORM_2','7/5/2003'),(5,'004','AZAM','CARBONATED','DRINK',340,'FORM_2','7/10/2003'),(6,'005','PLATE','CUP','SPOON',423,'FORM_3','8/4/2005'),(7,'099','HUAWEI','SAMSUNG','TECNO',456,'FORM_3','11/27/2018'),(8,'100','NIVEA','VASELINE','VALON',400,'FORM_4','11/1/2017'),(9,'101','TAIFA','EXE','PEMBE',390,'FORM_4','5/29/2016');
/*!40000 ALTER TABLE `tbl_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_subject_selection`
--

DROP TABLE IF EXISTS `tbl_subject_selection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_subject_selection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adm` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `english` varchar(100) DEFAULT NULL,
  `kiswahili` varchar(100) DEFAULT NULL,
  `mathematics` varchar(100) DEFAULT NULL,
  `biology` varchar(100) DEFAULT NULL,
  `chemistry` varchar(100) DEFAULT NULL,
  `physics` varchar(100) DEFAULT NULL,
  `geography` varchar(100) DEFAULT NULL,
  `history` varchar(100) DEFAULT NULL,
  `cre` varchar(100) DEFAULT NULL,
  `business` varchar(100) DEFAULT NULL,
  `agriculture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_subject_selection`
--

LOCK TABLES `tbl_subject_selection` WRITE;
/*!40000 ALTER TABLE `tbl_subject_selection` DISABLE KEYS */;
INSERT INTO `tbl_subject_selection` VALUES (1,'001','SONY','CASIO','FORME','400','FORM_1','1','1','1','1','1','1','1','1','1','1','1'),(2,'002','INTEL','COMPAQ','ACER','340','FORM_1','1','1','1','1','1','1','1','1','1','1','1'),(3,'003','HACKERS','ELECTRON','PHOENIX','350','FORM_2','1','1','1','1','1','1','1','1','1','1','1'),(5,'004','AZAM','CARBONATED','DRINK','340','FORM_2','1','1','1','1','1','1','1','1','1','1','1'),(6,'005','PLATE','CUP','SPOON','423','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'099','HUAWEI','SAMSUNG','TECNO','456','FORM_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'100','NIVEA','VASELINE','VALON','400','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'101','TAIFA','EXE','PEMBE','390','FORM_4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_subject_selection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_teacher`
--

DROP TABLE IF EXISTS `tbl_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `short` varchar(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_teacher`
--

LOCK TABLES `tbl_teacher` WRITE;
/*!40000 ALTER TABLE `tbl_teacher` DISABLE KEYS */;
INSERT INTO `tbl_teacher` VALUES (1,'23','MUSALIA','MUKAISI','NYABUTO','MM NYABUTO','FORM_1','English'),(2,'67','MARTIN','GICHUKI','KAMAU','KAMAU MG','FORM_1','Kiswahili'),(3,'78','MARK','TOO','LI','TOO ML','FORM_1','Mathematics'),(4,'68','PERIS','WAIRIA','NJUNGE','NJUNGEE PW','FORM_1','Biology'),(5,'56','GICHIMU','SILAS','NJARABA','GICHIMU SN','FORM_1','Chemistry'),(6,'65','BEST','ASTRA','ENGLAND','ASTRA BE','FORM_1','Physics'),(7,'66','UNGA','WA','DOLA','DOLA UW','FORM_1','Geography'),(8,'45','MARY','WANGU','MARII','MARY WM','FORM_1','CRE'),(9,'67','MARTIN','GICHUKI','KAMAU','KAMAU MG','FORM_1','History'),(10,'78','MARK','TOO','LI','TOO ML','FORM_1','Business'),(11,'56','GICHIMU','SILAS','NJARABA','GICHIMU SN','FORM_1','Agriculture');
/*!40000 ALTER TABLE `tbl_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_temporary`
--

DROP TABLE IF EXISTS `tbl_temporary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_temporary` (
  `id` int(11) DEFAULT NULL,
  `adm` varchar(100) NOT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` int(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `dob` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_temporary`
--

LOCK TABLES `tbl_temporary` WRITE;
/*!40000 ALTER TABLE `tbl_temporary` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_temporary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_update`
--

DROP TABLE IF EXISTS `tbl_update`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_update` (
  `id` int(11) DEFAULT NULL,
  `admPrev` varchar(100) DEFAULT NULL,
  `adm` varchar(100) NOT NULL,
  `fname` varchar(100) DEFAULT NULL,
  `mname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `kcpe` int(100) DEFAULT NULL,
  `class` varchar(100) DEFAULT NULL,
  `dob` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_update`
--

LOCK TABLES `tbl_update` WRITE;
/*!40000 ALTER TABLE `tbl_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_update` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES (1,'CINDY','GACUNKU','20','CINDYG','0000','System_User','2018-07-04 09:09:57'),(2,'VICTOR','N','1','VIC','0000','Administrator','2018-07-04 12:45:44'),(3,'VICTOR','NGANGA','34','NV','0000','System_User','2018-09-12 23:22:02');
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-24 17:48:25
