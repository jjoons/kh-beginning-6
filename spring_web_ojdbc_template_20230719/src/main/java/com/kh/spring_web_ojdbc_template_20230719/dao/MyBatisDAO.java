package com.kh.spring_web_ojdbc_template_20230719.dao;

import com.kh.spring_web_ojdbc_template_20230719.vo.MvcBoardVO;

/*
 * mapper 연결에 사용하는 인터페이스
 * 이 인터페이스의 풀 패키지 이름을 mvcboard.xml 파일의 namespace에 정확히 적어야 한다
 */
public interface MyBatisDAO {
  /*
   * mapper로 사용되는 인터페이스의 추상 메소드의 형식 resultType id(parameterType)
   * 과 같은 형식이다
   * MyBatisDAO 인터페이스의 추상 메소드 이름이 XML 파일의 SQL 명령을 식별하는 id로 사용되고
   * 추상 메소드의 인수로 전달된 데이터가 XML 파일의 SQL 명령으로 전달된다
   */
  void insert(MvcBoardVO mvcBoardVO);
}
