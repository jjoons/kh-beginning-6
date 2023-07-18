package com.kh.spring_member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String root() {
    return "redirect:/member/index";
  }
}
