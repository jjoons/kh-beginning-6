<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8" />
  <title>Insert title here</title>
</head>
<body>
  <h2>MEMBER JOIN</h2>
  <form action="join_pro" method="post">
    <table border="1">
      <tbody>
        <tr>
          <td>ID</td>
          <td>
            <input type="text" name="id" id="id" />
          </td>
        </tr>
        <tr>
          <td>PW</td>
          <td>
            <input type="password" name="password" id="password" />
          </td>
        </tr>
        <tr>
          <td>MAIL</td>
          <td>
            <input type="email" name="email" id="email" />
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <button type="submit">Join</button>
            <button type="button" onclick="history.back()">Cancel</button>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
  <a href="main">MAIN</a>
</body>
</html>
