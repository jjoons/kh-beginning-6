package com.kh.d20230719_problem_1.item;

public enum ItemCategory {
  VEGETABLE("100", "채소"),
  SHELLFISH("200", "해산물"),
  MEAT("300", "육류"),
  HOME_APPLIANCES("400", "가전제품"),;

  private String code;
  private String koreanName;

  private ItemCategory(String code, String koreanName) {
    this.code = code;
    this.koreanName = koreanName;
  }

  public String getCode() {
    return code;
  }

  public String getKoreanName() {
    return koreanName;
  }
}
