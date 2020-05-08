INSERT INTO users (emailid,password,name) VALUES ('admin@gmail.com', '$2a$10$HlHwHzSbl5bTlPiZi64Xj.qo9Kxc7FZV0LFFK0M6zKOM0hgUpXI/6', 'Admin');
INSERT INTO users (emailid,password,name) VALUES ('manoj@gmail.com', '$2a$10$Tx.tMX56ZWbWHB6A8zcDIOywzn1xZjgYzpQUZY3wHnnamoUWiSqX6', 'Manoj Kumar');

INSERT INTO privileges (privilege_name,description) VALUES ('PRIVILEGE_ADMIN_ALL', 'Admin privilege');
INSERT INTO privileges (privilege_name,description) VALUES ('PRIVILEGE_VIEW_PRODUCT', 'Product viewer privilege');

INSERT INTO user_privilege (user_id, privilege_id) VALUES (1,1);
INSERT INTO user_privilege (user_id, privilege_id) VALUES (2,2);

INSERT INTO products (prod_name, prod_type, price) VALUES ('REDMI NOT 9 Pro 4 - 64', 'Mobile & Accessories', 13999);
INSERT INTO products (prod_name, prod_type, price) VALUES ('REDMI NOT 9 Pro 6 - 128', 'Mobile & Accessories', 16999);
INSERT INTO products (prod_name, prod_type, price) VALUES ('Diverse Men's Relaxed Fit Stretchable Jeans', 'Fashion', 1199);
INSERT INTO products (prod_name, prod_type, price) VALUES ('STUDIO NEXX Men's Regular Fit Stretch Jeans', 'Fashion', 2499);
