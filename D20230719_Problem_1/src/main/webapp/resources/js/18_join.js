/*
 */

var contextPath = location.pathname.substring(
  0,
  location.pathname.indexOf("/", 2)
);

$(document).ready(function () {
  // 아이디 체크 (중복 확인)

  // 이메일 중복 체크

  // 회원가입 클릭 시
  $("#join").click(function () {
    // 혹시 입력 칸이 비어있는지 확인
    checkInfo();

    // status는 만약 위에서 checkInfo() 메소드에서 하나라도 false가 나오면
    // 빈 칸이 존재하기 때문에 통신을 하면 안 된다 (전송)
    if (status) {
      $.ajax({
        type: "POST",
        url: contextPath + "/joinPro.do",
        data: {
          id: $("#id").val(),
          pw: $("#pw").val(),
          name: $("#name").val(),
          tel: $("#tel").val(),
          address: $("#address").val(),
          email: $("#email").val(),
        },
        success: function (data) {
          alert("회원가입이 완료되었습니다");

          // 이동하는 주소 /index
          location.href = "";
        },
        error: function (data) {
          alert("error");
        },
      });
    }
  });
});

function checkInfo() {
  if (!$("#id").val()) {
  }
  if (!$("#pw").val()) {
  }
  if (!$("#name").val()) {
  }
  if (!$("#tel").val()) {
  }
  if (!$("#address").val()) {
  }
  if (!$("#email").val()) {
  }
}
