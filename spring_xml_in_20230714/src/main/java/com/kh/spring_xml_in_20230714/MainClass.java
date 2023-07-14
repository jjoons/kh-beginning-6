package com.kh.spring_xml_in_20230714;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
  public static void main(String[] args) {
    /*
     * 어노테이션을 이용해서 bean을 생성했을 때
     * spring에서는 XML 클래스로 받는 것이 아니라
     * 새로운 클래스로 저장해야한다
     */
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(ApplicationConfig.class);

    // getBean("메소드이름", 메소드의 리턴 타입.class)
    Student student = ctx.getBean("student", Student.class);

    System.out.println(student.getName());
  }
}
