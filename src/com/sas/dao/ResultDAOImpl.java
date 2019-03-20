package com.sas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sas.entity.Result;

@Repository
public class ResultDAOImpl implements ResultDAO {

	// need to inject the sessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveResult(Result theResult) {
		// get the hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// save the result

		currentSession.saveOrUpdate(theResult);

	}

	@Override
	public Result getResult(int resultID) {

		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// retrieve/read data using primaryKey

		Result theResult = currentSession.get(Result.class, resultID);

		return theResult;

	}

	@Override
	public List<Result> getResults() {

		// get the current Hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// create the query

		Query<Result> theQuery = currentSession.createQuery("from Result", Result.class);

		// execute the query and get the resultList

		List<Result> results = theQuery.getResultList();

		// return the resultList

		return results;
	}

	@Override
	public List<Result> searchResults(String theSearchName) {

		// get the current Hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// search for the student with the

		return null;

	}

	@Override
	public void deleteResult(int resultID) {

		// get the current session

		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with the primary key

		Query<?> theQuery = currentSession.createQuery("delete from Result where result_id=:resultID");
		theQuery.setParameter("resultID", resultID);
		
		// process the HQL

		theQuery.executeUpdate();

	}

}
