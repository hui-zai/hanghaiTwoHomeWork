/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : hh2db

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2020-01-02 19:59:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userinfo`;
CREATE TABLE `tbl_userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `hobby` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_userinfo
-- ----------------------------
INSERT INTO `tbl_userinfo` VALUES ('3', '王五', '5656@163.com', '女', '广东省', '跳舞,插画,篮球,读书,弹琴,编程');
INSERT INTO `tbl_userinfo` VALUES ('4', '解决', '解决', '男', '北京市', '插画,读书');
INSERT INTO `tbl_userinfo` VALUES ('5', '发放', '发发发', '男', '北京市', '插画,读书,篮球');
INSERT INTO `tbl_userinfo` VALUES ('6', '2', '法法', '男', '北京市', '读书,篮球');
INSERT INTO `tbl_userinfo` VALUES ('7', '666666', '6666', '男', '重庆市', '弹琴,编程');
INSERT INTO `tbl_userinfo` VALUES ('8', '发发发', '发发发', '男', '北京市', '读书,篮球');
INSERT INTO `tbl_userinfo` VALUES ('10', '斗逗', '333', '男', '北京市', '篮球,读书');
