<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
		<table border="1">
			<tr>
				<td>
					<c:if test="${type == 0}">
      					 <jsp:include page="01_01_managerLogin.jsp"/>
    				</c:if>
					    <c:if test="${type == 1}">
     				<%-- 	 <jsp:include page="03_02_login.jsp"/>  --%>
    				</c:if>
				</td>
			</tr>
			<tr>
				<td>				
		 			<c:if test="${not empty cont }" >
  				 	  <jsp:include page="${cont}"/>   
  				 	  </c:if> 
				</td>
			</tr>
		</table>	
	</div>
 
</body>
</html>
<%--
	# ë°ì´í°ë² ì´ì¤ ìì±íê¸° 
CREATE DATABASE shoppingmall;

# ë°ì´í°ë² ì´ì¤ ì¬ì©íê¸°
USE shoppingmall;
-------------------------------------------------------
# manager íì´ë¸ ìì±íê¸°
CREATE TABLE manager(
	managerId VARCHAR(50),
    managerPw VARCHAR(16)
);
DESC manager;
INSERT INTO manager (managerId, managerPw)
VALUES('admin@shop.com', '1111');
SELECT * FROM manager;
-------------------------------------------------------
# book íì´ë¸ ìì±íê¸°
CREATE TABLE book(
	book_id INT,
    book_kind VARCHAR(3),
    book_title VARCHAR(100),
    book_price INT,
    book_count INT,
    author VARCHAR(40),
    publishing_com VARCHAR(30),
    publishing_date VARCHAR(15),
    book_image VARCHAR(30),			-- default 'nothing.jpg'
    book_content VARCHAR(500),
    discount_rate INT,				-- default 10
    reg_date VARCHAR(50)
);
DESC book;
INSERT INTO book VALUES(1, '100', 'ëë¯¸ì¼ ì¡íì ì ê¸°ì ', 15000, 100, 'íê°ìë¸ ê²ì´ê³ ', 'íëë¬¸í', '2019-01-11', 'nothing.jpg', 'ì¼ë³¸ì ëííë ìì¤ê° íê°ìë¸ ê²ì´ê³ ì ì ì', 10, now());
INSERT INTO book VALUES(2, '100', 'ì°íë¡ ì°ê¸°', 18000, 80, 'ê¹í', 'ë¬¸íëë¤', '2018-02-14', 'nothing.jpg', '70ëì ê¹íì´ ì°íë¡ ê¾¹ê¾¹ ëë¬ì´ ì°ë¬¸ì ì§ê²½', 5, now());
INSERT INTO book VALUES(3, '100', 'ì¸ê° ì¤ê²©', 20000, 50, 'ë¤ìì´ ì¤ì¬ë¬´', 'ë¯¼ìì¬', '2016-11-20', 'nothing.jpg', '2019 ìë°ê¸° ì¢í© ë² ì¤í¸ìë¬', 15, now());
INSERT INTO book VALUES(4, '100', 'ê¸°ë¬í ì í¼ì¬í', 12000, 30, 'ì íì', 'ë¬¸íì ë¬¸í', '2017-04-20', 'nothing.jpg', '13í¸ì ì¶ë¦¬ë¬¸í ê±¸ìì ', 20, now());

INSERT INTO book VALUES(5, '200', 'ì¸êµ­ì´ ê³µë¶ì ê°ê°', 15000, 100, 'ìí¤ì¼ë§ ìí¤ì´', 'ìë¶', '2011-03-11', 'nothing.jpg', 'ëë ì´ë»ê² 10ê° êµ­ì´ë¥¼ ë§íê² ëìë?', 25, now());
INSERT INTO book VALUES(6, '200', 'EBS ìë¥ìì± ê³ ë± ì 2ì¸êµ­ì´', 28000, 200, 'EBS í¸ì§ë¶', 'EBSêµì¡ë°©ì¡', '2014-08-14', 'nothing.jpg', '2014 íëë ìë¥ ì°ê³êµì¬', 10, now());
INSERT INTO book VALUES(7, '200', 'ì¸êµ­ì´ ì íë´', 23000, 70, 'ë¡ë²í¸ íì°ì ', 'íí', '2012-10-03', 'nothing.jpg', 'ì¸êµ­ì´ë ì´ëìì ì´ëë¡', 10, now());
INSERT INTO book VALUES(8, '200', 'ìë¬´í¼,ì¸êµ­ì´', 22000, 50, 'ì¡°ì§ì', 'ìê³ ', '2019-04-20', 'nothing.jpg', 'ëª¨ë  ëë¼ìë ì² ìì ìí¬ê° ìë¤', 10, now());

INSERT INTO book VALUES(9, '300', 'ì»´í¨í° ë¹ì ê³¼ ë¥ë¬ë', 35000, 700, 'ë¼ìë§ê°í ì¨ë¬´ê°¸ë§ë', 'ìì´ì½', '2018-02-18', 'nothing.jpg', 'íìíë¡ì ì¼ë¼ì¤ë¥¼ ì¬ì©í ì ë¬¸ ê°ì´ë', 5, now());
INSERT INTO book VALUES(10, '300', 'ì½ê² ë°°ì°ë ë°ì´í° íµì ', 19000, 100, 'ë°ê¸°í', 'íë¹ìì¹´ë°ë¯¸', '2015-03-10', 'nothing.jpg', 'ë°ì´í° íµì ê³¼ ì»´í¨í° ë¤í¸ìí¬', 10, now());
INSERT INTO book VALUES(11, '300', 'ì»´í¨í°íì©ë¥ë ¥', 38000, 200, 'ì´ì£¼í¬', 'ë°°ì', '2012-09-24', 'nothing.jpg', 'ì»´í¨í° ìê²©ì¦', 20, now());
INSERT INTO book VALUES(12, '300', 'ì´ë±íìì´ ììì¼í  ì«ì', 22000, 0, 'ìë¦¬ì¤ ì ìì¤', 'ì´ì¤ë³¸ì½ë¦¬ì', '2013-06-12', 'nothing.jpg', 'ì»´í¨í°ì ì½ë 100ê°ì§', 10, now());
SELECT * FROM book;
-------------------------------------------------------
# bank íì´ë¸ ìì±íê¸°
CREATE TABLE bank(
	account VARCHAR(30),
    bank VARCHAR(10),
    name VARCHAR(10)
);
DESC bank;
INSERT INTO bank (account, bank, name)
VALUES('11111-111-11111', 'ì°ë¦¬ìí', '(ì£¼)ì½ë¦¬ì');
INSERT INTO bank (account, bank, name)
VALUES('22222-222-22222', 'ì íìí', '(ì£¼)ì½ë¦¬ì');
SELECT * FROM bank;
-------------------------------------------------------
# cart íì´ë¸ ìì±íê¸°
CREATE TABLE cart(
	cart_id int not null auto_increment primary key,
    buyer VARCHAR(50),
    book_id INT,
    book_title VARCHAR(100),
    buy_price INT,
    buy_count INT,
    book_image VARCHAR(16)			-- default 'nothing.jpg'
);
DESC cart;
-------------------------------------------------------
# buy íì´ë¸ ìì±íê¸°
CREATE TABLE buy(
	buy_id bigint ,
    buyer VARCHAR(50),
    book_id VARCHAR(12),
    book_title VARCHAR(100),
    buy_price INT,
    buy_count INT,
    book_image VARCHAR(16),			-- default 'nothing.jpg'
    buy_date VARCHAR(50),
    account VARCHAR(50),
    deliveryName VARCHAR(10),
    deliveryTel varchar(20),
    deliveryAdress VARCHAR(10),
    sanction VARCHAR(10)			-- default 'ìíì¤ë¹ì¤'
);
DESC buy;
-------------------------------------------------------

# member íì´ë¸ ìì±íê¸°
CREATE TABLE member(
	id VARCHAR(20),
    passwd VARCHAR(16),
    name VARCHAR(20),
    reg_date VARCHAR(30),
    address VARCHAR(100),
    tel VARCHAR(20)
);
DESC member;
INSERT INTO member
VALUES('qwer@shop.com', '1111', 'íê¸¸ë', now(), 'ê²½ê¸°ë êµ¬ë¦¬ì êµë¬¸ë ìì°¨ì°ë¡', '010-3034-2291');
SELECT * FROM member;
---------------------

create table qna(
	qna_id int not null auto_increment primary key,
    book_id int,
    book_title varchar(40),
    qna_writer varchar(20),
    qna_content varchar(500),
    group_id int,
    qora int,
    reply int,
    reg_date datetime
);

 --%>
