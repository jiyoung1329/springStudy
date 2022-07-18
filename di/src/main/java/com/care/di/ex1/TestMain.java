package com.care.di.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.di.ex2.Test;
import com.care.di.ex2.TestBean;

public class TestMain {
	public static void main(String[] args) {
		
		
		TestBean bean = new TestBean();
		bean.setTest(new Test());
		bean.getTest().printName("test");
		bean.getTest().printAge(20);
				
	}
}
