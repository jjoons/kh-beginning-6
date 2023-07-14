<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <div>
      <form action="login" method="POST">
        <label>
          <input type="text" name="user_id" placeholder="id" />
        </label>
        <label>
          <input type="password" name="user_pw" placeholder="password" />
        </label>
        <button type="submit">제출</button>
      </form>
    </div>
  </body>
</html>
