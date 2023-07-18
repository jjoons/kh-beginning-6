package com.kh.spring_member_2_20230717;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
  @Autowired
  private MemberDAO dao;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String root() {
    return "redirect:/member/index";
  }

  // key
  @ModelAttribute("cp")
  public String getContextPath(HttpServletRequest req) {
    /*
     * 모델 객체에 Controller에서 생성된 데이터를 담아서
     * view에 전달할 때 사용하는 객체이다
     */

    // @ModelAttribute("cp") 자동으로 매핑시켜준다
    //    String cp = req.getContextPath();
    //    model.addAttribute("cp", cp);
    // view 전달

    return req.getContextPath();
  }

  @RequestMapping(value = "/member/userMenu")
  public String userMenu() {
    System.out.println("===== userMenu =====");

    return "member/userMenu";
  }

  @RequestMapping(value = "/member/joinForm")
  public String joinForm() {
    System.out.println("===== joinForm =====");

    // 뷰 페이지 연결
    return "member/joinForm";
  }

  /*
   * 회원가입을 하면 처리하는 내용
   * 새로운 페이지로 요청하면 된다 list 화면으로 넘어갈 것
   */
  @RequestMapping(value = "/member/joinPro", method = RequestMethod.POST)
  public String joinPro(Member member) {
    System.out.println("===== joinPro =====");

    // 입력한 멤버의 정보를 받아와서 실제 데이터베이스에 저장하는 메소드
    // DAO 가서 member를 저장하는 내용 실행하는 메소드 호출
    this.dao.memberJoin(member);

    // 새로운 페이지 즉 새로운 컨트롤러 요청을 해야 한다
    return "redirect:/member/list";
  }

  @RequestMapping(value = "/member/loginForm")
  public String loginForm() {
    System.out.println("===== loginForm =====");

    return "member/loginForm";
  }
}
