
package com.Data4Design.results;
public class NumberResultService implements IResultService {

	
	NumberResultService(){
		
	}
	
	public Result getResult(){
		return new NumberResult();
	}
	
	public int getId() {
		return 6;
	}
}