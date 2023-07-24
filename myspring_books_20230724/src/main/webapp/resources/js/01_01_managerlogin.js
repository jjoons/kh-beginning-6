$(document).ready(function () {
  // 로그인 버튼 클릭하면 자동 실행
  $("#login").click(function () {
    var query = {
      id: $("#id").val(),
      passwd: $("#passwd").val(),
    };

    $.ajax({
      type: "POST",
      url: "managerLoginPro.do",
      data: query,
      success: function (data) {
        location.href = "managerMain.do";
      },
    });
  });

  // 로그아웃 버튼을 클릭하면 자동 실행
  $("#logout").click(function () {
    $.ajax({
      type: "POST",
      url: "managerLogout.do",
      success: function (data) {
        location.href = "managerMain.do";
      },
    });
  });
});
