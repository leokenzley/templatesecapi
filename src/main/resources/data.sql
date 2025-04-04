CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL
);

INSERT INTO users (name, email, cpf) VALUES ('Leo Kenzley', 'leo.kenzley@example.com', '02704738157');
INSERT INTO users (name, email, cpf) VALUES ('Liz Kenzley', 'liz.kenzley@example.com', '02704738157');
INSERT INTO users (name, email, cpf) VALUES ('Sofia Kenzley', 'sofia.kenzley@example.com', '02704738157');