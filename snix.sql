CREATE DATABASE  IF NOT EXISTS `snix` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `snix`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: snix
-- ------------------------------------------------------
-- Server version	9.3.0

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
-- Table structure for table `archivo`
--

DROP TABLE IF EXISTS `archivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `archivo` (
  `id` varchar(255) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `ruta` varchar(255) DEFAULT NULL,
  `producto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2cqrd51ehj7s2d760i8gtl9r9` (`producto`),
  CONSTRAINT `FK2cqrd51ehj7s2d760i8gtl9r9` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivo`
--

LOCK TABLES `archivo` WRITE;
/*!40000 ALTER TABLE `archivo` DISABLE KEYS */;
INSERT INTO `archivo` VALUES ('00c13572-1c77-4be9-a551-ef325e5320fa','NIKE_TN_VERDES.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('117d55db-2084-4b87-b636-2d7eb2b1b8ff','On_Cloudsurfer_1_On1_6.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','4'),('154b5a9d-51d6-4a0e-80bf-e9a80883daca','Y24_Nike_Vomero_6.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','3'),('180fa404-6276-47fb-8f11-fbd8e83059cf','NIKE_DORADOS_CON_NEGRO.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('185c0c51-3cac-4ffa-8a8e-6d0fbcd86ed4','Y28_Nike_P6000_7.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','2'),('1a7b53e0-602c-47d2-ace9-d85783aea273','Adidas_Country_Y30_1.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','9'),('20959e86-bf6d-429c-a28c-4d70211f8194','New_Balance_530_2.0_Y6_1.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','6'),('2dcaf682-211f-440d-bd00-f6b051765e8a','On_Cloudsurfer_1_On1_4.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','4'),('2e2c6a4c-4e31-4385-b1ec-1306cf2bc0ac','NIKE_TN_NEGROS_CON_BLANCO.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('3131b82c-d1c6-408a-b764-bf6e9de7fcc3','1.png','image/png','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('329e049e-66ff-4f3d-97e9-490e76c1c635','Y28_Nike_P6000_8.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','2'),('3610346f-2018-4799-a371-9bd6a911d328','An12_Skate_3.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','7'),('4a3adbec-e5c9-4a4b-918c-610e0de4d3c6','Y24_Nike_Vomero_4.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','3'),('4a49a6b7-ea80-45f1-ae86-1d51fa087fab','Nike_Speed_713_5.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','5'),('4a606125-6b35-4454-81ca-575fd10f96d0','Adidas_Samba_Y7_12.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','8'),('4b068a22-ba67-4071-aa6e-1e0b3d1c915b','Y28_Nike_P6000_1.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','2'),('4f0166d1-7193-4f37-b65f-8671f677f637','NIKE_DORADOS_CON_NEGRO.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('5b76b0b4-2ed3-4c1e-b93a-0993d352bc28','New_Balance_530_2.0_Y6_6.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','6'),('5e2d7080-215b-4a0d-992f-9f86c709f90e','NIKE_TN_NEGROS_CON_BLANCO.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('60baa7df-1734-49ec-8534-5e0e67298723','On_Cloudsurfer_1_On1_2.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','4'),('69190437-4658-420f-aa48-3a4e803286ed','Adidas_Samba_Y7_11.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','8'),('74113103-3d9c-4bb1-b3eb-d42d64bd0328','1.png','image/png','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('743c9eed-b358-48ba-bcb6-2688d0f8a71f','ADIDAS_BOUNCE_3.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','10'),('758a37aa-2018-44fd-8bfb-035bcb733508','Y24_Nike_Vomero_8.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','3'),('7d0fb59f-a19d-46f7-8719-dc8e49c0033b','Nike_Speed_713_1.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','5'),('7d16936b-be75-43f7-a23f-7d25ffacfc77','New_Balance_530_2.0_Y6_4.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','6'),('7fe49b21-c7e9-4a9d-893f-a7dda3af8ac6','Adidas_Country_Y30_4.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','9'),('8110bc51-9b0e-45a5-8151-3c3349f22278','Adidas_Country_Y30_3.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','9'),('84be0d1d-493e-44b8-9aae-561967658963','An12_Skate_7.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','7'),('887ccba3-b3e9-4f31-a94b-9875840eea42','Y28_Nike_P6000_6.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','2'),('8e875e0b-4c57-4592-b617-f6a16c715905','Black_White_Bold_Rounded_Shoes_Fashion_Product_Introduction_Instagram_Post__2_.png','image/png','C:\\Users\\sauma\\Documents\\Snix\\images\\','10'),('a540c418-e377-4923-951e-8c555ec61148','ADIDAS_BOUNCE_4.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','10'),('af72b9ab-bb70-4a08-8d83-47c2ac47ba07','NIKE_NEGROS_CON_AZUL.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('b1995a53-8682-423a-b61f-aa185e29cd1c','Nike_Speed_713_8.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','5'),('b4dfff4e-a5ae-4fb9-9e9f-7a978a65d8fd','New_Balance_530_2.0_Y6_3.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','6'),('b6920250-62f0-4ff2-8184-50371a9f0a16','An12_Skate_6.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','7'),('bf263348-dc19-4e22-93eb-1941533f48d0','ADIDAS_BOUNCE_2.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','10'),('c1e8e541-9746-4819-a332-8a54c6cb6f8c','Adidas_Samba_Y7_14.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','8'),('c476b90d-a801-40b2-926f-af7c3ce29740','Adidas_Country_Y30_2.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','9'),('d512bed7-d838-48bb-859e-5d51c00e8d45','NIKE_TN_VERDES.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('da0a9d89-6555-42e4-ad86-c528f70323af','NIKE_NEGROS_CON_AZUL.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','1882810'),('dfff08c8-2d85-4cca-bbf1-24cbf8824998','Adidas_Samba_Y7_13.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','8'),('e40f7fe8-b4c8-4d7f-817d-82b95fdda9ba','Y24_Nike_Vomero_9.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','3'),('ef8bdc91-bdd0-4013-9522-8ff09650c770','On_Cloudsurfer_1_On1_1.jpeg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','4'),('f3e29039-690f-4092-b84c-65eb905fa2ab','Nike_Speed_713_7.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','5'),('f4da39f3-6a3a-46d6-bd56-093e85801585','An12_Skate_8.jpg','image/jpeg','C:\\Users\\sauma\\Documents\\Snix\\images\\','7');
/*!40000 ALTER TABLE `archivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combos`
--

DROP TABLE IF EXISTS `combos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `combos` (
  `id` varchar(255) NOT NULL,
  `id2` varchar(255) DEFAULT NULL,
  `precio` varchar(255) DEFAULT NULL,
  `productos` varchar(255) DEFAULT NULL,
  `promo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combos`
--

LOCK TABLES `combos` WRITE;
/*!40000 ALTER TABLE `combos` DISABLE KEYS */;
/*!40000 ALTER TABLE `combos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_cliente`
--

DROP TABLE IF EXISTS `informacion_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_cliente` (
  `nombre` varchar(255) NOT NULL,
  `autorizacion` varchar(255) NOT NULL,
  `contacto` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  `depto` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_cliente`
--

LOCK TABLES `informacion_cliente` WRITE;
/*!40000 ALTER TABLE `informacion_cliente` DISABLE KEYS */;
INSERT INTO `informacion_cliente` VALUES ('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','004d1f40-9afe-40f8-a2d8-f3b9ad626cb6'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','0ed4ebaf-13a5-4d84-ad8c-c9180643f5b6'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','208ed095-e36b-47c9-82dd-5e10530dca0a'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','2092f1ad-d488-47c4-bb3b-5622654809b3'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','20a1280b-5229-4b6e-bf6b-b46a47b55771'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','22fc75ac-f775-459c-91ed-d9f898062256'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','235663ca-f968-4fb5-b328-874eac16a468'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','23f00da1-4c96-4825-a2d3-1c8f458e4825'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','25581931-8469-4b4e-b9c5-da82586091d1'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','2f2e0ce6-a227-4988-b36f-2dd7e24e80c8'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','305379f5-b8ec-4dbc-b5c4-0ef294cddea7'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','35ae07c7-9a45-4606-b18c-9a11bf74e898'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','3a8fffe2-2031-4f0d-8167-a28b704c90ef'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','3cb89c12-2302-4041-ba01-b51641e40c2d'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','4c291c74-61d2-4427-ad79-4c7398c74297'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','4c705a86-0f3b-4143-808d-d86ef7a497c7'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','4d15ea4e-f455-4acb-b5ff-13262f97a65f'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','4dae0864-19a6-4334-afa6-8f48b50272d7'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','50d512a0-31bb-4670-b918-9215f198428c'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','50f164f7-d814-4ab7-899c-c0677ce946de'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','53bc854e-15ec-438c-bc53-94655d9ffbd7'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','53dbbddd-58c0-4c3e-8751-cabcd83b64d1'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','57a7e58c-7eec-489d-ae90-137b7b0e5174'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','5e256a61-5e9a-4eb6-90c0-9d044e33c769'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','5e5de03b-e523-45cf-bfec-38b9e3a97323'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','6232ff93-c987-40a8-a145-fa8058148119'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','630cfebb-bb77-4fc0-afe9-6faafadbbbc8'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','637fbade-6240-444a-8753-893245a6dba3'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','6fd536d2-e6e5-4023-8202-f5b225c1796d'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','7042d9cd-d3ec-46d6-9c5b-e7bc31cacefa'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','7048ac95-380f-4777-be4e-f55956d60c4a'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','7b420009-7f6a-4c8f-89d8-db5ce2c991e5'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','7e4f7482-ffba-42f7-8b6e-c1418351719f'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','83d94347-2ce1-49cf-9d6a-a9053e0b11ab'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','8e82527a-3234-4b4b-9c5a-ebc4cf37da6d'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','96d0071d-bd19-4c61-8a56-e6aca6ffc9d7'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','9a9490e2-3edf-4208-9b67-7b97558b65f1'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','9c36822c-7401-40e5-b5b2-4e05364d358d'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','9d96029a-341d-41fc-9075-b4270d43a5dc'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','a1e6e3ea-d340-4977-ae64-e263ce371744'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','a2ca8c99-bf93-4186-870e-354d9925a9f4'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','aa8a120a-6249-4632-bc9e-07ee81ee9946'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','add07dff-a344-4608-b55b-8d89d32abe88'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','ae8567b1-28e7-4722-adda-a140b78a37f3'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','b18a0736-f7d4-4179-90eb-ff3a4e46b53a'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','beb24a44-160b-4ea2-921b-0a8367c9ad60'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','c2623a37-fa0d-40fd-9d01-baae0ea29a1d'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','c2711b55-8576-4676-b315-6d6fa26ec611'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','c8977425-c5eb-4733-bf43-f05c9f4a59a3'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','cc056854-785b-4b5e-aaec-15056b3341fa'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','cf2140bd-4918-414c-b8cb-446d3aa12b58'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','d62b1231-dcfb-4783-a15d-ca336bd780e5'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','e63575c3-2fef-4f7b-9e98-369a5852742f'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','e7a6530b-9d14-4374-9fed-c8cabf368cf0'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','eae0b91c-2757-4bbf-8c06-18a55de343ff'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','ebd5d208-acc7-4ae5-86b8-fe3be2b27e74'),('WALMART DAS 12.02.2000','autorizado','132123','transversal34ddsur#10-30','123123@gmail.com','123123','sgfg','fa13937e-64a0-4f5d-ae02-ffd8173daac3');
/*!40000 ALTER TABLE `informacion_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` varchar(255) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `cliente_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKjvfwgjbqjdp5sk1qto0trgpla` (`cliente_id`),
  CONSTRAINT `FKnddw3xcs25cmww1rftu8qwgb5` FOREIGN KEY (`cliente_id`) REFERENCES `informacion_cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('0d599db9-ffa6-4d80-a494-f45c6e0d7e14',NULL,'WALMART DAS 12.02.2000',4567,'2092f1ad-d488-47c4-bb3b-5622654809b3'),('0e499448-4991-4062-b923-c42310f65ae8',NULL,'WALMART DAS 12.02.2000',4567,'a1e6e3ea-d340-4977-ae64-e263ce371744'),('0e73e9f3-ef13-469e-8180-6198fad9b4ff',NULL,'WALMART DAS 12.02.2000',4567,'ae8567b1-28e7-4722-adda-a140b78a37f3'),('1a25406a-dd7a-469e-a36d-e7c5adb2626c',NULL,'WALMART DAS 12.02.2000',4567,'cc056854-785b-4b5e-aaec-15056b3341fa'),('1f645620-dc8b-413c-80ee-5e0e6cd88ad8',NULL,'WALMART DAS 12.02.2000',4567,'9a9490e2-3edf-4208-9b67-7b97558b65f1'),('255b1193-6ebf-4080-8d81-aefb83a5ffee',NULL,'WALMART DAS 12.02.2000',4567,'630cfebb-bb77-4fc0-afe9-6faafadbbbc8'),('28c2e097-3163-4b4e-bff5-3942406db0c1',NULL,'WALMART DAS 12.02.2000',4567,'a2ca8c99-bf93-4186-870e-354d9925a9f4'),('33e85196-0a56-4c5a-8e6f-3d8a2c167173',NULL,'WALMART DAS 12.02.2000',4567,'8e82527a-3234-4b4b-9c5a-ebc4cf37da6d'),('380b835f-4766-488c-947f-b0aeed2306ba',NULL,'WALMART DAS 12.02.2000',4567,'add07dff-a344-4608-b55b-8d89d32abe88'),('3b1e768e-8b66-4d0e-b477-b5865db2074f',NULL,'WALMART DAS 12.02.2000',4567,'c2711b55-8576-4676-b315-6d6fa26ec611'),('3eec78bc-552c-4dec-82cc-f12cef1e195c',NULL,'WALMART DAS 12.02.2000',4567,'305379f5-b8ec-4dbc-b5c4-0ef294cddea7'),('40c43ace-2945-4594-b870-19d829ec9e5c',NULL,'WALMART DAS 12.02.2000',4567,'53dbbddd-58c0-4c3e-8751-cabcd83b64d1'),('4588ba2b-8b9b-4d53-9429-92d7e7c16013',NULL,'WALMART DAS 12.02.2000',4567,'208ed095-e36b-47c9-82dd-5e10530dca0a'),('4b15cbed-457f-4570-a115-e0d9aad3c293',NULL,'WALMART DAS 12.02.2000',4567,'7e4f7482-ffba-42f7-8b6e-c1418351719f'),('651832a4-1be4-409a-8e2d-76dc3ee6fda2',NULL,'WALMART DAS 12.02.2000',4567,'ebd5d208-acc7-4ae5-86b8-fe3be2b27e74'),('6e6c41b2-2d57-4b55-8e94-d48f060f021e',NULL,'WALMART DAS 12.02.2000',4567,'53bc854e-15ec-438c-bc53-94655d9ffbd7'),('716eb285-5cb1-4031-9ef6-557619d7b0c2',NULL,'WALMART DAS 12.02.2000',4567,'4c705a86-0f3b-4143-808d-d86ef7a497c7'),('75029c8f-0e38-4a97-be3c-7cbdf4e80344',NULL,'WALMART DAS 12.02.2000',4567,'96d0071d-bd19-4c61-8a56-e6aca6ffc9d7'),('7aa789e0-8c27-41ce-bc2e-3c35c47b622d',NULL,'WALMART DAS 12.02.2000',4567,'3a8fffe2-2031-4f0d-8167-a28b704c90ef'),('8129ff14-1ffc-4ed3-924b-1f6b7064e37c',NULL,'WALMART DAS 12.02.2000',4567,'9c36822c-7401-40e5-b5b2-4e05364d358d'),('8bf78c4d-1dc4-46ba-98ba-3282eb8dd334',NULL,'WALMART DAS 12.02.2000',4567,'cf2140bd-4918-414c-b8cb-446d3aa12b58'),('8e9fe535-7f66-4152-8d35-fb7e999eda3c',NULL,'WALMART DAS 12.02.2000',4567,'c8977425-c5eb-4733-bf43-f05c9f4a59a3'),('8ff958fd-4e69-4abc-8d75-e309abb2e0c0',NULL,'WALMART DAS 12.02.2000',4567,'3cb89c12-2302-4041-ba01-b51641e40c2d'),('94264e43-2551-4e73-9283-181b04aa3550',NULL,'WALMART DAS 12.02.2000',4567,'d62b1231-dcfb-4783-a15d-ca336bd780e5'),('98a06e0e-7923-4b17-a7d5-f59796090896',NULL,'WALMART DAS 12.02.2000',4567,'35ae07c7-9a45-4606-b18c-9a11bf74e898'),('9c040a59-7cc9-4337-9c89-ff037c4e85a1',NULL,'WALMART DAS 12.02.2000',4567,'e7a6530b-9d14-4374-9fed-c8cabf368cf0'),('a99e2592-cb45-4564-b880-3374ba32bbbc',NULL,'WALMART DAS 12.02.2000',4567,'637fbade-6240-444a-8753-893245a6dba3'),('b0f26f05-fae9-4773-b660-47a316f99d5d',NULL,'WALMART DAS 12.02.2000',4567,'5e256a61-5e9a-4eb6-90c0-9d044e33c769'),('b5a3f9a4-ec93-4e17-8777-5255490b12eb',NULL,'WALMART DAS 12.02.2000',4567,'7048ac95-380f-4777-be4e-f55956d60c4a'),('b5c48260-e94c-4e42-9df3-4661a12cbde3',NULL,'WALMART DAS 12.02.2000',4567,'c2623a37-fa0d-40fd-9d01-baae0ea29a1d'),('b6a42a4a-14f2-4998-8c43-17f1276cc49d',NULL,'WALMART DAS 12.02.2000',4567,'83d94347-2ce1-49cf-9d6a-a9053e0b11ab'),('b7a18bc8-8479-48ab-8d2d-8468e0461e0c',NULL,'WALMART DAS 12.02.2000',4567,'b18a0736-f7d4-4179-90eb-ff3a4e46b53a'),('bc97a2e9-5693-4b82-9baf-a02d632b7955',NULL,'WALMART DAS 12.02.2000',4567,'2f2e0ce6-a227-4988-b36f-2dd7e24e80c8'),('d614788b-12c6-4927-81ad-122bc09386b4',NULL,'WALMART DAS 12.02.2000',4567,'e63575c3-2fef-4f7b-9e98-369a5852742f'),('e18db2ff-a12c-4b20-b69a-ad9cdca1cfb8',NULL,'WALMART DAS 12.02.2000',4567,'57a7e58c-7eec-489d-ae90-137b7b0e5174'),('e1c390a3-7553-4e97-a661-0f026b8122b3',NULL,'WALMART DAS 12.02.2000',4567,'6fd536d2-e6e5-4023-8202-f5b225c1796d'),('e1db21dc-05e9-46f1-8e94-fe3a092a298e',NULL,'WALMART DAS 12.02.2000',4567,'7042d9cd-d3ec-46d6-9c5b-e7bc31cacefa'),('e51bf80e-d92f-4daf-b1c7-558c06506e1f',NULL,'WALMART DAS 12.02.2000',4567,'22fc75ac-f775-459c-91ed-d9f898062256'),('e534487d-f5b6-4698-8512-06f135a12c57',NULL,'WALMART DAS 12.02.2000',4567,'fa13937e-64a0-4f5d-ae02-ffd8173daac3'),('ec07c307-f264-4197-88c0-fba7bd60160c',NULL,'WALMART DAS 12.02.2000',4567,'beb24a44-160b-4ea2-921b-0a8367c9ad60'),('fa49fbac-829d-40a2-b1d2-afa067e5c9c6',NULL,'WALMART DAS 12.02.2000',4567,'4d15ea4e-f455-4acb-b5ff-13262f97a65f');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` varchar(255) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `talla` varchar(255) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `detalles` varchar(7000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('10','Tennis','Adidas','Adidas Bounce',130000,99,'negro','35',4.5,'? ENERGÍA EN CADA PASO CON ADIDAS BOUNCE ? ?♂️ Tecnología, comodidad y estilo… ¡Todo en un solo par! ⏳ ¡SE ESTÁN VENDIENDO COMO PAN CALIENTE! +2,500 CLIENTES SATISFECHOS ⭐⭐⭐⭐⭐ ✨ CARACTERÍSTICAS DESTACADAS: ? Tecnología Bounce™: Amortiguación elástica que te impulsa con cada paso. ? Soporte dinámico: Ideal para entrenamientos, caminatas largas o uso diario. ?️ Material transpirable: Malla de alto rendimiento para pies frescos y secos. ? Suela antideslizante: Seguridad y agarre sin importar el terreno. ✅ BENEFICIOS CLAVE: ⚡ Potencia y retorno de energía que se sienten desde el primer paso. ? Comodidad todo el día: suaves, livianos y resistentes. ?️♀️ Ideales para personas activas, deportistas o amantes del buen calzado. ? Diseño moderno que combina con todo tu outfit.'),('1882810','Unisex','Nike','Tenis Nike TN Unisex',130000,99,'negro','38',4.2,'? ¿BUSCAS UN TENIS QUE TE OFREZCA COMODIDAD, ESTILO Y RENDIMIENTO? ? ? ¡LLEGÓ EL NIKE AIR MAX PLUS! ? Con un diseño audaz y una tecnología de amortiguación avanzada, el Nike Air Max Plus es ideal para quienes buscan comodidad y estilo todo el día. Su suela con Air Max garantiza una amortiguación única, mientras que su estilo dinámico se adapta perfectamente a cualquier look urbano o deportivo. ¡Un modelo perfecto para cualquier ocasión! ? ? Envíos a toda Colombia ?? ? Pago contra entrega ? ✨ CARACTERÍSTICAS DESTACADAS ?️ Amortiguación Air Max®: Con la tecnología Air Max® en la suela, sentirás un confort superior y absorción de impactos al caminar o correr. ?♂️? ? Diseño moderno: Con detalles en blanco, negro y rojo, es el calzado perfecto para darle un toque único a tus outfits. ? ? Ligereza: Ideal para largas jornadas de pie, corre o pasea con la comodidad que te mereces. ?♂️ ⚡ Materiales de alta calidad: Combina malla y cuero en su diseño, lo que lo hace resistente y duradero sin perder su ligereza. ✅ BENEFICIOS CLAVE ? Comodidad todo el día: Su sistema de amortiguación Air Max® proporciona un confort duradero. ⚡ Diseño que destaca: Perfecto para quienes buscan un calzado deportivo que combine rendimiento y estilo. ?♂️ Ideal para entrenamientos y uso diario: Perfecto para correr, caminar o salir con estilo. ?️ Estilo único y versátil: Combina con todo tipo de ropa, desde deportiva hasta casual. ¡Siempre destacarás!'),('2','Running','Nike','Y28 Nike P6000',130000,99,'Plateado','35',4.5,'⚡ ¿QUERÉS COMODIDAD, ESTILO Y TECNOLOGÍA EN UN SOLO PAR? El Nike P-6000 no es un par cualquiera — es una mezcla brutal de inspiración running retro y estética futurista Y2K. ? Perfecto para los que viven con estilo, se mueven sin parar y no siguen la moda… la crean. ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS ✔️ Pago contra entrega en Colombia ✔️ Atención directa por WhatsApp ✔️ Envíos seguros a cualquier ciudad del país ✨ CARACTERÍSTICAS DESTACADAS ? Diseño inspirado en running clásico: Silueta noventera con vibes del 2000 que hoy marcan tendencia ?️ Materiales transpirables + acabados metálicos: Comodidad todo el día + estilo que brilla ? Suela ergonómica y resistente: Ideal para largas caminatas, ciudad o planes urbanos ? Ajuste cómodo, estable y duradero: Perfecto para uso diario sin perder el flow ? Color plata cromado: Elegancia y rebeldía en un solo paso ✅ ¿POR QUÉ ELEGIRLO? Se adapta a cualquier outfit: streetwear, deportivo o casual Ligero, cómodo y con soporte en cada pisada Viral en redes: reels, TikTok, Instagram… ¡todos lo quieren! ⚠️ Stock limitado en Colombia ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES! Este modelo se agota rápido. Si tu talla está disponible, aprovechá y cómpralo ya. ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida. Tu estilo no espera.'),('3','Unisex','Nike','Y24 Nike Vomero',130000,99,'Negro','35',4,'⚡ ¿BUSCÁS CONFORT, RENDIMIENTO Y ESTILO EN UN SOLO PAR? El Y24 Nike Vomero no es cualquier sneaker — es la mezcla perfecta entre tecnología de running premium y un diseño versátil que se adapta a la calle.  ? Ideal para quienes quieren máxima comodidad, soporte en cada pisada y un look fresco que nunca pasa desapercibido.  ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS ✔️ Pago contra entrega en Colombia ✔️ Atención directa por WhatsApp ✔️ Envíos seguros a cualquier ciudad del país  ✨ CARACTERÍSTICAS DESTACADAS ? Tecnología ZoomX + Cushlon: Amortiguación reactiva y soporte superior en todo momento ?️ Malla transpirable: Mantiene tus pies frescos en entrenos largos o días activos ? Suela resistente y flexible: Tracción y durabilidad para ciudad, caminatas o deporte ? Ajuste premium y acolchado extra: Confort absoluto desde el primer paso ? Diseño moderno y versátil: Perfecto para entrenar, salir o elevar tu outfit diario  ✅ ¿POR QUÉ ELEGIRLO?  Se adapta tanto a entrenamientos como a looks urbanos  Comodidad insuperable para todo el día  Recomendado por runners y trendsetters a nivel mundial  ⚠️ Stock limitado en Colombia ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES! Este modelo vuela. Si tu talla está en stock, ¡aprovechá y pedilo ya!  ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida. Porque tus pasos merecen la mejor tecnología.'),('4','Running','OnCloud','On Cloudsurfer 1',130000,99,'Blanco','35',4.5,'? ON CLOUDSURFER 1 On1  LA REVOLUCIÓN DEL RUNNING LIGERO Y URBANO ? ⚡ ¿BUSCÁS COMODIDAD, RENDIMIENTO Y ESTILO PREMIUM EN UN SOLO PAR?  El On Cloudsurfer 1 On1 no es cualquier zapatilla: combina ingeniería suiza con diseño minimalista para darte una pisada suave, ligera y con un flow urbano único.  ? Perfecto para quienes no se conforman con lo común: corren, caminan y marcan tendencia en cada paso. ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS  ✔️ Pago contra entrega en Colombia  ✔️ Atención directa por WhatsApp  ✔️ Envíos seguros a cualquier ciudad del país ✨ CARACTERÍSTICAS DESTACADAS  ☁️ Tecnología CloudTec® Phase: Amortiguación progresiva y fluida en cada pisada  ? Mesh ultratranspirable: Frescura y ventilación para todo el día  ? Suela ligera y flexible: Ideal para entrenamientos, caminatas largas o uso urbano  ? Ajuste cómodo y estable: Diseñado para moverse con libertad sin perder soporte  ⚡ Diseño minimalista + toques modernos: Estilo versátil que combina con cualquier outfit ✅ ¿POR QUÉ ELEGIRLO?  ✔️ Peso ultraligero que se siente como correr sobre nubes  ✔️ Transición natural del talón a la punta del pie  ✔️ Tecnología suiza, reconocida mundialmente por su innovación  ⚠️ Stock limitado en Colombia ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES!  Este modelo vuela rápido. Si ves tu talla disponible, no lo dudes más.  ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida.  Tu estilo y comodidad no esperan.'),('5','Running','Nike','Nike Speed 713',130000,99,'negro','35',4,'⚡ ¿QUERÉS VELOCIDAD, LIGEREZA Y ESTILO EN UN SOLO PAR? El Nike Speed 713 no es un sneaker cualquiera — combina tecnología de running de alto rendimiento con un diseño moderno que impone en la calle.  ? Ideal para quienes buscan rapidez, frescura y comodidad en cada paso, ya sea entrenando o marcando tendencia urbana.  ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS ✔️ Pago contra entrega en Colombia ✔️ Atención directa por WhatsApp ✔️ Envíos seguros a cualquier ciudad del país  ✨ CARACTERÍSTICAS DESTACADAS ? Espuma ligera de alto rebote: Amortiguación reactiva que impulsa cada pisada ?️ Upper en malla técnica: Transpirable, flexible y cómodo para todo el día ? Suela con patrón de tracción avanzado: Agarre confiable en asfalto y superficies urbanas ? Diseño estilizado y ergonómico: Ajuste firme pero natural para máxima comodidad ? Estética dinámica y moderna: Perfecta para entrenar, salir o elevar tu flow deportivo  ✅ ¿POR QUÉ ELEGIRLO?  Diseñado para velocidad y confort en un mismo par  Perfecto para running, gym o uso urbano  Ligero, versátil y con look actual que destaca  ⚠️ Stock limitado en Colombia ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES! Este modelo vuela. Si tu talla está en stock, ¡no lo dejes pasar!  ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida. Porque la velocidad también se lleva con estilo.'),('6','Unisex','NewBalance','New Balance 530 2.0 Y6',130000,99,'Blanco','35',4.5,'? NEW BALANCE 530 2.0 Y6  EL CLÁSICO RETRO RUNNING QUE SE VOLVIÓ ICONO URBANO ✨? ⚡ ¿QUERÉS COMODIDAD, TECNOLOGÍA Y ESTILO Y2K EN UN SOLO PAR?  Los New Balance 530 2.0 Y6 combinan la esencia del running noventero con toques futuristas que hoy son tendencia mundial.  ? Perfectos para quienes buscan un sneaker versátil: deportivo, cómodo y con todo el flow urbano. ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS  ✔️ Pago contra entrega en Colombia  ✔️ Atención directa por WhatsApp  ✔️ Envíos seguros a cualquier ciudad del país ✨ CARACTERÍSTICAS DESTACADAS  ? Diseño retro running + vibes Y2K: Silueta noventera que hoy marca tendencia  ? Tecnología ABZORB: Amortiguación y soporte extra en cada pisada  ?️ Mesh transpirable + detalles sintéticos: Comodidad y frescura todo el día  ? Suela robusta y ergonómica: Ideal para caminatas largas o uso urbano  ⚡ Estilo versátil y moderno: Combina con streetwear, casual o deportivo ✅ ¿POR QUÉ ELEGIRLOS?  ✔️ Sneaker viral en redes y parte del revival Y2K  ✔️ Cómodos, resistentes y perfectos para uso diario  ✔️ New Balance: sinónimo de calidad y estilo retro-tech  ⚠️ Stock limitado en Colombia ? GUÍA DE TALLAS ?  Queremos que tengas el ajuste perfecto desde el primer paso ?✨  Consulta nuestra tabla de medidas antes de comprar ? ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES!  Este modelo se agota rápido en todas partes del mundo.  ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida.  El futuro retro ya está en tus pies.'),('7','Unisex','Nike','An12 Skate',130000,99,'Blanco','35',4.2,'? AN12 SKATE  EL PODER DEL SKATE CON ESTILO URBANO ?? ⚡ ¿BUSCÁS RESISTENCIA, COMODIDAD Y ESTILO EN UN SOLO PAR?  Los An12 Skate están diseñados para aguantar la calle, los trucos y el día a día con un look urbano que nunca pasa desapercibido.  ? Perfectos para skaters, amantes del streetwear y quienes viven con actitud en cada paso. ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS  ✔️ Pago contra entrega en Colombia  ✔️ Atención directa por WhatsApp  ✔️ Envíos seguros a cualquier ciudad del país ✨ CARACTERÍSTICAS DESTACADAS  ? Diseño skate clásico: Silueta robusta y cómoda para patinar o el día a día  ? Suela de goma vulcanizada: Agarre y durabilidad máxima en la tabla o en la calle  ?️ Materiales resistentes + transpirables: Confort sin perder firmeza  ? Ajuste estable y acolchado: Soporte extra en tobillos y comodidad prolongada  ⚡ Estética urbana con detalles modernos: Para destacar en cualquier outfit ✅ ¿POR QUÉ ELEGIRLOS?  ✔️ Ideales para skate, streetwear o uso diario  ✔️ Construcción duradera que resiste golpes y desgaste  ✔️ Estilo fresco y auténtico que conecta con la cultura urbana  ⚠️ Stock limitado en Colombia ? GUÍA DE TALLAS ?  Queremos que sientas la comodidad y el ajuste perfecto desde la primera rodada ?✨  Consulta nuestra tabla de medidas antes de comprar ? ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES!  Este modelo se agota rápido. Si tu talla está en stock, no la dejes escapar.  ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida.  Tu estilo urbano y skate en un solo par.'),('8','Streetwear','Adidas','Adidas Samba Y7',130000,99,'negro','35',4,'? ADIDAS SAMBA Y7  EL CLÁSICO QUE NUNCA PASA DE MODA ?✨ ⚡ ¿QUERÉS ESTILO ICÓNICO, COMODIDAD Y VERSATILIDAD EN UN SOLO PAR?  Los Adidas Samba Y7 son la leyenda del streetwear: nacidos en las canchas y convertidos en un ícono global. Con su silueta retro, comodidad premium y vibes urbanas, son el par que todos quieren.  ? Perfectos para quienes saben que lo clásico siempre marca tendencia. ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS  ✔️ Pago contra entrega en Colombia  ✔️ Atención directa por WhatsApp  ✔️ Envíos seguros a cualquier ciudad del país ✨ CARACTERÍSTICAS DESTACADAS  ⚽ Diseño inspirado en el fútbol clásico: Estilo retro que se adapta al día a día  ? Suela de goma resistente: Tracción y estabilidad en cualquier superficie  ?️ Capellada en cuero premium: Durabilidad + look elegante y urbano  ? Ajuste cómodo y versátil: Perfecto para uso diario o planes casuales  ⚡ Las 3 franjas icónicas: Detalle eterno que define el estilo Adidas ✅ ¿POR QUÉ ELEGIRLOS?  ✔️ Combinan con todo: jeans, joggers, shorts o streetwear  ✔️ Ligero, cómodo y atemporal: un básico que nunca falla  ✔️ Viral en redes, amado por celebridades y la cultura urbana  ⚠️ Stock limitado en Colombia ? GUÍA DE TALLAS ?  Queremos que tu ajuste sea perfecto desde el primer paso ?✨  Consulta nuestra tabla de medidas antes de comprar ? ⏳ ¡ÚLTIMAS UNIDADES DISPONIBLES!  El Samba nunca dura mucho en stock. Si tu talla aparece, no la dejes pasar.  ? Haz tu pedido ahora mismo. Compra fácil, segura y rápida.  Un clásico eterno, en tus pies.'),('9','Streetwear','Adidas','Adidas Country Y30',130000,99,'negro','35',4.5,'? ADIDAS COUNTRY Y30  EL CLÁSICO RETRO QUE VUELVE A DOMINAR LAS CALLES ? ⚡ ¿QUERÉS ESTILO VINTAGE, COMODIDAD Y VERSATILIDAD EN UN SOLO PAR?  Los Adidas Country Y30 no son cualquier sneaker: son una pieza icónica de los 70’s reinventada para hoy, combinando vibes retro con comodidad moderna.  ? Perfectos para quienes aman lo clásico pero no dejan de marcar tendencia. ? ENVÍOS RÁPIDOS + PAGO COMO QUIERAS  ✔️ Pago contra entrega en Colombia  ✔️ Atención directa por WhatsApp  ✔️ Envíos seguros a cualquier ciudad del país ✨ CARACTERÍSTICAS DESTACADAS  ? Diseño retro runner: Inspirado en las zapatillas de atletismo de los 70’s  ?️ Materiales ligeros y transpirables: Frescura y comodidad todo el día  ? Suela de goma resistente: Tracción y durabilidad en ciudad o exteriores  ? Ajuste clásico y versátil: Se adapta a cualquier estilo y ocasión  ⚡ Icono atemporal con las 3 Franjas: El detalle que nunca pasa de moda ✅ ¿POR QUÉ ELEGIRLO?  ✔️ Combina con todo: jeans, joggers o looks casuales  ✔️ Estilo retro que está de vuelta y arrasando  ✔️ Un clásico Adidas que siempre marca diferencia  ⚠️ Stock limitado en Colombia');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promo`
--

DROP TABLE IF EXISTS `promo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promo` (
  `id` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promo`
--

LOCK TABLES `promo` WRITE;
/*!40000 ALTER TABLE `promo` DISABLE KEYS */;
/*!40000 ALTER TABLE `promo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rol_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9hfl8tdutsxq1r5er252rnssq` (`rol_id`),
  CONSTRAINT `FKpsq955rc12exhgysvc8fgbxu2` FOREIGN KEY (`rol_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-19 18:59:48
