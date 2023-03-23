DROP TABLE IF EXISTS "catalog";
CREATE TABLE "catalog"
(
    "id"         INT AUTO_INCREMENT PRIMARY KEY,
    "code"       VARCHAR(32) NOT NULL COMMENT 'unique code stands for this catalog',
    "image_url"  VARCHAR(1024) NOT NULL,
    CONSTRAINT "catalog_code_uindex" UNIQUE ("code")
);


DROP TABLE IF EXISTS "catalog_language";
CREATE TABLE "catalog_language"
(
    "id"             INT AUTO_INCREMENT PRIMARY KEY,
    "text"           VARCHAR(4096) NOT NULL,
    "language_code"  VARCHAR(32) NOT NULL,
    "catalog_id"     INT NULL,
    "catalog_code"   INT NULL COMMENT 'unique code stands for which part of the catalog, short description, long description, or title etc',
    CONSTRAINT "catalog_language_fk" FOREIGN KEY ("catalog_id") REFERENCES "catalog" ("id")
);