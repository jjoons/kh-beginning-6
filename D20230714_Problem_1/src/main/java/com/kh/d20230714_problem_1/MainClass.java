package com.kh.d20230714_problem_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(ApplicationConfig.class);
    LoginBean bean = ctx.getBean("login", LoginBean.class);
    System.out.println(bean);

    bean = ctx.getBean("login2", LoginBean.class);
    System.out.println(bean);
  }
}
