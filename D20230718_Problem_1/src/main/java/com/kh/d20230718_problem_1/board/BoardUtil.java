package com.kh.d20230718_problem_1.board;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardUtil {
  public static Board resultSetToBoard(ResultSet rs) {

    try {
      Board board = new Board();

      int num = rs.getInt("num");
      String writer = rs.getString("writer");
      String email = rs.getString("email");
      String subject = rs.getString("subject");
      String password = rs.getString("password");
      Date regDate = rs.getDate("reg_date");
      int ref = rs.getInt("ref");
      int reStep = rs.getInt("re_step");
      int reLevel = rs.getInt("re_level");
      int readCount = rs.getInt("readcount");
      String content = rs.getString("content");

      board.setNum(num);
      board.setWriter(writer);
      board.setEmail(email);
      board.setSubject(subject);
      board.setPassword(password);
      board.setReg_date(regDate);
      board.setRef(ref);
      board.setRe_step(reStep);
      board.setRe_level(reLevel);
      board.setReadcount(readCount);
      board.setContent(content);

      return board;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }
}
