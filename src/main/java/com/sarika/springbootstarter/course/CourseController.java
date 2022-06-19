package com.sarika.springbootstarter.course;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarika.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{Id}/courses")
	public List<Course> getAllCourses(@PathVariable String Id) {
		return courseService.getAllCourses(Id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCources(@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		return courseService.getCourse(id);
	}

	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId ) {
		course.setTopic(new Topic(topicId, "",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{Id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String idtopicId, @PathVariable String Id) {
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{Id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

} 
