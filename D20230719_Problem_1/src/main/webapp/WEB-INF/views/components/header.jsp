<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
  <div>
    <a href="${ contextPath }/manager/managerMain">
      <img src="${ contextPath }/resources/img/logo.png" />
    </a>
  </div>
  <div>
    <a href="${ contextPath }/manager/managerMain">관리자 메인</a>
    <a href="${ contextPath }/manager/addNewItem">신상품 등록</a>
    <a href="${ contextPath }/manager/itemListForManager">상품 수정 / 삭제</a>
    <a href="${ contextPath }/manager/checkOrderList">주문현황</a>
    <a href="#">Q&A</a>
  </div>
</header>
