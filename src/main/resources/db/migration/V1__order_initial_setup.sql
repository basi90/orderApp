-- USER table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    address TEXT,
    phone_number VARCHAR(50) NOT NULL UNIQUE
);

-- ITEM table
CREATE TABLE items (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE PRECISION NOT NULL,
    stock_amount BIGINT NOT NULL
);

-- ORDER table
CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL REFERENCES users(id),
    order_date DATE NOT NULL
);

-- ITEM_GROUP table
CREATE TABLE item_groups (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL REFERENCES orders(id),
    item_id BIGINT NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    item_price DOUBLE PRECISION NOT NULL,
    amount INT NOT NULL,
    shipping_date DATE NOT NULL
);
