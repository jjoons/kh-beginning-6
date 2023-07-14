package com.kh.springdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
  public static void main(String[] args) {
    /*
      MyCalculator myCalculator = new MyCalculator();
      myCalculator.setFirstNum(8);
      myCalculator.setSecondNum(5);
    
      Calculator calculator = new Calculator();
      myCalculator.setCalculator(calculator);
    */

    /*
     * XML 파일에서 설정한 bean 설정 정보를 읽어 들인다
     * bean에 대해서 얻어온다
     * 
     * applicationCTX.xml 파일이 위치한 경로 src/main/resources 를 classpath라고 부른다
     * 
     * GenericXmlApplicationContext 클래스는 생성자의 인수로
     * bean을 설정한 XML 파일의 경로와 이름을 넣어주면
     * XML 파일의 내용을 읽어서 Java 객체로 변환한 후
     * 부모 클래스인 AbstractApplicationContext 클래스의 객체에 저장한다
     * 
     * Spring IOC 컨테이너가 관리하는 자바 객체
     * 등록하는 방법: 어노테이션, XML 파일을 이용해서 등록
     */
    String configLocation = "classpath:applicationCTX.xml";

    AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);

    /*
     * getBean() 메소드로 AbstractApplicationContext 클래스 타입의 객체 ctx에 저장된 bean을 얻어온다
     *   getBean("얻어올 bean id", bean을 생성한 클래스의 이름.class);
     * 
     * MyCalculator myCalculator = (MyCalculator) ctx.getBean("myCalculator");
     */

    MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
    System.out.println(myCalculator);

    myCalculator.add();
    myCalculator.sub();
    myCalculator.mul();
    myCalculator.div();
  }
}


// 의존적이다 라는 예

//class B{
//	
//	public void show() {}
//}
//
//// A라는 객체를 생성할 때 B를 무조건 생성을 해야된다. 
//// 이런 문장을 보고 의존적으로 
//// B에 대한 객체의 내용이 변경되면 A안에 있는 메서드 호출 내용도 변경을 해야된다. 
//
//class A{
//	
//	B b = new B();
//	
//	public void show() {
//		b.show();
//	}
//}

/*
 * 
 */
