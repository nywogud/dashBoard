package com.jhl.dashBoard.model;

import lombok.Data;

@Data
public class DataModel {
	
	private int testNumber;
	private String method;
	private String result;
	private int numAttem;
	
	public int getNumAttem() {
		return numAttem;
	}
	public void setNumAttem(int numAttem) {
		this.numAttem = numAttem;
	}
	public int getTestNumber() {
		return testNumber;
	}
	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
