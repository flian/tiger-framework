-- ----------------------------
-- Records of shiro_permissions
-- ----------------------------
SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `shiro_permissions` VALUES ('1', 'admin_add');
INSERT INTO `shiro_permissions` VALUES ('2', 'admin_modify');
INSERT INTO `shiro_permissions` VALUES ('3', 'admin_delete');
INSERT INTO `shiro_permissions` VALUES ('4', 'admin_read');
INSERT INTO `shiro_permissions` VALUES ('5', 'operator_read');
INSERT INTO `shiro_permissions` VALUES ('6', 'operator_write');


-- ----------------------------
-- Records of shiro_resources
-- ----------------------------
INSERT INTO `shiro_resources` VALUES ('1', '1', '高机密菜单', 'http://highconfidential', null, null);
INSERT INTO `shiro_resources` VALUES ('2', '1', '普通机密菜单', 'http://normalconfidential', null, null);
INSERT INTO `shiro_resources` VALUES ('3', '1', '普通菜单', 'http://normal', null, null);
INSERT INTO `shiro_resources` VALUES ('4', '1', '系统操作员菜单', 'http://operatormenu', null, null);
INSERT INTO `shiro_resources` VALUES ('5', '2', '某按钮', 'http://somebutton1', null, null);

-- ----------------------------
-- Records of shiro_roles
-- ----------------------------
INSERT INTO `shiro_roles` VALUES ('1', 'global_admin');
INSERT INTO `shiro_roles` VALUES ('2', 'dept_admin');
INSERT INTO `shiro_roles` VALUES ('3', 'normal_user');
INSERT INTO `shiro_roles` VALUES ('4', 'operator');

-- ----------------------------
-- Records of shiro_r_role_permission
-- ----------------------------
INSERT INTO `shiro_r_role_permission` VALUES ('1', '2', '1');
INSERT INTO `shiro_r_role_permission` VALUES ('2', '2', '2');
INSERT INTO `shiro_r_role_permission` VALUES ('3', '2', '3');
INSERT INTO `shiro_r_role_permission` VALUES ('4', '2', '4');
INSERT INTO `shiro_r_role_permission` VALUES ('5', '4', '5');
INSERT INTO `shiro_r_role_permission` VALUES ('6', '4', '6');

-- ----------------------------
-- Records of shiro_r_role_resource
-- ----------------------------
INSERT INTO `shiro_r_role_resource` VALUES ('1', '1', '1');
INSERT INTO `shiro_r_role_resource` VALUES ('2', '1', '2');
INSERT INTO `shiro_r_role_resource` VALUES ('3', '1', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('4', '1', '4');
INSERT INTO `shiro_r_role_resource` VALUES ('5', '2', '2');
INSERT INTO `shiro_r_role_resource` VALUES ('6', '2', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('7', '2', '4');
INSERT INTO `shiro_r_role_resource` VALUES ('8', '3', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('9', '4', '4');

-- ----------------------------
-- Records of shiro_r_user_role
-- ----------------------------
INSERT INTO `shiro_r_user_role` VALUES ('1', '5', '1');
INSERT INTO `shiro_r_user_role` VALUES ('2', '1', '2');
INSERT INTO `shiro_r_user_role` VALUES ('3', '4', '2');
INSERT INTO `shiro_r_user_role` VALUES ('4', '2', '2');
INSERT INTO `shiro_r_user_role` VALUES ('5', '3', '3');
INSERT INTO `shiro_r_user_role` VALUES ('6', '1', '4');
INSERT INTO `shiro_r_user_role` VALUES ('7', '3', '4');

-- ----------------------------
-- Records of shiro_users
-- ----------------------------
INSERT INTO `shiro_users` VALUES ('1', 'charles1', '123');
INSERT INTO `shiro_users` VALUES ('2', 'jessica', '234');
INSERT INTO `shiro_users` VALUES ('3', 'kevin', '345');
INSERT INTO `shiro_users` VALUES ('4', 'charles2', '456');
INSERT INTO `shiro_users` VALUES ('5', 'admin', 'admin');
