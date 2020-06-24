package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private int numberOfPosts;



	private User(){
		
	}
	
	public int getNumberOfPosts() {
		return numberOfPosts;
	}

	public void setNumberOfPosts(int numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
	}

	public List<Post> getListOfPosts() {
		return ListOfPosts;
	}

	public void setListOfPosts(List<Post> listOfPosts) {
		ListOfPosts = listOfPosts;
	}

	public User(int id, String name, Date dob,List<Post> ListOfPosts,int numberOfPosts) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.ListOfPosts = ListOfPosts;
		this.numberOfPosts = numberOfPosts;
	}
	public User(){
		
	}

	private int id;
	
	@Size(min=2,message="name should be atleast two characters long")
	private String name;
	
	@Past
	private Date dob;
	
	private List<Post> ListOfPosts = new ArrayList<Post>();

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
