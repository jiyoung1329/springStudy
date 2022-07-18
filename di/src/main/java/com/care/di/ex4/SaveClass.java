package com.care.di.ex4;

import java.util.ArrayList;
import java.util.HashMap;

public class SaveClass {
	private PrintClass pc;
	private ArrayList<String> names;
	private HashMap<String, String> menus;
	
	public void show() {
		pc.show(names, menus);
	}

	public PrintClass getPc() {
		return pc;
	}

	public void setPc(PrintClass pc) {
		this.pc = pc;
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public HashMap<String, String> getMenus() {
		return menus;
	}

	public void setMenus(HashMap<String, String> menus) {
		this.menus = menus;
	}
	
	
}
