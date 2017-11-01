/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:08:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_target_rule`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_target_rule`;
CREATE TABLE `t_stan_target_rule` (
  `rule_id` varchar(200) DEFAULT NULL,
  `rule_no` varchar(200) DEFAULT NULL,
  `rule_name` varchar(200) DEFAULT NULL,
  `rule_category` varchar(200) DEFAULT NULL,
  `rule_apply` varchar(200) DEFAULT NULL,
  `rule_per` varchar(200) DEFAULT NULL,
  `rule_condition` varchar(200) DEFAULT NULL,
  `rule_status` varchar(200) DEFAULT NULL,
  `rule_desc` varchar(200) DEFAULT NULL,
  `rule_create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_target_rule
-- ----------------------------
INSERT INTO `t_stan_target_rule` VALUES ('cd80b51d209d4d65b808675c718f96ed', 'xasxas', 'xasx', 'asxas', 'FE', 'FE', 'FE', 'Y', 'xsaxas', '2017-09-28');
INSERT INTO `t_stan_target_rule` VALUES ('1d9b3c49072b4a06871c601b8e7ec81b', 'xas', 'xsa', 'FE', 'FE', 'FE', 'FE', 'Y', 'xsaxasxASXSAX', '2017-09-28');
INSERT INTO `t_stan_target_rule` VALUES ('a058d20f67a14a64aa3eddef369abf61', 'xAX', 'axAX', 'FE', 'FE', 'FE', 'FE', 'Y', 'Xax', '2017-09-29');
