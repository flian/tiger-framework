/*
Navicat MySQL Data Transfer

Source Server         : 172.19.64.35
Source Server Version : 50622
Source Host           : 172.19.64.35:3306
Source Database       : ettodaypoc

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-05-30 13:33:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shiro_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permissions`;
CREATE TABLE `shiro_permissions` (
  `ID` double(22,0) NOT NULL,
  `PERMISSION_DESCRIPTION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_permissions
-- ----------------------------
INSERT INTO `shiro_permissions` VALUES ('1', 'admin_add');
INSERT INTO `shiro_permissions` VALUES ('2', 'admin_modify');
INSERT INTO `shiro_permissions` VALUES ('3', 'admin_delete');
INSERT INTO `shiro_permissions` VALUES ('4', 'admin_read');
INSERT INTO `shiro_permissions` VALUES ('5', 'operator_read');
INSERT INTO `shiro_permissions` VALUES ('6', 'operator_write');

-- ----------------------------
-- Table structure for `shiro_resources`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_resources`;
CREATE TABLE `shiro_resources` (
  `ID` double(22,0) NOT NULL,
  `RESOURCE_TYPE` double(22,0) DEFAULT NULL,
  `RESOURCE_NAME` varchar(100) DEFAULT NULL,
  `RESOURCE_URL` text,
  `CREATE_AT` datetime DEFAULT NULL,
  `UPDATE_AT` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_resources
-- ----------------------------
INSERT INTO `shiro_resources` VALUES ('1', '1', '高机密菜单', 'http://highconfidential', null, null);
INSERT INTO `shiro_resources` VALUES ('2', '1', '普通机密菜单', 'http://normalconfidential', null, null);
INSERT INTO `shiro_resources` VALUES ('3', '1', '普通菜单', 'http://normal', null, null);
INSERT INTO `shiro_resources` VALUES ('4', '1', '系统操作员菜单', 'http://operatormenu', null, null);
INSERT INTO `shiro_resources` VALUES ('5', '2', '某按钮', 'http://somebutton1', null, null);

-- ----------------------------
-- Table structure for `shiro_roles`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_roles`;
CREATE TABLE `shiro_roles` (
  `ID` double(22,0) NOT NULL,
  `ROLE_DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_roles
-- ----------------------------
INSERT INTO `shiro_roles` VALUES ('1', 'global_admin');
INSERT INTO `shiro_roles` VALUES ('2', 'dept_admin');
INSERT INTO `shiro_roles` VALUES ('3', 'normal_user');
INSERT INTO `shiro_roles` VALUES ('4', 'operator');

-- ----------------------------
-- Table structure for `shiro_r_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_r_role_permission`;
CREATE TABLE `shiro_r_role_permission` (
  `ID` double(22,0) DEFAULT NULL,
  `ROLE_ID` double(22,0) DEFAULT NULL,
  `PERMISSION_ID` double(22,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_r_role_permission
-- ----------------------------
INSERT INTO `shiro_r_role_permission` VALUES ('1', '2', '1');
INSERT INTO `shiro_r_role_permission` VALUES ('2', '2', '2');
INSERT INTO `shiro_r_role_permission` VALUES ('3', '2', '3');
INSERT INTO `shiro_r_role_permission` VALUES ('4', '2', '4');
INSERT INTO `shiro_r_role_permission` VALUES ('5', '4', '5');
INSERT INTO `shiro_r_role_permission` VALUES ('6', '4', '6');

-- ----------------------------
-- Table structure for `shiro_r_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_r_role_resource`;
CREATE TABLE `shiro_r_role_resource` (
  `ID` double(22,0) NOT NULL,
  `ROLE_ID` double(22,0) DEFAULT NULL,
  `RESOURCE_ID` double(22,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_r_role_resource
-- ----------------------------
INSERT INTO `shiro_r_role_resource` VALUES ('1', '1', '1');
INSERT INTO `shiro_r_role_resource` VALUES ('2', '1', '2');
INSERT INTO `shiro_r_role_resource` VALUES ('3', '1', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('4', '1', '4');
INSERT INTO `shiro_r_role_resource` VALUES ('5', '2', '2');
INSERT INTO `shiro_r_role_resource` VALUES ('6', '2', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('7', '2', '4');
INSERT INTO `shiro_r_role_resource` VALUES ('8', '3', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('9', '4', '4');

-- ----------------------------
-- Table structure for `shiro_r_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_r_user_role`;
CREATE TABLE `shiro_r_user_role` (
  `ID` double(22,0) NOT NULL,
  `USER_ID` double(22,0) DEFAULT NULL,
  `ROLE_ID` double(22,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_r_user_role
-- ----------------------------
INSERT INTO `shiro_r_user_role` VALUES ('1', '5', '1');
INSERT INTO `shiro_r_user_role` VALUES ('2', '1', '2');
INSERT INTO `shiro_r_user_role` VALUES ('3', '4', '2');
INSERT INTO `shiro_r_user_role` VALUES ('4', '2', '2');
INSERT INTO `shiro_r_user_role` VALUES ('5', '3', '3');
INSERT INTO `shiro_r_user_role` VALUES ('6', '1', '4');
INSERT INTO `shiro_r_user_role` VALUES ('7', '3', '4');

-- ----------------------------
-- Table structure for `shiro_users`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_users`;
CREATE TABLE `shiro_users` (
  `ID` double(22,0) NOT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `SALT` VARCHAR (500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_users
-- ----------------------------
INSERT INTO `shiro_users` VALUES ('1', 'charles1', '123');
INSERT INTO `shiro_users` VALUES ('2', 'jessica', '234');
INSERT INTO `shiro_users` VALUES ('3', 'kevin', '345');
INSERT INTO `shiro_users` VALUES ('4', 'charles2', '456');
INSERT INTO `shiro_users` VALUES ('5', 'admin', 'admin');

-- ----------------------------
-- Table structure for `wallet`
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet` (
  `ID` double(22,0) DEFAULT NULL,
  `NICKNAME` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(20) DEFAULT NULL,
  `LAST_USED_AT` datetime DEFAULT NULL,
  `PASSWORD_LAST_MODIFIED_AT` datetime DEFAULT NULL,
  `CREATED_AT` datetime DEFAULT NULL,
  `STATUS` double(22,0) DEFAULT NULL,
  `PAY_PASSWORD` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wallet
-- ----------------------------



