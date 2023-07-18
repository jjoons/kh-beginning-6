package com.kh.d20230718_problem_1.board;

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
public class Board {
  private int num;
  private String writer;
  private String email;
  private String subject;
  private String password;
  private Date reg_date;
  private int ref;
  private int re_step;
  private int re_level;
  private int readcount;
  private String content;
}
