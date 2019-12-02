create table address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    city VARCHAR(255) NOT NULL,
    district VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    complement VARCHAR(255)
    created_at DATETIME,
    UPDATED_AT DATETIME
) ENGINE=InnoDB DEFAULT CHARSET=utf8;