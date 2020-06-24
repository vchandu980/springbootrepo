package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.util.Date;

public class Post {
	int id;
	String message;
	Date doc;
	
	public Post() {
		super();
		
	}
	public Post(int id,String message, Date doc) {
		super();
		this.id = id;
		this.message = message;
		this.doc = doc;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	
	

}
