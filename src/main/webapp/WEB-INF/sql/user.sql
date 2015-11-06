/*
Navicat MySQL Data Transfer

Source Server         : confidant
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : confidant

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-06 10:26:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
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
