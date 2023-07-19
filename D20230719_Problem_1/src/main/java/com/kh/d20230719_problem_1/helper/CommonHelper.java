package com.kh.d20230719_problem_1.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonHelper {
  public static String getToday() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return dateTime.format(formatter);
  }
}
