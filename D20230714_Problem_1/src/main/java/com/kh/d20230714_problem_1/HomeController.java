package com.kh.d20230714_problem_1;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    return "home";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(Model model, @RequestParam(value = "user_id") String userId,
      @RequestParam("user_pw") String userPw) {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(ApplicationConfig.class);
    LoginBean bean = ctx.getBean("login", LoginBean.class);

    if (bean.getId().equals(userId) && bean.getPw().equals(userPw)) {
      model.addAttribute("result", "로그인 성공");
    } else {
      model.addAttribute("result", "로그인 실패");
    }

    return "login";
  }
}
