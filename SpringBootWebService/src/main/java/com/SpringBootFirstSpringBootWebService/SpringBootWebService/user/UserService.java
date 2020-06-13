package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user = service.findOne(id);
		if(user ==null){
			throw new UserNotFoundException("id: "+id);
		}
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity SaveUser(@RequestBody User user){
		 User savedUser = service.save(user);
		
		URI Location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(Location).build();
	}

	

}
