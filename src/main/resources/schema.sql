CREATE TABLE app_user(
    id INT AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100),
    enabled INT,
    PRIMARY KEY (id)
);