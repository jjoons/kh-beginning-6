package com.kh.d20230720_problem_1.manager.book;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ManagerBookVO {
  private int id;
  private int categoryCode;
  private String title;
  private int price;
  private int amount;
  private String author;
  private String publishCompany;
  private Date publishDate;
  private String bookImagePath;
  private String content;
  private int discountRate;
}
