package com.bo;

import java.sql.Date;

public class Requirement {
	int id;
	
	int rid;
	Date reqdate;
	Date closedate;
	int vacancies;
	int minexp;
	String mode;
	String domain;
	public Requirement(int id, int rid, Date reqdate, Date closedate, int vacancies, int minexp, String mode,String domain) {
		super();
		this.id = id;
		this.rid = rid;
		this.reqdate = reqdate;
		this.closedate = closedate;
		this.vacancies = vacancies;
		this.minexp = minexp;
		this.mode = mode;
		this.domain=domain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}
	public Date getClosedate() {
		return closedate;
	}
	public void setClosedate(Date closedate) {
		this.closedate = closedate;
	}
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public int getMinexp() {
		return minexp;
	}
	public void setMinexp(int minexp) {
		this.minexp = minexp;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	
	
	
}
