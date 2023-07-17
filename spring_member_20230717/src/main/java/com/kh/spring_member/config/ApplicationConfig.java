package com.kh.spring_member.config;

import com.kh.spring_member.dao.MemberDAO;

// @Configuration
public class ApplicationConfig {
  //  @Bean
  public MemberDAO dao() {
    return new MemberDAO();
  }
}
