package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping(path="/users/{id}")//if we were able to find the resource then fetch it from database and return else return Http 404 error telling that the resource is not found
	public User getSpecificUser(@PathVariable int id){
		User user = service.findOne(id);
		if(user==null){
			throw new UserNotFoundException("id - "+id+" is not found");
		}
		return user;
		
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> CreateUser(@Valid @RequestBody User user){
		User newUser  = service.save(user);
		if(newUser ==null){
			throw new InvalidUserDetailsException("Missing or Invlalid Name or DOB details");
		}
		URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(Location).build();
		
	}
	
	@GetMapping(path="users/{id}/posts")
	public List<Post> ReturnPostsOfOneUser(@PathVariable int id){
		return service.AllPostsOfUser(id);
		
	}
	
	@PostMapping(path="users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post,@PathVariable int id){
		Post p = service.save(post,id);
		if(p==null){
			throw new InvalidPostDetailsException("Missing details in post");
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping(path="users/{userid}/posts/{postid}")
	public ResponseEntity<Object> deletePost(@PathVariable int userid,@PathVariable int postid){
		service.deletePost(userid,postid);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping(path="users/{id}")
	public void DeleteUser(@PathVariable int id){
		User user = service.deleteUser(id);
		if(user ==null){
			throw new UserNotFoundException("id:"+id);
		}
		
	}
	

}
