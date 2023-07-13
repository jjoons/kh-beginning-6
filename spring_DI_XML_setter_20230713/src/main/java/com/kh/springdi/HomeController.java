package com.kh.springdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String home(Model model) {
    model.addAttribute("name", "홍길동");

    return "home";
  }
}
