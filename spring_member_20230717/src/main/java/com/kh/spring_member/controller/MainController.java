package com.kh.spring_member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
  @RequestMapping(value = "/main", method = RequestMethod.GET)
  public String main(Model model) {
    return "main";
  }
}
