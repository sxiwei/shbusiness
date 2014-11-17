/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : shshop

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-11-17 18:41:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sh_index_carousel`
-- ----------------------------
DROP TABLE IF EXISTS `sh_index_carousel`;
CREATE TABLE `sh_index_carousel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `url` varchar(64) NOT NULL,
  `usable` tinyint(1) NOT NULL COMMENT '1-可用',
  `addTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sh_index_carousel
-- ----------------------------
INSERT INTO `sh_index_carousel` VALUES ('1', '智能照明', '智能照明系统可针对任意一路或多路灯光进行任意开、关、调光，并且可以设置多种生活使用场景（晨起、离家、聚会、就餐等）所对应的多种灯光组合方式，从而一键调用所需场景的灯光组合，达到节能、环保、舒适、方便的效果', 'images/333.png', '1', '2014-11-16 10:26:35');
INSERT INTO `sh_index_carousel` VALUES ('2', '智能门锁', '区别于传统机械锁，智能锁时尚精美，牢固耐用，无需传统钥匙开启，通常可通过密码、IC卡、指纹、掌纹、虹膜、静脉等识别方式开启，也可通过绑定的智能手机进行控制，安全可靠，使用方便', 'images/slide-02.jpg', '1', '2014-11-16 10:45:16');
INSERT INTO `sh_index_carousel` VALUES ('3', '电动窗帘', '智能电动窗帘是通过在普通家用窗帘上加装电机与导轨实现电动控制，智能家居系统可对电动窗帘进行远程控制，情景模式控制，并实现窗帘与灯光等家用设备的联动', 'images/222.png', '1', '2014-11-16 10:51:09');

-- ----------------------------
-- Table structure for `sh_index_column`
-- ----------------------------
DROP TABLE IF EXISTS `sh_index_column`;
CREATE TABLE `sh_index_column` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `heading` varchar(64) NOT NULL,
  `desc` varchar(150) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `addTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sh_index_column
-- ----------------------------
INSERT INTO `sh_index_column` VALUES ('1', '标题一', '标题一的描述', '标题一详细说明', '2014-11-16 11:07:00');
INSERT INTO `sh_index_column` VALUES ('2', '标题二', '标题二的描述', '标题二详细说明', '2014-11-16 11:07:27');
INSERT INTO `sh_index_column` VALUES ('3', '标题三', '标题三的描述', '标题三的详细说明', '2014-11-16 11:07:50');
INSERT INTO `sh_index_column` VALUES ('4', '标题四', '标题四的描述', '标题四详细说明', '2014-11-16 11:13:36');

-- ----------------------------
-- Table structure for `sh_user`
-- ----------------------------
DROP TABLE IF EXISTS `sh_user`;
CREATE TABLE `sh_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sh_user
-- ----------------------------
INSERT INTO `sh_user` VALUES ('2', 'gavin@163.com', 'Tam+OkJ2pGrF1u2/bURJx/82V6eU4l5j9/A7xYs0/kN/0Bi7dni2IdTFp3jVQN4g');
