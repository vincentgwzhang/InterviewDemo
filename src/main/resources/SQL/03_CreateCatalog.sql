SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `catalog`;
create table `catalog`
(
    id        int auto_increment primary key,
    code      varchar(32)   CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL comment 'unique code stands for this catalog',
    image_url varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    constraint catalog_code_uindex unique (code)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `catalog_language`;
create table `catalog_language`
(
    id            int auto_increment primary key,
    text          varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    language_code varchar(32)   CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    catalog_id    int           not null,
    catalog_code  int           not null COMMENT 'unique code stands for which part of the catalog, short description, long description, or title etc',
    constraint catalog_language_fk foreign key (catalog_id) references catalog (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS=1;