create table person (
    id        BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth     DATETIME NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;