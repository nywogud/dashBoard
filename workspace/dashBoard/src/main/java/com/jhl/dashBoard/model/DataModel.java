package com.jhl.dashBoard.model;


import lombok.Data;

@Data
public class DataModel {
	
	private int testNumber;
	private String method;
	private String result;
	private int numAttem;
	private int countNumAttem;
	private int sucResultNum;
	private int failResultNum;
	private int rowNum;
	private float sucPerFail;
	
	
	public int getFailResultNum() {
		return failResultNum;
	}
	public void setFailResultNum(int failResultNum) {
		this.failResultNum = failResultNum;
	}
	public float getSucPerFail() {
		return sucPerFail;
	}
	public void setSucPerFail(float sucPerFail) {
		this.sucPerFail = sucPerFail;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getSucResultNum() {
		return sucResultNum;
	}
	public void setSucResultNum(int sucResultNum) {
		this.sucResultNum = sucResultNum;
	}
	public int getCountNumAttem() {
		return countNumAttem;
	}
	public void setCountNumAttem(int countNumAttem) {
		this.countNumAttem = countNumAttem;
	}
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
