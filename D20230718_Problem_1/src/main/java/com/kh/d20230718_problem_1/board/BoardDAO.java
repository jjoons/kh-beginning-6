package com.kh.d20230718_problem_1.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDAO {
  @Autowired
  private DataSource dataSource;

  public List<Board> getBoardList(int limit, int offset) {
    List<Board> list = null;
    String sql = "SELECT * FROM board ORDER BY num DESC LIMIT ? OFFSET ?";

    ResultSet rs = null;

    try (Connection con = this.dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
      ps.setInt(1, limit);
      ps.setInt(2, offset);
      rs = ps.executeQuery();
      list = new ArrayList<>();

      while (rs.next()) {
        Board board = BoardUtil.resultSetToBoard(rs);
        list.add(board);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  public Board getBoardById(int num) {
    String sql = "SELECT * FROM board WHERE num = ?";

    ResultSet rs = null;

    try (Connection con = this.dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
      ps.setInt(1, num);
      rs = ps.executeQuery();

      if (rs.next()) {
        return BoardUtil.resultSetToBoard(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public int increaseReadCount(int num) {
    String sql = "UPDATE board SET readcount = readcount + 1 WHERE num = ?";

    try (Connection con = this.dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
      ps.setInt(1, num);

      return ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public int insertBoard(Board board) {
    ResultSet rs = null;
    int ref = 0;

    String refSql = "SELECT MAX(ref) FROM board";
    String sql = "INSERT INTO board (writer, email, subject, "
        + "password, reg_date, ref, re_step, re_level, "
        + "readcount, content) VALUES(?, ?, ?, ?, now(), ?, 1, 1, 0, ?)";

    try (Connection conn = this.dataSource.getConnection();
        PreparedStatement pstmtRef = conn.prepareStatement(refSql);
        PreparedStatement pstmt = conn.prepareStatement(sql);) {
      rs = pstmtRef.executeQuery();
      if (rs.next()) {
        ref = rs.getInt(1) + 1;
      }

      pstmt.setString(1, board.getWriter());
      pstmt.setString(2, board.getEmail());
      pstmt.setString(3, board.getSubject());
      pstmt.setString(4, board.getPassword());
      pstmt.setInt(5, ref);
      pstmt.setString(6, board.getContent());

      return pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public void close(ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
