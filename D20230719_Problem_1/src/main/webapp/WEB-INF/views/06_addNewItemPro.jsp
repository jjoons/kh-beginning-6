<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>추가</title>
</head>
<body>
  <c:if test="${ result == 1 }">
    <script>
      alert('상품을 추가했습니다.')
      history.back()
    </script>
  </c:if>
  <c:if test="${ result != 1 }">
    <script>
      alert('상품을 추가하지 못 했습니다.')
      history.back()
    </script>
  </c:if>
</body>
</html>
