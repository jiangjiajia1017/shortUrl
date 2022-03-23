

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `long_url` varchar(200) NOT NULL,
  `code` varchar(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of records
-- ----------------------------
BEGIN;
INSERT INTO `records` (`id`, `long_url`, `code`, `create_time`, `update_time`) VALUES (7, 'https://www.baidu.com', '4hHMpL', '2022-03-23 15:54:51', '2022-01-21 01:01:01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
