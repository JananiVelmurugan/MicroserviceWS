CREATE TABLE books( id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(100), price INT NOT NULL , created_by INT NOT NULL,
created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
UNIQUE(title)
);