SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user`  (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `account_non_expired` TINYINT(1),
    `account_non_locked` TINYINT(1),
    `credentials_non_expired` TINYINT(1),
    `enabled` TINYINT(1),
    `created` datetime default now() not null,
    `updated` datetime null,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO `security_user`(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES ('admin', '{bcrypt}$2a$10$.vM1AMKrAtONTn/C9NwxIO5HftsBNRZWJ8mRChSyoPsCe1nwpwuDq', 1,1,1,1);

DROP TABLE IF EXISTS `security_role`;
CREATE TABLE `security_role`  (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO `security_role`(name) VALUES ('ROLE_ADMIN');
INSERT INTO `security_role`(name) VALUES ('ROLE_EDITOR');

DROP TABLE IF EXISTS `security_users_roles`;
CREATE TABLE `security_users_roles`  (
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    UNIQUE INDEX `ur_unique`(`user_id`, `role_id`) USING BTREE,
    INDEX `fk_ur_cr`(`role_id`) USING BTREE,
    CONSTRAINT `fk_ur_cr` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk_ur_cu` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO `security_users_roles`(user_id, role_id) VALUES (1, 1);
INSERT INTO `security_users_roles`(user_id, role_id) VALUES (1, 2);

SET FOREIGN_KEY_CHECKS=1;