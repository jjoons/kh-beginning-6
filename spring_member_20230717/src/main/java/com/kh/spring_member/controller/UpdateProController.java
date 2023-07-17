package com.kh.spring_member.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kh.spring_member.service.MemberService;

@Controller
public class UpdateProController {
  @Autowired
  private MemberService service;

  @RequestMapping(value = "/update_pro", method = RequestMethod.POST)
  public String updatePro(HttpSession session, String id, String password) {
    String id = (String) session.getAttribute("id");

    if (id == null) {
      return "redirect:main";
    }

    boolean result = this.service.update(id, password);


  }
}
