package com.kh.spring_legacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.kh.spring_legacy.service.MemberServiceImpl;

@Controller
public class MemberController {
  @Autowired
  private MemberServiceImpl memberService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String memberLogin() {
    return "index";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String memberLoginPro(Model model, @RequestParam String memberId,
      @RequestParam String memberPwd) {
    this.memberService.memberLoginPro(memberId, memberPwd, model);

    return "errorPage";
  }
}
