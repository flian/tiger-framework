-- ----------------------------
-- Records of shiro_permissions
-- ----------------------------
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '家电', '家电', '0', '');
INSERT INTO `category` VALUES ('2', '数码', '数码', '0', '');
INSERT INTO `category` VALUES ('3', '手机', '手机', '0', '');
INSERT INTO `category` VALUES ('4', '电视机', '电视机', '1', '');
INSERT INTO `category` VALUES ('5', '洗衣机', '洗衣机', '1', null);
INSERT INTO `category` VALUES ('6', '吸尘器', '吸尘器', '1', null);
INSERT INTO `category` VALUES ('7', '平板电脑', '平板电脑', '2', null);
INSERT INTO `category` VALUES ('8', '苹果', '苹果', '3', null);
INSERT INTO `category` VALUES ('19', '小米', '小米品牌系列', '3', '');
INSERT INTO `category` VALUES ('20', 'note', '', '19', '');
INSERT INTO `category` VALUES ('21', '红米', '', '19', '');
INSERT INTO `category` VALUES ('22', '海尔', '', '5', '');
INSERT INTO `category` VALUES ('23', '西门子', '西门子', '5', '');
INSERT INTO `category` VALUES ('26', '运动', '运动', '0', null);
INSERT INTO `category` VALUES ('29', '阿迪达斯', '阿迪达斯', '26', '');
INSERT INTO `category` VALUES ('30', '耐克', '耐克', '26', '');
INSERT INTO `category` VALUES ('31', '新百伦', '新百伦', '26', '');
INSERT INTO `category` VALUES ('33', '苹果6S', '苹果6S', '8', '');
INSERT INTO `category` VALUES ('35', '跑鞋', '跑鞋', '29', '');
INSERT INTO `category` VALUES ('36', '篮球鞋', '篮球鞋', '29', '');
INSERT INTO `category` VALUES ('37', '图书', '图书', '0', '');
INSERT INTO `category` VALUES ('38', '跑鞋', '跑鞋', '30', '');
INSERT INTO `category` VALUES ('39', '篮球鞋', '篮球鞋', '30', '');
INSERT INTO `category` VALUES ('40', '板鞋', '板鞋', '31', '');
INSERT INTO `category` VALUES ('41', '休闲鞋', '休闲鞋', '31', '');
INSERT INTO `category` VALUES ('42', '三星液晶电视', '三星（SAMSUNG）UA55JU7800J 55英寸 曲面 超高清4K 智能3D液晶电视 黑色', '4', '');
INSERT INTO `category` VALUES ('43', 'TCL 液晶电视机', 'TCL D55A630U 55英寸观影王运动版 HDR真4K十四核安卓智能液晶电视机', '4', '');
INSERT INTO `category` VALUES ('44', '戴森(Dyson) 吸尘器', '戴森(Dyson) 吸尘器 V6 Motorhead手持式家用除螨无线无绳', '6', '');
INSERT INTO `category` VALUES ('45', '海尔（Haier）吸尘器 HC-X3C', '海尔（Haier）吸尘器 HC-X3C 家用大功率水洗无耗材', '6', '');
INSERT INTO `category` VALUES ('46', '华为（HUAWEI）平板电脑', '华为（HUAWEI）荣耀畅玩note高配版 平板电脑 9.6英寸', '7', '');
INSERT INTO `category` VALUES ('47', '微软（Microsoft）Surface Pro 4 平板电脑', '微软（Microsoft）Surface Pro 4 平板电脑 12.3英寸', '7', '');

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '三叶草', '小资生活', '鞋子、衣服、裤子', '35', '0');
INSERT INTO `product` VALUES ('2', '小米note4', '小米note4', '小米（MI） 红米Note4 新品上市！十核处理器，4100mAh电池，千元旗舰新标', '20', '0');
INSERT INTO `product` VALUES ('3', '小米（MI） 小米Note ', '小米（MI） 小米Note ', '小米（MI） 小米Note 低至899元！12期白条免息！领券有优惠！5.7英寸高清', '20', '1');
INSERT INTO `product` VALUES ('4', '小米 红米3S', '小米 红米3S手机', '小米 红米3S手机 经典银白 全网通4G标准(2G RAM+16G ROM)标配', '21', '1');
INSERT INTO `product` VALUES ('5', '海尔（Haier） XQB55-M1269', '海尔（Haier） XQB55-M1269', '海尔（Haier） XQB55-M1269 5.5公斤全自动波轮洗衣机 3年质保', '22', '0');
INSERT INTO `product` VALUES ('6', '海尔（Haier）EG7012B29W 7公斤', '海尔（Haier）EG7012B29W 7公斤', '海尔（Haier）EG7012B29W 7公斤 变频滚筒洗衣机 防霉抗菌窗垫 3年质保', '22', '1');
INSERT INTO `product` VALUES ('7', '西门子(SIEMENS) XQG70-WM10N0600W 7公斤', '西门子(SIEMENS) XQG70-WM10N0600W 7公斤', '西门子(SIEMENS) XQG70-WM10N0600W 7公斤 变频 滚筒洗衣机', '23', '0');
INSERT INTO `product` VALUES ('8', '西门子(SIEMENS)WM10N0R80W 7公斤', '西门子(SIEMENS)WM10N0R80W 7公斤', '\r\n西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)\r\n商品编号：1116412649关注商品分享\r\n西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)\r\n西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)\r\n商品编号：1116412649关注商品分享\r\n西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)', '23', '1');
INSERT INTO `product` VALUES ('9', 'Apple iPhone 6s', 'Apple iPhone 6s', 'Apple iPhone 6s', '33', '1');
INSERT INTO `product` VALUES ('10', '三星液晶电视', '三星液晶电视', '三星液晶电视', '42', '1');
INSERT INTO `product` VALUES ('19', '华为（HUAWEI）平板电脑', '华为（HUAWEI）平板电脑', '华为（HUAWEI）平板电脑', '46', '0');
INSERT INTO `product` VALUES ('20', '微软（Microsoft）Surface Pro 4 平板电脑', '微软（Microsoft）Surface Pro 4 平板电脑', '微软（Microsoft）Surface Pro 4 平板电脑', '47', '0');

-- ----------------------------
-- Records of shiro_permissions
-- ----------------------------
INSERT INTO `shiro_permissions` VALUES ('1', 'admin_add');
INSERT INTO `shiro_permissions` VALUES ('2', 'admin_modify');
INSERT INTO `shiro_permissions` VALUES ('3', 'admin_delete');
INSERT INTO `shiro_permissions` VALUES ('4', 'admin_read');
INSERT INTO `shiro_permissions` VALUES ('5', 'operator_read');
INSERT INTO `shiro_permissions` VALUES ('6', 'operator_write');

-- ----------------------------
-- Records of shiro_resources
-- ----------------------------
INSERT INTO `shiro_resources` VALUES ('1', '1', '功能菜单', '#', null, null);
INSERT INTO `shiro_resources` VALUES ('2', '1', '卡包(CRUD Demo)', '/web/wallet/index', null, null);
INSERT INTO `shiro_resources` VALUES ('3', '1', '商品管理', '/web/products', null, null);
INSERT INTO `shiro_resources` VALUES ('4', '1', '订单管理', '/web/orders', null, null);
INSERT INTO `shiro_resources` VALUES ('5', '2', '某按钮', '#', null, null);
INSERT INTO `shiro_resources` VALUES ('6', '1', '分类管理', '/web/categories', null, null);

-- ----------------------------
-- Records of shiro_roles
-- ----------------------------
INSERT INTO `shiro_roles` VALUES ('1', 'global_admin');
INSERT INTO `shiro_roles` VALUES ('2', 'dept_admin');
INSERT INTO `shiro_roles` VALUES ('3', 'normal_user');
INSERT INTO `shiro_roles` VALUES ('4', 'operator');
INSERT INTO `shiro_roles` VALUES ('5', 'product_manager');
INSERT INTO `shiro_roles` VALUES ('6', 'order_manager');

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
INSERT INTO `shiro_r_role_resource` VALUES ('10', '1', '5');
INSERT INTO `shiro_r_role_resource` VALUES ('11', '1', '6');
INSERT INTO `shiro_r_role_resource` VALUES ('12', '5', '1');
INSERT INTO `shiro_r_role_resource` VALUES ('13', '5', '6');
INSERT INTO `shiro_r_role_resource` VALUES ('14', '5', '3');
INSERT INTO `shiro_r_role_resource` VALUES ('15', '6', '1');
INSERT INTO `shiro_r_role_resource` VALUES ('16', '6', '4');

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
INSERT INTO `shiro_r_user_role` VALUES ('8', '6', '5');
INSERT INTO `shiro_r_user_role` VALUES ('9', '7', '6');

-- ----------------------------
-- Records of shiro_users
-- ----------------------------
INSERT INTO `shiro_users` VALUES ('1', 'charles1', '123','');
INSERT INTO `shiro_users` VALUES ('2', 'jessica', '234','');
INSERT INTO `shiro_users` VALUES ('3', 'kevin', '345','');
INSERT INTO `shiro_users` VALUES ('4', 'charles2', '456','');
INSERT INTO `shiro_users` VALUES ('5', 'admin', 'admin','');
INSERT INTO `shiro_users` VALUES ('6', 'product', '123','');
INSERT INTO `shiro_users` VALUES ('7', 'order', '123','');
INSERT INTO `shiro_users` VALUES ('8', 'lucong', '123456','');
INSERT INTO `shiro_users` VALUES ('9', 'ewq', '123','');
INSERT INTO `shiro_users` VALUES ('12', 'ad', 'qwe','');
INSERT INTO `shiro_users` VALUES ('13', 'sscc', '123456','');
INSERT INTO `shiro_users` VALUES ('14', 'dengju', '123456','');
INSERT INTO `shiro_users` VALUES ('15', 'lx', '123','');
INSERT INTO `shiro_users` VALUES ('16', 'zhangyi', '123456','');
INSERT INTO `shiro_users` VALUES ('17', 'ewqr', '123','');

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES ('1', '9', 'iPhone 6s', '【苏宁直发】Apple/苹果 iPhone6s 64G 全网通4G智能手机国行', '6788', '4788', '/images/sku_detail_img/sku_detail_9_1.jpg', 'images/sku_detail_img/sku_detail9.jpg');
INSERT INTO `sku` VALUES ('3', '10', '三星 UA65JU5900', '三星', '8532', '6799', '/images/SanXin.jpg', 'images/sku_detail_img/sku_detail1.jpg');
INSERT INTO `sku` VALUES ('4', '10', '三星 UA48JU5900CXXZ', '三星', '7000', '4749', '/images/SanXin.jpg', 'images/sku_detail_img/sku_detail1.jpg');
INSERT INTO `sku` VALUES ('6', '1', ' 水洗条纹圆领T恤(长袖)', '夏季港风新款潮男短袖T恤青少年韩版修身拼色打底衫圆领简约小衫', '699', '299', '/images/sku_detail_img/sku_detail_6_1.jpg', 'images/sku_detail_img/sku_detail1.jpg');
INSERT INTO `sku` VALUES ('9', '9', 'iphone6s plus 64G', '【苏宁直发】Apple/苹果 iPhone6s 64G 全网通4G智能手机国行', '8999', '6999', '/images/sku_detail_img/sku_detail_9_1.jpg', 'images/sku_detail_img/sku_detail9.jpg');
INSERT INTO `sku` VALUES ('10', '2', '小米note4', '小米红米Note4手机 银色 标准版全网通4G(2GRAM+16G ROM)标配', '1199', '1199', '/images/sku_img/xiaomi_note4.jpg', '/images/sku_img/xiaomi_note_detail.jpg');
INSERT INTO `sku` VALUES ('11', '3', '小米note', '小米 Note 全网通 白色 移动联通电信4G手机 双卡双待', '999', '999', '/images/sku_img/xiaomi_note.jpg', '/images/sku_img/xiaomi_note_detail.jpg');
INSERT INTO `sku` VALUES ('12', '4', '红米3S', '小米红米3S移动联通电信4G手机双卡双待 金色 全网通版(2G RAM+16G ROM)', '719', '719', '/images/sku_img/hongmi_3S.jpg', '/images/sku_img/hongmi_3S_detail.jpg');
INSERT INTO `sku` VALUES ('13', '5', '海尔（Haier） XQB55-M1269', '海尔（Haier） XQB55-M1269 5.5公斤全自动波轮洗衣机', '1200', '799', '/images/sku_img/Haier(XQB55-M1269).jpg', '/images/sku_img/Haier(XQB55-M1269)_detail.jpg');
INSERT INTO `sku` VALUES ('14', '6', '海尔（Haier）EG7012B29W', '海尔（Haier）EG7012B29W 7公斤 变频滚筒洗衣机 防霉抗菌窗垫 3年质保', '1999', '1699', '/images/sku_img/Haier(EG7012B29W).jpg', '/images/sku_img/Haier(EG7012B29W)_detail.jpg');
INSERT INTO `sku` VALUES ('15', '7', '西门子 XQG70-WM10N0600W', '西门子(SIEMENS) XQG70-WM10N0600W 7公斤 变频 滚筒洗衣机 ', '2899', '2748', '/images/sku_img/SIEMENS(XQG70-WM10N0600W).jpg', '/images/sku_img/SIEMENS(XQG70-WM10N0600W)_detail.jpg');
INSERT INTO `sku` VALUES ('16', '8', '西门子 WM10N0R80W', '西门子(SIEMENS)WM10N0R80W 7公斤变频大容量滚筒洗衣机(银色)', '3500', '3199', '/images/sku_img/SIEMENS(XQG70-WM10N0600W).jpg', '/images/sku_img/SIEMENS(XQG70-WM10N0600W)_detail.jpg');
INSERT INTO `sku` VALUES ('17', '19', '华为 M2 平板电脑', '华为（HUAWEI） M2 平板电脑 10.1英寸（八核 海思麒麟930 3G/16G WiFi）月光', '2599', '2288', '/images/sku_img/huawei_M2.jpg', '/images/sku_img/huawei_M2_detail.jpg');
INSERT INTO `sku` VALUES ('18', '20', '微软（Microsoft）Surface Pro 4 平板电脑', '微软（Microsoft）Surface Pro 4 平板电脑 12.3英寸（Intel Core M 4G内存 128G', '6230', '5988', '/images/sku_img/weiruanPro4.jpg', '/images/sku_img/weiruanPro4_detail.jpg');

-- ----------------------------
-- Records of sku_pic
-- ----------------------------
INSERT INTO `sku_pic` VALUES ('1', '9', 'images/sku_detail_img/sku_detail_9_1.jpg');
INSERT INTO `sku_pic` VALUES ('2', '9', 'images/sku_detail_img/sku_detail_9_2.jpg');
INSERT INTO `sku_pic` VALUES ('3', '9', 'images/sku_detail_img/sku_detail_9_3.jpg');
INSERT INTO `sku_pic` VALUES ('4', '6', 'images/sku_detail_img/sku_detail_6_1.jpg');
INSERT INTO `sku_pic` VALUES ('5', '6', 'images/sku_detail_img/sku_detail_6_2.jpg');
INSERT INTO `sku_pic` VALUES ('6', '6', 'images/sku_detail_img/sku_detail_6_3.jpg');


-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '1', '249', '9997');
INSERT INTO `stock` VALUES ('2', '6', '82', '10000');
INSERT INTO `stock` VALUES ('3', '7', '46', '10000');
INSERT INTO `stock` VALUES ('4', '3', '5', '10000');
INSERT INTO `stock` VALUES ('5', '9', '43', '10000');
INSERT INTO `stock` VALUES ('6', '3', '5', '10000');
INSERT INTO `stock` VALUES ('7', '4', '13', '10000');
INSERT INTO `stock` VALUES ('8', '8', '1', '10000');

-- ----------------------------
-- Records of tb_order_address
-- ----------------------------
INSERT INTO `tb_order_address` VALUES ('1', '606547505907240960', 'zhangyi3', '13881795255', '13881795255', '河北省', '秦皇岛市', '山海关区', '四川省天府软件园');
INSERT INTO `tb_order_address` VALUES ('2', '606543563022405632', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('7', '606549461191102464', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('8', '606549461191102464', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('9', '606549461191102464', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('10', '606549461191102464', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('11', '606549461191102464', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('12', '606556746688761856', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('13', '606556746688761856', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('14', '606556746688761856', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('15', '606556746688761856', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('16', '606556746688761856', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('17', '606557302496956416', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('21', '606564608081137664', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('22', '606567965470494720', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('28', '606568553037959168', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('32', '606571613101494272', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('34', '606571613101494272', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('35', '606573022127591424', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('36', '606547702435549184', '张毅', '13881795255', '13881795255', '四川省', '成都市', '龙泉驿区', '四川省天府软件园A8');
INSERT INTO `tb_order_address` VALUES ('40', '606573076871647232', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('41', '606614037236551680', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('42', '606615320509026304', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('43', '606618280014123008', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('44', '606621072594309120', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('45', '606621177481269248', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('46', '606621453932040192', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('47', '606622143655972864', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');
INSERT INTO `tb_order_address` VALUES ('48', '606622800551088128', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼');


-- ----------------------------
-- Records of tb_order_detail
-- ----------------------------
INSERT INTO `tb_order_detail` VALUES ('1', '606547505907240960', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('3', '606543563022405632', '9', '9', 'iphone6s plus 64G', '8999.00', '6999.00', '1', '6999.00', null);
INSERT INTO `tb_order_detail` VALUES ('4', '606543563022405632', '9', '9', 'iphone6s plus 64G', '8999.00', '6999.00', '1', '6999.00', null);
INSERT INTO `tb_order_detail` VALUES ('5', '606549461191102464', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('6', '606556746688761856', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('7', '606557302496956416', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('8', '606557302496956416', '9', '9', 'iphone6s plus 64G', '8999.00', '6999.00', '1', '6999.00', null);
INSERT INTO `tb_order_detail` VALUES ('9', '606564608081137664', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('10', '606564608081137664', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('11', '606567965470494720', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('17', '606568553037959168', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('18', '606571613101494272', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('19', '606573022127591424', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('20', '606547702435549184', '9', '9', 'iphone6s plus 64G', '8999.00', '6999.00', '1', '6999.00', null);
INSERT INTO `tb_order_detail` VALUES ('22', '606573076871647232', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('23', '606614037236551680', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('24', '606615320509026304', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('25', '606618280014123008', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('26', '606618280014123008', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('27', '606621072594309120', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('28', '606621177481269248', '9', '9', 'iphone6s plus 64G', '8999.00', '6999.00', '1', '6999.00', null);
INSERT INTO `tb_order_detail` VALUES ('29', '606621453932040192', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('30', '606621453932040192', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('31', '606621453932040192', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('32', '606621453932040192', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('33', '606622143655972864', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);
INSERT INTO `tb_order_detail` VALUES ('34', '606622800551088128', '9', '1', 'iPhone 6s', '6788.00', '4788.00', '1', '4788.00', null);


-- ----------------------------
-- Records of tb_order_master
-- ----------------------------
INSERT INTO `tb_order_master` VALUES ('1', '606543563022405632', '13998.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 09:22:43', null);
INSERT INTO `tb_order_master` VALUES ('2', '606547505907240960', '4788.00', '0.00', '02', '0', '5', 'zhangyi', '2016-09-27 09:38:23', null);
INSERT INTO `tb_order_master` VALUES ('3', '606547702435549184', '6999.00', '0.00', '02', '0', '5', 'zhangyi', '2016-09-27 09:39:10', null);
INSERT INTO `tb_order_master` VALUES ('4', '606549461191102464', '4788.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 09:46:09', null);
INSERT INTO `tb_order_master` VALUES ('5', '606556746688761856', '4788.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 10:15:06', null);
INSERT INTO `tb_order_master` VALUES ('6', '606557302496956416', '11787.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 10:17:19', null);
INSERT INTO `tb_order_master` VALUES ('7', '606564608081137664', '9576.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 10:46:21', null);
INSERT INTO `tb_order_master` VALUES ('8', '606567965470494720', '4788.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 10:59:41', null);
INSERT INTO `tb_order_master` VALUES ('9', '606568553037959168', '4788.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 11:02:01', null);
INSERT INTO `tb_order_master` VALUES ('10', '606571613101494272', '4788.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 11:14:11', null);
INSERT INTO `tb_order_master` VALUES ('11', '606573022127591424', '4788.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 11:19:47', null);
INSERT INTO `tb_order_master` VALUES ('12', '606573076871647232', '4788.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 11:20:00', null);
INSERT INTO `tb_order_master` VALUES ('13', '606580354316242944', null, null, '-1', '0', null, 'zhangyi', '2016-09-27 11:48:55', null);
INSERT INTO `tb_order_master` VALUES ('14', '606614037236551680', '4788.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 14:02:45', null);
INSERT INTO `tb_order_master` VALUES ('15', '606615320509026304', '4788.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 14:07:51', null);
INSERT INTO `tb_order_master` VALUES ('16', '606618280014123008', '9576.00', '0.00', '01', '0', '1', 'admin', '2016-09-27 14:19:37', null);
INSERT INTO `tb_order_master` VALUES ('17', '606621072594309120', '4788.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 14:30:43', null);
INSERT INTO `tb_order_master` VALUES ('18', '606621177481269248', '6999.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 14:31:08', null);
INSERT INTO `tb_order_master` VALUES ('19', '606621453932040192', '19152.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 14:32:14', null);
INSERT INTO `tb_order_master` VALUES ('21', '606622143655972864', '4788.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 14:34:58', null);
INSERT INTO `tb_order_master` VALUES ('22', '606622800551088128', '4788.00', '0.00', '02', '0', '1', 'admin', '2016-09-27 14:37:35', null);
INSERT INTO `tb_order_master` VALUES ('23', '606623440333443072', null, null, '-1', '0', null, 'admin', '2016-09-27 14:40:07', null);


-- ----------------------------
-- Records of tb_user_address
-- ----------------------------
INSERT INTO `tb_user_address` VALUES ('1', '5', '菲儿', '1111', '7654', '四川省', '成都市', '武侯区', '软件园A8F7楼', '0', '610000');
INSERT INTO `tb_user_address` VALUES ('2', '7', '王尼玛', '13567565678', '', '四川省', '成都市', '双流县', '华阳镇华府达到一段88号', null, null);
INSERT INTO `tb_user_address` VALUES ('3', '7', '王尼玛', '13567565678', '', '四川省', '成都市', '双流县', '华阳镇华府达到一段88号', null, null);
INSERT INTO `tb_user_address` VALUES ('4', '15', '王蜜桃', '13567676567', '', '四川省', '成都市', '双流县', '公兴镇公新大道88号付5号', null, null);
INSERT INTO `tb_user_address` VALUES ('5', '16', '张毅', '13881795255', '13881795255', '四川省', '成都市', '龙泉驿区', '四川省天府软件园A8', null, null);

-- ----------------------------
-- Records of wallet
-- ----------------------------
INSERT INTO `wallet` VALUES ('1', '1', '11111111', '2016-05-25 14:15:23', '2016-05-30 14:15:28', '2016-05-30 14:15:18', '11', '111');
INSERT INTO `wallet` VALUES ('2', '2', null, '2016-05-30 14:50:29', '2016-05-30 14:50:32', '2016-05-30 14:50:36', null, null);
INSERT INTO `wallet` VALUES ('3', '3', null, '2016-05-30 14:50:43', '2016-05-30 14:50:41', '2016-05-30 14:50:39', null, null);
INSERT INTO `wallet` VALUES ('4', '4', null, '2016-05-30 14:51:03', '2016-05-30 14:51:20', '2016-05-30 14:51:40', null, null);
INSERT INTO `wallet` VALUES ('5', '5', null, '2016-05-30 14:51:00', '2016-05-30 14:51:22', '2016-05-30 14:51:37', null, null);
INSERT INTO `wallet` VALUES ('6', '6', null, '2016-05-30 14:50:58', '2016-05-30 14:51:17', '2016-05-30 14:51:35', null, null);
INSERT INTO `wallet` VALUES ('7', '7', null, '2016-05-30 14:50:55', '2016-05-30 14:51:15', '2016-05-30 14:51:33', null, null);
INSERT INTO `wallet` VALUES ('8', '8', null, '2016-05-30 14:50:53', '2016-05-30 14:51:13', '2016-05-30 14:51:31', null, null);
INSERT INTO `wallet` VALUES ('9', '9', null, '2016-05-30 14:50:50', '2016-05-30 14:51:11', '2016-05-30 14:51:29', null, null);
INSERT INTO `wallet` VALUES ('10', '10', null, '2016-05-30 14:50:48', '2016-05-30 14:51:08', '2016-05-30 14:51:26', null, null);
INSERT INTO `wallet` VALUES ('11', '11', null, '2016-05-30 14:50:46', '2016-05-30 14:51:06', '2016-05-30 14:51:24', null, null);
