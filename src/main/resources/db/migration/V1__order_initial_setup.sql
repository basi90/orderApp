-- SEQUENCES
CREATE SEQUENCE item_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE order_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE item_group_seq START WITH 1 INCREMENT BY 1;

-- USERS
CREATE TABLE users (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    role VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50),
    last_name VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    address TEXT,
    phone_number VARCHAR(50) NOT NULL UNIQUE
);

-- ITEMS
CREATE TABLE item (
    id BIGINT PRIMARY KEY DEFAULT nextval('item_seq'),
    name VARCHAR(50) NOT NULL,
    description TEXT,
    price DOUBLE PRECISION NOT NULL,
    stock_amount BIGINT NOT NULL
);

-- ORDERS
CREATE TABLE orders (
    id BIGINT PRIMARY KEY DEFAULT nextval('order_seq'),
    customer_id BIGINT NOT NULL,
    order_date DATE NOT NULL,
    CONSTRAINT fk_order_customer FOREIGN KEY (customer_id) REFERENCES users(id)
);

-- ITEM GROUPS
CREATE TABLE item_group (
    id BIGINT PRIMARY KEY DEFAULT nextval('item_group_seq'),
    order_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    item_name VARCHAR(50) NOT NULL,
    item_price DOUBLE PRECISION NOT NULL,
    amount INT NOT NULL,
    shipping_date DATE NOT NULL,
    CONSTRAINT fk_item_group_order FOREIGN KEY (order_id) REFERENCES orders(id)
);
