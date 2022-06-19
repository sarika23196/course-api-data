 package com.sarika.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service 
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String id){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(t -> courses.add(t));
		return courses;
	}
	
	public Course getCourse(String id) {
		Optional<Course>  optionalCourse = courseRepository.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}
	
	public void addCourse (Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course ) {
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}

}
