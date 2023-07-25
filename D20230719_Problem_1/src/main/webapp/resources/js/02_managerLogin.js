$(document).ready(function () {
  // 로그인 버튼 클릭했을 때
  $("#").click(function () {
    var query = {
      id: $("#id").val(),
      pw: $("#pw").val(),
    };

    $.ajax({
      type: "POST",
      url: contextPath + "/managerLoginPro.do",
      data: query,
      success: function (data) {},
    });
  });

  /*
  로그아웃 버튼 넣기
  */
  $().click(function () {
    $.ajax({
      type: "POST",
      url: contextPath + "managerLogout.do",
      success: function () {
        location.href = contextPath + "/managerMain.do";
      },
    });
  });
});
