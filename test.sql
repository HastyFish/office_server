Warning: Using a password on the command line interface can be insecure.
-- MySQL dump 10.13  Distrib 5.6.44, for Linux (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.44

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
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clazz` (
  `clazz_id` char(8) NOT NULL COMMENT '班级编号 专业(4)+年份(2)+编号(2)',
  `clazz_name` varchar(20) NOT NULL,
  `professional_id` char(4) NOT NULL,
  `guide_id` char(5) NOT NULL,
  PRIMARY KEY (`clazz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clazz_course`
--

DROP TABLE IF EXISTS `clazz_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clazz_course` (
  `course_id` char(5) NOT NULL,
  `clazz_id` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `college_id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '学院编号(2)',
  `college_name` varchar(20) NOT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` char(5) NOT NULL COMMENT '课程编号 由C开头 类别(1)+学院(2)+编号(2)',
  `course_name` varchar(20) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS `guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guide` (
  `guide_id` char(5) NOT NULL COMMENT '素导编号 由G开头 身份(1)+学院(2)+编号(2)',
  `guide_name` varchar(20) NOT NULL,
  `guide_sex` enum('男','女') DEFAULT NULL,
  PRIMARY KEY (`guide_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `professional`
--

DROP TABLE IF EXISTS `professional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professional` (
  `professional_id` char(4) NOT NULL COMMENT '专业编号, 学院(2)+编号(2)',
  `professional_name` varchar(20) NOT NULL,
  `college_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`professional_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `report_id` char(13) NOT NULL COMMENT '成绩单编号 学生id(10)+年份(2)+学期(1)',
  `report_name` varchar(20) NOT NULL,
  `report_year` char(5) NOT NULL,
  `student_id` char(10) NOT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `report_id` char(13) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  `score_result` tinyint(4) NOT NULL,
  `student_id` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` char(10) NOT NULL COMMENT '学生编号 入学年份(4)+专业(4)+编号(2)',
  `student_enrollment` tinyint(4) NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `student_sex` enum('男','女') DEFAULT NULL,
  `clazz_id` char(8) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacher_id` char(6) NOT NULL COMMENT '老师编号 由T开头 身份(1)+学院(2)+编号(3)',
  `teacher_name` varchar(20) NOT NULL,
  `teacher_sex` enum('男','女') DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teacher_course`
--

DROP TABLE IF EXISTS `teacher_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course` (
  `course_id` char(5) NOT NULL,
  `teacher_id` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17  0:24:08
