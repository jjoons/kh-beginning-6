// 책 등록 버튼 클릭
//   [관리자 메인으로] 버튼 클릭
$(document).ready(function () {
  $("#regist").click(function () {
    location.href = "managerBookRegister.do";
  });

  $("#bookMain").click(function () {
    location.href = "managerMain.do";
  });
});

// 수정 버튼을 클릭하면 자동 실행
function edit(editBtn) {
  // 실제 수정할 데이터(글 번호) 글의 종류
}

// 삭제 버튼을 클릭하면 자동 실행
function del(delBtn) {
  // 삭제할 데이터의 글 번호와 글 종류
}
