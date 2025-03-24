-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: laravel
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cache`
--

DROP TABLE IF EXISTS `cache`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cache` (
  `key` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `value` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiration` int NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cache`
--

LOCK TABLES `cache` WRITE;
/*!40000 ALTER TABLE `cache` DISABLE KEYS */;
/*!40000 ALTER TABLE `cache` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cache_locks`
--

DROP TABLE IF EXISTS `cache_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cache_locks` (
  `key` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `owner` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiration` int NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cache_locks`
--

LOCK TABLES `cache_locks` WRITE;
/*!40000 ALTER TABLE `cache_locks` DISABLE KEYS */;
/*!40000 ALTER TABLE `cache_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `categories_name_unique` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'esporte','2025-01-28 22:11:53','2025-01-29 23:59:51'),(12,'exercitationem','2025-01-28 22:11:53','2025-01-28 22:11:53'),(13,'error','2025-01-28 22:11:53','2025-01-28 22:11:53'),(15,'quaerat','2025-01-28 22:11:53','2025-01-28 22:11:53'),(16,'eos','2025-01-28 22:11:53','2025-01-28 22:11:53'),(17,'corporis','2025-01-28 22:11:53','2025-01-28 22:11:53'),(18,'cupiditate','2025-01-28 22:11:53','2025-01-28 22:11:53'),(19,'eaque','2025-01-28 22:11:53','2025-01-28 22:11:53'),(20,'omnis','2025-01-28 22:11:53','2025-01-28 22:11:53'),(24,'teste','2025-01-29 23:55:00','2025-01-29 23:55:00'),(25,'imovel','2025-01-30 00:06:47','2025-01-30 00:06:47');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `failed_jobs`
--

DROP TABLE IF EXISTS `failed_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `failed_jobs` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `failed_jobs`
--

LOCK TABLES `failed_jobs` WRITE;
/*!40000 ALTER TABLE `failed_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `failed_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `category_id` bigint unsigned NOT NULL,
  `status` enum('achado','perdido') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'perdido',
  `user_id` bigint unsigned NOT NULL,
  `contact_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `items_category_id_foreign` (`category_id`),
  KEY `items_user_id_foreign` (`user_id`),
  CONSTRAINT `items_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE,
  CONSTRAINT `items_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (2,'atqu','Aperiam quia velit modi nemo facilis.','166',12,'perdido',13,'linnea.kertzmann@hotmail.com','+1-586-313-1957','1975-07-19','2025-01-28 22:11:53','2025-01-29 23:41:39'),(5,'cupiditate','Quia veniam nobis qui fugiat quo.','418 Roberts Passage Suite 783\nKaitlinborough, AZ 66947',15,'perdido',16,'simone74@lindgren.com','(765) 730-6233','1984-09-08','2025-01-28 22:11:53','2025-01-28 22:11:53'),(6,'neque','Et consequatur provident nostrum consequatur.','656 Watson Dale\nWelchfurt, WA 97770-9654',16,'perdido',17,'hershel.runolfsdottir@yahoo.com','1-256-328-9328','1997-04-06','2025-01-28 22:11:53','2025-01-28 22:11:53'),(7,'quam','Atque dolorem quis fugiat nobis.','859 Simonis Islands Suite 713\nLake Gretchenberg, TX 32708',17,'perdido',18,'autumn69@veum.com','661.359.2685','1985-06-20','2025-01-28 22:11:53','2025-01-28 22:11:53'),(8,'nonooooo','Delectus aut officiis exercitationem quam.','1125 Rutherford Flats\nDonavonhaven, WY 82452',18,'achado',19,'leslie97@hotmail.com','980-917-2263','1990-12-17','2025-01-28 22:11:53','2025-01-28 22:35:38'),(9,'perspiciatis','Beatae expedita rerum illo et eveniet quia exercitationem.','26102 McLaughlin Land Apt. 099\nWest Traceymouth, MN 65221',19,'perdido',20,'pbalistreri@anderson.com','(341) 794-6103','2006-01-09','2025-01-28 22:11:53','2025-01-28 22:11:53'),(10,'consequatur','Similique sit et quia quas perspiciatis pariatur.','86495 Upton Ranch\nNew Gerda, NH 02498',20,'perdido',21,'heidenreich.darien@hotmail.com','940.381.6798','2022-07-19','2025-01-28 22:11:53','2025-01-28 22:11:53'),(11,'asdas','asdasdas','asdasdsadasdasd',1,'achado',1,'asdasd@asdasdsda','1241241','2025-01-13','2025-01-28 22:21:54','2025-01-28 22:21:54'),(12,'asda','asd','a',1,'perdido',22,'a@a','124123441142412','2025-01-14','2025-01-28 22:38:23','2025-01-28 22:41:34'),(13,'nunooooo@nunooooo','nonooooo@nonooooo','Nova Rua 123',1,'perdido',1,'nonooooo@nonooooo','987654321','2025-01-24','2025-01-28 22:51:21','2025-01-29 23:11:27'),(14,'Celular','Celular encontrado','Rua X, 123',1,'perdido',1,'email@exemplo.com','123456789','2025-01-28','2025-01-28 22:51:59','2025-01-28 22:51:59'),(15,'nonooooo','nonooooo','nonooooo',1,'perdido',1,'nonooooo@nonooooo','141423','2024-12-30','2025-01-28 23:02:18','2025-01-28 23:02:18'),(16,'nonooooo','nonooooo','nonooooo',1,'perdido',23,'nonooooo@nonooooo','1241241','2025-01-13','2025-01-28 23:04:07','2025-01-28 23:04:07');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_batches`
--

DROP TABLE IF EXISTS `job_batches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_batches` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `total_jobs` int NOT NULL,
  `pending_jobs` int NOT NULL,
  `failed_jobs` int NOT NULL,
  `failed_job_ids` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `options` mediumtext COLLATE utf8mb4_unicode_ci,
  `cancelled_at` int DEFAULT NULL,
  `created_at` int NOT NULL,
  `finished_at` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_batches`
--

LOCK TABLES `job_batches` WRITE;
/*!40000 ALTER TABLE `job_batches` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_batches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `queue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `attempts` tinyint unsigned NOT NULL,
  `reserved_at` int unsigned DEFAULT NULL,
  `available_at` int unsigned NOT NULL,
  `created_at` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobs_queue_index` (`queue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `migrations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES (2,'0001_01_01_000001_create_cache_table',1),(3,'0001_01_01_000002_create_jobs_table',1),(8,'2025_01_22_185819_create_personal_access_tokens_table',3),(29,'2025_01_28_152932_add_is_admin_to_users_table',5),(58,'0001_01_01_000000_create_users_table',6),(59,'2025_01_17_180218_create_categories_table',6),(60,'2025_01_17_180218_create_items_table',6),(61,'2025_01_18_182220_add_contact_fields_to_items_table',6),(62,'2025_01_21_180914_create_personal_access_tokens_table',6),(63,'2025_01_28_174837_add_is_admin_to_users_table',6),(64,'2025_01_28_220046_add_address_to_items_table',6);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_tokens`
--

DROP TABLE IF EXISTS `password_reset_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_tokens`
--

LOCK TABLES `password_reset_tokens` WRITE;
/*!40000 ALTER TABLE `password_reset_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_access_tokens`
--

DROP TABLE IF EXISTS `personal_access_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_access_tokens` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `tokenable_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint unsigned NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text COLLATE utf8mb4_unicode_ci,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_access_tokens`
--

LOCK TABLES `personal_access_tokens` WRITE;
/*!40000 ALTER TABLE `personal_access_tokens` DISABLE KEYS */;
INSERT INTO `personal_access_tokens` VALUES (1,'App\\Models\\User',1,'api_token','2b12255245ac6098bd82bacbe42ab3be127e4fb70931c2e94d9acfb66a673583','[\"*\"]','2025-01-29 23:34:49',NULL,'2025-01-28 22:51:04','2025-01-29 23:34:49'),(2,'App\\Models\\User',22,'api_token','0a5db003c31549b18f1dfd141294e2a64ae9ce3473078a3d7012934ae58c4620','[\"*\"]','2025-01-28 23:01:32',NULL,'2025-01-28 23:01:22','2025-01-28 23:01:32'),(3,'App\\Models\\User',1,'api_token','0205bcfd27fd82b32638db6eb78b7146660c1db6e288003ba15410cb8a0913c0','[\"*\"]','2025-01-28 23:03:04',NULL,'2025-01-28 23:02:45','2025-01-28 23:03:04'),(4,'App\\Models\\User',23,'api_token','210c6c0b9de6f58f110eb70c364ca5ec948846736b70f99fb38d5715435e94aa','[\"*\"]','2025-01-28 23:10:08',NULL,'2025-01-28 23:04:31','2025-01-28 23:10:08'),(5,'App\\Models\\User',1,'api_token','31995dad181b33418bce59efef2bed37057b11d93ccdeec6301ef6e30c2694c9','[\"*\"]',NULL,NULL,'2025-01-29 20:09:18','2025-01-29 20:09:18'),(6,'App\\Models\\User',1,'api_token','ea4efa523d6c0d2c581336f32d235d645e800a7be756759bc809035d6c4ff085','[\"*\"]','2025-01-29 22:58:13',NULL,'2025-01-29 20:09:41','2025-01-29 22:58:13'),(7,'App\\Models\\User',1,'api_token','e45a3194d6088ecb227a3c9c641f2627631f709b4c17045639caa4997ca30694','[\"*\"]','2025-01-29 23:11:27',NULL,'2025-01-29 22:58:28','2025-01-29 23:11:27'),(8,'App\\Models\\User',24,'api_token','55a156c9cb45d69d3aecc4ff6232984ba7422e59e2c15661257875392b15f8db','[\"*\"]','2025-01-30 00:18:10',NULL,'2025-01-29 23:21:47','2025-01-30 00:18:10'),(9,'App\\Models\\User',1,'api_token','6c324d25c676e29996d2667b5de3a96363e20c4244798df4703a7cd7e620ee0f','[\"*\"]','2025-01-29 23:54:13',NULL,'2025-01-29 23:53:20','2025-01-29 23:54:13'),(10,'App\\Models\\User',24,'api_token','eedafdea5cc29f26d4d96ade78c08c58a291b34676a559fc1434a14f11140e58','[\"*\"]','2025-01-29 23:59:17',NULL,'2025-01-29 23:54:33','2025-01-29 23:59:17'),(11,'App\\Models\\User',1,'api_token','7123145bcfe446964b3c69bf4c2b3b74db2b236cc4486da554c22ba5c9c5d2e4','[\"*\"]','2025-01-30 00:06:47',NULL,'2025-01-29 23:59:34','2025-01-30 00:06:47'),(12,'App\\Models\\User',24,'api_token','34475142bdc416e4860af5564dbc13b4e210968d6cffa34887bfc12f62418d18','[\"*\"]','2025-01-30 00:16:25',NULL,'2025-01-30 00:07:19','2025-01-30 00:16:25'),(13,'App\\Models\\User',1,'api_token','3492613fcb1058cab9d41defe3d393a04c69b15ae191ed273a478513adb1d3d4','[\"*\"]','2025-01-30 00:19:00',NULL,'2025-01-30 00:17:05','2025-01-30 00:19:00'),(14,'App\\Models\\User',24,'api_token','70b2cd92b244bf483009be230d1ffa5059f2ca87f7cbb838e413f3de95b2a558','[\"*\"]','2025-01-31 00:54:59',NULL,'2025-01-30 00:17:51','2025-01-31 00:54:59'),(15,'App\\Models\\User',26,'api_token','a92b8ebe03f8a383b2e8fce7ddeeeed135b7ac9c2184fe6a1a0d5d5c46b6f0ee','[\"*\"]',NULL,NULL,'2025-01-30 00:36:25','2025-01-30 00:36:25'),(16,'App\\Models\\User',1,'api_token','7c6aeb1d4f8ec7efaa6e599d07901eb2afb8c7072218fa036eb491e32109b47f','[\"*\"]','2025-01-31 00:55:05',NULL,'2025-01-30 00:41:58','2025-01-31 00:55:05'),(17,'App\\Models\\User',1,'api_token','143a1fc84710d9bd873597019b2cc7b478b2c9f0787e7001999bc732a9f3c79f','[\"*\"]','2025-01-31 01:25:29',NULL,'2025-01-31 00:44:32','2025-01-31 01:25:29'),(18,'App\\Models\\User',24,'api_token','553329798f03c1e008203b860086a7e7fe2b312047c8669367a42b06a2c32afe','[\"*\"]','2025-01-31 01:24:57',NULL,'2025-01-31 00:47:00','2025-01-31 01:24:57'),(19,'App\\Models\\User',1,'api_token','b5aa1aed7b9d6b3033d4681ac30c6cfb51df32c835485fd79ec2483f7ea915ad','[\"*\"]',NULL,NULL,'2025-01-31 01:41:21','2025-01-31 01:41:21');
/*!40000 ALTER TABLE `personal_access_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessions` (
  `id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint unsigned DEFAULT NULL,
  `ip_address` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_agent` text COLLATE utf8mb4_unicode_ci,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_activity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sessions_user_id_index` (`user_id`),
  KEY `sessions_last_activity_index` (`last_activity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES ('EuZSl8LXe6tyNlYhpU3dTXGWcMVST192IYo9zTjM',NULL,'172.22.0.1','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36','YTozOntzOjY6Il90b2tlbiI7czo0MDoidzdxQ0RPbUVSTkpwRTQwWjJNbWlMWlBPQlNnMFBIQ3JYOWtKNEgwcSI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MTY6Imh0dHA6Ly9sb2NhbGhvc3QiO31zOjY6Il9mbGFzaCI7YToyOntzOjM6Im9sZCI7YTowOnt9czozOiJuZXciO2E6MDp7fX19',1738288906),('G3xJLyIqYvZUhyjhKbjeulooz97qFA8Baw8MAjQd',1,'172.22.0.1','Mozilla/5.0 (X11; Linux x86_64; rv:134.0) Gecko/20100101 Firefox/134.0','YTo2OntzOjY6Il90b2tlbiI7czo0MDoiMXdQU0h6Vmkza0NjUjRqS0s2SnlhQmpqMFVPM0tPUUc0VkJYOWxZeSI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6NTE6Imh0dHA6Ly9sb2NhbGhvc3QvaXRlbXM/Y2F0ZWdvcnlfaWQ9Jm5hbWU9ZXUmc3RhdHVzPSI7fXM6NjoiX2ZsYXNoIjthOjI6e3M6Mzoib2xkIjthOjA6e31zOjM6Im5ldyI7YTowOnt9fXM6MzoidXJsIjthOjA6e31zOjUwOiJsb2dpbl93ZWJfNTliYTM2YWRkYzJiMmY5NDAxNTgwZjAxNGM3ZjU4ZWE0ZTMwOTg5ZCI7aToxO3M6NDoiYXV0aCI7YToxOntzOjIxOiJwYXNzd29yZF9jb25maXJtZWRfYXQiO2k6MTczODI4NTAwNDt9fQ==',1738285760),('MVaHObX2MrehKlKnCXTZFWW6giNDP2mMvDv3HI6i',NULL,'172.22.0.1','PostmanRuntime/7.43.0','YTozOntzOjY6Il90b2tlbiI7czo0MDoiU09weU5ISnNLVk05TEJnTTJXVUJrOW5kcW9MdW8xMnBncDhtQTFKbyI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MjI6Imh0dHA6Ly9sb2NhbGhvc3QvbG9naW4iO31zOjY6Il9mbGFzaCI7YToyOntzOjM6Im9sZCI7YTowOnt9czozOiJuZXciO2E6MDp7fX19',1738286734),('X1kE9npwPz09a4qCDr6zpP57EdEmVE50VPrIuTy4',NULL,'172.22.0.1','PostmanRuntime/7.43.0','YTozOntzOjY6Il90b2tlbiI7czo0MDoibXFtQU9qZ2NOMEJmNFB3Nng5NTVxTWk5NDlqZTJ3QjN4RXNBNndkNCI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MjI6Imh0dHA6Ly9sb2NhbGhvc3QvbG9naW4iO31zOjY6Il9mbGFzaCI7YToyOntzOjM6Im9sZCI7YTowOnt9czozOiJuZXciO2E6MDp7fX19',1738196730),('ZOn3bY1xfPM1GiX78L9b9yjs6k8vAeoeiDscvjpg',NULL,'172.22.0.1','PostmanRuntime/7.43.0','YTozOntzOjY6Il90b2tlbiI7czo0MDoiREhaMHoyd29mdENwQ1RDU05JWUpMTVRZeFdSWWpEUUJJeVU3NUNlTiI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MjI6Imh0dHA6Ly9sb2NhbGhvc3QvbG9naW4iO31zOjY6Il9mbGFzaCI7YToyOntzOjM6Im9sZCI7YTowOnt9czozOiJuZXciO2E6MDp7fX19',1738265691),('zYNU2ly9QMFbeAdGbvDSKxg620XN3Kb8fYw3hDvG',1,'172.22.0.1','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36','YTo1OntzOjY6Il90b2tlbiI7czo0MDoiMFRRclRmaHhYalc1U3Zaakx4eFNyZGY4NmFVN2NwQXJXRmM3WEZCVyI7czo2OiJfZmxhc2giO2E6Mjp7czozOiJvbGQiO2E6MDp7fXM6MzoibmV3IjthOjA6e319czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MjI6Imh0dHA6Ly9sb2NhbGhvc3QvdXNlcnMiO31zOjUwOiJsb2dpbl93ZWJfNTliYTM2YWRkYzJiMmY5NDAxNTgwZjAxNGM3ZjU4ZWE0ZTMwOTg5ZCI7aToxO3M6NDoiYXV0aCI7YToxOntzOjIxOiJwYXNzd29yZF9jb25maXJtZWRfYXQiO2k6MTczODE5NDA0OTt9fQ==',1738196720);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','admin@gmail.com',NULL,'$2y$12$0wuO.cFkn5GDwXPpb9L.letbLCnUgfNjU7B44FSmmIbOWRh4tfu.6',NULL,'2025-01-28 22:11:53','2025-01-28 22:11:53',1),(3,'Annamarie Spinka','paris.sawayn@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','MT7EO7AZk0','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(4,'Billie Powlowski','kbergnaum@example.com','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','dSlfBkuF7B','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(5,'Roxanne Dicki III','arath@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','kxhdLPTEPn','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(6,'Jefferey Price','waino31@example.org','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','vYlBt789HI','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(7,'Otilia Buckridge Sr.','brandt99@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','IEP66job7g','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(8,'Mr. Braulio Wintheiser III','jcormier@example.org','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','uLzWPLNyUs','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(9,'Alf Runolfsdottir','nolan.heather@example.com','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','U4F4xmbKIB','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(10,'Ricardo Hermiston','beatty.myrna@example.com','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','zV1mXqMZqH','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(11,'Ashly Zulauf','strosin.lew@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','1HrVusZIy8','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(12,'Prof. Viviane Kohler DDS','treva32@example.org','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','ImncI8OO8I','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(13,'Mozell Swaniawski','kavon30@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','zKCBNR4WOg','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(14,'Celia Thompson Jr.','ebeer@example.org','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','sY8K4AGtDB','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(15,'Nicolas Terry Sr.','kihn.clifton@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','e07WHE7LHk','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(16,'Dr. Muhammad Thompson MD','smueller@example.org','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','cO8V42D3P9','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(17,'Floy Koch','leuschke.ford@example.com','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','PgRhGXDBw0','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(18,'Precious D\'Amore','ernie.mosciski@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','ewBxH7SLe1','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(19,'Anais Frami','jnienow@example.com','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','fSodGbkUdE','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(20,'Dr. Rhett Morar','ulemke@example.net','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','kDkzPxF4s7','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(21,'Santa Mayert','jeremy16@example.com','2025-01-28 22:11:53','$2y$12$sWaLfGt0Pjwn6a4n3dEu3.LMlqThoaWYKijOzYGy9Q92Bg9zzr1Ta','3YdrvISUOb','2025-01-28 22:11:53','2025-01-28 22:11:53',0),(22,'fonsecah269','fonsecah269@gmail.com',NULL,'$2y$12$p1VWVbKOtqYrgqXxt.iKIeha/XCNHat2hZKyYfIRBIIjHEB/v5VNq',NULL,'2025-01-28 22:37:47','2025-01-28 22:37:47',0),(23,'carlos','carlos@gmail.com',NULL,'$2y$12$2d5L3scJUhEa4KeSrMCljOlRJXQQE5n08jQ8xHkveJGMF92pOOzeu',NULL,'2025-01-28 23:03:44','2025-01-28 23:03:44',0),(24,'dudu','dudu@gmail.com',NULL,'$2y$12$gM9uimfj09LWXOB0pLebreo6Q5dEOBP0gHBryX7lgKAaJiAanIJiS',NULL,'2025-01-29 23:21:05','2025-01-29 23:21:05',0),(25,'jandira','jandira@gmail.com',NULL,'$2y$12$dXFnRDDVIHZsyuizCLOKFOSR.CiFazwV10Itglvqd990YaPqONcrS',NULL,'2025-01-30 00:24:24','2025-01-30 00:24:24',0),(26,'João Silva','jo@gmail.com',NULL,'$2y$12$.0OG2uSpdjjToxp6nk4NjuEIUEqAGIQpux9UmizM8Ev585y7IipaW',NULL,'2025-01-30 00:36:25','2025-01-30 00:36:25',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-31  2:26:43
