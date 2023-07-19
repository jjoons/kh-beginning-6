package com.kh.d20230719_problem_1.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh.d20230719_problem_1.helper.DAOHelper;

public class ManagerDAO {
  @Autowired
  private DataSource dataSource;

  @Autowired
  private DAOHelper daoHelper;

  public int checkIdPassword(String id, String password) {
    String sql = "SELECT COUNT(*) FROM manager WHERE id = ? AND pw = ?";
    ResultSet rs = null;

    try (Connection con = this.dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, id);
      ps.setString(2, password);
      rs = ps.executeQuery();

      if (rs.next()) {
        return rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public int totalCustomerCount() {
    String sql = "SELECT COUNT(*) FROM customer";
    return this.daoHelper.selectAllCount(sql);
  }

  public int totalItemCount() {
    String sql = "SELECT COUNT(*) FROM item";
    return this.daoHelper.selectAllCount(sql);
  }
}
