<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Insert title here</title>
</head>
<body>
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
