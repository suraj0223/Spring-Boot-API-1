package com.playAPI.firstAPIMicroservice.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.playAPI.firstAPIMicroservice.topic.Topic;

// This controller file mapped to respective business logic  

@RestController
public class CourseController {
	
	@Autowired
	private CourseServices CourseServices;
	
	@GetMapping("/getAllCourses")
	public ArrayList<Course> getAllCourse() {
		return CourseServices.getAllCoursesWithNoConstraint();
	}
	
	@GetMapping("/getAlltopics/{topicId}/courses")
	public List<Course> showAllCourses(@PathVariable String topicId) {
		return CourseServices.getAllCourses(topicId);
	}
	
	@GetMapping("/getAlltopics/{topicId}/courses/{CourseId}")
	public Optional<Course> showCourseById(@PathVariable String CourseId) {
		return CourseServices.getCourseById(CourseId);
	}
	
	@PostMapping("/getAlltopics/{topicId}/courses/addCourses")
	public void addCourse( @PathVariable String topicId, @RequestBody Course newCourse) {
		newCourse.setTopic(new Topic(topicId, "", ""));
		CourseServices.addCourseToList(newCourse);
	}
	
	@PutMapping("/getAlltopics/{topicId}/courses/updateCourses/{CourseId}")
	public String updateCourse(@PathVariable String CourseId, @PathVariable String topicId, @RequestBody Course newCourse) {
		newCourse.setTopic(new Topic(topicId, "", ""));
		return CourseServices.updateCourseById(CourseId, newCourse);
	}
	
	@DeleteMapping("/getAlltopics/{topicId}/courses/deleteCourse/{CourseId}")
	public void deleteCourse(@PathVariable String CourseId) {
		CourseServices.deleteCourseById(CourseId);
	}
	
	
}
