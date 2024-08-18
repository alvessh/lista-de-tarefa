package com.listatarefa.api.entity;

import java.util.List;

public class Person {
	
	private Integer id;
	private String name;
	private String mail;
	private String address;
	private List<Task> taksList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Task> getTaksList() {
		return taksList;
	}
	public void setTaksList(List<Task> taksList) {
		this.taksList = taksList;
	}
}