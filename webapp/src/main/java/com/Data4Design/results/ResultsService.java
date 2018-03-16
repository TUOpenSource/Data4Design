package com.Data4Design.results;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class ResultsService implements IResultsService {

	
	private IResultService[] iResultServices;
	
	
	public ResultsService(IResultService[] iResultServices) {
		
		this.iResultServices = iResultServices;
	}
	
	public Result [] GetResults(int [] ids) {
		//Needs a Fixin
		return new Result [0] ;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int el : ids ) {
			list.add(el);
		}
		
		ArrayList<IResultService> services = new ArrayList<IResultService>();
		
		for(IResultService el: services) {
			services.add(el);
		}
		
		ArrayList<Result> filtered = new ArrayList<Result>(services.stream().filter(p->list.contains(p.getId())).map(q->q.getResult()).collect(Collectors.toList()));
	
		Result ans [] = new Result[filtered.size()];
		
		return filtered.toArray(ans);
		
	}
}
