<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>관리자 메인</title>
</head>
<body>
  <div>
    <c:import url="components/header.jsp" />
    <h3>현황</h3>
    <div>회원수: ${ customerCount }명</div>
    <div>등록된 상품 수: ${ registeredItemCount }개</div>
    <div>누적 주문량: ${ totalBuyCount }건</div>
  </div>
</body>
</html>
