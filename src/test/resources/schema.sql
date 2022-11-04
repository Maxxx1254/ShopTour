
CREATE TABLE card
(
    id                 CHAR(36) PRIMARY KEY,
    number             VARCHAR(19) UNIQUE NOT NULL,
    month              INT                NOT NULL,
    year               INT                NOT NULL,
    status             INT                NOT NULL,
    holder             INT                NOT NULL,
    cvc                INT                NOT NULL
);