package com.sarika.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	
	@Id
	private String id;
	private String name;
	private String desription;
	
	public Topic() {
		
	 
	}
	
	public Topic(String id, String name, String desription) {
		super();
		this.id = id;
		this.name = name;
		this.desription = desription;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesription() {
		return desription;
	}
	
	public void setDesription(String desription) {
		this.desription = desription;
	}
	
	
}
