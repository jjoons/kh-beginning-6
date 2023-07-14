package com.kh.spring_xml_in_20230714;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean, DisposableBean {
  private String name;
  private int age;

  public Person() {}

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
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

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }

  /*
   * 스프링 빈(Bean) 생명 주기 콜백 지원하는 3가지 방법
   *   1. 인터페이스
   *   2. 설정 정보에 초기화 메소드, 종료 메소드 지정
   *   3. 어노테이션으로 지정
   */

  /*
   * 메소드에서 bean 생성(생성자 실행)된 후 자동으로 실행할 내용을 구현한다
   */
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("afterPropertiesSet()");
  }

  /*
   * DisposableBean 인터페이스 구현받으면 destory 메소드를 반드시 Override
   * 해서 사용해야하고 destory 메소드는 bean이 소멸될 때
   * (DI 컨테이너에서 close() 메소드가 실행되면) 자동으로 실행할 내용을 구현한다
   */
  @Override
  public void destroy() throws Exception {
    System.out.println("destroy()");
  }

  // 스프링 전용 인터페이스라 이름을 변경하는 건 불가능
  // 초기화 메소드, 소멸 메소드
}
