INSERT INTO category (name) VALUES
('Italian'),
('Japanese'),
('American');

INSERT INTO address (street, number, complement) VALUES 
('Oak St', '321', NULL),
('Pine Rd', '654', NULL),
('Cedar Blvd', '987', NULL);

INSERT INTO customer (name, address) VALUES
('Sarah Lee', '123 Main St'),
('Alex Chen', '456 Elm St'),
('Emma Davis', '789 Maple Ave');

INSERT INTO drivers (name, phone, license_plate) VALUES
('John Doe', '555-4321', 'JKL321'),
('Jane Smith', '555-8765', 'MNO654'),
('Bob Johnson', '555-2109', 'PQR987');

INSERT INTO menu_items (name, description, price) VALUES
('Pepperoni Pizza', 'Tomato sauce, mozzarella cheese, and pepperoni', 10.99),
('California Roll', 'Crab, avocado, and cucumber wrapped in seaweed and rice', 8.99),
('Bacon Cheeseburger', 'Beef patty, bacon, American cheese, lettuce, tomato, and onion on a bun', 9.99);

INSERT INTO restaurants (name, address, phone, category_id) VALUES
('Marios Pizza', '321 Oak St', '555-1234', 1),
('Sushi Palace', '654 Pine Rd', '555-5678', 2),
('Burger Barn', '987 Cedar Blvd', '555-9012', 3);

INSERT INTO reviews (customer_id, restaurant_id, review_description, rating) VALUES
(1, 1, 'Best pizza I have ever had!', 5),
(2, 2, 'Decent sushi, but a bit overpriced', 3),
(3, 3, 'Amazing burgers and friendly service', 5);

INSERT INTO restaurants_menu_items (restaurant_id, menu_items_id) VALUES
(1, 1),
(2, 2),
(3, 3);

COMMIT;