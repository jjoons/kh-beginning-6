package com.kh.d20230719_problem_1.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh.d20230719_problem_1.helper.DAOHelper;

public class ItemDAO {
  private DataSource dataSource;

  @Autowired
  private DAOHelper daoHelper;

  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

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

  public ArrayList<ItemDTO> getAllItemList() {
    ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

    try {
      conn = dataSource.getConnection();

      String sql = "SELECT * FROM item";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ItemDTO dto = new ItemDTO();

        dto.setItem_number(rs.getInt("item_number"));
        dto.setItem_category(rs.getString("item_category"));
        dto.setItem_name(rs.getString("item_name"));
        dto.setItem_price(rs.getInt("item_price"));
        dto.setItem_stock(rs.getInt("item_stock"));
        dto.setItem_image(rs.getString("item_image"));
        dto.setItem_info(rs.getString("Item_info"));
        dto.setDiscount_rate(rs.getInt("discount_rate"));
        dto.setReg_date(rs.getString("reg_date"));
        dto.setSold(rs.getInt("sold"));

        itemList.add(dto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }

    return itemList;
  }

  public ArrayList<ItemDTO> getAllItem() {
    ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

    try {
      conn = dataSource.getConnection();

      String sql = "SELECT * FROM item";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ItemDTO dto = new ItemDTO();

        dto.setItem_number(rs.getInt("item_number"));
        dto.setItem_category(rs.getString("item_category"));
        dto.setItem_name(rs.getString("item_name"));
        dto.setItem_price(rs.getInt("item_price"));
        dto.setItem_stock(rs.getInt("item_stock"));
        dto.setItem_image(rs.getString("item_image"));
        dto.setItem_info(rs.getString("Item_info"));
        dto.setDiscount_rate(rs.getInt("discount_rate"));
        dto.setReg_date(rs.getString("reg_date"));
        dto.setSold(rs.getInt("sold"));

        itemList.add(dto);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }

    return itemList;
  }

  public ItemDTO getOneItem(int item_num) {
    ItemDTO dto = new ItemDTO();

    try {
      conn = dataSource.getConnection();

      String sql = "SELECT * FROM item WHERE item_number=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, item_num);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setItem_number(rs.getInt("item_number"));
        dto.setItem_category(rs.getString("item_category"));
        dto.setItem_name(rs.getString("item_name"));
        dto.setItem_price(rs.getInt("item_price"));
        dto.setItem_stock(rs.getInt("item_stock"));
        dto.setItem_image(rs.getString("item_image"));
        dto.setItem_info(rs.getString("Item_info"));
        dto.setDiscount_rate(rs.getInt("discount_rate"));
        dto.setReg_date(rs.getString("reg_date"));
        dto.setSold(rs.getInt("sold"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }
    return dto;
  }

  public ArrayList<ItemDTO> getNewItem() {
    ArrayList<ItemDTO> newList = new ArrayList<ItemDTO>();

    try {
      conn = dataSource.getConnection();

      String sql = "SELECT * FROM item ORDER BY reg_date DESC";
      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      int i = 0;
      while (rs.next()) {

        ItemDTO dto = new ItemDTO();

        dto.setItem_number(rs.getInt("item_number"));
        dto.setItem_category(rs.getString("item_category"));
        dto.setItem_name(rs.getString("item_name"));
        dto.setItem_price(rs.getInt("item_price"));
        dto.setItem_stock(rs.getInt("item_stock"));
        dto.setItem_image(rs.getString("item_image"));
        dto.setItem_info(rs.getString("Item_info"));
        dto.setDiscount_rate(rs.getInt("discount_rate"));
        dto.setReg_date(rs.getString("reg_date"));
        dto.setSold(rs.getInt("sold"));

        newList.add(dto);
        i++;

        if (i > 2)
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }

    return newList;
  }

  public ArrayList<ItemDTO> getBestItem() {
    ArrayList<ItemDTO> bestList = new ArrayList<ItemDTO>();

    try {
      conn = dataSource.getConnection();

      String sql = "SELECT * FROM item ORDER BY sold DESC";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      int i = 0;
      while (rs.next()) {
        ItemDTO dto = new ItemDTO();

        dto.setItem_number(rs.getInt("item_number"));
        dto.setItem_category(rs.getString("item_category"));
        dto.setItem_name(rs.getString("item_name"));
        dto.setItem_price(rs.getInt("item_price"));
        dto.setItem_stock(rs.getInt("item_stock"));
        dto.setItem_image(rs.getString("item_image"));
        dto.setItem_info(rs.getString("Item_info"));
        dto.setDiscount_rate(rs.getInt("discount_rate"));
        dto.setReg_date(rs.getString("reg_date"));
        dto.setSold(rs.getInt("sold"));

        bestList.add(dto);
        i++;

        if (i > 2)
          break;
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }

    return bestList;
  }

  public ArrayList<ItemDTO> getDiscountedItem() {
    ArrayList<ItemDTO> discountedList = new ArrayList<ItemDTO>();

    try {
      conn = dataSource.getConnection();

      String sql = "SELECT * FROM item WHERE discount_rate >= 20";
      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        ItemDTO dto = new ItemDTO();

        dto.setItem_number(rs.getInt("item_number"));
        dto.setItem_category(rs.getString("item_category"));
        dto.setItem_name(rs.getString("item_name"));
        dto.setItem_price(rs.getInt("item_price"));
        dto.setItem_stock(rs.getInt("item_stock"));
        dto.setItem_image(rs.getString("item_image"));
        dto.setItem_info(rs.getString("Item_info"));
        dto.setDiscount_rate(rs.getInt("discount_rate"));
        dto.setReg_date(rs.getString("reg_date"));
        dto.setSold(rs.getInt("sold"));

        discountedList.add(dto);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
        }
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
    }

    return discountedList;
  }
}
