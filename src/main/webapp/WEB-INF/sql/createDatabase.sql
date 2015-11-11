set password for 'root'@'localhost'=password('root');
drop database if exists confidant;
CREATE DATABASE  confidant;
USE confidant;
/*
friend
 */
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `friendId` int(11) NOT NULL,
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
  `birthday` text NOT NULL,
  `habbit` text NOT NULL,
  `headIcon` text NOT NULL,
  `sex` int(11) NOT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float NOT NULL,
  `account` text NOT NULL,
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `lastlogintime` mediumtext,
  `confidantDeId` int(11) DEFAULT '0',
  `myConfidantId` int(11) NOT NULL,
  `confidantStar` int(11) DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;


/*gift*/

DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `id` mediumtext NOT NULL,
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT '0',
  `fromUserId` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `userId` int(11) NOT NULL,
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
  `userId` int(11) NOT NULL,
  `chatType` int(11) DEFAULT '0',
  `voiceTime` int(11) DEFAULT '0',
  `videoTime` int(11) DEFAULT '0',
  `textTime` int(11) DEFAULT '0',
  `token` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

