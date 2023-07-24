package com.kh.d20230719_problem_1.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOHelper {
  @Autowired
  private DataSource dataSource;

  public int selectAllCount(String sql) {
    ResultSet rs = null;

    try (Connection con = this.dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      rs = ps.executeQuery();

      if (rs.next()) {
        return rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
      } catch (SQLException e) {
      }
    }

    return -1;
  }
}
