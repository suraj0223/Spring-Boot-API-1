package com.playAPI.firstAPIMicroservice.topic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This controller file mapped to respective business logic  

@RestController
public class TopicController {
	
	@Autowired
	private TopicServices topicServices;
	
	@GetMapping("/getAlltopics")
	public ArrayList<Topic> showAllTopics() {
		return topicServices.getAllTopics();
	}
	
	@GetMapping("/getAlltopics/{topicId}")
	public Topic showTopicById(@PathVariable String topicId) {
		return topicServices.getTopicById(topicId);
	}
	
	@PostMapping("/addtopics")
	public void addTopic(@RequestBody ArrayList<Topic> newtopic) {
		topicServices.addTopicToList(newtopic);
	}
	
	@PutMapping("/updatetopics/{topicId}")
	public void updateTopic(@PathVariable String topicId, @RequestBody Topic newtopic) {
		topicServices.updateTopicById(topicId, newtopic);
	}
	
	@DeleteMapping("/deletetopic/{topicId}")
	public void deleteTopic(@PathVariable String topicId) {
		topicServices.deleteTopicById(topicId);
	}
	

}
