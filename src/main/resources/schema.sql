CREATE TABLE app_user(
    id INT AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    enabled INT,
    admin INT,
    PRIMARY KEY (id)
);