/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50637
Source Host           : 127.0.0.1:3306
Source Database       : db_fastadmin

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-10-11 16:51:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `parent_id` bigint(20) DEFAULT NULL,
  `type` tinyint(4) NOT NULL COMMENT '资源类型（0：菜单，1：页面，2：功能)',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `code` varchar(64) NOT NULL COMMENT '资源代码',
  `permission_tag` varchar(128) DEFAULT NULL COMMENT '权限标识',
  `url` varchar(128) DEFAULT NULL COMMENT '资源地址',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(0：停用，1：启用)',
  `remark` varchar(64) NOT NULL COMMENT '备注',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `label_tag` varchar(64) DEFAULT NULL COMMENT '标签标示',
  PRIMARY KEY (`resource_id`),
  UNIQUE KEY `u_sys_resource` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '0', '0', '系统管理', 'sys_manage', null, null, 'fa fa-cog', '1', '系统管理', '98', null);
INSERT INTO `sys_resource` VALUES ('2', '1', '1', '菜单管理', 'menu_manage', 'sys:menu:list,sys:menu:info', '/sys/menu/index.html', 'fa fa-th-list', '1', '菜单管理', '3', null);
INSERT INTO `sys_resource` VALUES ('4', '2', '2', '新增', 'menu_add', 'sys:menu:save', null, null, '1', '新增', '0', null);
INSERT INTO `sys_resource` VALUES ('5', '2', '2', '修改', 'menu_edit', 'sys:menu:update', null, null, '1', '修改', '0', null);
INSERT INTO `sys_resource` VALUES ('6', '2', '2', '删除', 'menu_delete', 'sys:menu:delete', null, null, '1', '删除', '0', null);
INSERT INTO `sys_resource` VALUES ('7', '1', '1', '角色管理', 'role_manage', 'sys:role:info,sys:role:list', 'modules/sys/role.html', 'fa fa-user-secret', '1', '角色管理', '2', null);
INSERT INTO `sys_resource` VALUES ('8', '1', '1', '用户管理', 'admin_manage', 'sys:user:update,sys:user:list,sys:user:info', '/sys/admin/index.html', 'fa fa-user', '1', '用户管理', '1', null);
INSERT INTO `sys_resource` VALUES ('9', '8', '2', '新增', 'user_add', 'sys:user:save,sys:role:select', null, null, '1', '新增', '0', null);
INSERT INTO `sys_resource` VALUES ('10', '8', '2', '修改', 'user_edit', 'sys:user:update,sys:role:select', null, null, '1', '修改', '0', null);
INSERT INTO `sys_resource` VALUES ('11', '8', '2', '删除', 'user_delete', 'sys:user:delete', null, null, '1', '删除', '0', null);
INSERT INTO `sys_resource` VALUES ('12', '7', '2', '新增', 'role_add', 'sys:role:save,sys:menu:perms', null, null, '1', '新增', '0', null);
INSERT INTO `sys_resource` VALUES ('13', '7', '2', '修改', 'role_edit', 'sys:role:update,sys:menu:perms', null, null, '1', '修改', '0', null);
INSERT INTO `sys_resource` VALUES ('14', '7', '2', '删除', 'role_delete', 'sys:role:delete', null, null, '1', '删除', '0', null);
INSERT INTO `sys_resource` VALUES ('37', '61', '2', '查询日志', 'log_list', 'sys:log:list', null, null, '1', '查询日志', '0', null);
INSERT INTO `sys_resource` VALUES ('38', '1', '1', '系统参数', 'param_manage', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 'modules/sys/config.html', 'fa fa-building', '1', '系统参数', '4', null);
INSERT INTO `sys_resource` VALUES ('39', '1', '1', '定时任务', 'scheduler_manage', null, 'modules/job/schedule.html', 'fa fa-tasks', '1', '定时任务', '5', null);
INSERT INTO `sys_resource` VALUES ('40', '39', '2', '查看', 'schedule_detail', 'sys:schedule:list,sys:schedule:info', null, null, '1', '查看', '0', null);
INSERT INTO `sys_resource` VALUES ('41', '39', '2', '新增', 'schedule_add', 'sys:schedule:save', null, null, '1', '新增', '0', null);
INSERT INTO `sys_resource` VALUES ('42', '39', '2', '修改', 'schedule_edit', 'sys:schedule:update', null, null, '1', '修改', '0', null);
INSERT INTO `sys_resource` VALUES ('43', '39', '2', '删除', 'schedule_del', 'sys:schedule:delete', null, null, '1', '删除', '0', null);
INSERT INTO `sys_resource` VALUES ('44', '39', '2', '暂停', 'schedule_stop', 'sys:schedule:pause', null, null, '1', '暂停', '0', null);
INSERT INTO `sys_resource` VALUES ('45', '39', '2', '恢复', 'schedule_recovery', 'sys:schedule:resume', null, null, '1', '恢复', '0', null);
INSERT INTO `sys_resource` VALUES ('46', '39', '2', '立即执行', 'schedule_run', 'sys:schedule:run', null, null, '1', '立即执行', '0', null);
INSERT INTO `sys_resource` VALUES ('59', '0', '0', '监控管理', 'monitor', null, null, 'fas fa-eye', '1', '监控管理', '0', null);
INSERT INTO `sys_resource` VALUES ('60', '59', '1', '主机分组', 'monitor_hostgroup', 'monitor:hostgroup', 'modules/monitor/hostgroup.html', 'fa fa-sitemap', '1', '主机分组', '0', null);
INSERT INTO `sys_resource` VALUES ('61', '1', '1', '操作日志', 'log_manage', null, 'modules/sys/log.html', 'fab fa-delicious', '1', '操作日志', '0', null);
INSERT INTO `sys_resource` VALUES ('62', '59', '1', '主机监控', 'monitor_host', 'monitor:host', 'modules/monitor/host.html', 'fas fa-server', '1', '主机监控', '1', null);
INSERT INTO `sys_resource` VALUES ('63', '59', '1', '服务监控', 'monitor_service', 'monitor:service', 'modules/monitor/service.html', 'fab fa-servicestack', '1', '服务监控', '2', null);
INSERT INTO `sys_resource` VALUES ('64', '59', '1', '指标监控', 'monitor_counter', 'monitor:counter', 'modules/monitor/counter.html', 'fas fa-eye', '1', '指标监控', '3', null);
INSERT INTO `sys_resource` VALUES ('65', '0', '0', 'P2P调度', 'p2p_manage', null, null, 'fab fa-product-hunt', '1', 'P2P调度', '1', null);
INSERT INTO `sys_resource` VALUES ('66', '65', '1', '节点监控', 'p2p_node_monitor', 'p2p:node_monitor', 'modules/p2p/node_monitor.html', 'fas fa-eye', '1', '节点监控', '0', null);
INSERT INTO `sys_resource` VALUES ('67', '65', '1', '节点拓扑', 'p2p_node_topology', 'p2p:node_topology', 'modules/p2p/node_topology.html', 'fab fa-hubspot', '1', '节点拓扑', '1', null);
INSERT INTO `sys_resource` VALUES ('68', '65', '1', '调度参数', 'p2p_schedue_param', 'p2p:schedue_param', 'modules/p2p/schedue_param.html', 'fas fa-cogs', '1', '调度参数', '2', null);
INSERT INTO `sys_resource` VALUES ('69', '60', '2', '主机分组-新增', 'hostgroup_save', 'monitor:hostgroup:save', null, null, '1', '主机分组-新增', '0', null);
INSERT INTO `sys_resource` VALUES ('70', '60', '2', '主机分组-删除', 'hostgroup_delete', 'monitor:hostgroup:delete', null, null, '1', '主机分组-删除', '0', null);
INSERT INTO `sys_resource` VALUES ('71', '60', '2', '主机分组-修改', 'hostgroup_update', 'monitor:hostgroup:update', null, null, '1', '主机分组-修改', '0', null);
INSERT INTO `sys_resource` VALUES ('72', '60', '2', '主机监控-新增', 'host_save', 'monitor:host:save', null, null, '1', '主机监控-新增', '0', null);
INSERT INTO `sys_resource` VALUES ('73', '60', '2', '主机监控-删除', 'host_delete', 'monitor:host:delete', null, null, '1', '主机监控-删除', '0', null);
INSERT INTO `sys_resource` VALUES ('74', '60', '2', '主机监控-修改', 'host_update', 'monitor:host:update', null, null, '1', '主机监控-修改', '0', null);
INSERT INTO `sys_resource` VALUES ('75', '1', '1', '数据字典', 'dict_manage', 'sys:dict:list,sys:dict:info', 'modules/sys/dict.html', 'far fa-newspaper', '1', '数据字典', '6', null);
INSERT INTO `sys_resource` VALUES ('76', '75', '2', '新增数据字典', 'add_dict', 'sys:dict:save,sys:dictItem:save', null, null, '1', '新增数据字典', '0', null);
INSERT INTO `sys_resource` VALUES ('77', '75', '2', '修改数据字典', 'edit_dict', 'sys:dict:update,sys:dictItem:update', null, null, '1', '修改数据字典', '0', null);
INSERT INTO `sys_resource` VALUES ('78', '75', '2', '删除数据字典', 'del_dict', 'sys:dict:delete,sys:dictItem:delete', null, null, '1', '删除数据字典', '0', null);
INSERT INTO `sys_resource` VALUES ('79', '1', '1', '白名单管理', 'white_list', 'sys:white:info,sys:white:list', 'modules/sys/white.html', 'fab fa-delicious', '1', '白名单管理', '0', null);
INSERT INTO `sys_resource` VALUES ('80', '79', '2', '新增白名单', 'white_add', 'sys:white:save', null, null, '1', '新增白名单', '0', null);
INSERT INTO `sys_resource` VALUES ('81', '79', '2', '白名单修改', 'white_edit', 'sys:white:update', null, null, '1', '白名单修改', '0', null);
INSERT INTO `sys_resource` VALUES ('82', '79', '2', '删除白名单', 'white_del', 'sys:white:delete', null, null, '1', '删除白名单', '0', null);
INSERT INTO `sys_resource` VALUES ('83', '0', '0', '终端管理', 'terminal_manage', null, null, 'fas fa-bullhorn', '1', '终端管理', '3', null);
INSERT INTO `sys_resource` VALUES ('84', '83', '1', '终端信息', 'terminal_info', 'dev:info:update,dev:info:list,dev:info:info', 'modules/dev/terminalInfo.html', 'far fa-circle', '1', '终端信息', '1', null);
INSERT INTO `sys_resource` VALUES ('85', '83', '1', '终端升级文件', 'upgrade_files', 'upgrade:file:delete,upgrade:file:info,upgrade:file:list', 'modules/dev/upgradeFile.html', null, '1', '终端升级文件', '1', null);
INSERT INTO `sys_resource` VALUES ('86', '85', '2', '上传升级文件', 'upload_file', 'upgrade:file:upload', null, null, '1', '上传升级文件', '0', null);
INSERT INTO `sys_resource` VALUES ('87', '85', '2', '终端升级', 'upgrade_devs', 'upgrade:dev:upgradeBatch', null, null, '1', '终端升级', '2', null);
INSERT INTO `sys_resource` VALUES ('88', '83', '1', '终端升级记录', 'upgrade_recode', 'upgrade:recode:info,upgrade:recode:list', 'modules/dev/upgradeRecode.html', null, '1', '终端升级记录', '3', null);
INSERT INTO `sys_resource` VALUES ('89', '83', '1', '终端地图', 'dev_map', 'dev:map:list', 'modules/dev/map.html', 'fas fa-map-marker', '1', '终端地图', '0', null);
INSERT INTO `sys_resource` VALUES ('90', '0', '0', '统计报表', 'stat', null, null, 'fas fa-signal', '1', '统计报表', '5', null);
INSERT INTO `sys_resource` VALUES ('91', '90', '1', '子系统总量报表', 'stat_total_quantity_subsys', 'stat:totalquantity:subsys', 'modules/stat/total_quantity_subsys.html', 'fas fa-chart-line', '1', '子系统总量报表', '3', null);
INSERT INTO `sys_resource` VALUES ('92', '90', '1', '子系统增量报表', 'stat_quantity_subsys', 'stat:newquantity:subsys', 'modules/stat/quantity_subsys.html', 'fas fa-chart-line', '1', '子系统增量报表', '4', null);
INSERT INTO `sys_resource` VALUES ('93', '90', '1', '终端总量报表', 'stat_total_quantity_dev', 'stat:totalquantity:dev', 'modules/stat/total_quantity_dev.html', 'fas fa-chart-line', '1', '终端总量报表', '1', null);
INSERT INTO `sys_resource` VALUES ('94', '90', '1', '终端增量报表', 'stat_quantity_dev', 'stat:newquantity:dev', 'modules/stat/quantity_dev.html', 'fas fa-chart-line', '1', '终端增量报表', '2', null);
INSERT INTO `sys_resource` VALUES ('96', '1', '1', '平台参数', 'plat_config', 'sys:plat:config:list,sys:plat:config:info,sys:plat:config:save,sys:plat:config:update,sys:plat:config:delete', 'modules/sys/platConfig.html', 'fas fa-chart-line', '1', '平台参数', '8', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `role_group_id` bigint(20) DEFAULT NULL COMMENT '角色组ID',
  `creater_user_id` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '运维人员', '不可删除', null, '1', '2018-01-11 10:57:54');
INSERT INTO `sys_role` VALUES ('4', '管理员', '包含所有权限', null, '1', '2018-01-11 10:57:54');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_resourc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色资源ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`role_resourc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=467 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('269', '1', '59');
INSERT INTO `sys_role_resource` VALUES ('270', '1', '60');
INSERT INTO `sys_role_resource` VALUES ('271', '1', '69');
INSERT INTO `sys_role_resource` VALUES ('272', '1', '70');
INSERT INTO `sys_role_resource` VALUES ('273', '1', '71');
INSERT INTO `sys_role_resource` VALUES ('274', '1', '72');
INSERT INTO `sys_role_resource` VALUES ('275', '1', '73');
INSERT INTO `sys_role_resource` VALUES ('276', '1', '74');
INSERT INTO `sys_role_resource` VALUES ('277', '1', '62');
INSERT INTO `sys_role_resource` VALUES ('278', '1', '63');
INSERT INTO `sys_role_resource` VALUES ('279', '1', '64');
INSERT INTO `sys_role_resource` VALUES ('280', '1', '65');
INSERT INTO `sys_role_resource` VALUES ('281', '1', '66');
INSERT INTO `sys_role_resource` VALUES ('282', '1', '67');
INSERT INTO `sys_role_resource` VALUES ('283', '1', '68');
INSERT INTO `sys_role_resource` VALUES ('284', '1', '83');
INSERT INTO `sys_role_resource` VALUES ('285', '1', '84');
INSERT INTO `sys_role_resource` VALUES ('286', '1', '85');
INSERT INTO `sys_role_resource` VALUES ('287', '1', '86');
INSERT INTO `sys_role_resource` VALUES ('288', '1', '87');
INSERT INTO `sys_role_resource` VALUES ('289', '1', '88');
INSERT INTO `sys_role_resource` VALUES ('407', '4', '59');
INSERT INTO `sys_role_resource` VALUES ('408', '4', '60');
INSERT INTO `sys_role_resource` VALUES ('409', '4', '69');
INSERT INTO `sys_role_resource` VALUES ('410', '4', '70');
INSERT INTO `sys_role_resource` VALUES ('411', '4', '71');
INSERT INTO `sys_role_resource` VALUES ('412', '4', '72');
INSERT INTO `sys_role_resource` VALUES ('413', '4', '73');
INSERT INTO `sys_role_resource` VALUES ('414', '4', '74');
INSERT INTO `sys_role_resource` VALUES ('415', '4', '62');
INSERT INTO `sys_role_resource` VALUES ('416', '4', '63');
INSERT INTO `sys_role_resource` VALUES ('417', '4', '64');
INSERT INTO `sys_role_resource` VALUES ('418', '4', '65');
INSERT INTO `sys_role_resource` VALUES ('419', '4', '66');
INSERT INTO `sys_role_resource` VALUES ('420', '4', '67');
INSERT INTO `sys_role_resource` VALUES ('421', '4', '68');
INSERT INTO `sys_role_resource` VALUES ('422', '4', '83');
INSERT INTO `sys_role_resource` VALUES ('423', '4', '89');
INSERT INTO `sys_role_resource` VALUES ('424', '4', '84');
INSERT INTO `sys_role_resource` VALUES ('425', '4', '85');
INSERT INTO `sys_role_resource` VALUES ('426', '4', '86');
INSERT INTO `sys_role_resource` VALUES ('427', '4', '87');
INSERT INTO `sys_role_resource` VALUES ('428', '4', '88');
INSERT INTO `sys_role_resource` VALUES ('429', '4', '90');
INSERT INTO `sys_role_resource` VALUES ('430', '4', '93');
INSERT INTO `sys_role_resource` VALUES ('431', '4', '94');
INSERT INTO `sys_role_resource` VALUES ('432', '4', '91');
INSERT INTO `sys_role_resource` VALUES ('433', '4', '92');
INSERT INTO `sys_role_resource` VALUES ('434', '4', '1');
INSERT INTO `sys_role_resource` VALUES ('435', '4', '61');
INSERT INTO `sys_role_resource` VALUES ('436', '4', '37');
INSERT INTO `sys_role_resource` VALUES ('437', '4', '79');
INSERT INTO `sys_role_resource` VALUES ('438', '4', '80');
INSERT INTO `sys_role_resource` VALUES ('439', '4', '81');
INSERT INTO `sys_role_resource` VALUES ('440', '4', '82');
INSERT INTO `sys_role_resource` VALUES ('441', '4', '8');
INSERT INTO `sys_role_resource` VALUES ('442', '4', '9');
INSERT INTO `sys_role_resource` VALUES ('443', '4', '10');
INSERT INTO `sys_role_resource` VALUES ('444', '4', '11');
INSERT INTO `sys_role_resource` VALUES ('445', '4', '7');
INSERT INTO `sys_role_resource` VALUES ('446', '4', '12');
INSERT INTO `sys_role_resource` VALUES ('447', '4', '13');
INSERT INTO `sys_role_resource` VALUES ('448', '4', '14');
INSERT INTO `sys_role_resource` VALUES ('449', '4', '2');
INSERT INTO `sys_role_resource` VALUES ('450', '4', '4');
INSERT INTO `sys_role_resource` VALUES ('451', '4', '5');
INSERT INTO `sys_role_resource` VALUES ('452', '4', '6');
INSERT INTO `sys_role_resource` VALUES ('453', '4', '38');
INSERT INTO `sys_role_resource` VALUES ('454', '4', '39');
INSERT INTO `sys_role_resource` VALUES ('455', '4', '40');
INSERT INTO `sys_role_resource` VALUES ('456', '4', '41');
INSERT INTO `sys_role_resource` VALUES ('457', '4', '42');
INSERT INTO `sys_role_resource` VALUES ('458', '4', '43');
INSERT INTO `sys_role_resource` VALUES ('459', '4', '44');
INSERT INTO `sys_role_resource` VALUES ('460', '4', '45');
INSERT INTO `sys_role_resource` VALUES ('461', '4', '46');
INSERT INTO `sys_role_resource` VALUES ('462', '4', '75');
INSERT INTO `sys_role_resource` VALUES ('463', '4', '76');
INSERT INTO `sys_role_resource` VALUES ('464', '4', '77');
INSERT INTO `sys_role_resource` VALUES ('465', '4', '78');
INSERT INTO `sys_role_resource` VALUES ('466', '4', '96');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '登录账户',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(255) NOT NULL COMMENT '真实姓名',
  `mobile` varchar(16) NOT NULL COMMENT '手机号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '动态key',
  `type` tinyint(4) DEFAULT NULL COMMENT '用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)',
  `status` tinyint(4) NOT NULL COMMENT '状态(0:锁定,1启用)',
  `create_by` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('4', 'admin4', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '0', '1', '2018-03-08 14:45:47', '备注');
INSERT INTO `sys_user` VALUES ('5', 'liwei5', '李维1', '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '0', '1', '2018-04-26 11:00:09', '备注');
INSERT INTO `sys_user` VALUES ('6', 'admin6', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '0', '1', '2018-03-08 14:45:47', '备注');
INSERT INTO `sys_user` VALUES ('8', 'admin8', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '0', '1', '2018-03-08 14:45:47', '备注');
INSERT INTO `sys_user` VALUES ('10', 'admin10', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '0', '1', '2018-03-08 14:45:47', '备注');
INSERT INTO `sys_user` VALUES ('12', 'admin12', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '0', '1', '2018-03-08 14:45:47', '备注');
INSERT INTO `sys_user` VALUES ('13', 'liwei3', '李维', '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '0', '1', '2018-04-26 11:00:09', '备注');
INSERT INTO `sys_user` VALUES ('14', 'admin14', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '0', '1', '2018-03-08 14:45:47', '备注');
INSERT INTO `sys_user` VALUES ('16', 'admin16', '李维', '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', '备注');

-- ----------------------------
-- Table structure for t_demo
-- ----------------------------
DROP TABLE IF EXISTS `t_demo`;
CREATE TABLE `t_demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '演示ID',
  `name` varchar(64) DEFAULT NULL COMMENT '演示名称',
  `remark` varchar(64) DEFAULT NULL COMMENT '演示备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_demo
-- ----------------------------
