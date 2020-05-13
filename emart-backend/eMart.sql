/*
MySQL Data Transfer
Source Host: localhost
Source Database: eMart
Target Host: localhost
Target Database: eMart
Date: 5/13/2020 4:24:15 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for eMart_buyer
-- ----------------------------
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
-- Table structure for eMart_category
-- ----------------------------
CREATE TABLE `eMart_category` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) DEFAULT NULL,
  `brief_details` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eMart_discounts
-- ----------------------------
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
-- Table structure for eMart_items
-- ----------------------------
CREATE TABLE `eMart_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category_id` int(10) DEFAULT NULL,
  `subcategory_id` int(10) DEFAULT NULL,
  `price` float(10,0) NOT NULL DEFAULT '0',
  `item_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `stock_number` int(10) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eMart_purchase_history
-- ----------------------------
CREATE TABLE `eMart_purchase_history` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(10) NOT NULL,
  `seller_id` int(10) NOT NULL,
  `transaction_id` bigint(100) NOT NULL,
  `item_id` int(10) NOT NULL,
  `number_of_items` int(10) NOT NULL,
  `date_time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eMart_seller
-- ----------------------------
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
-- Table structure for eMart_subcategory
-- ----------------------------
CREATE TABLE `eMart_subcategory` (
  `subcategory_id` int(10) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(100) DEFAULT NULL,
  `category_id` int(10) NOT NULL,
  `brief_details` varchar(200) DEFAULT NULL,
  `gst` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subcategory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eMart_transactions
-- ----------------------------
CREATE TABLE `eMart_transactions` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `seller_id` int(10) NOT NULL,
  `transaction_type` varchar(10) NOT NULL,
  `date_time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
