package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getSpecificUser(@PathVariable int id){
		return service.findOne(id);
	}
	

}
