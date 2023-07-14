package com.kh.springdi2;

public class BMICalculator {
  // 키와 몸무게를 인수로 넘겨받아 BMI 지수를 계산하고 등급을 출력하는 메소드
  // BMI 지수: 몸무게 / 키 * 키
  // 산출된 값이 18.5 미만 저체중, 18.5 이상 23미만이면 정상 23 ~25 미만 과체중
  // 25이상  30미만 비만 30이상 고도비만 

  // BMI 계산
  public void bmiCalculator(double height, double weight) {
    height /= 100;
    double bmi = weight / (height * height);
    bmi = Math.ceil(bmi * 100) / 100;

    System.out.println(new StringBuilder("BMI 지수: ").append(bmi));

    if (bmi < 18.5) {
      System.out.println("저체중입니다");
    } else if (bmi < 23) {
      System.out.println("정상입니다");
    } else if (bmi < 25) {
      System.out.println("과체중입니다");
    } else if (bmi < 30) {
      System.out.println("비만입니다");
    } else if (bmi >= 30) {
      System.out.println("고도비만입니다");
    }
  }
}
