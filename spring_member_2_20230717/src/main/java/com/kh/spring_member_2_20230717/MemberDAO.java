package com.kh.spring_member_2_20230717;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAO {
  /*
   * DB를 연결해 주는 역할을 한다
   * 커넥션 정보를 담고 있으며 빈으로 등록하여 인자로 넘겨준다
   */
  @Autowired
  private DataSource dataSource;
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

  public void memberJoin(Member member) {
    // 데이터베이스 연결 getConnect()
    try {
      this.conn = this.dataSource.getConnection();

      // 명령문 컴파일하고 실제 데이터들 ? 채우고 쿼리 날리기
      String sql = "INSERT INTO member(id, pw, email) VALUES (?, ?, ?)";
      this.pstmt = this.conn.prepareStatement(sql);
      pstmt.setString(1, member.getId());
      pstmt.setString(2, member.getPw());
      pstmt.setString(3, member.getEmail());

      this.pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.finallyClose();
    }
  }

  public void finallyClose() {
    try {
      if (this.pstmt != null) {
        this.pstmt.close();
      }
      if (this.conn != null) {
        this.conn.close();
      }
      if (this.rs != null) {
        this.rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

/*
 * org.apache.commons.dbcp2.BasicDataSource
 * 
 * DB Connection Pool
 *   자바 프로그램에서 데이터베이스 연결(커넥션 객체를 얻어오는 것)할 때마다 생성해서 가져오려면 오래 걸림
 *   일정량의 Connection 객체를 미리 만들어서 저장해 두었다가 요청 시 꺼내쓴다
 *   속도, 처리 능력이 좋아진다
 * 
 * 여러 개의 Connection 객체를 관리하는 Connection Pool
 * 커넥션 풀에서 꺼내서 사용이 끝나면 꼭 반납해야한다
 */

/*
 * JDBC Template
 *   Spring JDBC 접근하는 방법 중 하나이다
 *   JDBC Template을 이용해서 커넥션 연결, 종료와 같은 세부적인 작업을
 *   개발자가 직접하지 않아도 된다 DataSource 설정
 */
