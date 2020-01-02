/*
Navicat MySQL Data Transfer

Source Server         : wzj
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : wzj

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-01-02 23:22:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` char(1) DEFAULT '1',
  `province` varchar(10) DEFAULT NULL,
  `hobby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
