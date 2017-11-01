/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:10:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_area_roll`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_area_roll`;
CREATE TABLE `t_stan_area_roll` (
  `area_roll_id` varchar(200) DEFAULT NULL,
  `area_roll_type` varchar(200) DEFAULT NULL,
  `area_type` varchar(200) DEFAULT NULL,
  `area_model` varchar(200) DEFAULT NULL,
  `area_en` varchar(200) DEFAULT NULL,
  `area_name` varchar(200) DEFAULT NULL,
  `area_qu` varchar(200) DEFAULT NULL,
  `area_create_date` date DEFAULT NULL,
  `area_create_by` varchar(200) DEFAULT NULL,
  `ares_update_date` date DEFAULT NULL,
  `area_update_by` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_area_roll
-- ----------------------------
INSERT INTO `t_stan_area_roll` VALUES ('b6ee3c211b8e4cec89c07f93d5338205', '1', '1', '潇洒', null, '潇洒', '小阿三', '2017-10-10', null, '2017-10-10', null);
INSERT INTO `t_stan_area_roll` VALUES ('cac5b22e928f4b178108aee73b77c28a', '1', '1', '潇洒', null, '小阿三', '小阿三', '2017-10-10', null, '2017-10-10', null);
INSERT INTO `t_stan_area_roll` VALUES ('ecd3178d73464b91b9da4bdbb6182ecf', '1', '1', '啊洒洒水', null, '啊啊', '谢谢撒', '2017-10-10', null, '2017-10-10', null);
