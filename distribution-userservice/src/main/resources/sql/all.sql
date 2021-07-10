-- MySQL dump 10.13  Distrib 5.7.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demo1
-- ------------------------------------------------------
-- Server version	5.7.34-log

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
-- Table structure for table `sys_operator_log`
--

create database demo1;
user demo1;

DROP TABLE IF EXISTS `sys_operator_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_operator_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `operator_name` varchar(64)  NOT NULL DEFAULT '' COMMENT '操作名称',
  `operator_uri` varchar(64)  NOT NULL DEFAULT '' COMMENT '操作uri',
  `operator_module` varchar(64)  NOT NULL DEFAULT '' COMMENT '操作模块',
  `operator_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `operator_ip` varchar(16)  NOT NULL DEFAULT '',
  `operator_type` varchar(10)  NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `t_event`
--

DROP TABLE IF EXISTS `t_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_event` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type` varchar(32) NOT NULL COMMENT '事件类型 新增用户 新增积分',
  `process` varchar(32) NOT NULL COMMENT '事件进行的程度 新建 已发布 已处理',
  `content` text NOT NULL COMMENT '要进行处理的数据',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='本地事件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_event`
--

LOCK TABLES `t_event` WRITE;
/*!40000 ALTER TABLE `t_event` DISABLE KEYS */;
INSERT INTO `t_event` (`id`, `type`, `process`, `content`, `create_time`, `update_time`) VALUES (1,'addUser','NEW','{\"userId\":1,\"point\":20}','2021-07-10 06:15:45','2021-07-10 06:15:45'),(2,'addUser','NEW','{\"userId\":2,\"point\":20}','2021-07-10 06:17:06','2021-07-10 06:17:06'),(3,'addUser','NEW','{\"userId\":3,\"point\":20}','2021-07-10 06:18:26','2021-07-10 06:18:26'),(4,'addUser','NEW','{\"userId\":4,\"point\":20}','2021-07-10 06:19:24','2021-07-10 06:19:24');
/*!40000 ALTER TABLE `t_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT b'0',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `name`, `age`, `phone`, `is_delete`, `create_time`, `update_time`) VALUES (1,'??',23,'15560220637',_binary '\0','2021-07-10 06:15:45','2021-07-10 06:15:45'),(2,'??',23,'15560220637',_binary '\0','2021-07-10 06:17:06','2021-07-10 06:17:06'),(3,'??',23,'15560220637',_binary '\0','2021-07-10 06:18:26','2021-07-10 06:18:26'),(4,'??',23,'15560220637',_binary '\0','2021-07-10 06:19:24','2021-07-10 06:19:24');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-10 14:45:12
