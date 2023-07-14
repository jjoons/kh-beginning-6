package com.kh.springdi2;

import java.util.ArrayList;

public class MyInfo {
  private String name;
  private double height;
  private double weight;
  private BMICalculator bmiCalculator;
  private ArrayList<String> hobbies;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public BMICalculator getBmiCalculator() {
    return bmiCalculator;
  }

  public void setBmiCalculator(BMICalculator bmiCalculator) {
    this.bmiCalculator = bmiCalculator;
  }

  // toString
  @Override
  public String toString() {
    return "MyInfo [name=" + name + ", height=" + height + ", weight=" + weight + ", bmiCalculator="
        + bmiCalculator + ", hobbies=" + hobbies + "]";
  }

  // 실제 계산하는 메서드를 호출하는 메서드!
  public void getMyInfo() {
    System.out.println("이름: " + this.name);
    System.out.println("신장: " + this.height);
    System.out.println("체중: " + this.weight);
    System.out.println("취미: " + this.hobbies);

    bmiCalculator.bmiCalculator(height, weight);
  }

}
