DROP TABLE IF EXISTS cards;
CREATE TABLE cards
(
    id                 CHAR(36) PRIMARY KEY,
    number             VARCHAR(19) UNIQUE NOT NULL,
    Month              INT                NOT NULL,
    Year               INT                NOT NULL,
    CVC/CVV            INT                NOT NULL,
    Cardholder         VARCHAR(255) UNIQUE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);