create table address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    city VARCHAR(255) NOT NULL,
    district VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    complement VARCHAR(255),
    person_id BIGINT,
    created_at DATETIME,
    UPDATED_AT DATETIME,

    CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;