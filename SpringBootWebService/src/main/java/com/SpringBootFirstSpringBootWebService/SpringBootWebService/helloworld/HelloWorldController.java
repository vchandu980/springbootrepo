package com.SpringBootFirstSpringBootWebService.SpringBootWebService.helloworld;
import com.SpringBootFirstSpringBootWebService.SpringBootWebService.user.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World!!";
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/userStatus")
	public String userStatus(){
		return "sleeping in his couch";
	}
	

	
	@GetMapping(path="/user/{name}")
	public HelloWorldBean helloworldbeanreturn(@PathVariable String name){
		return new HelloWorldBean(name);
	}
	
	@GetMapping(path="/user/{name}/{quality}")
	public HelloWorldBean helloworldbeanquality(@PathVariable String name,String quality){
		return new HelloWorldBean(name,quality);
	}
	
	@GetMapping(path = "/user/song")
	public String Helloworldsong(){
		return " hello world song";
	}

}
