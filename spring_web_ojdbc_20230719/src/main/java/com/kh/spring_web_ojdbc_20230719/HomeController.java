package com.kh.spring_web_ojdbc_20230719;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  private DataSource dataSource;
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;

  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    try {
      this.con = this.dataSource.getConnection();
      String sql = "SELECT COUNT(*) FROM mvcboard";
      this.ps = this.con.prepareStatement(sql);
      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        System.out.println("열 개수: " + rs.getInt(1));
      }
    } catch (SQLException e) {
      System.out.println("연결 오류");
      System.out.println(e);
    }

    return "home";
  }

}
