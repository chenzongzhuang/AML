/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:08:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_target_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_target_detail`;
CREATE TABLE `t_stan_target_detail` (
  `target_detail_id` varchar(200) DEFAULT NULL,
  `target_no` varchar(200) DEFAULT NULL,
  `target_desc` varchar(200) DEFAULT NULL,
  `target_count_con_desc` varchar(200) DEFAULT NULL,
  `target_create_date` date DEFAULT NULL,
  `target_enable` varchar(200) DEFAULT NULL,
  `target_column1` varchar(200) DEFAULT NULL,
  `target_id` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_target_detail
-- ----------------------------
INSERT INTO `t_stan_target_detail` VALUES ('9664fe314f874880817812b501839502', null, 'mtsxasxaswqcqwcwq', 'mtsxsaxsawdqqwdqw', '2017-09-27', 'Y', null, 'ff39cfda107c4af981293e1d3267a09d');
INSERT INTO `t_stan_target_detail` VALUES ('fb91a9a27aeb4d25ae979452a2a25ce8', null, 'qwdqw', 'dwqd', '2017-09-27', 'Y', null, 'bceeabda509f4a7791a525f9cdce09e8');
INSERT INTO `t_stan_target_detail` VALUES ('ce9a99bbb9a64dab88bb5d61634eb225', null, null, null, '2017-09-27', 'Y', null, 'bceeabda509f4a7791a525f9cdce09e8');
INSERT INTO `t_stan_target_detail` VALUES ('19fc604fc1c546e3a184fa681423835d', null, 'dqwdqw', 'dqwdqw', '2017-09-27', 'Y', null, 'bceeabda509f4a7791a525f9cdce09e8');
INSERT INTO `t_stan_target_detail` VALUES ('26283ab088944ababdb38f85e488acd0', null, 'tgyh', 'bhuj', '2017-09-27', 'Y', null, 'bceeabda509f4a7791a525f9cdce09e8');
