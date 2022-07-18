package com.care.di.quiz3;

public class OperatorClass {
	public Integer operator(int data1, String oper, int data2) {
		switch (oper) {
		case "+":
			return data1+data2;
		case "-":
			return data1-data2;
			
		case "*":
			return data1*data2;
			
		case "/":
			return data1/data2;

		default:
			System.out.println("잘못입력하였습니다.");
			return null;
		}
	}
}
