package com.playAPI.firstAPIMicroservice.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This files contains actual business logic to fetch and set data from db 
	

@Service
public class CourseServices {
	
	@Autowired
	private CourseRepository CourseRespository;
	
	
//	private ArrayList<Course> _CourseList = new ArrayList<Course>(
//			Arrays.asList(new Course("123", "Data Structure", "Data structure course"),
//					new Course("234", "Algorithm Design", "Algorithm design course gets started"),
//					new Course("918", "System Design", "System Design Course course"),
//					new Course("7373", "Machine learning Course", "Lets start with machine learning")));

	// returns all the Courses
	public List<Course> getAllCourses(String topicId) {
		// return _CourseList;
		List<Course> Courses = new ArrayList<>();
		 CourseRespository.findByTopicId(topicId).forEach(Courses::add);
		 return Courses;
	}

	// returns a particular detail about a given Course id
	public Optional<Course> getCourseById(String CourseId) {
		// return _CourseList.stream().filter(element -> element.getCourseId().equals(CourseId)).findFirst().get();
		return CourseRespository.findById(CourseId);
	}

	// add Course to the list of Courses
	public void addCourseToList(Course Courses) {
		// _CourseList.addAll(Course);
		CourseRespository.save(Courses);
	}

	// update Course by id
	public String updateCourseById(String CourseId, Course Course) {
//		for (int i = 0; i < _CourseList.size(); i++) {
//			Course currentCourse = _CourseList.get(i);
//			if (currentCourse.getCourseId().equals(CourseId)) {
//				_CourseList.set(i, Course);
//				return;
//			}
//		}
		if (CourseRespository.existsById(CourseId)) {
			CourseRespository.save(Course);
			return "Course updated";
		}
		else 
			return "Course is not present";	
			
	}

	// delete Course by id
	public void deleteCourseById(String CourseId) {
		//_CourseList.removeIf(element -> element.getCourseId().equals(CourseId));
		CourseRespository.deleteById(CourseId);
	}

	public ArrayList<Course> getAllCoursesWithNoConstraint() {
		ArrayList<Course> Courses = new ArrayList<>();
		 CourseRespository.findAll().forEach(Courses::add);
		 return Courses;
	}

}
