/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cruddemo

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-01-03 10:11:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `hobby` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('9', '张三', 'test1@qq.com', '重庆市', '篮球', '0');
INSERT INTO `tb_user` VALUES ('10', '刘一', 'test2@qq.com', '河北省', '编程', '0');
INSERT INTO `tb_user` VALUES ('11', '李四', 'test3@qq.com', '河北省', '插画', '1');
INSERT INTO `tb_user` VALUES ('12', '王五', 'test4@qq.com', '河南省', '编程', '1');
INSERT INTO `tb_user` VALUES ('15', '赵六', 'test5@qq.com', '广东省', '弹琴', '1');
