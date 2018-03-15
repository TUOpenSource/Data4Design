package com.Data4Design.results;

public class NumberResultStrategy implements IOutputService {
	
	public String GetOutput(Result result) {
		NumberResult number = (NumberResult) result;
		String ans ="";
		return ans+ number.getData();
	}

}
