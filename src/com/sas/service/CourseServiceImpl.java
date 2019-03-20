package com.sas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sas.dao.CourseDAO;
import com.sas.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {

		courseDAO.saveCourse(theCourse);

	}

	@Override
	@Transactional
	public Course getCourse(int courseID) {

		return courseDAO.getCourse(courseID);

	}

	@Override
	@Transactional
	public List<Course> getCourses() {

		return courseDAO.getCourses();

	}

	@Override
	@Transactional
	public List<Course> searchCourses(String theSearchName) {

		return courseDAO.searchCourses(theSearchName);

	}

	@Override
	@Transactional
	public void deleteCourse(int courseID) {

		courseDAO.deleteCourse(courseID);

	}

}
