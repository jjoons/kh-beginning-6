<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Insert title here</title>
</head>
<body>
  <c:if test="${ result }">
    <script>
      alert('회원가입 되었습니다')
      location.href = 'main'
    </script>
  </c:if>
  <c:if test="${ not result }">
    <script>
      alert('회원가입에 실패했습니다')
      location.href = 'main'
    </script>
  </c:if>
</body>
</html>
