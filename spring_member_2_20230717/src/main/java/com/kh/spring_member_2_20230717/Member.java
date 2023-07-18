package com.kh.spring_member_2_20230717;

public class Member {
  private int num;
  private String id;
  private String pw;
  private String email;

  public Member() {}

  public Member(int num, String id, String pw, String email) {
    super();
    this.num = num;
    this.id = id;
    this.pw = pw;
    this.email = email;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Member [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + "]";
  }
}
