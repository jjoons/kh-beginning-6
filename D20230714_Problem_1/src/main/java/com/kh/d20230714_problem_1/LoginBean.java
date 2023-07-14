package com.kh.d20230714_problem_1;

import java.util.Objects;

public class LoginBean {
  private String id;
  private String pw;

  public LoginBean() {}

  public LoginBean(String id, String pw) {
    this.id = id;
    this.pw = pw;
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

  @Override
  public int hashCode() {
    return Objects.hash(id, pw);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LoginBean other = (LoginBean) obj;
    return Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
  }

  @Override
  public String toString() {
    return "LoginBean [id=" + id + ", pw=" + pw + "]";
  }
}
