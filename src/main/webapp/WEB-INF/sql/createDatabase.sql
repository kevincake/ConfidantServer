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
  `friends` text,
  `sex` int(11) NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL,
  `account` text NOT NULL,
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;