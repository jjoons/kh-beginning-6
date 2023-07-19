package com.kh.spring_web_ojdbc_template_20230719;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
  /*
   * MvcBoardDAO 클래스에서 사용할 수 있도록 설정
   * public, static 데이터베이스에 접근하는 객체는 하나만 존재 (싱글톤)
   */
  public static JdbcTemplate template;
}
