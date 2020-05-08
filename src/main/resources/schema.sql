USE assignment;

CREATE TABLE users(
    id INTEGER NOT NULL AUTO_INCREMENT,
    emailid VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY unique_email (emailid)
);

CREATE TABLE privileges(
    id INTEGER NOT NULL AUTO_INCREMENT,
    privilege_name VARCHAR(128) NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE KEY unique_privilege (privilege_name)
);

CREATE TABLE user_privilege(
    user_id INTEGER NOT NULL,
    privilege_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, privilege_id)
);

CREATE TABLE products(
    id INTEGER NOT NULL AUTO_INCREMENT,
    prod_name VARCHAR(255) NOT NULL,
    prod_type VARCHAR(75) NOT NULL,
    price integer NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY unique_prodname (prod_name)
);