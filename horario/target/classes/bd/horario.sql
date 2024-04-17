CREATE DATABASE  IF NOT EXISTS `horario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `horario`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: horario
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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Informática'),(2,'Administração');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `id_disciplina` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  `tempo` int DEFAULT NULL,
  `area_fim` tinyint DEFAULT NULL,
  `matriz_curricular_id` int NOT NULL,
  `etapa_id` int NOT NULL,
  PRIMARY KEY (`id_disciplina`),
  KEY `fk_disciplina_matriz_curricular_idx` (`matriz_curricular_id`),
  KEY `fk_disciplina_etapa_idx` (`etapa_id`),
  CONSTRAINT `fk_disciplina_etapa` FOREIGN KEY (`etapa_id`) REFERENCES `etapa` (`id_etapa`),
  CONSTRAINT `fk_disciplina_matriz_curricular` FOREIGN KEY (`matriz_curricular_id`) REFERENCES `matriz_curricular` (`id_matriz_curricular`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'ARQUITETURA DE COMPUTADORES','ARC',4,1,1,1),(2,'LINGUAGEM DE PROGRAMAÇÃO I','LP1',8,1,1,1),(3,'LÓGICA APLICADA À INFORMÁTICA','LAI',4,0,1,1),(4,'MODELAGEM DE DADOS I','MD1',4,1,1,1),(5,'SEGURANÇA, MEIO AMBIENTE E SAÚDE','SMAS',2,0,1,1),(6,'SISTEMAS OPERACIONAIS','SO',4,1,1,1),(7,'TECNOLOGIA DA INFORMAÇÃO','TI',4,1,1,1),(8,'BANCO DE DADOS I','BD1',4,1,1,2),(9,'DESIGN GRÁFICO','DG',4,0,1,2),(10,'FERRAMENTAS PARA WEB I','FW1',2,1,1,2),(11,'LINGUAGEM DE PROGRAMAÇÃO II','LP2',8,1,1,2),(12,'MODELAGEM DE DADOS II','MD2',4,1,1,2),(13,'MONTAGEM E MANUTENÇÃO','MM',4,1,1,2),(14,'REDES DE COMPUTADORES','RD',4,1,1,2),(15,'BANCO DE DADOS II','BD2',4,1,1,3),(16,'FERRAMENTAS PARA WEB II','FW2',4,1,1,3),(17,'GESTÃO E EMPREENDEDORISMO','GE',2,0,1,3),(18,'LINGUAGEM DE PROGRAMAÇÃO III','LP3',8,1,1,3),(19,'PROGRAMAÇÃO PARA DISPOSITIVOS','PDM',6,1,1,3),(20,'PROJETO FINAL','PF',4,1,1,3),(21,'PSICOLOGIA DAS RELAÇÕES HUMANAS','PSI',2,0,1,3),(22,'INFORMÁTICA APLICADA I ','INFA1',2,0,2,1),(23,'INFORMÁTICA APLICADA II','INFA2',2,0,2,3);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_habilitacao`
--

DROP TABLE IF EXISTS `disciplina_habilitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina_habilitacao` (
  `disciplina_id` int NOT NULL,
  `habilitacao_id` int NOT NULL,
  PRIMARY KEY (`disciplina_id`,`habilitacao_id`),
  KEY `fk_disciplina_habilitacao_habilitacao_idx` (`habilitacao_id`),
  CONSTRAINT `fk_disciplina_habilitacao_disciplina` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id_disciplina`),
  CONSTRAINT `fk_disciplina_habilitacao_habilitacao` FOREIGN KEY (`habilitacao_id`) REFERENCES `habilitacao` (`id_habilitacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_habilitacao`
--

LOCK TABLES `disciplina_habilitacao` WRITE;
/*!40000 ALTER TABLE `disciplina_habilitacao` DISABLE KEYS */;
INSERT INTO `disciplina_habilitacao` VALUES (1,1),(2,1),(4,1),(6,1),(7,1),(8,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(18,1),(19,1),(20,1),(22,1),(23,1);
/*!40000 ALTER TABLE `disciplina_habilitacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disponibilidade_docente`
--

DROP TABLE IF EXISTS `disponibilidade_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disponibilidade_docente` (
  `id_disponibilidade_docente` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_disponibilidade_docente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibilidade_docente`
--

LOCK TABLES `disponibilidade_docente` WRITE;
/*!40000 ALTER TABLE `disponibilidade_docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `disponibilidade_docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id_docente` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `setor_id` bigint NOT NULL,
  `tempo` int DEFAULT NULL,
  `habilitacao_id` int DEFAULT NULL,
  PRIMARY KEY (`id_docente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fkSetorSetorID_idx` (`setor_id`),
  KEY `fk_docente_habilitacao_idx` (`habilitacao_id`),
  CONSTRAINT `fk_docente_habilitacao` FOREIGN KEY (`habilitacao_id`) REFERENCES `habilitacao` (`id_habilitacao`),
  CONSTRAINT `fk_docente_setor` FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (10,'BRUNO','AUGUSTO TORRES','05281025759','brunotorresprofessor@gmail.com',4,12,1),(11,'ALEXANDRE','ROCHA novo','11039606792','vivian.torres@prof.etejk.faetec.rj.gov.br',5,0,1),(12,'JULIO','DA SILVA','11111111111','teste@teste.com',4,24,1);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ensino`
--

DROP TABLE IF EXISTS `ensino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ensino` (
  `id_ensino` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ensino`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ensino`
--

LOCK TABLES `ensino` WRITE;
/*!40000 ALTER TABLE `ensino` DISABLE KEYS */;
INSERT INTO `ensino` VALUES (1,'Integrado'),(2,'Subsequente');
/*!40000 ALTER TABLE `ensino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escola`
--

DROP TABLE IF EXISTS `escola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escola` (
  `id_escola` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_escola`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escola`
--

LOCK TABLES `escola` WRITE;
/*!40000 ALTER TABLE `escola` DISABLE KEYS */;
INSERT INTO `escola` VALUES (4,'ETEJK'),(5,'REPÚBLICA');
/*!40000 ALTER TABLE `escola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etapa`
--

DROP TABLE IF EXISTS `etapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etapa` (
  `id_etapa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_etapa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa`
--

LOCK TABLES `etapa` WRITE;
/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
INSERT INTO `etapa` VALUES (1,'Etapa 1'),(2,'Etapa 2'),(3,'Etapa 3');
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilitacao`
--

DROP TABLE IF EXISTS `habilitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habilitacao` (
  `id_habilitacao` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_habilitacao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilitacao`
--

LOCK TABLES `habilitacao` WRITE;
/*!40000 ALTER TABLE `habilitacao` DISABLE KEYS */;
INSERT INTO `habilitacao` VALUES (1,'Informática'),(2,'Administração');
/*!40000 ALTER TABLE `habilitacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `idHorario` int NOT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `idLocal` int NOT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `id_matricula` bigint NOT NULL AUTO_INCREMENT,
  `cargo` varchar(255) NOT NULL,
  `carga_horaria` bigint NOT NULL,
  `id_docente` bigint DEFAULT NULL,
  PRIMARY KEY (`id_matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriz_curricular`
--

DROP TABLE IF EXISTS `matriz_curricular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriz_curricular` (
  `id_matriz_curricular` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `curso_id` int NOT NULL,
  `ano_matriz` varchar(4) NOT NULL,
  PRIMARY KEY (`id_matriz_curricular`),
  KEY `fk_matriz_curricular_curso_idx` (`curso_id`),
  CONSTRAINT `fk_matriz_curricular_curso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriz_curricular`
--

LOCK TABLES `matriz_curricular` WRITE;
/*!40000 ALTER TABLE `matriz_curricular` DISABLE KEYS */;
INSERT INTO `matriz_curricular` VALUES (1,'Matriz Curricular Informática Subsequente',1,'2023'),(2,'Matriz Curricular Administração Subsequente',2,'2023');
/*!40000 ALTER TABLE `matriz_curricular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `id_permissao` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_permissao`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'administrador'),(2,'coordenador_curso'),(3,'professor');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencia_disciplina_docente`
--

DROP TABLE IF EXISTS `preferencia_disciplina_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferencia_disciplina_docente` (
  `id_preferencia_disciplina_docente` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_preferencia_disciplina_docente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencia_disciplina_docente`
--

LOCK TABLES `preferencia_disciplina_docente` WRITE;
/*!40000 ALTER TABLE `preferencia_disciplina_docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencia_disciplina_docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie` (
  `idSerie` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSerie`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` VALUES (1,'PRIMEIRA'),(2,'SEGUNDA'),(3,'TERCEIRA');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setor` (
  `id_setor` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `escola_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (4,'Coordenação de Informática','5'),(5,'Coordenação de Administração','5');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_local`
--

DROP TABLE IF EXISTS `tipo_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_local` (
  `idTipoLocal` int NOT NULL,
  PRIMARY KEY (`idTipoLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_local`
--

LOCK TABLES `tipo_local` WRITE;
/*!40000 ALTER TABLE `tipo_local` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `id_turma` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `ano_inicio` varchar(4) NOT NULL,
  `semestre_inicio` varchar(1) NOT NULL,
  `curso_id` int NOT NULL,
  `ensino_id` int NOT NULL,
  `turno_id` int NOT NULL,
  `etapa_id` int NOT NULL,
  `ativo` tinyint NOT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `fk_turma_curso_idx` (`curso_id`),
  KEY `fk_ensino_curso_idx` (`ensino_id`),
  KEY `fk_turno_curso_idx` (`turno_id`),
  KEY `fk_etapa_curso_idx` (`etapa_id`),
  CONSTRAINT `fk_ensino_curso` FOREIGN KEY (`ensino_id`) REFERENCES `ensino` (`id_ensino`),
  CONSTRAINT `fk_etapa_curso` FOREIGN KEY (`etapa_id`) REFERENCES `etapa` (`id_etapa`),
  CONSTRAINT `fk_turma_curso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `fk_turno_curso` FOREIGN KEY (`turno_id`) REFERENCES `turno` (`id_turno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'1350','2023','1',1,2,3,3,1),(2,'1250','2023','2',1,2,3,2,1);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `id_turno` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_turno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Matutino '),(2,'Vespertino '),(3,'Noturno '),(4,'Integral');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `data_expiracao` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'99999999999','brunotorresprofessor@gmail.com','Bruno Torres','$2a$10$q/tVg3Ch0WpdNOWBzzSO7.1JLjGNTIthPzQX8449q0urVXS5KZqiC',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_permissao`
--

DROP TABLE IF EXISTS `usuario_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_permissao` (
  `usuario_id_usuario` bigint NOT NULL,
  `permissao_id_permissao` bigint NOT NULL,
  KEY `FKk332avxi0y4bxefc81bb80c50` (`permissao_id_permissao`),
  KEY `FKasxswpkitybqqc3734owjqq78` (`usuario_id_usuario`),
  CONSTRAINT `FKasxswpkitybqqc3734owjqq78` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKk332avxi0y4bxefc81bb80c50` FOREIGN KEY (`permissao_id_permissao`) REFERENCES `permissao` (`id_permissao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_permissao`
--

LOCK TABLES `usuario_permissao` WRITE;
/*!40000 ALTER TABLE `usuario_permissao` DISABLE KEYS */;
INSERT INTO `usuario_permissao` VALUES (1,1);
/*!40000 ALTER TABLE `usuario_permissao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-10 18:08:15
