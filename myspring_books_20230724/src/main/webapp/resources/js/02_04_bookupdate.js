$(document).ready(function () {
  // 이미지를 포함한 상품 수정
  $("#upForm1").ajaxForm({
    // 업로드에 성공하면 수행
    success: function (data, status) {
      location.href = "managerBookList.do?book_kind=all";
    },
  });

  $("#bookMain").click(function () {
    location.href = "managerMain.do";
  });

  $("#bookList").click(function () {
    location.href = "managerBookList.do?book_kind=all";
  });
});
