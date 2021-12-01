package com.playAPI.firstAPIMicroservice.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.playAPI.firstAPIMicroservice.topic.Topic;


@Entity
public class Course {
	@Id
	private String id;
	private String courseName;
	private String courseDescription;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		super();
	}

	public Course(String courseId, String courseName, String courseDescription, String topicId) {
		super();
		this.id = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.setTopic(new Topic(topicId, "", ""));
	}

	public String getcourseId() {
		return id;
	}

	public void setcourseId(String courseId) {
		this.id = courseId;
	}

	public String getcourseName() {
		return courseName;
	}

	public void setcourseName(String coursecourseName) {
		this.courseName = coursecourseName;
	}

	public String getcourseDescription() {
		return courseDescription;
	}

	public void setcourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
