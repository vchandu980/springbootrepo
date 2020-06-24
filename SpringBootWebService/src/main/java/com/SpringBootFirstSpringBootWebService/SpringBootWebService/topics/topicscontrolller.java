package com.SpringBootFirstSpringBootWebService.SpringBootWebService.topics;

import java.net.URI;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class topicscontrolller {
	
	@Autowired
	private TopicsDaoService service ;
	
	@GetMapping(path="/topics")
	public List<Topic> getAllTopics(){
		return service.getTopicslist();
		
	}
	
	@GetMapping(path="/topics/{id}")
	public Topic getSpecificTopic(@PathVariable int id){
		return service.findTopic(id);
	}
	
	@PostMapping(path="/topics")
	public ResponseEntity saveTopic(@RequestBody Topic topic){
		Topic t = service.save(topic);
		URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getId()).toUri();
		return ResponseEntity.created(Location).build();
	}
	
	@PutMapping(path="/topics/{id}")
	public ResponseEntity updateTopic(@RequestBody Topic topic,@PathVariable int id){
		service.updateTopic(topic,id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@DeleteMapping(path="/topics/{id}")
	public ResponseEntity deleteTopic(@PathVariable int id){
		service.deleteTopic(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
