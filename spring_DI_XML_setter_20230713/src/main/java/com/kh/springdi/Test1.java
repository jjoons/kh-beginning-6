package com.kh.springdi;

public class Test1 {
  int a = 10;

  public void add(int val) {
    this.a = this.a + val;
  }

  public void test1() {
    System.out.println(this.a);
  }
}
