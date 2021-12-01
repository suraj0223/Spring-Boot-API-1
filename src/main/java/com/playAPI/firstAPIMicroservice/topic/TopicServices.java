package com.playAPI.firstAPIMicroservice.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This files contains actual business logic to fetch and set data from db 
	

@Service
public class TopicServices {
	
	@Autowired
	private TopicRepository topicRespository;
	
	
//	private ArrayList<Topic> _topicList = new ArrayList<Topic>(
//			Arrays.asList(new Topic("123", "Data Structure", "Data structure course"),
//					new Topic("234", "Algorithm Design", "Algorithm design course gets started"),
//					new Topic("918", "System Design", "System Design Course course"),
//					new Topic("7373", "Machine learning Course", "Lets start with machine learning")));

	// returns all the topics
	public ArrayList<Topic> getAllTopics() {
		// return _topicList;
		ArrayList<Topic> topics = new ArrayList<>();
		 topicRespository.findAll().forEach(topics::add);
		 return topics;
	}

	// returns a particular detail about a given topic id
	public Optional<Topic> getTopicById(String topicId) {
		// return _topicList.stream().filter(element -> element.getTopicId().equals(topicId)).findFirst().get();
		return topicRespository.findById(topicId);
	}

	// add topic to the list of topics
	public void addTopicToList(Topic topics) {
		// _topicList.addAll(topic);
		topicRespository.save(topics);
	}

	// update topic by id
	public void updateTopicById(String topicId, Topic topic) {
//		for (int i = 0; i < _topicList.size(); i++) {
//			Topic currentTopic = _topicList.get(i);
//			if (currentTopic.getTopicId().equals(topicId)) {
//				_topicList.set(i, topic);
//				return;
//			}
//		}
		topicRespository.save(topic);
	}

	// delete topic by id
	public void deleteTopicById(String topicId) {
		//_topicList.removeIf(element -> element.getTopicId().equals(topicId));
		topicRespository.deleteById(topicId);
	}

}
