package com.playAPI.firstAPIMicroservice.topic;

public class Topic {
	private String topicId;
	private String name;
	private String description;

	public Topic() {
		super();
	}

	public Topic(String topicId, String name, String description) {
		super();
		this.topicId = topicId;
		this.name = name;
		this.description = description;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
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
