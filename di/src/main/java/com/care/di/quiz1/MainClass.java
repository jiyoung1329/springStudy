package com.care.di.quiz1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String location = "classpath:quiz1.xml";
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(location);
		PrintBean bean = gxac.getBean(PrintBean.class);
		bean.getPs().printString(bean.getPrint());
	}
}
