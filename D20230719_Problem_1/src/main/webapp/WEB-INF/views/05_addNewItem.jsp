<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
  ajaxForm 플러그인
    파일 업로드할 때 가장 많이 사용하는 방법
-->
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Insert title here</title>
  <script src="${contextPath}/resources/jq/jquery-1.11.0.min.js"></script>
  <script src="${contextPath}/resources/jq/jquery.form.min.js"></script>
  <script src="${contextPath}/resources/js/05_addNewItem.js"></script>
</head>
<body>
<form method="post" id="fileUploadForm" action="${ contextPath }/addNewItemPro.do" enctype="multipart/form-data">
  <table border="1"  style="border-collapse:collapse;">
    <tr height="30">
      <td width ="200">상품 카테고리</td>
      <td width = "500">
        <select name="item_category">
          <option value="100">채소</option>
          <option value="200">해산물</option>
          <option value="300">육류</option>
          <option value="400">전자제품</option>
        </select>
      </td>
    </tr>
    <tr height="30">
      <td width ="200">상품명</td>
      <td width = "500">
        <input type="text" name="item_name">
      </td>
    </tr>
    <tr height="30">
      <td width ="200">상품가격</td>
      <td width = "500">
        <input type="text" name="item_price">원
      </td>
    </tr>
    <tr height="30">
      <td width ="200">상품재고</td>
      <td width = "500">
        <input type="text" name="item_stock">
      </td>
    </tr>
    <tr height="30">
      <td width ="200">이미지</td>
      <td width = "500">
        <input type="file" name="item_image">
      </td>
    </tr>
    <tr height="30">
      <td width ="200">상품정보</td>
      <td width = "500">
        <input type="text" name="item_info" size="50">
      </td>
    </tr>
    <tr height="30">
      <td width ="200">할인률</td>
      <td width = "500">
        <input type="text" name="discount_rate">%
      </td>
    </tr>
  </table>
  <br>
  <input type="submit" value="상품 추가하기">
</form>

  <div>
    <c:import url="components/header.jsp" />
    <div>
      <form action="addNewItemPro" method="post">
        <table border="1" style="border-collapse: collapse;">
          <tbody>
            <tr>
              <td>상품 카테고리</td>
              <td>
                <select name="item_category">
                  <option value="100">채소</option>
                  <option value="200">해산물</option>
                  <option value="300">육류</option>
                  <option value="400">가전체품</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>상품명</td>
              <td>
                <input type="text" name="item_name" id="">
              </td>
            </tr>
            <tr>
              <td>상품가격</td>
              <td>
                <input type="number" name="item_price" id="">
              </td>
            </tr>
            <tr>
              <td>상품재고</td>
              <td>
                <input type="number" name="item_stock" id="">
              </td>
            </tr>
            <tr>
              <td>이미지</td>
              <td>
                <input type="file" name="item_image" id="">
              </td>
            </tr>
            <tr>
              <td>상품정보</td>
              <td>
                <input type="text" name="item_info" id="">
              </td>
            </tr>
            <tr>
              <td>할인율</td>
              <td>
                <input type="number" name="discount_rate" id="">
              </td>
            </tr>
          </tbody>
        </table>
        <br />
        <button type="submit">상품 추가하기</button>
      </form>
    </div>
  </div>
</body>
</html>
