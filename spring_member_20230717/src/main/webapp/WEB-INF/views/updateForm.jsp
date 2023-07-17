<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Insert title here</title>
</head>
<body>
  <h2>MEMBER UPDATE</h2>
  <form action="update_pro" method="post">
    <label for="id">ID</label>
    <input type="text" name="id" id="id" value="${ id }" disabled />
    <br />
    <label for="password">PW</label>
    <input type="password" name="password" id="password" />
    <br />
    <button type="submit">회원수정</button>
    <button type="button" onclick="">탈퇴</button>
  </form>
</body>
</html>
