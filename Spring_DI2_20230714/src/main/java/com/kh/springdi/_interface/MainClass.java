package com.kh.springdi._interface;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
  public static void main(String[] args) {
    /*
     * 스프링 컨테이너 종류
     *   - Bean Factory
     *     - 스프링 설정 파일에 등록된 Bean 객체를 생성하고 관리하는 기본적인 기능만 한다
     *     - 클라이언트 요청에 의해서 Bean 객체가 사용되는 시점에 객체를 생성하는 방식
     *   - ApplicationContext (Bean Factory 상속)
     *     - Bean Factory와 똑같은 기능
     *     - 메시지 기반의 다국어 처리, AOP 처리, 트랜젝션 관리
     *     - 컨테이너가 구동되는 시점에 객체들이 생성되는 방식
     */

    /*
     * GenericXmlApplicationContext
     *   파일 시스템이나 클래스 경로에 있는 XML 파일을 로딩하여 구동하는 컨테이너
     *   
     * MVC 구조는 대부분 XmlApplicationContext
     * 웹 기반의 스프링 어플리케이션을 개발할 때 사용하는 컨테이너
     */

    AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:pencilCtx.xml");

    Pencil pencil = ctx.getBean("pencil4B", Pencil4B.class);
    pencil.use();

    pencil = ctx.getBean("pencilH4B", PencilH4B.class);
    pencil.use();

    pencil = ctx.getBean("pencilHB", PencilHB.class);
    pencil.use();
  }
}
