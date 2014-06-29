-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema those_people
--

CREATE DATABASE IF NOT EXISTS those_people;
USE those_people;

--
-- Definition of table `info_statics`
--

DROP TABLE IF EXISTS `info_statics`;
CREATE TABLE `info_statics` (
  `infoId` int(10) unsigned NOT NULL,
  `likes` tinyint(6) unsigned default '0',
  `collects` tinyint(6) unsigned default '0',
  `visits` tinyint(6) unsigned default '0',
  `comments` tinyint(6) unsigned default '0',
  `infoType` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY  (`infoId`,`infoType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `info_statics`
--

/*!40000 ALTER TABLE `info_statics` DISABLE KEYS */;
/*!40000 ALTER TABLE `info_statics` ENABLE KEYS */;


--
-- Definition of table `job_info`
--

DROP TABLE IF EXISTS `job_info`;
CREATE TABLE `job_info` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `uid` int(10) unsigned NOT NULL,
  `title` varchar(45) NOT NULL,
  `workplace` varchar(45) NOT NULL COMMENT '工作地点',
  `jobtype` tinyint(3) unsigned NOT NULL COMMENT '信息类型：实习；社招；校招',
  `isOutOfDate` bit(1) default '\0' COMMENT '0：没过期；1：过期',
  `postdate` datetime default NULL COMMENT '发表日期',
  `company` varchar(45) NOT NULL,
  `content` text NOT NULL,
  `requires` text NOT NULL,
  `email` varchar(30) NOT NULL,
  `tel` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job_info`
--

/*!40000 ALTER TABLE `job_info` DISABLE KEYS */;
INSERT INTO `job_info` (`id`,`uid`,`title`,`workplace`,`jobtype`,`isOutOfDate`,`postdate`,`company`,`content`,`requires`,`email`,`tel`) VALUES 
 (2,38,'阿里巴巴','北京',1,0x00,'2014-04-11 19:55:40','阿里巴巴','format','format','format@qq.com',''),
 (3,38,'php工程师','北京 杭州',1,0x00,'2014-04-18 18:08:23','阿里巴巴','程序员要求\r\n1． 重点大学计算机或科学计算相关专业本科及以上学历\r\n2． 熟悉多种高级程序语言，例如C++,Java\r\n3． 熟悉Linux及Windows下脚本语言编程，例如perl和python\r\n4． 熟悉网络编程语言与模式\r\n5． 对关系数据库建立，维护，与编程有一定经验\r\n6． 重视合作，具备团队精神\r\n7． 善于交流，可以面向非专业客户讲解技术细节\r\n8． 有责任心，有主观能动性\r\n','程序员要求\r\n1． 重点大学计算机或科学计算相关专业本科及以上学历\r\n2． 熟悉多种高级程序语言，例如C++,Java\r\n3． 熟悉Linux及Windows下脚本语言编程，例如perl和python\r\n4． 熟悉网络编程语言与模式\r\n5． 对关系数据库建立，维护，与编程有一定经验\r\n6． 重视合作，具备团队精神\r\n7． 善于交流，可以面向非专业客户讲解技术细节\r\n8． 有责任心，有主观能动性\r\n','1@qq.com',''),
 (4,38,'php工程师','北京 杭州',1,0x00,'2014-04-18 18:09:14','阿里巴巴','程序员要求\r\n1． 重点大学计算机或科学计算相关专业本科及以上学历\r\n2． 熟悉多种高级程序语言，例如C++,Java\r\n3． 熟悉Linux及Windows下脚本语言编程，例如perl和python\r\n4． 熟悉网络编程语言与模式\r\n5． 对关系数据库建立，维护，与编程有一定经验\r\n6． 重视合作，具备团队精神\r\n7． 善于交流，可以面向非专业客户讲解技术细节\r\n8． 有责任心，有主观能动性\r\n','程序员要求\r\n1． 重点大学计算机或科学计算相关专业本科及以上学历\r\n2． 熟悉多种高级程序语言，例如C++,Java\r\n3． 熟悉Linux及Windows下脚本语言编程，例如perl和python\r\n4． 熟悉网络编程语言与模式\r\n5． 对关系数据库建立，维护，与编程有一定经验\r\n6． 重视合作，具备团队精神\r\n7． 善于交流，可以面向非专业客户讲解技术细节\r\n8． 有责任心，有主观能动性\r\n','1@qq.com',''),
 (5,38,'CTO','北京',1,0x00,'2014-04-19 14:29:13','those_people','<!--[if !supportLists]-->1． <!--[endif]-->完成刊物的组稿、编辑加工等，能够认真负责地处理在此过程中的所有有关业务。\r\n\r\n<!--[if !supportLists]-->2． <!--[endif]-->协调我社和刊物的共同主办方的关系，处理合作中出现的各种问题。\r\n\r\n<!--[if !supportLists]-->3． <!--[endif]-->能够完成事业部领导及分社交办的其他工作，包括（但不限于）刊物的宣传、营销等。\r\n','任 职 资 格：\r\n\r\n<!--[if !supportLists]-->1． <!--[endif]-->性别：不限。\r\n\r\n<!--[if !supportLists]-->2． <!--[endif]-->身体条件：良好。年龄在28岁以下。\r\n\r\n<!--[if !supportLists]-->3． <!--[endif]-->所学专业：计算机及相关专业。\r\n\r\n<!--[if !supportLists]-->4． <!--[endif]-->教育程度及相关工作经验：硕士以上（含）学历，有编辑工作经验者优先。\r\n\r\n<!--[if !supportLists]-->5． <!--[endif]-->基本素质：有较为扎实的文字功底；英语听说读写熟练；较善于与学者沟通。\r\n','1@qq.com',''),
 (6,38,'xss','北京',1,0x00,'2014-04-19 14:42:48','xss test ','<a href =\"www.baidu.com\"> 我的链接</a>','<a href =\"www.baidu.com\"> 我的链接</a>','s@qq.com',''),
 (7,38,'php工程师','北京 杭州',1,0x00,'2014-04-19 15:52:46','埃里巴巴','400','400','1@qq.com',''),
 (8,38,'php工程师','事务提交',1,0x00,'2014-04-19 15:53:28','埃里巴巴','\r\nfunction verifyEmailFormat(email) {\r\n	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;\r\n	if (format.test(email)) {\r\n		return true;\r\n	}\r\n	return false;\r\n}\r\n','\r\nfunction verifyEmailFormat(email) {\r\n	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;\r\n	if (format.test(email)) {\r\n		return true;\r\n	}\r\n	return false;\r\n}\r\n','1@qq.com',''),
 (9,38,'php工程师','北京 杭州',1,0x00,'2014-04-19 15:54:26','阿里巴巴','\r\nfunction verifyEmailFormat(email) {\r\n	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;\r\n	if (format.test(email)) {\r\n		return true;\r\n	}\r\n	return false;\r\n}\r\n','\r\nfunction verifyEmailFormat(email) {\r\n	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;\r\n	if (format.test(email)) {\r\n		return true;\r\n	}\r\n	return false;\r\n}\r\n','1@qq.com',''),
 (10,38,'ss\"><script>alert(document.cookie)</script>','北京 杭州',1,0x00,'2014-04-19 16:44:02','埃里巴巴','<script>alert(document.cookie)</script>','<script>alert(document.cookie)</script>','1@qq.com','');
/*!40000 ALTER TABLE `job_info` ENABLE KEYS */;


--
-- Definition of table `job_info_comment`
--

DROP TABLE IF EXISTS `job_info_comment`;
CREATE TABLE `job_info_comment` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `infoid` int(10) unsigned NOT NULL,
  `commentuserId` int(10) unsigned NOT NULL,
  `beReplieduserId` int(10) unsigned default NULL,
  `content` varchar(500) NOT NULL,
  `replyTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job_info_comment`
--

/*!40000 ALTER TABLE `job_info_comment` DISABLE KEYS */;
INSERT INTO `job_info_comment` (`id`,`infoid`,`commentuserId`,`beReplieduserId`,`content`,`replyTime`) VALUES 
 (1,1,38,1,'随便说点甚么','2014-04-03 20:07:05'),
 (2,1,38,1,'随便说点甚么','2014-04-03 20:14:21'),
 (3,1,38,1,'随便缩一点','2014-04-03 20:15:11'),
 (4,1,38,1,'随便缩一点','2014-04-03 20:15:45'),
 (5,1,38,1,'打死打死','2014-04-03 20:16:16'),
 (6,1,38,1,'撒打算打算·','2014-04-03 20:18:03'),
 (7,1,38,1,'撒打算打算·','2014-04-03 20:18:07'),
 (8,1,38,1,'打死打死','2014-04-03 20:18:45'),
 (9,1,38,1,'打死打死','2014-04-03 20:18:48'),
 (10,1,38,1,'打死打死','2014-04-03 20:18:49'),
 (11,1,38,1,'打死打死','2014-04-03 20:18:50'),
 (12,1,38,1,'随便说点甚么','2014-04-03 20:37:54'),
 (13,2,38,1,'asdas','2014-04-10 18:26:53'),
 (14,2,38,1,'asdas','2014-04-10 18:26:55');
/*!40000 ALTER TABLE `job_info_comment` ENABLE KEYS */;


--
-- Definition of table `love_info`
--

DROP TABLE IF EXISTS `love_info`;
CREATE TABLE `love_info` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) NOT NULL,
  `selfDescribe` text NOT NULL,
  `expectOther` text NOT NULL,
  `picturePath` int(11) default NULL,
  `contactWay` varchar(25) NOT NULL,
  `uid` int(11) NOT NULL,
  `postTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `love_info`
--

/*!40000 ALTER TABLE `love_info` DISABLE KEYS */;
INSERT INTO `love_info` (`id`,`title`,`selfDescribe`,`expectOther`,`picturePath`,`contactWay`,`uid`,`postTime`) VALUES 
 (1,'1','1','1',NULL,'1369763362@qq.com',33,'2014-03-25 17:10:55'),
 (2,'1','1','1',NULL,'1369763362@qq.com',33,'2014-03-25 17:23:42'),
 (3,'1','1','1',NULL,'1369763362@qq.com',33,'2014-03-29 16:59:47'),
 (4,'帮室友征男友 有图有真相','室友标准文艺女青年一枚，但绝对不是不食人间烟火那种，属于正经的时候正经，文艺的时候文艺，逗逼的时候逗逼的那种，会画画，弹吉他，文笔超级好。\r\n\r\n    最重要的是人超级善良，有爱心，真诚实在，没心眼儿，打扮潮范儿~\r\n\r\n    10级今年毕业，东北妞儿，毕业后工作暂定在北京或者天津，身高175cm，感情史几乎空白，真诚求好男生带走，你绝对值得拥有！','对男友的要求：身高180+，北方人（东北最好），逗逼最好……不要书呆子型的……其他的还是要具体磨合~',NULL,'1369763362@qq.com',33,'2014-03-29 17:20:50'),
 (5,'找个真心相爱的人','1.普通工人家庭\r\n\r\n2.爱好读书，喜欢旅游\r\n\r\n3.是个温柔的妹子','1.有责任心上进\r\n\r\n2.看眼缘',NULL,'1369763362@qq.com',33,'2014-03-30 11:32:53'),
 (6,'1','11','11',NULL,'1369763362@qq.com',33,'2014-03-30 11:36:10'),
 (7,'1','11','11',NULL,'1369763362@qq.com',33,'2014-03-30 11:36:51'),
 (8,'1','11','11',NULL,'1369763362@qq.com',33,'2014-03-30 11:37:20'),
 (9,'1','11','11',NULL,'1369763362@qq.com',33,'2014-03-30 11:38:37'),
 (10,'等等','的','的',NULL,'1369763362@qq.com',33,'2014-03-30 11:46:30'),
 (11,'等等','的','的',NULL,'1369763362@qq.com',33,'2014-03-30 11:46:55'),
 (12,'等等','的','的',NULL,'1369763362@qq.com',33,'2014-03-30 11:48:31'),
 (13,'等等','的','的',NULL,'1369763362@qq.com',33,'2014-03-30 11:55:21'),
 (14,'等等','的','的',NULL,'1369763362@qq.com',33,'2014-03-30 11:56:11'),
 (15,'等等','的','的',NULL,'1369763362@qq.com',33,'2014-03-30 11:56:36'),
 (16,'111','11','11111',NULL,'1369763362@qq.com',33,'2014-03-30 11:58:03');
/*!40000 ALTER TABLE `love_info` ENABLE KEYS */;


--
-- Definition of table `love_info_comment`
--

DROP TABLE IF EXISTS `love_info_comment`;
CREATE TABLE `love_info_comment` (
  `id` int(11) NOT NULL auto_increment COMMENT '评论编号',
  `infoId` int(11) NOT NULL default '0',
  `commentUserId` int(11) NOT NULL default '0',
  `beRepliedUserId` int(11) default '0' COMMENT '回复某平路时被回复评论的id',
  `content` int(11) NOT NULL,
  `replyTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `love_info_comment`
--

/*!40000 ALTER TABLE `love_info_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `love_info_comment` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL auto_increment COMMENT '用户唯一标识id',
  `realName` varchar(20) collate utf8_bin NOT NULL COMMENT '真实姓名',
  `nickName` varchar(20) collate utf8_bin NOT NULL,
  `password` char(32) collate utf8_bin NOT NULL,
  `email` varchar(100) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UNIQUE_INDEX_EMAIL_PASSWORD` (`email`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`realName`,`nickName`,`password`,`email`) VALUES 
 (38,0x68696861,0x68696861,0x6166366531366265643236643038623733663034326435363763646434363632,0x686968614071712E636F6D),
 (41,0x68696869,0x68696869,0x6362313830343336363131303232646163666238626236346237356536653162,0x686968694071712E636F6D),
 (42,0x68756875,0x68756875,0x3335336339656531316363386165636235303931623839653433313736333363,0x687568754071712E636F6D);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `uid` int(10) unsigned NOT NULL default '0',
  `gender` bit(1) NOT NULL default '\0',
  `city` varchar(30) collate utf8_bin NOT NULL,
  `school` varchar(45) collate utf8_bin NOT NULL,
  `major` varchar(45) collate utf8_bin NOT NULL,
  `enrollmentDate` date NOT NULL,
  `signature` varchar(100) collate utf8_bin default NULL,
  `showType` bit(1) NOT NULL default '\0',
  `company` varchar(30) collate utf8_bin default NULL,
  `headPicPath` varchar(100) collate utf8_bin default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_detail`
--

/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` (`uid`,`gender`,`city`,`school`,`major`,`enrollmentDate`,`signature`,`showType`,`company`,`headPicPath`) VALUES 
 (38,0x00,0xE5A4A9E6B4A5,0xE58D97E5BC80E5A4A7E5ADA6,'','2014-01-01','',0x00,0x74686F7365,0x2E2E2F75706C6F61642F686561647069632F313339363532353738393437305F33382E6A7067),
 (41,0x00,0xE58C97E4BAAC,0xE58D97E5BC80E5A4A7E5ADA6,'','1998-01-01',0xE69292E68993E7AE97E68993E7AE97,0x00,0x74686973,0x2E2E2F75706C6F61642F686561647069632F313430303635373139343137325F34312E6A7067),
 (42,0x00,0xE5A4A9E6B4A5,0x61647361,'','2014-01-01',0x73616461736473,0x00,0x64617764617764,0x2E2E2F75706C6F61642F686561647069632F313430303635373431363231325F34322E6A7067);
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;


--
-- Definition of table `user_statics`
--

DROP TABLE IF EXISTS `user_statics`;
CREATE TABLE `user_statics` (
  `uid` int(10) unsigned NOT NULL,
  `infoType` int(10) unsigned NOT NULL,
  `likes` varchar(200) NOT NULL default '0',
  `collects` varchar(200) NOT NULL default '0',
  `comments` varchar(200) NOT NULL default '0',
  PRIMARY KEY  (`infoType`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_statics`
--

/*!40000 ALTER TABLE `user_statics` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_statics` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
