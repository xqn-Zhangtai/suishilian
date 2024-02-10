/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : suishilian

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/02/2024 22:22:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '计算机科学与技术');
INSERT INTO `class` VALUES (2, '信息技术');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(0) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (2);

-- ----------------------------
-- Table structure for option
-- ----------------------------
DROP TABLE IF EXISTS `option`;
CREATE TABLE `option`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `question_id` int(0) NULL DEFAULT NULL,
  `label` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  CONSTRAINT `option_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 433 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of option
-- ----------------------------
INSERT INTO `option` VALUES (1, 4, 'A', '数据');
INSERT INTO `option` VALUES (2, 4, 'B', '信息');
INSERT INTO `option` VALUES (3, 4, 'C', '资产');
INSERT INTO `option` VALUES (4, 4, 'D', '文本');
INSERT INTO `option` VALUES (5, 5, 'A', '时效性');
INSERT INTO `option` VALUES (6, 5, 'B', '等级性');
INSERT INTO `option` VALUES (7, 5, 'C', '价值性');
INSERT INTO `option` VALUES (8, 5, 'D', '交换性');
INSERT INTO `option` VALUES (9, 6, 'A', '文教数据');
INSERT INTO `option` VALUES (10, 6, 'B', '经济数据');
INSERT INTO `option` VALUES (11, 6, 'C', '科技数据');
INSERT INTO `option` VALUES (12, 6, 'D', '军事数据');
INSERT INTO `option` VALUES (13, 7, 'A', '零次文献数据');
INSERT INTO `option` VALUES (14, 7, 'B', '一次文献数据');
INSERT INTO `option` VALUES (15, 7, 'C', '二次文献数据');
INSERT INTO `option` VALUES (16, 7, 'D', '三次文献数据');
INSERT INTO `option` VALUES (17, 8, 'A', '信息≥数据≥知识≥智慧');
INSERT INTO `option` VALUES (18, 8, 'B', '数据≥信息≥知识≥智慧');
INSERT INTO `option` VALUES (19, 8, 'C', '数据≤信息≤知识≤智慧');
INSERT INTO `option` VALUES (20, 8, 'D', '数据≥智慧≥知识≥信息');
INSERT INTO `option` VALUES (21, 9, 'A', '学生简历');
INSERT INTO `option` VALUES (22, 9, 'B', '学生姓名');
INSERT INTO `option` VALUES (23, 9, 'C', '学生学号');
INSERT INTO `option` VALUES (24, 9, 'D', '学生性别');
INSERT INTO `option` VALUES (25, 10, 'A', '科学性');
INSERT INTO `option` VALUES (26, 10, 'B', '安全性');
INSERT INTO `option` VALUES (27, 10, 'C', '系统性');
INSERT INTO `option` VALUES (28, 10, 'D', '兼容性');
INSERT INTO `option` VALUES (29, 11, 'A', '相同级别');
INSERT INTO `option` VALUES (30, 11, 'B', '不同级别');
INSERT INTO `option` VALUES (31, 11, 'C', '最高级别');
INSERT INTO `option` VALUES (32, 11, 'D', '最低级别');
INSERT INTO `option` VALUES (33, 12, 'A', '较大范围');
INSERT INTO `option` VALUES (34, 12, 'B', '较小范围');
INSERT INTO `option` VALUES (35, 12, 'C', '一般范围');
INSERT INTO `option` VALUES (36, 12, 'D', '弱小范围');
INSERT INTO `option` VALUES (37, 13, 'A', '要求');
INSERT INTO `option` VALUES (38, 13, 'B', '要求的程度');
INSERT INTO `option` VALUES (39, 13, 'C', '程度');
INSERT INTO `option` VALUES (40, 13, 'D', '用户要求');
INSERT INTO `option` VALUES (41, 14, 'A', '完整性');
INSERT INTO `option` VALUES (42, 14, 'B', '及时性');
INSERT INTO `option` VALUES (43, 14, 'C', '准确性');
INSERT INTO `option` VALUES (44, 14, 'D', '一致性');
INSERT INTO `option` VALUES (45, 15, 'A', '一致性');
INSERT INTO `option` VALUES (46, 15, 'B', '及时性');
INSERT INTO `option` VALUES (47, 15, 'C', '准确性');
INSERT INTO `option` VALUES (48, 15, 'D', '完整性');
INSERT INTO `option` VALUES (49, 16, 'A', '一致性');
INSERT INTO `option` VALUES (50, 16, 'B', '及时性');
INSERT INTO `option` VALUES (51, 16, 'C', '准确性');
INSERT INTO `option` VALUES (52, 16, 'D', '完整性');
INSERT INTO `option` VALUES (53, 17, 'A', '有效性');
INSERT INTO `option` VALUES (54, 17, 'B', '及时性');
INSERT INTO `option` VALUES (55, 17, 'C', '准确性');
INSERT INTO `option` VALUES (56, 17, 'D', '完整性');
INSERT INTO `option` VALUES (57, 18, 'A', '首要阶段');
INSERT INTO `option` VALUES (58, 18, 'B', '第二阶段');
INSERT INTO `option` VALUES (59, 18, 'C', '第三阶段');
INSERT INTO `option` VALUES (60, 18, 'D', '最末阶段');
INSERT INTO `option` VALUES (61, 19, 'A', '政府组织数据');
INSERT INTO `option` VALUES (62, 19, 'B', '事业单位数据');
INSERT INTO `option` VALUES (63, 19, 'C', '商业型组织数据');
INSERT INTO `option` VALUES (64, 19, 'D', '非营利型数据');
INSERT INTO `option` VALUES (65, 20, 'A', '组织数据');
INSERT INTO `option` VALUES (66, 20, 'B', '实体数据');
INSERT INTO `option` VALUES (67, 20, 'C', '个人数据');
INSERT INTO `option` VALUES (68, 20, 'D', '网络数据');
INSERT INTO `option` VALUES (69, 21, 'A', 'OPC通信法');
INSERT INTO `option` VALUES (70, 21, 'B', '网络爬虫法');
INSERT INTO `option` VALUES (71, 21, 'C', '程序接口法');
INSERT INTO `option` VALUES (72, 21, 'D', '现场采集法');
INSERT INTO `option` VALUES (73, 22, 'A', 'RFID芯片');
INSERT INTO `option` VALUES (74, 22, 'B', '一维码');
INSERT INTO `option` VALUES (75, 22, 'C', '二维码');
INSERT INTO `option` VALUES (76, 22, 'D', '条形码');
INSERT INTO `option` VALUES (77, 23, 'A', '加密');
INSERT INTO `option` VALUES (78, 23, 'B', '解密');
INSERT INTO `option` VALUES (79, 23, 'C', '密钥');
INSERT INTO `option` VALUES (80, 23, 'D', '协议');
INSERT INTO `option` VALUES (81, 24, 'A', '核心密码');
INSERT INTO `option` VALUES (82, 24, 'B', '普通密码');
INSERT INTO `option` VALUES (83, 24, 'C', '商用密码');
INSERT INTO `option` VALUES (84, 24, 'D', '基础密码');
INSERT INTO `option` VALUES (85, 25, 'A', '商用密码');
INSERT INTO `option` VALUES (86, 25, 'B', '密码算法');
INSERT INTO `option` VALUES (87, 25, 'C', '密钥管理');
INSERT INTO `option` VALUES (88, 25, 'D', '密码协议');
INSERT INTO `option` VALUES (89, 26, 'A', 'DES');
INSERT INTO `option` VALUES (90, 26, 'B', 'AES');
INSERT INTO `option` VALUES (91, 26, 'C', 'SM2');
INSERT INTO `option` VALUES (92, 26, 'D', 'SM4');
INSERT INTO `option` VALUES (93, 27, 'A', '有效性原则');
INSERT INTO `option` VALUES (94, 27, 'B', '真实性原则');
INSERT INTO `option` VALUES (95, 27, 'C', '高效性原则');
INSERT INTO `option` VALUES (96, 27, 'D', '合规性原则');
INSERT INTO `option` VALUES (97, 28, 'A', '企业数据脱敏');
INSERT INTO `option` VALUES (98, 28, 'B', '个人数据脱敏');
INSERT INTO `option` VALUES (99, 28, 'C', '动态数据脱敏');
INSERT INTO `option` VALUES (100, 28, 'D', '静态数据脱敏');
INSERT INTO `option` VALUES (101, 29, 'A', '产业形态');
INSERT INTO `option` VALUES (102, 29, 'B', '产品形态');
INSERT INTO `option` VALUES (103, 29, 'C', '产品价值');
INSERT INTO `option` VALUES (104, 29, 'D', '数据类别');
INSERT INTO `option` VALUES (105, 30, 'A', '数据要素');
INSERT INTO `option` VALUES (106, 30, 'B', '法律要素');
INSERT INTO `option` VALUES (107, 30, 'C', '价值要素');
INSERT INTO `option` VALUES (108, 30, 'D', '业务要素');
INSERT INTO `option` VALUES (109, 31, 'A', '保值增值');
INSERT INTO `option` VALUES (110, 31, 'B', '安全应用');
INSERT INTO `option` VALUES (111, 31, 'C', '市场交易');
INSERT INTO `option` VALUES (112, 31, 'D', '资产变更');
INSERT INTO `option` VALUES (113, 32, 'A', '零次数据资产');
INSERT INTO `option` VALUES (114, 32, 'B', '一次数据资产');
INSERT INTO `option` VALUES (115, 32, 'C', '二次数据资产');
INSERT INTO `option` VALUES (116, 32, 'D', '三次数据资产');
INSERT INTO `option` VALUES (117, 33, 'A', '数据定义语言(DDL)');
INSERT INTO `option` VALUES (118, 33, 'B', '数据操作语言(DML)');
INSERT INTO `option` VALUES (119, 33, 'C', '数据控制语言(DCL)');
INSERT INTO `option` VALUES (120, 33, 'D', '数据程序语言(DPL)');
INSERT INTO `option` VALUES (121, 34, 'A', '数据');
INSERT INTO `option` VALUES (122, 34, 'B', '数据安全');
INSERT INTO `option` VALUES (123, 34, 'C', '数据治理');
INSERT INTO `option` VALUES (124, 34, 'D', '数据安全治理');
INSERT INTO `option` VALUES (125, 35, 'A', '绝密级');
INSERT INTO `option` VALUES (126, 35, 'B', '机密级');
INSERT INTO `option` VALUES (127, 35, 'C', '秘密级');
INSERT INTO `option` VALUES (128, 35, 'D', '内部级');
INSERT INTO `option` VALUES (129, 36, 'A', '零次文献数据');
INSERT INTO `option` VALUES (130, 36, 'B', '一次文献数据');
INSERT INTO `option` VALUES (131, 36, 'C', '二次文献数据');
INSERT INTO `option` VALUES (132, 36, 'D', '三次文献级据');
INSERT INTO `option` VALUES (133, 37, 'A', '安全保护');
INSERT INTO `option` VALUES (134, 37, 'B', '有效保护');
INSERT INTO `option` VALUES (135, 37, 'C', '合规使用');
INSERT INTO `option` VALUES (136, 37, 'D', '综合利用');
INSERT INTO `option` VALUES (137, 38, 'A', '数据采集');
INSERT INTO `option` VALUES (138, 38, 'B', '数据处理');
INSERT INTO `option` VALUES (139, 38, 'C', '数据交换');
INSERT INTO `option` VALUES (140, 38, 'D', '数据销毁');
INSERT INTO `option` VALUES (141, 39, 'A', '数据采集');
INSERT INTO `option` VALUES (142, 39, 'B', '通用安全');
INSERT INTO `option` VALUES (143, 39, 'C', '数据交换');
INSERT INTO `option` VALUES (144, 39, 'D', '数据销毁');
INSERT INTO `option` VALUES (145, 40, 'A', '数据有效保护');
INSERT INTO `option` VALUES (146, 40, 'B', '数据合法利用');
INSERT INTO `option` VALUES (147, 40, 'C', '数据安全应用');
INSERT INTO `option` VALUES (148, 40, 'D', '数据综合利用');
INSERT INTO `option` VALUES (149, 41, 'A', '科学性');
INSERT INTO `option` VALUES (150, 41, 'B', '系统性');
INSERT INTO `option` VALUES (151, 41, 'C', '兼容性');
INSERT INTO `option` VALUES (152, 41, 'D', '可扩展性');
INSERT INTO `option` VALUES (153, 42, 'A', '线分类法');
INSERT INTO `option` VALUES (154, 42, 'B', '树分类法');
INSERT INTO `option` VALUES (155, 42, 'C', '面分类法');
INSERT INTO `option` VALUES (156, 42, 'D', '层分类法');
INSERT INTO `option` VALUES (157, 43, 'A', '数据重要程度');
INSERT INTO `option` VALUES (158, 43, 'B', '数据敏感程度');
INSERT INTO `option` VALUES (159, 43, 'C', '数据泄露造成的风险程度');
INSERT INTO `option` VALUES (160, 43, 'D', '数据安全程度');
INSERT INTO `option` VALUES (161, 44, 'A', '明确的');
INSERT INTO `option` VALUES (162, 44, 'B', '公开的');
INSERT INTO `option` VALUES (163, 44, 'C', '秘密的');
INSERT INTO `option` VALUES (164, 44, 'D', '隐含的');
INSERT INTO `option` VALUES (165, 45, 'A', '技术方面');
INSERT INTO `option` VALUES (166, 45, 'B', '业务方面');
INSERT INTO `option` VALUES (167, 45, 'C', '管理方面');
INSERT INTO `option` VALUES (168, 45, 'D', '标准方面');
INSERT INTO `option` VALUES (169, 46, 'A', '比率法');
INSERT INTO `option` VALUES (170, 46, 'B', '最小值法');
INSERT INTO `option` VALUES (171, 46, 'C', '最大值法');
INSERT INTO `option` VALUES (172, 46, 'D', '加权平均法');
INSERT INTO `option` VALUES (173, 47, 'A', '采集');
INSERT INTO `option` VALUES (174, 47, 'B', '抽取');
INSERT INTO `option` VALUES (175, 47, 'C', '转换');
INSERT INTO `option` VALUES (176, 47, 'D', '装载');
INSERT INTO `option` VALUES (177, 48, 'A', '离线模式');
INSERT INTO `option` VALUES (178, 48, 'B', '人工模式');
INSERT INTO `option` VALUES (179, 48, 'C', '在线模式');
INSERT INTO `option` VALUES (180, 48, 'D', '智能模式');
INSERT INTO `option` VALUES (181, 49, 'A', '机械采集技术');
INSERT INTO `option` VALUES (182, 49, 'B', '人工采集技术');
INSERT INTO `option` VALUES (183, 49, 'C', '半人工采集技术');
INSERT INTO `option` VALUES (184, 49, 'D', '自动采集技术');
INSERT INTO `option` VALUES (185, 50, 'A', '个人工作信息');
INSERT INTO `option` VALUES (186, 50, 'B', '个人生物识别信息');
INSERT INTO `option` VALUES (187, 50, 'C', '个人网络标识信息');
INSERT INTO `option` VALUES (188, 50, 'D', '个人身体信息');
INSERT INTO `option` VALUES (189, 51, 'A', '权威性');
INSERT INTO `option` VALUES (190, 51, 'B', '普适性');
INSERT INTO `option` VALUES (191, 51, 'C', '安全性');
INSERT INTO `option` VALUES (192, 51, 'D', '垄断性');
INSERT INTO `option` VALUES (193, 52, 'A', '感知设备法');
INSERT INTO `option` VALUES (194, 52, 'B', '网络爬虫法');
INSERT INTO `option` VALUES (195, 52, 'C', 'OPC通信法');
INSERT INTO `option` VALUES (196, 52, 'D', '程序接口法');
INSERT INTO `option` VALUES (197, 53, 'A', 'PLC');
INSERT INTO `option` VALUES (198, 53, 'B', 'DNC');
INSERT INTO `option` VALUES (199, 53, 'C', 'DCS');
INSERT INTO `option` VALUES (200, 53, 'D', 'SCADA');
INSERT INTO `option` VALUES (201, 54, 'A', '定性评价法');
INSERT INTO `option` VALUES (202, 54, 'B', '定量评价法');
INSERT INTO `option` VALUES (203, 54, 'C', '现场评价法');
INSERT INTO `option` VALUES (204, 54, 'D', '问卷评价法');
INSERT INTO `option` VALUES (205, 55, 'A', '车载摄像头');
INSERT INTO `option` VALUES (206, 55, 'B', '红外传感器');
INSERT INTO `option` VALUES (207, 55, 'C', '车速传感器');
INSERT INTO `option` VALUES (208, 55, 'D', 'PM2.5传感器');
INSERT INTO `option` VALUES (209, 56, 'A', '学术定义');
INSERT INTO `option` VALUES (210, 56, 'B', '工程定义');
INSERT INTO `option` VALUES (211, 56, 'C', '法律定义');
INSERT INTO `option` VALUES (212, 56, 'D', '数学定义');
INSERT INTO `option` VALUES (213, 57, 'A', '加密保护的物项');
INSERT INTO `option` VALUES (214, 57, 'B', '加密保护的技术');
INSERT INTO `option` VALUES (215, 57, 'C', '安全认证的物项');
INSERT INTO `option` VALUES (216, 57, 'D', '安全认证的技术');
INSERT INTO `option` VALUES (217, 58, 'A', '加密保护技术');
INSERT INTO `option` VALUES (218, 58, 'B', '安全认证技术');
INSERT INTO `option` VALUES (219, 58, 'C', '加密技术');
INSERT INTO `option` VALUES (220, 58, 'D', '解密技术');
INSERT INTO `option` VALUES (221, 59, 'A', '核心密码');
INSERT INTO `option` VALUES (222, 59, 'B', '普通密码');
INSERT INTO `option` VALUES (223, 59, 'C', '商用密码');
INSERT INTO `option` VALUES (224, 59, 'D', '基础密码');
INSERT INTO `option` VALUES (225, 60, 'A', 'RSA');
INSERT INTO `option` VALUES (226, 60, 'B', 'SM9');
INSERT INTO `option` VALUES (227, 60, 'C', 'SM2');
INSERT INTO `option` VALUES (228, 60, 'D', 'SM4');
INSERT INTO `option` VALUES (229, 61, 'A', 'SM2');
INSERT INTO `option` VALUES (230, 61, 'B', 'SM3');
INSERT INTO `option` VALUES (231, 61, 'C', 'SM4');
INSERT INTO `option` VALUES (232, 61, 'D', 'SM9');
INSERT INTO `option` VALUES (233, 62, 'A', '需求调研数据');
INSERT INTO `option` VALUES (234, 62, 'B', '识别敏感数据');
INSERT INTO `option` VALUES (235, 62, 'C', '脱掉敏感数据');
INSERT INTO `option` VALUES (236, 62, 'D', '评价脱敏效果');
INSERT INTO `option` VALUES (237, 63, 'A', '图像数据脱敏');
INSERT INTO `option` VALUES (238, 63, 'B', '视频数据脱敏');
INSERT INTO `option` VALUES (239, 63, 'C', '非结构化文本脱敏');
INSERT INTO `option` VALUES (240, 63, 'D', '个人隐私脱敏');
INSERT INTO `option` VALUES (241, 64, 'A', '甲骨文');
INSERT INTO `option` VALUES (242, 64, 'B', '达梦');
INSERT INTO `option` VALUES (243, 64, 'C', 'My SQL');
INSERT INTO `option` VALUES (244, 64, 'D', '人大金仓');
INSERT INTO `option` VALUES (245, 65, 'A', '源程序代码');
INSERT INTO `option` VALUES (246, 65, 'B', 'API接口');
INSERT INTO `option` VALUES (247, 65, 'C', '数据表格');
INSERT INTO `option` VALUES (248, 65, 'D', '消息队列');
INSERT INTO `option` VALUES (249, 66, 'A', '企业资产');
INSERT INTO `option` VALUES (250, 66, 'B', '个人资产');
INSERT INTO `option` VALUES (251, 66, 'C', '有形资产');
INSERT INTO `option` VALUES (252, 66, 'D', '无形资产');
INSERT INTO `option` VALUES (253, 67, 'A', '结构化数据资产');
INSERT INTO `option` VALUES (254, 67, 'B', '无结构化数据资产');
INSERT INTO `option` VALUES (255, 67, 'C', '非结构化数据资产');
INSERT INTO `option` VALUES (256, 67, 'D', '半结构化数据资产');
INSERT INTO `option` VALUES (257, 68, 'A', '增值性');
INSERT INTO `option` VALUES (258, 68, 'B', '共享性');
INSERT INTO `option` VALUES (259, 68, 'C', '计量性');
INSERT INTO `option` VALUES (260, 68, 'D', '依托性');
INSERT INTO `option` VALUES (261, 69, 'A', '权责分明原则');
INSERT INTO `option` VALUES (262, 69, 'B', '价值导向原则');
INSERT INTO `option` VALUES (263, 69, 'C', '成本效益原则');
INSERT INTO `option` VALUES (264, 69, 'D', '安全合规原则');
INSERT INTO `option` VALUES (265, 70, 'A', '使用方');
INSERT INTO `option` VALUES (266, 70, 'B', '第三方存证');
INSERT INTO `option` VALUES (267, 70, 'C', '公证存证');
INSERT INTO `option` VALUES (268, 70, 'D', '自行存证');
INSERT INTO `option` VALUES (269, 71, 'A', '数据供给方');
INSERT INTO `option` VALUES (270, 71, 'B', '数据需求方');
INSERT INTO `option` VALUES (271, 71, 'C', '数据产品');
INSERT INTO `option` VALUES (272, 71, 'D', '数据交易平台');
INSERT INTO `option` VALUES (273, 72, 'A', '事前');
INSERT INTO `option` VALUES (274, 72, 'B', '事中');
INSERT INTO `option` VALUES (275, 72, 'C', '事后');
INSERT INTO `option` VALUES (276, 72, 'D', '过程');
INSERT INTO `option` VALUES (277, 73, 'A', '数据');
INSERT INTO `option` VALUES (278, 73, 'B', '数据安全');
INSERT INTO `option` VALUES (279, 73, 'C', '数据治理');
INSERT INTO `option` VALUES (280, 73, 'D', '数据安全治理');
INSERT INTO `option` VALUES (281, 74, 'A', '绝密级');
INSERT INTO `option` VALUES (282, 74, 'B', '机密级');
INSERT INTO `option` VALUES (283, 74, 'C', '秘密级');
INSERT INTO `option` VALUES (284, 74, 'D', '内部级');
INSERT INTO `option` VALUES (285, 75, 'A', '零次文献数据');
INSERT INTO `option` VALUES (286, 75, 'B', '一次文献数据');
INSERT INTO `option` VALUES (287, 75, 'C', '二次文献数据');
INSERT INTO `option` VALUES (288, 75, 'D', '三次文献级据');
INSERT INTO `option` VALUES (289, 76, 'A', '安全保护');
INSERT INTO `option` VALUES (290, 76, 'B', '有效保护');
INSERT INTO `option` VALUES (291, 76, 'C', '合规使用');
INSERT INTO `option` VALUES (292, 76, 'D', '综合利用');
INSERT INTO `option` VALUES (293, 77, 'A', '数据采集');
INSERT INTO `option` VALUES (294, 77, 'B', '数据处理');
INSERT INTO `option` VALUES (295, 77, 'C', '数据交换');
INSERT INTO `option` VALUES (296, 77, 'D', '数据销毁');
INSERT INTO `option` VALUES (297, 78, 'A', '数据采集');
INSERT INTO `option` VALUES (298, 78, 'B', '通用安全');
INSERT INTO `option` VALUES (299, 78, 'C', '数据交换');
INSERT INTO `option` VALUES (300, 78, 'D', '数据销毁');
INSERT INTO `option` VALUES (301, 79, 'A', '数据有效保护');
INSERT INTO `option` VALUES (302, 79, 'B', '数据合法利用');
INSERT INTO `option` VALUES (303, 79, 'C', '数据安全应用');
INSERT INTO `option` VALUES (304, 79, 'D', '数据综合利用');
INSERT INTO `option` VALUES (305, 80, 'A', '科学性');
INSERT INTO `option` VALUES (306, 80, 'B', '系统性');
INSERT INTO `option` VALUES (307, 80, 'C', '兼容性');
INSERT INTO `option` VALUES (308, 80, 'D', '可扩展性');
INSERT INTO `option` VALUES (309, 81, 'A', '线分类法');
INSERT INTO `option` VALUES (310, 81, 'B', '树分类法');
INSERT INTO `option` VALUES (311, 81, 'C', '面分类法');
INSERT INTO `option` VALUES (312, 81, 'D', '层分类法');
INSERT INTO `option` VALUES (313, 82, 'A', '数据重要程度');
INSERT INTO `option` VALUES (314, 82, 'B', '数据敏感程度');
INSERT INTO `option` VALUES (315, 82, 'C', '数据泄露造成的风险程度');
INSERT INTO `option` VALUES (316, 82, 'D', '数据安全程度');
INSERT INTO `option` VALUES (317, 83, 'A', '明确的');
INSERT INTO `option` VALUES (318, 83, 'B', '公开的');
INSERT INTO `option` VALUES (319, 83, 'C', '秘密的');
INSERT INTO `option` VALUES (320, 83, 'D', '隐含的');
INSERT INTO `option` VALUES (321, 84, 'A', '技术方面');
INSERT INTO `option` VALUES (322, 84, 'B', '业务方面');
INSERT INTO `option` VALUES (323, 84, 'C', '管理方面');
INSERT INTO `option` VALUES (324, 84, 'D', '标准方面');
INSERT INTO `option` VALUES (325, 85, 'A', '比率法');
INSERT INTO `option` VALUES (326, 85, 'B', '最小值法');
INSERT INTO `option` VALUES (327, 85, 'C', '最大值法');
INSERT INTO `option` VALUES (328, 85, 'D', '加权平均法');
INSERT INTO `option` VALUES (329, 86, 'A', '采集');
INSERT INTO `option` VALUES (330, 86, 'B', '抽取');
INSERT INTO `option` VALUES (331, 86, 'C', '转换');
INSERT INTO `option` VALUES (332, 86, 'D', '装载');
INSERT INTO `option` VALUES (333, 87, 'A', '离线模式');
INSERT INTO `option` VALUES (334, 87, 'B', '人工模式');
INSERT INTO `option` VALUES (335, 87, 'C', '在线模式');
INSERT INTO `option` VALUES (336, 87, 'D', '智能模式');
INSERT INTO `option` VALUES (337, 88, 'A', '机械采集技术');
INSERT INTO `option` VALUES (338, 88, 'B', '人工采集技术');
INSERT INTO `option` VALUES (339, 88, 'C', '半人工采集技术');
INSERT INTO `option` VALUES (340, 88, 'D', '自动采集技术');
INSERT INTO `option` VALUES (341, 89, 'A', '个人工作信息');
INSERT INTO `option` VALUES (342, 89, 'B', '个人生物识别信息');
INSERT INTO `option` VALUES (343, 89, 'C', '个人网络标识信息');
INSERT INTO `option` VALUES (344, 89, 'D', '个人身体信息');
INSERT INTO `option` VALUES (345, 90, 'A', '权威性');
INSERT INTO `option` VALUES (346, 90, 'B', '普适性');
INSERT INTO `option` VALUES (347, 90, 'C', '安全性');
INSERT INTO `option` VALUES (348, 90, 'D', '垄断性');
INSERT INTO `option` VALUES (349, 91, 'A', '感知设备法');
INSERT INTO `option` VALUES (350, 91, 'B', '网络爬虫法');
INSERT INTO `option` VALUES (351, 91, 'C', 'OPC通信法');
INSERT INTO `option` VALUES (352, 91, 'D', '程序接口法');
INSERT INTO `option` VALUES (353, 92, 'A', 'PLC');
INSERT INTO `option` VALUES (354, 92, 'B', 'DNC');
INSERT INTO `option` VALUES (355, 92, 'C', 'DCS');
INSERT INTO `option` VALUES (356, 92, 'D', 'SCADA');
INSERT INTO `option` VALUES (357, 93, 'A', '定性评价法');
INSERT INTO `option` VALUES (358, 93, 'B', '定量评价法');
INSERT INTO `option` VALUES (359, 93, 'C', '现场评价法');
INSERT INTO `option` VALUES (360, 93, 'D', '问卷评价法');
INSERT INTO `option` VALUES (361, 94, 'A', '车载摄像头');
INSERT INTO `option` VALUES (362, 94, 'B', '红外传感器');
INSERT INTO `option` VALUES (363, 94, 'C', '车速传感器');
INSERT INTO `option` VALUES (364, 94, 'D', 'PM2.5传感器');
INSERT INTO `option` VALUES (365, 95, 'A', '学术定义');
INSERT INTO `option` VALUES (366, 95, 'B', '工程定义');
INSERT INTO `option` VALUES (367, 95, 'C', '法律定义');
INSERT INTO `option` VALUES (368, 95, 'D', '数学定义');
INSERT INTO `option` VALUES (369, 96, 'A', '加密保护的物项');
INSERT INTO `option` VALUES (370, 96, 'B', '加密保护的技术');
INSERT INTO `option` VALUES (371, 96, 'C', '安全认证的物项');
INSERT INTO `option` VALUES (372, 96, 'D', '安全认证的技术');
INSERT INTO `option` VALUES (373, 97, 'A', '加密保护技术');
INSERT INTO `option` VALUES (374, 97, 'B', '安全认证技术');
INSERT INTO `option` VALUES (375, 97, 'C', '加密技术');
INSERT INTO `option` VALUES (376, 97, 'D', '解密技术');
INSERT INTO `option` VALUES (377, 98, 'A', '核心密码');
INSERT INTO `option` VALUES (378, 98, 'B', '普通密码');
INSERT INTO `option` VALUES (379, 98, 'C', '商用密码');
INSERT INTO `option` VALUES (380, 98, 'D', '基础密码');
INSERT INTO `option` VALUES (381, 99, 'A', 'RSA');
INSERT INTO `option` VALUES (382, 99, 'B', 'SM9');
INSERT INTO `option` VALUES (383, 99, 'C', 'SM2');
INSERT INTO `option` VALUES (384, 99, 'D', 'SM4');
INSERT INTO `option` VALUES (385, 100, 'A', 'SM2');
INSERT INTO `option` VALUES (386, 100, 'B', 'SM3');
INSERT INTO `option` VALUES (387, 100, 'C', 'SM4');
INSERT INTO `option` VALUES (388, 100, 'D', 'SM9');
INSERT INTO `option` VALUES (389, 101, 'A', '需求调研数据');
INSERT INTO `option` VALUES (390, 101, 'B', '识别敏感数据');
INSERT INTO `option` VALUES (391, 101, 'C', '脱掉敏感数据');
INSERT INTO `option` VALUES (392, 101, 'D', '评价脱敏效果');
INSERT INTO `option` VALUES (393, 102, 'A', '图像数据脱敏');
INSERT INTO `option` VALUES (394, 102, 'B', '视频数据脱敏');
INSERT INTO `option` VALUES (395, 102, 'C', '非结构化文本脱敏');
INSERT INTO `option` VALUES (396, 102, 'D', '个人隐私脱敏');
INSERT INTO `option` VALUES (397, 103, 'A', '甲骨文');
INSERT INTO `option` VALUES (398, 103, 'B', '达梦');
INSERT INTO `option` VALUES (399, 103, 'C', 'My SQL');
INSERT INTO `option` VALUES (400, 103, 'D', '人大金仓');
INSERT INTO `option` VALUES (401, 104, 'A', '源程序代码');
INSERT INTO `option` VALUES (402, 104, 'B', 'API接口');
INSERT INTO `option` VALUES (403, 104, 'C', '数据表格');
INSERT INTO `option` VALUES (404, 104, 'D', '消息队列');
INSERT INTO `option` VALUES (405, 105, 'A', '企业资产');
INSERT INTO `option` VALUES (406, 105, 'B', '个人资产');
INSERT INTO `option` VALUES (407, 105, 'C', '有形资产');
INSERT INTO `option` VALUES (408, 105, 'D', '无形资产');
INSERT INTO `option` VALUES (409, 106, 'A', '结构化数据资产');
INSERT INTO `option` VALUES (410, 106, 'B', '无结构化数据资产');
INSERT INTO `option` VALUES (411, 106, 'C', '非结构化数据资产');
INSERT INTO `option` VALUES (412, 106, 'D', '半结构化数据资产');
INSERT INTO `option` VALUES (413, 107, 'A', '增值性');
INSERT INTO `option` VALUES (414, 107, 'B', '共享性');
INSERT INTO `option` VALUES (415, 107, 'C', '计量性');
INSERT INTO `option` VALUES (416, 107, 'D', '依托性');
INSERT INTO `option` VALUES (417, 108, 'A', '权责分明原则');
INSERT INTO `option` VALUES (418, 108, 'B', '价值导向原则');
INSERT INTO `option` VALUES (419, 108, 'C', '成本效益原则');
INSERT INTO `option` VALUES (420, 108, 'D', '安全合规原则');
INSERT INTO `option` VALUES (421, 109, 'A', '使用方');
INSERT INTO `option` VALUES (422, 109, 'B', '第三方存证');
INSERT INTO `option` VALUES (423, 109, 'C', '公证存证');
INSERT INTO `option` VALUES (424, 109, 'D', '自行存证');
INSERT INTO `option` VALUES (425, 110, 'A', '数据供给方');
INSERT INTO `option` VALUES (426, 110, 'B', '数据需求方');
INSERT INTO `option` VALUES (427, 110, 'C', '数据产品');
INSERT INTO `option` VALUES (428, 110, 'D', '数据交易平台');
INSERT INTO `option` VALUES (429, 111, 'A', '事前');
INSERT INTO `option` VALUES (430, 111, 'B', '事中');
INSERT INTO `option` VALUES (431, 111, 'C', '事后');
INSERT INTO `option` VALUES (432, 111, 'D', '过程');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `question_type_id` int(0) NOT NULL,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stem` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_type_id`(`question_type_id`) USING BTREE,
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`question_type_id`) REFERENCES `question_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 1, '1', '数据是指任何以电子或者其他方式对的记录。', 'B');
INSERT INTO `question` VALUES (2, 2, '1', '数据是指任何以电子或者其他方式对的记录。', 'B');
INSERT INTO `question` VALUES (3, 3, '1', '数据是指任何以电子或者其他方式对的记录。', 'B');
INSERT INTO `question` VALUES (4, 4, '1', '数据是指任何以电子或者其他方式对的记录。', 'B');
INSERT INTO `question` VALUES (5, 4, '2', '数据敏感性又称为数据。', 'C');
INSERT INTO `question` VALUES (6, 4, '3', '生产销售、商业贸易、金融市场等数据属于。', 'B');
INSERT INTO `question` VALUES (7, 4, '4', '卡片、目录、索引、文摘等数据属于。', 'C');
INSERT INTO `question` VALUES (8, 4, '5', '从数量多少视角，数据、信息、知识、智慧间的关系是。', 'B');
INSERT INTO `question` VALUES (9, 4, '6', '以下术语不属于数据元素的是。', 'A');
INSERT INTO `question` VALUES (10, 4, '7', '数据分级的主要作用是保障数据在其全生命周期过程中的。', 'B');
INSERT INTO `question` VALUES (11, 4, '8', '当仅对数据项进行分级时，默认数据项集合的级别为其所包含数据项级别的。', 'C');
INSERT INTO `question` VALUES (12, 4, '9', '数据产生风险后，影响党政机关的数量不超过1个，其影响范围属于。', 'B');
INSERT INTO `question` VALUES (13, 4, '10', '数据质量是指在指定条件下使用时，数据的特性满足明确的和隐含的。', 'B');
INSERT INTO `question` VALUES (14, 4, '11', '若关系数据库中数据记录缺失，则说明其数据质量的不好。', 'A');
INSERT INTO `question` VALUES (15, 4, '12', '字段为NULL值的检验属于监控规则。', 'D');
INSERT INTO `question` VALUES (16, 4, '13', '数据长度检查属于监控规则。', 'C');
INSERT INTO `question` VALUES (17, 4, '14', '数值取值范围约束属于监控规则。', 'A');
INSERT INTO `question` VALUES (18, 4, '15', '数据采集是数据全生命周期的。', 'A');
INSERT INTO `question` VALUES (19, 4, '16', '组织数据包括公益型组织数据和。', 'C');
INSERT INTO `question` VALUES (20, 4, '17', '组织机构官网上公开发布的数据称为。', 'D');
INSERT INTO `question` VALUES (21, 4, '18', '面向网络数据源的数据采集方法是。', 'B');
INSERT INTO `question` VALUES (22, 4, '19', '手机微信可通过进行添加。', 'C');
INSERT INTO `question` VALUES (23, 4, '20', '数据是指将明文转换成密文的过程。', 'A');
INSERT INTO `question` VALUES (24, 4, '21', '一般地，工程界将称为国产密码。-', 'C');
INSERT INTO `question` VALUES (25, 4, '22', '数据加密技术中，是核心。', 'B');
INSERT INTO `question` VALUES (26, 4, '23', '属于国产的对称加密算法。', 'D');
INSERT INTO `question` VALUES (27, 4, '24', '“脱掉”后的数据仍能体现相关业务的真实特征是指数据险敏的。', 'B');
INSERT INTO `question` VALUES (28, 4, '25', '下述脱敏模式可以形象地概括为“搬移并仿真替换”。', 'D');
INSERT INTO `question` VALUES (29, 4, '26', '数据资产按分为一次数据资产、二次数据资产、三次数据资产。', 'B');
INSERT INTO `question` VALUES (30, 4, '27', '数据资产的取得成本、获利状况、金融属性等属于数据资产的。', 'C');
INSERT INTO `question` VALUES (31, 4, '28', '数据资产管理的目标是实现其。', 'A');
INSERT INTO `question` VALUES (32, 4, '29', 'AI训练数据集属于( C)。', '');
INSERT INTO `question` VALUES (33, 4, '30', 'SQL指令CREATE、ALTER、DROP 等属于。', 'A');
INSERT INTO `question` VALUES (34, 4, '1', '数据安全与治理涉及等基本概念。', 'ABCD');
INSERT INTO `question` VALUES (35, 4, '2', '数据按其等级性可分为。', 'ABCD');
INSERT INTO `question` VALUES (36, 4, '3', '数据按其加工深度的不同分为', 'BCD');
INSERT INTO `question` VALUES (37, 4, '4', '从技术视角,数据安全是指通过管理和技术措施,确保数据状态。', 'BC');
INSERT INTO `question` VALUES (38, 4, '5', '数据安全范围包括阶段的安全。', 'ABCD');
INSERT INTO `question` VALUES (39, 4, '6', '按照国家标准GB/T 37988-2019,数据安全PA(过程域)体系分为过程域', 'BC');
INSERT INTO `question` VALUES (40, 4, '7', '数据安全治理的目标是。', 'AB');
INSERT INTO `question` VALUES (41, 4, '8', '数据分类的基本原则包括。', 'ABCD');
INSERT INTO `question` VALUES (42, 4, '9', '混合分类法是将进行组合使用的分类方法。', 'AC');
INSERT INTO `question` VALUES (43, 4, '10', '数据分级是指按照等进行定级的过程。', 'ABC');
INSERT INTO `question` VALUES (44, 4, '11', '数据质量是指在指定条件下使用时,数据的特性满足要求的程度。', 'AD');
INSERT INTO `question` VALUES (45, 4, '12', '影响数据质量的原因包括。', 'ABC');
INSERT INTO `question` VALUES (46, 4, '13', '数据质量评价技术的基本方法包括。', 'ABCD');
INSERT INTO `question` VALUES (47, 4, '14', 'ETL技术包括数据的。', 'BCD');
INSERT INTO `question` VALUES (48, 4, '15', 'ETL通常采用实现数据清洗。', 'AC');
INSERT INTO `question` VALUES (49, 4, '16', '数据采集技术包括。', 'BCD');
INSERT INTO `question` VALUES (50, 4, '17', '数据采集周期内,应保证数据的。\nA,完整性\nB.准确性\nC.唯一性\nD.有效性\n18.下述信息中属于个人自然数据的有。', 'ABCD');
INSERT INTO `question` VALUES (51, 4, '19', '组织数据源具有特点。', 'AD');
INSERT INTO `question` VALUES (52, 4, '20', '自动宋集数据方法包括', 'ACD');
INSERT INTO `question` VALUES (53, 4, '21', '工业控制系统包括系统。', 'ABCD');
INSERT INTO `question` VALUES (54, 4, '22', '数批宋集质量评价方法主要有。', 'AB');
INSERT INTO `question` VALUES (55, 4, '23', '汽车数据采集米用感知设备包括.', 'ABCD');
INSERT INTO `question` VALUES (56, 4, '24', '密码有多种定义,包括。', 'ABC');
INSERT INTO `question` VALUES (57, 4, '25', '从工程角度,密码是对数据等信息进行。', 'ABCD');
INSERT INTO `question` VALUES (58, 4, '26', '利用物项实现加密保护或安全认证功能的方法或手段称为。', 'AB');
INSERT INTO `question` VALUES (59, 4, '27', '( AB)用于保护国家秘密信息', '');
INSERT INTO `question` VALUES (60, 4, '28', '国内外常见的非对称加密算法有。', 'ABC');
INSERT INTO `question` VALUES (61, 4, '29', '国内主要加密算法有。', 'ABCD');
INSERT INTO `question` VALUES (62, 4, '30', '数据脱敏主要包括阶段。', 'BCD');
INSERT INTO `question` VALUES (63, 4, '31', '非结构化数据脱敏包括。', 'ABC');
INSERT INTO `question` VALUES (64, 4, '32', '下述数据库系统中,属于国产数据库的是。', 'BD');
INSERT INTO `question` VALUES (65, 4, '33', '下列数据源属于动态数据流的有。', 'BD');
INSERT INTO `question` VALUES (66, 4, '34', '资产按其存在形态分为。', 'CD');
INSERT INTO `question` VALUES (67, 4, '35', '数据资产按数据结构类别分为。', 'ACD');
INSERT INTO `question` VALUES (68, 4, '36', '数据资产的特征主要包括。', 'ABCD');
INSERT INTO `question` VALUES (69, 4, '37', '数据资产管理的基本原则包括。', 'ABCD');
INSERT INTO `question` VALUES (70, 4, '38', '电子数据存证方式有。', 'BCD');
INSERT INTO `question` VALUES (71, 4, '39', '数据交易主体。', 'ABD');
INSERT INTO `question` VALUES (72, 4, '40', '数据审计可以在发挥作用。', 'ABC');
INSERT INTO `question` VALUES (73, 5, '1', '数据安全与治理涉及等基本概念。', 'ABCD');
INSERT INTO `question` VALUES (74, 5, '2', '数据按其等级性可分为。', 'ABCD');
INSERT INTO `question` VALUES (75, 5, '3', '数据按其加工深度的不同分为', 'BCD');
INSERT INTO `question` VALUES (76, 5, '4', '从技术视角,数据安全是指通过管理和技术措施,确保数据状态。', 'BC');
INSERT INTO `question` VALUES (77, 5, '5', '数据安全范围包括阶段的安全。', 'ABCD');
INSERT INTO `question` VALUES (78, 5, '6', '按照国家标准GB/T 37988-2019,数据安全PA(过程域)体系分为过程域', 'BC');
INSERT INTO `question` VALUES (79, 5, '7', '数据安全治理的目标是。', 'AB');
INSERT INTO `question` VALUES (80, 5, '8', '数据分类的基本原则包括。', 'ABCD');
INSERT INTO `question` VALUES (81, 5, '9', '混合分类法是将进行组合使用的分类方法。', 'AC');
INSERT INTO `question` VALUES (82, 5, '10', '数据分级是指按照等进行定级的过程。', 'ABC');
INSERT INTO `question` VALUES (83, 5, '11', '数据质量是指在指定条件下使用时,数据的特性满足要求的程度。', 'AD');
INSERT INTO `question` VALUES (84, 5, '12', '影响数据质量的原因包括。', 'ABC');
INSERT INTO `question` VALUES (85, 5, '13', '数据质量评价技术的基本方法包括。', 'ABCD');
INSERT INTO `question` VALUES (86, 5, '14', 'ETL技术包括数据的。', 'BCD');
INSERT INTO `question` VALUES (87, 5, '15', 'ETL通常采用实现数据清洗。', 'AC');
INSERT INTO `question` VALUES (88, 5, '16', '数据采集技术包括。', 'BCD');
INSERT INTO `question` VALUES (89, 5, '17', '数据采集周期内,应保证数据的。\nA,完整性\nB.准确性\nC.唯一性\nD.有效性\n18.下述信息中属于个人自然数据的有。', 'ABCD');
INSERT INTO `question` VALUES (90, 5, '19', '组织数据源具有特点。', 'AD');
INSERT INTO `question` VALUES (91, 5, '20', '自动宋集数据方法包括', 'ACD');
INSERT INTO `question` VALUES (92, 5, '21', '工业控制系统包括系统。', 'ABCD');
INSERT INTO `question` VALUES (93, 5, '22', '数批宋集质量评价方法主要有。', 'AB');
INSERT INTO `question` VALUES (94, 5, '23', '汽车数据采集米用感知设备包括.', 'ABCD');
INSERT INTO `question` VALUES (95, 5, '24', '密码有多种定义,包括。', 'ABC');
INSERT INTO `question` VALUES (96, 5, '25', '从工程角度,密码是对数据等信息进行。', 'ABCD');
INSERT INTO `question` VALUES (97, 5, '26', '利用物项实现加密保护或安全认证功能的方法或手段称为。', 'AB');
INSERT INTO `question` VALUES (98, 5, '27', '( AB)用于保护国家秘密信息', '');
INSERT INTO `question` VALUES (99, 5, '28', '国内外常见的非对称加密算法有。', 'ABC');
INSERT INTO `question` VALUES (100, 5, '29', '国内主要加密算法有。', 'ABCD');
INSERT INTO `question` VALUES (101, 5, '30', '数据脱敏主要包括阶段。', 'BCD');
INSERT INTO `question` VALUES (102, 5, '31', '非结构化数据脱敏包括。', 'ABC');
INSERT INTO `question` VALUES (103, 5, '32', '下述数据库系统中,属于国产数据库的是。', 'BD');
INSERT INTO `question` VALUES (104, 5, '33', '下列数据源属于动态数据流的有。', 'BD');
INSERT INTO `question` VALUES (105, 5, '34', '资产按其存在形态分为。', 'CD');
INSERT INTO `question` VALUES (106, 5, '35', '数据资产按数据结构类别分为。', 'ACD');
INSERT INTO `question` VALUES (107, 5, '36', '数据资产的特征主要包括。', 'ABCD');
INSERT INTO `question` VALUES (108, 5, '37', '数据资产管理的基本原则包括。', 'ABCD');
INSERT INTO `question` VALUES (109, 5, '38', '电子数据存证方式有。', 'BCD');
INSERT INTO `question` VALUES (110, 5, '39', '数据交易主体。', 'ABD');
INSERT INTO `question` VALUES (111, 5, '40', '数据审计可以在发挥作用。', 'ABC');

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO `question_type` VALUES (1, '单选题', 30);
INSERT INTO `question_type` VALUES (2, '单选题', 30);
INSERT INTO `question_type` VALUES (3, '单选题', 30);
INSERT INTO `question_type` VALUES (4, '单选题', 30);
INSERT INTO `question_type` VALUES (5, '多选题', 40);
INSERT INTO `question_type` VALUES (6, '判断题', 30);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_class_id`(`class_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, '2024-02-07 23:14:20', '123456', 'zhangsan', 1);

SET FOREIGN_KEY_CHECKS = 1;
