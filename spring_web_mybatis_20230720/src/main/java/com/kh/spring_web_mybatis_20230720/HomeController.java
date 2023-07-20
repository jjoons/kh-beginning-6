package com.kh.spring_web_mybatis_20230720;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  @RequestMapping("/")
  public String home() {
    return "redirect:/member/listMembers";
  }
}
