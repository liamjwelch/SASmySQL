package com.sas.service;

import java.util.List;

import com.sas.entity.Course;


public interface CourseService {
	
	// create + update
	public void saveCourse(Course theCourse);

	// read
	public Course getCourse(int courseID);

	public List<Course> getCourses();

	public List<Course> searchCourses(String theSearchName);

	// delete
	public void deleteCourse(int courseID);	

}
