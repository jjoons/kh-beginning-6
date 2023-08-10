package com.kh.spring_legacy.d20230810_problem_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
  @RequestMapping(value = "/")
  public String index() {
    return "index";
  }
}
