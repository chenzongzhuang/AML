/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:08:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_target`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_target`;
CREATE TABLE `t_stan_target` (
  `target_id` varchar(200) NOT NULL DEFAULT '',
  `target_no` varchar(200) DEFAULT NULL,
  `target_desc` varchar(200) DEFAULT NULL,
  `target_properties` varchar(200) DEFAULT NULL,
  `target_count_fun` varchar(200) DEFAULT NULL,
  `target_count_con` varchar(200) DEFAULT NULL,
  `target_count_properties` varchar(200) DEFAULT NULL,
  `target_create_date` date DEFAULT NULL,
  `target_enable` varchar(200) DEFAULT NULL,
  `target_column1` varchar(200) DEFAULT NULL,
  `target_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`target_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_target
-- ----------------------------
INSERT INTO `t_stan_target` VALUES ('5ee8049f16224e5d92c04172ac538497', '', 'No', 'FE', 'mts', 'mts', 'mts', '2017-09-22', 'Y', null, '');
INSERT INTO `t_stan_target` VALUES ('b5dcc68222dd4f3f8f9de21b4c7669ca', null, null, null, null, null, null, '2017-09-22', 'Y', null, null);
INSERT INTO `t_stan_target` VALUES ('c4a87ddd7126425cbdf42de04eb09946', null, null, null, null, null, null, '2017-09-22', 'Y', null, null);
INSERT INTO `t_stan_target` VALUES ('fcf06b9c8dd54d6b8e50201ae1e8ea47', null, null, null, null, null, null, '2017-09-22', 'Y', null, null);
INSERT INTO `t_stan_target` VALUES ('ff39cfda107c4af981293e1d3267a09d', null, null, null, null, null, null, '2017-09-22', 'Y', null, null);
INSERT INTO `t_stan_target` VALUES ('mts', '', '', '', '', '', '', '2017-09-21', '', '', '');
