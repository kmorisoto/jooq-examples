CREATE TABLE colors
(
    id     serial PRIMARY KEY,
    bcolor varchar,
    fcolor varchar
);

INSERT INTO colors (bcolor, fcolor)
VALUES ('red', 'red')
     , ('red', 'red')
     , ('red', NULL)
     , (NULL, 'red')
     , (NULL, NULL)
     , ('green', 'green')
     , ('blue', 'blue')
     , ('blue', 'blue');
