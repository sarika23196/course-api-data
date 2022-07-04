 package com.sarika.springbootstarter.topic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sarika.springbootstarter.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Service 
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics(){
		List<Topic> dynmoDBList = new ArrayList<>();
		 for(com.sarika.springbootstarter.dynamodb.Topic t: topicRepository.findAll()) {
			 Topic temp = new Topic(t.getId(),t.getName(),t.getDesription());
			 dynmoDBList.add(temp);
		 }
		 return dynmoDBList;
	}
	
	public Topic getTopic(String id) {
		com.sarika.springbootstarter.dynamodb.Topic t =topicRepository.findById(id);
		Topic temp = new Topic(t.getId(),t.getName(),t.getDesription());
		return temp;
	}
	
	public void addTopic(Topic topic) {
		com.sarika.springbootstarter.dynamodb.Topic temp = new com.sarika.springbootstarter.dynamodb.Topic();
		temp.setId(topic.getId());
		temp.setName(topic.getName());
		temp.setDesription(topic.getDesription());
		topicRepository.save(temp);
	}

	public void updateTopic(Topic topic, String id) {
		com.sarika.springbootstarter.dynamodb.Topic temp = new com.sarika.springbootstarter.dynamodb.Topic();
		temp.setId(topic.getId());
		temp.setName(topic.getName());
		temp.setDesription(topic.getDesription());
		topicRepository.update(temp);
		
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}
}
