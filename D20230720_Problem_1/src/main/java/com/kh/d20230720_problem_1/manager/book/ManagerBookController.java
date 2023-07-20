package com.kh.d20230720_problem_1.manager.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerBookController {
  @Autowired
  private ManagerBookDAO managerBookDAO;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String loginForm() {

  }
}
