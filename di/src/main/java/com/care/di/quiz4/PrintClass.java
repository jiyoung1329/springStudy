package com.care.di.quiz4;

import java.util.ArrayList;

public class PrintClass {
	public void show(String name, ArrayList<String> foods) {
		System.out.println("이름: " + name);
		System.out.print(name + "님이 좋아하는 음식은 : ");
		for(String food: foods) {
			System.out.print(food + " ");
		}
		System.out.print("입니다.");
	}
}
