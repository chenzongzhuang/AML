/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:08:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_target_com`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_target_com`;
CREATE TABLE `t_stan_target_com` (
  `target_no` varchar(200) DEFAULT NULL,
  `target_id` varchar(200) DEFAULT NULL,
  `target_name` varchar(200) DEFAULT NULL,
  `target_desc` varchar(200) DEFAULT NULL,
  `target_count` varchar(200) DEFAULT NULL,
  `target_count_fun` varchar(200) DEFAULT NULL,
  `target_count_per` varchar(200) DEFAULT NULL,
  `target_count_contaion` varchar(200) DEFAULT NULL,
  `target_count_con` varchar(200) DEFAULT NULL,
  `target_count_properties` varchar(200) DEFAULT NULL,
  `target_create_date` date DEFAULT NULL,
  `target_enable` varchar(200) DEFAULT NULL,
  `target_column1` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_target_com
-- ----------------------------
INSERT INTO `t_stan_target_com` VALUES ('xsaxas', 'bceeabda509f4a7791a525f9cdce09e8', 'cascassacsacas', 'csacsacascsa', 'xaXAewc', 'FE', 'FE', 'FE', 'FE', null, '2017-09-27', 'Y', null);
INSERT INTO `t_stan_target_com` VALUES ('xsacas', '43c50ca7494147f2a69ed6c7d36cd04d', 'sacasc', 'acascascas', 'ascascs', 'FE', 'FE', 'FE', 'FE', null, '2017-09-27', 'Y', null);
INSERT INTO `t_stan_target_com` VALUES ('csacas', '25cd1d6c1713405d8a059f0b9e84baba', 'casc', 'ascascascsdfwa', 'ascascasc', 'FE', 'FE', 'FE', 'FE', null, '2017-09-27', 'Y', null);
