package com.kh.d20230718_problem_1.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "redirect:/board/";
  }
}
