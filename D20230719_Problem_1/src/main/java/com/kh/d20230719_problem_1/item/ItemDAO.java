package com.kh.d20230719_problem_1.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh.d20230719_problem_1.helper.DAOHelper;

public class ItemDAO {
  private DataSource dataSource;

  @Autowired
  private DAOHelper daoHelper;

  public int getLastNum() {
    String sql = "SELECT MAX(item_number) FROM item";
    return daoHelper.selectAllCount(sql);
  }

  public int insertItem(ItemDTO dto) {
    String sql = "INSERT INTO item (item_number, item_category, item_name, item_price,"
        + " item_stock, item_image, item_info, discount_rate, reg_date, sold)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = this.dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, dto.getItem_number());
      ps.setString(2, dto.getItem_category());
      ps.setString(3, dto.getItem_name());
      ps.setInt(4, dto.getItem_price());
      ps.setInt(5, dto.getItem_stock());
      ps.setString(6, dto.getItem_image());
      ps.setString(7, dto.getItem_info());
      ps.setInt(8, dto.getDiscount_rate());
      ps.setString(9, dto.getReg_date());
      ps.setInt(10, dto.getSold());

      return ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }
}
