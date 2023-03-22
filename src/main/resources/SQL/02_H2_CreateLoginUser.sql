DROP TABLE IF EXISTS security_user;
CREATE TABLE security_user (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    account_non_expired BOOLEAN,
    account_non_locked BOOLEAN,
    credentials_non_expired BOOLEAN,
    enabled BOOLEAN,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO security_user(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES ('admin', '{bcrypt}$2a$10$.vM1AMKrAtONTn/C9NwxIO5HftsBNRZWJ8mRChSyoPsCe1nwpwuDq', TRUE, TRUE, TRUE, TRUE);

DROP TABLE IF EXISTS security_role;
CREATE TABLE security_role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

INSERT INTO security_role(name) VALUES ('ROLE_ADMIN');
INSERT INTO security_role(name) VALUES ('ROLE_EDITOR');

DROP TABLE IF EXISTS security_users_roles;
CREATE TABLE security_users_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT ur_unique UNIQUE(user_id, role_id),
    CONSTRAINT fk_ur_cr FOREIGN KEY (role_id) REFERENCES security_role (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_ur_cu FOREIGN KEY (user_id) REFERENCES security_user (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

INSERT INTO security_users_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO security_users_roles(user_id, role_id) VALUES (1, 2);