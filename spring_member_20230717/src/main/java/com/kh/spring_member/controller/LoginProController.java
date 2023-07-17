package com.kh.spring_member.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kh.spring_member.service.MemberService;

@Controller
public class LoginProController {
  @Autowired
  private MemberService service;

  @RequestMapping(value = "/login_pro", method = RequestMethod.POST)
  public String loginPro(Model model, HttpSession session, String id, String password) {
    boolean result = this.service.login(id, password);

    if (result) {
      session.setAttribute("id", id);
      return "redirect:update";
    }

    return "loginProFail";
  }
}
