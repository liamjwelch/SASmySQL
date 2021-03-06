package com.sas.dao;

import java.util.List;

import com.sas.entity.Result;

public interface ResultDAO {
	
	// create + update
	public void saveResult(Result theResult);

	// read
	public Result getResult(int resultID);

	public List<Result> getResults();

	public List<Result> searchResults(String theSearchName);

	// delete
	public void deleteResult(int resultID);	

}
