package com.SpringBootFirstSpringBootWebService.SpringBootWebService.helloworld;

public class HelloWorldBean {
	
	private String name;
	private String quality;
	
	public HelloWorldBean(String name){
		
		this.name = name;
		quality = "good";
	}
	
	
	public HelloWorldBean(String name2, String quality) {
		this.name= name2;
		this.quality = quality;
		// TODO Auto-generated constructor stub
	}

	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name= name;
	}
	
	public String getquality(){
		return quality;
	}
	
	public void setquality(String quality){
		this.quality = quality;
	}
	
//	public String toString(){
//		return String.format("");
//		
//	}

}
