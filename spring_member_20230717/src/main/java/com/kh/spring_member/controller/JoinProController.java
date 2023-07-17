package com.kh.spring_member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kh.spring_member.service.MemberService;

@Controller
public class JoinProController {
  @Autowired
  private MemberService service;

  @RequestMapping(value = "/join_pro", method = RequestMethod.POST)
  public String joinPro(Model model, String id, String password, String email) {
    boolean result = this.service.join(id, password, email);
    model.addAttribute("result", result);

    return "joinPro";
  }
}
