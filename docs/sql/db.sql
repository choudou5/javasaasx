/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : javasaasx

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2018-02-10 12:54:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dic_area`
-- ----------------------------
DROP TABLE IF EXISTS `dic_area`;
CREATE TABLE `dic_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(30) DEFAULT NULL COMMENT '地区编码',
  `name` varchar(64) DEFAULT NULL COMMENT '地区名称',
  `pcode` varchar(30) DEFAULT NULL COMMENT '父级编码',
  `pname` varchar(64) DEFAULT NULL COMMENT '父级名称',
  `level` int(11) DEFAULT NULL COMMENT '地区等级',
  `geo` varchar(64) DEFAULT NULL COMMENT '经纬度',
  `fullname` varchar(256) DEFAULT NULL COMMENT '全名',
  `pinyin` varchar(128) DEFAULT NULL COMMENT '拼音',
  `pinyin_short` varchar(32) DEFAULT NULL COMMENT '短拼音',
  `pinyin_first_letter` char(1) DEFAULT NULL COMMENT '拼音首字母',
  PRIMARY KEY (`id`),
  FULLTEXT KEY `index_key_code` (`code`)
) ENGINE=MyISAM AUTO_INCREMENT=1436276 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `dic_biz_tree`
-- ----------------------------
DROP TABLE IF EXISTS `dic_biz_tree`;
CREATE TABLE `dic_biz_tree` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `biz_code` varchar(50) DEFAULT NULL COMMENT '业务code',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `alias` varchar(50) DEFAULT NULL COMMENT '别名',
  `logo` varchar(128) DEFAULT NULL COMMENT 'logo',
  `value` varchar(128) DEFAULT NULL COMMENT '值',
  `p_code` varchar(50) DEFAULT NULL COMMENT '上级代码',
  `p_name` varchar(50) DEFAULT NULL COMMENT '上级名称',
  `p_path` varchar(512) DEFAULT NULL COMMENT '父路径',
  `depth` int(11) DEFAULT '1' COMMENT '层级深度',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `ext_1` varchar(128) DEFAULT NULL COMMENT '预留字段1',
  `ext_2` varchar(128) DEFAULT NULL COMMENT '预留字段2',
  `ext_3` varchar(128) DEFAULT NULL COMMENT '预留字段3',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常',
  `is_sys_data` char(1) DEFAULT '0' COMMENT '是否系统数据: 0=否，1=是',
  `del_flag` char(1) DEFAULT '1' COMMENT '删除标记：0=已删除,1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典业务树';

-- ----------------------------
-- Records of dic_biz_tree
-- ----------------------------

-- ----------------------------
-- Table structure for `dic_sensitive_word`
-- ----------------------------
DROP TABLE IF EXISTS `dic_sensitive_word`;
CREATE TABLE `dic_sensitive_word` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `word` varchar(32) NOT NULL COMMENT '敏感词',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_key_word` (`word`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='敏感词库';

-- ----------------------------
-- Records of dic_sensitive_word
-- ----------------------------

-- ----------------------------
-- Table structure for `gen_table_column_style`
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column_style`;
CREATE TABLE `gen_table_column_style` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `table` varchar(64) NOT NULL COMMENT '表',
  `column` varchar(64) NOT NULL COMMENT '字段',
  `desc` varchar(64) DEFAULT NULL COMMENT '字段描述',
  `field_name` varchar(64) DEFAULT NULL COMMENT '字段名',
  `is_insert` char(1) DEFAULT '1' COMMENT '是否为插入字段',
  `is_edit` char(1) DEFAULT '0' COMMENT '是否编辑字段: 0=否，1=是',
  `is_list` char(1) DEFAULT '1' COMMENT '是否列表字段: 0=否，1=是',
  `is_query` char(1) DEFAULT '0' COMMENT '是否查询字段: 0=否，1=是',
  `query_type` varchar(32) DEFAULT NULL COMMENT '查询方式：（eq，neq，gt，lt，between，like）',
  `show_type` varchar(32) DEFAULT 'input' COMMENT '字段生成方案: （input、textarea、select、checkbox、radio、dialog）',
  `dic_type` varchar(128) DEFAULT NULL COMMENT '字典类型',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生成表字段样式';

-- ----------------------------
-- Records of gen_table_column_style
-- ----------------------------
INSERT INTO `gen_table_column_style` VALUES ('954673303749005312', 'dic_area', 'id', 'id', 'id', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005313', 'dic_area', 'p_name', '父级名称', 'pname', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005314', 'dic_area', 'area_code', '地区代码', 'areaCode', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005315', 'dic_area', 'area_name', '地区名称', 'areaName', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005316', 'dic_area', 'p_code', '父级代码', 'pcode', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005317', 'dic_area', 'level', '地区等级：1=省，2=市，3=区，4=乡镇，5=村', 'level', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005318', 'dic_area', 'geo', '地理经纬度', 'geo', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005319', 'dic_area', 'pinyin', '拼音', 'pinyin', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005320', 'dic_area', 'short_pinyin', '短拼音', 'shortPinyin', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005321', 'dic_area', 'zip_code', '邮编', 'zipCode', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('954673303749005322', 'dic_area', 'stats_year', '统计年', 'statsYear', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('955451293655240704', 'dic_sensitive_word', 'id', 'id', 'id', '0', '0', '1', '0', 'eq', 'input', '', '1');
INSERT INTO `gen_table_column_style` VALUES ('955451293655240705', 'dic_sensitive_word', 'word', '敏感词', 'word', '0', '0', '1', '0', 'eq', 'input', '', '1');

-- ----------------------------
-- Table structure for `message_group`
-- ----------------------------
DROP TABLE IF EXISTS `message_group`;
CREATE TABLE `message_group` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `type` varchar(32) NOT NULL COMMENT '类型',
  `biz_type` varchar(32) NOT NULL COMMENT '业务类型',
  `group_key` varchar(64) NOT NULL COMMENT '群组key',
  `name` varchar(36) NOT NULL COMMENT '群组名',
  `owner_id` varchar(32) NOT NULL COMMENT '群主id',
  `member_ids` varchar(1024) DEFAULT NULL COMMENT '成员id,逗号隔开',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `env` varchar(10) NOT NULL DEFAULT 'test' COMMENT '环境: test/product',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息群';

-- ----------------------------
-- Records of message_group
-- ----------------------------

-- ----------------------------
-- Table structure for `message_send_hi`
-- ----------------------------
DROP TABLE IF EXISTS `message_send_hi`;
CREATE TABLE `message_send_hi` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `receive_by` varchar(256) DEFAULT NULL COMMENT '接收人',
  `receive_body` varchar(120) NOT NULL COMMENT '接收主体：email、phone、群组id等',
  `send_target_type` char(32) NOT NULL COMMENT '发送目标类型：p=个人、g=群组',
  `receive_service_type` varchar(32) NOT NULL COMMENT '接收服务类型',
  `biz_type` varchar(64) NOT NULL COMMENT '业务类型',
  `biz_id` varchar(64) DEFAULT NULL COMMENT '业务id',
  `content` varchar(256) NOT NULL COMMENT '内容',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=失败，1=成功',
  `ret_no` varchar(64) DEFAULT NULL COMMENT '返回流水号',
  `ret_code` varchar(16) DEFAULT NULL COMMENT '返回码',
  `ret_msg` varchar(64) DEFAULT NULL COMMENT '返回消息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息发送记录';

-- ----------------------------
-- Records of message_send_hi
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_exception`
-- ----------------------------
DROP TABLE IF EXISTS `sys_exception`;
CREATE TABLE `sys_exception` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `biz_module` varchar(64) NOT NULL COMMENT '业务模块',
  `method_name` varchar(36) NOT NULL COMMENT '方法名',
  `exception_type` varchar(128) NOT NULL COMMENT '异常类型',
  `exception` text COMMENT '异常消息',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip地址',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统异常';

-- ----------------------------
-- Records of sys_exception
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `p_id` varchar(32) DEFAULT NULL COMMENT '父级编号',
  `p_path` varchar(512) DEFAULT NULL COMMENT '父路径',
  `depth` int(11) DEFAULT '1' COMMENT '层级深度',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `type` varchar(18) NOT NULL COMMENT '类型：menu=菜单，button=按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `href` varchar(128) DEFAULT NULL COMMENT '链接',
  `icon` varchar(128) DEFAULT NULL COMMENT '图标',
  `permission` varchar(128) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注信息',
  `is_mobile_show` char(1) DEFAULT '0' COMMENT '手机端显示 0=否，1=是',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常',
  `is_sys_data` char(1) DEFAULT '0' COMMENT '是否系统数据: 0=否，1=是',
  `del_flag` char(1) DEFAULT '1' COMMENT '删除标记：0=已删除,1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('955035568528560128', null, null, '1', 'ddd', 'buttom', null, null, null, 'fff', '1', '2018-01-21 19:13:18', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955036197330227200', '1', null, '0', '系统管理', 'menu', '1', 'www.google.com', null, 'fff', '1', '2018-01-21 19:15:48', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955051020965253120', '1', null, '0', 'bbb', 'buttom', null, null, null, 'dddd', '1', '2018-01-21 20:14:42', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955051062342062080', '1', null, '0', 'bbb', 'buttom', null, null, null, 'dddd', '1', '2018-01-21 20:14:52', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955051475665555456', '1', null, '0', 'bbb', 'buttom', null, null, null, 'dddd5555555', '1', '2018-01-21 20:16:30', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955052048351629312', '1', null, '0', 'fff', 'buttom', null, null, null, 'fffffff', '1', '2018-01-21 20:18:47', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955052224906661888', '1', null, '0', 'dddddd', 'buttom', null, null, null, 'ddfffff', '1', '2018-01-21 20:19:29', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955052530457513984', '1', null, '0', 'rtt', 'buttom', null, null, null, 'tttwer', '1', '2018-01-21 20:20:42', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955103199583408128', '955036197330227200', 'null.955036197330227200', '1', 'ffffffff', 'buttom', null, null, null, 'dddddd', '1', '2018-01-21 23:42:02', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955104198649843712', '955036197330227200', '955036197330227200', '1', '898', 'buttom', null, null, null, '666', '1', '2018-01-21 23:46:01', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955104458403090432', '955103199583408128', 'null.955036197330227200.955103199583408128', '2', 'dddddd', 'buttom', null, null, null, 'ffffff', '1', '2018-01-21 23:47:03', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955104659612241920', '955036197330227200', '955036197330227200', '1', '66666', 'buttom', null, null, null, '6666666666', '1', '2018-01-21 23:47:50', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955105114073468928', '955036197330227200', '955036197330227200', '1', 'fffffffffff', 'buttom', null, null, null, 'ffddddddddddddd', '1', '2018-01-21 23:49:39', null, null, null, '0', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('955105697996083200', '955036197330227200', '955036197330227200', '1', 'fghjfghj', 'buttom', null, null, null, 'fghjfghj', '1', '2018-01-21 23:51:58', null, null, null, '0', '1', '1', '1');

-- ----------------------------
-- Table structure for `sys_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `p_id` varchar(64) DEFAULT NULL COMMENT '上级id',
  `p_path` varchar(512) DEFAULT NULL COMMENT '父路径',
  `depth` int(11) DEFAULT '1' COMMENT '层级深度',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域编码',
  `type` varchar(16) NOT NULL COMMENT '机构类型: company=公司、dept=部门',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `master` varchar(32) DEFAULT NULL COMMENT '负责人',
  `tel` varchar(64) DEFAULT NULL COMMENT '电话',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `data_md5` varchar(32) DEFAULT NULL COMMENT '数据md5码(检测是否有变更)',
  `code` varchar(64) DEFAULT NULL COMMENT 'code标识',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常',
  `is_sys_data` char(1) DEFAULT '0' COMMENT '是否系统数据: 0=否，1=是',
  `del_flag` char(1) DEFAULT '1' COMMENT '删除标记：0=已删除,1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统机构';

-- ----------------------------
-- Records of sys_office
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `opt_type` varchar(32) NOT NULL COMMENT '操作类型',
  `desc` varchar(128) NOT NULL COMMENT '说明',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求uri',
  `method` varchar(8) NOT NULL COMMENT '方法',
  `params` varchar(1024) DEFAULT NULL COMMENT '请求参数',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_remote_exception`
-- ----------------------------
DROP TABLE IF EXISTS `sys_remote_exception`;
CREATE TABLE `sys_remote_exception` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `biz_module` varchar(64) NOT NULL COMMENT '业务模块',
  `biz_id` varchar(64) NOT NULL COMMENT '业务id',
  `bean_name` varchar(36) NOT NULL COMMENT 'spring 实例名',
  `method_name` varchar(36) NOT NULL COMMENT '方法名',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `params_vals` text COMMENT '参数值，多个###隔开',
  `params_types` varchar(512) DEFAULT NULL COMMENT '参数类型，多个###隔开',
  `status` char(1) DEFAULT '1' COMMENT '状态：1=待修复, 2=已修复, 3=已忽略',
  `exception` text COMMENT '异常消息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统远程异常';

-- ----------------------------
-- Records of sys_remote_exception
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `office_id` varchar(32) NOT NULL COMMENT '归属机构',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围: 0=个人，1=本机构，2=所有',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `CREATE_BY` varchar(32) NOT NULL COMMENT '创建者',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) DEFAULT NULL COMMENT '创建者',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `STATUS` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常',
  `IS_SYS_DATA` char(1) DEFAULT '0' COMMENT '是否系统数据: 0=否，1=是',
  `DEL_FLAG` char(1) DEFAULT '1' COMMENT '删除标记：0=已删除,1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_seq`
-- ----------------------------
DROP TABLE IF EXISTS `sys_seq`;
CREATE TABLE `sys_seq` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `sys` varchar(64) NOT NULL COMMENT '系统名',
  `sub_sys` varchar(64) NOT NULL COMMENT '子系统名',
  `table_name` varchar(64) NOT NULL COMMENT '表名',
  `model_name` varchar(64) NOT NULL COMMENT '模块名',
  `value` bigint(20) NOT NULL DEFAULT '0' COMMENT '序号值',
  `step` int(11) DEFAULT '1' COMMENT '步长',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `load_time` datetime DEFAULT NULL COMMENT '加载时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统序列';

-- ----------------------------
-- Records of sys_seq
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_setting`
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `type_code` varchar(64) NOT NULL COMMENT '类型code',
  `code` varchar(64) NOT NULL COMMENT 'code',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `value` varchar(128) NOT NULL COMMENT '值',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `ext_1` varchar(128) DEFAULT NULL COMMENT '预留字段1',
  `ext_2` varchar(128) DEFAULT NULL COMMENT '预留字段2',
  `ext_3` varchar(128) DEFAULT NULL COMMENT '预留字段3',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常',
  `del_flag` char(1) DEFAULT '1' COMMENT '删除标记：0=已删除,1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置';

-- ----------------------------
-- Records of sys_setting
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `company_id` varchar(64) NOT NULL COMMENT '归属公司',
  `office_id` varchar(64) NOT NULL COMMENT '归属部门，多个逗号隔开',
  `job_number` varchar(32) DEFAULT NULL COMMENT '工号',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `english_name` varchar(32) DEFAULT NULL COMMENT '英文名',
  `is_admin` char(1) DEFAULT '0' COMMENT '是否为管理员 0=否，1=是',
  `is_boss` char(1) DEFAULT '0' COMMENT '是否为老板 0=否，1=是',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `gender` char(1) DEFAULT '0' COMMENT '性别。0=未定义，1=男性，2=女性',
  `avatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `login_ip` varchar(18) DEFAULT NULL COMMENT '最后登陆ip',
  `login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `position` varchar(64) DEFAULT NULL COMMENT '职位信息',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `source` varchar(16) NOT NULL COMMENT '来源',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=禁用，1=正常, 2=离职',
  `is_sys_data` char(1) DEFAULT '0' COMMENT '是否系统数据: 0=否，1=是',
  `del_flag` char(1) DEFAULT '1' COMMENT '删除标记：0=已删除,1=正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_login_hi`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login_hi`;
CREATE TABLE `sys_user_login_hi` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `account` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip地址',
  `client_source` varchar(16) NOT NULL COMMENT '客户端来源',
  `sys_code` varchar(32) NOT NULL COMMENT '系统code',
  `fail_reason` varchar(64) DEFAULT NULL COMMENT '失败原因',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0=失败，1=成功',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户登录记录';

-- ----------------------------
-- Records of sys_user_login_hi
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_rel_thirdparty`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_rel_thirdparty`;
CREATE TABLE `sys_user_rel_thirdparty` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `ding_union_id` varchar(64) DEFAULT NULL COMMENT '钉钉唯一标识',
  `ding_global_id` varchar(64) DEFAULT NULL COMMENT '钉钉全局标识',
  `wwx_union_id` varchar(64) DEFAULT NULL COMMENT '企业微信唯一标识',
  `wwx_global_id` varchar(64) DEFAULT NULL COMMENT '企业微信全局标识',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关联第三方';

-- ----------------------------
-- Records of sys_user_rel_thirdparty
-- ----------------------------
