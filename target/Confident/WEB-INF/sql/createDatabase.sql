# set password for 'root'@'localhost'=password('root');
drop database if exists confidant;
CREATE DATABASE  confidant;
USE confidant;
/*
friend
 */
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` text,
  `friendAccount` text,
  `isBlack` int(11) NOT NULL,
  `isProtect` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*
user
 */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userName` text NOT NULL,
  `password` text NOT NULL,
  `birthday` longtext,
  `habbit` longtext,
  `headIcon` longtext,
  `sex` int(11) NOT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `account` text NOT NULL,
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `lastlogintime` mediumtext,
  `confidantDeId` int(11) DEFAULT '0',
  `myConfidantId` int(11) DEFAULT NULL,
  `confidantStar` int(11) DEFAULT '0',
  `isLogin` int(11) DEFAULT NULL,
  `token` longtext,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;


/*gift*/

DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `count` int(11) DEFAULT '0',
  `toAccount` text,
  `itemId` int(11) DEFAULT '0',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `account` text,
  `msgText` text,
  `photo1` int(11) DEFAULT NULL,
  `time` longtext,
  `photo2` text,
  `photo3` text,
  `photo4` text,
  `photo5` text,
  `photo6` text,
  `heartType` int(11) DEFAULT NULL,
  `mobileName` text,
  `location` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `account` longtext,
  `chatType` int(11) DEFAULT '0',
  `voiceTime` int(11) DEFAULT '0',
  `videoTime` int(11) DEFAULT '0',
  `textTime` int(11) DEFAULT '0',
  `token` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

