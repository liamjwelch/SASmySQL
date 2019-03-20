package com.sas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sas.dao.ResultDAO;
import com.sas.entity.Result;

@Service
public class ResultServiceImpl implements ResultService {

	// need to inject the result DAO

	@Autowired
	private ResultDAO resultDAO;

	@Override
	@Transactional
	public void saveResult(Result theResult) {

		resultDAO.saveResult(theResult);

	}

	@Override
	@Transactional
	public Result getResult(int resultID) {

		return resultDAO.getResult(resultID);

	}

	@Override
	@Transactional
	public List<Result> getResults() {

		return resultDAO.getResults();

	}

	@Override
	@Transactional
	public List<Result> searchResults(String theSearchName) {

		return resultDAO.searchResults(theSearchName);

	}

	@Override
	@Transactional
	public void deleteResult(int resultID) {

		resultDAO.deleteResult(resultID);

	}

}
