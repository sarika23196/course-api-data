package com.sarika.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sarika.springbootstarter.topic.Topic;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {
	
	@Id
	private String id;
	private String name;
	private String desription;
	@ManyToOne
	private Topic topic;
	
	
	public Course() {
		
	 
	}
	
	public Course(String id, String name, String desription, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.desription = desription;
		this.topic = new Topic(topicId,"", "");
	}
	
}
