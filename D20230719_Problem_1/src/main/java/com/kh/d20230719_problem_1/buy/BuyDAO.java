package com.kh.d20230719_problem_1.buy;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.kh.d20230719_problem_1.helper.DAOHelper;

public class BuyDAO {
  @Autowired
  private DataSource dataSource;

  @Autowired
  private DAOHelper daoHelper;
}
