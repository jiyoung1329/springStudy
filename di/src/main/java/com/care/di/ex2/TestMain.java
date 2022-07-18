package com.care.di.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:ex2.xml";
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(location);
		TestBean bean = gxac.getBean(TestBean.class);
//		bean.setTest(new Test());
		bean.getTest().printName("test");
		bean.getTest().printAge(20);
				
	}
}
