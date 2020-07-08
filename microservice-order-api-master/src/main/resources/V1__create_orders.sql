CREATE TABLE orders ( 
id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
user_id INT NOT NULL,
book_id INT NOT NULL,
qty INT NOT NULL,
total_amount INT NOT NULL,
STATUS VARCHAR(100) NOT NULL DEFAULT 'ORDERED',
ordered_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
