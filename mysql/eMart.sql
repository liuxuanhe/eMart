/*
Navicat MySQL Data Transfer

Source Server         : cwtch.yiroote.com
Source Server Version : 50647
Source Host           : cwtch.yiroote.com:3306
Source Database       : eMart

Target Server Type    : MYSQL
Target Server Version : 50647
File Encoding         : 65001

Date: 2020-04-15 17:00:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `eMart_buyer`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_buyer`;
CREATE TABLE `eMart_buyer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `emailid` varchar(100) DEFAULT NULL,
  `mobile_number` char(11) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_buyer
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_category`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_category`;
CREATE TABLE `eMart_category` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) DEFAULT NULL,
  `brief_details` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_category
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_discounts`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_discounts`;
CREATE TABLE `eMart_discounts` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `discount_code` varchar(50) NOT NULL,
  `percentage` float(10,0) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_discounts
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_items`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_items`;
CREATE TABLE `eMart_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category_id` int(10) DEFAULT NULL,
  `subcategory_id` int(10) DEFAULT NULL,
  `price` float(10,0) NOT NULL DEFAULT '0',
  `item_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `stock_number` int(10) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_category_id` (`category_id`),
  KEY `item_subcategory_id` (`subcategory_id`),
  CONSTRAINT `item_category_id` FOREIGN KEY (`category_id`) REFERENCES `eMart_category` (`category_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `item_subcategory_id` FOREIGN KEY (`subcategory_id`) REFERENCES `eMart_subcategory` (`subcategory_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_items
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_purchase_history`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_purchase_history`;
CREATE TABLE `eMart_purchase_history` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(10) NOT NULL,
  `seller_id` int(10) NOT NULL,
  `transaction_id` bigint(100) NOT NULL,
  `item_id` int(10) NOT NULL,
  `number_of_items` int(10) NOT NULL,
  `date_time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_buyer_id` (`buyer_id`),
  KEY `purchase_item_id` (`item_id`),
  KEY `purchase_seller_id` (`seller_id`),
  KEY `purchase_transations_id` (`transaction_id`),
  CONSTRAINT `purchase_buyer_id` FOREIGN KEY (`buyer_id`) REFERENCES `eMart_buyer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `purchase_item_id` FOREIGN KEY (`item_id`) REFERENCES `eMart_items` (`id`),
  CONSTRAINT `purchase_seller_id` FOREIGN KEY (`seller_id`) REFERENCES `eMart_seller` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `purchase_transations_id` FOREIGN KEY (`transaction_id`) REFERENCES `eMart_transactions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_purchase_history
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_seller`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_seller`;
CREATE TABLE `eMart_seller` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `gstin` varchar(100) DEFAULT NULL,
  `brief_about_company` varchar(100) DEFAULT NULL,
  `postal_address` varchar(200) DEFAULT NULL,
  `website` varchar(200) DEFAULT NULL,
  `emailid` varchar(100) DEFAULT NULL,
  `contact_number` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_seller
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_subcategory`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_subcategory`;
CREATE TABLE `eMart_subcategory` (
  `subcategory_id` int(10) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(100) DEFAULT NULL,
  `category_id` int(10) NOT NULL,
  `brief_details` varchar(200) DEFAULT NULL,
  `gst` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subcategory_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `eMart_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_subcategory
-- ----------------------------

-- ----------------------------
-- Table structure for `eMart_transactions`
-- ----------------------------
DROP TABLE IF EXISTS `eMart_transactions`;
CREATE TABLE `eMart_transactions` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `seller_id` int(10) NOT NULL,
  `transaction_type` varchar(10) NOT NULL,
  `date_time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `transactions_seller_id` (`seller_id`),
  KEY `transactions_user_id` (`user_id`),
  CONSTRAINT `transactions_seller_id` FOREIGN KEY (`seller_id`) REFERENCES `eMart_seller` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `transactions_user_id` FOREIGN KEY (`user_id`) REFERENCES `eMart_buyer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eMart_transactions
-- ----------------------------
