package com.kh.spring_legacy.spring_di_mybatis_20230810.model.vo;

public class Member {
  private long no;
  private String id;
  private String password;
  private String name;
  private int age;
  private String email;
  private String tel;
  private String address;
  private String gender;
  private String hobbies;

  public Member() {}

  public Member(
      long no,
      String id,
      String password,
      String name,
      int age,
      String email,
      String tel,
      String address,
      String gender,
      String hobbies) {
    this.no = no;
    this.id = id;
    this.password = password;
    this.name = name;
    this.age = age;
    this.email = email;
    this.tel = tel;
    this.address = address;
    this.gender = gender;
    this.hobbies = hobbies;
  }

  public long getNo() {
    return no;
  }

  public void setNo(long no) {
    this.no = no;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHobbies() {
    return hobbies;
  }

  public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
  }

  @Override
  public String toString() {
    return "AccountDTO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name
        + ", age=" + age + ", email=" + email + ", tel=" + tel + ", address=" + address
        + ", gender=" + gender + ", hobbies=" + hobbies + "]";
  }
}
