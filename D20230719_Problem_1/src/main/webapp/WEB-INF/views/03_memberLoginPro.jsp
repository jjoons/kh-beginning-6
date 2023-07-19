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
  <c:if test="${ loginResult != 1 }">
    <script>
      alert('로그인에 실패했습니다. 아이디와 비밀번호를 확인해 주세요.')
      history.back()
    </script>
  </c:if>
</body>
</html>
