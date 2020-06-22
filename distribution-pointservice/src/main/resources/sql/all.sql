DROP TABLE IF EXISTS `t_event`;
CREATE TABLE `t_event`  (
                            `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                            `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件类型 新增用户 新增积分',
                            `process` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '事件进行的程度 新建 已发布 已处理',
                            `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '要进行处理的数据',
                            `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '本地事件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_point
-- ----------------------------
DROP TABLE IF EXISTS `user_point`;
CREATE TABLE `user_point`  (
                               `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                               `user_id` int(11) NOT NULL COMMENT '用户id',
                               `point` decimal(11, 2) NULL DEFAULT NULL COMMENT '积分',
                               `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户积分表' ROW_FORMAT = Dynamic;
