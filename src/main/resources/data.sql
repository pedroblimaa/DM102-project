INSERT INTO category (name) VALUES
('Italian'),
('Japanese'),
('American');

INSERT INTO address (street, number, complement) VALUES 
('Oak St', '321', NULL),
('Pine Rd', '654', NULL),
('Cedar Blvd', '987', NULL);

INSERT INTO customer (name, address_id) VALUES
('Sarah Lee', 1),
('Alex Chen', 2),
('Emma Davis', 3);

INSERT INTO drivers (name, phone, license_plate) VALUES
('John Doe', '555-4321', 'JKL321'),
('Jane Smith', '555-8765', 'MNO654'),
('Bob Johnson', '555-2109', 'PQR987');

INSERT INTO menu_items (name, description, price) VALUES
('Pepperoni Pizza', 'Tomato sauce, mozzarella cheese, and pepperoni', 10.99),
('California Roll', 'Crab, avocado, and cucumber wrapped in seaweed and rice', 8.99),
('Bacon Cheeseburger', 'Beef patty, bacon, American cheese, lettuce, tomato, and onion on a bun', 9.99),
('Margherita Pizza', 'Tomato sauce, fresh mozzarella, and basil', 9.99),
('Dragon Roll', 'Shrimp tempura, avocado, and eel sauce wrapped in seaweed and rice', 12.99),
('Mushroom Swiss Burger', 'Beef patty, sautéed mushrooms, Swiss cheese, lettuce, tomato, and onion on a bun', 10.99),
('Spaghetti Bolognese', 'Spaghetti with meat sauce made from ground beef, tomato, and spices', 11.99),
('Tuna Poke Bowl', 'Raw tuna, avocado, cucumber, and rice topped with soy sauce and sesame seeds', 13.99),
('Chicken Caesar Salad', 'Romaine lettuce, grilled chicken, croutons, Parmesan cheese, and Caesar dressing', 8.99);

INSERT INTO restaurants (name, address, phone, category_id) VALUES
('Marios Pizza', '321 Oak St', '555-1234', 1),
('Sushi Palace', '654 Pine Rd', '555-5678', 2),
('Burger Barn', '987 Cedar Blvd', '555-9012', 3);

INSERT INTO reviews (customer_id, restaurant_id, review_description, rating) VALUES
(1, 1, 'Best pizza I have ever had!', 5),
(2, 2, 'Decent sushi, but a bit overpriced', 3),
(3, 3, 'Amazing burgers and friendly service', 5),
(1, 2, 'Great atmosphere and delicious cocktails', 4),
(2, 1, 'Disappointing pasta dish, but excellent tiramisu', 2),
(3, 2, 'Fresh sushi and attentive service', 4),
(1, 3, 'Huge portions and tasty fries', 4),
(2, 3, 'Decent sandwiches, but nothing special', 3),
(3, 1, 'Fast service, but average pizza', 3);


INSERT INTO restaurants_menu_items (restaurant_id, menu_items_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 4),
(2, 5),
(3, 6),
(1, 7),
(2, 8),
(3, 9);

COMMIT;