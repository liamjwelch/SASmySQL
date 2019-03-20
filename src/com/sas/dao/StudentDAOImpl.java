package com.sas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sas.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// need to inject the sessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	// create - update

	@Override
	public void saveStudent(Student theStudent) {
		// get current hibernate Session

		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.saveOrUpdate(theStudent);

	}

//	 read

	@Override
	public Student getStudent(int studentID) {

		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from data using PrimaryKey
		Student theStudent = currentSession.get(Student.class, studentID);

		return theStudent;

	}

	@Override
	public List<Student> getStudents() {

		// get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// creates the query, sorts by last name
		Query<Student> theQuery = currentSession.createQuery("from Student order by lastName", Student.class);

		// execute the query and get the resultList

		List<Student> students = theQuery.getResultList();

		// return the resultList

		return students;

	}

	@Override
	public List<Student> searchStudents(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// search for the student with firstName

		Query<Student> theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//

		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from Student where lower(firstName) like:theName or lower(lastName) like:theName", Student.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// the searchName is empty
			theQuery = currentSession.createQuery("from Student", Student.class);
		}

		// execute Query and get resultList
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;

	}

	// delete

	@Override
	public void deleteStudent(int studentID) {

		// get the current session

		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with the primary key

		Query<?> theQuery = currentSession.createQuery("delete from Student where id=:studentID");
		theQuery.setParameter("studentID", studentID);

		// processes HQL
		theQuery.executeUpdate();
	}

}
