$(document).ready(function () {
  /*
    회원가입 버튼을 클릭하면 서블릿으로 매핑시킬 수 있도록
    href 이용해서 원하는 주소로 보내기
   */
  /*
   * 로그인 버튼
   *  비동기식 처리한다. 로그인의 정보들을 보내서 확인
   *  type: POST
   *  url: loginPro.do
   *  data: id, pw
   *  success: 콜백함수
   *    만약 check를 이용해서 1이 나오면 로그인 성공 후 main.do
   *    틀리면 아이디가 틀린지 비밀번호가 틀린지 확인한다
   */
  $("#loginBtn").click(function () {
    $.ajax({
      type: "POST",
      url: "loginPro.do",
      data: {
        id: id,
        pw: pw,
      },
      success: function (data) {},
    });
  });
  // 회원정보변경 버튼을 클릭했을 때
  /*
   * 로그아웃 버튼을 클릭했을 때
   *   비동기식 처리한다
   *   type: ?
   *   url: logout.do
   *   success: 콜백함수
   *     main.do
   */
  /*
   * 장바구니 버튼 클릭
   *   /shoppingmall/cartList.do
   */
});
