package com.kh.d20230719_problem_1.board;

import java.sql.Date;
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
public class BoardDTO {
  private int num;
  private String writer;
  private String title;
  private String pw;
  private Date reg_date;
  private int ref;
  private int re_step;
  private int re_level;
  private int readcount;
  private String content;
}
