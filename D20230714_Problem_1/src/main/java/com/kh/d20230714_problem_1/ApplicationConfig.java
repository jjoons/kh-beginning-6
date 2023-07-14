package com.kh.d20230714_problem_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @ImportResource("classpath:problem/a1/application_context.xml")
@Configuration
public class ApplicationConfig {
  @Bean
  public LoginBean login() {
    LoginBean loginBean = new LoginBean();
    loginBean.setId("admin");
    loginBean.setPw("1234");

    return loginBean;
  }
}
