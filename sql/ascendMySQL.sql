

DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS cart_items;
DROP TABLE IF EXISTS credit_cards;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;
DROP DATABASE IF EXISTS dbSQL;


CREATE DATABASE dbSQL;

USE dbSQL;

CREATE TABLE users
(
    user_id INT NOT NULL AUTO_INCREMENT, 
    email VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL, 
    user_password VARCHAR(50) NOT NULL,
    phone CHAR(10) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE addresses
(
    address_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    recipient_name VARCHAR(50),
    street VARCHAR(50) NOT NULL,
    street2 VARCHAR(50),
    city VARCHAR(30) NOT NULL,
    state CHAR(2) NOT NULL,
    zip CHAR(5) NOT NULL,
    is_shipping BOOL NOT NULL,
    is_billing BOOL NOT NULL,
    PRIMARY KEY (address_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE products
(
    upc CHAR(12) NOT NULL,
    prod_name VARCHAR(64) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    prod_description VARCHAR(2048) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price_per_unit FLOAT NOT NULL,
    image_url VARCHAR(2048),
    available_stock INT NOT NULL,
    reserved_stock INT NOT NULL,
    shipped_stock INT NOT NULL,
    PRIMARY KEY (upc)
);

CREATE TABLE cart_items
(
    cart_item_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    upc CHAR(12) NOT NULL,
    quantity INT,
    PRIMARY KEY (cart_item_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (upc) REFERENCES products (upc)
);

CREATE TABLE credit_cards
(
    credit_card_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    cardholder_name VARCHAR(40) NOT NULL,
    
    bank_name VARCHAR(255) NOT NULL,
    card_type VARCHAR(255) NOT NULL,
    
    last_four_card_number CHAR(16) NOT NULL,
    
    security_code VARCHAR(255) NOT NULL,
    
    expiration_year CHAR(4) NOT NULL,
    expiration_month CHAR(2) NOT NULL,
    PRIMARY KEY (credit_card_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE orders
(
    order_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    address_id INT NOT NULL,
    price FLOAT NOT NULL,
    credit_card_id INT NOT NULL,
    date_ordered DATETIME NOT NULL,
    date_shipped DATETIME,
    order_status VARCHAR(20) NOT NULL,
    PRIMARY KEY (order_id),
    /*FOREIGN KEY (user_id) REFERENCES users (user_id), */
    FOREIGN KEY (address_id) REFERENCES addresses (address_id),
    FOREIGN KEY (credit_card_id) REFERENCES credit_cards (credit_card_id)
);

CREATE TABLE order_items
(
    order_item_id INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    quantity INT NOT NULL,
    upc CHAR(12) NOT NULL,
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    FOREIGN KEY (upc) REFERENCES products (upc)
);

INSERT INTO users (email, first_name, last_name, user_password, phone) 
	VALUES ("bobby.joe@gmail.com", "Bobby", "Joe", "password123", "9876543210");
INSERT INTO users  (email, first_name, last_name, user_password, phone) 
	VALUES ("awilliams@yahoo.com", "Andrew", "Williams", "mypassword", "8376519501");
INSERT INTO users  (email, first_name, last_name, user_password, phone) 
	VALUES ("n.johnson@gmail.com", "Nancy", "Johnson", "thisisabadpassword", "6504891123");
INSERT INTO users  (email, first_name, last_name, user_password, phone) 
	VALUES ("jj1205@msn.com", "Jenny", "Jones", "iforgot", "6264589104");
INSERT INTO users  (email, first_name, last_name, user_password, phone) 
	VALUES ("g.s.l.62@gmail.com", "George", "Lee", "whatismypassword", "3108573221");
    
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',1, 'Bobby Joe', '1234', '2022', '09' );
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',3, 'Nancy Johnson', '1121', '2024', '01' );
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',2, 'Andrew Williams','3672', '2026', '09' );
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',5, 'George Lee','3161', '2025', '11' );
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',4, 'Jenny Jones', '1970', '2028', '10' );
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',3, 'Nancy Johnson', '4035', '2027', '07' );
INSERT INTO credit_cards (bank_name,card_type,security_code,user_id, cardholder_name, last_four_card_number, expiration_year, expiration_month) 
	VALUES('','','',1, 'Bobby Joe', '6477', '2023', '02' );

INSERT INTO addresses (user_id, recipient_name, street, street2, city, state, zip, is_shipping, is_billing)
	VALUES (1, "Bobby Joe", "100 This st", "Apt 20", "Los Angeles", "CA", "90025", TRUE, TRUE);
INSERT INTO addresses (user_id, recipient_name, street, street2, city, state, zip, is_shipping, is_billing)
	VALUES (2, "Andrew Williams", "3211 That Blvd", NULL, "Dallas", "TX", "75011", FALSE, TRUE);
INSERT INTO addresses (user_id, recipient_name, street, street2, city, state, zip, is_shipping, is_billing)
	VALUES (3, "Nancy Johnson", "20 Example Ave", NULL, "New York", "NY", "10205", TRUE, FALSE);
INSERT INTO addresses (user_id, recipient_name, street, street2, city, state, zip, is_shipping, is_billing)
	VALUES (4, "Jenny Jones", "777 Some Rd", "Apt 94", "Minneapolis", "MN", "55543", TRUE, TRUE);
INSERT INTO addresses (user_id, recipient_name, street, street2, city, state, zip, is_shipping, is_billing)
	VALUES (5, "George Lee", "57 Hello Ln", NULL, "Honolulu", "HI", "96720", TRUE, TRUE);

INSERT INTO products VALUES ("100000000001", "Shark Bites", "Assorted Gummy Sharks", "Betty Crockers", "Snacks", 3.99, "https://m.media-amazon.com/images/I/51Xlrk8SOaL.jpg", 49, 5, 10);
INSERT INTO products VALUES ("100000000011", "Cheerios", "General Mills", "Oat cold breakfast cereal", "Breakfast Cereals", 5.99, "https://i5.walmartimages.com/asr/ce09f4c7-0b16-4c56-9abe-76cf8ed53915.63028f7382a779cd875263c912632114.jpeg", 119, 3, 0);
INSERT INTO products VALUES ("100000000111", "Frosted Flakes", "Kelloggs", "Sugary corn cold breakfast cereal", "Breakfast Cereals", 5.99, "https://bjs.scene7.com/is/image/bjs/3633?$bjs-Zoom$", 419, 25, 14);
INSERT INTO products VALUES ("100000001111", "Kix", "General Mills", "Sugary corn puff cold breakfast cereal", "Breakfast Cereals", 4.99, "https://cereals.generalmills.com/wp-content/uploads/2019/04/kix.png", 44, 15, 5);
INSERT INTO products VALUES ("100000011111", "Sriracha", "Huy Fong Foods", "Chili paste hot sauce", "Condiments", 8.99, "https://m.media-amazon.com/images/I/817HLNV5DZL._SL1500_.jpg", 0, 1, 12);
INSERT INTO products VALUES ("100000111111", "Paper Towels", "Bounty", "Paper but towels", "Household", 2.99, "https://images.heb.com/is/image/HEBGrocery/003264047?fit=constrain,1&wid=800&hei=800&fmt=jpg&qlt=85,0&resMode=sharp2&op_usm=1.75,0.3,2,0", 59, 5, 10);
INSERT INTO products VALUES ("100001111111", "Goldfish", "Pepperidge Farm","Goldfish Baked Snack Crackers Cheddar", "Snacks", 2.99, "https://www.kroger.com/product/images/large/front/1001410004897", 49, 6, 70);
INSERT INTO products VALUES ("100011111111", "Malk", "Now With Vitamin R", "Not actually milk", "Drinks", 0.99, "https://target.scene7.com/is/image/Target/GUEST_fc940329-105c-42ce-8c26-d3d34b1a51b4?wid=800&hei=800&qlt=80&fmt=pjpeg", 39, 3, 3);
INSERT INTO products VALUES ("600000000002", "Crystal Geyser", "Crystal Geyser Water Company", "Spring Water", "Drinks", 0.99, "https://images.heb.com/is/image/HEBGrocery/001966477", 121, 3, 5);

INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (1, 1, 10.00, 1, "2011-12-18 13:17:17", NULL, "Pending");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (2, 2, 11.00, 2, "2012-12-18 13:17:17", "2012-12-18 13:17:17", "Delivered");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (3, 3, 12.00, 3, "2013-12-18 13:17:17", "2013-12-18 13:17:17", "Delivered");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (4, 4, 13.00, 4, "2014-12-18 13:17:17", "2014-12-18 13:17:17", "Canceled");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (5, 5, 14.00, 5, "2015-12-18 13:17:17", "2015-12-18 13:17:17", "Canceled");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (1, 1, 10.00, 1, "2015-12-18 13:17:17", "2015-12-18 13:17:17", "Delivered");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (2, 2, 11.00, 2, "2016-12-18 13:17:17", "2016-12-18 13:17:17", "Delivered");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (1, 3, 12.00, 3, "2017-12-18 13:17:17", "2017-12-18 13:17:17", "Canceled");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (5, 5, 13.00, 5, "2018-12-17 13:17:17", "2018-12-18 13:17:17", "Shipped");
INSERT INTO orders (user_id, address_id, price, credit_card_id, date_ordered, date_shipped, order_status)
	VALUES (5, 5, 14.00, 5, "2018-12-18 13:17:17", NULL, "Pending");

INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 72, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(8, 59, '100001111111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(10, 8, '100000111111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(8, 56, '100000011111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(2, 37, '600000000002');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(5, 41, '100000000011');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 64, '100000011111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(3, 1, '100001111111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(7, 95, '100000000111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 57, '100000011111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(2, 36, '100001111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(1, 64, '100000000001'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(7, 10, '100000000111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(9, 86, '100000000011'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(5, 50, '100000111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(7, 59, '100000111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(8, 62, '100011111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(1, 14, '100011111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 43, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(3, 13, '100011111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(3, 32, '100000000111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(8, 5, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(8, 70, '600000000002'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(2, 43, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 42, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 88, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(5, 41, '100011111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(2, 5, '100011111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(3, 5, '100000111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(5, 53, '100000011111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(6, 61, '100001111111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(5, 16, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(5, 40, '100001111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(4, 34, '100011111111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(2, 13, '100000000111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(4, 28, '100000001111'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(8, 16, '100000000001'); 
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(10, 13, '100000000111');
INSERT INTO order_items (order_id, quantity, upc)
	VALUES(10, 86, '100000001111');

SELECT * FROM orders;



/* SELECT DISTINCT o.order_id, a.street, o.price, cc.last_four_card_number, o.date_ordered, o.date_shipped, o.order_status FROM orders o JOIN Addresses a ON o.address_id = a.address_id JOIN credit_cards cc WHERE o.credit_card_id = cc.credit_card_id; */

SELECT * FROM orders;