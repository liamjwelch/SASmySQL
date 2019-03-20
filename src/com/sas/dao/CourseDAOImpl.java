package com.sas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sas.entity.Course;
import com.sas.entity.Student;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// create + update
	@Override
	public void saveCourse(Course theCourse) {

		// get the current session

		Session currentSession = sessionFactory.getCurrentSession();

		// persist the data using hibernate saveOrUpdate

		currentSession.saveOrUpdate(theCourse);
	}

	// read

	@Override
	public Course getCourse(int courseID) {

		// get the current session

		Session currentSession = sessionFactory.getCurrentSession();

		// get the information using hibernate Get

		Course theCourse = currentSession.get(Course.class, courseID);

		// return the fetch'd course
		return theCourse;
	}

	@Override
	public List<Course> getCourses() {

		// get the currentSession

		Session currentSession = sessionFactory.getCurrentSession();

		// get the information using a query

		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);

		// execute the query

		List<Course> courses = theQuery.getResultList();

		// return data
		return courses;
	}

	@Override
	public List<Course> searchCourses(String theSearchName) {
		// get the current session

		Session currentSession = sessionFactory.getCurrentSession();

		// get the information using a query

		Query<Course> theQuery = null;

		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from Course where lower(courseName) like:theName", Course.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// the searchName is empty
			theQuery = currentSession.createQuery("from Course", Course.class);
		}

		// execute Query and get the resultList

		List<Course> courses = theQuery.getResultList();

		return courses;
	}

	@Override
	public void deleteCourse(int courseID) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the information using a query

		Query<?> theQuery = currentSession.createQuery("delete from Course where course_id=:courseID");
		theQuery.setParameter("courseID", courseID);

		// execute update

		theQuery.executeUpdate();

	}

}
