package com.sas.dao;

import java.util.List;

import com.sas.entity.Student;

public interface StudentDAO {
	
	public List<Student> getStudents();
	
	public void saveStudent(Student theStudent);
	
	public Student getStudent(int studentID);

	public void deleteStudent(int studentID);

	public List<Student> searchStudents(String theSearchName);

}
