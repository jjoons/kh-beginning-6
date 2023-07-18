<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8" />
  <title>Insert title here</title>
</head>
<body>
  <h2>MEMBER LOGIN</h2>
  <form action="login_pro" method="post">
    <label>ID</label>
    <input type="text" name="id" id="id" />
    <br />
    <label>PW</label>
    <input type="password" name="password" id="password" />
    <br />
    <button type="submit">Login</button>
  </form>
  <a href="main">MAIN</a>
</body>
</html>
