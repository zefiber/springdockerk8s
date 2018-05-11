CREATE TABLE IF NOT EXISTS empi.patients
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS empi.users
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL
);


