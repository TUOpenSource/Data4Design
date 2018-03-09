package com.Data4Design.results;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultsService implements IResultsService {

	
	private IResultService[] iResultServices;
	
	public ResultsService(IResultService[] iResultServices) {
		
		this.iResultServices = iResultServices;
	}
	
	public Result [] GetResults(int [] ids) {
		
		ArrayList<String> params = new ArrayList<String>(Arrays.asList(ids));
		

	}
}
