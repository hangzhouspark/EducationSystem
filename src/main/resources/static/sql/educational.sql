/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : educational

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-03-07 22:13:55
*/

create database educational;

use educational;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) NOT NULL,
  `cauthor` varchar(10) DEFAULT NULL,
  `cware` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of courseware
-- ----------------------------
INSERT INTO `courseware` VALUES ('1', '摊破浣溪沙·菡萏香销翠叶残', '李璟〔五代〕', '');
INSERT INTO `courseware` VALUES ('2', '次北固山下', '王湾〔唐代〕', '');
INSERT INTO `courseware` VALUES ('3', '劝 学', '唐·颜真卿', '');
INSERT INTO `courseware` VALUES ('4', '金缕衣', '清·萧抡谓', null);

-- ----------------------------
-- Table structure for loginusers
-- ----------------------------
DROP TABLE IF EXISTS `loginusers`;
CREATE TABLE `loginusers` (
  `lid` int NOT NULL AUTO_INCREMENT,
  `lusername` varchar(50) NOT NULL,
  `lpassword` varchar(50) NOT NULL,
  `lisadmin` int NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of loginusers
-- ----------------------------
INSERT INTO `loginusers` VALUES ('1', 'zhangsan', '123', '2');
INSERT INTO `loginusers` VALUES ('2', 'lisi', '123', '2');
INSERT INTO `loginusers` VALUES ('3', 'wangwu', '123', '2');
INSERT INTO `loginusers` VALUES ('4', 'zhanglaoshi', '123', '1');
INSERT INTO `loginusers` VALUES ('5', 'admin', '123', '0');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `mquestion` varchar(255) NOT NULL,
  `manswers` varchar(255) DEFAULT NULL,
  `tid` int DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `tid` (`tid`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '问题1', '', '1');
INSERT INTO `message` VALUES ('2', '问题2', '', '1');
INSERT INTO `message` VALUES ('3', '问题3', '', '2');
INSERT INTO `message` VALUES ('4', '问题4', '', '2');
INSERT INTO `message` VALUES ('5', '问题5', '', '3');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(10) NOT NULL,
  `ssex` int NOT NULL,
  `sbirthday` date DEFAULT NULL,
  `sclass` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '1', '1999-11-12', '一班');
INSERT INTO `student` VALUES ('2', '李四', '0', '1999-01-01', '一班');
INSERT INTO `student` VALUES ('3', '王五', '0', '2001-09-15', '二班');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(10) NOT NULL,
  `tsex` int NOT NULL,
  `tbirthday` date DEFAULT NULL,
  `tdepart` varchar(20) DEFAULT NULL,
  `tnumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '张老师', '0', '1994-07-10', '教务处', '18000000000');
INSERT INTO `teacher` VALUES ('2', '王老师', '1', '1996-12-14', '科研处', '17000000000');
INSERT INTO `teacher` VALUES ('3', '李老师', '0', '1991-02-02', '教务处', '16000000000');
INSERT INTO `teacher` VALUES ('4', '赵老师', '1', '1994-12-24', '学生处', '15000000000');
INSERT INTO `teacher` VALUES ('5', '严老师', '0', '1994-10-26', '人事处', '14000000000');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `vid` int NOT NULL AUTO_INCREMENT,
  `vname` varchar(100) NOT NULL,
  `vauthor` varchar(10) DEFAULT NULL,
  `vware` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '试用了集合ChatGPT的Bing搜索后，感觉潘多拉魔盒已经打开了【差评君】', '差评君', '');
INSERT INTO `video` VALUES ('2', '[航空史砖讲]冷战期间德国人驾机降落红场？！', '飞行砖家王机长', null);
INSERT INTO `video` VALUES ('3', '240w快充3499？一台真我GT Neo5引发的混战！', '翻身电台', null);
INSERT INTO `video` VALUES ('4', '一夜爆红的ChatGPT，对我们普通人有哪些影响？', 'X科技实验室', null);
INSERT INTO `video` VALUES ('5', '今天试用了一下ChatGPT，感觉自己要失业了…', 'Every..', null);
