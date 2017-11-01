/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:08:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `trading_standard`
-- ----------------------------
DROP TABLE IF EXISTS `trading_standard`;
CREATE TABLE `trading_standard` (
  `rule_id` varchar(200) DEFAULT NULL,
  `rule_no` varchar(200) DEFAULT NULL,
  `rule_name` varchar(200) DEFAULT NULL,
  `rule_condition_name` varchar(200) DEFAULT NULL,
  `rule_category` varchar(200) DEFAULT NULL,
  `rule_desc` varchar(200) DEFAULT NULL,
  `rule_create_date` date DEFAULT NULL,
  `rule_enable` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trading_standard
-- ----------------------------
INSERT INTO `trading_standard` VALUES ('7ed3279e54a5471599f98c5e5d75a23b', null, null, null, null, null, '2017-09-30', 'Y');
INSERT INTO `trading_standard` VALUES ('12bde00c4bca4781b62b9c3198a910d8', null, null, 'xsa', null, 'xsax', '2017-09-30', 'Y');
