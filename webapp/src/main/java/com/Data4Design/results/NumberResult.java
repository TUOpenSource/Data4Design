package com.Data4Design.results;


public class NumberResult extends Result{
	
	private double data;
	private String unit;
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
    
    public String getUnit() {
    	return unit;
    }
    
    public void setUnit(String unit) {
    	this.unit = unit;
    }
	
}
