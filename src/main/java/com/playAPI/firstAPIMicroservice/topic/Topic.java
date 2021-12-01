package com.playAPI.firstAPIMicroservice.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	private String id;
	private String name;
	private String description;

	public Topic() {
		super();
	}

	public Topic(String topicId, String name, String description) {
		super();
		this.id = topicId;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String topicId) {
		this.id = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
