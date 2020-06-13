package com.SpringBootFirstSpringBootWebService.SpringBootWebService.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TopicsDaoService {
	
	private static List<Topic> topicslist = new ArrayList<Topic>();
	static{
		topicslist.add(new Topic(1,"springboot","The basics of Springframework by s.k Das"));
		topicslist.add(new Topic(2,"python fundamentals","Python from zero to hero"));
		
		
	}
	
	private static int topicscount = 2;

	public  List<Topic> getTopicslist() {
		return topicslist;
	}
	
	public Topic save(Topic t){
		if(t.getId()==0){
			t.setId(++topicscount);
			
		}
		topicslist.add(t);
		return t;
		
	}

	public Topic findTopic(int id) {
		// TODO Auto-generated method stub
		for(Topic t : topicslist){
			if(t.getId()==id){
				return t;
			}
		}
		return null;
	}

	public void updateTopic(Topic topic, int id) {
		topic.setId(id);
		for(Topic t:topicslist){
			if(t.getId()==id){
				topicslist.set(topicslist.indexOf(t), topic);
				break;
			}
		}
	}

	public void deleteTopic(int id) {
		topicslist.removeIf(t->t.getId()==id);
		
	}

	

	

	
	
	
	
	
	
	


}
