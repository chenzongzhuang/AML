/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:08:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `target_rule_detail`
-- ----------------------------
DROP TABLE IF EXISTS `target_rule_detail`;
CREATE TABLE `target_rule_detail` (
  `rule_id` varchar(200) DEFAULT NULL,
  `target_rule_id` varchar(200) DEFAULT NULL,
  `rule_no` varchar(200) DEFAULT NULL,
  `rule_name` varchar(200) DEFAULT NULL,
  `rule_condition_name` varchar(200) DEFAULT NULL,
  `rule_category` varchar(200) DEFAULT NULL,
  `rule_desc` varchar(200) DEFAULT NULL,
  `rule_create_date` date DEFAULT NULL,
  `rule_enable` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of target_rule_detail
-- ----------------------------
INSERT INTO `target_rule_detail` VALUES ('afe1ff40c5dc42cf99762aded44afc5a', '1d9b3c49072b4a06871c601b8e7ec81b', null, 'casc', 'casc', 'IN', 'csacasc', '2017-09-29', 'Y');
INSERT INTO `target_rule_detail` VALUES ('c716036fef064843811389896386b5a7', '1d9b3c49072b4a06871c601b8e7ec81b', null, 'sac', 'sac', 'FE', 'csac', '2017-09-29', 'Y');
