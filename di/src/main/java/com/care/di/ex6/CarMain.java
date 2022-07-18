package com.care.di.ex6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		String location = "classpath:ex6.xml";
		GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(location);
		ICar car = gxac.getBean(ICar.class);
		car.speed();
		
	}
}

