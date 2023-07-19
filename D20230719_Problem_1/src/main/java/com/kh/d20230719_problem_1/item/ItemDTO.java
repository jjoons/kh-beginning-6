package com.kh.d20230719_problem_1.item;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ItemDTO {
  private int item_number;
  private String item_category;
  private String item_name;
  private int item_price;
  private int item_stock;
  private String item_image;
  private String item_info;
  private int discount_rate;
  private String reg_date;
  private int sold;
}
