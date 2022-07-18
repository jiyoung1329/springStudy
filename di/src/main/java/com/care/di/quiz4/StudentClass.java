package com.care.di.quiz4;

import java.util.ArrayList;

public class StudentClass implements IStudent{
	private String name;
	private ArrayList<String> foods;
	private PrintClass pc;
	
	public StudentClass(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<String> foods) {
		this.foods = foods;
	}

	public PrintClass getPc() {
		return pc;
	}

	public void setPc(PrintClass pc) {
		this.pc = pc;
	}

	@Override
	public void execute() {
		pc.show(name, foods);
	}
	
	
}
