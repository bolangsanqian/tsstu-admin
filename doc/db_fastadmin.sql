/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50637
Source Host           : 127.0.0.1:3306
Source Database       : db_fastadmin

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-06-05 21:52:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `remark` varchar(64) NOT NULL COMMENT '资源名称',
  `key` varchar(64) NOT NULL,
  `url` varchar(128) DEFAULT NULL COMMENT '资源地址',
  `perms` varchar(128) DEFAULT NULL COMMENT '功能权限',
  `type` tinyint(4) NOT NULL COMMENT '类型（0：目录，1：菜单，2功能',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `parent_id` bigint(20) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`),
  UNIQUE KEY `u_sys_resource` (`key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统管理', 'sys_manage', null, null, '0', 'fa fa-cog', '0', '98');
INSERT INTO `sys_resource` VALUES ('2', '菜单管理', 'menu_manage', 'modules/sys/menu.html', 'sys:menu:list,sys:menu:info', '1', 'fa fa-th-list', '1', '3');
INSERT INTO `sys_resource` VALUES ('4', '新增', 'menu_add', null, 'sys:menu:save', '2', null, '2', '0');
INSERT INTO `sys_resource` VALUES ('5', '修改', 'menu_edit', null, 'sys:menu:update', '2', null, '2', '0');
INSERT INTO `sys_resource` VALUES ('6', '删除', 'menu_delete', null, 'sys:menu:delete', '2', null, '2', '0');
INSERT INTO `sys_resource` VALUES ('7', '角色管理', 'role_manage', 'modules/sys/role.html', 'sys:role:info,sys:role:list', '1', 'fa fa-user-secret', '1', '2');
INSERT INTO `sys_resource` VALUES ('8', '用户管理', 'admin_manage', 'modules/sys/user.html', 'sys:user:update,sys:user:list,sys:user:info', '1', 'fa fa-user', '1', '1');
INSERT INTO `sys_resource` VALUES ('9', '新增', 'user_add', null, 'sys:user:save,sys:role:select', '2', null, '8', '0');
INSERT INTO `sys_resource` VALUES ('10', '修改', 'user_edit', null, 'sys:user:update,sys:role:select', '2', null, '8', '0');
INSERT INTO `sys_resource` VALUES ('11', '删除', 'user_delete', null, 'sys:user:delete', '2', null, '8', '0');
INSERT INTO `sys_resource` VALUES ('12', '新增', 'role_add', null, 'sys:role:save,sys:menu:perms', '2', null, '7', '0');
INSERT INTO `sys_resource` VALUES ('13', '修改', 'role_edit', null, 'sys:role:update,sys:menu:perms', '2', null, '7', '0');
INSERT INTO `sys_resource` VALUES ('14', '删除', 'role_delete', null, 'sys:role:delete', '2', null, '7', '0');
INSERT INTO `sys_resource` VALUES ('37', '查询日志', 'log_list', null, 'sys:log:list', '2', null, '61', '0');
INSERT INTO `sys_resource` VALUES ('38', '系统参数', 'param_manage', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-building', '1', '4');
INSERT INTO `sys_resource` VALUES ('39', '定时任务', 'scheduler_manage', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '1', '5');
INSERT INTO `sys_resource` VALUES ('40', '查看', 'schedule_detail', null, 'sys:schedule:list,sys:schedule:info', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('41', '新增', 'schedule_add', null, 'sys:schedule:save', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('42', '修改', 'schedule_edit', null, 'sys:schedule:update', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('43', '删除', 'schedule_del', null, 'sys:schedule:delete', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('44', '暂停', 'schedule_stop', null, 'sys:schedule:pause', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('45', '恢复', 'schedule_recovery', null, 'sys:schedule:resume', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('46', '立即执行', 'schedule_run', null, 'sys:schedule:run', '2', null, '39', '0');
INSERT INTO `sys_resource` VALUES ('59', '监控管理', 'monitor', null, null, '0', 'fas fa-eye', '0', '0');
INSERT INTO `sys_resource` VALUES ('60', '主机分组', 'monitor_hostgroup', 'modules/monitor/hostgroup.html', 'monitor:hostgroup', '1', 'fa fa-sitemap', '59', '0');
INSERT INTO `sys_resource` VALUES ('61', '操作日志', 'log_manage', 'modules/sys/log.html', null, '1', 'fab fa-delicious', '1', '0');
INSERT INTO `sys_resource` VALUES ('62', '主机监控', 'monitor_host', 'modules/monitor/host.html', 'monitor:host', '1', 'fas fa-server', '59', '1');
INSERT INTO `sys_resource` VALUES ('63', '服务监控', 'monitor_service', 'modules/monitor/service.html', 'monitor:service', '1', 'fab fa-servicestack', '59', '2');
INSERT INTO `sys_resource` VALUES ('64', '指标监控', 'monitor_counter', 'modules/monitor/counter.html', 'monitor:counter', '1', 'fas fa-eye', '59', '3');
INSERT INTO `sys_resource` VALUES ('65', 'P2P调度', 'p2p_manage', null, null, '0', 'fab fa-product-hunt', '0', '1');
INSERT INTO `sys_resource` VALUES ('66', '节点监控', 'p2p_node_monitor', 'modules/p2p/node_monitor.html', 'p2p:node_monitor', '1', 'fas fa-eye', '65', '0');
INSERT INTO `sys_resource` VALUES ('67', '节点拓扑', 'p2p_node_topology', 'modules/p2p/node_topology.html', 'p2p:node_topology', '1', 'fab fa-hubspot', '65', '1');
INSERT INTO `sys_resource` VALUES ('68', '调度参数', 'p2p_schedue_param', 'modules/p2p/schedue_param.html', 'p2p:schedue_param', '1', 'fas fa-cogs', '65', '2');
INSERT INTO `sys_resource` VALUES ('69', '主机分组-新增', 'hostgroup_save', null, 'monitor:hostgroup:save', '2', null, '60', '0');
INSERT INTO `sys_resource` VALUES ('70', '主机分组-删除', 'hostgroup_delete', null, 'monitor:hostgroup:delete', '2', null, '60', '0');
INSERT INTO `sys_resource` VALUES ('71', '主机分组-修改', 'hostgroup_update', null, 'monitor:hostgroup:update', '2', null, '60', '0');
INSERT INTO `sys_resource` VALUES ('72', '主机监控-新增', 'host_save', null, 'monitor:host:save', '2', null, '60', '0');
INSERT INTO `sys_resource` VALUES ('73', '主机监控-删除', 'host_delete', null, 'monitor:host:delete', '2', null, '60', '0');
INSERT INTO `sys_resource` VALUES ('74', '主机监控-修改', 'host_update', null, 'monitor:host:update', '2', null, '60', '0');
INSERT INTO `sys_resource` VALUES ('75', '数据字典', 'dict_manage', 'modules/sys/dict.html', 'sys:dict:list,sys:dict:info', '1', 'far fa-newspaper', '1', '6');
INSERT INTO `sys_resource` VALUES ('76', '新增数据字典', 'add_dict', null, 'sys:dict:save,sys:dictItem:save', '2', null, '75', '0');
INSERT INTO `sys_resource` VALUES ('77', '修改数据字典', 'edit_dict', null, 'sys:dict:update,sys:dictItem:update', '2', null, '75', '0');
INSERT INTO `sys_resource` VALUES ('78', '删除数据字典', 'del_dict', null, 'sys:dict:delete,sys:dictItem:delete', '2', null, '75', '0');
INSERT INTO `sys_resource` VALUES ('79', '白名单管理', 'white_list', 'modules/sys/white.html', 'sys:white:info,sys:white:list', '1', 'fab fa-delicious', '1', '0');
INSERT INTO `sys_resource` VALUES ('80', '新增白名单', 'white_add', null, 'sys:white:save', '2', null, '79', '0');
INSERT INTO `sys_resource` VALUES ('81', '白名单修改', 'white_edit', null, 'sys:white:update', '2', null, '79', '0');
INSERT INTO `sys_resource` VALUES ('82', '删除白名单', 'white_del', null, 'sys:white:delete', '2', null, '79', '0');
INSERT INTO `sys_resource` VALUES ('83', '终端管理', 'terminal_manage', null, null, '0', 'fas fa-bullhorn', '0', '3');
INSERT INTO `sys_resource` VALUES ('84', '终端信息', 'terminal_info', 'modules/dev/terminalInfo.html', 'dev:info:update,dev:info:list,dev:info:info', '1', 'far fa-circle', '83', '1');
INSERT INTO `sys_resource` VALUES ('85', '终端升级文件', 'upgrade_files', 'modules/dev/upgradeFile.html', 'upgrade:file:delete,upgrade:file:info,upgrade:file:list', '1', null, '83', '1');
INSERT INTO `sys_resource` VALUES ('86', '上传升级文件', 'upload_file', null, 'upgrade:file:upload', '2', null, '85', '0');
INSERT INTO `sys_resource` VALUES ('87', '终端升级', 'upgrade_devs', null, 'upgrade:dev:upgradeBatch', '2', null, '85', '2');
INSERT INTO `sys_resource` VALUES ('88', '终端升级记录', 'upgrade_recode', 'modules/dev/upgradeRecode.html', 'upgrade:recode:info,upgrade:recode:list', '1', null, '83', '3');
INSERT INTO `sys_resource` VALUES ('89', '终端地图', 'dev_map', 'modules/dev/map.html', 'dev:map:list', '1', 'fas fa-map-marker', '83', '0');
INSERT INTO `sys_resource` VALUES ('90', '统计报表', 'stat', null, null, '0', 'fas fa-signal', '0', '5');
INSERT INTO `sys_resource` VALUES ('91', '子系统总量报表', 'stat_total_quantity_subsys', 'modules/stat/total_quantity_subsys.html', 'stat:totalquantity:subsys', '1', 'fas fa-chart-line', '90', '3');
INSERT INTO `sys_resource` VALUES ('92', '子系统增量报表', 'stat_quantity_subsys', 'modules/stat/quantity_subsys.html', 'stat:newquantity:subsys', '1', 'fas fa-chart-line', '90', '4');
INSERT INTO `sys_resource` VALUES ('93', '终端总量报表', 'stat_total_quantity_dev', 'modules/stat/total_quantity_dev.html', 'stat:totalquantity:dev', '1', 'fas fa-chart-line', '90', '1');
INSERT INTO `sys_resource` VALUES ('94', '终端增量报表', 'stat_quantity_dev', 'modules/stat/quantity_dev.html', 'stat:newquantity:dev', '1', 'fas fa-chart-line', '90', '2');
INSERT INTO `sys_resource` VALUES ('96', '平台参数', 'plat_config', 'modules/sys/platConfig.html', 'sys:plat:config:list,sys:plat:config:info,sys:plat:config:save,sys:plat:config:update,sys:plat:config:delete', '1', 'fas fa-chart-line', '1', '8');

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
  `salt` varchar(64) NOT NULL COMMENT '动态key',
  `type` tinyint(4) NOT NULL COMMENT '用户类型(0:管理员,1:交易所,2:运营中心,3:会员单位,4:代理会员)',
  `status` tinyint(4) NOT NULL COMMENT '状态(0:锁定,1启用)',
  `create_by` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `u_sys_user` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('3', 'liwei', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('4', 'admin4', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('5', 'liwei5', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('6', 'admin6', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('7', 'liwei7', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('8', 'admin8', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('9', 'liwei9', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('10', 'admin10', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('11', 'liwei11', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('12', 'admin12', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('13', 'liwei3', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('14', 'admin14', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('15', 'liwei15', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);
INSERT INTO `sys_user` VALUES ('16', 'admin16', null, '李维', '13611111111', '13611111111@qq.com', '78dc5e3609e19c70d2638c42770debf7b645a41d640b89bf0e069f434eed3d43', 'maOAu5mwrwpH749Yzh6O', '0', '1', '1', '2018-03-08 14:45:47', null);
INSERT INTO `sys_user` VALUES ('17', 'liwei17', null, '李维', '13611111111', '13611111111@qq.com', '33b1aa0276b4c70ce911fe10e5388059ad4fa51d501b6533bbae1fd58f5529b6', '5h3T6vPfQfGp2TGcTaTZ', '0', '1', '1', '2018-04-26 11:00:09', null);

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
