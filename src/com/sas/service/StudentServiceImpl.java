package com.sas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sas.dao.StudentDAO;
import com.sas.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	// need to inject studentDAO

	@Autowired
	private StudentDAO studentDAO;

	// create + update
	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentDAO.saveStudent(theStudent);
	}

	// read
	@Override
	@Transactional
	public Student getStudent(int studentID) {

		return studentDAO.getStudent(studentID);
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public List<Student> searchStudents(String theSearchName) {

		return studentDAO.searchStudents(theSearchName);
	}

	// delete
	@Override
	@Transactional
	public void deleteStudent(int studentID) {

		studentDAO.deleteStudent(studentID);

	}

}
