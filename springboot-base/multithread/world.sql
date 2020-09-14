/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : world

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 14/09/2020 18:53:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` char(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `CountryCode` char(3) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `District` char(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `Population` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `CountryCode`(`CountryCode`) USING BTREE,
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4080 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for condition_formula
-- ----------------------------
DROP TABLE IF EXISTS `condition_formula`;
CREATE TABLE `condition_formula`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `filte_rule_id` bigint(20) NOT NULL COMMENT '过滤规则记录id',
  `filte_rule_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '过滤规则公式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '公式条件过滤' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for condition_num
-- ----------------------------
DROP TABLE IF EXISTS `condition_num`;
CREATE TABLE `condition_num`  (
  `id` bigint(20) NOT NULL,
  `is_additional` tinyint(4) NOT NULL COMMENT '是否是补充字段',
  `compare_type` tinyint(255) NOT NULL COMMENT '比较类型',
  `left_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '左值',
  `right_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '右值',
  `left_condition` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '左条件',
  `right_condition` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '右条件',
  `middle_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '中间值',
  `filte_rule_id` bigint(20) NOT NULL COMMENT '过滤规则记录id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '数值条件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for condition_text_date
-- ----------------------------
DROP TABLE IF EXISTS `condition_text_date`;
CREATE TABLE `condition_text_date`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `is_additional` tinyint(255) NOT NULL COMMENT '是否是补充字段',
  `compare_type` tinyint(255) NOT NULL COMMENT '比较类型',
  `middle_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '中间值',
  `filte_rule_id` bigint(20) NOT NULL COMMENT '过滤字段记录id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '文本和日期条件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `Code` char(3) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `Name` char(52) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'Asia',
  `Region` char(26) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `SurfaceArea` float(10, 2) NOT NULL DEFAULT 0.00,
  `IndepYear` smallint(6) NULL DEFAULT NULL,
  `Population` int(11) NOT NULL DEFAULT 0,
  `LifeExpectancy` float(3, 1) NULL DEFAULT NULL,
  `GNP` float(10, 2) NULL DEFAULT NULL,
  `GNPOld` float(10, 2) NULL DEFAULT NULL,
  `LocalName` char(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `GovernmentForm` char(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `HeadOfState` char(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Capital` int(11) NULL DEFAULT NULL,
  `Code2` char(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`Code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for countrylanguage
-- ----------------------------
DROP TABLE IF EXISTS `countrylanguage`;
CREATE TABLE `countrylanguage`  (
  `CountryCode` char(3) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `Language` char(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `IsOfficial` enum('T','F') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT 'F',
  `Percentage` float(4, 1) NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`CountryCode`, `Language`) USING BTREE,
  INDEX `CountryCode`(`CountryCode`) USING BTREE,
  CONSTRAINT `countryLanguage_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for data_component
-- ----------------------------
DROP TABLE IF EXISTS `data_component`;
CREATE TABLE `data_component`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `component_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '组件名称',
  `map_type_id` bigint(20) NOT NULL COMMENT '图表id',
  `data_board_id` bigint(20) NOT NULL COMMENT '所属看板',
  `data_set_id` bigint(20) NOT NULL COMMENT '关联的数据集id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '组件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for filter_rule_record
-- ----------------------------
DROP TABLE IF EXISTS `filter_rule_record`;
CREATE TABLE `filter_rule_record`  (
  `id` bigint(20) NOT NULL,
  `dimension_field_type` tinyint(255) NOT NULL COMMENT '维度字段类型 1横轴字段 2：纵轴字段',
  `dimension_field_id` bigint(20) NOT NULL COMMENT '维度字段id,对于与横轴字段记录和纵轴字段记录表',
  `condition_type` tinyint(255) NOT NULL COMMENT '1条件 2 公式',
  `and_or_type` tinyint(255) NOT NULL COMMENT '1且条件 2或条件',
  `field_type` tinyint(255) NOT NULL COMMENT '字段类型 1:字符串 2数值 3日期时间',
  `filte_type` tinyint(255) NOT NULL COMMENT '过滤类型 1：公式 2：数值 3：字符串',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '过滤规则记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_rule_record
-- ----------------------------
DROP TABLE IF EXISTS `group_rule_record`;
CREATE TABLE `group_rule_record`  (
  `id` bigint(20) NOT NULL DEFAULT 1,
  `group_type` tinyint(255) NOT NULL DEFAULT 1 COMMENT '分组规则类型 1相同值为一组 2:自定义分组',
  `group_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '分组名称',
  `group_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '分组的值，当group_type为2时，该值生效',
  `horizontal_id` bigint(20) NOT NULL COMMENT '横轴字段记录id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '分组规则记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for horizontal_field_record
-- ----------------------------
DROP TABLE IF EXISTS `horizontal_field_record`;
CREATE TABLE `horizontal_field_record`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '新名称',
  `field_id` bigint(20) NOT NULL COMMENT '关联的字段',
  `sort_rule_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '排序规则',
  `group_rule_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '分组规则',
  `filte_rule_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '过滤规则',
  `component_id` bigint(20) NOT NULL COMMENT '关联的组件id',
  `is_additinal` tinyint(255) NOT NULL DEFAULT 2 COMMENT '是否是补充字段 1:是 2:不是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '横轴字段表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_attribute
-- ----------------------------
DROP TABLE IF EXISTS `map_attribute`;
CREATE TABLE `map_attribute`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `map_id` bigint(20) NOT NULL COMMENT '图表id',
  `color_json` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '颜色',
  `size_json` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '大小',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_style
-- ----------------------------
DROP TABLE IF EXISTS `map_style`;
CREATE TABLE `map_style`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `map_id` bigint(20) NOT NULL COMMENT '图形id',
  `axis_config_json` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '轴线配置',
  `horizontal_line_config` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '水平网格线配置',
  `vertical_line_config` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '垂直网格线配置',
  `background_config` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '背景配置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '图形样式配置记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_table_record
-- ----------------------------
DROP TABLE IF EXISTS `map_table_record`;
CREATE TABLE `map_table_record`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `map_name` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '图表名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sort_rule_record
-- ----------------------------
DROP TABLE IF EXISTS `sort_rule_record`;
CREATE TABLE `sort_rule_record`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sort_type` tinyint(255) NOT NULL DEFAULT 1 COMMENT '1:升序 2:降序 3:自定义',
  `sort_key` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '排序字段',
  `extra` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '当sort_type的值为3时，生效',
  `horizontal_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '横轴字段记录id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '排序规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for table_attribute
-- ----------------------------
DROP TABLE IF EXISTS `table_attribute`;
CREATE TABLE `table_attribute`  (
  `id` bigint(20) NOT NULL,
  `color_json` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '表格颜色配置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for table_style
-- ----------------------------
DROP TABLE IF EXISTS `table_style`;
CREATE TABLE `table_style`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `table_font_config` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '表格字体配置',
  `row_height_config` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '表格行配置',
  `backgroud_config` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '背景配置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '表格样式配置记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vertical_field_record
-- ----------------------------
DROP TABLE IF EXISTS `vertical_field_record`;
CREATE TABLE `vertical_field_record`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '新字段名称',
  `aggregationType` tinyint(255) NOT NULL COMMENT '汇总方式',
  `calculation_id` bigint(20) NOT NULL DEFAULT -1 COMMENT '计算方式',
  `filte_rule_id` bigint(20) NOT NULL COMMENT '过滤方式',
  `component_id` bigint(20) NOT NULL COMMENT '所属容器',
  `is_additional` tinyint(4) NOT NULL DEFAULT 2 COMMENT '是否是补充字段 1：是 2：不是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '纵轴字段记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
