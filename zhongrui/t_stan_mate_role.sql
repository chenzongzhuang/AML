/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:07:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_mate_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_mate_role`;
CREATE TABLE `t_stan_mate_role` (
  `mate_id` varchar(200) DEFAULT NULL,
  `mate_no` varchar(200) DEFAULT NULL,
  `mate_name` varchar(200) DEFAULT NULL,
  `mate_type` varchar(200) DEFAULT NULL,
  `mate_type_roll` varchar(200) DEFAULT NULL,
  `mate_desc` varchar(200) DEFAULT NULL,
  `mate_role_con` varchar(200) DEFAULT NULL,
  `mate_status` varchar(200) DEFAULT NULL,
  `mate_create_date` date DEFAULT NULL,
  `mate_create_by` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_mate_role
-- ----------------------------
INSERT INTO `t_stan_mate_role` VALUES ('eeeb1207f6ea459ebb2e406c91bb5641', '下A', 'X啊', '行啊', 'X啊', '下A', null, 'X啊', '2017-10-09', null);
INSERT INTO `t_stan_mate_role` VALUES ('631c19764d8e48c28be3e66fc8b79ff0', '小阿三', '小阿三', '小阿三', '小阿三', '小阿三', null, 'YES', '2017-10-09', null);
INSERT INTO `t_stan_mate_role` VALUES ('299ef6c8836546b993a6b5bffa2f4fe4', '下A', 'X啊', '下A', 'XA ', '下', null, 'on', '2017-10-09', null);
INSERT INTO `t_stan_mate_role` VALUES ('4fd24545c93140b7ac1b0a7ab7560cec', 'X啊', '下A', 'X啊', '下A', 'X啊', null, 'on', '2017-10-09', null);
INSERT INTO `t_stan_mate_role` VALUES ('d8a160d1601c494c8ab70b38a3779cdc', '下A', 'X啊', '下', 'X ', '下', null, 'on', '2017-10-09', null);
