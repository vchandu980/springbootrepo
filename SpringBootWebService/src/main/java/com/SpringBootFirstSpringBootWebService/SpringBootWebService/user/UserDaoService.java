package com.SpringBootFirstSpringBootWebService.SpringBootWebService.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static List<Post>  posts1 =new ArrayList<>();
	private static List<Post> posts2 = new ArrayList<>();
	private static List<Post> posts3 = new ArrayList<>();
	
	
	 
	static{
		posts1.add(new Post(1,"Hi..This is chandra and This is my first post",new Date()));
		posts1.add(new Post(2,"Hi ..This is chandra again and this is my second post", new Date()));
		posts2.add(new Post(1,"Hi ..This is pavan and this is my first post", new Date()));
		posts2.add(new Post(2,"Hi ..This is pavan again and this is my second post", new Date()));
		posts3.add(new Post(1,"Hi ..This is brahmam and this is my first post", new Date()));
		posts3.add(new Post(2,"Hi ..This is brahmam again and this is my second post", new Date()));
		
	}
	
	
	
	
	
	static{

		users.add(new User(1,"chandra", new Date(),posts1,2));
		users.add(new User(2,"pavan",new Date(),posts2,2));
		users.add(new User(3,"brahmam",new Date(),posts3,2));

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
		if(user.getName()!=null && user.getDob() instanceof Date){
			if(user.getId()==0){
				user.setId(++usersCount);
				users.add(user);
				return user;
			}
		}
		
		
		
		return null;
	}
	
	public List<Post> AllPostsOfUser(int id){
		for(User user :users){
			if(user.getId()==id){
				return user.getListOfPosts();
			}
		}
		return null;
	}

	public Post save(Post post,int id) {
		
		
		for(User user:users){
			if(user.getId()==id){
				post.setDoc(new Date());
				user.setNumberOfPosts(user.getNumberOfPosts()+1);
				post.setId(user.getNumberOfPosts());
				user.getListOfPosts().add(post);
				
				return post;
			}
		}
		return null;
		
		
	}

	public void deletePost(int userid, int postid) {
		
		for(User user:users){
			if(user.getId()==userid){
				List<Post> posts = user.getListOfPosts();
				for(Post post:posts){
					if(post.getId()==postid){
						posts.remove(post);
						user.setNumberOfPosts(user.getNumberOfPosts()-1);
						return;
					}
					
				}
			}
		}
		
		
	}

	public User deleteUser(int id) {
//		for(User user:users){
//			if(user.getId()==id){
//				users.remove(user);
//				return user;
//			}
//		}
//		return null;
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()){
			User user = itr.next();
			if(user.getId()==id){
				itr.remove();
				return user;
			}
			
		}
		return null;
		
	}

}
