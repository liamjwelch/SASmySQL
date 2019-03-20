package com.sas.service;

import java.util.List;

import com.sas.entity.Student;

public interface StudentService {

	// create + update
	public void saveStudent(Student theStudent);

	// read
	public Student getStudent(int studentID);

	public List<Student> getStudents();

	public List<Student> searchStudents(String theSearchName);

	// delete
	public void deleteStudent(int studentID);

}
