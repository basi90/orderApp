-- Insert an Admin user
INSERT INTO users (id, role, email, password, last_name, first_name, address, phone_number)
VALUES (
    nextval('user_seq'),
    'ADMIN',
    'ab@cd.com',
    'password',
    'admin',
    'user',
    'Avenue des Gaulois 17, Brussels',
    '0478123456'
       );

-- Insert some items
INSERT INTO item (id, name, description, price, stock_amount) VALUES
    (nextval('item_seq'), 'Laptop', 'A high-performance laptop', 1199.99, 15),
    (nextval('item_seq'), 'Wireless Mouse', 'Ergonomic wireless mouse', 29.99, 50),
    (nextval('item_seq'), 'Monitor', '27-inch 4K display', 329.00, 20),
    (nextval('item_seq'), 'USB-C Hub', 'Multi-port hub for USB-C devices', 59.90, 30),
    (nextval('item_seq'), 'Mechanical Keyboard', 'RGB backlit mechanical keyboard', 99.50, 10);
