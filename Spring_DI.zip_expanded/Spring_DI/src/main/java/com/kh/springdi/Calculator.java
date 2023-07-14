package com.kh.springdi;

public class Calculator {

	public void add(int firstNum, int seconNum) {

		System.out.println("add()");
		int result = firstNum + seconNum;
		System.out.println(firstNum +" + " + seconNum +"=" +result);
		
	}

	public void sub(int firstNum, int seconNum) {
		System.out.println("sub()");
		int result = firstNum - seconNum;
		System.out.println(firstNum +" - " + seconNum +"=" +result);
		
	}

	public void mul(int firstNum, int seconNum) {
		System.out.println("mul()");
		int result = firstNum * seconNum;
		System.out.println(firstNum +" * " + seconNum +"=" +result);
		
	}

	public void div(int firstNum, int seconNum) {
		System.out.println("div()");
		int result = firstNum / seconNum;
		System.out.println(firstNum +" / " + seconNum +"=" +result);
		
	}

}
