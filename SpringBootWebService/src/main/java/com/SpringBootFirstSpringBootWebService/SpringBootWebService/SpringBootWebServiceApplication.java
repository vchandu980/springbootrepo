package com.SpringBootFirstSpringBootWebService.SpringBootWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebServiceApplication.class, args);
	}
	
	@RequestMapping(path="/")
	public String entryPoint(){
		return "Welcome..This is the Entry point of your Spring Application";
	}
	
	@GetMapping(path="/userhtml")
	public String Html(){
		return "<h1>welcome to Minneapolis</h1>";
	}

}
