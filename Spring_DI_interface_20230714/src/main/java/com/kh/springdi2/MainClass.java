package com.kh.springdi2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
  // XML 파일에서 받아오는 내용으로 빈 객체 가져오기
  public static void main(String[] args) {
    AbstractApplicationContext ctx =
        new GenericXmlApplicationContext("classpath:applicationCTX.xml");
    MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
    myInfo.getMyInfo();
  }
}
