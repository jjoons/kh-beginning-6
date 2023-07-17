package com.kh.springProperties;

/*
 * AdminConnection 클래시의 bean이 생성되는 순간 admin.properties 파일의 내용을
 * 읽어서 필드에 저장한다
 */
public class AdminConnection {
  // admin.id
  private String adminId;
  // admin.pw
  private String adminPw;

  public AdminConnection() {}

  public AdminConnection(String adminId, String adminPw) {
    this.adminId = adminId;
    this.adminPw = adminPw;
  }

  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public String getAdminPw() {
    return adminPw;
  }

  public void setAdminPw(String adminPw) {
    this.adminPw = adminPw;
  }
}
