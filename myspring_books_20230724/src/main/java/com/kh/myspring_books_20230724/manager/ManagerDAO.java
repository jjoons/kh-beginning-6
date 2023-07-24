package com.kh.myspring_books_20230724.manager;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("managerDAO")
public class ManagerDAO {
  @Autowired
  private SqlSession sqlSession;

  // MyBatis SqlSession 객체 생성
  public int userCheck(String id, String passwd) {
    int check = -1;
    String dbpw = this.sqlSession.selectOne("mappers.manager.loginById", id);

    if (passwd.equals(dbpw)) {
      check = 1;
    }

    return check;
  }
}
