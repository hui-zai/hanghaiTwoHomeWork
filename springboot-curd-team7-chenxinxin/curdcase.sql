/*
Navicat MySQL Data Transfer

Source Server         : yostar
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : curdcase

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-27 23:34:31
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yostar', 'yostar@qq.com', '1', '广东省', '篮球|编程|读书');
INSERT INTO `user` VALUES ('3', 'jo', 'jo@163.com', '0', '北京市', '读书|插画|弹琴');
INSERT INTO `user` VALUES ('4', '测试用户1', 'test1@qq.com', '0', '广东省', '篮球|读书');
INSERT INTO `user` VALUES ('5', '测试用户2', 'test2@qq.,com', '1', '重庆市', '插画|读书|弹琴');
INSERT INTO `user` VALUES ('6', '测试用户3', 'test3', '2', '辽宁省', '篮球');
INSERT INTO `user` VALUES ('7', '陈萍萍', 'ping@163.com', '2', '河北省', '读书');
INSERT INTO `user` VALUES ('8', '范闲', 'xian@163.com', '1', '北京市', '弹琴|读书');
INSERT INTO `user` VALUES ('9', '小竹竹', 'zhu@163.com', '1', '北京市', '读书');
INSERT INTO `user` VALUES ('12', '嘿嘿嘿', 'hei@163.com', '1', '北京市', '读书|篮球');
