package com.bo;

import java.sql.Date;

public class Candidate {
	
	private String firstname;
	private String lastname;
	private static String username;
	private String password;
	private Date dob ;
	private String address;
	private String city;
	private String state;
	private int pin;
	private long contact;
	private String email;
	private String domain;
	private int experience;
	private String prevcompany;
	private int status;
	public Candidate(String firstname2, String password2, String email2, int contact2) {
		// TODO Auto-generated constructor stub
		super();
		this.firstname = firstname;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getPrevcompany() {
		return prevcompany;
	}
	public void setPrevcompany(String prevcompany) {
		this.prevcompany = prevcompany;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Candidate(String firstname, String lastname, String password, Date dob, String address, String city,
			String state, int pin, long contact, String email, String domain, int experience, String prevcompany,
			int status) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.contact = contact;
		this.email = email;
		this.domain = domain;
		this.experience = experience;
		this.prevcompany = prevcompany;
		this.status = status;
	}
	
	
	
	
	
	
	

}
