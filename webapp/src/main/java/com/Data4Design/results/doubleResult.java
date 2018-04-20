package com.Data4Design.results;

public class doubleResult extends Result{
	    
	    private double data;

	    public doubleResult() {

	    }
	    public doubleResult(double input) {
	        this.data = input;
	    }
	    
	    public double fetchData() {
	        return data;
	    }

	    public void setData(double input) {
	        this.data = input;
	    }
	    
	}

