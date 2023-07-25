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

  public void insert(ManagerBookVO book) {
    /*
     * 기존에 게시글 수가 몇 개인지 가져오는 SQL 명령문을 실행하고
     * 개수를 저장하고 새로운 게시글 + 1 해서 insert("sql id", "객체")
     * 
     */
    int num = sqlSession.selectOne("mapper.manager.getBookCount");
    num += 1;

    sqlSession.insert("mapper.manager.");
  }
}
