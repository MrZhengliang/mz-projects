/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : mz

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2015-01-18 23:16:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_mz_announcement`
-- ----------------------------
DROP TABLE IF EXISTS `t_mz_announcement`;
CREATE TABLE `t_mz_announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告表主键id',
  `content` text COMMENT '公告内容',
  `link` varchar(200) DEFAULT NULL COMMENT '公告链接',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `area_code` varchar(20) DEFAULT NULL COMMENT '发布地区',
  `title` varchar(50) DEFAULT NULL COMMENT '公告标题',
  `notice_type` tinyint(1) DEFAULT NULL COMMENT '1:普通公告；2：刺客笔记',
  `image_path` varchar(200) DEFAULT NULL COMMENT '图片存放路径',
  `image_url` varchar(200) DEFAULT NULL COMMENT '图片url连接地址',
  `status` tinyint(1) DEFAULT NULL COMMENT '审核状态 0 待审核 1 审核通过 2 审核驳回 3 过期 默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mz_announcement
-- ----------------------------

-- ----------------------------
-- Table structure for `t_mz_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_mz_area`;
CREATE TABLE `t_mz_area` (
  `id` mediumint(8) NOT NULL COMMENT 'id,自增长',
  `areacode` varchar(20) DEFAULT NULL COMMENT '区域编码',
  `areaname` varchar(20) DEFAULT NULL COMMENT '区域名称',
  `areagrade` tinyint(1) DEFAULT NULL COMMENT '区域级别，1 级代表省级、直辖市、特区；2级  代表地市',
  `parentcode` mediumint(8) DEFAULT NULL COMMENT '上级code',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省市信息表,存放省分、地市编码信息';

-- ----------------------------
-- Records of t_mz_area
-- ----------------------------
INSERT INTO `t_mz_area` VALUES ('1', '10', '北京', '1', '0');
INSERT INTO `t_mz_area` VALUES ('2', '11', '天津', '1', '0');
INSERT INTO `t_mz_area` VALUES ('3', '12', '上海', '1', '0');
INSERT INTO `t_mz_area` VALUES ('4', '20', '四川', '1', '0');
INSERT INTO `t_mz_area` VALUES ('5', '201', '成都', '2', '20');
INSERT INTO `t_mz_area` VALUES ('6', '21', '云南', '1', '0');
INSERT INTO `t_mz_area` VALUES ('7', '211', '昆明', '2', '21');
INSERT INTO `t_mz_area` VALUES ('8', '14', '广州', '1', '0');
INSERT INTO `t_mz_area` VALUES ('9', '22', '湖北', '1', '0');
INSERT INTO `t_mz_area` VALUES ('10', '221', '武汉', '2', '22');
INSERT INTO `t_mz_area` VALUES ('11', '222', '黄石', '2', '22');

-- ----------------------------
-- Table structure for `t_mz_articlecontent`
-- ----------------------------
DROP TABLE IF EXISTS `t_mz_articlecontent`;
CREATE TABLE `t_mz_articlecontent` (
  `cid` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT ' 内容ID',
  `uid` mediumint(8) DEFAULT NULL COMMENT '用户ID;与idType对应为管理人员id和网站会员id',
  `idtype` tinyint(1) DEFAULT NULL COMMENT '漫展文章来源id，1 来源管理系统人员  2 来源网站会员',
  `telephone` char(40) DEFAULT NULL COMMENT '电话',
  `qqcode` char(40) DEFAULT NULL COMMENT 'QQ',
  `email` char(40) DEFAULT NULL COMMENT '邮箱',
  `title` varchar(255) DEFAULT NULL COMMENT '漫展名称',
  `privurl` varchar(100) DEFAULT NULL COMMENT '个性域名',
  `cityname` varchar(20) DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL COMMENT '地图经度',
  `lng` varchar(50) DEFAULT NULL COMMENT '地图纬度',
  `address` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `closetime` datetime DEFAULT NULL COMMENT '结束时间',
  `pricetype` tinyint(1) DEFAULT NULL COMMENT '票价方式 1 免费  2 收费',
  `price` smallint(8) DEFAULT NULL COMMENT '当pricetype为2时，设置票价',
  `tickettype` varchar(50) DEFAULT NULL COMMENT '订票方式',
  `netticketaddress` varchar(255) DEFAULT NULL COMMENT '网络售票地址',
  `content` text COMMENT '漫展简介',
  `dateline` datetime DEFAULT NULL COMMENT '添加时间',
  `faceimg` mediumint(8) DEFAULT NULL COMMENT '漫展封面图片,对应t_mz_attachment表的aid',
  `status` tinyint(1) DEFAULT NULL COMMENT '漫展状态，0 待审核；1 已审核,上线； 9 下线。',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='门户文章漫展内容表';

-- ----------------------------
-- Records of t_mz_articlecontent
-- ----------------------------
INSERT INTO `t_mz_articlecontent` VALUES ('13', '14', '2', '15010396104', '981233589', '981233589@qq.com', '测试1', '测试1', '北京', '39.910028', '116.416125', '北京市北京市东城区东交民巷', '2015-01-12 08:00:00', '2015-01-18 23:55:00', '2', '15', '网络购票', 'http://www.tmall.com/测试1.shtml', '测试1\r\n测试1\r\n测试1\r\n测试1', null, '55', '1');

-- ----------------------------
-- Table structure for `t_mz_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `t_mz_attachment`;
CREATE TABLE `t_mz_attachment` (
  `aid` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `type` tinyint(1) DEFAULT NULL COMMENT '附件类型  1  图片  2 文件  3  音乐  4  视频',
  `uid` mediumint(8) DEFAULT NULL COMMENT '会员id；添加人员id',
  `downloads` mediumint(8) DEFAULT NULL COMMENT '下载次数',
  `filename` varchar(100) DEFAULT NULL COMMENT '文件原名称',
  `newfilename` varchar(100) DEFAULT NULL COMMENT '上传的文件新名称',
  `filepath` varchar(100) DEFAULT NULL COMMENT '文件保存路径',
  `uploadtime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='附件信息表';

-- ----------------------------
-- Records of t_mz_attachment
-- ----------------------------
INSERT INTO `t_mz_attachment` VALUES ('18', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef23310da0.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('19', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef2a21248c.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('20', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef3035cb37.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('21', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef3246c18a.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('22', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef34fe688b.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('23', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef3cc60edc.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('24', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef48fe7bb1.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('25', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef4bf9b056.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('26', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef517a5bde.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('27', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef56a2833c.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('28', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef57768465.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('29', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef59d1d1a9.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('30', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef5abed1a1.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('31', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef76a03fcb.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('32', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '541ef8b1a5f0e.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('33', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54201cd2e0585.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('34', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54201cff8a35b.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('35', '1', '14', null, 'csdn博客排名20140923.png', '542421cc4aaba.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('36', '1', '14', null, 'csdn博客排名20140923.png', '542421d29f1c9.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('37', '1', '14', null, 'csdn博客排名20140923.png', '5424241704d3b.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('38', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '5424243a38af1.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('39', '1', '14', null, 'csdn博客排名20140923.png', '5424291840883.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('40', '1', '14', null, 'csdn博客排名20140923.png', '54242bcc03a36.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('41', '1', '14', null, 'csdn博客排名20140923.png', '54242c147765d.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('42', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54242c5c4a95c.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('43', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54242c87c9851.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('44', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54242cf6f23f7.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('45', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54242d07b0d74.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('46', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54242daed4d7b.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('47', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '54242e50c5807.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('48', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '5427b578a21a4.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('49', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '542aa630989dc.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('50', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '542ab0e45b291.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('51', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '542ab31999617.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('52', '1', '14', null, 'Screenshot_2014-05-06-12-18-09.png', '542ab9e6c1808.png', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('53', '1', '14', null, '1d2890da99fcd48692a3c46e9972e568.jpg', '54702fe7cbb26.jpg', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('54', '1', '14', null, 'Penguins.jpg', '54b7551e2c2bd.jpg', '/Uploads/images/', null);
INSERT INTO `t_mz_attachment` VALUES ('55', '1', '14', null, 'cem0MNTWB1s66.jpg', '54ba7b610af99.jpg', '/Uploads/images/', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `t_mz_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_mz_group`;
CREATE TABLE `t_mz_group` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` char(255) DEFAULT NULL,
  `grouptype` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mz_group
-- ----------------------------
INSERT INTO `t_mz_group` VALUES ('1', '游客', '1');
INSERT INTO `t_mz_group` VALUES ('2', 'coser', '2');
INSERT INTO `t_mz_group` VALUES ('3', '妆娘', '3');
INSERT INTO `t_mz_group` VALUES ('4', '摄影', '4');
INSERT INTO `t_mz_group` VALUES ('5', '后勤', '5');
INSERT INTO `t_mz_group` VALUES ('6', '后期', '6');

-- ----------------------------
-- Table structure for `t_mz_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_mz_user`;
CREATE TABLE `t_mz_user` (
  `uid` mediumint(8) NOT NULL AUTO_INCREMENT,
  `email` char(40) DEFAULT NULL,
  `nickname` char(40) DEFAULT NULL,
  `username` char(15) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL COMMENT '主页',
  `status` tinyint(1) DEFAULT NULL COMMENT '判断用户是否已经删除 需要程序加判断，并增加整体清理的功能。原home字段为flag',
  `emailstatus` tinyint(1) DEFAULT NULL COMMENT 'email是否经过验证 home字段为emailcheck',
  `avatarstatus` tinyint(1) DEFAULT NULL COMMENT '是否有头像 home字段为avatar',
  `grade` tinyint(1) DEFAULT NULL,
  `adminid` tinyint(1) DEFAULT NULL COMMENT '管理员id',
  `groupid` smallint(6) DEFAULT NULL COMMENT '会员组id',
  `credits` int(10) DEFAULT NULL COMMENT '总积分',
  `regdate` datetime DEFAULT NULL COMMENT '注册时间',
  `timeoffset` char(4) DEFAULT NULL COMMENT '时区校正',
  `conisbind` tinyint(1) DEFAULT NULL COMMENT ' 用户是否绑定QC',
  `provincecode` varchar(20) DEFAULT NULL,
  `provincename` varchar(20) DEFAULT NULL,
  `citycode` varchar(20) DEFAULT NULL,
  `cityname` varchar(20) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `userintro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_mz_user
-- ----------------------------
INSERT INTO `t_mz_user` VALUES ('14', '981233589@qq.com', '测试大牛', '小不懂', '4297f44b13955235245b2497399d7a93', '1', null, null, null, null, '4', null, null, null, null, '12', '上海', '12', '上海', '1', 'I love php too!12请问ddd');
INSERT INTO `t_mz_user` VALUES ('15', '414402216@qq.com', '测试大牛', '必须的', '4297f44b13955235245b2497399d7a93', '1', null, null, null, null, '4', null, null, null, null, '22', null, '221', null, '1', '鹅鹅鹅饿饿');
INSERT INTO `t_mz_user` VALUES ('16', '9812335891@qq.com', '测试大牛', '有名字的', '4297f44b13955235245b2497399d7a93', '9', null, null, null, null, '2', null, null, null, null, '22', null, '221', null, '1', '鹅鹅鹅饿饿');
INSERT INTO `t_mz_user` VALUES ('17', '9812335892@qq.com', '测试大牛', '秘密', '4297f44b13955235245b2497399d7a93', '1', null, null, null, null, '4', null, null, null, null, '22', null, '221', null, '1', '鹅鹅鹅饿饿');

-- ----------------------------
-- Table structure for `t_sh_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sh_user`;
CREATE TABLE `t_sh_user` (
  `auid` int(8) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `terminal_id` varchar(20) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `role_id` varchar(8) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `start_date` varchar(20) DEFAULT NULL,
  `end_date` varchar(20) DEFAULT NULL,
  `last_login_ip` varchar(100) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `limit_year` int(3) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sh_user
-- ----------------------------
INSERT INTO `t_sh_user` VALUES ('1', '981233589@qq.com', '啥的', '123', '13511112222', '测试1', '6', '1', '20141120', '20141231', '128.0.0.1', null, null, null);
INSERT INTO `t_sh_user` VALUES ('2', '981233589@qq.com', '小k', '123', '13866553333', 'u007', '6', '1', '20141120', '20141231', '127.0.0.1', null, null, null);
INSERT INTO `t_sh_user` VALUES ('3', '981233589@qq.com', '刚刚', '123', '13511113333', '12u8', '7', '9', '20140520', '20141231', '125.255.231.255', null, '3', '测试12u8');
INSERT INTO `t_sh_user` VALUES ('4', '41221111@126.com', 'dd ', '123', '15655543232', '测试2', '7', '9', '20141022', '20141231', '127.0.0.2', null, null, null);
INSERT INTO `t_sh_user` VALUES ('5', '222111@163.com', 'TT', '123', '18677729388', 'au7', '9', '1', '20140521', '20141230', '128.0.2.5', null, null, null);
INSERT INTO `t_sh_user` VALUES ('7', '981@123.com', 'ceshi11', '123', '15011125555', '测试11', '7', '1', '2014-11-18', '2014-11-30', null, null, null, null);
INSERT INTO `t_sh_user` VALUES ('8', '二恶额@qq.com', '测试2', '123', '13855554444', '测试2', '6', '1', '2014-11-01', '2014-12-31', null, null, '3', '测试第二个');
INSERT INTO `t_sh_user` VALUES ('9', '1@11.com', '', '', '13811112222', '', '0', '9', '', '', null, null, null, '');
INSERT INTO `t_sh_user` VALUES ('10', '123123@123.com', '刚刚', '', '15010001000', '小刚', '8', '1', '20140520', '20141231', null, null, '5', '测试');
INSERT INTO `t_sh_user` VALUES ('11', '', '刚刚', '', '', '', '8', '9', '20140520', '20141231', null, null, null, '');
INSERT INTO `t_sh_user` VALUES ('12', '130@139.com', '初级的', '123', '13011112222', '测试ceshi', '6', '1', '20141201', '20141231', null, null, '3', '测试ceshi');

-- ----------------------------
-- Table structure for `t_sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dictionary`;
CREATE TABLE `t_sys_dictionary` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `dic_name` varchar(50) DEFAULT NULL,
  `dic_info` varchar(255) DEFAULT NULL,
  `parent_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_group`;
CREATE TABLE `t_sys_group` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(18) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `group_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sys_group
-- ----------------------------
INSERT INTO `t_sys_group` VALUES ('1', '系统管理组1', null, '测试的');
INSERT INTO `t_sys_group` VALUES ('2', '客服A组', '20141122101200', null);
INSERT INTO `t_sys_group` VALUES ('3', '客服B组', '20141025101200', null);
INSERT INTO `t_sys_group` VALUES ('4', '会员组', '20141118111200', null);

-- ----------------------------
-- Table structure for `t_sys_group_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_group_menu`;
CREATE TABLE `t_sys_group_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `group_id` int(8) DEFAULT NULL,
  `menu_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC32E4AFC69C23339` (`menu_id`),
  KEY `FKC32E4AFC105BF75B` (`group_id`),
  CONSTRAINT `FKC32E4AFC105BF75B` FOREIGN KEY (`group_id`) REFERENCES `t_sys_group` (`id`),
  CONSTRAINT `FKC32E4AFC69C23339` FOREIGN KEY (`menu_id`) REFERENCES `t_sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_group_menu
-- ----------------------------
INSERT INTO `t_sys_group_menu` VALUES ('1', '1', '2');
INSERT INTO `t_sys_group_menu` VALUES ('2', '1', '3');
INSERT INTO `t_sys_group_menu` VALUES ('3', '1', '4');

-- ----------------------------
-- Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_code` varchar(20) DEFAULT NULL,
  `menu_pid` int(8) DEFAULT NULL,
  `menu_url` varchar(50) DEFAULT NULL,
  `leaf_yn` int(1) DEFAULT NULL,
  `menu_btns` varchar(50) DEFAULT NULL,
  `icon_tag` varchar(20) DEFAULT NULL,
  `has_child` tinyint(1) DEFAULT NULL COMMENT '是否有子菜单,1有  0没有',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('2', '系统管理', 'sys_menu', '0', '', '0', '', null, null);
INSERT INTO `t_sys_menu` VALUES ('3', '参数设置', 'params_menu', '2', '/system/params.do', '1', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('4', '权限管理', 'group_menu', '2', '/group/gmanage.do', '1', 'add_btn,edit_btn,del_btn,audit_btn', null, null);
INSERT INTO `t_sys_menu` VALUES ('5', '用户管理', 'user_menu', '2', '/group/umanage.do', '1', 'add_btn,edit_btn,del_btn,audit_btn', null, null);
INSERT INTO `t_sys_menu` VALUES ('6', '会员管理', 'auser_menu', '2', '/auser/manage.do', '1', 'add_btn,edit_btn,del_btn,audit_btn', null, null);
INSERT INTO `t_sys_menu` VALUES ('7', '商品管理', 'goods_menu', '0', null, null, null, null, null);
INSERT INTO `t_sys_menu` VALUES ('8', '商品列表', 'goodslist_menu', '7', '/goods/list.do', null, null, null, null);
INSERT INTO `t_sys_menu` VALUES ('9', '商品审核', 'goodsaudit_menu', '7', '/goods/toAuditList.do', null, null, null, null);
INSERT INTO `t_sys_menu` VALUES ('10', '商品报表', 'goodsreport_menu', '7', '/goods/toReportList.do', null, null, null, null);
INSERT INTO `t_sys_menu` VALUES ('11', '订单管理', 'order_menu', '0', null, '0', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('12', '订单审核', 'order_audit', '6', '/order/oaudit.do', '1', null, null, null);
INSERT INTO `t_sys_menu` VALUES ('13', '订单报表', 'order_export', '6', '/order/export.do', '1', null, null, null);

-- ----------------------------
-- Table structure for `t_sys_operate`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operate`;
CREATE TABLE `t_sys_operate` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `operate_code` varchar(30) DEFAULT NULL,
  `operate_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_operate
-- ----------------------------
INSERT INTO `t_sys_operate` VALUES ('1', 'add_btn', '添加');
INSERT INTO `t_sys_operate` VALUES ('2', 'del_btn', '删除');
INSERT INTO `t_sys_operate` VALUES ('3', 'query_btn', '查询');
INSERT INTO `t_sys_operate` VALUES ('4', 'edit_btn', '修改');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(18) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `operate_id` int(8) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  `group_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD28DE253105BF75B` (`group_id`),
  KEY `FKD28DE2534F4DA930` (`group_id`),
  CONSTRAINT `FKD28DE253105BF75B` FOREIGN KEY (`group_id`) REFERENCES `t_sys_group` (`id`),
  CONSTRAINT `FKD28DE2534F4DA930` FOREIGN KEY (`group_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '超级管理员', '测试', '1', null, '1');
INSERT INTO `t_sys_role` VALUES ('2', '普通管理员', '普通管理员', '1', '20140520120015', '3');
INSERT INTO `t_sys_role` VALUES ('3', '客服1', '客服1', '2', '20140510110015', '2');
INSERT INTO `t_sys_role` VALUES ('4', '客服22', '测试', '1', null, '2');
INSERT INTO `t_sys_role` VALUES ('5', 'super管理员', 'super管理员', '1', '20140505120015', '1');
INSERT INTO `t_sys_role` VALUES ('6', '初级会员', '初级会员', '1', '20140505121115', '4');
INSERT INTO `t_sys_role` VALUES ('7', '普通会员', '普通会员', '1', '20140505121115', '4');
INSERT INTO `t_sys_role` VALUES ('8', '高级会员', '测试', '1', null, '4');
INSERT INTO `t_sys_role` VALUES ('9', 'VIP会员', 'VIP会员', '1', '20140505121115', '4');
INSERT INTO `t_sys_role` VALUES ('13', '测试角色', '测试', '1', '20141130120816', '1');
INSERT INTO `t_sys_role` VALUES ('14', '测试的', '测试', '1', '20141130131825', '1');
INSERT INTO `t_sys_role` VALUES ('16', '测试23', '测试', '1', '20141130131959', '3');
INSERT INTO `t_sys_role` VALUES ('18', '456', '测试', '1', '20141130143506', '2');
INSERT INTO `t_sys_role` VALUES ('19', '321123', '测试', '1', '20141130150528', '2');
INSERT INTO `t_sys_role` VALUES ('20', '测试是是是', '测试', '1', '20141130152254', '2');
INSERT INTO `t_sys_role` VALUES ('21', 'AAAXX', '测试', '1', null, '3');
INSERT INTO `t_sys_role` VALUES ('24', 'XXX', '测试', '1', null, '1');

-- ----------------------------
-- Table structure for `t_sys_role_operate`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_operate`;
CREATE TABLE `t_sys_role_operate` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `role_id` int(8) DEFAULT NULL,
  `operate_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK932813588330C7D9` (`role_id`),
  KEY `FK93281358C046E0FB` (`operate_id`),
  CONSTRAINT `FK932813588330C7D9` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`),
  CONSTRAINT `FK93281358C046E0FB` FOREIGN KEY (`operate_id`) REFERENCES `t_sys_operate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sys_role_operate
-- ----------------------------
INSERT INTO `t_sys_role_operate` VALUES ('4', '2', '1');
INSERT INTO `t_sys_role_operate` VALUES ('5', '2', '3');
INSERT INTO `t_sys_role_operate` VALUES ('6', '3', '2');
INSERT INTO `t_sys_role_operate` VALUES ('7', '3', '3');

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `uid` int(8) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(32) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `terminal_id` varchar(20) DEFAULT NULL,
  `valid_time` varchar(14) DEFAULT NULL,
  `create_time` varchar(14) DEFAULT NULL,
  `change_pwd_time` varchar(14) DEFAULT NULL,
  `lock_status` int(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `last_login_time` varchar(14) DEFAULT NULL,
  `last_login_ip` varchar(100) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `group_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'ceshi1', '123', '981233555@qq.com', 'admin', '10210005555', null, null, null, '0', '1', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('2', 'admin', '123', '981233555@qq.com', 'ccc', '11110000111', '20141203', '20141202', null, '0', '1', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('3', 'xiaozhi', '', '12555@126.com', '小智', '15011112222', '20141203', '20141202', null, '0', '1', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('4', 'bigtou', '', '4545115@163.com', '大头哥', '13811112223', '20141225', '20141202', null, '0', '1', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('5', 'kefux', '', '4545115@163.com', '客服YYY', '15011112288', '20141231', '20141202', null, '0', '1', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('7', '测试2', '123', '981@qq.com', 'ddd', '13013013000', '20141231', '20141202', null, '0', '9', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('8', '超人1', '123', '123@qq.com', '超人1', '14766665555', '20141231', '20141201', null, '0', '9', null, null, null, null, null);
INSERT INTO `t_sys_user` VALUES ('9', 'ceshi1205', '123', '123@126.com', '测试1205', '13011112222', '20141231', '20141205', null, '0', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) DEFAULT NULL,
  `role_id` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEEC648ED8330C7D9` (`role_id`),
  KEY `FKEEC648ED285B8BB9` (`user_id`),
  CONSTRAINT `FKEEC648ED285B8BB9` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`uid`),
  CONSTRAINT `FKEEC648ED8330C7D9` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('13', '3', '16');
INSERT INTO `t_sys_user_role` VALUES ('21', '4', '1');
INSERT INTO `t_sys_user_role` VALUES ('26', '5', '14');
INSERT INTO `t_sys_user_role` VALUES ('27', '7', '2');
INSERT INTO `t_sys_user_role` VALUES ('29', '2', '2');
INSERT INTO `t_sys_user_role` VALUES ('35', '1', '1');
INSERT INTO `t_sys_user_role` VALUES ('36', '2', '1');
INSERT INTO `t_sys_user_role` VALUES ('37', '9', '2');
