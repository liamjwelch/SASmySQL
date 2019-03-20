package com.sas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sas.dao.TeacherDAO;
import com.sas.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	// need to inject teacherDAO

	@Autowired
	private TeacherDAO teacherDAO;

	// create + update
	@Override
	@Transactional
	public void saveTeacher(Teacher theTeacher) {
		teacherDAO.saveTeacher(theTeacher);
	}

	// read
	@Override
	@Transactional
	public Teacher getTeacher(int teacherID) {

		return teacherDAO.getTeacher(teacherID);

	}

	@Override
	@Transactional
	public List<Teacher> getTeachers() {

		return teacherDAO.getTeachers();

	}

	@Override
	@Transactional
	public List<Teacher> searchTeachers(String theSearchName) {

		return teacherDAO.searchTeachers(theSearchName);

	}

	// delete

	@Override
	@Transactional
	public void deleteTeacher(int teacherID) {

		teacherDAO.deleteTeacher(teacherID);

	}

}
