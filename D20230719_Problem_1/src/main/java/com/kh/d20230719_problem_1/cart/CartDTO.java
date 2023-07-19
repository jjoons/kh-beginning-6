
package com.kh.d20230719_problem_1.cart;

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
public class CartDTO {
  private int cart_number;
  private String buyer;
  private String item_name;
  private int buy_price;
  private int buy_count;
  private String item_image;
}
