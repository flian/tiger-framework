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

--  ----------------------------
--  drop tables
--  ----------------------------
DROP TABLE IF EXISTS `shiro_permissions`;
DROP TABLE IF EXISTS `shiro_resources`;
DROP TABLE IF EXISTS `shiro_roles`;
DROP TABLE IF EXISTS `shiro_r_role_permission`;
DROP TABLE IF EXISTS `shiro_r_role_resource`;
DROP TABLE IF EXISTS `shiro_r_user_role`;
DROP TABLE IF EXISTS `shiro_users`;
DROP TABLE IF EXISTS `wallet`;

-- ----------------------------
-- Table structure for `shiro_permissions`
-- ----------------------------
CREATE TABLE `shiro_permissions` (
  `ID` bigint NOT NULL,
  `PERMISSION_DESCRIPTION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_resources`
-- ----------------------------

CREATE TABLE `shiro_resources` (
  `ID` bigint NOT NULL,
  `RESOURCE_TYPE` bigint DEFAULT NULL,
  `RESOURCE_NAME` varchar(100) DEFAULT NULL,
  `RESOURCE_URL` text,
  `CREATE_AT` datetime DEFAULT NULL,
  `UPDATE_AT` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_roles`
-- ----------------------------

CREATE TABLE `shiro_roles` (
  `ID` bigint NOT NULL,
  `ROLE_DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `shiro_r_role_permission`
-- ----------------------------

CREATE TABLE `shiro_r_role_permission` (
  `ID` bigint DEFAULT NULL,
  `ROLE_ID` bigint DEFAULT NULL,
  `PERMISSION_ID` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_r_role_resource`
-- ----------------------------

CREATE TABLE `shiro_r_role_resource` (
  `ID` bigint NOT NULL,
  `ROLE_ID` bigint DEFAULT NULL,
  `RESOURCE_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_r_user_role`
-- ----------------------------

CREATE TABLE `shiro_r_user_role` (
  `ID` bigint NOT NULL,
  `USER_ID` bigint DEFAULT NULL,
  `ROLE_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_users`
-- ----------------------------

CREATE TABLE `shiro_users` (
  `ID` bigint NOT NULL,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `wallet`
-- ----------------------------

CREATE TABLE `wallet` (
  `ID` bigint DEFAULT NULL,
  `NICKNAME` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(20) DEFAULT NULL,
  `LAST_USED_AT` datetime DEFAULT NULL,
  `PASSWORD_LAST_MODIFIED_AT` datetime DEFAULT NULL,
  `CREATED_AT` datetime DEFAULT NULL,
  `STATUS` bigint DEFAULT NULL,
  `PAY_PASSWORD` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wallet
-- ----------------------------



