/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:06:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_stan_area_roll_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_area_roll_type`;
CREATE TABLE `t_stan_area_roll_type` (
  `roll_id` varchar(200) DEFAULT NULL,
  `roll_en` varchar(200) DEFAULT NULL,
  `roll_name` varchar(200) DEFAULT NULL,
  `roll_cont` varchar(200) DEFAULT NULL,
  `roll_desc` varchar(200) DEFAULT NULL,
  `roll_type` varchar(200) DEFAULT NULL,
  `roll_create_date` date DEFAULT NULL,
  `roll_create_by` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_area_roll_type
-- ----------------------------
INSERT INTO `t_stan_area_roll_type` VALUES ('023664e40d064455882ce95c0234b561', null, '洒出', '吃撒', '擦拭', '吃撒', null, null);
INSERT INTO `t_stan_area_roll_type` VALUES ('773a115102194ca3b408bf1ee9c6de77', null, 'wqxa', 'wqsqwsqwsqwdsv', 'sqwxaswqsqwsqw', '2', null, null);
INSERT INTO `t_stan_area_roll_type` VALUES ('798eab99c54c41db9c0b130bf78d5014', null, 'xas', 'xasxas', 'xasxasxa', 'sxsax', null, null);
INSERT INTO `t_stan_area_roll_type` VALUES ('2b7a2259fde644a88d9f2340a82d207d', null, '下A', 'X啊', '行啊', '2', null, null);
INSERT INTO `t_stan_area_roll_type` VALUES ('2b6f06c962b342439264d9c40acbc939', null, 'SSQ ', ' SQ', 'C ', '1', null, null);
INSERT INTO `t_stan_area_roll_type` VALUES ('7a97ac2c0278478f875055ae5fdb6935', null, 'A', 'QX', 'QSQ', '---请选择---', null, null);

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

-- ----------------------------
-- Table structure for `t_stan_lookup`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_lookup`;
CREATE TABLE `t_stan_lookup` (
  `lookup_id` varchar(200) DEFAULT NULL,
  `lookup_type` varchar(200) DEFAULT NULL,
  `lookup_name` varchar(200) DEFAULT NULL,
  `lookup_en` varchar(200) DEFAULT NULL,
  `lookup_desc` varchar(200) DEFAULT NULL,
  `lookup_num` varchar(200) DEFAULT NULL,
  `lookup_create_date` date DEFAULT NULL,
  `lookup_create_by` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_lookup
-- ----------------------------
INSERT INTO `t_stan_lookup` VALUES ('c0bfec40441e42538661b0e35c28474c', 'ENABLETYPE', '作用类型', '1', '去除', '1', '2017-10-08', null);
INSERT INTO `t_stan_lookup` VALUES ('3b772e08c3aa4c95b01f212c8a3ce4ec', 'ENABLETYPE', '作用类型', '2', '切割', '2', '2017-10-08', null);
INSERT INTO `t_stan_lookup` VALUES ('b66a1efd38d4430abb1612b9b4312a3e', 'AREAROLLTYPE', '名单种类', '1', '高风险国家', '1', '2017-10-10', null);
INSERT INTO `t_stan_lookup` VALUES ('03b71efaada74cdcbc7dcca437d48ccb', 'AREATYPE', '地区种类', '1', '国家', '1', '2017-10-10', null);
INSERT INTO `t_stan_lookup` VALUES ('31f2b3efe89848dab13bf71650029a9b', '客户类别', 'CUSTOMERTYPE', '1', '客户', '1', '2017-10-11', null);
INSERT INTO `t_stan_lookup` VALUES ('9b2483e9e8b14551bc2798ce1a22ca87', 'CUSTOMERTYPE', '客户类别', '1', '客户', '1', '2017-10-11', null);
INSERT INTO `t_stan_lookup` VALUES ('4d70bc17cb924f429c0e605e8ae03270', 'CUSTOMERTYPE', '客户类别', '2', '商户', '2', '2017-10-11', null);

-- ----------------------------
-- Table structure for `t_stan_maiin`
-- ----------------------------
DROP TABLE IF EXISTS `t_stan_maiin`;
CREATE TABLE `t_stan_maiin` (
  `main_id` varchar(200) DEFAULT NULL,
  `main_type` varchar(200) DEFAULT NULL,
  `main_en` varchar(200) DEFAULT NULL,
  `main_in` varchar(200) DEFAULT NULL,
  `main_cn` varchar(200) DEFAULT NULL,
  `main_cn_full` varchar(200) DEFAULT NULL,
  `main_en_name` varchar(200) DEFAULT NULL,
  `main_en_full` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stan_maiin
-- ----------------------------
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', '7', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'naOrArea', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'naOrArea', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'naOrArea', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'coin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'coin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'coin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'coin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'coin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'coin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'tStanMainin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'tStanMainin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'tStanMainin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'tStanMainin', '7', '7', '7', '7', '7', '7');
INSERT INTO `t_stan_maiin` VALUES ('7', 'tStanMainin', '7', '7', '7', '7', '7', '7');

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

-- ----------------------------
-- Table structure for `target_entity`
-- ----------------------------
DROP TABLE IF EXISTS `target_entity`;
CREATE TABLE `target_entity` (
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
-- Records of target_entity
-- ----------------------------
INSERT INTO `target_entity` VALUES ('', 'mts', 'mts', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'wsqwijswqifubhijwqo');
INSERT INTO `target_entity` VALUES ('5f419b993a614ca394765e4f236b8bf1', 'xsaxm,las', 'xsamkxlas', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'xsamox,as');
INSERT INTO `target_entity` VALUES ('60bd0e83ed33404bb94de5b7a9cbdad2', 'xasxm,las', 'xasxkml,as', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'xsaxm,ls;a');
INSERT INTO `target_entity` VALUES ('780201db17fc4a06ac302900d2a9951e', 'eciwoimedw', 'dwqijdkoqwpdwq', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'dqwiojdmoqwdwq');
INSERT INTO `target_entity` VALUES ('7e7f7802cb604eb884d4a7d1717397a7', null, 'xsa', null, null, null, null, '2017-09-30', 'Y', null, null);
INSERT INTO `target_entity` VALUES ('8d739d2ffd714906aef0ae2c70731ade', '', '', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, '');
INSERT INTO `target_entity` VALUES ('9a6c019158eb40048522b3eff469778a', null, 'dwqdqw', null, null, null, null, '2017-09-30', 'Y', null, null);
INSERT INTO `target_entity` VALUES ('b181cfc24fa0499bae8b4cf578fcbc18', 'xasomx,sl;axas', 'xsapomx,l;as', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'xsaxiomasl,x;as');
INSERT INTO `target_entity` VALUES ('d751f925eb7a43899a163ca47df5ef88', 'mts', 'ascas', 'FE', 'FE', 'FE', 'FE', '2017-09-27', 'Y', null, 'as');
INSERT INTO `target_entity` VALUES ('dbd099238e844658badc3a342ca10c5e', 'mts', 'No', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'mts');
INSERT INTO `target_entity` VALUES ('ecbda026e1684b998b75957f8d1b3d6b', '', 'No', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, '');
INSERT INTO `target_entity` VALUES ('f03bf0574c5f4b648942e973ee50fc54', 'xsaxinaskmlxas', 'xsaiomxkaslxas', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'xsainxmoasklxas');
INSERT INTO `target_entity` VALUES ('f4e71bbc53f541798c3edd69eddc8ab0', null, 'xas', null, null, null, null, '2017-09-30', 'Y', null, null);
INSERT INTO `target_entity` VALUES ('f56ef8bbc3d042f2bd2198c0d8d2755a', 'xsaxkkaslxsa', 'xsajxmskalxas', 'FE', 'FE', 'FE', 'FE', '2017-09-24', 'Y', null, 'xasjxnmkslax');
INSERT INTO `target_entity` VALUES ('ff39cfda107c4af981293e1d3267a09d', null, null, null, null, null, null, '2017-09-22', 'Y', null, null);

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
