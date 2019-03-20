package com.sas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sas.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTeacher(Teacher theTeacher) {

		// get current session

		Session currentSession = sessionFactory.getCurrentSession();

		// persist the data to the database.
		currentSession.saveOrUpdate(theTeacher);

	}

	@Override
	public Teacher getTeacher(int teacherID) {

		// get the current session

		Session currentSession = sessionFactory.getCurrentSession();

		// now read/retrieve data from DB using teacherID

		Teacher theTeacher = currentSession.get(Teacher.class, teacherID);

		// return value
		return theTeacher;
	}

	@Override
	public List<Teacher> getTeachers() {
		// get the current session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query to get all teachers and sort by last name
		
		Query<Teacher> theQuery = currentSession.createQuery("from Teacher order by lastName", Teacher.class);
		
		//execute the query and the the resultList
		
		List<Teacher> teachers = theQuery.getResultList();
		
		//return teachers
		return teachers;
		
	}

	@Override
	public List<Teacher> searchTeachers(String theSearchName) {
		
		//get the currentSession
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Teacher> theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from Teacher where lower(firstName) like:theName or lower(lastName) like:theName", Teacher.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			//the searchName is empty
			theQuery = currentSession.createQuery("from Teacher", Teacher.class);
		}
		
		//execute Query and get ther resultList
		List<Teacher> teachers  = theQuery.getResultList();
		
		return teachers;
	}

	@Override
	public void deleteTeacher(int teacherID) {

		//get the current session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the teacher with primary key
		
		Query<?> theQuery = currentSession.createQuery("delete from Teacher where teacher_id=:teacherID");
		theQuery.setParameter("teacherID", teacherID);
		
		//process HQL
		theQuery.executeUpdate();
		
	}

}
