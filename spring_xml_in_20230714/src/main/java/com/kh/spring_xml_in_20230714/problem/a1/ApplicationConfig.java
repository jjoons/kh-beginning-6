package com.kh.spring_xml_in_20230714.problem.a1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:problem/a1/application_context.xml")
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
