/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : book_mall

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-05-16 19:03:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book_info`
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '逻辑UID',
  `name` varchar(32) CHARACTER SET utf8mb4 NOT NULL COMMENT '书名',
  `author` varchar(16) NOT NULL COMMENT '作者',
  `describe` text NOT NULL COMMENT '简介',
  `price` int(11) NOT NULL COMMENT '价格',
  `stock` int(32) NOT NULL COMMENT '库存量',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------

-- ----------------------------
-- Table structure for `discount_info`
-- ----------------------------
DROP TABLE IF EXISTS `discount_info`;
CREATE TABLE `discount_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '逻辑UID',
  `discount_price` int(11) NOT NULL COMMENT '代金券金额',
  `discount_num` int(11) NOT NULL COMMENT '代金券的数量',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `valid_time` int(11) NOT NULL COMMENT '代金券有效时长',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `end_time` datetime NOT NULL COMMENT '活动结束时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discount_info
-- ----------------------------

-- ----------------------------
-- Table structure for `hobby_info`
-- ----------------------------
DROP TABLE IF EXISTS `hobby_info`;
CREATE TABLE `hobby_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '逻辑UID',
  `describe` varchar(10) NOT NULL COMMENT '兴趣描述符',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hobby_info
-- ----------------------------

-- ----------------------------
-- Table structure for `panic_info`
-- ----------------------------
DROP TABLE IF EXISTS `panic_info`;
CREATE TABLE `panic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '抢购逻辑UID',
  `nums` tinyint(4) NOT NULL COMMENT '抢购数量',
  `cur_price` int(11) NOT NULL COMMENT '抢购价格',
  `start_time` datetime NOT NULL COMMENT '抢购开始时间',
  `end_time` datetime NOT NULL COMMENT '抢购结束时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of panic_info
-- ----------------------------

-- ----------------------------
-- Table structure for `premission_info`
-- ----------------------------
DROP TABLE IF EXISTS `premission_info`;
CREATE TABLE `premission_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '权限UID',
  `describe` varchar(16) NOT NULL COMMENT '权限描述',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of premission_info
-- ----------------------------

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增UID',
  `uid` varchar(32) NOT NULL COMMENT '角色UID',
  `describe` varchar(20) NOT NULL COMMENT '角色描述',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `role_uid` varchar(32) NOT NULL COMMENT '角色UID',
  `permission_uid` varchar(32) NOT NULL COMMENT '权限UID',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_role_uid_premission_uid` (`role_uid`,`permission_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sale`
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `book_uid` varchar(32) NOT NULL COMMENT '图书UID',
  `total_price` int(11) NOT NULL COMMENT '销售总额',
  `nums` int(11) NOT NULL COMMENT '销售数量',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_book_uid` (`book_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale
-- ----------------------------

-- ----------------------------
-- Table structure for `shop_car`
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_uid` varchar(32) NOT NULL COMMENT '用户UID',
  `book_uid` varchar(32) NOT NULL COMMENT '图书UID',
  `nums` int(11) NOT NULL COMMENT '购物车图书数量',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_uid_book_uid` (`user_uid`,`book_uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_car
-- ----------------------------

-- ----------------------------
-- Table structure for `user_book`
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_uid` varchar(32) NOT NULL COMMENT '用户UID',
  `book_uid` varchar(32) NOT NULL COMMENT '书籍UID',
  `buy_price` int(11) NOT NULL COMMENT '购买价格',
  `buy_nums` int(11) NOT NULL COMMENT '购买数量',
  `buy_way` tinyint(1) NOT NULL DEFAULT '0' COMMENT '购买方式[0-普通购买 | 1-抢购]',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_uid_book_uid` (`user_uid`,`book_uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_book
-- ----------------------------

-- ----------------------------
-- Table structure for `user_discount`
-- ----------------------------
DROP TABLE IF EXISTS `user_discount`;
CREATE TABLE `user_discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_uid` varchar(32) NOT NULL COMMENT '用户UID',
  `discount_uid` varchar(32) NOT NULL COMMENT '优惠UID',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_uid_discount_uid` (`user_uid`,`discount_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_discount
-- ----------------------------

-- ----------------------------
-- Table structure for `user_hobby`
-- ----------------------------
DROP TABLE IF EXISTS `user_hobby`;
CREATE TABLE `user_hobby` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_uid` varchar(32) NOT NULL COMMENT '用户UID',
  `hobby_uid` varchar(32) NOT NULL COMMENT '兴趣UID',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_uid_hobby_uid` (`user_uid`,`hobby_uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_hobby
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `uid` varchar(32) NOT NULL COMMENT '用户UID',
  `name` varchar(16) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_uid` varchar(32) NOT NULL COMMENT '用户逻辑ID',
  `role_uid` varchar(32) NOT NULL COMMENT '角色UID',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_uid_role_uid` (`user_uid`,`role_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
