/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : project_management_system

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-03-22 17:05:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `revision`
-- ----------------------------
DROP TABLE IF EXISTS `revision`;
CREATE TABLE `revision` (
  `id` int(11) DEFAULT NULL,
  `description` text,
  `object_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `is_active` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of revision
-- ----------------------------

-- ----------------------------
-- Table structure for `_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `_attachment`;
CREATE TABLE `_attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `url` text,
  `object_id` int(11) DEFAULT NULL,
  `object_type` varchar(45) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _attachment
-- ----------------------------

-- ----------------------------
-- Table structure for `_defect_content`
-- ----------------------------
DROP TABLE IF EXISTS `_defect_content`;
CREATE TABLE `_defect_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(45) DEFAULT NULL,
  `severity` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _defect_content
-- ----------------------------

-- ----------------------------
-- Table structure for `_discussion`
-- ----------------------------
DROP TABLE IF EXISTS `_discussion`;
CREATE TABLE `_discussion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `creator` int(11) DEFAULT NULL,
  `object_id` int(11) DEFAULT NULL,
  `object_type` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _discussion
-- ----------------------------

-- ----------------------------
-- Table structure for `_map_tag_task`
-- ----------------------------
DROP TABLE IF EXISTS `_map_tag_task`;
CREATE TABLE `_map_tag_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _map_tag_task
-- ----------------------------

-- ----------------------------
-- Table structure for `_map_tag_ticket`
-- ----------------------------
DROP TABLE IF EXISTS `_map_tag_ticket`;
CREATE TABLE `_map_tag_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) DEFAULT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _map_tag_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for `_operation`
-- ----------------------------
DROP TABLE IF EXISTS `_operation`;
CREATE TABLE `_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `time` timestamp NULL DEFAULT NULL,
  `level` varchar(45) DEFAULT NULL COMMENT '操作级别，实现时间轴时可以选择性的显示一些操作',
  `project_id` int(11) DEFAULT NULL,
  `sprint_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _operation
-- ----------------------------

-- ----------------------------
-- Table structure for `_project`
-- ----------------------------
DROP TABLE IF EXISTS `_project`;
CREATE TABLE `_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  `create_time` timestamp NULL DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _project
-- ----------------------------
INSERT INTO `_project` VALUES ('1', 'Online Exam System', '在线考试系统', '2015-02-01 11:06:23', '3', '1');

-- ----------------------------
-- Table structure for `_project_user`
-- ----------------------------
DROP TABLE IF EXISTS `_project_user`;
CREATE TABLE `_project_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_manager` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _project_user
-- ----------------------------
INSERT INTO `_project_user` VALUES ('1', '1', '3', '1');
INSERT INTO `_project_user` VALUES ('2', '1', '2', '0');
INSERT INTO `_project_user` VALUES ('3', '1', '4', '0');
INSERT INTO `_project_user` VALUES ('4', '1', '5', '0');

-- ----------------------------
-- Table structure for `_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `_schedule`;
CREATE TABLE `_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `_sequence`;
CREATE TABLE `_sequence` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `current_value` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _sequence
-- ----------------------------

-- ----------------------------
-- Table structure for `_sprint`
-- ----------------------------
DROP TABLE IF EXISTS `_sprint`;
CREATE TABLE `_sprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  `is_current` tinyint(1) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _sprint
-- ----------------------------

-- ----------------------------
-- Table structure for `_tag`
-- ----------------------------
DROP TABLE IF EXISTS `_tag`;
CREATE TABLE `_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _tag
-- ----------------------------

-- ----------------------------
-- Table structure for `_task`
-- ----------------------------
DROP TABLE IF EXISTS `_task`;
CREATE TABLE `_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` int(10) unsigned DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `description` text,
  `state` varchar(45) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `blocked` tinyint(1) DEFAULT NULL,
  `estimate` decimal(10,0) DEFAULT NULL,
  `todo` decimal(10,0) DEFAULT NULL,
  `notes` text,
  `project_uuid` int(11) DEFAULT NULL,
  `ticket_uuid` int(11) DEFAULT NULL,
  `sprint_uuid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _task
-- ----------------------------

-- ----------------------------
-- Table structure for `_ticket`
-- ----------------------------
DROP TABLE IF EXISTS `_ticket`;
CREATE TABLE `_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `release_id` int(11) DEFAULT NULL,
  `sprint_id` int(11) DEFAULT NULL,
  `bolcked` tinyint(1) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `notes` text,
  `plan_est` decimal(10,0) DEFAULT NULL,
  `task_est` decimal(10,0) DEFAULT NULL,
  `todo` decimal(10,0) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `defect_content_id` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _ticket
-- ----------------------------

-- ----------------------------
-- Table structure for `_user`
-- ----------------------------
DROP TABLE IF EXISTS `_user`;
CREATE TABLE `_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `job_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _user
-- ----------------------------
INSERT INTO `_user` VALUES ('1', '王超', 'W00001', '596084272@qq.com', '1', '123');
INSERT INTO `_user` VALUES ('2', '柯沁怡', 'W00002', null, '1', '123');
INSERT INTO `_user` VALUES ('3', 'wangchao', 'W00003', '123@qq.com', '1', 'wangchao1993');
INSERT INTO `_user` VALUES ('4', '小黄', 'W00004', '1234.qq.com', '1', '123');
INSERT INTO `_user` VALUES ('5', '小明', 'W00005', '12345.qq.com', '1', '123');
INSERT INTO `_user` VALUES ('6', '123', 'W00006', '596084273@qq.com', '1', '123123123');
