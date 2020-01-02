/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : vue

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 02/01/2020 22:51:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vue
-- ----------------------------
DROP TABLE IF EXISTS `vue`;
CREATE TABLE `vue`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of vue
-- ----------------------------
INSERT INTO `vue` VALUES (1, 'gsy', 'kkkk', '女', '河南省', '插画,篮球');
INSERT INTO `vue` VALUES (51, '广州航海学院', '灌灌灌灌灌', '未知', '河南省', '编程,读书');
INSERT INTO `vue` VALUES (52, '顾诗宇', '32235235', '男', '河南省', '读书');
INSERT INTO `vue` VALUES (53, 'guciy', '3262', '男', '辽宁省', '读书,编程,弹琴');

SET FOREIGN_KEY_CHECKS = 1;
