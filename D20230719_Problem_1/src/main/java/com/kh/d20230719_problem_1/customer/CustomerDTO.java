package com.kh.d20230719_problem_1.customer;

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
public class CustomerDTO {
  private String id;
  private String pw;
  private String name;
  private String reg_date;
  private String tel;
  private String address;
  private String email;
}
