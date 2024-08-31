CREATE TABLE users
(
    id       serial PRIMARY KEY,
    username varchar(50)  NOT NULL,
    email    varchar(100) NOT NULL
);
