package com.care.di.ex5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String location = "classpath:ex5.xml";
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(location);
		SaveClass save = gxac.getBean(SaveClass.class);
		save.show();
	}
}
