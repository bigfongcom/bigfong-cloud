/*
Navicat MySQL Data Transfer

Source Server         : local-mysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : cloud_demo_member

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-04-13 19:54:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for es_member
-- ----------------------------
DROP TABLE IF EXISTS `es_member`;
CREATE TABLE `es_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_name` varchar(30) DEFAULT NULL COMMENT '会员名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别 1男0女',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `birthday` date DEFAULT NULL COMMENT '出生日',
  `createTime` datetime DEFAULT NULL COMMENT '注册日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of es_member
-- ----------------------------
INSERT INTO `es_member` VALUES ('1', '哈哈', '1', '111', '1', '1111', '2018-12-13', '2018-12-13 14:27:38');

-- ----------------------------
-- Table structure for es_member_role
-- ----------------------------
DROP TABLE IF EXISTS `es_member_role`;
CREATE TABLE `es_member_role` (
  `id` int(11) NOT NULL COMMENT '主键',
  `member_id` int(11) DEFAULT NULL COMMENT '会员id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of es_member_role
-- ----------------------------
INSERT INTO `es_member_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for es_permission
-- ----------------------------
DROP TABLE IF EXISTS `es_permission`;
CREATE TABLE `es_permission` (
  `id` int(11) NOT NULL COMMENT '权限id',
  `method` varchar(10) DEFAULT NULL COMMENT '方法类型',
  `zuul_prefix` varchar(30) DEFAULT NULL COMMENT '网关前缀',
  `service_prefix` varchar(30) DEFAULT NULL COMMENT '服务前缀',
  `uri` varchar(100) DEFAULT NULL COMMENT '请求路径',
  `createTime` datetime DEFAULT NULL COMMENT '创建日期',
  `updateTime` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of es_permission
-- ----------------------------
INSERT INTO `es_permission` VALUES ('1', 'GET', '/api', '/auth', 'exit', '2018-12-14 09:45:35', '2018-12-14 09:45:37');
INSERT INTO `es_permission` VALUES ('2', 'GET', '/api', '/auth', 'member', '2018-12-17 13:23:25', '2018-12-17 13:23:27');
INSERT INTO `es_permission` VALUES ('3', 'GET', '/api', '/member', 'hello', '2018-12-17 13:23:25', '2018-12-17 13:23:25');
INSERT INTO `es_permission` VALUES ('4', 'GET', '/api', '/member', 'current', '2018-12-17 13:23:25', '2018-12-17 13:23:25');
INSERT INTO `es_permission` VALUES ('5', 'GET', '/api', '/member', 'query', '2018-12-17 13:23:25', '2018-12-17 13:23:25');

-- ----------------------------
-- Table structure for es_role
-- ----------------------------
DROP TABLE IF EXISTS `es_role`;
CREATE TABLE `es_role` (
  `id` int(11) NOT NULL COMMENT '角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `valid` tinyint(1) DEFAULT NULL COMMENT '是否有效 1是 0否',
  `createTime` datetime DEFAULT NULL COMMENT '创建日期',
  `updateTime` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of es_role
-- ----------------------------
INSERT INTO `es_role` VALUES ('1', 'ROLE_ADMIN', '1', '2018-12-14 09:46:01', '2018-12-14 09:46:03');
INSERT INTO `es_role` VALUES ('2', 'ROLE_USER', '1', '2018-12-14 09:46:16', '2018-12-14 09:46:18');

-- ----------------------------
-- Table structure for es_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `es_role_permission`;
CREATE TABLE `es_role_permission` (
  `id` int(11) NOT NULL COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of es_role_permission
-- ----------------------------
INSERT INTO `es_role_permission` VALUES ('1', '1', '1');
INSERT INTO `es_role_permission` VALUES ('2', '1', '2');
INSERT INTO `es_role_permission` VALUES ('4', '1', '4');
INSERT INTO `es_role_permission` VALUES ('5', '1', '5');
