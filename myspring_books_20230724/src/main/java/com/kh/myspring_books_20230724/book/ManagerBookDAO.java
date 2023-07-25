package com.kh.myspring_books_20230724.book;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerBookDAO {
  // 데이터베이스의 인증 정보를 가지고 와서 실제 데이터베이스 안으로 들어갈 수 있도록 객체 생성
  @Autowired
  private SqlSession sqlSession;

  public int getBookCount() {
    int count = -1;
    count = sqlSession.selectOne("getBookCount");

    return count;
  }

  public List<ManagerBookVO> getBooks(String book_kind) {
    List<ManagerBookVO> bookList = null;

    if (book_kind.equals("all")) {
      bookList = sqlSession.selectList("selectKindList", book_kind);
    }

    return bookList;
  }
}
