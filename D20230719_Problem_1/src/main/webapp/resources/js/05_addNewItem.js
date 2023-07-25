/*
String.indexOf(value, start)
  value: 필수 요소. 찾으려는 문자열을 작성한다
  start: 선택 요소. 검색을 시작할 인덱스 값이다. 입력하지 않으면 처음부터 검색한다
  대소문자 구별
  찾는 문자열이 없는 경우 -1을 반환한다
*/
/*
실제 업로드나 다운로드를 처리할 때 form 태그를 이용해서 데이터를 비동기식으로
처리할 때 ajaxForm 메소드를 이용해서 간단하게 처리할 수 있다
데이터를 자동으로 매핑해서 보내준다
*/

var contextPath = location.pathname.substring(
  0,
  location.pathname.indexOf("/", 2)
);

$(document).ready(function () {
  $("").ajaxForm({
    success: function (data) {
      alert("상품 등록 완료");
      location.href = contextPath + "/itemListForManager.do";
    },
  });
});
