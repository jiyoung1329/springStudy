package com.care.di.ex3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String location = "classpath:ex3.xml";
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(location);
		PrintBean bean = gxac.getBean(PrintBean.class);
		bean.getPs().printString(bean.getPrint());
	}
}
