<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
  <div>
    <div>Spring 홈페이지</div>
    <div>
      <c:if test="${ sessionScope.loginAccount }">
        <div>
          <div>${ sessionScope.loginAccount.name }님 안녕하세요</div>
          <div>
            <a href="myInfo">내 정보</a>
            <a href="logout">로그아웃</a>
          </div>
        </div>
      </c:if>
      <c:if test="${ not loginAccount }">
        <a href="login">로그인</a>
      </c:if>
    </div>
  </div>
  <div></div>
</header>
