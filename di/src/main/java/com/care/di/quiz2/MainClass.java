package com.care.di.quiz2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String location = "classpath:quiz2.xml";
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(location);
		SaveClass save = gxac.getBean(SaveClass.class);
		save.getResult();
	}
}
