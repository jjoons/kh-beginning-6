package com.kh.spring_member_2_20230717;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * Spring이 가지고 있는 Spring Exception으로 전환하기 위해서 @Repository를 사용한다
 */
@Repository
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

  public int checkMember(Member member) {
    int check = -1;

    try {
      this.conn = this.dataSource.getConnection();

      // SQL 명령문 작성하고 id, pw 넘기기
      String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";

      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setString(1, member.getId());
      this.pstmt.setString(2, member.getPw());

      // executeQuery()
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        check = 1;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.finallyClose();
    }

    return check;
  }

  /*
   * 데이터베이스에서 회원 정보를 가지고 온다
   */
  public ArrayList<Member> getMemberList() {
    ArrayList<Member> memberList = new ArrayList<>();
    String sql = "SELECT * FROM member";

    try {
      this.conn = this.dataSource.getConnection();

      // 명령문 쓰고 데이터 가지고 오는 SQL문 작성
      this.pstmt = this.conn.prepareStatement(sql);
      this.rs = this.pstmt.executeQuery();

      while (this.rs.next()) {
        int num = this.rs.getInt("num");
        String id = this.rs.getString("id");
        String pw = this.rs.getString("pw");
        String email = this.rs.getString("email");

        // 하나씩 List에 담는다
        Member member = new Member(num, id, pw, email);
        memberList.add(member);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      finallyClose();
    }

    return memberList;
  }

  public Member getOneMember(String id) {
    String sql = "SELECT * FROM member WHERE id = ?";

    try {
      this.conn = this.dataSource.getConnection();
      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setString(1, id);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        int num = this.rs.getInt("num");
        String id1 = this.rs.getString("id");
        String pw = this.rs.getString("pw");
        String email = this.rs.getString("email");

        return new Member(num, id1, pw, email);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.finallyClose();
    }

    return null;
  }

  public int updateMember(Member member) {
    String sql = "UPDATE member SET pw = ?, email = ? WHERE id = ?";

    try {
      this.conn = this.dataSource.getConnection();
      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setString(1, member.getPw());
      this.pstmt.setString(2, member.getEmail());
      this.pstmt.setString(3, member.getId());

      return this.pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
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
