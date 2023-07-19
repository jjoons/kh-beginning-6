<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인</title>
</head>
<body>
  <div>
    <c:import url="components/header.jsp" />
    <div>
      <form action="managerLoginPro" method="post">
        <label for="user_id">아이디</label>
        <input type="text" name="id" id="user_id" />
        <br />
        <label for="user_password">비밀번호</label>
        <input type="text" name="pw" id="user_password" />
        <br />
        <button type="submit">로그인</button>
      </form>
    </div>
  </div>
</body>
</html>
