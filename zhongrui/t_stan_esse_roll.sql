/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:07:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_esse_roll`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_esse_roll`;
CREATE TABLE `t_stan_esse_roll` (
  `esse_id` varchar(200) DEFAULT NULL,
  `esse_name` varchar(200) DEFAULT NULL,
  `esse_nation` varchar(200) DEFAULT NULL,
  `esse_cust_type` varchar(200) DEFAULT NULL,
  `esse_cust_name` varchar(200) DEFAULT NULL,
  `esse_bri_date` date DEFAULT NULL,
  `esse_address` varchar(200) DEFAULT NULL,
  `esse_tel` varchar(200) DEFAULT NULL,
  `esse_roll_category` varchar(200) DEFAULT NULL,
  `esse_roll_source` varchar(200) DEFAULT NULL,
  `esse_type` varchar(200) DEFAULT NULL,
  `esse_create_date` date DEFAULT NULL,
  `esse_create_by` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_esse_roll
-- ----------------------------
