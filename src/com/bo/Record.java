package com.bo;

public class Record {
	
	int rid;
	String name;
	int inid;
	int marks;
	String result;
	public Record(int rid, String name, int inid, int marks, String result) {
		super();
		this.rid = rid;
		this.name = name;
		this.inid = inid;
		this.marks = marks;
		this.result = result;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInid() {
		return inid;
	}
	public void setInid(int inid) {
		this.inid = inid;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	

}
