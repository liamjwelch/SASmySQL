package com.sas.service;

import java.util.List;

import com.sas.entity.Teacher;

public interface TeacherService {

	// create + update

	public void saveTeacher(Teacher theTeacher);

	// read

	public Teacher getTeacher(int teacherID);

	public List<Teacher> getTeachers();

	public List<Teacher> searchTeachers(String theSearchName);

	// delete

	public void deleteTeacher(int teacherID);

}
