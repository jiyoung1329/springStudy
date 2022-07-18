package com.care.di.quiz3;

public class SaveClass {
	private int data1;
	private int data2;
	private String oper;
	private OperatorClass operatorClass;
	private PrintClass printClass;
	
	public void getResult() {
		int result = operatorClass.operator(data1, oper, data2);
		// OperatorClass 내 operator 메소드 호출하여 두 수와 연산자로 결과 반환
		
		printClass.show(data1, oper, data2, result);
	}

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public int getData2() {
		return data2;
	}

	public void setData2(int data2) {
		this.data2 = data2;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public OperatorClass getOperatorClass() {
		return operatorClass;
	}

	public void setOperatorClass(OperatorClass operatorClass) {
		this.operatorClass = operatorClass;
	}

	public PrintClass getPrintClass() {
		return printClass;
	}

	public void setPrintClass(PrintClass printClass) {
		this.printClass = printClass;
	}
	
	
	
	
	
}
