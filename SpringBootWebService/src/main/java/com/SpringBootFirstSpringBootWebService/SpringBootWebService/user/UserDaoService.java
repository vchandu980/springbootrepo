package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static{
		users.add(new User(1,"chandra", new Date()));
		users.add(new User(2,"pavan",new Date()));
		users.add(new User(3,"brahmam",new Date()));
		users.add(new User(4,"kiran", new Date()));
	}
	private static int usersCount = 4;

	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id){
		for(User user : users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}
	
	public User save(User user){
		if(user.getId()==0){
			user.setId(++usersCount);
			
		}
		users.add(user);
		return user;
	}
	

}
