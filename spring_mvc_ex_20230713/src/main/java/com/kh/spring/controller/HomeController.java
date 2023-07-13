package com.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  // 어떤 서블릿 즉 어떤 컨트롤러로 이동을 해야하는지
  // request 요청을 하면 URL

  @RequestMapping("/hello")
  public String hello() {
    System.out.println("hello");

    // 결과가 나오면 실행할 페이지명을 넘겨준다
    // 실제 데이터가 넘어갈 수도 있다
    return "/WEB-INF/hello.jsp";
  }

  // URL 요청을 받아서 구별을 했으면 실제 서블릿들의 객체를 생성해서 실행
  // WEB-INF/spring/root-context.xml 파일이 실행해 준다
  //   이 파일 안에 객체를 실행하는 Bean을 설정해야 한다

  // 위에 있는 내용까지만 설정하면 404 페이지 오류가 뜬다
  // 보여지는 뷰 페이지가 없기 때문에 오류가 난다
  // 뷰가 가지고 있는 JSP 파일명을 넘겨줘야한다

  // 만약 서블릿을 실행하고 나서 결과값을 저장하는 내용을 써야할 때
  @RequestMapping("/hello5")
  public String hello5(Model model) {
    // 실제 데이터의 결과값들이 model에서 넘어온다
    // model이라는 객체를 만들어서 실제 저장
    // request.setArttibute() 저장을 해서 뷰로 포워드 시켜준다
    // 현재 페이지에서 저장한 내용을 다음 페이지까지는 데이터가 유지된다
    model.addAttribute("name", "홍길동");

    // 페이지명
    return "hello5";
  }
}
