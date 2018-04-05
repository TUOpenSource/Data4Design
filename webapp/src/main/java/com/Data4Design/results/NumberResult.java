package com.Data4Design.results;


public class NumberResult extends Result{
	
	private double data;
	public NumberResult() {
		
	}

	public NumberResult(long input) {
		this.data = (double)input;
	}

	public NumberResult(double input) {
		this.data = input;
	}
	
	public double getData() {
		return data;
	}

	public String toString() {
        return String.valueOf(this.data);
    }

    public void setData(double input) {
        this.data = input;
    }
	
}
