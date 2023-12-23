-- Create table 'category'
CREATE TABLE IF NOT EXISTS category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Create table 'expenses'
CREATE TABLE IF NOT EXISTS expense (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount FLOAT NOT NULL,
    category_id int NOT NULL,
    description VARCHAR(255) NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);