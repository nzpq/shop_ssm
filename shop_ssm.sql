/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : shop_ssm

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 27/10/2020 09:33:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `total` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (4, 36, 3, 2, 120.00, 240);
INSERT INTO `car` VALUES (5, 35, 3, 3, 25.00, 75);
INSERT INTO `car` VALUES (6, 36, 2, 2, 120.00, 240);
INSERT INTO `car` VALUES (7, 35, 2, 1, 25.00, 25);
INSERT INTO `car` VALUES (8, 32, 6, 1, 99.00, 99);
INSERT INTO `car` VALUES (10, 36, 7, 1, 120.00, 120);
INSERT INTO `car` VALUES (11, 31, 8, 2, 36.00, 72);
INSERT INTO `car` VALUES (12, 35, 7, 1, 25.00, 25);
INSERT INTO `car` VALUES (16, 31, 9, 1, 36.00, 36);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `item_id` int(11) NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (7, 3, 35, '真的很不错', '2020-07-03 19:23:03');
INSERT INTO `comment` VALUES (8, 3, 28, '真好吃', '2020-07-05 19:32:31');
INSERT INTO `comment` VALUES (9, 9, 35, '挺好', '2020-07-06 21:09:00');
INSERT INTO `comment` VALUES (10, 9, 35, '很大很多很好吃，再来十八斤', '2020-07-09 16:29:59');
INSERT INTO `comment` VALUES (11, 3, 27, '真的超级喜欢，非常支持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-07-09 16:32:26');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scNum` int(11) NULL DEFAULT NULL COMMENT '收藏数',
  `gmNum` int(11) NULL DEFAULT NULL COMMENT '购买数',
  `url1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片的主图',
  `url2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附图',
  `url3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附图',
  `url4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附图',
  `url5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附图',
  `ms` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `pam1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数1',
  `pam2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数2',
  `pam3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数3',
  `val3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值3',
  `val2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值2',
  `val1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值1',
  `type` int(11) NULL DEFAULT NULL,
  `zk` int(10) NULL DEFAULT NULL COMMENT '折扣',
  `category_id_one` int(11) NULL DEFAULT NULL COMMENT '类别id',
  `category_id_two` int(11) NULL DEFAULT NULL COMMENT '类别2级',
  `isDelete` int(2) NULL DEFAULT NULL COMMENT '0否 1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (27, '山西运城新鲜水果苹果红富士', '54.9', 2, 4, '../../../static/ueditor/upload/9f0296902c2111e865b6dc2da7582a7aTB19p5HeKuSBuNjSsziXXbq8pXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static/ueditor/upload/9f030bc02c2111e865b6dc2da7582a7aTB19p5HeKuSBuNjSsziXXbq8pXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static/ueditor/upload/9f05cae02c2111e865b6dc2da7582a7aTB2GaJWaYArBKNjSZFLXXc_dVXa_!!3320501499.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\9f0667202c2111e865b6dc2da7582a7aTB2faFrcFGWBuNjy0FbXXb4sXXa_!!3320501499.jpg_430x430q90.jpg', '../../../static/ueditor/upload/9f06dc502c2111e865b6dc2da7582a7aTB2GaJWaYArBKNjSZFLXXc_dVXa_!!3320501499.jpg_430x430q90.jpg', '苹果, 又叫bai滔婆，仁果类，由结实、多汁du的果肉包着zhi有几个种子的果核，与梨同属。商dao品型苹果原产于西亚或东欧，在世界范围内约有7500个品种，酸甜可口，营养丰富，是老幼皆宜的水果之一。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 1, 76, 0);
INSERT INTO `item` VALUES (28, '黄河古道安徽砀山红富士 丑苹果 不打蜡，无农药', '66.5', 1, 8, '../../../static\\ueditor\\upload\\ba329bc02c1e11e865b6dc2da7582a7a811f5031-87ab-4a55-bfd2-3e29a5eb0ad7.jpg', '../../../static/ueditor/upload/ba3310f02c1e11e865b6dc2da7582a7a6431e0f4-1f60-465b-906e-25ea52bd076b.jpg', '../../../static/ueditor/upload/ba3386202c1e11e865b6dc2da7582a7ae13bedb5-c6c1-47f2-8588-5735397f0dea (1).jpg', '../../../static\\ueditor\\upload\\ba33d4402c1e11e865b6dc2da7582a7ae13bedb5-c6c1-47f2-8588-5735397f0dea.jpg', '../../../static/ueditor/upload/ba3449702c1e11e865b6dc2da7582a7ae37c45cf-fcea-4cb1-8b4e-c7ead141c76d.jpg', '苹果中的钾含量丰富，能够防治高血压。因中国人的饮食中盐分摄入严重超量，从而导致体内钠、水潴留，促发高血压。钾能够使促发高血压的钠从肾脏排出量增加，使细胞中钠的含量降低，从而降低血压。钾还能扩张血管，和果胶共同作用能够预防代谢综合征。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 1, 76, 0);
INSERT INTO `item` VALUES (29, '2017山东新鲜红富士苹果', '49.9', 0, 0, '../../../static\\ueditor\\upload\\2cb2e5102c1f11e865b6dc2da7582a7a5f5bfef1-1183-4c8a-80f5-23a8251422eb.jpg', '../../../static/ueditor/upload/2cb333302c1f11e865b6dc2da7582a7a49e3c13e-5e8c-4c4a-8382-0721d61ae630.jpg', '../../../static/ueditor/upload/2cb3a8602c1f11e865b6dc2da7582a7adbbbca07-7c2d-4ecb-a1e3-097620517400.jpg', '../../../static\\ueditor\\upload\\2cb41d902c1f11e865b6dc2da7582a7ae798f106-7f85-43f8-82d0-7a1918bd5876.jpg', '../../../static/ueditor/upload/2cb46bb02c1f11e865b6dc2da7582a7adbbbca07-7c2d-4ecb-a1e3-097620517400.jpg', '苹果汁有很强大的杀灭传染性病毒的作用，吃较多苹果的人远比不吃或少吃苹果的人得感冒的机会要低。所以，有的科学家和医生把苹果称为“全方位的健康水果”，或称为“全科医生”。现在空气污染比较严重，多吃苹果可改善呼吸系统和肺功能，保护肺部免受污染和烟尘的影响。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 1, 76, 0);
INSERT INTO `item` VALUES (30, '陕西新鲜石榴现摘时令水果贵妃大石榴农家特产薄皮酸石榴', '85', 2, 3, '../../../static\\ueditor\\upload\\d9a752b02c1f11e865b6dc2da7582a7aTB1pC88XOCYBuNkSnaVXXcMsVXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static/ueditor/upload/d9a7eef02c1f11e865b6dc2da7582a7aTB2dP17arGYBuNjy0FoXXciBFXa_!!2455418594.jpg_430x430q90.jpg', '../../../static/ueditor/upload/d9a864202c1f11e865b6dc2da7582a7aTB2TmdedPgy_uJjSZLeXXaPlFXa_!!2455418594.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\d9a8b2402c1f11e865b6dc2da7582a7aTB2dP17arGYBuNjy0FoXXciBFXa_!!2455418594.jpg_430x430q90.jpg', '../../../static/ueditor/upload/d9aad5202c1f11e865b6dc2da7582a7aTB2TmdedPgy_uJjSZLeXXaPlFXa_!!2455418594.jpg_430x430q90.jpg', '唐代，怀远石榴已有栽植。明嘉靖年间，巡按御史，游怀远县时作《九日登山》诗 [1]  。怀远县地处北亚热带至暖温带的过渡带，兼有南北方气候特点，属暖温带半湿润季风农业气候区，适宜石榴的生长 [2]  。怀远石榴子白莹澈如水晶，果实大如碗，皮黄而透红，粒精赛玉米，明洁如珍珠，肉肥核细，汁多味甘 ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 4, 72, 0);
INSERT INTO `item` VALUES (31, '【现货】蒙自甜石榴云南特产薄皮 新鲜水果9个装 单果4.5两左右', '36', 0, 0, '../../../static\\ueditor\\upload\\23dc83f02c2011e865b6dc2da7582a7aTB2A3FzXRLzQeBjSZFoXXc5gFXa_!!2455185564.jpg_430x430q90.jpg', '../../../static/ueditor/upload/23dcf9202c2011e865b6dc2da7582a7aTB2iwNJX8PzQeBjSZPiXXb0TpXa_!!2455185564.jpg_430x430q90.jpg', '../../../static/ueditor/upload/23dd95602c2011e865b6dc2da7582a7aTB2MpRlaqnyQeBjSsplXXaLWVXa_!!2455185564.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\23de0a902c2011e865b6dc2da7582a7aTB11gurg63z9KJjy0FmXXXiwXXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static/ueditor/upload/23de7fc02c2011e865b6dc2da7582a7aTB2MpRlaqnyQeBjSsplXXaLWVXa_!!2455185564.jpg_430x430q90.jpg', '怀远石榴皮薄、粒大、味甘甜，百粒重、可食率、含糖量高。含糖量为15-17%，平均含酸量为0.55%，百粒重45-71克，可食率55-73%，单果重平均500克以上，最大达1250克。玉石籽、玛瑙籽核软可食，籽粒晶莹，若珍珠，似宝石，风味醇厚。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 4, 72, 0);
INSERT INTO `item` VALUES (32, '现货突尼斯软籽石榴2个超大果软子甜酸石榴新鲜水果非蒙自石榴', '99', 0, 10, '../../../static\\ueditor\\upload\\92cc7a902c2011e865b6dc2da7582a7aTB1a7xUdUR1BeNjy0FmXXb0wVXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static/ueditor/upload/92ccefc02c2011e865b6dc2da7582a7aTB2GV6ld7fb_uJjSsD4XXaqiFXa_!!3206065077.jpg_430x430q90.jpg', '../../../static/ueditor/upload/92cd8c002c2011e865b6dc2da7582a7aTB2J81_nf2H8KJjy0FcXXaDlFXa_!!3206065077.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\92ce01302c2011e865b6dc2da7582a7aTB2oM1InmYH8KJjSspdXXcRgVXa_!!3206065077.jpg_430x430q90.jpg', '../../../static/ueditor/upload/92ce76602c2011e865b6dc2da7582a7aTB29bjrngLD8KJjSszeXXaGRpXa_!!3206065077.jpg_430x430q90.jpg', '石榴（拉丁名：Punica granatum L.）落叶乔木或灌木；单叶，通常对生或簇生，无托叶。花顶生或近顶生，单生或几朵簇生或组成聚伞花序，近钟形，裂片5-9，花瓣5-9，多皱褶，覆瓦状排列；胚珠多数。浆果球形，顶端有宿存花萼裂片，果皮厚；种子多数，浆果近球形，果熟期9-10月。外种皮肉质半透明，多汁；内种皮革质。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 4, 72, 0);
INSERT INTO `item` VALUES (33, '荥阳突尼斯陈氏河阴软籽石榴软子新鲜水果非会理蒙自临潼甜新鲜', '80', 1, 0, '../../../static\\ueditor\\upload\\dcb3b2e02c2011e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '../../../static/ueditor/upload/dcb6e7302c2011e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '../../../static/ueditor/upload/dcb75c602c2011e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\dcb7d1902c2011e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '../../../static/ueditor/upload/dcb86dd02c2011e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '石榴是一种浆果，其营养丰富，维生素C比苹果、梨高1~2倍。原产中国西域，汉代传出中原。石榴成熟后，全身都可用，果皮可入药，果实可食用或压汁。对老年人的身体健康有很高营养价值，所以老人应该常吃石榴。石榴是一种珍奇的浆果，其果实营养价值较高。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 4, 72, 0);
INSERT INTO `item` VALUES (34, '正宗陕西红心石榴水果新鲜', '85', 0, 4, '../../../static\\ueditor\\upload\\012eb0202c2111e865b6dc2da7582a7aTB23TvclwoQMeJjy1XaXXcSsFXa_!!3296167834.jpg_430x430q90.jpg', '../../../static/ueditor/upload/012f25502c2111e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '../../../static/ueditor/upload/012fc1902c2111e865b6dc2da7582a7aTB23TvclwoQMeJjy1XaXXcSsFXa_!!3296167834.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\013036c02c2111e865b6dc2da7582a7aTB2VP8VmjuhSKJjSspaXXXFgFXa_!!3363047546.jpg_430x430q90.jpg', '../../../static/ueditor/upload/0130abf02c2111e865b6dc2da7582a7aTB23TvclwoQMeJjy1XaXXcSsFXa_!!3296167834.jpg_430x430q90.jpg', '石榴果实如一颗颗红色的宝石，果粒酸甜可口多汁，营养价\r\n石榴\r\n石榴(10张)\r\n值高，富含丰富的水果糖类、优质蛋白质、易吸收脂肪等，可补充人体能量和热量，但不增加身体负担。果实中含有维生素C及B族维生素，有机酸、糖类、蛋白质、脂肪及钙、磷、钾等矿物质，能够补充人体所缺失的微量元素和营养成分。还富含丰富的各种酸类，包括有机酸、叶酸等对人体有保健功效。石榴不仅果实营养成分丰富，而且叶子和果实核都非常有价值。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 4, 72, 0);
INSERT INTO `item` VALUES (35, '新鲜油桃5斤 新鲜孕妇水果非水蜜桃黄桃毛桃子樱桃当季时令鲜果', '25', 0, 8, '../../../static\\ueditor\\upload\\4152abc02c2111e865b6dc2da7582a7aTB1sRNzXSMmBKNjSZTEXXasKpXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static/ueditor/upload/41536f102c2111e865b6dc2da7582a7aTB2d_RhaKuSBuNjy1XcXXcYjFXa_!!2102024380.jpg_430x430q90.jpg', '../../../static/ueditor/upload/41540b502c2111e865b6dc2da7582a7aTB1sRNzXSMmBKNjSZTEXXasKpXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\415459702c2111e865b6dc2da7582a7aTB2d_RhaKuSBuNjy1XcXXcYjFXa_!!2102024380.jpg_430x430q90.jpg', '../../../static/ueditor/upload/4154cea02c2111e865b6dc2da7582a7aTB1sRNzXSMmBKNjSZTEXXasKpXa_!!0-item_pic.jpg_430x430q90.jpg', '桃子素有“寿桃”和“仙桃”的美称，因其肉质鲜美，又被称为“天下第一果”。桃肉含蛋白质、脂肪、碳水化合物、粗纤维、钙、磷、铁、胡萝卜素、维生素B1、以及有机酸（主要是苹果酸和柠檬酸）、糖分（主要是葡萄糖、果糖、蔗糖、木糖）和挥发油。每100克鲜桃中所含水分占比88%，蛋白质约有0.7克，碳水化合物11克，热量只有180.0千焦。桃子适宜低血钾和缺铁性贫血患者食用', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 5, 74, 0);
INSERT INTO `item` VALUES (36, '现摘3斤 桃子水蜜桃 新鲜水果包邮脆桃硬桃现货新摘桃子非油桃黄', '120', 0, 3, '../../../static\\ueditor\\upload\\88b583202c2111e865b6dc2da7582a7aTB2faFrcFGWBuNjy0FbXXb4sXXa_!!3320501499.jpg_430x430q90.jpg', '../../../static/ueditor/upload/88b5f8502c2111e865b6dc2da7582a7aTB2GaJWaYArBKNjSZFLXXc_dVXa_!!3320501499.jpg_430x430q90.jpg', '../../../static/ueditor/upload/88b66d802c2111e865b6dc2da7582a7aTB19p5HeKuSBuNjSsziXXbq8pXa_!!0-item_pic.jpg_430x430q90.jpg', '../../../static\\ueditor\\upload\\88b6e2b02c2111e865b6dc2da7582a7aTB2GaJWaYArBKNjSZFLXXc_dVXa_!!3320501499.jpg_430x430q90.jpg', '../../../static/ueditor/upload/88b77ef02c2111e865b6dc2da7582a7aTB19p5HeKuSBuNjSsziXXbq8pXa_!!0-item_pic.jpg_430x430q90.jpg', '是一种果实作为水果的落叶小乔木，花可以观赏，果实多汁，可以生食或制桃脯、罐头等，核仁也可以食用。果肉有白色和黄色的，桃有多种品种，一般果皮有毛，“油桃”的果皮光滑；“蟠桃”果实是扁盘状；“碧桃”是观赏花用桃树，有多种形式的花瓣。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, 5, 74, 0);

-- ----------------------------
-- Table structure for item_category
-- ----------------------------
DROP TABLE IF EXISTS `item_category`;
CREATE TABLE `item_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL COMMENT '父id',
  `isDelete` int(11) NULL DEFAULT NULL COMMENT '0未删除；1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item_category
-- ----------------------------
INSERT INTO `item_category` VALUES (1, '苹果', NULL, 0);
INSERT INTO `item_category` VALUES (2, '梨子', NULL, 0);
INSERT INTO `item_category` VALUES (3, '菠菜', NULL, 0);
INSERT INTO `item_category` VALUES (4, '石榴', NULL, 0);
INSERT INTO `item_category` VALUES (5, '桃子', NULL, 0);
INSERT INTO `item_category` VALUES (6, '西瓜', NULL, 0);
INSERT INTO `item_category` VALUES (70, '湾里酥梨', 2, 0);
INSERT INTO `item_category` VALUES (72, '肖山御石榴', 4, 0);
INSERT INTO `item_category` VALUES (74, '史德镇御桃', 5, 0);
INSERT INTO `item_category` VALUES (76, '日本红富士', 1, 0);
INSERT INTO `item_category` VALUES (77, '秦冠', 1, 0);
INSERT INTO `item_category` VALUES (79, '黄元帅', 2, 0);
INSERT INTO `item_category` VALUES (81, '花花牛', 1, 0);
INSERT INTO `item_category` VALUES (82, '测试1的二级分类', 83, 1);
INSERT INTO `item_category` VALUES (83, '测试1', NULL, 1);
INSERT INTO `item_category` VALUES (84, '测试2', NULL, 1);
INSERT INTO `item_category` VALUES (86, '测试2的二级分类', 84, 1);
INSERT INTO `item_category` VALUES (87, '测试3', NULL, 1);
INSERT INTO `item_category` VALUES (88, '测试3的二级分类', 87, 1);

-- ----------------------------
-- Table structure for item_order
-- ----------------------------
DROP TABLE IF EXISTS `item_order`;
CREATE TABLE `item_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addTime` datetime NULL DEFAULT NULL,
  `total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isDelete` int(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL COMMENT '0.未发货1.已取消 2已发货，3已收货；4待付款',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 921607047 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item_order
-- ----------------------------
INSERT INTO `item_order` VALUES (27, NULL, 3, '2018032017080001', '2020-07-01 17:08:56', '54.9', 0, 3);
INSERT INTO `item_order` VALUES (28, NULL, 3, '2018032017380001', '2020-07-03 16:38:52', '653.59', 0, 0);
INSERT INTO `item_order` VALUES (29, NULL, 2, '2018032017390001', '2020-07-04 17:39:28', '976.5', 0, 2);
INSERT INTO `item_order` VALUES (30, NULL, 2, '2018032019220001', '2020-07-02 19:22:25', '364.5', 0, 3);
INSERT INTO `item_order` VALUES (31, NULL, 2, '2018032019310001', '2020-06-30 19:31:23', '360', 0, 1);
INSERT INTO `item_order` VALUES (32, NULL, 1, '2018032019310002', '2020-07-01 19:31:50', '59.86', 0, 0);
INSERT INTO `item_order` VALUES (35, NULL, 2, '20200708212202', '2020-07-08 21:22:02', '265.00', 0, 0);
INSERT INTO `item_order` VALUES (38, NULL, 6, '20200708222557', '2020-07-08 22:25:57', '149.00', 0, 0);
INSERT INTO `item_order` VALUES (785830194, NULL, 8, '20200708223137', '2020-07-08 22:31:37', '72.00', 0, 4);
INSERT INTO `item_order` VALUES (785895959, NULL, 7, '20200708223242', '2020-07-08 22:32:42', '25.00', 0, 4);
INSERT INTO `item_order` VALUES (786310710, NULL, 6, '20200708223937', '2020-07-08 22:39:37', '50.00', 0, 4);
INSERT INTO `item_order` VALUES (831817310, NULL, 9, '20200709111804', '2020-07-09 11:18:04', '50.00', 0, 3);
INSERT INTO `item_order` VALUES (844012275, NULL, 3, '20200709144119', '2020-07-09 14:41:19', '160.00', 0, 1);
INSERT INTO `item_order` VALUES (846536578, NULL, 9, '20200709152323', '2020-07-09 15:23:23', '90.90', 0, 1);
INSERT INTO `item_order` VALUES (846572168, NULL, 9, '20200709152358', '2020-07-09 15:23:58', '99.80', 0, 4);
INSERT INTO `item_order` VALUES (921404815, NULL, 1, '20200710121111', '2020-07-10 12:11:11', '85.00', 0, 4);
INSERT INTO `item_order` VALUES (921520561, NULL, 1, '20200710121307', '2020-07-10 12:13:07', '99.00', 0, 4);
INSERT INTO `item_order` VALUES (921607046, NULL, 1, '20200710121433', '2020-07-10 12:14:33', '120.00', 0, 0);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, 'admin', '123', 'Tom');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (2, '一号留言', '13587452241', '好好学习', 1);
INSERT INTO `message` VALUES (3, '二号留言', '13587459984', '哈哈哈哈', 2);
INSERT INTO `message` VALUES (6, '熊大', '13524578841', '测试测试', 9);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (3, '测试公告', '哈哈哈哈哈哈', '2020-07-02 14:02:28');
INSERT INTO `notice` VALUES (4, '测试公告2', '嘻嘻嘻嘻嘻', '2020-07-03 14:03:09');
INSERT INTO `notice` VALUES (5, '测试公告3', '嘎嘎嘎嘎嘎', '2020-07-03 14:03:32');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `item_id` int(255) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '0.未退货 1已退货',
  `num` int(11) NULL DEFAULT NULL,
  `total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 921607057 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (54, 27, 27, 1, 1, '1');
INSERT INTO `order_detail` VALUES (55, 32, 28, 0, 5, '25');
INSERT INTO `order_detail` VALUES (56, 27, 28, 0, 3, '9');
INSERT INTO `order_detail` VALUES (57, 28, 28, 0, 1, '1');
INSERT INTO `order_detail` VALUES (58, 35, 29, 0, 2, '4');
INSERT INTO `order_detail` VALUES (59, 34, 29, 0, 4, '16');
INSERT INTO `order_detail` VALUES (60, 32, 29, 0, 3, '9');
INSERT INTO `order_detail` VALUES (61, 36, 29, 0, 3, '9');
INSERT INTO `order_detail` VALUES (62, 32, 29, 0, 2, '4');
INSERT INTO `order_detail` VALUES (63, 35, 30, 0, 6, '36');
INSERT INTO `order_detail` VALUES (64, 30, 30, 0, 3, '9');
INSERT INTO `order_detail` VALUES (65, 28, 31, 0, 4, '16');
INSERT INTO `order_detail` VALUES (66, 28, 31, 0, 2, '4');
INSERT INTO `order_detail` VALUES (67, 28, 32, 0, 1, '1');
INSERT INTO `order_detail` VALUES (785490246, 32, 38, 0, 1, '99.00');
INSERT INTO `order_detail` VALUES (785490247, 35, 38, 0, 2, '50.00');
INSERT INTO `order_detail` VALUES (785830200, 31, 785830194, 0, 2, '72.00');
INSERT INTO `order_detail` VALUES (785895961, 35, 785895959, 0, 1, '25.00');
INSERT INTO `order_detail` VALUES (786028289, 31, 786028287, 0, 1, '36.00');
INSERT INTO `order_detail` VALUES (786028291, 29, 786028287, 0, 2, '99.80');
INSERT INTO `order_detail` VALUES (786310723, 35, 786310710, 0, 2, '50.00');
INSERT INTO `order_detail` VALUES (831817313, 35, 831817310, 0, 2, '50.00');
INSERT INTO `order_detail` VALUES (844012277, 33, 844012275, 0, 2, '160.00');
INSERT INTO `order_detail` VALUES (846536579, 31, 846536578, 0, 1, '36.00');
INSERT INTO `order_detail` VALUES (846536582, 27, 846536578, 0, 1, '54.90');
INSERT INTO `order_detail` VALUES (846572170, 29, 846572168, 0, 2, '99.80');
INSERT INTO `order_detail` VALUES (921404818, 30, 921404815, 0, 1, '85.00');
INSERT INTO `order_detail` VALUES (921520568, 32, 921520561, 0, 1, '99.00');
INSERT INTO `order_detail` VALUES (921607056, 36, 921607046, 0, 1, '120.00');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (17, 27, 3);
INSERT INTO `sc` VALUES (18, 28, 3);
INSERT INTO `sc` VALUES (19, 30, 9);
INSERT INTO `sc` VALUES (22, 30, 9);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '123', '13465294753', '张三', '男', '河南', 'test@163.com');
INSERT INTO `user` VALUES (2, 'lisi', '123', '1346529475', '李四', '男', '上海', 'test@163.com');

SET FOREIGN_KEY_CHECKS = 1;
