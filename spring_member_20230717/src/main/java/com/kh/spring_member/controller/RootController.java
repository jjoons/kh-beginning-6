package com.kh.spring_member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RootController {
  @RequestMapping("/")
  public String root() {
    return "redirect:main";
  }
}
