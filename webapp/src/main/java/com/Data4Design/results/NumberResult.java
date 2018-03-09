package com.Data4Design.results;


public class NumberResult extends Result{
	
	private double data;
	public NumberResult() {
		
	}

	public NumberResult(long input) {
		this.data = (double)input;
	}
	
	public double fetchData() {
		return data;
	}
	
}
