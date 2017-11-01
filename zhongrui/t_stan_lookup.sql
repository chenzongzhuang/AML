/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : amldb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 18:07:44
*/

SET FOREIGN_KEY_CHECKS=0;

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
