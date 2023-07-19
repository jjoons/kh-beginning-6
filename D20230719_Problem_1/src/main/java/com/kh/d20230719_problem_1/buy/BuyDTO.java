package com.kh.d20230719_problem_1.buy;

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
public class BuyDTO {
  private String customer_id;
  private String customer_name;
  private int cart_number;
  private String item_name;
  private int buy_price;
  private int buy_count;
  private String item_image;
  private String buy_date;
  private String howpay;
  private String address;
}
