package com.kh.springdi;

public class Info {
  private String id;
  private String pw;
  private String name;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void printInfo() {
    System.out.println("Info [id=" + id + ", pw=" + pw + ", name=" + name + "]");
  }
}

// 스프링에서 의존성 주입 DI
//   객체 간 의존성을 개발자가 객체 내부에서 직접 new 연산자
//   스프링 컨테이너에서 객체를 생성해서 넣어주는 방식이다
//   

// 자바에서 사용하던 방식
// XML 파일에서 설정한 Bean 정보를 읽어들인다
// class의 bean을 설정하는 XML 파일을 만들어서 저장한다
