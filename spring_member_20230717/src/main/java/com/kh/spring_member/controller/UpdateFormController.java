package com.kh.spring_member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateFormController {
  @RequestMapping("/update")
  public String updateForm() {
    return "updateForm";
  }
}
