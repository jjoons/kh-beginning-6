CREATE DATABASE mybatis_db_01;
USE mybatis_db_01;

CREATE TABLE members (
    id VARCHAR(30) PRIMARY KEY,
    pwd VARCHAR(64) NOT NULL,
    name VARCHAR(30),
    email VARCHAR(50),
    joinDate DATE
);

ALTER TABLE members
    MODIFY joinDate DATETIME
;

SELECT * FROM members;

COMMIT;
