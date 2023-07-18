<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:if test="${ sessionScope.log != null }">
    <c:if test="${ result }">
      <script>
        alert('수정되었습니다.')
        history.back()
      </script>
    </c:if>
    <c:if test="${ not result }">
      <script>
        alert('수정하지 못 했습니다.')
        history.back()
      </script>
    </c:if>
  </c:if>
</body>
</html>
