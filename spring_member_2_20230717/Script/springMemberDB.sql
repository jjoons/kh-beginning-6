CREATE DATABASE springMemberDB;
USE springMemberDB;

CREATE TABLE member(
	num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(20),
    pw VARCHAR(20),
    email VARCHAR(20)
);

delete from member where num=3;
-- drop table member;
SELECT * FROM member;

SELECT * FROM member ORDER BY num ASC;


INSERT INTO member (id, pw, email) VALUES('qwer', '1234', 'qwer@naver.com');
