package com.kh.spring_legacy.spring_di_mybatis_20230810.controller;

import java.lang.reflect.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
  @RequestMapping(value = "/member/index.do", method = RequestMethod.GET)
  public String memberIndex() {
    return "member/index";
  }

  /*
   * 회원가입
   *   실제 데이터를 저장하는 공간
   *   MyBatis를 이용해 데이터 저장
   */
  @RequestMapping(value = "/member/memberEnroll.do")
  public String memberEnroll(Model model, Member m) {
    System.out.println();

    return;
  }

  @RequestMapping(value = "/member/memberList.do", method = RequestMethod.GET)
  public String memberList() {
    return "member/memberList";
  }

  @RequestMapping(value = "/member/error.do")
  public String errorPage(String msg) {
    System.out.println("오류 발생 로그 출력");

    return "common/error";
  }
}
