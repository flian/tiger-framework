/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : ettodaypoc

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-09-27 15:14:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  `descriptions` varchar(255) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  `path_Str` varchar(500) DEFAULT '',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `categoryId_UNIQUE` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `long_description` text,
  `parent_category_id` bigint(20) DEFAULT NULL,
  `on_shelf` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permissions`;
CREATE TABLE `shiro_permissions` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `PERMISSION_DESCRIPTION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_resources`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_resources`;
CREATE TABLE `shiro_resources` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `RESOURCE_TYPE` bigint(20) DEFAULT NULL,
  `RESOURCE_NAME` varchar(100) DEFAULT NULL,
  `RESOURCE_URL` text,
  `CREATE_AT` datetime DEFAULT NULL,
  `UPDATE_AT` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_roles`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_roles`;
CREATE TABLE `shiro_roles` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `ROLE_DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `shiro_r_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_r_role_permission`;
CREATE TABLE `shiro_r_role_permission` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `PERMISSION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `shiro_r_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_r_role_resource`;
CREATE TABLE `shiro_r_role_resource` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `RESOURCE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `shiro_r_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_r_user_role`;
CREATE TABLE `shiro_r_user_role` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `shiro_users`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_users`;
CREATE TABLE `shiro_users` (
  `ID` bigint(22) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `sku`
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `list_price` decimal(10,0) DEFAULT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `img_detail` varchar(255) DEFAULT NULL COMMENT '商品详情图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `sku_pic`
-- ----------------------------
DROP TABLE IF EXISTS `sku_pic`;
CREATE TABLE `sku_pic` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `sku_id` bigint(20) NOT NULL COMMENT 'skuId',
  `sku_pic_url` varchar(255) DEFAULT NULL COMMENT 'sku轮播图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SKU_ID` bigint(255) DEFAULT NULL,
  `reserve_stock` bigint(20) DEFAULT NULL COMMENT '预扣库存',
  `stock_level` bigint(20) DEFAULT NULL COMMENT '实际库存',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `tb_order_address`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_address`;
CREATE TABLE `tb_order_address` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` varchar(50) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `TELEPHONE` varchar(20) DEFAULT NULL,
  `PROVINCE` varchar(50) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `COUNTRY` varchar(50) DEFAULT NULL,
  `CONTENT` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` varchar(50) NOT NULL,
  `PRODUCT_ID` bigint(20) DEFAULT NULL,
  `SKU_ID` bigint(20) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `LIST_PRICE` decimal(10,2) DEFAULT NULL,
  `SALE_PRICE` decimal(10,2) DEFAULT NULL,
  `BUY_NUM` int(11) DEFAULT NULL,
  `TOTAL_MONEY` decimal(10,2) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_order_master`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_master`;
CREATE TABLE `tb_order_master` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` varchar(50) NOT NULL,
  `TOTAL_MONEY` decimal(11,2) DEFAULT NULL,
  `FREIGHT` decimal(11,2) DEFAULT NULL,
  `ORDER_STATUS` varchar(2) DEFAULT NULL,
  `IS_DEL` char(1) DEFAULT NULL,
  `ADDRESS_ID` bigint(20) DEFAULT NULL,
  `ORDER_CREATER` varchar(50) NOT NULL,
  `CREATED_TIME` timestamp NULL DEFAULT NULL,
  `AUDIT_COMMENT` varchar(2500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `tb_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_address`;
CREATE TABLE `tb_user_address` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(22) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `TELEPHONE` varchar(20) DEFAULT NULL,
  `PROVINCE` varchar(50) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `COUNTRY` varchar(50) DEFAULT NULL,
  `CONTENT` varchar(100) DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL,
  `POSTCODE` varchar(255) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `wallet`
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet` (
  `ID` int(22) NOT NULL AUTO_INCREMENT,
  `NICKNAME` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(20) DEFAULT NULL,
  `LAST_USED_AT` datetime DEFAULT NULL,
  `PASSWORD_LAST_MODIFIED_AT` datetime DEFAULT NULL,
  `CREATED_AT` datetime DEFAULT NULL,
  `STATUS` bigint(20) DEFAULT NULL,
  `PAY_PASSWORD` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

