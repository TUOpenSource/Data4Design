package com.Data4Design.results;

public class StringResultService implements IResultService {

	public int getId() {
		return 12;
	}
	
	public Result getResult() {
		
		return  new StringResult();
	}
	
}
